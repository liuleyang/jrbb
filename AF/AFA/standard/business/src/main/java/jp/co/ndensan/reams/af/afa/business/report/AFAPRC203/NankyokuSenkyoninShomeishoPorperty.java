package jp.co.ndensan.reams.af.afa.business.report.AFAPRC203;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRC203.NankyokuSenkyoninShomeishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 南極選挙人証
 *
 * @reamsid_L AF-0220-020 lis2
 */
public class NankyokuSenkyoninShomeishoPorperty extends ReportPropertyBase<NankyokuSenkyoninShomeishoReportSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRC203_南極選挙人証.value());

    /**
     * 帳票ID
     */
    public NankyokuSenkyoninShomeishoPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
