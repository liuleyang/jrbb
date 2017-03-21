package jp.co.ndensan.reams.af.afa.business.report.AFAPRC203;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.NankyokuSenkyoninShomeishoParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRC203.NankyokuSenkyoninShomeishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 南極選挙人証
 *
 * @reamsid_L AF-0220-020 lis2
 */
public class NankyokuSenkyoninShomeishoReport extends Report<NankyokuSenkyoninShomeishoReportSource> {

    private final List<NankyokuSenkyoninShomeishoParam> targets;

    /**
     * コンストラクタです。
     *
     * @param targets List<NankyokuSenkyoninShomeishoParam>
     */
    public NankyokuSenkyoninShomeishoReport(List<NankyokuSenkyoninShomeishoParam> targets) {
        this.targets = targets;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<NankyokuSenkyoninShomeishoReportSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<NankyokuSenkyoninShomeishoReportSource> reportSourceWriter) {
        for (NankyokuSenkyoninShomeishoParam target : this.targets) {
            NankyokuSenkyoninShomeishoEditor editor = new NankyokuSenkyoninShomeishoEditor(target);
            INankyokuSenkyoninShomeishoBuilder builder = new NankyokuSenkyoninShomeishoBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
