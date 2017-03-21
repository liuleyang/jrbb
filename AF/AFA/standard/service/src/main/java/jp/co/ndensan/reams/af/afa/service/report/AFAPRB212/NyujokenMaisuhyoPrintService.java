package jp.co.ndensan.reams.af.afa.service.report.AFAPRB212;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.NyujokenMaisuhyoParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB212.NyujokenMaisuhyoPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB212.NyujokenMaisuhyoReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB212.NyujokenMaisuhyoSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 投票所入場券印刷枚数表
 *
 * @reamsid_L AF-0160-036 guyq
 */
public class NyujokenMaisuhyoPrintService {

    /**
     * 投票所入場券印刷枚数表
     *
     * @param nyujokenMaisuhyoList List<NyujokenMaisuhyoParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<NyujokenMaisuhyoParam> nyujokenMaisuhyoList) {
        try (ReportManager reportManager = new ReportManager()) {
            NyujokenMaisuhyoPorperty property = new NyujokenMaisuhyoPorperty();
            try (ReportAssembler<NyujokenMaisuhyoSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                ReportSourceWriter<NyujokenMaisuhyoSource> reportSourceWriter = new ReportSourceWriter(assembler);

                for (NyujokenMaisuhyoReport report : toReports(nyujokenMaisuhyoList, ChouhyouCommon.create帳票共通ヘッダー())) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<NyujokenMaisuhyoReport> toReports(List<NyujokenMaisuhyoParam> targets, TeijiCommonJohoItem 帳票共通ヘッダー) {
        List<NyujokenMaisuhyoReport> list = new ArrayList<>();
        for (NyujokenMaisuhyoParam target : targets) {
            list.add(new NyujokenMaisuhyoReport(target, 帳票共通ヘッダー));
        }
        return list;
    }
}
