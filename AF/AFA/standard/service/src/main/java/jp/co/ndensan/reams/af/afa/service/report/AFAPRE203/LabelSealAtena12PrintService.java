package jp.co.ndensan.reams.af.afa.service.report.AFAPRE203;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.LabelSealAtena12Param;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE203.LabelSealAtena12Porperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE203.LabelSealAtena12Report;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE203.LabelSealAtena12Source;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * ラベルシール（宛名シール用紙12面）
 *
 * @reamsid_L AF-0620-032 wangh
 */
public class LabelSealAtena12PrintService {

    /**
     * ラベルシール（宛名シール用紙12面）
     *
     * @param labelSealAtena12List List<LabelSealAtena12Param>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<LabelSealAtena12Param> labelSealAtena12List) {
        try (ReportManager reportManager = new ReportManager()) {
            LabelSealAtena12Porperty property = new LabelSealAtena12Porperty();
            try (ReportAssembler<LabelSealAtena12Source> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                ReportSourceWriter<LabelSealAtena12Source> reportSourceWriter = new ReportSourceWriter(assembler);

                for (LabelSealAtena12Report report : toReports(labelSealAtena12List)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<LabelSealAtena12Report> toReports(List<LabelSealAtena12Param> targets) {
        List<LabelSealAtena12Report> list = new ArrayList<>();
        for (LabelSealAtena12Param target : targets) {
            list.add(new LabelSealAtena12Report(target));
        }
        return list;
    }

}
