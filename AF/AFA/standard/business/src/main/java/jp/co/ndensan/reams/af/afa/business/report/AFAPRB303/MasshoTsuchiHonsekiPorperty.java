package jp.co.ndensan.reams.af.afa.business.report.AFAPRB303;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB303.TorokuTsuchiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 抹消通知（本籍地）
 *
 * @reamsid_L AF-0350-030 wangh
 */
public class MasshoTsuchiHonsekiPorperty extends ReportPropertyBase<TorokuTsuchiReportSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRB303_抹消通知_本籍地.value());

    /**
     * 帳票ID
     */
    public MasshoTsuchiHonsekiPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
