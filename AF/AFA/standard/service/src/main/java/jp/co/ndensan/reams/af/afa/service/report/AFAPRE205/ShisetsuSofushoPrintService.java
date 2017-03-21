package jp.co.ndensan.reams.af.afa.service.report.AFAPRE205;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ShisetsuSofushoParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE205.ShisetsuSofushoPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE205.ShisetsuSofushoReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE205.ShisetsuSofushoSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 施設送付書
 *
 * @reamsid_L AF-0250-030 jihb
 */
public class ShisetsuSofushoPrintService {

    /**
     * 施設送付書
     *
     * @param shisetsuSofushoList List<ShisetsuSofushoParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<ShisetsuSofushoParam> shisetsuSofushoList) {
        try (ReportManager reportManager = new ReportManager()) {
            ShisetsuSofushoPorperty property = new ShisetsuSofushoPorperty();
            try (ReportAssembler<ShisetsuSofushoSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                ReportSourceWriter<ShisetsuSofushoSource> reportSourceWriter = new ReportSourceWriter(assembler);

                IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
                Association 地方公共団体情報 = associationFinder.getAssociation();
                for (ShisetsuSofushoParam shisetsuSofusho : shisetsuSofushoList) {
                    shisetsuSofusho.set地方公共団体情報(地方公共団体情報);
                }
                for (ShisetsuSofushoReport report : toReports(shisetsuSofushoList)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<ShisetsuSofushoReport> toReports(List<ShisetsuSofushoParam> targets) {
        List<ShisetsuSofushoReport> list = new ArrayList<>();
        for (ShisetsuSofushoParam target : targets) {
            list.add(new ShisetsuSofushoReport(target));
        }
        return list;
    }

}
