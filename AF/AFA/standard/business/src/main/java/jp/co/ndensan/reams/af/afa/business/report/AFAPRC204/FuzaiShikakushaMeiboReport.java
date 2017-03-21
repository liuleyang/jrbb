/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRC204;

import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabtb101.FuzaiShikakushaMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRC204.FuzaiShikakushaMeiboSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 不在者投票資格者名簿を出力する、リアル・バッチ両方で使用可能なReportクラスです。<br />
 * n行を生成可能とするため、リストの不在者投票資格者名簿Itemクラスを受け取ります。
 *
 * @reamsid_L AF-0030-035 liss
 */
public final class FuzaiShikakushaMeiboReport extends Report<FuzaiShikakushaMeiboSource> {

    private final FuzaiShikakushaMeiboEntity target;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;
    private final int rowCount;

    /**
     * コンストラクタです。
     *
     * @param target {@link FuzaiShikakushaMeiboEntity}
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     * @param rowCount int
     */
    public FuzaiShikakushaMeiboReport(FuzaiShikakushaMeiboEntity target, TeijiCommonJohoItem 帳票共通ヘッダー, int rowCount) {
        this.target = target;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
        this.rowCount = rowCount;
    }

    @Override
    public void writeBy(ReportSourceWriter<FuzaiShikakushaMeiboSource> writer) {

        IFuzaiShikakushaMeiboEditor editor = new FuzaiShikakushaMeiboEditor(target, 帳票共通ヘッダー, rowCount);
        IFuzaiShikakushaMeiboBuilder builder = new FuzaiShikakushaMeiboBuilder(editor);
        writer.writeLine(builder);

    }

}
