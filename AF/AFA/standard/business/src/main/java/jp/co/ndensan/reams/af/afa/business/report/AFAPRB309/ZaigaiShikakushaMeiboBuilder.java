package jp.co.ndensan.reams.af.afa.business.report.AFAPRB309;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB309.ZaigaiShikakushaMeiboReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 在外投票資格者名簿
 *
 * @reamsid_L AF-0350-032 wangh
 */
public class ZaigaiShikakushaMeiboBuilder implements IZaigaiShikakushaMeiboBuilder {

    private final ZaigaiShikakushaMeiboEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link ZaigaiShikakushaMeiboEditor}
     */
    public ZaigaiShikakushaMeiboBuilder(ZaigaiShikakushaMeiboEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return ZaigaiShikakushaMeiboReportSource
     */
    @Override
    public ZaigaiShikakushaMeiboReportSource build() {
        return ReportEditorJoiner.from(new ZaigaiShikakushaMeiboReportSource()).join(this.editor).buildSource();
    }

}
