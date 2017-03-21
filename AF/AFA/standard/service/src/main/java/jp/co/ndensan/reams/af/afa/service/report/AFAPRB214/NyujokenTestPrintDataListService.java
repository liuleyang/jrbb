package jp.co.ndensan.reams.af.afa.service.report.AFAPRB214;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.NyujokenTestPrintDataListParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB214.NyujokenTestPrintDataListPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB214.NyujokenTestPrintDataListReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB214.NyujokenTestPrintDataListSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 入場券テストデータ抽出一覧表
 *
 * @reamsid_L AF-0160-038 wangh
 */
public class NyujokenTestPrintDataListService {

    /**
     * 宛名シール121面
     *
     * @param nyujokenTestPrintDataList List<NyujokenTestPrintDataListParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<NyujokenTestPrintDataListParam> nyujokenTestPrintDataList) {
        try (ReportManager reportManager = new ReportManager()) {
            NyujokenTestPrintDataListPorperty porperty = new NyujokenTestPrintDataListPorperty();
            try (ReportAssembler<NyujokenTestPrintDataListSource> assembler = ChouhyouCommon.createAssembler(porperty, reportManager)) {
                ReportSourceWriter<NyujokenTestPrintDataListSource> reportSourceWriter = new ReportSourceWriter(assembler);
                for (NyujokenTestPrintDataListReport report : toReports(nyujokenTestPrintDataList)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<NyujokenTestPrintDataListReport> toReports(List<NyujokenTestPrintDataListParam> targets) {
        List<NyujokenTestPrintDataListReport> list = new ArrayList<>();
        for (NyujokenTestPrintDataListParam target : targets) {
            list.add(new NyujokenTestPrintDataListReport(target));
        }
        return list;
    }
}
