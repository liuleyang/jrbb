package jp.co.ndensan.reams.af.afa.business.report.AFAPRE204;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE204.LabelSealAtena21Source;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * ラベルシール（宛名シール用紙21面）
 *
 * @reamsid_L AF-0620-031 wangh
 */
public class LabelSealAtena21Porperty extends ReportPropertyBase<LabelSealAtena21Source> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRE204_ラベルシール_宛名シール用紙21面.value());

    /**
     * 帳票ID
     */
    public LabelSealAtena21Porperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }

}
