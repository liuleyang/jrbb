package jp.co.ndensan.reams.af.afa.business.report.AFAPRE502;

import jp.co.ndensan.reams.af.afa.business.core.KijitsumaeTohyoshaListParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE502.KijitsumaeTohyoshaListReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 期日前投票者一覧表
 *
 * @reamsid_L AF-0270-033 wangl
 */
public class KijitsumaeTohyoshaListReport extends Report<KijitsumaeTohyoshaListReportSource> {

    private final KijitsumaeTohyoshaListParam target;
    private final TeijiCommonJohoItem item;

    /**
     * コンストラクタです。
     *
     * @param target KijitsumaeTohyoshaListParam
     * @param item TeijiCommonJohoItem
     */
    public KijitsumaeTohyoshaListReport(KijitsumaeTohyoshaListParam target, TeijiCommonJohoItem item) {
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
        KijitsumaeTohyoshaListEditor editor = new KijitsumaeTohyoshaListEditor(target, item);
        IKijitsumaeTohyoshaListBuilder builder = new KijitsumaeTohyoshaListBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
