package jp.co.ndensan.reams.af.afa.business.report.AFAPRK100;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRK100.MeiboShohonKaikuSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 海区漁業調整委員会委員選挙人名簿抄本
 *
 * @reamsid_L AF-0460-031 wanghj
 */
public class MeiboShohonKaikuPorperty extends ReportPropertyBase<MeiboShohonKaikuSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRK100_海区漁業調整委員会委員選挙人名簿抄本.value());

    /**
     * 帳票ID
     */
    public MeiboShohonKaikuPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
