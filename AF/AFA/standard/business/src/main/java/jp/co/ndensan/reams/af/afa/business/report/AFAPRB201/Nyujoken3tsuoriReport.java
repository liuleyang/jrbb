package jp.co.ndensan.reams.af.afa.business.report.AFAPRB201;

import jp.co.ndensan.reams.af.afa.business.core.Nyujoken3tsuoriParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB201.Nyujoken3tsuoriSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 投票所入場券（個票3つ折り）
 *
 * @reamsid_L AF-0160-031 zhanggs
 */
public class Nyujoken3tsuoriReport extends Report<Nyujoken3tsuoriSource> {

    private final Nyujoken3tsuoriParam target;

    /**
     * コンストラクタです。
     *
     * @param target Nyujoken3tsuoriParam
     */
    public Nyujoken3tsuoriReport(Nyujoken3tsuoriParam target) {
        this.target = target;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<Nyujoken3tsuoriSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<Nyujoken3tsuoriSource> reportSourceWriter) {
        Nyujoken3tsuoriEditor editor = new Nyujoken3tsuoriEditor(target);
        INyujoken3tsuoriBuilder builder = new Nyujoken3tsuoriBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
