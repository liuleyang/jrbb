package jp.co.ndensan.reams.af.afa.business.report.AFAPRB306;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB306.KisaijikoHenkoTsuchiRyojikanReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 抹消通知（領事官）
 *
 * @reamsid_L AF-0350-031 wangh
 */
public class MasshoTsuchiRyojikanPorperty extends ReportPropertyBase<KisaijikoHenkoTsuchiRyojikanReportSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRB306_抹消通知_領事官.value());

    /**
     * 帳票ID
     */
    public MasshoTsuchiRyojikanPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
