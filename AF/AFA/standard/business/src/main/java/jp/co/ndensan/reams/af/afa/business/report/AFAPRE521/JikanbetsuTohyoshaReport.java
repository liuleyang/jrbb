/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE521;

import jp.co.ndensan.reams.af.afa.business.core.JikanbetsuTohyoshaParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE521.JikanbetsuTohyoshaReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 時間別投票者集計表帳票Reportクラスです。
 *
 * @reamsid_L AF-0290-037 lit
 */
public class JikanbetsuTohyoshaReport extends Report<JikanbetsuTohyoshaReportSource> {

    private final JikanbetsuTohyoshaParam data;

    /**
     * コンストラクタです。
     *
     * @param data 時間別投票者集計表帳票対象クラス
     */
    public JikanbetsuTohyoshaReport(JikanbetsuTohyoshaParam data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<JikanbetsuTohyoshaReportSource> reportSourceWriter) {
        reportSourceWriter.writeLine(new JikanbetsuTohyoshaBuilder(new JikanbetsuTohyoshaEditor(data)));
    }
}
