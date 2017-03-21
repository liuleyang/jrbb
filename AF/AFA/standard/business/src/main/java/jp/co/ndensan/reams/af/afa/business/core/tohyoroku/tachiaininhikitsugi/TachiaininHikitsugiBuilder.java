/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.tohyoroku.tachiaininhikitsugi;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT206TachiaininHikitsugiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * {@link TachiaininHikitsugi}の編集を行うビルダークラスです。
 */
public class TachiaininHikitsugiBuilder {

    private final AfT206TachiaininHikitsugiJohoEntity entity;
    private final TachiaininHikitsugiIdentifier id;

    /**
     * {@link AfT206TachiaininHikitsugiJohoEntity}より{@link TachiaininHikitsugi}の編集用Builderクラスを生成します。
     *
     * @param entity {@link AfT206TachiaininHikitsugiJohoEntity}
     * @param id {@link TachiaininHikitsugiIdentifier}
     *
     */
    TachiaininHikitsugiBuilder(
            AfT206TachiaininHikitsugiJohoEntity entity,
            TachiaininHikitsugiIdentifier id) {
        this.entity = entity.clone();
        this.id = id;
    }

    /**
     * 抄本番号を設定します。
     *
     * @param 抄本番号 抄本番号
     * @return {@link TachiaininHikitsugiBuilder}
     */
    public TachiaininHikitsugiBuilder set抄本番号(ShohonNo 抄本番号) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        entity.setShohonNo(抄本番号);
        return this;
    }

    /**
     * 選挙番号を設定します。
     *
     * @param 選挙番号 選挙番号
     * @return {@link TachiaininHikitsugiBuilder}
     */
    public TachiaininHikitsugiBuilder set選挙番号(SenkyoNo 選挙番号) {
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙番号"));
        entity.setSenkyoNo(選挙番号);
        return this;
    }

    /**
     * 報告年月日を設定します。
     *
     * @param 報告年月日 報告年月日
     * @return {@link TachiaininHikitsugiBuilder}
     */
    public TachiaininHikitsugiBuilder set報告年月日(FlexibleDate 報告年月日) {
        requireNonNull(報告年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("報告年月日"));
        entity.setHokokuYMD(報告年月日);
        return this;
    }

    /**
     * 施設コードを設定します。
     *
     * @param 施設コード 施設コード
     * @return {@link TachiaininHikitsugiBuilder}
     */
    public TachiaininHikitsugiBuilder set施設コード(RString 施設コード) {
        requireNonNull(施設コード, UrSystemErrorMessages.値がnull.getReplacedMessage("施設コード"));
        entity.setShisetsuCode(施設コード);
        return this;
    }

    /**
     * 投票区コードを設定します。
     *
     * @param 投票区コード 投票区コード
     * @return {@link TachiaininHikitsugiBuilder}
     */
    public TachiaininHikitsugiBuilder set投票区コード(RString 投票区コード) {
        requireNonNull(投票区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区コード"));
        entity.setTohyokuCode(投票区コード);
        return this;
    }

    /**
     * 立会人連番を設定します。
     *
     * @param 立会人連番 立会人連番
     * @return {@link TachiaininHikitsugiBuilder}
     */
    public TachiaininHikitsugiBuilder set立会人連番(int 立会人連番) {
        requireNonNull(立会人連番, UrSystemErrorMessages.値がnull.getReplacedMessage("立会人連番"));
        entity.setTachiaininRenban(立会人連番);
        return this;
    }

    /**
     * 投票録項目種類を設定します。
     *
     * @param 投票録項目種類 投票録項目種類
     * @return {@link TachiaininHikitsugiBuilder}
     */
    public TachiaininHikitsugiBuilder set投票録項目種類(Code 投票録項目種類) {
        requireNonNull(投票録項目種類, UrSystemErrorMessages.値がnull.getReplacedMessage("投票録項目種類"));
        entity.setKomokuShurui(投票録項目種類);
        return this;
    }

    /**
     * 連番を設定します。
     *
     * @param 連番 連番
     * @return {@link TachiaininHikitsugiBuilder}
     */
    public TachiaininHikitsugiBuilder set連番(int 連番) {
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        entity.setRenban(連番);
        return this;
    }

    /**
     * 氏名を設定します。
     *
     * @param 氏名 氏名
     * @return {@link TachiaininHikitsugiBuilder}
     */
    public TachiaininHikitsugiBuilder set氏名(AtenaMeisho 氏名) {
        requireNonNull(氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("氏名"));
        entity.setShimei(氏名);
        return this;
    }

    /**
     * 党派を設定します。
     *
     * @param 党派 党派
     * @return {@link TachiaininHikitsugiBuilder}
     */
    public TachiaininHikitsugiBuilder set党派(RString 党派) {
        requireNonNull(党派, UrSystemErrorMessages.値がnull.getReplacedMessage("党派"));
        entity.setToha(党派);
        return this;
    }

    /**
     * 立会時間（開始時刻）を設定します。
     *
     * @param 立会時間_開始時刻 立会時間（開始時刻）
     * @return {@link TachiaininHikitsugiBuilder}
     */
    public TachiaininHikitsugiBuilder set立会時間_開始時刻(RTime 立会時間_開始時刻) {
        requireNonNull(立会時間_開始時刻, UrSystemErrorMessages.値がnull.getReplacedMessage("立会時間（開始時刻）"));
        entity.setTachiaiStartTime(立会時間_開始時刻);
        return this;
    }

    /**
     * 立会時間（終了時刻）を設定します。
     *
     * @param 立会時間_終了時刻 立会時間（終了時刻）
     * @return {@link TachiaininHikitsugiBuilder}
     */
    public TachiaininHikitsugiBuilder set立会時間_終了時刻(RTime 立会時間_終了時刻) {
        requireNonNull(立会時間_終了時刻, UrSystemErrorMessages.値がnull.getReplacedMessage("立会時間（終了時刻）"));
        entity.setTachiaiStopTime(立会時間_終了時刻);
        return this;
    }

    /**
     * 異常有フラグを設定します。
     *
     * @param 異常有フラグ 異常有フラグ
     * @return {@link TachiaininHikitsugiBuilder}
     */
    public TachiaininHikitsugiBuilder set異常有フラグ(boolean 異常有フラグ) {
        requireNonNull(異常有フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("異常有フラグ"));
        entity.setIjoAriFlag(異常有フラグ);
        return this;
    }

    /**
     * 異常内容を設定します。
     *
     * @param 異常内容 異常内容
     * @return {@link TachiaininHikitsugiBuilder}
     */
    public TachiaininHikitsugiBuilder set異常内容(RString 異常内容) {
        requireNonNull(異常内容, UrSystemErrorMessages.値がnull.getReplacedMessage("異常内容"));
        entity.setIjoNaiyo(異常内容);
        return this;
    }

    /**
     * {@link TachiaininHikitsugi}のインスタンスを生成します。
     *
     * @return {@link TachiaininHikitsugi}のインスタンス
     */
    public TachiaininHikitsugi build() {
        return new TachiaininHikitsugi(entity, id);
    }
}
