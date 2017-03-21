/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyoku;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT503SenkyokuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 選挙区を管理するクラスです。
 *
 * @reamsid_L AF-0290-020 lit
 */
public class Senkyoku extends ModelBase<SenkyokuIdentifier, AfT503SenkyokuEntity, Senkyoku> implements Serializable {

    private static final long serialVersionUID = -6967514159611800361L;

    private final AfT503SenkyokuEntity entity;
    private final SenkyokuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 選挙区の新規作成時に使用します。
     *
     * @param 選挙種類 選挙種類
     * @param 選挙区コード 選挙区コード
     */
    public Senkyoku(Code 選挙種類, RString 選挙区コード) {
        requireNonNull(選挙種類, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙種類"));
        requireNonNull(選挙区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙区コード"));
        this.entity = new AfT503SenkyokuEntity();
        this.entity.setSenkyoShurui(選挙種類);
        this.entity.setSenkyokuCode(選挙区コード);
        this.id = new SenkyokuIdentifier(選挙種類, 選挙区コード);
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT503SenkyokuEntity}より{@link Shisetsu}を生成します。
     *
     * @param entity DBより取得した{@link AfT503SenkyokuEntity}
     */
    public Senkyoku(AfT503SenkyokuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙区"));
        this.id = new SenkyokuIdentifier(entity.getSenkyoShurui(), entity.getSenkyokuCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link AfT503SenkyokuEntity}
     * @param id {@link SenkyokuIdentifier}
     */
    Senkyoku(
            AfT503SenkyokuEntity entity,
            SenkyokuIdentifier id) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 選挙種類を返します。
     *
     * @return 選挙種類
     */
    public Code get選挙種類() {
        return entity.getSenkyoShurui();
    }

    /**
     * 選挙区コードを返します。
     *
     * @return 選挙区コード
     */
    public RString get選挙区コード() {
        return entity.getSenkyokuCode();
    }

    /**
     * 選挙区名を返します。
     *
     * @return 選挙区名
     */
    public RString get選挙区名() {
        return entity.getSenkyokuName();
    }

    /**
     * {@link AfT503SenkyokuEntity}のクローンを返します。
     *
     * @return {@link AfT503SenkyokuEntity}のクローン
     */
    @Override
    public AfT503SenkyokuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 選挙区の識別子{@link SenkyokuIdentifier}を返します。
     *
     * @return 選挙区の識別子{@link SenkyokuIdentifier}
     */
    @Override
    public SenkyokuIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する選挙区を削除対象とします。<br/> {@link AfT503SenkyokuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link Senkyoku}
     * @throws IllegalStateException AfT503SenkyokuEntityのデータ状態が変更の場合
     */
    @Override
    public Senkyoku deleted() {
        AfT503SenkyokuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new Senkyoku(deletedEntity, id);
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 7402213614486601766L;
        private final AfT503SenkyokuEntity entity;
        private final SenkyokuIdentifier id;

        private _SerializationProxy(AfT503SenkyokuEntity entity, SenkyokuIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new Senkyoku(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SenkyokuBuilder.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public SenkyokuBuilder createBuilderForEdit() {
        return new SenkyokuBuilder(entity, id);
    }

}
