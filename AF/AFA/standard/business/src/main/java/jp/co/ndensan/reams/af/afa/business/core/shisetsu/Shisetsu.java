/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.shisetsu;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT507ShisetsuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 施設を管理するクラスです。
 */
public class Shisetsu extends ModelBase<ShisetsuIdentifier, AfT507ShisetsuEntity, Shisetsu> implements Serializable {

    private static final long serialVersionUID = -6967514159611800361L;

    private final AfT507ShisetsuEntity entity;
    private final ShisetsuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 施設の新規作成時に使用します。
     *
     * @param 施設コード 施設コード
     */
    public Shisetsu(RString 施設コード) {
        requireNonNull(施設コード, UrSystemErrorMessages.値がnull.getReplacedMessage("施設コード"));
        this.entity = new AfT507ShisetsuEntity();
        this.entity.setShisetsuCode(施設コード);
        this.id = new ShisetsuIdentifier(施設コード);
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT507ShisetsuEntity}より{@link Shisetsu}を生成します。
     *
     * @param entity DBより取得した{@link AfT507ShisetsuEntity}
     */
    public Shisetsu(AfT507ShisetsuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("施設"));
        this.id = new ShisetsuIdentifier(entity.getShisetsuCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link AfT507ShisetsuEntity}
     * @param id {@link ShisetsuIdentifier}
     */
    Shisetsu(
            AfT507ShisetsuEntity entity,
            ShisetsuIdentifier id) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 施設コードを返します。
     *
     * @return 施設コード
     */
    public RString get施設コード() {
        return entity.getShisetsuCode();
    }

    /**
     * 施設種別を返します。
     *
     * @return 施設種別
     */
    public Code get施設種別() {
        return entity.getShisetsuShubetsu();
    }

    /**
     * 施設名称を返します。
     *
     * @return 施設名称
     */
    public RString get施設名称() {
        return entity.getShisetsuName();
    }

    /**
     * カナ施設名称を返します。
     *
     * @return カナ施設名称
     */
    public RString getカナ施設名称() {
        return entity.getKanaShisetsuName();
    }

    /**
     * 検索用カナ施設名称を返します。
     *
     * @return 検索用カナ施設名称
     */
    public RString get検索用カナ施設名称() {
        return entity.getSearchKanaShisetsuName();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return entity.getYubinNo();
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return entity.getJusho();
    }

    /**
     * 施設宛名を返します。
     *
     * @return 施設宛名
     */
    public AtenaMeisho get施設宛名() {
        return entity.getShisetsuAtena();
    }

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return entity.getTelNo();
    }

    /**
     * FAX番号を返します。
     *
     * @return FAX番号
     */
    public TelNo getFAX番号() {
        return entity.getFaxNo();
    }

    /**
     * {@link AfT507ShisetsuEntity}のクローンを返します。
     *
     * @return {@link AfT507ShisetsuEntity}のクローン
     */
    @Override
    public AfT507ShisetsuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 施設の識別子{@link ShisetsuIdentifier}を返します。
     *
     * @return 選挙の識別子{@link ShisetsuIdentifier}
     */
    @Override
    public ShisetsuIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する施設を削除対象とします。<br/> {@link AfT507ShisetsuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link Shisetsu}
     * @throws IllegalStateException AfT507ShisetsuEntityのデータ状態が変更の場合
     */
    @Override
    public Shisetsu deleted() {
        AfT507ShisetsuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new Shisetsu(deletedEntity, id);
    }

    /**
     * {@link Shisetsu}のシリアライズ形式を提供します。
     *
     * @return {@link Shisetsu}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 7402213614486601766L;
        private final AfT507ShisetsuEntity entity;
        private final ShisetsuIdentifier id;

        private _SerializationProxy(AfT507ShisetsuEntity entity, ShisetsuIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new Shisetsu(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link ShisetsuBuilder.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShisetsuBuilder createBuilderForEdit() {
        return new ShisetsuBuilder(entity, id);
    }

}
