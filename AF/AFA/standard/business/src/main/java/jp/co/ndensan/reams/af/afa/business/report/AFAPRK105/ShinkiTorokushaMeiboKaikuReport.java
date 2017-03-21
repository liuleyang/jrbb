package jp.co.ndensan.reams.af.afa.business.report.AFAPRK105;

import jp.co.ndensan.reams.af.afa.business.core.ShinkiTorokushaMeiboKaikuParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRK105.ShinkiTorokushaMeiboKaikuSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 新規登録者名簿
 *
 * @reamsid_L AF-0460-034 wanghj
 */
public class ShinkiTorokushaMeiboKaikuReport extends Report<ShinkiTorokushaMeiboKaikuSource> {

    private final ShinkiTorokushaMeiboKaikuParam target;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクタです。
     *
     * @param target ShinkiTorokushaMeiboKaikuParam
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public ShinkiTorokushaMeiboKaikuReport(ShinkiTorokushaMeiboKaikuParam target, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.target = target;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<ShinkiTorokushaMeiboKaikuSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<ShinkiTorokushaMeiboKaikuSource> reportSourceWriter) {
        ShinkiTorokushaMeiboKaikuEditor editor = new ShinkiTorokushaMeiboKaikuEditor(target, 帳票共通ヘッダー);
        IShinkiTorokushaMeiboKaikuBuilder builder = new ShinkiTorokushaMeiboKaikuBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
