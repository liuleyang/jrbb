package jp.co.ndensan.reams.af.afa.business.report.AFAPRB204;

import jp.co.ndensan.reams.af.afa.business.core.NyujokenPostexParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB204.NyujokenPostexSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 投票所入場券（ポステックス）
 *
 * @reamsid_L AF-0160-034 guyq
 */
public class NyujokenPostexReport extends Report<NyujokenPostexSource> {

    private final NyujokenPostexParam target;

    /**
     * コンストラクタです。
     *
     * @param target NyujokenPostexParam
     */
    public NyujokenPostexReport(NyujokenPostexParam target) {
        this.target = target;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<NyujokenPostexSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<NyujokenPostexSource> reportSourceWriter) {
        NyujokenPostexEditor editor = new NyujokenPostexEditor(target);
        INyujokenPostexBuilder builder = new NyujokenPostexBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
