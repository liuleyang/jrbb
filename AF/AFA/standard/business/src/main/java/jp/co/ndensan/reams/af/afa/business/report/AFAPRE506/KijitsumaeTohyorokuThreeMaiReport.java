/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE506;

import jp.co.ndensan.reams.af.afa.business.core.TohyorokuChohyo;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE506.KijitsumaeTohyorokuReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 期日前投票録１タイプ１枚Reportクラスです。
 *
 * @reamsid_L AF-0130-020 lit
 */
public class KijitsumaeTohyorokuThreeMaiReport extends Report<KijitsumaeTohyorokuReportSource> {

    private final TohyorokuChohyo item;

    /**
     * コンストラクタです。
     *
     * @param item 期日前投票録対象クラス
     */
    public KijitsumaeTohyorokuThreeMaiReport(TohyorokuChohyo item) {
        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<KijitsumaeTohyorokuReportSource> reportSourceWriter) {
        writeByThreeMai(reportSourceWriter);
    }

    private void writeByThreeMai(ReportSourceWriter<KijitsumaeTohyorokuReportSource> reportSourceWriter) {
        IKijitsumaeTohyorokuEditor editor = new KijitsumaeTohyorokuThreeMaiFirstEditor(item);
        IKijitsumaeTohyorokuBuilder builder = new KijitsumaeTohyorokuThreeMaiFirstBuilder(editor);
        reportSourceWriter.writeLine(builder);

        editor = new KijitsumaeTohyorokuThreeMaiSecondEditor(item);
        builder = new KijitsumaeTohyorokuThreeMaiSecondBuilder(editor);
        if (null != item.get代理投票者リスト() && !item.get代理投票者リスト().isEmpty()) {
            while (item.get代理投票者Index() < item.get代理投票者リスト().size()) {
                editor.setLastFlg(item.get代理投票者Index() == item.get代理投票者リスト().size() - 1);
                reportSourceWriter.writeLine(builder);
                item.set代理投票者Index(item.get代理投票者Index() + 1);
            }
        } else {
            reportSourceWriter.writeLine(builder);
        }

        editor = new KijitsumaeTohyorokuThreeMaiThirdEditor(item);
        builder = new KijitsumaeTohyorokuThreeMaiThirdBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
