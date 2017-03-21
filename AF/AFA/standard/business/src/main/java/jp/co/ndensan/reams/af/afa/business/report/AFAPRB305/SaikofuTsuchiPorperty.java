package jp.co.ndensan.reams.af.afa.business.report.AFAPRB305;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB305.NotTorokuTsuchiRyojikanReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 再交付通知
 *
 * @reamsid_L AF-0340-020 liuj2
 */
public class SaikofuTsuchiPorperty extends ReportPropertyBase<NotTorokuTsuchiRyojikanReportSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRB305_再交付通知.value());

    /**
     * 帳票ID
     */
    public SaikofuTsuchiPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
