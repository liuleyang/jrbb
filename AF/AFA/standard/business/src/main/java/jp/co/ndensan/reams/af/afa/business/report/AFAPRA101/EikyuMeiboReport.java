/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA101;

import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.EikyuSenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA101.EikyuMeiboSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 永久選挙人名簿を出力する、リアル・バッチ両方で使用可能なReportクラスです。<br />
 * n行を生成可能とするため、リストの 永久選挙人名簿ソースクラスを受け取ります。
 *
 * @reamsid_L AF-0010-035 qiuxy
 */
public final class EikyuMeiboReport extends Report<EikyuMeiboSource> {

    private final EikyuSenkyoninMeiboEntity target;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクタです。
     *
     * @param target EikyuSenkyoninMeiboEntity
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public EikyuMeiboReport(EikyuSenkyoninMeiboEntity target, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.target = target;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    /**
     * 指定の{@link ReportSourceWriter}を使用して、帳票ソースファイルの「永続化処理の定義」を行います。
     *
     * @param writer {@link ReportSourceWriter}
     */
    @Override
    public void writeBy(ReportSourceWriter<EikyuMeiboSource> writer) {
        IEikyuMeiboEditor editor = new EikyuMeiboEditor(target, 帳票共通ヘッダー);
        IEikyuMeiboBuilder builder = new EikyuMeiboBuilder(editor);
        writer.writeLine(builder);
    }
}
