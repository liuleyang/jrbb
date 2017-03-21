/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.tohyoroku.tohyorokufuzui;

import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT205TohyorokuFuzuiEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * {@link TohyorokuFuzui}の編集を行うビルダークラスです。
 */
public class TohyorokuFuzuiBuilder {

    private final AfT205TohyorokuFuzuiEntity entity;
    private final TohyorokuFuzuiIdentifier id;

    /**
     * {@link AfT205TohyorokuFuzuiEntity}より{@link TohyorokuFuzui}の編集用Builderクラスを生成します。
     *
     * @param entity {@link AfT205TohyorokuFuzuiEntity}
     * @param id {@link TohyorokuFuzuiIdentifier}
     *
     */
    TohyorokuFuzuiBuilder(
            AfT205TohyorokuFuzuiEntity entity,
            TohyorokuFuzuiIdentifier id) {
        this.entity = entity.clone();
        this.id = id;
    }

    /**
     * 抄本番号を設定します。
     *
     * @param 抄本番号 抄本番号
     * @return {@link TohyorokuFuzuiBuilder}
     */
    public TohyorokuFuzuiBuilder set抄本番号(ShohonNo 抄本番号) {
        entity.setShohonNo(抄本番号);
        return this;
    }

    /**
     * 選挙番号を設定します。
     *
     * @param 選挙番号 選挙番号
     * @return {@link TohyorokuFuzuiBuilder}
     */
    public TohyorokuFuzuiBuilder set選挙番号(SenkyoNo 選挙番号) {
        entity.setSenkyoNo(選挙番号);
        return this;
    }

    /**
     * 報告年月日を設定します。
     *
     * @param 報告年月日 報告年月日
     * @return {@link TohyorokuFuzuiBuilder}
     */
    public TohyorokuFuzuiBuilder set報告年月日(FlexibleDate 報告年月日) {
        entity.setHokokuYMD(報告年月日);
        return this;
    }

    /**
     * 施設コードを設定します。
     *
     * @param 施設コード 施設コード
     * @return {@link TohyorokuFuzuiBuilder}
     */
    public TohyorokuFuzuiBuilder set施設コード(RString 施設コード) {
        entity.setShisetsuCode(施設コード);
        return this;
    }

    /**
     * 投票区コードを設定します。
     *
     * @param 投票区コード 投票区コード
     * @return {@link TohyorokuFuzuiBuilder}
     */
    public TohyorokuFuzuiBuilder set投票区コード(RString 投票区コード) {
        entity.setTohyokuCode(投票区コード);
        return this;
    }

    /**
     * 投票録項目種類を設定します。
     *
     * @param 投票録項目種類 投票録項目種類
     * @return {@link TohyorokuFuzuiBuilder}
     */
    public TohyorokuFuzuiBuilder set投票録項目種類(Code 投票録項目種類) {
        entity.setKomokuShurui(投票録項目種類);
        return this;
    }

    /**
     * 連番を設定します。
     *
     * @param 連番 連番
     * @return {@link TohyorokuFuzuiBuilder}
     */
    public TohyorokuFuzuiBuilder set連番(int 連番) {
        entity.setRenban(連番);
        return this;
    }

    /**
     * 党派を設定します。
     *
     * @param 党派 党派
     * @return {@link TohyorokuFuzuiBuilder}
     */
    public TohyorokuFuzuiBuilder set党派(RString 党派) {
        entity.setToha(党派);
        return this;
    }

    /**
     * 氏名を設定します。
     *
     * @param 氏名 氏名
     * @return {@link TohyorokuFuzuiBuilder}
     */
    public TohyorokuFuzuiBuilder set氏名(AtenaMeisho 氏名) {
        entity.setShimei(氏名);
        return this;
    }

    /**
     * 選任年月日を設定します。
     *
     * @param 選任年月日 選任年月日
     * @return {@link TohyorokuFuzuiBuilder}
     */
    public TohyorokuFuzuiBuilder set選任年月日(FlexibleDate 選任年月日) {
        entity.setSennninYMD(選任年月日);
        return this;
    }

    /**
     * 立会時間（開始時刻）を設定します。
     *
     * @param 立会時間_開始時刻 立会時間（開始時刻）
     * @return {@link TohyorokuFuzuiBuilder}
     */
    public TohyorokuFuzuiBuilder set立会時間_開始時刻(RTime 立会時間_開始時刻) {
        entity.setTachiaiStartTime(立会時間_開始時刻);
        return this;
    }

    /**
     * 立会時間（終了時刻）を設定します。
     *
     * @param 立会時間_終了時刻 立会時間（終了時刻）
     * @return {@link TohyorokuFuzuiBuilder}
     */
    public TohyorokuFuzuiBuilder set立会時間_終了時刻(RTime 立会時間_終了時刻) {
        entity.setTachiaiStopTime(立会時間_終了時刻);
        return this;
    }

    /**
     * 参会時刻を設定します。
     *
     * @param 参会時刻 参会時刻
     * @return {@link TohyorokuFuzuiBuilder}
     */
    public TohyorokuFuzuiBuilder set参会時刻(RTime 参会時刻) {
        entity.setSankaiTime(参会時刻);
        return this;
    }

    /**
     * 辞職時刻を設定します。
     *
     * @param 辞職時刻 辞職時刻
     * @return {@link TohyorokuFuzuiBuilder}
     */
    public TohyorokuFuzuiBuilder set辞職時刻(RTime 辞職時刻) {
        entity.setJishokuTime(辞職時刻);
        return this;
    }

    /**
     * 事由を設定します。
     *
     * @param 事由 事由
     * @return {@link TohyorokuFuzuiBuilder}
     */
    public TohyorokuFuzuiBuilder set事由(RString 事由) {
        entity.setJiyu(事由);
        return this;
    }

    /**
     * {@link TohyorokuFuzui}のインスタンスを生成します。
     *
     * @return {@link TohyorokuFuzui}のインスタンス
     */
    public TohyorokuFuzui build() {
        return new TohyorokuFuzui(entity, id);
    }
}
