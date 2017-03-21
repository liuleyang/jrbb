package jp.co.ndensan.reams.af.afa.business.report.AFAPRE500;

import jp.co.ndensan.reams.af.afa.business.core.KijitsumaeNippoParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE500.KijitsumaeNippoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 期日前投票日報
 *
 * @reamsid_L AF-0270-030 wangl
 */
public class KijitsumaeNippoReport extends Report<KijitsumaeNippoReportSource> {

    private final KijitsumaeNippoParam target;
    private final TeijiCommonJohoItem item;

    /**
     * コンストラクタです。
     *
     * @param target KijitsumaeNippoParam
     * @param item TeijiCommonJohoItem
     */
    public KijitsumaeNippoReport(KijitsumaeNippoParam target, TeijiCommonJohoItem item) {
        this.target = target;
        this.item = item;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<KijitsumaeNippoReportSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<KijitsumaeNippoReportSource> reportSourceWriter) {
        KijitsumaeNippoEditor editor = new KijitsumaeNippoEditor(target, item);
        IKijitsumaeNippoBuilder builder = new KijitsumaeNippoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
