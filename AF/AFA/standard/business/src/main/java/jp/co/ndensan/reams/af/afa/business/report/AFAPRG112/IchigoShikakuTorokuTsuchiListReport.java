/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.af.afa.business.report.AFAPRG112;

import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG112.IchigoShikakuTorokuTsuchiListSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 1号資格登録通知一覧表Reportクラスです。
 *
 * @reamsid_L AF-0360-056 caijj2
 */
public class IchigoShikakuTorokuTsuchiListReport extends Report<IchigoShikakuTorokuTsuchiListSource> {
    
    private final IchigoShikakuTorokuTsuchiListParameter target;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクタです。
     *
     * @param target {@link IchigoShikakuTorokuTsuchiListParameter}
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public IchigoShikakuTorokuTsuchiListReport(IchigoShikakuTorokuTsuchiListParameter target, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.target = target;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    @Override
    public void writeBy(ReportSourceWriter<IchigoShikakuTorokuTsuchiListSource> writer) {

        IIchigoShikakuTorokuTsuchiListEditor editor = new IchigoShikakuTorokuTsuchiListEditor(target, 帳票共通ヘッダー);
        IIchigoShikakuTorokuTsuchiListBuilder builder = new IchigoShikakuTorokuTsuchiListBuilder(editor);
        writer.writeLine(builder);

    }
}
