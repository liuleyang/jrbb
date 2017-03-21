/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG116;

import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.db.relate.kokumintohyoji.NigoShikakuKohoshaListEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG116.NigoShikakuKohoshaListSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * AFAPRG116_2goShikakuKohoshaList_2号資格候補者一覧表のReportクラスです。
 *
 * @reamsid_L AF-0360-063 fulc
 */
public class NigoShikakuKohoshaListReport extends Report<NigoShikakuKohoshaListSource> {

    private final NigoShikakuKohoshaListEntity entity;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクタです。
     *
     * @param entity {@link NigoShikakuKohoshaListEntity}
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public NigoShikakuKohoshaListReport(NigoShikakuKohoshaListEntity entity, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.entity = entity;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;

    }

    @Override
    public void writeBy(ReportSourceWriter<NigoShikakuKohoshaListSource> reportSourceWriter) {
        INigoShikakuKohoshaListEditor editor = new NigoShikakuKohoshaListEditor(entity, 帳票共通ヘッダー);
        INigoShikakuKohoshaListBuilder builder = new NigoShikakuKohoshaListBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
