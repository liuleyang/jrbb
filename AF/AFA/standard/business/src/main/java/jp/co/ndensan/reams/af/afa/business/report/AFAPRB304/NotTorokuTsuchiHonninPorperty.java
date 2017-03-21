package jp.co.ndensan.reams.af.afa.business.report.AFAPRB304;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB304.NotTorokuTsuchiHonninReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 登録を行わなかった旨の通知（本人）
 *
 * @reamsid_L AF-0320-033 lis2
 */
public class NotTorokuTsuchiHonninPorperty extends ReportPropertyBase<NotTorokuTsuchiHonninReportSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRB304_登録を行わなかった旨の通知_本人.value());

    /**
     * 帳票ID
     */
    public NotTorokuTsuchiHonninPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
