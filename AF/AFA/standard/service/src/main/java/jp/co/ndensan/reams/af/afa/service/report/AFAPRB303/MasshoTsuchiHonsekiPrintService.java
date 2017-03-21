/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.report.AFAPRB303;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.MasshoTsuchiHonsekiParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB303.MasshoTsuchiHonsekiPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB303.MasshoTsuchiHonsekiReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB303.TorokuTsuchiReportSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.af.afa.service.core.KisaijikoHenkoTsuchiHonnin;
import jp.co.ndensan.reams.af.afa.service.core.MasshoTsuchiHonseki;
import jp.co.ndensan.reams.af.afa.service.core.NotTorokuTsuchiHonnin;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;

/**
 * 抹消通知（本籍地）
 *
 * @reamsid_L AF-0350-030 wangh
 */
public class MasshoTsuchiHonsekiPrintService {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final FlexibleDate DATE = FlexibleDate.EMPTY;
    private static final RString コード種別 = new RString("0036");
    private static final RString EMPTY = new RString("");
    private static final RString 長さ_本文1 = new RString("honbun1");
    private static final RString 長さ_委員長名１ = new RString("iinchoMei1");
    private static final RString 長さ_通知先市町村名1 = new RString("tsuchiSaki");
    private static final RString 長さ_通知元市町村名1 = new RString("tsuchiMoto1");
    private static final RString 長さ_通知元市町村名2 = new RString("tsuchiMoto2");
    private static final RString 長さ_本籍1 = new RString("honseki1");
    private static final RString 長さ_本籍2 = new RString("honseki2");
    private static final RString 長さ_本籍3 = new RString("honseki3");
    private static final RString 長さ_氏名 = new RString("shimei");
    private static final RString 長さ_氏名1 = new RString("shimei1");
    private static final RString 長さ_氏名2 = new RString("shimei2");
    private static final RString 長さ_氏名3 = new RString("shimei3");

    /**
     * 抹消通知（本籍地）
     *
     * @param masshoTsuchiHonsekiList List<MasshoTsuchiHonsekiParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<MasshoTsuchiHonsekiParam> masshoTsuchiHonsekiList) {
        try (ReportManager reportManager = new ReportManager()) {
            MasshoTsuchiHonsekiPorperty property = new MasshoTsuchiHonsekiPorperty();
            try (ReportAssembler<TorokuTsuchiReportSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {

                ReportSourceWriter<TorokuTsuchiReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                NotTorokuTsuchiHonnin notTorokuTsuchiHonnin = NotTorokuTsuchiHonnin.createInstance();
                MasshoTsuchiHonseki masshoTsuchiHonseki = MasshoTsuchiHonseki.createInstance();
                KisaijikoHenkoTsuchiHonnin kisaijikoHenkoTsuchiHonnin = KisaijikoHenkoTsuchiHonnin.createInstance();
                for (MasshoTsuchiHonsekiParam param : masshoTsuchiHonsekiList) {
                    ZenkokuJushoCode 全国住所コード = param.get在外選挙人住所情報_本籍().getZenkokuJushoCode();
                    RString 全国住所コード_上5桁 = null == 全国住所コード ? RString.EMPTY : 全国住所コード.getColumnValue();
                    AtenaBanchi 番地 = param.get在外選挙人住所情報_本籍().getBanchi();
                    AtenaJusho 住所 = param.get在外選挙人住所情報_本籍().getJusho();
                    if (!RString.isNullOrEmpty(全国住所コード_上5桁)) {
                        全国住所コード_上5桁 = 全国住所コード_上5桁.substring(ZERO, FIVE);
                    }
                    RString 発行番号 = notTorokuTsuchiHonnin.get発行番号(changeNullToEmpty(param.get画面帳票作成入力項目().get発行番号_第()),
                            changeNullToEmpty(param.get画面帳票作成入力項目().get発行番号_号()), changeNullToEmpty(param.get画面帳票作成入力項目().get発行番号()));
                    AtenaMeisho 漢字氏名 = param.get在外選挙人申請情報().get申請情報().getShinseishaShimei();
                    List<RString> 通知先市町村リスト = masshoTsuchiHonseki.get通知先市町村１_２(全国住所コード_上5桁, getItemLength(長さ_通知先市町村名1));
                    List<RString> 通知元市町村リスト = notTorokuTsuchiHonnin.get通知元市町村１_２(getItemLength(長さ_通知元市町村名1), getItemLength(長さ_通知元市町村名2));
                    List<RString> 委員長名リスト = notTorokuTsuchiHonnin.get委員長名１_２(changeNullToEmpty(param.get画面帳票作成入力項目().get選管委員長名()),
                            getItemLength(長さ_委員長名１));
                    List<RString> 氏名リスト = masshoTsuchiHonseki.get氏名と氏名１_４(null == 漢字氏名 ? RString.EMPTY : 漢字氏名.getColumnValue(),
                            getItemLength(長さ_氏名), getItemLength(長さ_氏名1), getItemLength(長さ_氏名2), getItemLength(長さ_氏名3));
                    List<RString> 本文リスト = notTorokuTsuchiHonnin.get本文(new CodeShubetsu(コード種別),
                            getItemLength(長さ_本文1), ZERO, ZERO, ZERO, ZERO, DATE, EMPTY);
                    List<RString> 性別リスト = kisaijikoHenkoTsuchiHonnin.get性別１_２(param.get在外選挙人申請情報().get申請情報().getSeibetsuCode());
                    List<RString> 本籍リスト = masshoTsuchiHonseki.get本籍１_４(null == 住所 ? RString.EMPTY : 住所.getColumnValue(),
                            null == 番地 ? RString.EMPTY : 番地.getColumnValue(), getItemLength(長さ_本籍1), getItemLength(長さ_本籍2), getItemLength(長さ_本籍3));

                    param.setYubinNo(masshoTsuchiHonseki.get郵便番号(null == 全国住所コード ? RString.EMPTY : 全国住所コード.getColumnValue()));
                    param.setHakkoDaino(発行番号);
                    param.setTsuchiSaki(通知先市町村リスト.get(ZERO));
                    param.setTsuchiSakiL(通知先市町村リスト.get(ONE));
                    param.setTsuchiMoto1(通知元市町村リスト.get(ZERO));
                    param.setTsuchiMoto2(通知元市町村リスト.get(ONE));
                    param.setHakkoYmd(notTorokuTsuchiHonnin.get日付編集(param.get画面帳票作成入力項目().get発行日()));
                    param.setSeibetsuM(性別リスト.get(ZERO));
                    param.setSeibetsuF(性別リスト.get(ONE));
                    param.setIinchoMei1(委員長名リスト.get(ZERO));
                    param.setIinchoMei2(委員長名リスト.get(ONE));
                    param.setHonbun1(本文リスト.get(ZERO));
                    param.setHonbun2(本文リスト.get(ONE));
                    param.setHonseki1(本籍リスト.get(ZERO));
                    param.setHonseki2(本籍リスト.get(ONE));
                    param.setHonseki3(本籍リスト.get(TWO));
                    param.setHonseki4(本籍リスト.get(THREE));
                    param.setShimei(氏名リスト.get(ZERO));
                    param.setShimei1(氏名リスト.get(ONE));
                    param.setShimei2(氏名リスト.get(TWO));
                    param.setShimei3(氏名リスト.get(THREE));
                    param.setShimei4(氏名リスト.get(FOUR));
                    param.setSeinengappi(notTorokuTsuchiHonnin.get日付編集(param.get在外選挙人申請情報().get申請情報().getSeinengappiYMD()));
                    param.setTorokuYmd(notTorokuTsuchiHonnin.get日付編集(param.get在外選挙資格().getMasshoYMD()));
                }

                for (MasshoTsuchiHonsekiReport report : toReports(masshoTsuchiHonsekiList)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<MasshoTsuchiHonsekiReport> toReports(List<MasshoTsuchiHonsekiParam> targets) {
        List<MasshoTsuchiHonsekiReport> list = new ArrayList<>();
        list.add(new MasshoTsuchiHonsekiReport(targets));
        return list;
    }

    private static RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }

    private int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(TorokuTsuchiReportSource.class, itemName);
    }
}
