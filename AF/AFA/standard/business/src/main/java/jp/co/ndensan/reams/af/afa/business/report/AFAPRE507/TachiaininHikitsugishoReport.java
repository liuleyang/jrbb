package jp.co.ndensan.reams.af.afa.business.report.AFAPRE507;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.TachiaininHikitsugishoParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE507.TachiaininHikitsugishoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 投票立会人引継書
 *
 * @reamsid_L AF-0120-020 jihb
 */
public class TachiaininHikitsugishoReport extends Report<TachiaininHikitsugishoSource> {

    private final List<TachiaininHikitsugishoParam> targets;

    /**
     * コンストラクタです。
     *
     * @param targets List<TachiaininHikitsugishoParam>
     */
    public TachiaininHikitsugishoReport(List<TachiaininHikitsugishoParam> targets) {
        this.targets = targets;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<TachiaininHikitsugishoSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<TachiaininHikitsugishoSource> reportSourceWriter) {
        for (TachiaininHikitsugishoParam target : this.targets) {
            TachiaininHikitsugishoEditor editor = new TachiaininHikitsugishoEditor(target);
            ITachiaininHikitsugishoBuilder builder = new TachiaininHikitsugishoBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
