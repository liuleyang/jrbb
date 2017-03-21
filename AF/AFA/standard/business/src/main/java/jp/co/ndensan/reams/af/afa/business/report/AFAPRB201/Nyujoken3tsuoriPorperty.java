package jp.co.ndensan.reams.af.afa.business.report.AFAPRB201;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB201.Nyujoken3tsuoriSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 投票所入場券（個票3つ折り）
 *
 * @reamsid_L AF-0160-031 zhanggs
 */
public class Nyujoken3tsuoriPorperty extends ReportPropertyBase<Nyujoken3tsuoriSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRB201_投票所入場券_個票3つ折り.value());

    /**
     * 帳票ID
     */
    public Nyujoken3tsuoriPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
