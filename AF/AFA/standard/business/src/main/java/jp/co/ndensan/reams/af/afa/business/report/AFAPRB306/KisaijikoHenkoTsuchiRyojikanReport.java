package jp.co.ndensan.reams.af.afa.business.report.AFAPRB306;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.KisaijikoHenkoTsuchiRyojikanParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB306.KisaijikoHenkoTsuchiRyojikanReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 記載事項変更通知（領事官）
 *
 * @reamsid_L AF-0330-031 zhangl
 */
public class KisaijikoHenkoTsuchiRyojikanReport extends Report<KisaijikoHenkoTsuchiRyojikanReportSource> {

    private final List<KisaijikoHenkoTsuchiRyojikanParam> targets;

    /**
     * コンストラクタです。
     *
     * @param targets List<KisaijikoHenkoTsuchiRyojikanParam>
     */
    public KisaijikoHenkoTsuchiRyojikanReport(List<KisaijikoHenkoTsuchiRyojikanParam> targets) {
        this.targets = targets;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<KisaijikoHenkoTsuchiRyojikanReportSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<KisaijikoHenkoTsuchiRyojikanReportSource> reportSourceWriter) {
        for (KisaijikoHenkoTsuchiRyojikanParam target : this.targets) {
            KisaijikoHenkoTsuchiRyojikanEditor editor = new KisaijikoHenkoTsuchiRyojikanEditor(target);
            IKisaijikoHenkoTsuchiRyojikanBuilder builder = new KisaijikoHenkoTsuchiRyojikanBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
