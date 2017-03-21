package jp.co.ndensan.reams.af.afa.business.report.AFAPRB309;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiShikakushaMeiboParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB309.ZaigaiShikakushaMeiboReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 在外投票資格者名簿
 *
 * @reamsid_L AF-0350-032 wangh
 */
public class ZaigaiShikakushaMeiboReport extends Report<ZaigaiShikakushaMeiboReportSource> {

    private final List<ZaigaiShikakushaMeiboParam> targets;
    private final TeijiCommonJohoItem item;

    /**
     * コンストラクタです。
     *
     * @param targets List<ZaigaiShikakushaMeiboParam>
     * @param item TeijiCommonJohoItem
     */
    public ZaigaiShikakushaMeiboReport(List<ZaigaiShikakushaMeiboParam> targets, TeijiCommonJohoItem item) {
        this.targets = targets;
        this.item = item;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<ZaigaiShikakushaMeiboReportSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<ZaigaiShikakushaMeiboReportSource> reportSourceWriter) {
        for (ZaigaiShikakushaMeiboParam target : this.targets) {
            ZaigaiShikakushaMeiboEditor editor = new ZaigaiShikakushaMeiboEditor(target, item);
            IZaigaiShikakushaMeiboBuilder builder = new ZaigaiShikakushaMeiboBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
