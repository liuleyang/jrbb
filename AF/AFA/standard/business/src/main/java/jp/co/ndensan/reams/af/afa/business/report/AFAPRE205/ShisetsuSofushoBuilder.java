package jp.co.ndensan.reams.af.afa.business.report.AFAPRE205;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE205.ShisetsuSofushoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 施設送付書
 *
 * @reamsid_L AF-0250-030 jihb
 */
public class ShisetsuSofushoBuilder implements IShisetsuSofushoBuilder {

    private final IShisetsuSofushoEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link ShisetsuSofushoEditor}
     */
    public ShisetsuSofushoBuilder(IShisetsuSofushoEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return NyujokenHagakiSource
     */
    @Override
    public ShisetsuSofushoSource build() {
        return ReportEditorJoiner.from(new ShisetsuSofushoSource()).join(this.editor).buildSource();
    }

}
