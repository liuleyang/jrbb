/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.tohyoyoshimaisukanri;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT251TohyoYoshiMaisuKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 投票用紙枚数管理情報です。
 *
 * @reamsid_L AF-0280-036 lit
 */
public class TohyoYoshiMaisuKanri extends ModelBase<TohyoYoshiMaisuKanriIdentifier, AfT251TohyoYoshiMaisuKanriEntity, TohyoYoshiMaisuKanri>
        implements Serializable {

    private static final long serialVersionUID = -6967514159611800361L;

    private final AfT251TohyoYoshiMaisuKanriEntity entity;
    private final TohyoYoshiMaisuKanriIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 投票区の新規作成時に使用します。
     *
     * @param 抄本番号 ShohonNo
     * @param 選挙番号 SenkyoNo
     * @param 投票区コード RString
     */
    public TohyoYoshiMaisuKanri(ShohonNo 抄本番号, SenkyoNo 選挙番号, RString 投票区コード) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙番号"));
        requireNonNull(投票区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区コード"));
        this.entity = new AfT251TohyoYoshiMaisuKanriEntity();
        this.entity.setShohonNo(抄本番号);
        this.entity.setSenkyoNo(選挙番号);
        this.entity.setTohyokuCode(投票区コード);
        this.id = new TohyoYoshiMaisuKanriIdentifier(抄本番号, 選挙番号, 投票区コード);
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT251TohyoYoshiMaisuKanriEntity}より{@link Shisetsu}を生成します。
     *
     * @param entity DBより取得した{@link AfT251TohyoYoshiMaisuKanriEntity}
     */
    public TohyoYoshiMaisuKanri(AfT251TohyoYoshiMaisuKanriEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("投票用紙枚数管理"));
        this.id = new TohyoYoshiMaisuKanriIdentifier(entity.getShohonNo(), entity.getSenkyoNo(), entity.getTohyokuCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link AfT251TohyoYoshiMaisuKanriEntity}
     * @param id {@link TohyoYoshiMaisuKanriIdentifier}
     */
    TohyoYoshiMaisuKanri(
            AfT251TohyoYoshiMaisuKanriEntity entity,
            TohyoYoshiMaisuKanriIdentifier id) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * shohonNoのgetメソッドです。
     *
     * @return shohonNo
     */
    public ShohonNo getShohonNo() {
        return entity.getShohonNo();
    }

    /**
     * senkyoNoのgetメソッドです。
     *
     * @return senkyoNo
     */
    public SenkyoNo getSenkyoNo() {
        return entity.getSenkyoNo();
    }

    /**
     * tohyokuCodeのgetメソッドです。
     *
     * @return tohyokuCode
     */
    public RString getTohyokuCode() {
        return entity.getTohyokuCode();
    }

    /**
     * tenjiYoshiMaisuのgetメソッドです。
     *
     * @return tenjiYoshiMaisu
     */
    public int getTenjiYoshiMaisu() {
        return entity.getTenjiYoshiMaisu();
    }

    /**
     * tohyoYoshiMaisuのgetメソッドです。
     *
     * @return tohyoYoshiMaisu
     */
    public int getTohyoYoshiMaisu() {
        return entity.getTohyoYoshiMaisu();
    }

    /**
     * kariFutoMaisuのgetメソッドです。
     *
     * @return kariFutoMaisu
     */
    public int getKariFutoMaisu() {
        return entity.getKariFutoMaisu();
    }

    /**
     * {@link AfT251TohyoYoshiMaisuKanriEntity}のクローンを返します。
     *
     * @return {@link AfT251TohyoYoshiMaisuKanriEntity}のクローン
     */
    @Override
    public AfT251TohyoYoshiMaisuKanriEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 投票用紙枚数管理の識別子{@link TohyoYoshiMaisuKanriIdentifier}を返します。
     *
     * @return 投票区の識別子{@link TohyoYoshiMaisuKanriIdentifier}
     */
    @Override
    public TohyoYoshiMaisuKanriIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する投票区を削除対象とします。<br/>
     * {@link AfT251TohyoYoshiMaisuKanriEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link TohyoYoshiMaisuKanri}
     * @throws IllegalStateException AfT251TohyoYoshiMaisuKanriEntityのデータ状態が変更の場合
     */
    @Override
    public TohyoYoshiMaisuKanri deleted() {
        AfT251TohyoYoshiMaisuKanriEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new TohyoYoshiMaisuKanri(deletedEntity, id);
    }

    /**
     * {@link TohyoYoshiMaisuKanri}のシリアライズ形式を提供します。
     *
     * @return {@link TohyoYoshiMaisuKanri}のシリアライズ形式
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
        private final AfT251TohyoYoshiMaisuKanriEntity entity;
        private final TohyoYoshiMaisuKanriIdentifier id;

        private _SerializationProxy(AfT251TohyoYoshiMaisuKanriEntity entity, TohyoYoshiMaisuKanriIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new TohyoYoshiMaisuKanri(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link TohyoYoshiMaisuKanriBuilder.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public TohyoYoshiMaisuKanriBuilder createBuilderForEdit() {
        return new TohyoYoshiMaisuKanriBuilder(entity, id);
    }

}
