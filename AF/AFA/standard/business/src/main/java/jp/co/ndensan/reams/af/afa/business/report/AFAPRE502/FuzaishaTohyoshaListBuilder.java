package jp.co.ndensan.reams.af.afa.business.report.AFAPRE502;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE502.KijitsumaeTohyoshaListReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 不在者投票者一覧表
 *
 * @reamsid_L AF-0270-032 wangl
 */
public class FuzaishaTohyoshaListBuilder implements IFuzaishaTohyoshaListBuilder {

    private final FuzaishaTohyoshaListEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link FuzaishaTohyoshaListEditor}
     */
    public FuzaishaTohyoshaListBuilder(FuzaishaTohyoshaListEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return KijitsumaeTohyoshaListReportSource
     */
    @Override
    public KijitsumaeTohyoshaListReportSource build() {
        return ReportEditorJoiner.from(new KijitsumaeTohyoshaListReportSource()).join(this.editor).buildSource();
    }

}
