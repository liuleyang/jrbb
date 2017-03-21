package jp.co.ndensan.reams.af.afa.business.report.AFAPRB214;

import jp.co.ndensan.reams.af.afa.business.core.NyujokenTestPrintDataListParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB214.NyujokenTestPrintDataListSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 入場券テストデータ抽出一覧表
 *
 * @reamsid_L AF-0160-038 wangh
 */
public class NyujokenTestPrintDataListReport extends Report<NyujokenTestPrintDataListSource> {

    private final NyujokenTestPrintDataListParam target;

    /**
     * コンストラクタです。
     *
     * @param target NyujokenTestPrintDataListParam
     */
    public NyujokenTestPrintDataListReport(NyujokenTestPrintDataListParam target) {
        this.target = target;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<NyujokenTestPrintDataListSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<NyujokenTestPrintDataListSource> reportSourceWriter) {
        NyujokenTestPrintDataListEditor editor = new NyujokenTestPrintDataListEditor(target);
        INyujokenTestPrintDataListBuilder builder = new NyujokenTestPrintDataListBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
