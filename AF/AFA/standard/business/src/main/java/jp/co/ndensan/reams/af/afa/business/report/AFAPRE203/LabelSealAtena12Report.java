package jp.co.ndensan.reams.af.afa.business.report.AFAPRE203;

import jp.co.ndensan.reams.af.afa.business.core.LabelSealAtena12Param;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE203.LabelSealAtena12Source;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * ラベルシール（宛名シール用紙12面）
 *
 * @reamsid_L AF-0620-030 wangh
 */
public class LabelSealAtena12Report extends Report<LabelSealAtena12Source> {

    private final LabelSealAtena12Param target;

    /**
     * コンストラクタです。
     *
     * @param target LabelSealAtena12Param
     */
    public LabelSealAtena12Report(LabelSealAtena12Param target) {
        this.target = target;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<LabelSealAtena12Source>}
     */
    @Override
    public void writeBy(ReportSourceWriter<LabelSealAtena12Source> reportSourceWriter) {
        LabelSealAtena12Editor editor = new LabelSealAtena12Editor(target);
        ILabelSealAtena12Builder builder = new LabelSealAtena12Builder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
