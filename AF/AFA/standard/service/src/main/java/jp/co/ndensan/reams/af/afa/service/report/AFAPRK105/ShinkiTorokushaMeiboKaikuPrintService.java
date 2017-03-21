package jp.co.ndensan.reams.af.afa.service.report.AFAPRK105;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ShinkiTorokushaMeiboKaikuParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRK105.ShinkiTorokushaMeiboKaikuPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRK105.ShinkiTorokushaMeiboKaikuReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRK105.ShinkiTorokushaMeiboKaikuSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 新規登録者名簿
 *
 * @reamsid_L AF-0460-034 wanghj
 */
public class ShinkiTorokushaMeiboKaikuPrintService {

    /**
     * 新規登録者名簿
     *
     * @param shisetsuSofushoList List<ShinkiTorokushaMeiboKaikuParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<ShinkiTorokushaMeiboKaikuParam> shisetsuSofushoList) {
        try (ReportManager reportManager = new ReportManager()) {
            ShinkiTorokushaMeiboKaikuPorperty property = new ShinkiTorokushaMeiboKaikuPorperty();
            try (ReportAssembler<ShinkiTorokushaMeiboKaikuSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                ReportSourceWriter<ShinkiTorokushaMeiboKaikuSource> reportSourceWriter = new ReportSourceWriter(assembler);

                for (ShinkiTorokushaMeiboKaikuReport report : toReports(shisetsuSofushoList, ChouhyouCommon.create帳票共通ヘッダー())) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<ShinkiTorokushaMeiboKaikuReport> toReports(List<ShinkiTorokushaMeiboKaikuParam> targets, TeijiCommonJohoItem 帳票共通ヘッダー) {
        List<ShinkiTorokushaMeiboKaikuReport> list = new ArrayList<>();
        for (ShinkiTorokushaMeiboKaikuParam target : targets) {
            list.add(new ShinkiTorokushaMeiboKaikuReport(target, 帳票共通ヘッダー));
        }
        return list;
    }

}
