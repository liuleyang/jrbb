package jp.co.ndensan.reams.af.afa.service.report.AFAPRC202;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.SenkyoninMeiboTorokuShomeishoParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRC202.SenkyoninMeiboTorokuShomeishoPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRC202.SenkyoninMeiboTorokuShomeishoReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRC202.SenkyoninMeiboTorokuShomeishoReportSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 選挙人名簿登録証明書
 *
 * @reamsid_L AF-0210-020 lis2
 */
public class SenkyoninMeiboTorokuShomeishoPrintService {

    /**
     * 選挙人名簿登録証明書
     *
     * @param list List<SenkyoninMeiboTorokuShomeishoParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<SenkyoninMeiboTorokuShomeishoParam> list) {
        try (ReportManager reportManager = new ReportManager()) {
            SenkyoninMeiboTorokuShomeishoPorperty property = new SenkyoninMeiboTorokuShomeishoPorperty();
            try (ReportAssembler<SenkyoninMeiboTorokuShomeishoReportSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
                Association 地方公共団体 = associationFinder.getAssociation();

                ReportSourceWriter<SenkyoninMeiboTorokuShomeishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);

                for (SenkyoninMeiboTorokuShomeishoParam yubinTohyoShomeisho : list) {
                    yubinTohyoShomeisho.set地方公共団体(地方公共団体);
                }
                for (SenkyoninMeiboTorokuShomeishoReport report : toReports(list)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<SenkyoninMeiboTorokuShomeishoReport> toReports(List<SenkyoninMeiboTorokuShomeishoParam> targets) {
        List<SenkyoninMeiboTorokuShomeishoReport> list = new ArrayList<>();
        list.add(new SenkyoninMeiboTorokuShomeishoReport(targets));
        return list;
    }
}
