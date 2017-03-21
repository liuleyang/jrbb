package jp.co.ndensan.reams.af.afa.business.report.AFAPRE215;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE215.AtenaSealListSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 宛名シール出力対象者一覧
 *
 * @reamsid_L AF-0620-034 wangh
 */
public class AtenaSealListBuilder implements IAtenaSealListBuilder {

    private final AtenaSealListEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link AtenaSealListEditor}
     */
    public AtenaSealListBuilder(AtenaSealListEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return NyujokenHagakiSource
     */
    @Override
    public AtenaSealListSource build() {
        return ReportEditorJoiner.from(new AtenaSealListSource()).join(this.editor).buildSource();
    }

}
