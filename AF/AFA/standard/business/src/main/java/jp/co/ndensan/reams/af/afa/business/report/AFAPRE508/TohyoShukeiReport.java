/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE508;

import jp.co.ndensan.reams.af.afa.business.core.TohyoShukeiData;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE508.TohyoShukeiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 投票日前日関連帳票Reportクラスです。
 *
 * @reamsid_L AF-0280-025 lit
 */
public class TohyoShukeiReport extends Report<TohyoShukeiReportSource> {

    private final TohyoShukeiData item;

    /**
     * コンストラクタです。
     *
     * @param item 投票日前日関連帳票対象クラス
     */
    public TohyoShukeiReport(TohyoShukeiData item) {
        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<TohyoShukeiReportSource> reportSourceWriter) {
        reportSourceWriter.writeLine(new TohyoShukeiBuilder(new TohyoShukeiEditor(item)));
    }
}
