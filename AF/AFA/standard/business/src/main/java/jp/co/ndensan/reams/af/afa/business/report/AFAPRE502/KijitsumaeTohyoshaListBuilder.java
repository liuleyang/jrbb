package jp.co.ndensan.reams.af.afa.business.report.AFAPRE502;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE502.KijitsumaeTohyoshaListReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 期日前投票者一覧表
 *
 * @reamsid_L AF-0270-033 wangl
 */
public class KijitsumaeTohyoshaListBuilder implements IKijitsumaeTohyoshaListBuilder {

    private final KijitsumaeTohyoshaListEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link KijitsumaeTohyoshaListEditor}
     */
    public KijitsumaeTohyoshaListBuilder(KijitsumaeTohyoshaListEditor editor) {
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
