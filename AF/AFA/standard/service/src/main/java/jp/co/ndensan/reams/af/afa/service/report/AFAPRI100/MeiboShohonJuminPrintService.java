package jp.co.ndensan.reams.af.afa.service.report.AFAPRI100;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.MeiboShohonJuminParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRI100.MeiboShohonJuminPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRI100.MeiboShohonJuminReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRI100.MeiboShohonJuminSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 住民投票時登録
 *
 * @reamsid_L AF-0450-030 lis
 */
public class MeiboShohonJuminPrintService {

    /**
     * 住民投票時登録
     *
     * @param meiboShohonJuminList List<MeiboShohonJuminParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<MeiboShohonJuminParam> meiboShohonJuminList) {
        try (ReportManager reportManager = new ReportManager()) {
            MeiboShohonJuminPorperty property = new MeiboShohonJuminPorperty();
            try (ReportAssembler<MeiboShohonJuminSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                ReportSourceWriter<MeiboShohonJuminSource> reportSourceWriter = new ReportSourceWriter(assembler);

                for (MeiboShohonJuminReport report : toReports(meiboShohonJuminList)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<MeiboShohonJuminReport> toReports(List<MeiboShohonJuminParam> targets) {
        List<MeiboShohonJuminReport> list = new ArrayList<>();
        for (MeiboShohonJuminParam param : targets) {
            list.add(new MeiboShohonJuminReport(param));
        }
        return list;
    }
}
