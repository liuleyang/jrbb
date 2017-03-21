/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE517;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE517.FuzaishaTohyoYoshiChoshoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票AFAPRE517_FuzaishaTohyoYoshiChosho_不在者投票用紙等の調書のReportクラスです。
 *
 * @reamsid_L AF-0280-034 wangm
 */
public class FuzaishaTohyoYoshiChoshoReport extends Report<FuzaishaTohyoYoshiChoshoSource> {

    private final FuzaishaTohyoYoshiChoshoParam target;

    /**
     * インスタンスを生成します。
     *
     * @param target FuzaishaTohyoYoshiChoshoParam
     */
    public FuzaishaTohyoYoshiChoshoReport(FuzaishaTohyoYoshiChoshoParam target) {
        this.target = target;
    }

    @Override
    public void writeBy(ReportSourceWriter<FuzaishaTohyoYoshiChoshoSource> writer) {
        IFuzaishaTohyoYoshiChoshoEditor editor = new FuzaishaTohyoYoshiChoshoEditor(target);
        IFuzaishaTohyoYoshiChoshoBuilder builder = new FuzaishaTohyoYoshiChoshoBuilder(editor);
        writer.writeLine(builder);
    }

}
