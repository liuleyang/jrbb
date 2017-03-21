/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE512;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE512.NendaibetsuJokyoShirabeSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票AFAPRE512_NendaibetsuJokyoShirabe_年代別投票状況調べのReportクラスです。
 *
 * @reamsid_L AF-0280-029 wangm
 */
public class NendaibetsuJokyoShirabeReport extends Report<NendaibetsuJokyoShirabeSource> {

    private final NendaibetsuJokyoShirabeParam target;

    /**
     * インスタンスを生成します。
     *
     * @param target NendaibetsuJokyoShirabeParam
     */
    public NendaibetsuJokyoShirabeReport(NendaibetsuJokyoShirabeParam target) {
        this.target = target;
    }

    @Override
    public void writeBy(ReportSourceWriter<NendaibetsuJokyoShirabeSource> writer) {
        INendaibetsuJokyoShirabeEditor editor = new NendaibetsuJokyoShirabeEditor(target);
        INendaibetsuJokyoShirabeBuilder builder = new NendaibetsuJokyoShirabeBuilder(editor);
        writer.writeLine(builder);
    }

}
