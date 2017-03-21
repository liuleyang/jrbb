/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 選挙を管理するクラスです。
 */
public class Senkyo extends ModelBase<SenkyoIdentifier, AfT111SenkyoEntity, Senkyo> implements Serializable {

    private static final long serialVersionUID = -6967514159611800361L;

    private final AfT111SenkyoEntity entity;
    private final SenkyoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 選挙の新規作成時に使用します。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙番号 選挙番号
     */
    public Senkyo(ShohonNo 抄本番号, SenkyoNo 選挙番号) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙番号"));
        this.entity = new AfT111SenkyoEntity();
        this.entity.setShohonNo(抄本番号);
        this.entity.setSenkyoNo(選挙番号);
        this.id = new SenkyoIdentifier(抄本番号, 選挙番号);
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT111SenkyoEntity}より{@link Senkyo}を生成します。
     *
     * @param entity DBより取得した{@link AfT111SenkyoEntity}
     */
    public Senkyo(AfT111SenkyoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙"));
        this.id = new SenkyoIdentifier(
                entity.getShohonNo(),
                entity.getSenkyoNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link AfT111SenkyoEntity}
     * @param id {@link SenkyoIdentifier}
     */
    Senkyo(
            AfT111SenkyoEntity entity,
            SenkyoIdentifier id) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 抄本番号を返します。
     *
     * @return 抄本番号
     */
    public ShohonNo get抄本番号() {
        return entity.getShohonNo();
    }

    /**
     * 選挙番号を返します。
     *
     * @return 選挙番号
     */
    public SenkyoNo get選挙番号() {
        return entity.getSenkyoNo();
    }

    /**
     * 選挙レベルを返します。
     *
     * @return 選挙レベル
     */
    public Code get選挙レベル() {
        return entity.getSenkyoLevel();
    }

    /**
     * 選挙名称を返します。
     *
     * @return 選挙名称
     */
    public RString get選挙名称() {
        return entity.getSenkyoName();
    }

    /**
     * 選挙略称を返します。
     *
     * @return 選挙略称
     */
    public RString get選挙略称() {
        return entity.getSenkyoRyakusho();
    }

    /**
     * 選挙マークを返します。
     *
     * @return 選挙マーク
     */
    public RString get選挙マーク() {
        return entity.getSenkyoMark();
    }

    /**
     * 名簿基準年月日を返します。
     *
     * @return 名簿基準年月日
     */
    public FlexibleDate get名簿基準年月日() {
        return entity.getKijunYMD();
    }

    /**
     * 名簿登録年月日を返します。
     *
     * @return 名簿登録年月日
     */
    public FlexibleDate get名簿登録年月日() {
        return entity.getMeiboTorokuYMD();
    }

    /**
     * 告示（公示）年月日を返します。
     *
     * @return 告示（公示）年月日
     */
    public FlexibleDate get告示_公示年月日() {
        return entity.getKokujiYMD();
    }

    /**
     * 転出期限年月日を返します。
     *
     * @return 転出期限年月日
     */
    public FlexibleDate get転出期限年月日() {
        return entity.getTenshutsuKigenYMD();
    }

    /**
     * 転入期限年月日を返します。
     *
     * @return 転入期限年月日
     */
    public FlexibleDate get転入期限年月日() {
        return entity.getTennyuKigenYMD();
    }

    /**
     * 投票受付開始年月日を返します。
     *
     * @return 投票受付開始年月日
     */
    public FlexibleDate get投票受付開始年月日() {
        return entity.getTohyoUketsukeYMD();
    }

    /**
     * 無投票選挙フラグを返します。
     *
     * @return 無投票選挙フラグ
     */
    public boolean is無投票選挙フラグ() {
        return entity.getMutohyoSenkyoFlag();
    }

    /**
     * {@link AfT111SenkyoEntity}のクローンを返します。
     *
     * @return {@link AfT111SenkyoEntity}のクローン
     */
    @Override
    public AfT111SenkyoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 選挙の識別子{@link SenkyoIdentifier}を返します。
     *
     * @return 選挙の識別子{@link SenkyoIdentifier}
     */
    @Override
    public SenkyoIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する選挙を削除対象とします。<br/> {@link AfT111SenkyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link Senkyo}
     * @throws IllegalStateException AfT111SenkyoEntityのデータ状態が変更の場合
     */
    @Override
    public Senkyo deleted() {
        AfT111SenkyoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new Senkyo(deletedEntity, id);
    }

    /**
     * {@link Senkyo}のシリアライズ形式を提供します。
     *
     * @return {@link Senkyo}のシリアライズ形式
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
        private final AfT111SenkyoEntity entity;
        private final SenkyoIdentifier id;

        private _SerializationProxy(AfT111SenkyoEntity entity, SenkyoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new Senkyo(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public SenkyoBuilder createBuilderForEdit() {
        return new SenkyoBuilder(entity, id);
    }

}
