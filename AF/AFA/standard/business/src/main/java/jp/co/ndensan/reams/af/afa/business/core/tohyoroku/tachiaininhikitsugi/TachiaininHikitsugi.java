/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.tohyoroku.tachiaininhikitsugi;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT206TachiaininHikitsugiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 立会人引継を管理するクラスです。
 */
public class TachiaininHikitsugi extends ModelBase<TachiaininHikitsugiIdentifier, AfT206TachiaininHikitsugiJohoEntity, TachiaininHikitsugi>
        implements Serializable {

    private static final long serialVersionUID = -6967514159611800361L;

    private final AfT206TachiaininHikitsugiJohoEntity entity;
    private final TachiaininHikitsugiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 投票録付随の新規作成時に使用します。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙番号 選挙番号
     * @param 報告年月日 報告年月日
     * @param 施設コード 施設コード
     * @param 投票区コード 投票区コード
     * @param 立会人連番 立会人連番
     * @param 投票録項目種類 投票録項目種類
     * @param 連番 連番
     */
    public TachiaininHikitsugi(ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            RString 施設コード,
            RString 投票区コード,
            int 立会人連番,
            Code 投票録項目種類,
            int 連番) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙番号"));
        requireNonNull(報告年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("報告年月日"));
        requireNonNull(施設コード, UrSystemErrorMessages.値がnull.getReplacedMessage("施設コード"));
        requireNonNull(投票区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区コード"));
        requireNonNull(立会人連番, UrSystemErrorMessages.値がnull.getReplacedMessage("立会人連番"));
        requireNonNull(投票録項目種類, UrSystemErrorMessages.値がnull.getReplacedMessage("投票録項目種類"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        this.entity = new AfT206TachiaininHikitsugiJohoEntity();
        this.entity.setShohonNo(抄本番号);
        this.entity.setSenkyoNo(選挙番号);
        this.entity.setHokokuYMD(報告年月日);
        this.entity.setShisetsuCode(施設コード);
        this.entity.setTohyokuCode(投票区コード);
        this.entity.setTachiaininRenban(立会人連番);
        this.entity.setKomokuShurui(投票録項目種類);
        this.entity.setRenban(連番);
        this.id = new TachiaininHikitsugiIdentifier(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード, 立会人連番, 投票録項目種類, 連番);
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT206TachiaininHikitsugiJohoEntity}より{@link TachiaininHikitsugi}を生成します。
     *
     * @param entity DBより取得した{@link AfT206TachiaininHikitsugiJohoEntity}
     */
    public TachiaininHikitsugi(AfT206TachiaininHikitsugiJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("立会人引継"));
        this.id = new TachiaininHikitsugiIdentifier(
                entity.getShohonNo(),
                entity.getSenkyoNo(),
                entity.getHokokuYMD(),
                entity.getShisetsuCode(),
                entity.getTohyokuCode(),
                entity.getTachiaininRenban(),
                entity.getKomokuShurui(),
                entity.getRenban());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link AfT206TachiaininHikitsugiJohoEntity}
     * @param id {@link TachiaininHikitsugiIdentifier}
     */
    TachiaininHikitsugi(
            AfT206TachiaininHikitsugiJohoEntity entity,
            TachiaininHikitsugiIdentifier id) {
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
     * 報告年月日を返します。
     *
     * @return 選挙レベル
     */
    public FlexibleDate get報告年月日() {
        return entity.getHokokuYMD();
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
     * 投票区コードを返します。
     *
     * @return 投票区コード
     */
    public RString get投票区コード() {
        return entity.getTohyokuCode();
    }

    /**
     * 立会人連番を返します。
     *
     * @return 立会人連番
     */
    public int get立会人連番() {
        return entity.getTachiaininRenban();
    }

    /**
     * 投票録項目種類を返します。
     *
     * @return 投票録項目種類
     */
    public Code get投票録項目種類() {
        return entity.getKomokuShurui();
    }

    /**
     * 連番を返します。
     *
     * @return 連番
     */
    public int get連番() {
        return entity.getRenban();
    }

    /**
     * 氏名を返します。
     *
     * @return 氏名
     */
    public AtenaMeisho get氏名() {
        return entity.getShimei();
    }

    /**
     * 党派を返します。
     *
     * @return 党派
     */
    public RString get党派() {
        return entity.getToha();
    }

    /**
     * 立会時間（開始時刻）を返します。
     *
     * @return 立会時間（開始時刻）
     */
    public RTime get立会時間_開始時刻() {
        return entity.getTachiaiStartTime();
    }

    /**
     * 立会時間（終了時刻）を返します。
     *
     * @return 立会時間（終了時刻）
     */
    public RTime get立会時間_終了時刻() {
        return entity.getTachiaiStopTime();
    }

    /**
     * 異常有フラグを返します。
     *
     * @return 異常有フラグ
     */
    public boolean is異常有フラグ() {
        return entity.getIjoAriFlag();
    }

    /**
     * 異常内容を返します。
     *
     * @return 異常内容
     */
    public RString get異常内容() {
        return entity.getIjoNaiyo();
    }

    /**
     * {@link AfT206TachiaininHikitsugiJohoEntity}のクローンを返します。
     *
     * @return {@link AfT206TachiaininHikitsugiJohoEntity}のクローン
     */
    @Override
    public AfT206TachiaininHikitsugiJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 投票録付随の識別子{@link TachiaininHikitsugiIdentifier}を返します。
     *
     * @return 選挙の識別子{@link TachiaininHikitsugiIdentifier}
     */
    @Override
    public TachiaininHikitsugiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する立会人引継を削除対象とします。<br/>
     * {@link AfT206TachiaininHikitsugiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link TachiaininHikitsugi}
     * @throws IllegalStateException AfT206TachiaininHikitsugiJohoEntityのデータ状態が変更の場合
     */
    @Override
    public TachiaininHikitsugi deleted() {
        AfT206TachiaininHikitsugiJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new TachiaininHikitsugi(deletedEntity, id);
    }

    /**
     * {@link TachiaininHikitsugi}のシリアライズ形式を提供します。
     *
     * @return {@link TachiaininHikitsugi}のシリアライズ形式
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
        private final AfT206TachiaininHikitsugiJohoEntity entity;
        private final TachiaininHikitsugiIdentifier id;

        private _SerializationProxy(AfT206TachiaininHikitsugiJohoEntity entity, TachiaininHikitsugiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new TachiaininHikitsugi(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link TachiaininHikitsugiBuilder.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public TachiaininHikitsugiBuilder createBuilderForEdit() {
        return new TachiaininHikitsugiBuilder(entity, id);
    }

}
