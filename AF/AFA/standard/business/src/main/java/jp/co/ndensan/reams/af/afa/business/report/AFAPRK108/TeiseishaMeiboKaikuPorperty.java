package jp.co.ndensan.reams.af.afa.business.report.AFAPRK108;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRK108.TeiseishaMeiboKaikuSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 訂正者名簿
 *
 * @reamsid_L AF-0460-035 wanghj
 */
public class TeiseishaMeiboKaikuPorperty extends ReportPropertyBase<TeiseishaMeiboKaikuSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.訂正者名簿海区.value());

    /**
     * 帳票ID
     */
    public TeiseishaMeiboKaikuPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
