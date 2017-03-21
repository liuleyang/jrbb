package jp.co.ndensan.reams.af.afa.business.report.AFAPRE214;

import jp.co.ndensan.reams.af.afa.business.core.AtenaSeal21Param;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE214.AtenaSeal21Source;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 宛名シール21面
 *
 * @reamsid_L AF-0620-033 wangh
 */
public class AtenaSeal21Report extends Report<AtenaSeal21Source> {

    private final AtenaSeal21Param target;

    /**
     * コンストラクタです。
     *
     * @param target AtenaSeal21Param
     */
    public AtenaSeal21Report(AtenaSeal21Param target) {
        this.target = target;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<AtenaSeal21Source>}
     */
    @Override
    public void writeBy(ReportSourceWriter<AtenaSeal21Source> reportSourceWriter) {
        AtenaSeal21Editor editor = new AtenaSeal21Editor(target);
        IAtenaSeal21Builder builder = new AtenaSeal21Builder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
