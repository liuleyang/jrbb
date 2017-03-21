package jp.co.ndensan.reams.af.afa.business.report.AFAPRB203;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB203.NyujokenSealerSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 投票所入場券（シーラー）
 *
 * @reamsid_L AF-0160-033 xul
 */
public class NyujokenSealerBuilder implements INyujokenSealerBuilder {

    private final NyujokenSealerEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link NyujokenSealerEditor}
     */
    public NyujokenSealerBuilder(NyujokenSealerEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return NyujokenHagakiSource
     */
    @Override
    public NyujokenSealerSource build() {
        return ReportEditorJoiner.from(new NyujokenSealerSource()).join(this.editor).buildSource();
    }

}
