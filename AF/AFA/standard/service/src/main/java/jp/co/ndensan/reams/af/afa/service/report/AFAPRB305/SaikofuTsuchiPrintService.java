package jp.co.ndensan.reams.af.afa.service.report.AFAPRB305;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.SaikofuTsuchiParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB305.SaikofuTsuchiPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB305.SaikofuTsuchiReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB305.NotTorokuTsuchiRyojikanReportSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.af.afa.service.core.NotTorokuTsuchiHonnin;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;

/**
 * 再交付通知
 *
 * @reamsid_L AF-0340-020 liuj2
 */
public class SaikofuTsuchiPrintService {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;

    private static final RString コード種別 = new RString("0035");
    private static final FlexibleDate DATE = FlexibleDate.EMPTY;
    private static final RString EMPTY = new RString("");
    private static final RString 長さ_氏名１ = new RString("honninShimei1");
    private static final RString 長さ_通知元市町村名１ = new RString("tsuchiMoto1");
    private static final RString 長さ_通知元市町村名２ = new RString("tsuchiMoto2");
    private static final RString 長さ_委員長名１ = new RString("iinchoMei1");
    private static final RString 長さ_本文1 = new RString("honbun1");
    private static final RString 長さ_本文2 = new RString("honbun2");
    private static final RString 長さ_本文3 = new RString("honbun3");
    private static final RString 長さ_本文4 = new RString("honbun4");
    private static final RString 長さ_本文5 = new RString("honbun5");
    private static final RString 長さ_連絡先住所１ = new RString("renrakusakiJusho1");

    /**
     * 再交付通知
     *
     * @param saikofuTsuchiList List<SaikofuTsuchiParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<SaikofuTsuchiParam> saikofuTsuchiList) {
        try (ReportManager reportManager = new ReportManager()) {
            SaikofuTsuchiPorperty property = new SaikofuTsuchiPorperty();
            try (ReportAssembler<NotTorokuTsuchiRyojikanReportSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {

                ReportSourceWriter<NotTorokuTsuchiRyojikanReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                NotTorokuTsuchiHonnin notTorokuTsuchiHonnin = NotTorokuTsuchiHonnin.createInstance();
                for (SaikofuTsuchiParam param : saikofuTsuchiList) {
                    AtenaMeisho 漢字氏名 = param.get在外選挙人申請情報().get申請情報().getShinseishaShimei();
                    RString 発行番号 = notTorokuTsuchiHonnin.get発行番号(changeNullToEmpty(param.get画面帳票作成入力項目().get発行番号_第()),
                            changeNullToEmpty(param.get画面帳票作成入力項目().get発行番号_号()), changeNullToEmpty(param.get画面帳票作成入力項目().get発行番号()));
                    List<RString> 通知元市町村 = notTorokuTsuchiHonnin.get通知元市町村１_２(getItemLength(長さ_通知元市町村名１), getItemLength(長さ_通知元市町村名２));
                    List<RString> 委員長名リスト = notTorokuTsuchiHonnin.get委員長名１_２(changeNullToEmpty(param.get画面帳票作成入力項目().get選管委員長名()),
                            getItemLength(長さ_委員長名１));
                    List<RString> 氏名リスト = notTorokuTsuchiHonnin.get本人氏名１_２(null == 漢字氏名 ? RString.EMPTY : 漢字氏名.getColumnValue(),
                            getItemLength(長さ_氏名１));
                    List<RString> 本文リスト = notTorokuTsuchiHonnin.get本文(new CodeShubetsu(コード種別), getItemLength(長さ_本文1),
                            getItemLength(長さ_本文2), getItemLength(長さ_本文3), getItemLength(長さ_本文4), getItemLength(長さ_本文5), DATE, EMPTY);
                    List<RString> 連絡先住所リスト = notTorokuTsuchiHonnin.get連絡先住所１_２(getItemLength(長さ_連絡先住所１));
                    List<RString> 連絡先リスト = notTorokuTsuchiHonnin.get連絡先１_３();
                    RString 連絡先委員会名 = notTorokuTsuchiHonnin.get事務局名();
                    RString 連絡先郵便番号 = notTorokuTsuchiHonnin.get郵便番号();

                    param.setHakkoDaino(発行番号);
                    param.setHakkoYmd(notTorokuTsuchiHonnin.get日付編集(param.get画面帳票作成入力項目().get発行日()));
                    param.setHonninShimei1(氏名リスト.get(ZERO));
                    param.setHonninShimei2(氏名リスト.get(ONE));
                    param.setTsuchiMoto1(通知元市町村.get(ZERO));
                    param.setTsuchiMoto2(通知元市町村.get(ONE));
                    param.setIinchoMei1(委員長名リスト.get(ZERO));
                    param.setIinchoMei2(委員長名リスト.get(ONE));
                    param.setHonbun1(本文リスト.get(ZERO));
                    param.setHonbun2(本文リスト.get(ONE));
                    param.setHonbun3(本文リスト.get(TWO));
                    param.setHonbun4(本文リスト.get(THREE));
                    param.setHonbun5(本文リスト.get(FOUR));
                    param.setHonbun6(本文リスト.get(FIVE));
                    param.setRenrakusakiIinkaiMei(連絡先委員会名);
                    param.setRenrakusakiYubinNo(連絡先郵便番号);
                    param.setRenrakusakiJusho1(連絡先住所リスト.get(ZERO));
                    param.setRenrakusakiJusho2(連絡先住所リスト.get(ONE));
                    param.setRenrakusakiTitle1(連絡先リスト.get(ZERO));
                    param.setRenrakusaki1(連絡先リスト.get(ONE));
                    param.setRenrakusakiTitle2(連絡先リスト.get(TWO));
                    param.setRenrakusaki2(連絡先リスト.get(THREE));
                    param.setRenrakusakiTitle3(連絡先リスト.get(FOUR));
                    param.setRenrakusaki3(連絡先リスト.get(FIVE));
                }

                for (SaikofuTsuchiReport report : toReports(saikofuTsuchiList)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<SaikofuTsuchiReport> toReports(List<SaikofuTsuchiParam> targets) {
        List<SaikofuTsuchiReport> list = new ArrayList<>();
        list.add(new SaikofuTsuchiReport(targets));
        return list;
    }

    private static RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }

    private int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(NotTorokuTsuchiRyojikanReportSource.class, itemName);
    }
}
