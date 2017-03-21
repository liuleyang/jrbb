package jp.co.ndensan.reams.af.afa.business.report.AFAPRK100;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRK100.MeiboShohonKaikuSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 海区漁業調整委員会委員選挙人名簿抄本
 *
 * @reamsid_L AF-0460-031 wanghj
 */
public class MeiboShohonKaikuBuilder implements IMeiboShohonKaikuBuilder {

    private final MeiboShohonKaikuEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link MeiboShohonKaikuEditor}
     */
    public MeiboShohonKaikuBuilder(MeiboShohonKaikuEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return NyujokenHagakiSource
     */
    @Override
    public MeiboShohonKaikuSource build() {
        return ReportEditorJoiner.from(new MeiboShohonKaikuSource()).join(this.editor).buildSource();
    }

}
