package jp.co.ndensan.reams.af.afa.business.report.AFAPRB302;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ShinseishaShokaiBunshoParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB302.ShinseishaShokaiBunshoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 申請者の被登録資格の照会文書
 *
 * @reamsid_L AF-0320-031 lis2
 */
public class ShinseishaShokaiBunshoReport extends Report<ShinseishaShokaiBunshoReportSource> {

    private final List<ShinseishaShokaiBunshoParam> targets;

    /**
     * コンストラクタです。
     *
     * @param targets List<ShinseishaShokaiBunshoParam>
     */
    public ShinseishaShokaiBunshoReport(List<ShinseishaShokaiBunshoParam> targets) {
        this.targets = targets;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<ShinseishaShokaiBunshoReportSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<ShinseishaShokaiBunshoReportSource> reportSourceWriter) {
        for (ShinseishaShokaiBunshoParam target : this.targets) {
            ShinseishaShokaiBunshoEditor editor = new ShinseishaShokaiBunshoEditor(target);
            IShinseishaShokaiBunshoBuilder builder = new ShinseishaShokaiBunshoBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
