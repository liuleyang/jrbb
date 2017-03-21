package jp.co.ndensan.reams.af.afa.service.report.AFAPRB304;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.NotTorokuTsuchiHonninParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB304.NotTorokuTsuchiHonninPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB304.NotTorokuTsuchiHonninReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB304.NotTorokuTsuchiHonninReportSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.af.afa.service.core.NotTorokuTsuchiHonnin;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;

/**
 * 登録を行わなかった旨の通知（本人）
 *
 * @reamsid_L AF-0320-033 lis2
 */
public class NotTorokuTsuchiHonninPrintService {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int SEVEN = 7;
    private static final int EIGHT = 8;

    private static final RString コード種別 = new RString("0031");
    private static final FlexibleDate DATE = FlexibleDate.EMPTY;
    private static final RString EMPTY = new RString("");
    private static final RString 長さ_本人氏名１ = new RString("honninShimei1");
    private static final RString 長さ_委員長名１ = new RString("iinchoMei1");
    private static final RString 長さ_氏名１ = new RString("shimei1");
    private static final RString 長さ_本文1 = new RString("honbun1");
    private static final RString 長さ_本文2 = new RString("honbun2");
    private static final RString 長さ_通知元市町村名１ = new RString("tsuchiMoto1");
    private static final RString 長さ_通知元市町村名２ = new RString("tsuchiMoto2");
    private static final RString 長さ_領事官 = new RString("ryojikan");
    private static final RString 長さ_領事官１ = new RString("ryojikan1");

    /**
     * 登録を行わなかった旨の通知（本人）
     *
     * @param notTorokuTsuchiHonninList List<NotTorokuTsuchiHonninParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<NotTorokuTsuchiHonninParam> notTorokuTsuchiHonninList) {
        try (ReportManager reportManager = new ReportManager()) {
            NotTorokuTsuchiHonninPorperty property = new NotTorokuTsuchiHonninPorperty();
            try (ReportAssembler<NotTorokuTsuchiHonninReportSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {

                ReportSourceWriter<NotTorokuTsuchiHonninReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                NotTorokuTsuchiHonnin notTorokuTsuchiHonnin = NotTorokuTsuchiHonnin.createInstance();
                for (NotTorokuTsuchiHonninParam param : notTorokuTsuchiHonninList) {
                    AtenaMeisho 漢字氏名 = param.get在外選挙人申請情報().get申請情報().getShinseishaShimei();
                    RString 領事官名称 = null == param.get在外選挙人申請情報().get領事官() ? RString.EMPTY : param.get在外選挙人申請情報().get領事官().getRyojikanName();
                    Code 申請取下事由コード1 = param.get在外選挙人申請情報().get申請情報().getTorisageJiyuCode();
                    List<RString> 本人氏名リスト1 = notTorokuTsuchiHonnin.get本人氏名１_２(null == 漢字氏名 ? RString.EMPTY : 漢字氏名.getColumnValue(),
                            getItemLength(長さ_本人氏名１));
                    List<RString> 通知元市町村リスト1 = notTorokuTsuchiHonnin.get通知元市町村１_２(getItemLength(長さ_通知元市町村名１), getItemLength(長さ_通知元市町村名２));
                    List<RString> 委員長名リスト1 = notTorokuTsuchiHonnin.get委員長名１_２(changeNullToEmpty(param.get画面帳票作成入力項目().get選管委員長名()),
                            getItemLength(長さ_委員長名１));
                    List<RString> 本文リスト1 = notTorokuTsuchiHonnin.get本文(new CodeShubetsu(コード種別), getItemLength(長さ_本文1),
                            getItemLength(長さ_本文2), ZERO, ZERO, ZERO, DATE, EMPTY);
                    List<RString> 氏名リスト1 = notTorokuTsuchiHonnin.get氏名と氏名１_２(null == 漢字氏名 ? RString.EMPTY : 漢字氏名.getColumnValue(),
                            getItemLength(長さ_氏名１));
                    List<RString> 領事官リスト1 = notTorokuTsuchiHonnin.get領事官と領事官１_２(領事官名称, getItemLength(長さ_領事官), getItemLength(長さ_領事官１));
                    List<RString> 理由リスト1 = notTorokuTsuchiHonnin.get理由１_９(null == 申請取下事由コード1 ? RString.EMPTY : 申請取下事由コード1.getColumnValue());
                    RString 発行番号 = notTorokuTsuchiHonnin.get発行番号(changeNullToEmpty(param.get画面帳票作成入力項目().get発行番号_第()),
                            changeNullToEmpty(param.get画面帳票作成入力項目().get発行番号_号()), changeNullToEmpty(param.get画面帳票作成入力項目().get発行番号()));
                    RString 選挙種類 = notTorokuTsuchiHonnin.get選挙種類();

                    param.setHonninShimei1(本人氏名リスト1.get(ZERO));
                    param.setHonninShimei2(本人氏名リスト1.get(ONE));
                    param.setHakkoDaino(発行番号);
                    param.setHakkoYmd(notTorokuTsuchiHonnin.get日付編集(param.get画面帳票作成入力項目().get発行日()));
                    param.setTsuchiMoto1(通知元市町村リスト1.get(ZERO));
                    param.setTsuchiMoto2(通知元市町村リスト1.get(ONE));
                    param.setIinchoMei1(委員長名リスト1.get(ZERO));
                    param.setIinchoMei2(委員長名リスト1.get(ONE));
                    param.setSenkyoShurui(選挙種類);
                    param.setHonbun1(本文リスト1.get(ZERO));
                    param.setHonbun2(本文リスト1.get(ONE));
                    param.setHonbun3(本文リスト1.get(TWO));
                    param.setShimei(氏名リスト1.get(ZERO));
                    param.setShimei1(氏名リスト1.get(ONE));
                    param.setShimei2(氏名リスト1.get(TWO));
                    param.setRyojikan(領事官リスト1.get(ZERO));
                    param.setRyojikan1(領事官リスト1.get(ONE));
                    param.setRyojikan2(領事官リスト1.get(TWO));
                    param.setRiyu1(理由リスト1.get(ZERO));
                    param.setRiyu2(理由リスト1.get(ONE));
                    param.setRiyu3(理由リスト1.get(TWO));
                    param.setRiyu4(理由リスト1.get(THREE));
                    param.setRiyu5(理由リスト1.get(FOUR));
                    param.setRiyu6(理由リスト1.get(FIVE));
                    param.setRiyu7(理由リスト1.get(SIX));
                    param.setRiyu8(理由リスト1.get(SEVEN));
                    param.setRiyu9(理由リスト1.get(EIGHT));
                }
                for (NotTorokuTsuchiHonninReport report : toReports(notTorokuTsuchiHonninList)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<NotTorokuTsuchiHonninReport> toReports(List<NotTorokuTsuchiHonninParam> targets) {
        List<NotTorokuTsuchiHonninReport> list = new ArrayList<>();
        list.add(new NotTorokuTsuchiHonninReport(targets));
        return list;
    }

    private static RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }

    private int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(NotTorokuTsuchiHonninReportSource.class, itemName);
    }
}
