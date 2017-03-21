package jp.co.ndensan.reams.af.afa.business.report.AFAPRK101;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRK101.ShinseishoCheckListKaikuSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 申請書チェックリスト
 *
 * @reamsid_L AF-0460-032 wanghj
 */
public class ShinseishoCheckListKaikuPorperty extends ReportPropertyBase<ShinseishoCheckListKaikuSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRK101_申請書チェックリスト.value());

    /**
     * 帳票ID
     */
    public ShinseishoCheckListKaikuPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
