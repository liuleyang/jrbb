/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.tohyoroku;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT204TohyorokuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * {@link Tohyoroku}の編集を行うビルダークラスです。
 */
public class TohyorokuBuilder {

    private final AfT204TohyorokuEntity entity;
    private final TohyorokuIdentifier id;

    /**
     * {@link AfT204TohyorokuEntity}より{@link Tohyoroku}の編集用Builderクラスを生成します。
     *
     * @param entity {@link AfT204TohyorokuEntity}
     * @param id {@link TohyorokuIdentifier}
     *
     */
    TohyorokuBuilder(
            AfT204TohyorokuEntity entity,
            TohyorokuIdentifier id) {
        this.entity = entity.clone();
        this.id = id;
    }

    /**
     * 抄本番号を設定します。
     *
     * @param 抄本番号 抄本番号
     * @return {@link TohyorokuBuilder}
     */
    public TohyorokuBuilder set抄本番号(ShohonNo 抄本番号) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        entity.setShohonNo(抄本番号);
        return this;
    }

    /**
     * 選挙番号を設定します。
     *
     * @param 選挙番号 選挙番号
     * @return {@link TohyorokuBuilder}
     */
    public TohyorokuBuilder set選挙番号(SenkyoNo 選挙番号) {
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙番号"));
        entity.setSenkyoNo(選挙番号);
        return this;
    }

    /**
     * 報告年月日を設定します。
     *
     * @param 報告年月日 報告年月日
     * @return {@link TohyorokuBuilder}
     */
    public TohyorokuBuilder set報告年月日(FlexibleDate 報告年月日) {
        requireNonNull(報告年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("報告年月日"));
        entity.setHokokuYMD(報告年月日);
        return this;
    }

    /**
     * 施設コードを設定します。
     *
     * @param 施設コード 施設コード
     * @return {@link TohyorokuBuilder}
     */
    public TohyorokuBuilder set施設コード(RString 施設コード) {
        requireNonNull(施設コード, UrSystemErrorMessages.値がnull.getReplacedMessage("施設コード"));
        entity.setShisetsuCode(施設コード);
        return this;
    }

    /**
     * 投票区コードを設定します。
     *
     * @param 投票区コード 投票区コード
     * @return {@link TohyorokuBuilder}
     */
    public TohyorokuBuilder set投票区コード(RString 投票区コード) {
        requireNonNull(投票区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区コード"));
        entity.setTohyokuCode(投票区コード);
        return this;
    }

    /**
     * 投票所設置状況を設定します。
     *
     * @param 投票所設置状況 投票所設置状況
     * @return {@link TohyorokuBuilder}
     */
    public TohyorokuBuilder set投票所設置状況(RString 投票所設置状況) {
        requireNonNull(投票所設置状況, UrSystemErrorMessages.値がnull.getReplacedMessage("投票所設置状況"));
        entity.setSecchiJokyo(投票所設置状況);
        return this;
    }

    /**
     * 投票所開設場所を設定します。
     *
     * @param 投票所開設場所 投票所開設場所
     * @return {@link TohyorokuBuilder}
     */
    public TohyorokuBuilder set投票所開設場所(RString 投票所開設場所) {
        requireNonNull(投票所開設場所, UrSystemErrorMessages.値がnull.getReplacedMessage("投票所開設場所"));
        entity.setKaisetsuBasho(投票所開設場所);
        return this;
    }

    /**
     * 設置期間（開始年月日）を設定します。
     *
     * @param 設置期間_開始年月日 設置期間（開始年月日）
     * @return {@link TohyorokuBuilder}
     */
    public TohyorokuBuilder set設置期間_開始年月日(FlexibleDate 設置期間_開始年月日) {
        requireNonNull(設置期間_開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("設置期間（開始年月日）"));
        entity.setSecchiFirstYMD(設置期間_開始年月日);
        return this;
    }

    /**
     * 設置期間（終了年月日）を設定します。
     *
     * @param 設置期間_終了年月日 設置期間（終了年月日）
     * @return {@link TohyorokuBuilder}
     */
    public TohyorokuBuilder set設置期間_終了年月日(FlexibleDate 設置期間_終了年月日) {
        requireNonNull(設置期間_終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("設置期間（終了年月日）"));
        entity.setSecchiLastYMD(設置期間_終了年月日);
        return this;
    }

    /**
     * 開閉時刻（開始）を設定します。
     *
     * @param 開閉時刻_開始 開閉時刻（開始）
     * @return {@link TohyorokuBuilder}
     */
    public TohyorokuBuilder set開閉時刻_開始(RTime 開閉時刻_開始) {
        entity.setKaiheiStartTime(開閉時刻_開始);
        return this;
    }

    /**
     * 開閉時刻（終了）を設定します。
     *
     * @param 開閉時刻_終了 開閉時刻（終了）
     * @return {@link TohyorokuBuilder}
     */
    public TohyorokuBuilder set開閉時刻_終了(RTime 開閉時刻_終了) {
        entity.setKaiheiStopTime(開閉時刻_終了);
        return this;
    }

    /**
     * 選管書記人数を設定します。
     *
     * @param 選管書記人数 選管書記人数
     * @return {@link TohyorokuBuilder}
     */
    public TohyorokuBuilder set選管書記人数(int 選管書記人数) {
        requireNonNull(選管書記人数, UrSystemErrorMessages.値がnull.getReplacedMessage("選管書記人数"));
        entity.setShokiNinzu(選管書記人数);
        return this;
    }

    /**
     * 職員人数を設定します。
     *
     * @param 職員人数 職員人数
     * @return {@link TohyorokuBuilder}
     */
    public TohyorokuBuilder set職員人数(int 職員人数) {
        requireNonNull(職員人数, UrSystemErrorMessages.値がnull.getReplacedMessage("職員人数"));
        entity.setShokuinNinzu(職員人数);
        return this;
    }

    /**
     * その他人数を設定します。
     *
     * @param その他人数 その他人数
     * @return {@link TohyorokuBuilder}
     */
    public TohyorokuBuilder setその他人数(int その他人数) {
        requireNonNull(その他人数, UrSystemErrorMessages.値がnull.getReplacedMessage("その他人数"));
        entity.setSonotaNinzu(その他人数);
        return this;
    }

    /**
     * {@link Tohyoroku}のインスタンスを生成します。
     *
     * @return {@link Tohyoroku}のインスタンス
     */
    public Tohyoroku build() {
        return new Tohyoroku(entity, id);
    }
}
