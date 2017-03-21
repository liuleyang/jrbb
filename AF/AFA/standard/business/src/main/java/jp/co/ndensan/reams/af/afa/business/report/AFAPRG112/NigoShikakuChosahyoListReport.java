/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG112;

import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.db.relate.kokumintohyoji.MitorokushaMasshoTsuchiListEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG112.MitorokushaMasshoTsuchiListSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * AFAPRG112_2goShikakuChosahyoList_2号資格調査一覧表のReportクラスです。
 *
 * @reamsid_L AF-0360-057 fulc
 */
public class NigoShikakuChosahyoListReport extends Report<MitorokushaMasshoTsuchiListSource> {

    private final MitorokushaMasshoTsuchiListEntity entity;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;
    private final RString 帳票ID;
    private final RString 帳票タイトル;

    /**
     * コンストラクタです。
     *
     * @param entity {@link MitorokushaMasshoTsuchiListEntity}
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     * @param 帳票ID RString
     * @param 帳票タイトル RString
     */
    public NigoShikakuChosahyoListReport(MitorokushaMasshoTsuchiListEntity entity, TeijiCommonJohoItem 帳票共通ヘッダー,
            RString 帳票ID, RString 帳票タイトル) {
        this.entity = entity;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
        this.帳票ID = 帳票ID;
        this.帳票タイトル = 帳票タイトル;
    }

    @Override
    public void writeBy(ReportSourceWriter<MitorokushaMasshoTsuchiListSource> reportSourceWriter) {
        INigoShikakuChosahyoListEditor editor = new NigoShikakuChosahyoListEditor(entity, 帳票共通ヘッダー, 帳票ID, 帳票タイトル);
        INigoShikakuChosahyoListBuilder builder = new NigoShikakuChosahyoListBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
