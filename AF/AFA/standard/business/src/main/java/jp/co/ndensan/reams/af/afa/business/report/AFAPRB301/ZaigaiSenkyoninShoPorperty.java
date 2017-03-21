package jp.co.ndensan.reams.af.afa.business.report.AFAPRB301;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB301.ZaigaiSenkyoninShoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 在外選挙人証
 *
 * @reamsid_L AF-0320-030 lis2
 */
public class ZaigaiSenkyoninShoPorperty extends ReportPropertyBase<ZaigaiSenkyoninShoReportSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRB301_在外選挙人証.value());

    /**
     * 帳票ID
     */
    public ZaigaiSenkyoninShoPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
