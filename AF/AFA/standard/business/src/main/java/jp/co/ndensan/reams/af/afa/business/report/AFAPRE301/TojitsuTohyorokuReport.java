/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE301;

import jp.co.ndensan.reams.af.afa.business.core.TohyorokuChohyo;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE301.TojitsuTohyorokuReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 期日前投票録１タイプ１枚Reportクラスです。
 *
 * @reamsid_L AF-0130-021 lit
 */
public class TojitsuTohyorokuReport extends Report<TojitsuTohyorokuReportSource> {

    private final TohyorokuChohyo item;
    private static final int 代理投票者_表示可能数 = 5;

    /**
     * コンストラクタです。
     *
     * @param item 期日前投票録対象クラス
     */
    public TojitsuTohyorokuReport(TohyorokuChohyo item) {
        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<TojitsuTohyorokuReportSource> reportSourceWriter) {
        ITojitsuTohyorokuEditor editor = new TojitsuTohyorokuFirstEditor(item);
        ITojitsuTohyorokuBuilder builder = new TojitsuTohyorokuFirstBuilder(editor);
        if (null == item.get代理投票者リスト() || item.get代理投票者リスト().isEmpty()) {
            reportSourceWriter.writeLine(builder);
        } else if (item.get代理投票者リスト().size() > 代理投票者_表示可能数) {
            reportSourceWriter.writeLine(builder);

            editor = new TojitsuTohyorokuiSecondEditor(item);
            builder = new TojitsuTohyorokuSecondBuilder(editor);
            if (null != item.get代理投票者リスト() && !item.get代理投票者リスト().isEmpty()) {
                while (item.get代理投票者Index() < item.get代理投票者リスト().size()) {
                    editor.setLastFlg(item.get代理投票者Index() == item.get代理投票者リスト().size() - 1);
                    reportSourceWriter.writeLine(builder);
                    item.set代理投票者Index(item.get代理投票者Index() + 1);
                }
            }
        } else {
            while (item.get代理投票者Index() < item.get代理投票者リスト().size()) {
                editor.setLastFlg(item.get代理投票者Index() == item.get代理投票者リスト().size() - 1);
                reportSourceWriter.writeLine(builder);
                item.set代理投票者Index(item.get代理投票者Index() + 1);
            }
        }
    }
}
