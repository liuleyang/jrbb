/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.batchprm.tohyokekkaprint;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.processprm.tohyokekkaprint.AFABTE505BatchPrintProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.tohyokekkaprint.AFABTE505SelectProcessParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import lombok.Getter;
import lombok.Setter;

/**
 * 投票結果集計表バッチパラメータクラスです。
 *
 * @reamsid_L AF-0290-020 lit
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AFABTE505BatchParameter extends BatchParameterBase implements IBatchProcessParameter {

    private static final String KEY_SHOHONNO = "抄本番号";
    private static final String KEY_SENKYOSHURUI = "選挙種類";
    private static final String KEY_SENKYO_OUTFLG = "無投票選挙出力有無";
    private static final String KEY_NENREIBETSU_TOHYOROKU_FROM = "年齢別集計表投票区from";
    private static final String KEY_NENREIBETSU_TOHYOROKU_TO = "年齢別集計表投票区to ";
    private static final String KEY_NENREIBETSU_OUTFLG = "年齢別集計表出力有無";
    private static final String KEY_NENREIBETSU_EUCFLG = "年齢別集計表EUCフラグ";
    private static final String KEY_NENDAIBETSU_TOHYOROKU_FROM = "年代別集計表投票区from";
    private static final String KEY_NENDAIBETSU_TOHYOROKU_TO = "年代別集計表投票区to ";
    private static final String KEY_NENDAIBETSU_OUTFLG = "年代別集計表出力有無";
    private static final String KEY_NENDAIBETSU_EUCFLG = "年代別集計表EUCフラグ";
    private static final String KEY_JIKANBETSU_OUTFLG = "時間別集計表出力有無";

    @BatchParameter(key = KEY_SHOHONNO, name = "抄本番号", order = 1)
    private RString 抄本番号;
    @BatchParameter(key = KEY_SENKYOSHURUI, name = "選挙種類", order = 2)
    private RString 選挙種類;

    @BatchParameter(key = KEY_NENREIBETSU_OUTFLG, name = "年齢別集計表出力有無", order = 3)
    private Boolean 年齢別集計表出力有無;
    @BatchParameter(key = KEY_NENREIBETSU_EUCFLG, name = "年齢別集計表EUCフラグ", order = 4)
    private Boolean 年齢別集計表EUCフラグ;
    @BatchParameter(key = KEY_NENREIBETSU_TOHYOROKU_FROM, name = "年齢別集計表投票区from", order = 5)
    private RString 年齢別集計表投票区from;
    @BatchParameter(key = KEY_NENREIBETSU_TOHYOROKU_TO, name = "年齢別集計表投票区to ", order = 6)
    private RString 年齢別集計表投票区to;

    @BatchParameter(key = KEY_NENDAIBETSU_OUTFLG, name = "年代別集計表出力有無", order = 7)
    private Boolean 年代別集計表出力有無;
    @BatchParameter(key = KEY_NENDAIBETSU_EUCFLG, name = "年代別集計表EUCフラグ", order = 8)
    private Boolean 年代別集計表EUCフラグ;
    @BatchParameter(key = KEY_NENDAIBETSU_TOHYOROKU_FROM, name = "年代別集計表投票区from", order = 9)
    private RString 年代別集計表投票区from;
    @BatchParameter(key = KEY_NENDAIBETSU_TOHYOROKU_TO, name = "年代別集計表投票区to ", order = 10)
    private RString 年代別集計表投票区to;

    @BatchParameter(key = KEY_JIKANBETSU_OUTFLG, name = "時間別集計表出力有無", order = 11)
    private Boolean 時間別集計表出力有無;

    @BatchParameter(key = KEY_SENKYO_OUTFLG, name = "無投票選挙出力有無", order = 12)
    private Boolean 無投票選挙出力有無;

    /**
     * 年齢別投票状況調べProcessParameterの変換のメソッド
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param order順 RString
     * @param order ASC | DESC
     * @return AFABTE505SelectProcessParameter
     */
    public AFABTE505SelectProcessParameter to年齢別投票集計表ProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            RString order順, Order order) {
        AFABTE505SelectProcessParameter processParameter = new AFABTE505SelectProcessParameter(
                無投票選挙出力有無,
                年齢別集計表投票区from, 年齢別集計表投票区to,
                searchKey, get修正後抄本番号(), order順);
        processParameter.setOrder(order);
        processParameter.setEucFlg(年齢別集計表EUCフラグ);
        processParameter.set選挙種類(new Code(選挙種類));
        return processParameter;
    }

    /**
     * 年代別投票状況調べProcessParameterの変換のメソッド
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param order順 RString
     * @param order ASC | DESC
     * @return AFABTE505SelectProcessParameter
     */
    public AFABTE505SelectProcessParameter to年代別投票集計表ProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            RString order順, Order order) {
        AFABTE505SelectProcessParameter processParameter = new AFABTE505SelectProcessParameter(
                無投票選挙出力有無,
                年代別集計表投票区from, 年代別集計表投票区to,
                searchKey, get修正後抄本番号(), order順);
        processParameter.setOrder(order);
        processParameter.setEucFlg(年代別集計表EUCフラグ);
        processParameter.set選挙種類(new Code(選挙種類));
        return processParameter;
    }

    /**
     * 時間別投票状況表合計ProcessParameterの変換のメソッド
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param order順 RString
     * @return AFABTE505SelectProcessParameter
     */
    public AFABTE505SelectProcessParameter to時間別投票集計表ProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey, RString order順) {
        AFABTE505SelectProcessParameter processParameter = new AFABTE505SelectProcessParameter(
                無投票選挙出力有無,
                RString.EMPTY, RString.EMPTY,
                searchKey, get修正後抄本番号(), order順);
        processParameter.set選挙種類(new Code(選挙種類));
        return processParameter;
    }

    private ShohonNo get修正後抄本番号() {
        return null != 抄本番号 && !抄本番号.isEmpty() ? new ShohonNo(抄本番号) : null;
    }

    /**
     * 投票結果集計表バッチ出力条件表のパラメータへの変換のメソッド
     *
     * @return 投票日前日関連帳票バッチ出力条件表のパラメータ
     */
    public AFABTE505BatchPrintProcessParameter toAFABTE505BatchPrintProcessParameter() {
        return new AFABTE505BatchPrintProcessParameter(get修正後抄本番号(),
                年齢別集計表出力有無,
                年齢別集計表EUCフラグ,
                年齢別集計表投票区from,
                年齢別集計表投票区to,
                年代別集計表出力有無,
                年代別集計表EUCフラグ,
                年代別集計表投票区from,
                年代別集計表投票区to,
                時間別集計表出力有無);
    }
}
