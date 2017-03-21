package jp.co.ndensan.reams.af.afa.business.report.AFAPRB305;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB305.NotTorokuTsuchiRyojikanReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 再交付通知
 *
 * @reamsid_L AF-0340-020 liuj2
 */
public class SaikofuTsuchiBuilder implements ISaikofuTsuchiBuilder {

    private final SaikofuTsuchiEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link SaikofuTsuchiEditor}
     */
    public SaikofuTsuchiBuilder(SaikofuTsuchiEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return NotTorokuTsuchiRyojikanReportSource
     */
    @Override
    public NotTorokuTsuchiRyojikanReportSource build() {
        return ReportEditorJoiner.from(new NotTorokuTsuchiRyojikanReportSource()).join(this.editor).buildSource();
    }

}
