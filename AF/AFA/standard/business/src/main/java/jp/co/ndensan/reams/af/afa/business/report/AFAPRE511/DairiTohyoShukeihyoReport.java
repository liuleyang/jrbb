/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE511;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE511.DairiTohyoShukeihyoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票AFAPRE511_DairiTohyoShukeihyo_代理投票集計表のReportクラスです。
 *
 * @reamsid_L AF-0280-028 wangm
 */
public class DairiTohyoShukeihyoReport extends Report<DairiTohyoShukeihyoSource> {

    private final DairiTohyoShukeihyoParam target;

    /**
     * インスタンスを生成します。
     *
     * @param target DairiTohyoShukeihyoParam
     */
    public DairiTohyoShukeihyoReport(DairiTohyoShukeihyoParam target) {
        this.target = target;
    }

    @Override
    public void writeBy(ReportSourceWriter<DairiTohyoShukeihyoSource> writer) {
        IDairiTohyoShukeihyoEditor editor = new DairiTohyoShukeihyoEditor(target);
        IDairiTohyoShukeihyoBuilder builder = new DairiTohyoShukeihyoBuilder(editor);
        writer.writeLine(builder);
    }

}
