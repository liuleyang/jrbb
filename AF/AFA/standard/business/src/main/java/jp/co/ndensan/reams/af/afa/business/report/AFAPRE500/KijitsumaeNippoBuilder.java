package jp.co.ndensan.reams.af.afa.business.report.AFAPRE500;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE500.KijitsumaeNippoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 期日前投票日報
 *
 * @reamsid_L AF-0270-030 wangl
 */
public class KijitsumaeNippoBuilder implements IKijitsumaeNippoBuilder {

    private final KijitsumaeNippoEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link KijitsumaeNippoEditor}
     */
    public KijitsumaeNippoBuilder(KijitsumaeNippoEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return KijitsumaeNippoReportSource
     */
    @Override
    public KijitsumaeNippoReportSource build() {
        return ReportEditorJoiner.from(new KijitsumaeNippoReportSource()).join(this.editor).buildSource();
    }

}
