package jp.co.ndensan.reams.af.afa.business.report.AFAPRB305;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB305.NotTorokuTsuchiRyojikanReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 登録を行わなかった旨の通知（領事官）
 *
 * @reamsid_L AF-0320-034 lis2
 */
public class NotTorokuTsuchiRyojikanPorperty extends ReportPropertyBase<NotTorokuTsuchiRyojikanReportSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRB305_登録を行わなかった旨の通知_領事官.value());

    /**
     * 帳票ID
     */
    public NotTorokuTsuchiRyojikanPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
