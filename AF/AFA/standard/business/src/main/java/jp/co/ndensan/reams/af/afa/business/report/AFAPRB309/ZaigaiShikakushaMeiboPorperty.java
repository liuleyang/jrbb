package jp.co.ndensan.reams.af.afa.business.report.AFAPRB309;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB309.ZaigaiShikakushaMeiboReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 在外投票資格者名簿
 *
 * @reamsid_L AF-0350-032 wangh
 */
public class ZaigaiShikakushaMeiboPorperty extends ReportPropertyBase<ZaigaiShikakushaMeiboReportSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRB309_在外投票資格者名簿.value());

    /**
     * 帳票ID
     */
    public ZaigaiShikakushaMeiboPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
