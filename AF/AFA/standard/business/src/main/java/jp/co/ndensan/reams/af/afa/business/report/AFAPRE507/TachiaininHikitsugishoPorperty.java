package jp.co.ndensan.reams.af.afa.business.report.AFAPRE507;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE507.TachiaininHikitsugishoSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 投票立会人引継書
 *
 * @reamsid_L AF-0120-020 jihb
 */
public class TachiaininHikitsugishoPorperty extends ReportPropertyBase<TachiaininHikitsugishoSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRE507_投票立会人引継書.value());

    /**
     * 帳票ID
     */
    public TachiaininHikitsugishoPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
