package jp.co.ndensan.reams.af.afa.business.report.AFAPRB305;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.KisaijikoHenkoTsuchiHonninParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB305.NotTorokuTsuchiRyojikanReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 記載事項変更通知（本人）
 *
 * @reamsid_L AF-0330-030 zhangl
 */
public class KisaijikoHenkoTsuchiHonninReport extends Report<NotTorokuTsuchiRyojikanReportSource> {

    private final List<KisaijikoHenkoTsuchiHonninParam> targets;

    /**
     * コンストラクタです。
     *
     * @param targets List<KisaijikoHenkoTsuchiHonninParam>
     */
    public KisaijikoHenkoTsuchiHonninReport(List<KisaijikoHenkoTsuchiHonninParam> targets) {
        this.targets = targets;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<NotTorokuTsuchiRyojikanReportSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<NotTorokuTsuchiRyojikanReportSource> reportSourceWriter) {
        for (KisaijikoHenkoTsuchiHonninParam target : this.targets) {
            KisaijikoHenkoTsuchiHonninEditor editor = new KisaijikoHenkoTsuchiHonninEditor(target);
            IKisaijikoHenkoTsuchiHonninBuilder builder = new KisaijikoHenkoTsuchiHonninBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
