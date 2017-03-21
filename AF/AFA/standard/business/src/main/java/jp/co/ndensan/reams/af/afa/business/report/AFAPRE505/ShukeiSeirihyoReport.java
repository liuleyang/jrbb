package jp.co.ndensan.reams.af.afa.business.report.AFAPRE505;

import jp.co.ndensan.reams.af.afa.business.core.ShukeiSeirihyoParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE505.ShukeiSeirihyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 集計整理表
 *
 * @reamsid_L AF-0270-036 wangl
 */
public class ShukeiSeirihyoReport extends Report<ShukeiSeirihyoReportSource> {

    private final ShukeiSeirihyoParam target;
    private final TeijiCommonJohoItem item;

    /**
     * コンストラクタです。
     *
     * @param target ShukeiSeirihyoParam
     * @param item TeijiCommonJohoItem
     */
    public ShukeiSeirihyoReport(ShukeiSeirihyoParam target, TeijiCommonJohoItem item) {
        this.target = target;
        this.item = item;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<ShukeiSeirihyoReportSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<ShukeiSeirihyoReportSource> reportSourceWriter) {
        ShukeiSeirihyoEditor editor = new ShukeiSeirihyoEditor(target, item);
        IShukeiSeirihyoBuilder builder = new ShukeiSeirihyoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
