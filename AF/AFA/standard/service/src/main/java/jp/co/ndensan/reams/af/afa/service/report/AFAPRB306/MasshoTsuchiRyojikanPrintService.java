package jp.co.ndensan.reams.af.afa.service.report.AFAPRB306;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.MasshoTsuchiRyojikanParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB306.MasshoTsuchiRyojikanPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB306.MasshoTsuchiRyojikanReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB306.KisaijikoHenkoTsuchiRyojikanReportSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.af.afa.service.core.KisaijikoHenkoTsuchiHonnin;
import jp.co.ndensan.reams.af.afa.service.core.MasshoTsuchiHonseki;
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
 * 抹消通知（領事官）
 *
 * @reamsid_L AF-0350-031 wangh
 */
public class MasshoTsuchiRyojikanPrintService {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final RString コード種別 = new RString("0037");
    private static final FlexibleDate DATE = FlexibleDate.EMPTY;
    private static final RString EMPTY = new RString("");
    private static final RString 長さ_通知先市町村１ = new RString("tsuchiSakiS");
    private static final RString 長さ_通知元市町村名１ = new RString("tsuchiMoto1");
    private static final RString 長さ_通知元市町村名２ = new RString("tsuchiMoto2");
    private static final RString 長さ_委員長名１ = new RString("iinchoMei1");
    private static final RString 長さ_本文1 = new RString("honbun1");
    private static final RString 長さ_本文２ = new RString("honbun2");
    private static final RString 長さ_氏名１ = new RString("shimei1");

    /**
     * 抹消通知（領事官）
     *
     * @param masshoTsuchiRyojikanList List<MasshoTsuchiRyojikanParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<MasshoTsuchiRyojikanParam> masshoTsuchiRyojikanList) {
        try (ReportManager reportManager = new ReportManager()) {
            MasshoTsuchiRyojikanPorperty property = new MasshoTsuchiRyojikanPorperty();
            try (ReportAssembler<KisaijikoHenkoTsuchiRyojikanReportSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {

                ReportSourceWriter<KisaijikoHenkoTsuchiRyojikanReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                NotTorokuTsuchiHonnin notTorokuTsuchiHonnin = NotTorokuTsuchiHonnin.createInstance();
                MasshoTsuchiHonseki masshoTsuchiHonseki = MasshoTsuchiHonseki.createInstance();
                KisaijikoHenkoTsuchiHonnin kisaijikoHenkoTsuchiHonnin = KisaijikoHenkoTsuchiHonnin.createInstance();
                for (MasshoTsuchiRyojikanParam param : masshoTsuchiRyojikanList) {

                    AtenaMeisho 漢字氏名 = param.get在外選挙人申請情報().get申請情報().getShinseishaShimei();
                    RString 性別コード = param.get在外選挙人申請情報().get申請情報().getSeibetsuCode();
                    RString 領事官名称 = null == param.get在外選挙人申請情報().get領事官() ? RString.EMPTY : param.get在外選挙人申請情報().get領事官().getRyojikanName();
                    RString 発行番号 = notTorokuTsuchiHonnin.get発行番号(changeNullToEmpty(param.get画面帳票作成入力項目().get発行番号_第()),
                            changeNullToEmpty(param.get画面帳票作成入力項目().get発行番号_号()), changeNullToEmpty(param.get画面帳票作成入力項目().get発行番号()));
                    RString 選挙種類 = notTorokuTsuchiHonnin.get選挙種類();
                    List<RString> 通知先市町村リスト = notTorokuTsuchiHonnin.get領事官１_２(null == 領事官名称 ? RString.EMPTY : 領事官名称,
                            getItemLength(長さ_通知先市町村１));
                    List<RString> 通知元市町村リスト = notTorokuTsuchiHonnin.get通知元市町村１_２(getItemLength(長さ_通知元市町村名１), getItemLength(長さ_通知元市町村名２));
                    List<RString> 委員長名リスト = notTorokuTsuchiHonnin.get委員長名１_２(changeNullToEmpty(param.get画面帳票作成入力項目().get選管委員長名()),
                            getItemLength(長さ_委員長名１));
                    List<RString> 氏名リスト = notTorokuTsuchiHonnin.get氏名と氏名１_２(null == 漢字氏名 ? RString.EMPTY : 漢字氏名.getColumnValue(),
                            getItemLength(長さ_氏名１));
                    List<RString> 性別リスト = kisaijikoHenkoTsuchiHonnin.get性別１_２(null == 性別コード ? RString.EMPTY : 性別コード);
                    List<RString> 本文リスト = notTorokuTsuchiHonnin.get本文(new CodeShubetsu(コード種別),
                            getItemLength(長さ_本文1), getItemLength(長さ_本文２), ZERO, ZERO, ZERO, DATE, EMPTY);
                    Code 抹消事由 = param.get在外選挙資格().getMasshoJiyuCode();
                    RString 抹消事由コード = null == 抹消事由 || 抹消事由.isEmpty() ? RString.EMPTY : 抹消事由.getColumnValue();
                    List<RString> 抹消理由リスト = masshoTsuchiHonseki.get抹消理由１_４(抹消事由コード);

                    param.setHakkoDaino(発行番号);
                    param.setHakkoYmd(notTorokuTsuchiHonnin.get日付編集(param.get画面帳票作成入力項目().get発行日()));
                    param.setTsuchiSakiS(通知先市町村リスト.get(ZERO));
                    param.setTsuchiSakiL(通知先市町村リスト.get(ONE));
                    param.setTsuchiMoto1(通知元市町村リスト.get(ZERO));
                    param.setTsuchiMoto2(通知元市町村リスト.get(ONE));
                    param.setIinchoMei1(委員長名リスト.get(ZERO));
                    param.setIinchoMei2(委員長名リスト.get(ONE));
                    param.setHonbun1(本文リスト.get(ZERO));
                    param.setHonbun2(本文リスト.get(ONE));
                    param.setHonbun3(本文リスト.get(TWO));
                    param.setShimei(氏名リスト.get(ZERO));
                    param.setShimei1(氏名リスト.get(ONE));
                    param.setShimei2(氏名リスト.get(TWO));
                    param.setSenkyoShurui(選挙種類);
                    param.setTorokuYmd(notTorokuTsuchiHonnin.get日付編集(param.get在外選挙資格().getMeiboTorokuYMD()));
                    param.setSeibetsuM(性別リスト.get(ZERO));
                    param.setSeibetsuF(性別リスト.get(ONE));
                    param.setSeinengappi(notTorokuTsuchiHonnin.get日付編集(param.get在外選挙人申請情報().get申請情報().getSeinengappiYMD()));
                    param.setMasshoYmd(notTorokuTsuchiHonnin.get日付編集(param.get在外選挙資格().getMasshoYMD()));
                    param.setMasshoRiyu1(抹消理由リスト.get(ZERO));
                    param.setMasshoRiyu2(抹消理由リスト.get(ONE));
                    param.setMasshoRiyu3(抹消理由リスト.get(TWO));
                    param.setMasshoRiyu4(抹消理由リスト.get(THREE));
                }
                for (MasshoTsuchiRyojikanReport report : toReports(masshoTsuchiRyojikanList)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<MasshoTsuchiRyojikanReport> toReports(List<MasshoTsuchiRyojikanParam> targets) {
        List<MasshoTsuchiRyojikanReport> list = new ArrayList<>();
        list.add(new MasshoTsuchiRyojikanReport(targets));
        return list;
    }

    private static RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }

    private int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(KisaijikoHenkoTsuchiRyojikanReportSource.class, itemName);
    }
}
