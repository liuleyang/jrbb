package jp.co.ndensan.reams.af.afa.service.report.AFAPRB213;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.NninIjoSetaiListParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB213.NninIjoSetaiListPorperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB213.NninIjoSetaiListReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB213.NninIjoSetaiListSource;
import jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * n人以上世帯一覧表
 *
 * @reamsid_L AF-0160-037 wangh
 */
public class NninIjoSetaiListPrintService {

    /**
     * n人以上世帯一覧表
     *
     * @param nninIjoSetaiList List<NninIjoSetaiListParam>
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<NninIjoSetaiListParam> nninIjoSetaiList) {
        try (ReportManager reportManager = new ReportManager()) {
            NninIjoSetaiListPorperty property = new NninIjoSetaiListPorperty();
            try (ReportAssembler<NninIjoSetaiListSource> assembler = ChouhyouCommon.createAssembler(property, reportManager)) {
                ReportSourceWriter<NninIjoSetaiListSource> reportSourceWriter = new ReportSourceWriter(assembler);

                for (NninIjoSetaiListReport report : toReports(nninIjoSetaiList, ChouhyouCommon.create帳票共通ヘッダー())) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<NninIjoSetaiListReport> toReports(List<NninIjoSetaiListParam> targets, TeijiCommonJohoItem 帳票共通ヘッダー) {
        List<NninIjoSetaiListReport> list = new ArrayList<>();
        for (NninIjoSetaiListParam target : targets) {
            list.add(new NninIjoSetaiListReport(target, 帳票共通ヘッダー));
        }
        return list;
    }

}
