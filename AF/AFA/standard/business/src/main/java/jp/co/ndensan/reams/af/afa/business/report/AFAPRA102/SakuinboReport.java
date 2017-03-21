/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA102;

import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA102.SakuinboSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 選挙人索引簿を出力する、リアル・バッチ両方で使用可能なReportクラスです。<br />
 * n行を生成可能とするため、リストの選挙人索引簿ソースクラスを受け取ります。
 *
 * @reamsid_L AF-0010-036 qiuxy
 */
public final class SakuinboReport extends Report<SakuinboSource> {

    private final SakuinboParam target;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクタです。
     *
     * @param target SakuinboParam
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public SakuinboReport(SakuinboParam target, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.target = target;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    /**
     * 指定の{@link ReportSourceWriter}を使用して、帳票ソースファイルの「永続化処理の定義」を行います。
     *
     * @param writer {@link ReportSourceWriter}
     */
    @Override
    public void writeBy(ReportSourceWriter<SakuinboSource> writer) {
        ISakuinboEditor editor = new SakuinboEditor(target, 帳票共通ヘッダー);
        ISakuinboBuilder builder = new SakuinboBuilder(editor);
        writer.writeLine(builder);

    }

}
