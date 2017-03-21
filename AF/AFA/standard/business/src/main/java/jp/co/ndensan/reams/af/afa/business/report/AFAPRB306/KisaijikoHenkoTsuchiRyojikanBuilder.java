package jp.co.ndensan.reams.af.afa.business.report.AFAPRB306;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB306.KisaijikoHenkoTsuchiRyojikanReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 記載事項変更通知（領事官）
 *
 * @reamsid_L AF-0330-031 zhangl
 */
public class KisaijikoHenkoTsuchiRyojikanBuilder implements IKisaijikoHenkoTsuchiRyojikanBuilder {

    private final KisaijikoHenkoTsuchiRyojikanEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link KisaijikoHenkoTsuchiRyojikanEditor}
     */
    public KisaijikoHenkoTsuchiRyojikanBuilder(KisaijikoHenkoTsuchiRyojikanEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return KisaijikoHenkoTsuchiRyojikanReportSource
     */
    @Override
    public KisaijikoHenkoTsuchiRyojikanReportSource build() {
        return ReportEditorJoiner.from(new KisaijikoHenkoTsuchiRyojikanReportSource()).join(this.editor).buildSource();
    }

}
