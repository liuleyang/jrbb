package jp.co.ndensan.reams.af.afa.business.report.AFAPRB303;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB303.TorokuTsuchiReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 登録した旨の通知
 *
 * @reamsid_L AF-0320-032 lis2
 */
public class TorokuTsuchiBuilder implements ITorokuTsuchiBuilder {

    private final TorokuTsuchiEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link TorokuTsuchiEditor}
     */
    public TorokuTsuchiBuilder(TorokuTsuchiEditor editor) {
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
