/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE515;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE515.JimushoriboSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票AFAPRE515_Jimushoribo_事務処理簿のReportクラスです。
 *
 * @reamsid_L AF-0280-032 wangm
 */
public class JimushoriboReport extends Report<JimushoriboSource> {

    private final JimushoriboParam target;

    /**
     * インスタンスを生成します。
     *
     * @param target JimushoriboParam
     */
    public JimushoriboReport(JimushoriboParam target) {
        this.target = target;
    }

    @Override
    public void writeBy(ReportSourceWriter<JimushoriboSource> writer) {
        IJimushoriboEditor editor = new JimushoriboEditor(target);
        IJimushoriboBuilder builder = new JimushoriboBuilder(editor);
        writer.writeLine(builder);
    }

}
