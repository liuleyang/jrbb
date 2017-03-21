package jp.co.ndensan.reams.af.afa.service.report.AFAPRL100;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.MeiboShohonZaisankuParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRL100.MeiboShohonZaisankuPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRL100.MeiboShohonZaisankuReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRL100.MeiboShohonZaisankuSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 財産区選挙人名簿抄本
 *
 * @reamsid_L AF-0600-030 lis
 */
public class MeiboShohonZaisankuPrintService {

    /**
     * 宛名シール21面
     *
     * @param meiboShohonZaisankuList List<MeiboShohonZaisankuParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<MeiboShohonZaisankuParam> meiboShohonZaisankuList) {
        try (ReportManager reportManager = new ReportManager()) {
            MeiboShohonZaisankuPorperty porperty = new MeiboShohonZaisankuPorperty();
            try (ReportAssembler<MeiboShohonZaisankuSource> assembler = ChouhyouCommon.createAssembler(porperty, reportManager)) {
                ReportSourceWriter<MeiboShohonZaisankuSource> reportSourceWriter = new ReportSourceWriter(assembler);
                for (MeiboShohonZaisankuReport report : toReports(meiboShohonZaisankuList)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }

    }

    private static List<MeiboShohonZaisankuReport> toReports(List<MeiboShohonZaisankuParam> targets) {
        List<MeiboShohonZaisankuReport> list = new ArrayList<>();
        for (MeiboShohonZaisankuParam target : targets) {
            list.add(new MeiboShohonZaisankuReport(target));
        }
        return list;
    }
}
