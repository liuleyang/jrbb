/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatis.param.tohyoroku;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 立会人引継情報を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L AF-0130-010 lit
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class TachiaininHikitsugiMapperParameter implements IMyBatisParameter {

    private final ShohonNo 抄本番号;
    private final SenkyoNo 選挙番号;
    private final FlexibleDate 報告年月日;
    private final RString 施設コード;
    private final RString 投票区コード;
    private final Code 投票録項目種類;

    /**
     * コンストラクタです。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙番号 選挙番号
     * @param 報告年月日 報告年月日
     * @param 施設コード 施設コード
     * @param 投票区コード 投票区コード
     * @param 投票録項目種類 投票録項目種類
     */
    private TachiaininHikitsugiMapperParameter(
            ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            RString 施設コード,
            RString 投票区コード,
            Code 投票録項目種類) {
        this.抄本番号 = 抄本番号;
        this.選挙番号 = 選挙番号;
        this.報告年月日 = 報告年月日;
        this.施設コード = 施設コード;
        this.投票区コード = 投票区コード;
        this.投票録項目種類 = 投票録項目種類;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙番号 選挙番号
     * @param 報告年月日 報告年月日
     * @param 施設コード 施設コード
     * @param 投票区コード 投票区コード
     * @param 投票録項目種類 投票録項目種類
     * @return 投票状況検索パラメータ
     */
    public static TachiaininHikitsugiMapperParameter createParam(
            ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            RString 施設コード,
            RString 投票区コード,
            Code 投票録項目種類) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙番号"));
        requireNonNull(報告年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("報告年月日"));
        requireNonNull(施設コード, UrSystemErrorMessages.値がnull.getReplacedMessage("施設コード"));
        requireNonNull(投票区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区コード"));
        requireNonNull(投票録項目種類, UrSystemErrorMessages.値がnull.getReplacedMessage("投票録項目種類"));
        return new TachiaininHikitsugiMapperParameter(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード, 投票録項目種類);
    }
}
