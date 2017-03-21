package jp.co.ndensan.reams.af.afa.business.report.AFAPRB204;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB204.NyujokenPostexSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 投票所入場券（ポステックス）
 *
 * @reamsid_L AF-0160-034 guyq
 */
public class NyujokenPostex152269Porperty extends ReportPropertyBase<NyujokenPostexSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRB204_投票所入場券_ポステックス_南魚沼市版.value());

    /**
     * 帳票ID
     */
    public NyujokenPostex152269Porperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
