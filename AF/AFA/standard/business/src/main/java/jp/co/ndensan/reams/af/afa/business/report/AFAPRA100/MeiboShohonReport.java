/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA100;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA100.MeiboShohonSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 選挙人名簿抄本を出力する、リアル・バッチ両方で使用可能なReportクラスです。<br />
 * n行を生成可能とするため、リストの選挙人名簿抄本Itemクラスを受け取ります。
 *
 */
public class MeiboShohonReport extends Report<MeiboShohonSource> {

    private final MeinoShohonParam param;
    private final boolean is国民投票;

    /**
     * コンストラクタです。
     *
     * @param param MeinoShohonParam
     * @param is国民投票 boolean
     */
    public MeiboShohonReport(MeinoShohonParam param, boolean is国民投票) {
        this.param = param;
        this.is国民投票 = is国民投票;
    }

    @Override
    public void writeBy(ReportSourceWriter<MeiboShohonSource> writer) {
        IMeiboShohonEditor editor = new MeiboShohonEditor(param, is国民投票);
        IMeiboShohonBuilder builder = new MeiboShohonBuilder(editor);
        writer.writeLine(builder);
    }
}
