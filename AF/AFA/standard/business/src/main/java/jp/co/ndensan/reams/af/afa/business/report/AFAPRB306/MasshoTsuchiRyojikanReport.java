package jp.co.ndensan.reams.af.afa.business.report.AFAPRB306;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.MasshoTsuchiRyojikanParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB306.KisaijikoHenkoTsuchiRyojikanReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 抹消通知（領事官）
 *
 * @reamsid_L AF-0350-031 wangh
 */
public class MasshoTsuchiRyojikanReport extends Report<KisaijikoHenkoTsuchiRyojikanReportSource> {

    private final List<MasshoTsuchiRyojikanParam> targets;

    /**
     * コンストラクタです。
     *
     * @param targets List<MasshoTsuchiRyojikanParam>
     */
    public MasshoTsuchiRyojikanReport(List<MasshoTsuchiRyojikanParam> targets) {
        this.targets = targets;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<KisaijikoHenkoTsuchiRyojikanReportSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<KisaijikoHenkoTsuchiRyojikanReportSource> reportSourceWriter) {
        for (MasshoTsuchiRyojikanParam target : this.targets) {
            MasshoTsuchiRyojikanEditor editor = new MasshoTsuchiRyojikanEditor(target);
            IMasshoTsuchiRyojikanBuilder builder = new MasshoTsuchiRyojikanBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
