package jp.co.ndensan.reams.af.afa.business.report.AFAPRB306;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB306.KisaijikoHenkoTsuchiRyojikanReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 抹消通知（領事官）
 *
 * @reamsid_L AF-0350-031 wangh
 */
public class MasshoTsuchiRyojikanBuilder implements IMasshoTsuchiRyojikanBuilder {

    private final MasshoTsuchiRyojikanEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link MasshoTsuchiRyojikanEditor}
     */
    public MasshoTsuchiRyojikanBuilder(MasshoTsuchiRyojikanEditor editor) {
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
