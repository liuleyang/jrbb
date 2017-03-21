/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMG1060;

import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.business.tojitsutohyo.ShohonSearchResult;
import jp.co.ndensan.reams.af.afa.definition.batchprm.reprintkokumin.AFABTG106BatchParameter;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1060.RePrintKokuminDiv;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国民投票帳票再発行のクラス
 *
 * @reamsid_L AF-0400-010 guancy
 */
public class RePrintKokuminHandler {

    private final RePrintKokuminDiv div;

    /**
     * コンストラクタです。
     *
     * @param div RePrintKokuminDiv
     */
    public RePrintKokuminHandler(RePrintKokuminDiv div) {
        this.div = div;
    }

    /**
     * 「実行する」ボタン押下のチェックする。
     *
     * @param 対象抄本情報 ShohonSearchResult
     * @param 抹消日 FlexibleDate
     * @param 抄本 Senkyo
     * @return parameter AFABTG106BatchParameter
     */
    public AFABTG106BatchParameter set画面入力内容(ShohonSearchResult 対象抄本情報, FlexibleDate 抹消日, Senkyo 抄本) {
        AFABTG106BatchParameter parameter = new AFABTG106BatchParameter();
        parameter.set抄本番号(new RString(対象抄本情報.get抄本番号().getColumnValue()));
        parameter.set抄本名(対象抄本情報.get抄本名称());
        parameter.set投票日(対象抄本情報.get投票年月日());
        parameter.set基準日(対象抄本情報.get名簿基準年月日());
        parameter.set名簿登録日(対象抄本情報.get名簿登録年月日());
        parameter.set年齢到達日(対象抄本情報.get規定年齢到達年月日());
        parameter.set特定期間開始日(抄本 == null ? FlexibleDate.EMPTY : 抄本.get転出期限年月日());
        parameter.set特定期限日(対象抄本情報.get転入期限年月日());
        parameter.set受付開始日(対象抄本情報.get投票受付開始年月日());
        parameter.set投票人名簿抄本出力有無(div.getCcdRePrintKokuminSakuseiChohy().get投票人名簿抄本().isIsPublish());
        parameter.set投票人名簿登録者数リスト出力有無(div.getCcdRePrintKokuminSakuseiChohy().get投票人名簿登録者数リスト().isIsPublish());
        RDate 時点日 = div.getCcdRePrintKokuminSakuseiChohy().get投票人名簿登録者数リスト().getTxtTorokushasuListKijunYmd().getValue();
        if (時点日 == null || !時点日.isWareki()) {
            parameter.set時点日(対象抄本情報.get名簿基準年月日());
        } else {
            parameter.set時点日(new FlexibleDate(時点日.toDateString()));
        }
        parameter.set不在資格対象者名簿出力有無(div.getCcdRePrintKokuminSakuseiChohy().get投票人名簿登録者数リスト().getChkFuzaiTohyoMeibo().isAllSelected());
        parameter.set不在者投票資格者分出力有無(div.getCcdRePrintKokuminSakuseiChohy().get投票人名簿登録者数リスト().getChkTorokuListFuzaishabun().isAllSelected());

        parameter.set一号資格登録通知出力有無(div.getCcdRePrintKokuminSakuseiChohy().get1号資格登録通知().isIsPublish());
        RDate 発行日_1号資格登録 = div.getCcdRePrintKokuminSakuseiChohy().get1号資格登録通知().getCcdPrintNaiyo1goTsuchi().getTxtHakkoYMD().getValue();
        if (発行日_1号資格登録 == null || !発行日_1号資格登録.isWareki()) {
            parameter.set発行日_1号資格登録(FlexibleDate.EMPTY);
        } else {
            parameter.set発行日_1号資格登録(new FlexibleDate(発行日_1号資格登録.toDateString()));
        }
        parameter.set発行番号の第_1号資格(div.getCcdRePrintKokuminSakuseiChohy().get1号資格登録通知().getCcdPrintNaiyo1goTsuchi().getCcdHakkoBango().get発行番号_第());
        parameter.set発行番号の番号_1号資格(div.getCcdRePrintKokuminSakuseiChohy().get1号資格登録通知().getCcdPrintNaiyo1goTsuchi().getCcdHakkoBango().get発行番号_番号());
        parameter.set発行番号の号_1号資格(div.getCcdRePrintKokuminSakuseiChohy().get1号資格登録通知().getCcdPrintNaiyo1goTsuchi().getCcdHakkoBango().get発行番号_号());
        parameter.set一号資格登録通知一覧表出力有無(div.getCcdRePrintKokuminSakuseiChohy().get1号資格登録通知().getChk1goTsuchiIchiran().isAllSelected());
        parameter.set送付先宛名シール出力有無_1号資格(div.getCcdRePrintKokuminSakuseiChohy().get1号資格登録通知().getChkSeal1goTsuchi().isAllSelected());
        parameter.set二号資格調査票出力有無(div.getCcdRePrintKokuminSakuseiChohy().get2号資格調査票().isIsPublish());
        RDate 発行日_2号資格登録 = div.getCcdRePrintKokuminSakuseiChohy().get2号資格調査票().getCcdPrintNaiyo2goChosahyo().getTxtHakkoYMD().getValue();
        if (発行日_2号資格登録 == null || !発行日_2号資格登録.isWareki()) {
            parameter.set発行日_2号資格(FlexibleDate.EMPTY);
        } else {
            parameter.set発行日_2号資格(new FlexibleDate(発行日_2号資格登録.toDateString()));
        }
        parameter.set発行番号の第_2号資格(div.getCcdRePrintKokuminSakuseiChohy().get2号資格調査票().getCcdPrintNaiyo2goChosahyo().getCcdHakkoBango().get発行番号_第());
        parameter.set発行番号の番号_2号資格(div.getCcdRePrintKokuminSakuseiChohy().get2号資格調査票().getCcdPrintNaiyo2goChosahyo().getCcdHakkoBango().get発行番号_番号());
        parameter.set発行番号の号_2号資格(div.getCcdRePrintKokuminSakuseiChohy().get2号資格調査票().getCcdPrintNaiyo2goChosahyo().getCcdHakkoBango().get発行番号_号());
        parameter.set二号資格調査一覧表出力有無(div.getCcdRePrintKokuminSakuseiChohy().get2号資格調査票().getChk2goChosaIchiran().isAllSelected());
        parameter.set送付先宛名シール出力有無_2号資格(div.getCcdRePrintKokuminSakuseiChohy().get2号資格調査票().getChkSeal2goChosahyo().isAllSelected());
        parameter.set二号資格候補者一覧表出力有無(div.getCcdRePrintKokuminSakuseiChohy().get2号資格候補者一覧表().isIsPublish());
        parameter.set補正登録者名簿出力有無(div.getCcdRePrintKokuminSakuseiChohy().get補正登録者名簿().isIsPublish());
        parameter.set補正登録者宛名シール出力有無(div.getCcdRePrintKokuminSakuseiChohy().get補正登録者名簿().getChkSealTorokushaMeibo().isAllSelected());
        parameter.set縦覧用も作成する出力有無(div.getCcdRePrintKokuminSakuseiChohy().get補正登録者名簿().getChkTorokushaMeiboJuran().isAllSelected());
        parameter.set抹消者名簿出力有無(div.getCcdRePrintKokuminSakuseiChohy().get抹消者名簿().isIsPublish());
        RDate 抹消者名簿抹消日 = div.getCcdRePrintKokuminSakuseiChohy().get抹消者名簿().getTxtMasshoYMD().getValue();
        if (抹消者名簿抹消日 == null || !抹消者名簿抹消日.isWareki()) {
            parameter.set抹消日(抹消日);
        } else {
            parameter.set抹消日(new FlexibleDate(抹消者名簿抹消日.toDateString()));
        }
        parameter.set縦覧用も作成する出力有無_抹消者(div.getCcdRePrintKokuminSakuseiChohy().get抹消者名簿().getChkMasshoshaMeiboJuran().isAllSelected());
        parameter.set訂正者名簿出力有無(div.getCcdRePrintKokuminSakuseiChohy().get訂正者名簿().isIsPublish());
        parameter.set未登録者抹消通知出力有無(div.getCcdRePrintKokuminSakuseiChohy().get未登録者抹消通知().isIsPublish());
        RDate 発行日_未登録者抹消通知 = div.getCcdRePrintKokuminSakuseiChohy().get未登録者抹消通知().getCcdPrintNaiyoMasshoTsuchi().getTxtHakkoYMD().getValue();
        if (発行日_未登録者抹消通知 == null || !発行日_未登録者抹消通知.isWareki()) {
            parameter.set発行日_未登録者抹消(FlexibleDate.EMPTY);
        } else {
            parameter.set発行日_未登録者抹消(new FlexibleDate(発行日_未登録者抹消通知.toDateString()));
        }
        parameter.set発行番号の第_未登録者抹消(div.getCcdRePrintKokuminSakuseiChohy().get未登録者抹消通知().getCcdPrintNaiyoMasshoTsuchi().getCcdHakkoBango().get発行番号_第());
        parameter.set発行番号の番号_未登録者抹消(div.getCcdRePrintKokuminSakuseiChohy().get未登録者抹消通知().getCcdPrintNaiyoMasshoTsuchi().getCcdHakkoBango().get発行番号_番号());
        parameter.set発行番号の号_未登録者抹消(div.getCcdRePrintKokuminSakuseiChohy().get未登録者抹消通知().getCcdPrintNaiyoMasshoTsuchi().getCcdHakkoBango().get発行番号_号());
        parameter.set未登録者抹消通知一覧出力有無(div.getCcdRePrintKokuminSakuseiChohy().get未登録者抹消通知().getChkMasshoTsuchiIchiran().isAllSelected());
        parameter.set送付先宛名シール出力有無_未登録者抹消(div.getCcdRePrintKokuminSakuseiChohy().get未登録者抹消通知().getChkSealMasshoTsuchi().isAllSelected());
        parameter.set国内転入者調査票出力有無(div.getCcdRePrintKokuminSakuseiChohy().get国内転入者調査票().isIsPublish());
        RDate 発行日_国内転入者調査票 = div.getCcdRePrintKokuminSakuseiChohy().get国内転入者調査票().getCcdPrintNaiyoKokunaiChosa().getTxtHakkoYMD().getValue();
        if (発行日_国内転入者調査票 == null || !発行日_国内転入者調査票.isWareki()) {
            parameter.set発行日_国内転入者調査票(FlexibleDate.EMPTY);
        } else {
            parameter.set発行日_国内転入者調査票(new FlexibleDate(発行日_国内転入者調査票.toDateString()));
        }
        parameter.set発行番号の第_国内転入者調査票(div.getCcdRePrintKokuminSakuseiChohy().get国内転入者調査票().getCcdPrintNaiyoKokunaiChosa().getCcdHakkoBango().get発行番号_第());
        parameter.set発行番号の番号_国内転入者調査票(div.getCcdRePrintKokuminSakuseiChohy().get国内転入者調査票().getCcdPrintNaiyoKokunaiChosa().getCcdHakkoBango().get発行番号_番号());
        parameter.set発行番号の号_国内転入者調査票(div.getCcdRePrintKokuminSakuseiChohy().get国内転入者調査票().getCcdPrintNaiyoKokunaiChosa().getCcdHakkoBango().get発行番号_号());
        parameter.set国内転入者調査一覧表出力有無(div.getCcdRePrintKokuminSakuseiChohy().get国内転入者調査票().getChkKokunaiChosaIchiran().isAllSelected());
        parameter.set送付先宛名シール出力有無_国内転入者調査票(div.getCcdRePrintKokuminSakuseiChohy().get国内転入者調査票().getChkSealKokunaiChosa().isAllSelected());
        parameter.set国外転入者調査票出力有無(div.getCcdRePrintKokuminSakuseiChohy().get国外転入者調査票().isIsPublish());
        RDate 発行日_国外転入者調査票 = div.getCcdRePrintKokuminSakuseiChohy().get国外転入者調査票().getCcdPrintNaiyoKokugaiChosa().getTxtHakkoYMD().getValue();
        if (発行日_国外転入者調査票 == null || !発行日_国外転入者調査票.isWareki()) {
            parameter.set発行日_国外転入者調査票(FlexibleDate.EMPTY);
        } else {
            parameter.set発行日_国外転入者調査票(new FlexibleDate(発行日_国外転入者調査票.toDateString()));
        }
        parameter.set発行番号の第_国外転入者調査票(div.getCcdRePrintKokuminSakuseiChohy().get国外転入者調査票().getCcdPrintNaiyoKokugaiChosa().getCcdHakkoBango().get発行番号_第());
        parameter.set発行番号の番号_国外転入者調査票(div.getCcdRePrintKokuminSakuseiChohy().get国外転入者調査票().getCcdPrintNaiyoKokugaiChosa().getCcdHakkoBango().get発行番号_番号());
        parameter.set発行番号の号_国外転入者調査票(div.getCcdRePrintKokuminSakuseiChohy().get国外転入者調査票().getCcdPrintNaiyoKokugaiChosa().getCcdHakkoBango().get発行番号_号());
        parameter.set国外転入者調査一覧表出力有無(div.getCcdRePrintKokuminSakuseiChohy().get国外転入者調査票().getChkKokugaiChosaIchiran().isAllSelected());
        parameter.set送付先宛名シール出力有無_国外転入者調査票(div.getCcdRePrintKokuminSakuseiChohy().get国外転入者調査票().getChkSealKokugaiChosa().isAllSelected());
        parameter.set在外投票人名簿抄本出力有無(div.getCcdRePrintKokuminSakuseiChohy().get在外投票関連().getKokuminSakuseiChohyoZaigaiSenkyoninMeiboShohon().isIsPublish());
        parameter.set在外投票資格者名簿出力有無(div.getCcdRePrintKokuminSakuseiChohy().get在外投票関連().getKokuminSakuseiChohyoZaigaiShikakushaMeibo().isIsPublish());
        parameter.set在外投票管理表出力有無(div.getCcdRePrintKokuminSakuseiChohy().get在外投票関連().getKokuminSakuseiChohyoZaigaiTohyoKanrihyo().isIsPublish());
        return parameter;
    }
}
