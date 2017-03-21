package jp.co.ndensan.reams.af.afa.business.report.AFAPRB202;

import jp.co.ndensan.reams.af.afa.business.core.NyujokenHagakiParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB202.NyujokenHagakiSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 投票所入場券（はがき4つ切り）
 *
 * @reamsid_L AF-0160-032 guyq
 */
public class NyujokenHagakiReport extends Report<NyujokenHagakiSource> {

    private final NyujokenHagakiParam target;

    /**
     * コンストラクタです。
     *
     * @param target NyujokenHagakiParam
     */
    public NyujokenHagakiReport(NyujokenHagakiParam target) {
        this.target = target;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<NyujokenHagakiSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<NyujokenHagakiSource> reportSourceWriter) {
        NyujokenHagakiEditor editor = new NyujokenHagakiEditor(target);
        INyujokenHagakiBuilder builder = new NyujokenHagakiBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
