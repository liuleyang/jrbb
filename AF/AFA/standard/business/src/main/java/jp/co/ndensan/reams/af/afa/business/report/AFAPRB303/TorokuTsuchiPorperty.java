package jp.co.ndensan.reams.af.afa.business.report.AFAPRB303;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB303.TorokuTsuchiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 登録した旨の通知
 *
 * @reamsid_L AF-0320-032 lis2
 */
public class TorokuTsuchiPorperty extends ReportPropertyBase<TorokuTsuchiReportSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRB303_登録した旨の通知.value());

    /**
     * 帳票ID
     */
    public TorokuTsuchiPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
