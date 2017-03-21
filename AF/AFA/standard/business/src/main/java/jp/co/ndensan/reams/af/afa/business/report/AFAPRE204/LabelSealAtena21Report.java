package jp.co.ndensan.reams.af.afa.business.report.AFAPRE204;

import jp.co.ndensan.reams.af.afa.business.core.LabelSealAtena21Param;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE204.LabelSealAtena21Source;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * ラベルシール（宛名シール用紙21面）
 *
 * @reamsid_L AF-0620-031 wangh
 */
public class LabelSealAtena21Report extends Report<LabelSealAtena21Source> {

    private final LabelSealAtena21Param target;

    /**
     * コンストラクタです。
     *
     * @param target LabelSealAtena21Param
     */
    public LabelSealAtena21Report(LabelSealAtena21Param target) {
        this.target = target;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<LabelSealAtena21Source>}
     */
    @Override
    public void writeBy(ReportSourceWriter<LabelSealAtena21Source> reportSourceWriter) {
        LabelSealAtena21Editor editor = new LabelSealAtena21Editor(target);
        ILabelSealAtena21Builder builder = new LabelSealAtena21Builder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
