package jp.co.ndensan.reams.af.afa.business.report.AFAPRK105;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRK105.ShinkiTorokushaMeiboKaikuSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 新規登録者名簿
 *
 * @reamsid_L AF-0460-034 wanghj
 */
public class ShinkiTorokushaMeiboKaikuBuilder implements IShinkiTorokushaMeiboKaikuBuilder {

    private final ShinkiTorokushaMeiboKaikuEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link ShinkiTorokushaMeiboKaikuEditor}
     */
    public ShinkiTorokushaMeiboKaikuBuilder(ShinkiTorokushaMeiboKaikuEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return ShinkiTorokushaMeiboKaikuSource
     */
    @Override
    public ShinkiTorokushaMeiboKaikuSource build() {
        return ReportEditorJoiner.from(new ShinkiTorokushaMeiboKaikuSource()).join(this.editor).buildSource();
    }

}
