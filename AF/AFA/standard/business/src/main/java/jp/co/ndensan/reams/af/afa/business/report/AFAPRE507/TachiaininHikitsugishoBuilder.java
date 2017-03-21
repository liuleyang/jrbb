package jp.co.ndensan.reams.af.afa.business.report.AFAPRE507;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE507.TachiaininHikitsugishoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 投票立会人引継書
 *
 * @reamsid_L AF-0120-020 jihb
 */
public class TachiaininHikitsugishoBuilder implements ITachiaininHikitsugishoBuilder {

    private final TachiaininHikitsugishoEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link TachiaininHikitsugishoEditor}
     */
    public TachiaininHikitsugishoBuilder(TachiaininHikitsugishoEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return TachiaininHikitsugishoReportSource
     */
    @Override
    public TachiaininHikitsugishoSource build() {
        return ReportEditorJoiner.from(new TachiaininHikitsugishoSource()).join(this.editor).buildSource();
    }

}
