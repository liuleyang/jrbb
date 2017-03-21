package jp.co.ndensan.reams.af.afa.business.report.AFAPRB210;

import jp.co.ndensan.reams.af.afa.business.core.TenshutsuOshiraseHagakiParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB210.TenshutsuOshiraseHagakiSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 転出者お知らせハガキ
 *
 * @reamsid_L AF-0160-035 jihb
 */
public class TenshutsuOshiraseHagakiReport extends Report<TenshutsuOshiraseHagakiSource> {

    private final TenshutsuOshiraseHagakiParam target;

    /**
     * コンストラクタです。
     *
     * @param target TenshutsuOshiraseHagakiParam
     */
    public TenshutsuOshiraseHagakiReport(TenshutsuOshiraseHagakiParam target) {
        this.target = target;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<TenshutsuOshiraseHagakiSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<TenshutsuOshiraseHagakiSource> reportSourceWriter) {
        TenshutsuOshiraseHagakiEditor editor = new TenshutsuOshiraseHagakiEditor(target);
        ITenshutsuOshiraseHagakiBuilder builder = new TenshutsuOshiraseHagakiBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
