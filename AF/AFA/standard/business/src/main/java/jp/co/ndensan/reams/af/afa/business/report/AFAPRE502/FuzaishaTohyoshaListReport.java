package jp.co.ndensan.reams.af.afa.business.report.AFAPRE502;

import jp.co.ndensan.reams.af.afa.business.core.FuzaishaTohyoshaListParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE502.KijitsumaeTohyoshaListReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 不在者投票者一覧表
 *
 * @reamsid_L AF-0270-032 wangl
 */
public class FuzaishaTohyoshaListReport extends Report<KijitsumaeTohyoshaListReportSource> {

    private final FuzaishaTohyoshaListParam target;
    private final TeijiCommonJohoItem item;

    /**
     * コンストラクタです。
     *
     * @param target FuzaishaTohyoshaListParam
     * @param item TeijiCommonJohoItem
     */
    public FuzaishaTohyoshaListReport(FuzaishaTohyoshaListParam target, TeijiCommonJohoItem item) {
        this.target = target;
        this.item = item;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<KijitsumaeTohyoshaListReportSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<KijitsumaeTohyoshaListReportSource> reportSourceWriter) {
        FuzaishaTohyoshaListEditor editor = new FuzaishaTohyoshaListEditor(target, item);
        IFuzaishaTohyoshaListBuilder builder = new FuzaishaTohyoshaListBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
