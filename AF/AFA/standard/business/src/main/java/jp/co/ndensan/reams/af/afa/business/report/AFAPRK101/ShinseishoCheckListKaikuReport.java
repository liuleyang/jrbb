package jp.co.ndensan.reams.af.afa.business.report.AFAPRK101;

import jp.co.ndensan.reams.af.afa.business.core.ShinseishoCheckListKaikuParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRK101.ShinseishoCheckListKaikuSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 申請書チェックリスト
 *
 * @reamsid_L AF-0460-032 wanghj
 */
public class ShinseishoCheckListKaikuReport extends Report<ShinseishoCheckListKaikuSource> {

    private final ShinseishoCheckListKaikuParam target;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクタです。
     *
     * @param target ShinseishoCheckListKaikuParam
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public ShinseishoCheckListKaikuReport(ShinseishoCheckListKaikuParam target, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.target = target;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<ShinseishoCheckListKaikuSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<ShinseishoCheckListKaikuSource> reportSourceWriter) {
        ShinseishoCheckListKaikuEditor editor = new ShinseishoCheckListKaikuEditor(target, 帳票共通ヘッダー);
        IShinseishoCheckListKaikuBuilder builder = new ShinseishoCheckListKaikuBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
