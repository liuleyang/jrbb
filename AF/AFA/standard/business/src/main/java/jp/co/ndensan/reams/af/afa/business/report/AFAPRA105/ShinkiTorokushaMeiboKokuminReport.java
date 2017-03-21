/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA105;

import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TorokushaMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA105.ShinkiTorokushaMeiboKokuminSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 補正登録者名簿のShinkiTorokushaMeiboKokuminReportです。
 *
 * @reamsid_L AF-0360-051 zhoujie3
 */
public class ShinkiTorokushaMeiboKokuminReport extends Report<ShinkiTorokushaMeiboKokuminSource> {

    private final TorokushaMeiboEntity entity;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクタです。
     *
     * @param entity {@link KokuminTohyojiEntity}
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public ShinkiTorokushaMeiboKokuminReport(TorokushaMeiboEntity entity, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.entity = entity;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;

    }

    @Override
    public void writeBy(ReportSourceWriter<ShinkiTorokushaMeiboKokuminSource> reportSourceWriter) {
        IShinkiTorokushaMeiboKokuminEditor editor = new ShinkiTorokushaMeiboKokuminEditor(entity, 帳票共通ヘッダー);
        IShinkiTorokushaMeiboKokuminBuilder builder = new ShinkiTorokushaMeiboKokuminBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
