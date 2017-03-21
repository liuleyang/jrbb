package jp.co.ndensan.reams.af.afa.business.report.AFAPRB310;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.TohyoKanrihyoParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB310.TohyoKanrihyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 在外選挙投票管理表
 *
 * @reamsid_L AF-0350-033 wangh
 */
public class TohyoKanrihyoReport extends Report<TohyoKanrihyoReportSource> {

    private final List<TohyoKanrihyoParam> targets;
    private final TeijiCommonJohoItem item;

    /**
     * コンストラクタです。
     *
     * @param targets List<TohyoKanrihyoParam>
     * @param item TeijiCommonJohoItem
     */
    public TohyoKanrihyoReport(List<TohyoKanrihyoParam> targets, TeijiCommonJohoItem item) {
        this.targets = targets;
        this.item = item;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<TohyoKanrihyoReportSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<TohyoKanrihyoReportSource> reportSourceWriter) {
        for (TohyoKanrihyoParam target : this.targets) {
            TohyoKanrihyoEditor editor = new TohyoKanrihyoEditor(target, item);
            ITohyoKanrihyoBuilder builder = new TohyoKanrihyoBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
