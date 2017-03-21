package jp.co.ndensan.reams.af.afa.service.report.AFAPRE215;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.AtenaSealListParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE215.AtenaSealListPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE215.AtenaSealListReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE215.AtenaSealListSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 宛名シール出力対象者一覧
 *
 * @reamsid_L AF-0620-034 wangh
 */
public class AtenaSealListPrintService {

    /**
     * 宛名シール出力対象者一覧
     *
     * @param atenaSeal21List List<AtenaSealListParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<AtenaSealListParam> atenaSeal21List) {
        try (ReportManager reportManager = new ReportManager()) {
            AtenaSealListPorperty porperty = new AtenaSealListPorperty();
            try (ReportAssembler<AtenaSealListSource> assembler = ChouhyouCommon.createAssembler(porperty, reportManager)) {
                ReportSourceWriter<AtenaSealListSource> reportSourceWriter = new ReportSourceWriter(assembler);
                for (AtenaSealListReport report : toReports(atenaSeal21List)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<AtenaSealListReport> toReports(List<AtenaSealListParam> targets) {
        List<AtenaSealListReport> list = new ArrayList<>();
        for (AtenaSealListParam target : targets) {
            list.add(new AtenaSealListReport(target));
        }
        return list;
    }

}
