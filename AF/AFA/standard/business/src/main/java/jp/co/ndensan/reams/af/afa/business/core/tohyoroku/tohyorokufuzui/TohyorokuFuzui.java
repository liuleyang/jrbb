/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.tohyoroku.tohyorokufuzui;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT205TohyorokuFuzuiEntity;
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
 * 投票録付随を管理するクラスです。
 */
public class TohyorokuFuzui extends ModelBase<TohyorokuFuzuiIdentifier, AfT205TohyorokuFuzuiEntity, TohyorokuFuzui> implements Serializable {

    private static final long serialVersionUID = -6967514159611800361L;

    private final AfT205TohyorokuFuzuiEntity entity;
    private final TohyorokuFuzuiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 投票録付随の新規作成時に使用します。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙番号 選挙番号
     * @param 報告年月日 報告年月日
     * @param 施設コード 施設コード
     * @param 投票区コード 投票区コード
     * @param 投票録項目種類 投票録項目種類
     * @param 連番 連番
     */
    public TohyorokuFuzui(ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            RString 施設コード,
            RString 投票区コード,
            Code 投票録項目種類,
            int 連番) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙番号"));
        requireNonNull(報告年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("報告年月日"));
        requireNonNull(施設コード, UrSystemErrorMessages.値がnull.getReplacedMessage("施設コード"));
        requireNonNull(投票区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区コード"));
        requireNonNull(投票録項目種類, UrSystemErrorMessages.値がnull.getReplacedMessage("投票録項目種類"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        this.entity = new AfT205TohyorokuFuzuiEntity();
        this.entity.setShohonNo(抄本番号);
        this.entity.setSenkyoNo(選挙番号);
        this.entity.setHokokuYMD(報告年月日);
        this.entity.setShisetsuCode(施設コード);
        this.entity.setTohyokuCode(投票区コード);
        this.entity.setKomokuShurui(投票録項目種類);
        this.entity.setRenban(連番);
        this.id = new TohyorokuFuzuiIdentifier(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード, 投票録項目種類, 連番);
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT205TohyorokuFuzuiEntity}より{@link TohyorokuFuzui}を生成します。
     *
     * @param entity DBより取得した{@link AfT205TohyorokuFuzuiEntity}
     */
    public TohyorokuFuzui(AfT205TohyorokuFuzuiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("投票録付随"));
        this.id = new TohyorokuFuzuiIdentifier(
                entity.getShohonNo(),
                entity.getSenkyoNo(),
                entity.getHokokuYMD(),
                entity.getShisetsuCode(),
                entity.getTohyokuCode(),
                entity.getKomokuShurui(),
                entity.getRenban());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link AfT205TohyorokuFuzuiEntity}
     * @param id {@link TohyorokuFuzuiIdentifier}
     */
    TohyorokuFuzui(
            AfT205TohyorokuFuzuiEntity entity,
            TohyorokuFuzuiIdentifier id) {
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
     * 党派を返します。
     *
     * @return 党派
     */
    public RString get党派() {
        return entity.getToha();
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
     * 選任年月日を返します。
     *
     * @return 選任年月日
     */
    public FlexibleDate get選任年月日() {
        return entity.getSennninYMD();
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
     * 参会時刻を返します。
     *
     * @return 参会時刻
     */
    public RTime get参会時刻() {
        return entity.getSankaiTime();
    }

    /**
     * 辞職時刻を返します。
     *
     * @return 辞職時刻
     */
    public RTime get辞職時刻() {
        return entity.getJishokuTime();
    }

    /**
     * 事由を返します。
     *
     * @return 事由
     */
    public RString get事由() {
        return entity.getJiyu();
    }

    /**
     * {@link AfT205TohyorokuFuzuiEntity}のクローンを返します。
     *
     * @return {@link AfT205TohyorokuFuzuiEntity}のクローン
     */
    @Override
    public AfT205TohyorokuFuzuiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 投票録付随の識別子{@link TohyorokuFuzuiIdentifier}を返します。
     *
     * @return 選挙の識別子{@link TohyorokuFuzuiIdentifier}
     */
    @Override
    public TohyorokuFuzuiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する投票録付随を削除対象とします。<br/> {@link AfT205TohyorokuFuzuiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link TohyorokuFuzui}
     * @throws IllegalStateException AfT205TohyorokuFuzuiEntityのデータ状態が変更の場合
     */
    @Override
    public TohyorokuFuzui deleted() {
        AfT205TohyorokuFuzuiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new TohyorokuFuzui(deletedEntity, id);
    }

    /**
     * {@link TohyorokuFuzui}のシリアライズ形式を提供します。
     *
     * @return {@link TohyorokuFuzui}のシリアライズ形式
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
        private final AfT205TohyorokuFuzuiEntity entity;
        private final TohyorokuFuzuiIdentifier id;

        private _SerializationProxy(AfT205TohyorokuFuzuiEntity entity, TohyorokuFuzuiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new TohyorokuFuzui(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link TohyorokuFuzuiBuilder.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public TohyorokuFuzuiBuilder createBuilderForEdit() {
        return new TohyorokuFuzuiBuilder(entity, id);
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link TohyorokuFuzuiBuilder.createBuilderForAddEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public TohyorokuFuzuiBuilder createBuilderForAddEdit() {
        entity.setState(EntityDataState.Added);
        return new TohyorokuFuzuiBuilder(entity, id);
    }

}
