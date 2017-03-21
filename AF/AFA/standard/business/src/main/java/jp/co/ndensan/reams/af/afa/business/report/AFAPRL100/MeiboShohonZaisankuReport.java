package jp.co.ndensan.reams.af.afa.business.report.AFAPRL100;

import jp.co.ndensan.reams.af.afa.business.core.MeiboShohonZaisankuParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRL100.MeiboShohonZaisankuSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 財産区選挙人名簿抄本
 *
 * @reamsid_L AF-0600-030 lis
 */
public class MeiboShohonZaisankuReport extends Report<MeiboShohonZaisankuSource> {

    private final MeiboShohonZaisankuParam target;

    /**
     * コンストラクタです。
     *
     * @param target MeiboShohonZaisankuParam
     */
    public MeiboShohonZaisankuReport(MeiboShohonZaisankuParam target) {
        this.target = target;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<MeiboShohonZaisankuSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<MeiboShohonZaisankuSource> reportSourceWriter) {
        MeiboShohonZaisankuEditor editor = new MeiboShohonZaisankuEditor(target);
        IMeiboShohonZaisankuBuilder builder = new MeiboShohonZaisankuBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
