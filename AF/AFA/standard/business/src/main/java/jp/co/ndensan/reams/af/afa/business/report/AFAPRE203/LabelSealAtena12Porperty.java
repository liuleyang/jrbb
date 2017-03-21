package jp.co.ndensan.reams.af.afa.business.report.AFAPRE203;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE203.LabelSealAtena12Source;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * ラベルシール（宛名シール用紙12面）
 *
 * @reamsid_L AF-0620-030 wangh
 */
public class LabelSealAtena12Porperty extends ReportPropertyBase<LabelSealAtena12Source> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRE203_ラベルシール_宛名シール用紙12面.value());

    /**
     * 帳票ID
     */
    public LabelSealAtena12Porperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
