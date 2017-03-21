/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE504;

import jp.co.ndensan.reams.af.afa.business.core.TohyoJiyuChoshoParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE504.TohyoJiyuChoshoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 投票事由調書
 *
 * @reamsid_L AF-0270-035 wangl
 */
public class TohyoJiyuChoshoReport extends Report<TohyoJiyuChoshoSource> {

    private final TohyoJiyuChoshoParam target;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクタです。
     *
     * @param target {@link TohyoJiyuChoshoParam}
     * @param 帳票共通ヘッダー {@link TeijiCommonJohoItem}
     */
    public TohyoJiyuChoshoReport(TohyoJiyuChoshoParam target, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.target = target;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<TohyoJiyuChoshoSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<TohyoJiyuChoshoSource> reportSourceWriter) {
        TohyoJiyuChoshoEditor editor = new TohyoJiyuChoshoEditor(target, 帳票共通ヘッダー);
        ITohyoJiyuChoshoBuilder builder = new TohyoJiyuChoshoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
