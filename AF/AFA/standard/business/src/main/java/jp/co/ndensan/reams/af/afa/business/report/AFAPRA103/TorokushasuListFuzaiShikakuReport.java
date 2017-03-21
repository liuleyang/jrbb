/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA103;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA103.TorokushasuListSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 登録者数リスト（不在者投票資格者分）作成を出力する、リアル・バッチ両方で使用可能なReportクラスです。<br />
 * n行を生成可能とするため、リストの登録者数リストソースクラスを受け取ります。
 *
 * @reamsid_L AF-0030-031 liss
 */
public final class TorokushasuListFuzaiShikakuReport extends Report<TorokushasuListSource> {

    private final List<TorokushasuListFuzaiShikakuItem> targets;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;
    private final FlexibleDate 基準日;

    private TorokushasuListFuzaiShikakuReport(List<TorokushasuListFuzaiShikakuItem> targets, TeijiCommonJohoItem 帳票共通ヘッダー, FlexibleDate 基準日) {
        this.targets = targets;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
        this.基準日 = 基準日;
    }

    /**
     * コンストラクタです。
     *
     * @param targets TorokushasuListFuzaiShikakuItem
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     * @param 基準日 FlexibleDate
     * @return TorokushasuListReport
     */
    public static TorokushasuListFuzaiShikakuReport createForm(@NonNull List<TorokushasuListFuzaiShikakuItem> targets, TeijiCommonJohoItem 帳票共通ヘッダー,
            FlexibleDate 基準日) {
        return new TorokushasuListFuzaiShikakuReport(targets, 帳票共通ヘッダー, 基準日);
    }

    @Override
    public void writeBy(ReportSourceWriter<TorokushasuListSource> writer) {
        for (TorokushasuListFuzaiShikakuItem target : targets) {
            TorokushasuListFuzaiShikakuEditor editor = new TorokushasuListFuzaiShikakuEditor(target, 帳票共通ヘッダー, 基準日);
            TorokushasuListFuzaiShikakuBuilder builder = new TorokushasuListFuzaiShikakuBuilder(editor);
            writer.writeLine(builder);
        }

    }

}
