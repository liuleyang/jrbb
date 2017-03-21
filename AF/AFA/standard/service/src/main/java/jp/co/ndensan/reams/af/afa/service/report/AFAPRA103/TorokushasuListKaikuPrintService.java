package jp.co.ndensan.reams.af.afa.service.report.AFAPRA103;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.TorokushasuListKaikuParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA103.TorokushasuListKaikuPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA103.TorokushasuListKaikuReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA103.TorokushasuListSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 登録者数リスト（海区選挙）
 *
 * @reamsid_L AF-0460-033 wanghj
 */
public class TorokushasuListKaikuPrintService {

    /**
     * 申請書チェックリスト
     *
     * @param shisetsuSofushoList List<TorokushasuListKaikuParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<TorokushasuListKaikuParam> shisetsuSofushoList) {
        try (ReportManager reportManager = new ReportManager()) {
            TorokushasuListKaikuPorperty property = new TorokushasuListKaikuPorperty();
            try (ReportAssembler<TorokushasuListSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                ReportSourceWriter<TorokushasuListSource> reportSourceWriter = new ReportSourceWriter(assembler);

                for (TorokushasuListKaikuReport report : toReports(shisetsuSofushoList, ChouhyouCommon.create帳票共通ヘッダー())) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<TorokushasuListKaikuReport> toReports(List<TorokushasuListKaikuParam> targets, TeijiCommonJohoItem 帳票共通ヘッダー) {
        List<TorokushasuListKaikuReport> list = new ArrayList<>();
        for (TorokushasuListKaikuParam target : targets) {
            list.add(new TorokushasuListKaikuReport(target, 帳票共通ヘッダー));
        }
        return list;
    }
}
