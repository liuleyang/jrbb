package jp.co.ndensan.reams.af.afa.business.report.AFAPRE501;

import jp.co.ndensan.reams.af.afa.business.core.FuzaihsaNippoParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE501.FuzaihsaNippoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 不在者投票日報
 *
 * @reamsid_L AF-0270-031 wangl
 */
public class FuzaihsaNippoReport extends Report<FuzaihsaNippoReportSource> {

    private final FuzaihsaNippoParam target;
    private final TeijiCommonJohoItem item;

    /**
     * コンストラクタです。
     *
     * @param target FuzaihsaNippoParam
     * @param item TeijiCommonJohoItem
     */
    public FuzaihsaNippoReport(FuzaihsaNippoParam target, TeijiCommonJohoItem item) {
        this.target = target;
        this.item = item;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<FuzaihsaNippoReportSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<FuzaihsaNippoReportSource> reportSourceWriter) {
        FuzaihsaNippoEditor editor = new FuzaihsaNippoEditor(target, item);
        IFuzaihsaNippoBuilder builder = new FuzaihsaNippoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
