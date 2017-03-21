package jp.co.ndensan.reams.af.afa.business.report.AFAPRB303;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB303.TorokuTsuchiReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 抹消通知（本籍地）
 *
 * @reamsid_L AF-0350-030 wangh
 */
public class MasshoTsuchiHonsekiBuilder implements IMasshoTsuchiHonsekiBuilder {

    private final MasshoTsuchiHonsekiEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link MasshoTsuchiHonsekiEditor}
     */
    public MasshoTsuchiHonsekiBuilder(MasshoTsuchiHonsekiEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return TorokuTsuchiReportSource
     */
    @Override
    public TorokuTsuchiReportSource build() {
        return ReportEditorJoiner.from(new TorokuTsuchiReportSource()).join(this.editor).buildSource();
    }

}
