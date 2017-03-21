package jp.co.ndensan.reams.af.afa.business.report.AFAPRC202;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.SenkyoninMeiboTorokuShomeishoParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRC202.SenkyoninMeiboTorokuShomeishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 選挙人名簿登録証明書
 *
 * @reamsid_L AF-0210-030 lis2
 */
public class SenkyoninMeiboTorokuShomeishoReport extends Report<SenkyoninMeiboTorokuShomeishoReportSource> {

    private final List<SenkyoninMeiboTorokuShomeishoParam> targets;

    /**
     * コンストラクタです。
     *
     * @param targets List<SenkyoninMeiboTorokuShomeishoParam>
     */
    public SenkyoninMeiboTorokuShomeishoReport(List<SenkyoninMeiboTorokuShomeishoParam> targets) {
        this.targets = targets;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<SenkyoninMeiboTorokuShomeishoReportSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<SenkyoninMeiboTorokuShomeishoReportSource> reportSourceWriter) {
        for (SenkyoninMeiboTorokuShomeishoParam target : this.targets) {
            SenkyoninMeiboTorokuShomeishoEditor editor = new SenkyoninMeiboTorokuShomeishoEditor(target);
            ISenkyoninMeiboTorokuShomeishoBuilder builder = new SenkyoninMeiboTorokuShomeishoBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
