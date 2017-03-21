package jp.co.ndensan.reams.af.afa.business.report.AFAPRC201;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRC201.YubinTohyoShomeishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 郵便等投票証明書
 *
 * @reamsid_L AF-0200-030 lis2
 */
public class YubinTohyoShomeishoPorperty extends ReportPropertyBase<YubinTohyoShomeishoReportSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRC201_郵便等投票証明書.value());

    /**
     * 帳票ID
     */
    public YubinTohyoShomeishoPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
