package jp.co.ndensan.reams.af.afa.business.report.AFAPRB303;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.TorokuTsuchiParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB303.TorokuTsuchiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 登録した旨の通知
 *
 * @reamsid_L AF-0320-032 lis2
 */
public class TorokuTsuchiReport extends Report<TorokuTsuchiReportSource> {

    private final List<TorokuTsuchiParam> targets;

    /**
     * コンストラクタです。
     *
     * @param targets List<TorokuTsuchiParam>
     */
    public TorokuTsuchiReport(List<TorokuTsuchiParam> targets) {
        this.targets = targets;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<TorokuTsuchiReportSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<TorokuTsuchiReportSource> reportSourceWriter) {
        for (TorokuTsuchiParam target : this.targets) {
            TorokuTsuchiEditor editor = new TorokuTsuchiEditor(target);
            ITorokuTsuchiBuilder builder = new TorokuTsuchiBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
