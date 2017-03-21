package jp.co.ndensan.reams.af.afa.business.report.AFAPRB301;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoninShoParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB301.ZaigaiSenkyoninShoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 在外選挙人証
 *
 * @reamsid_L AF-0320-030 lis2
 */
public class ZaigaiSenkyoninShoReport extends Report<ZaigaiSenkyoninShoReportSource> {

    private final List<ZaigaiSenkyoninShoParam> targets;

    /**
     * コンストラクタです。
     *
     * @param targets List<ZaigaiSenkyoninShoParam>
     */
    public ZaigaiSenkyoninShoReport(List<ZaigaiSenkyoninShoParam> targets) {
        this.targets = targets;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<ZaigaiSenkyoninShoReportSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<ZaigaiSenkyoninShoReportSource> reportSourceWriter) {
        for (ZaigaiSenkyoninShoParam target : this.targets) {
            ZaigaiSenkyoninShoEditor editor = new ZaigaiSenkyoninShoEditor(target);
            IZaigaiSenkyoninShoBuilder builder = new ZaigaiSenkyoninShoBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
