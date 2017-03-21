package jp.co.ndensan.reams.af.afa.business.report.AFAPRB202;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB202.NyujokenHagakiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 投票所入場券（はがき4つ切り）
 *
 * @reamsid_L AF-0160-032 guyq
 */
public class NyujokenHagakiBuilder implements INyujokenHagakiBuilder {

    private final NyujokenHagakiEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link NyujokenHagakiEditor}
     */
    public NyujokenHagakiBuilder(NyujokenHagakiEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return NyujokenHagakiSource
     */
    @Override
    public NyujokenHagakiSource build() {
        return ReportEditorJoiner.from(new NyujokenHagakiSource()).join(this.editor).buildSource();
    }

}
