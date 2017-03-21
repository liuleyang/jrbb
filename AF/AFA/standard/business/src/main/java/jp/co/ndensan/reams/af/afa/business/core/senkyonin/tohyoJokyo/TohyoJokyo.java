/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 投票状況を管理するクラスです。
 */
public class TohyoJokyo extends ModelBase<TohyoJokyoIdentifier, AfT201TohyoJokyoEntity, TohyoJokyo> implements Serializable {

    private final AfT201TohyoJokyoEntity entity;
    private final TohyoJokyoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 投票状況の新規作成時に使用します。
     *
     * @param 抄本番号 抄本番号
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     */
    public TohyoJokyo(ShohonNo 抄本番号,
            ShikibetsuCode 識別コード,
            SenkyoNo 選挙番号) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙番号"));
        this.entity = new AfT201TohyoJokyoEntity();
        this.entity.setShohonNo(抄本番号);
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setSenkyoNo(選挙番号);
        this.id = new TohyoJokyoIdentifier(
                抄本番号,
                識別コード,
                選挙番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT201TohyoJokyoEntity}より{@link TohyoJokyo}を生成します。
     *
     * @param entity DBより取得した{@link AfT201TohyoJokyoEntity}
     */
    public TohyoJokyo(AfT201TohyoJokyoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("投票状況"));
        this.id = new TohyoJokyoIdentifier(
                entity.getShohonNo(),
                entity.getShikibetsuCode(),
                entity.getSenkyoNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link AfT201TohyoJokyoEntity}
     * @param id {@link TohyoJokyoIdentifier}
     */
    TohyoJokyo(
            AfT201TohyoJokyoEntity entity,
            TohyoJokyoIdentifier id
    ) {
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
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
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
     * 投票状況を返します。
     *
     * @return 投票状況
     */
    public Code get投票状況() {
        return entity.getTohyoJokyo();
    }

    /**
     * 投票事由コードを返します。
     *
     * @return 投票事由コード
     */
    public Code get投票事由コード() {
        return entity.getTohyoJiyuCode();
    }

    /**
     * 請求年月日を返します。
     *
     * @return 請求年月日
     */
    public FlexibleDate get請求年月日() {
        return entity.getSeikyuYMD();
    }

    /**
     * 請求方法を返します。
     *
     * @return 請求方法
     */
    public Code get請求方法() {
        return entity.getSeikyuHoho();
    }

    /**
     * 受付番号を返します。
     *
     * @return 受付番号
     */
    public Integer get受付番号() {
        return entity.getUketsukeNo();
    }

    /**
     * 交付年月日を返します。
     *
     * @return 交付年月日
     */
    public FlexibleDate get交付年月日() {
        return entity.getKofuYMD();
    }

    /**
     * 交付時刻を返します。
     *
     * @return 交付時刻
     */
    public RTime get交付時刻() {
        return entity.getKofuTime();
    }

    /**
     * 交付方法を返します。
     *
     * @return 交付方法
     */
    public Code get交付方法() {
        return entity.getKofuHoho();
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
     * 受取年月日を返します。
     *
     * @return 受取年月日
     */
    public FlexibleDate get受取年月日() {
        return entity.getUketoriYMD();
    }

    /**
     * 受理年月日を返します。
     *
     * @return 受理年月日
     */
    public FlexibleDate get受理年月日() {
        return entity.getJuriYMD();
    }

    /**
     * 受理時刻を返します。
     *
     * @return 受理時刻
     */
    public RTime get受理時刻() {
        return entity.getJuriTime();
    }

    /**
     * 受理方法を返します。
     *
     * @return 受理方法
     */
    public Code get受理方法() {
        return entity.getJuriHoho();
    }

    /**
     * 受理施設種別を返します。
     *
     * @return 受理施設種別
     */
    public Code get受理施設種別() {
        return entity.getJuriShisetsuShubetsu();
    }

    /**
     * 棄権年月日を返します。
     *
     * @return 棄権年月日
     */
    public FlexibleDate get棄権年月日() {
        return entity.getKikenYMD();
    }

    /**
     * 返還年月日を返します。
     *
     * @return 返還年月日
     */
    public FlexibleDate get返還年月日() {
        return entity.getHenkanYMD();
    }

    /**
     * 点字フラグを返します。
     *
     * @return 点字フラグ
     */
    public boolean is点字フラグ() {
        return entity.getTenjiFlag();
    }

    /**
     * 代理投票有フラグを返します。
     *
     * @return 代理投票有フラグ
     */
    public boolean is代理投票有フラグ() {
        return entity.getDairiTohyoAriFlag();
    }

    /**
     * 補助者識別コード1を返します。
     *
     * @return 補助者識別コード1
     */
    public ShikibetsuCode get補助者識別コード1() {
        return entity.getHojoshaShikibetsuCode1();
    }

    /**
     * 補助者氏名1を返します。
     *
     * @return 補助者氏名1
     */
    public AtenaMeisho get補助者氏名1() {
        return entity.getHojoshaShimei1();
    }

    /**
     * 補助者識別コード2を返します。
     *
     * @return 補助者識別コード2
     */
    public ShikibetsuCode get補助者識別コード2() {
        return entity.getHojoshaShikibetsuCode2();
    }

    /**
     * 補助者氏名2を返します。
     *
     * @return 補助者氏名2
     */
    public AtenaMeisho get補助者氏名2() {
        return entity.getHojoshaShimei2();
    }

    /**
     * 拒否事由を返します。
     *
     * @return 拒否事由
     */
    public RString get拒否事由() {
        return entity.getKyohiJiyu();
    }

    /**
     * 証明書出力フラグを返します。
     *
     * @return 証明書出力フラグ
     */
    public boolean is証明書出力フラグ() {
        return entity.getShomeishoPrintFlag();
    }

    /**
     * 送致済フラグを返します。
     *
     * @return 送致済フラグ
     */
    public boolean is送致済フラグ() {
        return entity.getSochiZumiFlag();
    }

    /**
     * {@link AfT201TohyoJokyoEntity}のクローンを返します。
     *
     * @return {@link AfT201TohyoJokyoEntity}のクローン
     */
    @Override
    public AfT201TohyoJokyoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 投票状況の識別子{@link TohyoJokyoIdentifier}を返します。
     *
     * @return 投票状況の識別子{@link TohyoJokyoIdentifier}
     */
    @Override
    public TohyoJokyoIdentifier identifier() {
        return this.id;
    }

    // <editor-fold defaultstate="collapsed" desc="無しの場合">
    /**
     * 保持する投票状況を削除対象とします。<br/> {@link AfT201TohyoJokyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link TohyoJokyo}
     * @throws IllegalStateException AfT201TohyoJokyoEntityのデータ状態が変更の場合
     */
    @Override
    public TohyoJokyo deleted() {
        AfT201TohyoJokyoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new TohyoJokyo(deletedEntity, id);
    }

    /**
     * {@link TohyoJokyo}のシリアライズ形式を提供します。
     *
     * @return {@link TohyoJokyo}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -3643883536402292658L;

        private final AfT201TohyoJokyoEntity entity;
        private final TohyoJokyoIdentifier id;

        private _SerializationProxy(AfT201TohyoJokyoEntity entity, TohyoJokyoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new TohyoJokyo(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public TohyoJokyoBuilder createBuilderForEdit() {
        return new TohyoJokyoBuilder(entity, id);
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @param entityRString RString
     * @param 抄本番号 ShohonNo
     * @param 識別コード ShikibetsuCode
     * @param 選挙番号 SenkyoNo
     * @return Builder
     */
    public static TohyoJokyoBuilder createBuilderForEdit(RString entityRString, ShohonNo 抄本番号, ShikibetsuCode 識別コード, SenkyoNo 選挙番号) {
        TohyoJokyo tohyoJokyo;
        if (RString.isNullOrEmpty(entityRString)) {
            tohyoJokyo = new TohyoJokyo(抄本番号, 識別コード, 選挙番号);
            tohyoJokyo.entity.setState(EntityDataState.Added);
        } else {
            AfT201TohyoJokyoEntity entity = DataPassingConverter.deserialize(entityRString, AfT201TohyoJokyoEntity.class);
            entity.setState(EntityDataState.Modified);
            tohyoJokyo = new TohyoJokyo(entity);
        }

        return tohyoJokyo.createBuilderForEdit();
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @param entityRString RString
     * @param 抄本番号 ShohonNo
     * @param 識別コード ShikibetsuCode
     * @param 選挙番号 SenkyoNo
     * @return Builder
     */
    public static TohyoJokyoBuilder createBuilderForDelete(RString entityRString, ShohonNo 抄本番号, ShikibetsuCode 識別コード, SenkyoNo 選挙番号) {
        TohyoJokyo tohyoJokyo;
        if (RString.isNullOrEmpty(entityRString)) {
            tohyoJokyo = new TohyoJokyo(抄本番号, 識別コード, 選挙番号);
            tohyoJokyo.entity.setState(EntityDataState.Deleted);
        } else {
            AfT201TohyoJokyoEntity entity = DataPassingConverter.deserialize(entityRString, AfT201TohyoJokyoEntity.class);
            entity.setState(EntityDataState.Deleted);
            tohyoJokyo = new TohyoJokyo(entity);
        }

        return tohyoJokyo.createBuilderForEdit();
    }
}
