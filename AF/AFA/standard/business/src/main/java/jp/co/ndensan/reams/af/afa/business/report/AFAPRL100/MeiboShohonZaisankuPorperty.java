package jp.co.ndensan.reams.af.afa.business.report.AFAPRL100;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRL100.MeiboShohonZaisankuSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 財産区選挙人名簿抄本
 *
 * @reamsid_L AF-0600-030 lis
 */
public class MeiboShohonZaisankuPorperty extends ReportPropertyBase<MeiboShohonZaisankuSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRL100_財産区選挙人名簿抄本.value());

    /**
     * 帳票ID
     */
    public MeiboShohonZaisankuPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
