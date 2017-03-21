package jp.co.ndensan.reams.af.afa.service.report.AFAPRE214;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.AtenaSeal21Param;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE214.AtenaSeal21Porperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE214.AtenaSeal21Report;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE214.AtenaSeal21Source;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 宛名シール21面
 *
 * @reamsid_L AF-0620-033 wangh
 */
public class AtenaSeal21PrintService {

    /**
     * 宛名シール21面
     *
     * @param atenaSeal21List List<AtenaSeal21Param>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<AtenaSeal21Param> atenaSeal21List) {
        try (ReportManager reportManager = new ReportManager()) {
            AtenaSeal21Porperty porperty = new AtenaSeal21Porperty();
            try (ReportAssembler<AtenaSeal21Source> assembler = ChouhyouCommon.createAssembler(porperty, reportManager)) {
                ReportSourceWriter<AtenaSeal21Source> reportSourceWriter = new ReportSourceWriter(assembler);
                for (AtenaSeal21Report report : toReports(atenaSeal21List)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }

    }

    private static List<AtenaSeal21Report> toReports(List<AtenaSeal21Param> targets) {
        List<AtenaSeal21Report> list = new ArrayList<>();
        for (AtenaSeal21Param target : targets) {
            list.add(new AtenaSeal21Report(target));
        }
        return list;
    }

}
