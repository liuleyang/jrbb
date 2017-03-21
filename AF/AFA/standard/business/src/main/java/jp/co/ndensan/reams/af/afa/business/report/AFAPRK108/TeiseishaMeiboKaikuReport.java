package jp.co.ndensan.reams.af.afa.business.report.AFAPRK108;

import jp.co.ndensan.reams.af.afa.business.core.TeiseishaMeiboKaikuParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRK108.TeiseishaMeiboKaikuSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 訂正者名簿
 *
 * @reamsid_L AF-0460-035 wanghj
 */
public class TeiseishaMeiboKaikuReport extends Report<TeiseishaMeiboKaikuSource> {

    private final TeiseishaMeiboKaikuParam target;

    /**
     * コンストラクタです。
     *
     * @param target TeiseishaMeiboKaikuParam
     */
    public TeiseishaMeiboKaikuReport(TeiseishaMeiboKaikuParam target) {
        this.target = target;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<TeiseishaMeiboKaikuSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<TeiseishaMeiboKaikuSource> reportSourceWriter) {
        TeiseishaMeiboKaikuEditor editor = new TeiseishaMeiboKaikuEditor(target);
        ITeiseishaMeiboKaikuBuilder builder = new TeiseishaMeiboKaikuBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
