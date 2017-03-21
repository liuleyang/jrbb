package jp.co.ndensan.reams.af.afa.business.report.AFAPRB204;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB204.NyujokenPostexSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 投票所入場券（ポステックス）
 *
 * @reamsid_L AF-0160-034 guyq
 */
public class NyujokenPostexBuilder implements INyujokenPostexBuilder {

    private final NyujokenPostexEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link NyujokenPostexEditor}
     */
    public NyujokenPostexBuilder(NyujokenPostexEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return NyujokenHagakiSource
     */
    @Override
    public NyujokenPostexSource build() {
        return ReportEditorJoiner.from(new NyujokenPostexSource()).join(this.editor).buildSource();
    }

}
