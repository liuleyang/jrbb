package jp.co.ndensan.reams.af.afa.business.report.AFAPRC202;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRC202.SenkyoninMeiboTorokuShomeishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 選挙人名簿登録証明書
 *
 * @reamsid_L AF-0210-030 lis2
 */
public class SenkyoninMeiboTorokuShomeishoPorperty extends ReportPropertyBase<SenkyoninMeiboTorokuShomeishoReportSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRC202_選挙人名簿登録証明書.value());

    /**
     * 帳票ID
     */
    public SenkyoninMeiboTorokuShomeishoPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
