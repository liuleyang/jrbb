package jp.co.ndensan.reams.af.afa.business.report.AFAPRB213;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB213.NninIjoSetaiListSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * n人以上世帯一覧表
 *
 * @reamsid_L AF-0160-037 wangh
 */
public class NninIjoSetaiListPorperty extends ReportPropertyBase<NninIjoSetaiListSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRB213_n人以上世帯一覧表.value());

    /**
     * 帳票ID
     */
    public NninIjoSetaiListPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
