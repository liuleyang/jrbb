package jp.co.ndensan.reams.af.afa.service.report.AFAPRE204;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.LabelSealAtena21Param;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE204.LabelSealAtena21Porperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE204.LabelSealAtena21Report;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE204.LabelSealAtena21Source;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * ラベルシール（宛名シール用紙21面）
 *
 * @reamsid_L AF-0620-031 wangh
 */
public class LabelSealAtena21PrintService {

    /**
     * ラベルシール（宛名シール用紙21面）
     *
     * @param labelSealAtena21List List<LabelSealAtena21Param>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<LabelSealAtena21Param> labelSealAtena21List) {
        try (ReportManager reportManager = new ReportManager()) {
            LabelSealAtena21Porperty property = new LabelSealAtena21Porperty();
            try (ReportAssembler<LabelSealAtena21Source> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                ReportSourceWriter<LabelSealAtena21Source> reportSourceWriter = new ReportSourceWriter(assembler);

                for (LabelSealAtena21Report report : toReports(labelSealAtena21List)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<LabelSealAtena21Report> toReports(List<LabelSealAtena21Param> targets) {
        List<LabelSealAtena21Report> list = new ArrayList<>();
        for (LabelSealAtena21Param target : targets) {
            list.add(new LabelSealAtena21Report(target));
        }
        return list;
    }
}
