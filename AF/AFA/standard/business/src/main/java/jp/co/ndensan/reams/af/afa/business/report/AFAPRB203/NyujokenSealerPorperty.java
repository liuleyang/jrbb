package jp.co.ndensan.reams.af.afa.business.report.AFAPRB203;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB203.NyujokenSealerSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 投票所入場券（シーラー）
 *
 * @reamsid_L AF-0160-033 xul
 */
public class NyujokenSealerPorperty extends ReportPropertyBase<NyujokenSealerSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRB203_投票所入場券_シーラー.value());

    /**
     * 帳票ID
     */
    public NyujokenSealerPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
