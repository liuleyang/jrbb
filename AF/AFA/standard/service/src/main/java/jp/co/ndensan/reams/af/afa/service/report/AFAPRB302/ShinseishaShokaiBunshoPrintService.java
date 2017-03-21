package jp.co.ndensan.reams.af.afa.service.report.AFAPRB302;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ShinseishaShokaiBunshoParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB302.ShinseishaShokaiBunshoPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB302.ShinseishaShokaiBunshoReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB302.ShinseishaShokaiBunshoReportSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.af.afa.service.core.MasshoTsuchiHonseki;
import jp.co.ndensan.reams.af.afa.service.core.NotTorokuTsuchiHonnin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;

/**
 * 申請者の被登録資格の照会文書
 *
 * @reamsid_L AF-0320-031 lis2
 */
public class ShinseishaShokaiBunshoPrintService {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int FIVE = 5;
    private static final RString 長さ_通知元市町村名１ = new RString("shokaiMoto1");
    private static final RString 長さ_通知元市町村名２ = new RString("shokaiMoto2");
    private static final RString 長さ_委員長名１ = new RString("iinchoMei1");
    private static final RString 長さ_氏名１ = new RString("shimei3");

    /**
     * 申請者の被登録資格の照会文書
     *
     * @param shinseishaShokaiBunshoList List<ShinseishaShokaiBunshoParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<ShinseishaShokaiBunshoParam> shinseishaShokaiBunshoList) {
        try (ReportManager reportManager = new ReportManager()) {
            ShinseishaShokaiBunshoPorperty property = new ShinseishaShokaiBunshoPorperty();
            try (ReportAssembler<ShinseishaShokaiBunshoReportSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
                Association 地方公共団体情報 = associationFinder.getAssociation();

                ReportSourceWriter<ShinseishaShokaiBunshoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                NotTorokuTsuchiHonnin notTorokuTsuchiHonnin = NotTorokuTsuchiHonnin.createInstance();
                MasshoTsuchiHonseki masshoTsuchiHonseki = MasshoTsuchiHonseki.createInstance();
                for (ShinseishaShokaiBunshoParam param : shinseishaShokaiBunshoList) {
                    ZenkokuJushoCode 全国住所コード = param.get在外選挙人住所情報_本籍().getZenkokuJushoCode();
                    AtenaMeisho 申請者氏名 = param.get在外選挙人申請情報().get申請情報().getShinseishaShimei();
                    RString 全国住所コード_上5桁 = null == 全国住所コード ? RString.EMPTY : 全国住所コード.getColumnValue();
                    if (!RString.isNullOrEmpty(全国住所コード_上5桁)) {
                        全国住所コード_上5桁 = 全国住所コード_上5桁.substring(ZERO, FIVE);
                    }
                    List<RString> 照会元市町村リスト = notTorokuTsuchiHonnin.get通知元市町村１_２(getItemLength(長さ_通知元市町村名１), getItemLength(長さ_通知元市町村名２));
                    List<RString> 委員長名リスト = notTorokuTsuchiHonnin.get委員長名１_２(
                            changeNullToEmpty(param.get画面帳票作成入力項目().get選管委員長名()), getItemLength(長さ_委員長名１));
                    List<RString> 通知先市町村リスト = masshoTsuchiHonseki.get通知先市町村１_２(全国住所コード_上5桁, getItemLength(長さ_通知元市町村名１));
                    List<RString> 氏名リスト = notTorokuTsuchiHonnin.get氏名と氏名１_２(
                            null == 申請者氏名 ? RString.EMPTY : 申請者氏名.getColumnValue(), getItemLength(長さ_氏名１));
                    RString 発行番号 = notTorokuTsuchiHonnin.get発行番号(changeNullToEmpty(param.get画面帳票作成入力項目().get発行番号_第()),
                            changeNullToEmpty(param.get画面帳票作成入力項目().get発行番号_号()), changeNullToEmpty(param.get画面帳票作成入力項目().get発行番号()));
                    RString 選挙種類 = notTorokuTsuchiHonnin.get選挙種類();
                    RString 市区町村区分 = notTorokuTsuchiHonnin.get市区町村区分();

                    param.setYubinNo(masshoTsuchiHonseki.get郵便番号(null == 全国住所コード ? RString.EMPTY : 全国住所コード.getColumnValue()));
                    param.setShokaiSaki(通知先市町村リスト.get(ZERO));
                    param.setShokaiSakiL(通知先市町村リスト.get(ONE));
                    param.setHakkoDaino(発行番号);
                    param.setHakkoYmd(notTorokuTsuchiHonnin.get日付編集(param.get画面帳票作成入力項目().get発行日()));
                    param.setShokaiMoto1(照会元市町村リスト.get(ZERO));
                    param.setShokaiMoto2(照会元市町村リスト.get(ONE));
                    param.setIinchoMei1(委員長名リスト.get(ZERO));
                    param.setIinchoMei2(委員長名リスト.get(ONE));
                    param.setSenkyoShurui(選挙種類);
                    param.setCityKubun(市区町村区分);
                    param.setShimei1(氏名リスト.get(ZERO));
                    param.setShimei2(氏名リスト.get(TWO));
                    param.setShimei3(氏名リスト.get(ONE));
                    param.setSeinengappi(notTorokuTsuchiHonnin.get日付編集(param.get在外選挙人申請情報().get申請情報().getSeinengappiYMD()));
                    param.setSeibetsu(notTorokuTsuchiHonnin.get性別(param.get在外選挙人申請情報().get申請情報().getSeibetsuCode()));
                    param.setSakuseiYmd(notTorokuTsuchiHonnin.get日付編集(new FlexibleDate(RDate.getNowDate().toDateString())));
                    param.set地方公共団体(地方公共団体情報);
                    param.setGengo(notTorokuTsuchiHonnin.get日付編集(new FlexibleDate(RDate.getNowDate().toDateString())));
                }

                for (ShinseishaShokaiBunshoReport report : toReports(shinseishaShokaiBunshoList)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<ShinseishaShokaiBunshoReport> toReports(List<ShinseishaShokaiBunshoParam> targets) {
        List<ShinseishaShokaiBunshoReport> list = new ArrayList<>();
        list.add(new ShinseishaShokaiBunshoReport(targets));
        return list;
    }

    private static RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }

    private int getItemLength(RString itemName) {
        return ReportDataInfoLoader.getMaxLength(ShinseishaShokaiBunshoReportSource.class, itemName);
    }

}
