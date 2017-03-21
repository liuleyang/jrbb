package jp.co.ndensan.reams.af.afa.service.report.AFAPRK101;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ShinseishoCheckListKaikuParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRK101.ShinseishoCheckListKaikuPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRK101.ShinseishoCheckListKaikuReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRK101.ShinseishoCheckListKaikuSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 申請書チェックリスト
 *
 * @reamsid_L AF-0460-032 wanghj
 */
public class ShinseishoCheckListKaikuPrintService {

    /**
     * 申請書チェックリスト
     *
     * @param shisetsuSofushoList List<ShinseishoCheckListKaikuParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<ShinseishoCheckListKaikuParam> shisetsuSofushoList) {
        try (ReportManager reportManager = new ReportManager()) {
            ShinseishoCheckListKaikuPorperty property = new ShinseishoCheckListKaikuPorperty();
            try (ReportAssembler<ShinseishoCheckListKaikuSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                ReportSourceWriter<ShinseishoCheckListKaikuSource> reportSourceWriter = new ReportSourceWriter(assembler);

                for (ShinseishoCheckListKaikuReport report : toReports(shisetsuSofushoList, ChouhyouCommon.create帳票共通ヘッダー())) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<ShinseishoCheckListKaikuReport> toReports(List<ShinseishoCheckListKaikuParam> targets, TeijiCommonJohoItem 帳票共通ヘッダー) {
        List<ShinseishoCheckListKaikuReport> list = new ArrayList<>();
        for (ShinseishoCheckListKaikuParam target : targets) {
            list.add(new ShinseishoCheckListKaikuReport(target, 帳票共通ヘッダー));
        }
        return list;
    }
}
