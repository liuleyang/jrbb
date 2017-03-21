/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE201;

import jp.co.ndensan.reams.af.afa.business.report.AFAPRE101.SenseishoParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE201.FuzaishaTohyoShomeishoReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * {@link FuzaishaTohyoShomeishoReportSource}を編集します。
 *
 * @reamsid_L AF-0090-020 lit
 */
public class FuzaishaTohyoShomeishoReport extends Report<FuzaishaTohyoShomeishoReportSource> {

    private final SenseishoParam target;
    private final Association association;

    /**
     * コンストラクタです。
     *
     * @param target {@link SenseishoParam}
     * @param association {@link Association}
     */
    public FuzaishaTohyoShomeishoReport(SenseishoParam target, Association association) {
        this.target = target;
        this.association = association;
    }

    @Override
    public void writeBy(ReportSourceWriter<FuzaishaTohyoShomeishoReportSource> writer) {
        IFuzaishaTohyoShomeishoEditor editor = new FuzaishaTohyoShomeishoEditor(target, association);
        IFuzaishaTohyoShomeishoBuilder builder = new FuzaishaTohyoShomeishoBuilder(editor);
        writer.writeLine(builder);
    }
}
