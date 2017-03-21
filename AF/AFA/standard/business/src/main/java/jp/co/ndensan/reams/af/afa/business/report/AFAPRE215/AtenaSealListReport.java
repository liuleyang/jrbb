package jp.co.ndensan.reams.af.afa.business.report.AFAPRE215;

import jp.co.ndensan.reams.af.afa.business.core.AtenaSealListParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE215.AtenaSealListSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 宛名シール出力対象者一覧
 *
 * @reamsid_L AF-0620-034 wangh
 */
public class AtenaSealListReport extends Report<AtenaSealListSource> {

    private final AtenaSealListParam target;

    /**
     * コンストラクタです。
     *
     * @param target AtenaSealListParam
     */
    public AtenaSealListReport(AtenaSealListParam target) {
        this.target = target;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<AtenaSealListSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<AtenaSealListSource> reportSourceWriter) {
        AtenaSealListEditor editor = new AtenaSealListEditor(target);
        IAtenaSealListBuilder builder = new AtenaSealListBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
