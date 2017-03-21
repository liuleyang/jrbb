package jp.co.ndensan.reams.af.afa.business.report.AFAPRK100;

import jp.co.ndensan.reams.af.afa.business.core.MeiboShohonKaikuParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRK100.MeiboShohonKaikuSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 海区漁業調整委員会委員選挙人名簿抄本
 *
 * @reamsid_L AF-0460-031 wanghj
 */
public class MeiboShohonKaikuReport extends Report<MeiboShohonKaikuSource> {

    private final MeiboShohonKaikuParam target;

    /**
     * コンストラクタです。
     *
     * @param target MeiboShohonKaikuParam
     */
    public MeiboShohonKaikuReport(MeiboShohonKaikuParam target) {
        this.target = target;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<MeiboShohonKaikuSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<MeiboShohonKaikuSource> reportSourceWriter) {
        MeiboShohonKaikuEditor editor = new MeiboShohonKaikuEditor(target);
        IMeiboShohonKaikuBuilder builder = new MeiboShohonKaikuBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
