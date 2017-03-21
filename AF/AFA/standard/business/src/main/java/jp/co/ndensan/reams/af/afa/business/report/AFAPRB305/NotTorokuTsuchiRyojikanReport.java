package jp.co.ndensan.reams.af.afa.business.report.AFAPRB305;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.NotTorokuTsuchiRyojikanParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB305.NotTorokuTsuchiRyojikanReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 登録を行わなかった旨の通知（領事官）
 *
 * @reamsid_L AF-0320-034 lis2
 */
public class NotTorokuTsuchiRyojikanReport extends Report<NotTorokuTsuchiRyojikanReportSource> {

    private final List<NotTorokuTsuchiRyojikanParam> targets;

    /**
     * コンストラクタです。
     *
     * @param targets List<NotTorokuTsuchiRyojikanParam>
     */
    public NotTorokuTsuchiRyojikanReport(List<NotTorokuTsuchiRyojikanParam> targets) {
        this.targets = targets;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<NotTorokuTsuchiRyojikanReportSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<NotTorokuTsuchiRyojikanReportSource> reportSourceWriter) {
        for (NotTorokuTsuchiRyojikanParam target : this.targets) {
            NotTorokuTsuchiRyojikanEditor editor = new NotTorokuTsuchiRyojikanEditor(target);
            INotTorokuTsuchiRyojikanBuilder builder = new NotTorokuTsuchiRyojikanBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
