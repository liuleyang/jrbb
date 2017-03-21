package jp.co.ndensan.reams.af.afa.service.report.AFAPRC203;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.NankyokuSenkyoninShomeishoParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRC203.NankyokuSenkyoninShomeishoPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRC203.NankyokuSenkyoninShomeishoReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRC203.NankyokuSenkyoninShomeishoReportSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 南極選挙人証
 *
 * @reamsid_L AF-0220-020 lis2
 */
public class NankyokuSenkyoninShomeishoPrintService {

    /**
     * 南極選挙人証
     *
     * @param nankyokuSenkyoninShomeishoList List<NankyokuSenkyoninShomeishoParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<NankyokuSenkyoninShomeishoParam> nankyokuSenkyoninShomeishoList) {
        try (ReportManager reportManager = new ReportManager()) {
            NankyokuSenkyoninShomeishoPorperty property = new NankyokuSenkyoninShomeishoPorperty();
            try (ReportAssembler<NankyokuSenkyoninShomeishoReportSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
                Association 地方公共団体 = associationFinder.getAssociation();

                ReportSourceWriter<NankyokuSenkyoninShomeishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);

                for (NankyokuSenkyoninShomeishoParam yubinTohyoShomeisho : nankyokuSenkyoninShomeishoList) {
                    yubinTohyoShomeisho.set地方公共団体(地方公共団体);
                }
                for (NankyokuSenkyoninShomeishoReport report : toReports(nankyokuSenkyoninShomeishoList)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<NankyokuSenkyoninShomeishoReport> toReports(List<NankyokuSenkyoninShomeishoParam> targets) {
        List<NankyokuSenkyoninShomeishoReport> list = new ArrayList<>();
        list.add(new NankyokuSenkyoninShomeishoReport(targets));
        return list;
    }

}
