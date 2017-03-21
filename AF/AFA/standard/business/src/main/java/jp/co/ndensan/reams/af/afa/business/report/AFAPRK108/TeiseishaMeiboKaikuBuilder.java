package jp.co.ndensan.reams.af.afa.business.report.AFAPRK108;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRK108.TeiseishaMeiboKaikuSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 訂正者名簿
 *
 * @reamsid_L AF-0460-035 wanghj
 */
public class TeiseishaMeiboKaikuBuilder implements ITeiseishaMeiboKaikuBuilder {

    private final TeiseishaMeiboKaikuEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link TeiseishaMeiboKaikuEditor}
     */
    public TeiseishaMeiboKaikuBuilder(TeiseishaMeiboKaikuEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return TeiseishaMeiboKaikuSource
     */
    @Override
    public TeiseishaMeiboKaikuSource build() {
        return ReportEditorJoiner.from(new TeiseishaMeiboKaikuSource()).join(this.editor).buildSource();
    }

}
