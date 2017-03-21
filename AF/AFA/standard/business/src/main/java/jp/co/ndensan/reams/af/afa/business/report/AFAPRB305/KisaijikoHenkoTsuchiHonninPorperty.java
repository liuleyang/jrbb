package jp.co.ndensan.reams.af.afa.business.report.AFAPRB305;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB305.NotTorokuTsuchiRyojikanReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 記載事項変更通知（本人）
 *
 * @reamsid_L AF-0330-030 zhangl
 */
public class KisaijikoHenkoTsuchiHonninPorperty extends ReportPropertyBase<NotTorokuTsuchiRyojikanReportSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRB305_記載事項変更通知_本人.value());

    /**
     * 帳票ID
     */
    public KisaijikoHenkoTsuchiHonninPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
