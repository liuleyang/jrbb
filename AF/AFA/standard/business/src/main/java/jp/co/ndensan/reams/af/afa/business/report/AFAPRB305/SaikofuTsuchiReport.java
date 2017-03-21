package jp.co.ndensan.reams.af.afa.business.report.AFAPRB305;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.SaikofuTsuchiParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB305.NotTorokuTsuchiRyojikanReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 再交付通知
 *
 * @reamsid_L AF-0340-020 liuj2
 */
public class SaikofuTsuchiReport extends Report<NotTorokuTsuchiRyojikanReportSource> {

    private final List<SaikofuTsuchiParam> targets;

    /**
     * コンストラクタです。
     *
     * @param targets List<SaikofuTsuchiParam>
     */
    public SaikofuTsuchiReport(List<SaikofuTsuchiParam> targets) {
        this.targets = targets;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<NotTorokuTsuchiRyojikanReportSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<NotTorokuTsuchiRyojikanReportSource> reportSourceWriter) {
        for (SaikofuTsuchiParam target : this.targets) {
            SaikofuTsuchiEditor editor = new SaikofuTsuchiEditor(target);
            ISaikofuTsuchiBuilder builder = new SaikofuTsuchiBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
