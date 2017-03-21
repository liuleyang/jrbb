/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE518;

import jp.co.ndensan.reams.af.afa.business.core.FuzaishaKanribetsuChoshoParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE518.FuzaishaKanribetsuChoshoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 不在者投票管理者別の調書帳票Reportクラスです。
 *
 * @reamsid_L AF-0280-035 lit
 */
public class FuzaishaKanribetsuChoshoReport extends Report<FuzaishaKanribetsuChoshoReportSource> {

    private final FuzaishaKanribetsuChoshoParam param;

    /**
     * コンストラクタです。
     *
     * @param param 不在者投票管理者別の調書帳票対象クラス
     */
    public FuzaishaKanribetsuChoshoReport(FuzaishaKanribetsuChoshoParam param) {
        this.param = param;
    }

    @Override
    public void writeBy(ReportSourceWriter<FuzaishaKanribetsuChoshoReportSource> reportSourceWriter) {
        reportSourceWriter.writeLine(new FuzaishaKanribetsuChoshoBuilder(new FuzaishaKanribetsuChoshoEditor(param)));
    }
}
