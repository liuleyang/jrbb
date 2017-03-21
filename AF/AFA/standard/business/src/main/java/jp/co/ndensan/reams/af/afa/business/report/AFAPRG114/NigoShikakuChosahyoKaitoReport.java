/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG114;

import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG114.NigoShikakuChosahyoKaitoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * AFAPRG114_2goShikakuChosahyoKaito_2号資格調査票（回答）（様式2-2）のReportクラスです。
 *
 * @reamsid_L AF-0360-062 fulc
 */
public class NigoShikakuChosahyoKaitoReport extends Report<NigoShikakuChosahyoKaitoSource> {

    private final NigoShikakuChosahyoKaitoParameter para;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクタです。
     *
     * @param para {@link NigoShikakuChosahyoKaitoParameter}
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public NigoShikakuChosahyoKaitoReport(NigoShikakuChosahyoKaitoParameter para,
            TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.para = para;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;

    }

    @Override
    public void writeBy(ReportSourceWriter<NigoShikakuChosahyoKaitoSource> reportSourceWriter) {
        INigoShikakuChosahyoKaitoEditor editor = new NigoShikakuChosahyoKaitoEditor(para, 帳票共通ヘッダー);
        INigoShikakuChosahyoKaitoBuilder builder = new NigoShikakuChosahyoKaitoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
