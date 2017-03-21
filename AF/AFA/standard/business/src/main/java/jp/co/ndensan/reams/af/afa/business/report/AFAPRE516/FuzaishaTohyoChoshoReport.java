/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE516;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE516.FuzaishaTohyoChoshoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票AFAPRE516_FuzaishaTohyoChosho_不在者投票に関する調書（25号様式）のReportクラスです。
 *
 * @reamsid_L AF-0280-033 wangm
 */
public class FuzaishaTohyoChoshoReport extends Report<FuzaishaTohyoChoshoSource> {

    private final FuzaishaTohyoChoshoParam target;

    /**
     * インスタンスを生成します。
     *
     * @param target FuzaishaTohyoChoshoParam
     */
    public FuzaishaTohyoChoshoReport(FuzaishaTohyoChoshoParam target) {
        this.target = target;
    }

    @Override
    public void writeBy(ReportSourceWriter<FuzaishaTohyoChoshoSource> writer) {
        IFuzaishaTohyoChoshoEditor editor = new FuzaishaTohyoChoshoEditor(target);
        IFuzaishaTohyoChoshoBuilder builder = new FuzaishaTohyoChoshoBuilder(editor);
        writer.writeLine(builder);
    }

}
