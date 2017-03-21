package jp.co.ndensan.reams.af.afa.business.report.AFAPRE501;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE501.FuzaihsaNippoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 不在者投票日報
 *
 * @reamsid_L AF-0270-031 wangl
 */
public class FuzaihsaNippoBuilder implements IFuzaihsaNippoBuilder {

    private final FuzaihsaNippoEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link FuzaihsaNippoEditor}
     */
    public FuzaihsaNippoBuilder(FuzaihsaNippoEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return FuzaihsaNippoReportSource
     */
    @Override
    public FuzaihsaNippoReportSource build() {
        return ReportEditorJoiner.from(new FuzaihsaNippoReportSource()).join(this.editor).buildSource();
    }

}
