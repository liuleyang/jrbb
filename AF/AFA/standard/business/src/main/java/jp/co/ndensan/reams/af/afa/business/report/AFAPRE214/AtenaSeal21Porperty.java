package jp.co.ndensan.reams.af.afa.business.report.AFAPRE214;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE214.AtenaSeal21Source;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 宛名シール21面
 *
 * @reamsid_L AF-0620-033 wangh
 */
public class AtenaSeal21Porperty extends ReportPropertyBase<AtenaSeal21Source> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRE214_宛名シール21面.value());

    /**
     * 帳票ID
     */
    public AtenaSeal21Porperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }

}
