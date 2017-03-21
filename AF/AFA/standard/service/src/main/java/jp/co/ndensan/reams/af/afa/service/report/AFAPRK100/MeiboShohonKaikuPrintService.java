package jp.co.ndensan.reams.af.afa.service.report.AFAPRK100;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.MeiboShohonKaikuParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRK100.MeiboShohonKaikuPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRK100.MeiboShohonKaikuReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRK100.MeiboShohonKaikuSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 海区漁業調整委員会委員選挙人名簿抄本
 *
 * @reamsid_L AF-0460-031 wanghj
 */
public class MeiboShohonKaikuPrintService {

    /**
     * 海区漁業調整委員会委員選挙人名簿抄本
     *
     * @param shisetsuSofushoList List<MeiboShohonKaikuParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<MeiboShohonKaikuParam> shisetsuSofushoList) {
        try (ReportManager reportManager = new ReportManager()) {
            MeiboShohonKaikuPorperty property = new MeiboShohonKaikuPorperty();
            try (ReportAssembler<MeiboShohonKaikuSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                ReportSourceWriter<MeiboShohonKaikuSource> reportSourceWriter = new ReportSourceWriter(assembler);

                for (MeiboShohonKaikuReport report : toReports(shisetsuSofushoList)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<MeiboShohonKaikuReport> toReports(List<MeiboShohonKaikuParam> targets) {
        List<MeiboShohonKaikuReport> list = new ArrayList<>();
        for (MeiboShohonKaikuParam target : targets) {
            list.add(new MeiboShohonKaikuReport(target));
        }
        return list;
    }

}
