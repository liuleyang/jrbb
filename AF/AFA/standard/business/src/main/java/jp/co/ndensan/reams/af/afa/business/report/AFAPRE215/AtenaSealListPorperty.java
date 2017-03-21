package jp.co.ndensan.reams.af.afa.business.report.AFAPRE215;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE215.AtenaSealListSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 宛名シール出力対象者一覧
 *
 * @reamsid_L AF-0620-034 wangh
 */
public class AtenaSealListPorperty extends ReportPropertyBase<AtenaSealListSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRE215_宛名シール出力対象者一覧.value());

    /**
     * 帳票ID
     */
    public AtenaSealListPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }

}
