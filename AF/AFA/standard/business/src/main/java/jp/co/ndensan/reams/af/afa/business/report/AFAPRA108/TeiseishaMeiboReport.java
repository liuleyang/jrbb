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
 * @reamsid_L AF-0010-042 wangm
 */
public final class TeiseishaMeiboReport extends Report<TeiseishaMeiboSource> {

    private final TeiseishaMeiboParam trgt;

    /**
     * コンストラクタです。
     *
     * @param trgt TeiseishaMeiboParam
     */
    public TeiseishaMeiboReport(TeiseishaMeiboParam trgt) {
        this.trgt = trgt;
    }

    /**
     * 指定の{@link ReportSourceWriter}を使用して、帳票ソースファイルの「永続化処理の定義」を行います。
     *
     * @param writer {@link ReportSourceWriter}
     */
    @Override
    public void writeBy(ReportSourceWriter<TeiseishaMeiboSource> writer) {

        ITeiseishaMeiboEditor editor = new TeiseishaMeiboEditor(trgt);
        ITeiseishaMeiboBuilder builder = new TeiseishaMeiboBuilder(editor);
        writer.writeLine(builder);
    }
}
