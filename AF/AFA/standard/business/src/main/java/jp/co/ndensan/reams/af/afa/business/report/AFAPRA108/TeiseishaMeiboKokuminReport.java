/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.af.afa.business.report.AFAPRA108;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA108.TeiseishaMeiboSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 訂正者名簿を出力する、リアル・バッチ両方で使用可能なReportクラスです。<br />
 * n行を生成可能とするため、リストの訂正者名簿ソースクラスを受け取ります。
 *
 * @reamsid_L AF-0360-053 caijj2
 */
public class TeiseishaMeiboKokuminReport  extends Report<TeiseishaMeiboSource> {
    
    private final TeiseishaMeiboKokuminParam trgt;

    /**
     * コンストラクタです。
     *
     * @param trgt TeiseishaMeiboKokuminParam
     */
    public TeiseishaMeiboKokuminReport(TeiseishaMeiboKokuminParam trgt) {
        this.trgt = trgt;
    }

    /**
     * 指定の{@link ReportSourceWriter}を使用して、帳票ソースファイルの「永続化処理の定義」を行います。
     *
     * @param writer {@link ReportSourceWriter}
     */
    @Override
    public void writeBy(ReportSourceWriter<TeiseishaMeiboSource> writer) {

        ITeiseishaMeiboKokuminEditor editor = new TeiseishaMeiboKokuminEditor(trgt);
        ITeiseishaMeiboKokuminBuilder builder = new TeiseishaMeiboKokuminBuilder(editor);
        writer.writeLine(builder);
    }
}
