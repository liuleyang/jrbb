package jp.co.ndensan.reams.af.afa.business.report.AFAPRE213;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE213.AtenaSeal12Source;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 宛名シール12面
 *
 * @reamsid_L AF-0620-032 wangh
 */
public class AtenaSeal12Porperty extends ReportPropertyBase<AtenaSeal12Source> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRE213_宛名シール12面.value());

    /**
     * 帳票ID
     */
    public AtenaSeal12Porperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }

}
