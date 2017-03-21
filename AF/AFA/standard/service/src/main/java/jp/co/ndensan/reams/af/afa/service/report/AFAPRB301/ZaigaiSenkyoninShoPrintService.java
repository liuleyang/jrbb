package jp.co.ndensan.reams.af.afa.service.report.AFAPRB301;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoninShoParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB301.ZaigaiSenkyoninShoPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB301.ZaigaiSenkyoninShoReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB301.ZaigaiSenkyoninShoReportSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.af.afa.service.core.NotTorokuTsuchiHonnin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 在外選挙人証
 *
 * @reamsid_L AF-0320-030 lis2
 */
public class ZaigaiSenkyoninShoPrintService {

    private final RString 全角スペース = new RString("　");

    /**
     * 在外選挙人証
     *
     * @param zaigaiSenkyoninShoList List<ZaigaiSenkyoninShoParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<ZaigaiSenkyoninShoParam> zaigaiSenkyoninShoList) {
        try (ReportManager reportManager = new ReportManager()) {
            ZaigaiSenkyoninShoPorperty property = new ZaigaiSenkyoninShoPorperty();
            try (ReportAssembler<ZaigaiSenkyoninShoReportSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
                Association 地方公共団体 = associationFinder.getAssociation();
                ReportSourceWriter<ZaigaiSenkyoninShoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);

                NotTorokuTsuchiHonnin notTorokuTsuchiHonnin = NotTorokuTsuchiHonnin.createInstance();
                for (ZaigaiSenkyoninShoParam param : zaigaiSenkyoninShoList) {
                    param.setKofuNo(param.get在外選挙資格().getKofuNo());
                    AtenaMeisho 申請者氏名 = param.get在外選挙人申請情報().get申請情報().getShinseishaShimei();
                    param.setShimei(null == 申請者氏名 ? RString.EMPTY : 申請者氏名.getColumnValue());
                    param.setYukoKikanStart1(notTorokuTsuchiHonnin.get日付編集(param.get在外選挙人申請情報().get申請情報().getSeinengappiYMD()));
                    param.setSeibetsu(notTorokuTsuchiHonnin.get性別(param.get在外選挙人申請情報().get申請情報().getSeibetsuCode()));
                    param.setYukoKikanEnd(notTorokuTsuchiHonnin.get日付編集(param.get在外選挙資格().getMeiboTorokuYMD()));
                    param.setSenkyoMei(param.get選挙情報().getSenkyokuName());
                    AtenaJusho 最終住所 = param.get在外選挙人住所情報_最終住所().getJusho();
                    AtenaBanchi 番地 = param.get在外選挙人住所情報_最終住所().getBanchi();
                    Katagaki 方書 = param.get在外選挙人住所情報_最終住所().getKatagaki();
                    param.setJusho(changeNullToEmpty(null == 最終住所 ? RString.EMPTY : 最終住所.getColumnValue())
                            .concat(changeNullToEmpty(null == 番地 ? RString.EMPTY : 番地.getColumnValue()))
                            .concat(全角スペース)
                            .concat(changeNullToEmpty(null == 方書 ? RString.EMPTY : 方書.getColumnValue())));
                    AtenaJusho 海外送付先住所 = param.get在外選挙人住所情報_海外送付先住所().getJusho();
                    param.setSofusaki(null == 海外送付先住所 ? RString.EMPTY : 海外送付先住所.getColumnValue());
                    param.setShuruiTitle(notTorokuTsuchiHonnin.get選挙種類());
                    param.setHakkoYmd(notTorokuTsuchiHonnin.get日付編集(FlexibleDate.getNowDate()));
                    param.setShichosonMei(changeNullToEmpty(地方公共団体.get都道府県名())
                            .concat(changeNullToEmpty(地方公共団体.get郡名()))
                            .concat(changeNullToEmpty(地方公共団体.get市町村名())));
                }
                for (ZaigaiSenkyoninShoReport report : toReports(zaigaiSenkyoninShoList)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<ZaigaiSenkyoninShoReport> toReports(List<ZaigaiSenkyoninShoParam> targets) {
        List<ZaigaiSenkyoninShoReport> list = new ArrayList<>();
        list.add(new ZaigaiSenkyoninShoReport(targets));
        return list;
    }

    private RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }
}
