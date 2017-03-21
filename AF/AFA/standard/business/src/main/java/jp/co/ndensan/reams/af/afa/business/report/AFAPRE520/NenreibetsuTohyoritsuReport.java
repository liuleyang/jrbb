/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE520;

import jp.co.ndensan.reams.af.afa.business.core.TohyoritsuData;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE520.NenreibetsuTohyoritsuReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 年齢別投票率集計表帳票Reportクラスです。
 *
 * @reamsid_L AF-0290-036 lit
 */
public class NenreibetsuTohyoritsuReport extends Report<NenreibetsuTohyoritsuReportSource> {

    private final TohyoritsuData data;

    /**
     * コンストラクタです。
     *
     * @param data 年齢別投票率集計表帳票対象クラス
     */
    public NenreibetsuTohyoritsuReport(TohyoritsuData data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<NenreibetsuTohyoritsuReportSource> reportSourceWriter) {
        reportSourceWriter.writeLine(new NenreibetsuTohyoritsuBuilder(new NenreibetsuTohyoritsuEditor(data)));
    }
}
