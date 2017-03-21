package jp.co.ndensan.reams.af.afa.business.report.AFAPRB306;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB306.KisaijikoHenkoTsuchiRyojikanReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 記載事項変更通知（領事官）
 *
 * @reamsid_L AF-0330-031 zhangl
 */
public class KisaijikoHenkoTsuchiRyojikanPorperty extends ReportPropertyBase<KisaijikoHenkoTsuchiRyojikanReportSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRB306_記載事項変更通知_領事官.value());

    /**
     * 帳票ID
     */
    public KisaijikoHenkoTsuchiRyojikanPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
