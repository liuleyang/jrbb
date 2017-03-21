package jp.co.ndensan.reams.af.afa.business.report.AFAPRB304;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.NotTorokuTsuchiHonninParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB304.NotTorokuTsuchiHonninReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 登録を行わなかった旨の通知（本人）
 *
 * @reamsid_L AF-0320-033 lis2
 */
public class NotTorokuTsuchiHonninReport extends Report<NotTorokuTsuchiHonninReportSource> {

    private final List<NotTorokuTsuchiHonninParam> targets;

    /**
     * コンストラクタです。
     *
     * @param targets List<NotTorokuTsuchiHonninParam>
     */
    public NotTorokuTsuchiHonninReport(List<NotTorokuTsuchiHonninParam> targets) {
        this.targets = targets;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<NotTorokuTsuchiHonninReportSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<NotTorokuTsuchiHonninReportSource> reportSourceWriter) {
        for (NotTorokuTsuchiHonninParam target : this.targets) {
            NotTorokuTsuchiHonninEditor editor = new NotTorokuTsuchiHonninEditor(target);
            INotTorokuTsuchiHonninBuilder builder = new NotTorokuTsuchiHonninBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
