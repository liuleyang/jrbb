package jp.co.ndensan.reams.af.afa.business.report.AFAPRB212;

import jp.co.ndensan.reams.af.afa.business.core.NyujokenMaisuhyoParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB212.NyujokenMaisuhyoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 投票所入場券印刷枚数表
 *
 * @reamsid_L AF-0160-036 guyq
 */
public class NyujokenMaisuhyoReport extends Report<NyujokenMaisuhyoSource> {

    private final NyujokenMaisuhyoParam target;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクタです。
     *
     * @param target NyujokenMaisuhyoParam
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public NyujokenMaisuhyoReport(NyujokenMaisuhyoParam target, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.target = target;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<NyujokenMaisuhyoSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<NyujokenMaisuhyoSource> reportSourceWriter) {
        NyujokenMaisuhyoEditor editor = new NyujokenMaisuhyoEditor(target, 帳票共通ヘッダー);
        INyujokenMaisuhyoBuilder builder = new NyujokenMaisuhyoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
