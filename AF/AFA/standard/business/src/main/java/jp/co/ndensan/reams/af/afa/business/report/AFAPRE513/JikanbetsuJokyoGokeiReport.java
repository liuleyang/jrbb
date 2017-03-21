/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE513;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE513.JikanbetsuJokyoGokeiSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票AFAPRE513_JikanbetsuJokyoGokei_時間別投票状況表　合計のReportクラスです。
 *
 * @reamsid_L AF-0280-030 wangm
 */
public class JikanbetsuJokyoGokeiReport extends Report<JikanbetsuJokyoGokeiSource> {

    private final JikanbetsuJokyoGokeiParam target;

    /**
     * インスタンスを生成します。
     *
     * @param target JikanbetsuJokyoGokeiParam
     */
    public JikanbetsuJokyoGokeiReport(JikanbetsuJokyoGokeiParam target) {
        this.target = target;
    }

    @Override
    public void writeBy(ReportSourceWriter<JikanbetsuJokyoGokeiSource> writer) {
        IJikanbetsuJokyoGokeiEditor editor = new JikanbetsuJokyoGokeiEditor(target);
        IJikanbetsuJokyoGokeiBuilder builder = new JikanbetsuJokyoGokeiBuilder(editor);
        writer.writeLine(builder);
    }

}
