/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.report.AFAPRE504;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.TohyoJiyuChoshoParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE504.TohyoJiyuChoshoProperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE504.TohyoJiyuChoshoReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE504.TohyoJiyuChoshoSource;
import static jp.co.ndensan.reams.af.afa.service.core.ChouhyouCommon.createAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 投票事由調書
 *
 * @reamsid_L AF-0270-035 wangl
 */
public class TohyoJiyuChoshoPrintService {

    /**
     * 投票事由調書作成を発行します。
     *
     * @param tohyoJiyuChoshoParamLst List<TohyoJiyuChoshoParam>
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<TohyoJiyuChoshoParam> tohyoJiyuChoshoParamLst, TeijiCommonJohoItem 帳票共通ヘッダー) {
        try (ReportManager reportManager = new ReportManager()) {
            TohyoJiyuChoshoProperty property = new TohyoJiyuChoshoProperty();
            try (ReportAssembler<TohyoJiyuChoshoSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<TohyoJiyuChoshoSource> reportSourceWriter = new ReportSourceWriter(assembler);
                for (TohyoJiyuChoshoParam param : tohyoJiyuChoshoParamLst) {
                    TohyoJiyuChoshoReport report = toReport(param, 帳票共通ヘッダー);
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private TohyoJiyuChoshoReport toReport(TohyoJiyuChoshoParam param, TeijiCommonJohoItem 帳票共通ヘッダー) {
        return new TohyoJiyuChoshoReport(param, 帳票共通ヘッダー);
    }

}
