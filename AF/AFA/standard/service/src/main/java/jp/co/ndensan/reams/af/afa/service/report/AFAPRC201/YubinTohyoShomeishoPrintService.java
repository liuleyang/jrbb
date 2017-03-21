package jp.co.ndensan.reams.af.afa.service.report.AFAPRC201;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.YubinTohyoShomeishoParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRC201.YubinTohyoShomeishoPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRC201.YubinTohyoShomeishoReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRC201.YubinTohyoShomeishoReportSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 郵便等投票証明書
 *
 * @reamsid_L AF-0200-030 lis2
 */
public class YubinTohyoShomeishoPrintService {

    /**
     * 郵便等投票証明書
     *
     * @param yubinTohyoShomeishoList List<YubinTohyoShomeishoParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<YubinTohyoShomeishoParam> yubinTohyoShomeishoList) {
        try (ReportManager reportManager = new ReportManager()) {
            YubinTohyoShomeishoPorperty property = new YubinTohyoShomeishoPorperty();
            try (ReportAssembler<YubinTohyoShomeishoReportSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
                Association 地方公共団体 = associationFinder.getAssociation();

                ReportSourceWriter<YubinTohyoShomeishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);

                for (YubinTohyoShomeishoParam yubinTohyoShomeisho : yubinTohyoShomeishoList) {
                    yubinTohyoShomeisho.set地方公共団体(地方公共団体);
                }
                for (YubinTohyoShomeishoReport report : toReports(yubinTohyoShomeishoList)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<YubinTohyoShomeishoReport> toReports(List<YubinTohyoShomeishoParam> targets) {
        List<YubinTohyoShomeishoReport> list = new ArrayList<>();
        list.add(new YubinTohyoShomeishoReport(targets));
        return list;
    }
}
