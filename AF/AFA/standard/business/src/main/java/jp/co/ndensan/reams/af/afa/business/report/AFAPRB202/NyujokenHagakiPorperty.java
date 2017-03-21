package jp.co.ndensan.reams.af.afa.business.report.AFAPRB202;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB202.NyujokenHagakiSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 投票所入場券（はがき4つ切り）
 *
 * @reamsid_L AF-0160-032 guyq
 */
public class NyujokenHagakiPorperty extends ReportPropertyBase<NyujokenHagakiSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRB202_投票所入場券_はがき4つ切り.value());

    /**
     * 帳票ID
     */
    public NyujokenHagakiPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
