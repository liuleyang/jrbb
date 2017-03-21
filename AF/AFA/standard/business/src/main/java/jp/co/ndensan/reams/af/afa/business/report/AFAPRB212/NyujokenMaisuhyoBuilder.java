package jp.co.ndensan.reams.af.afa.business.report.AFAPRB212;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB212.NyujokenMaisuhyoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 投票所入場券印刷枚数表
 *
 * @reamsid_L AF-0160-036 guyq
 */
public class NyujokenMaisuhyoBuilder implements INyujokenMaisuhyoBuilder {

    private final NyujokenMaisuhyoEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link NyujokenMaisuhyoEditor}
     */
    public NyujokenMaisuhyoBuilder(NyujokenMaisuhyoEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return NyujokenHagakiSource
     */
    @Override
    public NyujokenMaisuhyoSource build() {
        return ReportEditorJoiner.from(new NyujokenMaisuhyoSource()).join(this.editor).buildSource();
    }

}
