/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA103;

import jp.co.ndensan.reams.af.afa.business.core.TorokushasuListKaikuParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA103.TorokushasuListSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 登録者数リスト（海区選挙）
 *
 * @reamsid_L AF-0460-033 wanghj
 */
public final class TorokushasuListKaikuReport extends Report<TorokushasuListSource> {

    private final TorokushasuListKaikuParam target;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * インスタンスを生成します。
     *
     * @param target TorokushasuListKaikuParam
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public TorokushasuListKaikuReport(TorokushasuListKaikuParam target, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.target = target;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    @Override
    public void writeBy(ReportSourceWriter<TorokushasuListSource> writer) {
        ITorokushasuListKaikuEditor editor = new TorokushasuListKaikuEditor(target, 帳票共通ヘッダー);
        ITorokushasuListKaikuBuilder builder = new TorokushasuListKaikuBuilder(editor);
        writer.writeLine(builder);
    }

}
