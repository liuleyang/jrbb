package jp.co.ndensan.reams.af.afa.business.report.AFAPRB310;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB310.TohyoKanrihyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 在外選挙投票管理表
 *
 * @reamsid_L AF-0350-033 wangh
 */
public class TohyoKanrihyoBuilder implements ITohyoKanrihyoBuilder {

    private final TohyoKanrihyoEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link TohyoKanrihyoEditor}
     */
    public TohyoKanrihyoBuilder(TohyoKanrihyoEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return TohyoKanrihyoReportSource
     */
    @Override
    public TohyoKanrihyoReportSource build() {
        return ReportEditorJoiner.from(new TohyoKanrihyoReportSource()).join(this.editor).buildSource();
    }

}
