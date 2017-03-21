package jp.co.ndensan.reams.af.afa.business.report.AFAPRB305;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB305.NotTorokuTsuchiRyojikanReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 記載事項変更通知（本人）
 *
 * @reamsid_L AF-0330-030 zhangl
 */
public class KisaijikoHenkoTsuchiHonninBuilder implements IKisaijikoHenkoTsuchiHonninBuilder {

    private final KisaijikoHenkoTsuchiHonninEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link KisaijikoHenkoTsuchiHonninEditor}
     */
    public KisaijikoHenkoTsuchiHonninBuilder(KisaijikoHenkoTsuchiHonninEditor editor) {
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
