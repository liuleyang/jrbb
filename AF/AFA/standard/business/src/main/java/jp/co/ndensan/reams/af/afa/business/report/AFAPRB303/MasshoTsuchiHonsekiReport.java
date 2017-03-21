package jp.co.ndensan.reams.af.afa.business.report.AFAPRB303;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.MasshoTsuchiHonsekiParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB303.TorokuTsuchiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 抹消通知（本籍地）
 *
 * @reamsid_L AF-0350-030 wangh
 */
public class MasshoTsuchiHonsekiReport extends Report<TorokuTsuchiReportSource> {

    private final List<MasshoTsuchiHonsekiParam> targets;

    /**
     * コンストラクタです。
     *
     * @param targets List<MasshoTsuchiHonsekiParam>
     */
    public MasshoTsuchiHonsekiReport(List<MasshoTsuchiHonsekiParam> targets) {
        this.targets = targets;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<TorokuTsuchiReportSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<TorokuTsuchiReportSource> reportSourceWriter) {
        for (MasshoTsuchiHonsekiParam target : this.targets) {
            MasshoTsuchiHonsekiEditor editor = new MasshoTsuchiHonsekiEditor(target);
            IMasshoTsuchiHonsekiBuilder builder = new MasshoTsuchiHonsekiBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
