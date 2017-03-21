package jp.co.ndensan.reams.af.afa.business.report.AFAPRB310;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB310.TohyoKanrihyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 在外選挙投票管理表
 *
 * @reamsid_L AF-0350-033 wangh
 */
public class TohyoKanrihyoPorperty extends ReportPropertyBase<TohyoKanrihyoReportSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRB310_在外選挙投票管理表.value());

    /**
     * 帳票ID
     */
    public TohyoKanrihyoPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }
}
