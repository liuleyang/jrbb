package jp.co.ndensan.reams.af.afa.business.report.AFAPRC201;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.YubinTohyoShomeishoParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRC201.YubinTohyoShomeishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 郵便等投票証明書
 *
 * @reamsid_L AF-0200-030 lis2
 */
public class YubinTohyoShomeishoReport extends Report<YubinTohyoShomeishoReportSource> {

    private final List<YubinTohyoShomeishoParam> targets;

    /**
     * コンストラクタです。
     *
     * @param targets List<YubinTohyoShomeishoParam>
     */
    public YubinTohyoShomeishoReport(List<YubinTohyoShomeishoParam> targets) {
        this.targets = targets;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<YubinTohyoShomeishoReportSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<YubinTohyoShomeishoReportSource> reportSourceWriter) {
        for (YubinTohyoShomeishoParam target : this.targets) {
            YubinTohyoShomeishoEditor editor = new YubinTohyoShomeishoEditor(target);
            IYubinTohyoShomeishoBuilder builder = new YubinTohyoShomeishoBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
