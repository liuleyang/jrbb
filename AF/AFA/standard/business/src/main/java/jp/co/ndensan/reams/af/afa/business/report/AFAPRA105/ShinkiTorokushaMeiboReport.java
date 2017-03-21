/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA105;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA105.ShinkiTorokushaMeiboSource;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 適用適正化件数表作成を出力する、リアル・バッチ両方で使用可能なReportクラスです。<br />
 * n行を生成可能とするため、リストの適用適正化件数表作成Itemクラスを受け取ります。
 *
 * @reamsid_L AF-0010-039 qiuxy
 */
public class ShinkiTorokushaMeiboReport extends Report<ShinkiTorokushaMeiboSource> {

    private final ShinkiTorokushaMeiboParam param;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクタです。
     *
     * @param param {@link ShinkiTorokushaMeiboParam}
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     * @throws NullPointerException 引数がNullの場合
     */
    public ShinkiTorokushaMeiboReport(ShinkiTorokushaMeiboParam param, TeijiCommonJohoItem 帳票共通ヘッダー) throws NullPointerException {
        this.param = requireNonNull(param, UrSystemErrorMessages.値がnull.getReplacedMessage("適用適正化件数表作成編集元クラス"));
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShinkiTorokushaMeiboSource> writer) {

        IShinkiTorokushaMeiboEditor editor = new ShinkiTorokushaMeiboEditor(param, 帳票共通ヘッダー);
        IShinkiTorokushaMeiboBuilder builder = new ShinkiTorokushaMeiboBuilder(editor);
        writer.writeLine(builder);

    }

}
