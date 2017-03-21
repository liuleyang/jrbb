/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE514;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE514.JikanbetsuJokyoTohyojoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票AFAPRE514_JikanbetsuJokyoTohyojo_時間別投票状況表　投票所別のReportクラスです。
 *
 * @reamsid_L AF-0280-031 wangm
 */
public class JikanbetsuJokyoTohyojoReport extends Report<JikanbetsuJokyoTohyojoSource> {

    private final JikanbetsuJokyoTohyojoParam target;

    /**
     * インスタンスを生成します。
     *
     * @param target JikanbetsuJokyoTohyojoParam
     */
    public JikanbetsuJokyoTohyojoReport(JikanbetsuJokyoTohyojoParam target) {
        this.target = target;
    }

    @Override
    public void writeBy(ReportSourceWriter<JikanbetsuJokyoTohyojoSource> writer) {
        IJikanbetsuJokyoTohyojoEditor editor = new JikanbetsuJokyoTohyojoEditor(target);
        IJikanbetsuJokyoTohyojoBuilder builder = new JikanbetsuJokyoTohyojoBuilder(editor);
        writer.writeLine(builder);
    }

}
