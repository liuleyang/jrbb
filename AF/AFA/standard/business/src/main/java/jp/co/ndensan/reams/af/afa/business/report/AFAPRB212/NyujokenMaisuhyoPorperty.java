package jp.co.ndensan.reams.af.afa.business.report.AFAPRB212;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB212.NyujokenMaisuhyoSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 投票所入場券印刷枚数表
 *
 * @reamsid_L AF-0160-036 guyq
 */
public class NyujokenMaisuhyoPorperty extends ReportPropertyBase<NyujokenMaisuhyoSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRB212_投票所入場券印刷枚数表.value());

    /**
     * 帳票ID
     */
    public NyujokenMaisuhyoPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
