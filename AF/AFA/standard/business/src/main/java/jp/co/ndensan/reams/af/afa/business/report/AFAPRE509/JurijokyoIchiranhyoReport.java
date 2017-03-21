/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE509;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE509.JurijokyoIchiranhyoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票AFAPRE509_JurijokyoIchiranhyo_受理状況一覧表のReportクラスです。
 *
 * @reamsid_L AF-0280-026 wangm
 */
public class JurijokyoIchiranhyoReport extends Report<JurijokyoIchiranhyoSource> {

    private final JurijokyoIchiranhyoParam target;

    /**
     * インスタンスを生成します。
     *
     * @param target JurijokyoIchiranhyoParam
     */
    public JurijokyoIchiranhyoReport(JurijokyoIchiranhyoParam target) {
        this.target = target;
    }

    @Override
    public void writeBy(ReportSourceWriter<JurijokyoIchiranhyoSource> writer) {
        IJurijokyoIchiranhyoEditor editor = new JurijokyoIchiranhyoEditor(target);
        IJurijokyoIchiranhyoBuilder builder = new JurijokyoIchiranhyoBuilder(editor);
        writer.writeLine(builder);
    }

}
