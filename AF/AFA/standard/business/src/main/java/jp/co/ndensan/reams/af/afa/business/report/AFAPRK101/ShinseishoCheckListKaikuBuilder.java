package jp.co.ndensan.reams.af.afa.business.report.AFAPRK101;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRK101.ShinseishoCheckListKaikuSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 申請書チェックリスト
 *
 * @reamsid_L AF-0460-032 wanghj
 */
public class ShinseishoCheckListKaikuBuilder implements IShinseishoCheckListKaikuBuilder {

    private final ShinseishoCheckListKaikuEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link ShinseishoCheckListKaikuEditor}
     */
    public ShinseishoCheckListKaikuBuilder(ShinseishoCheckListKaikuEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return NyujokenHagakiSource
     */
    @Override
    public ShinseishoCheckListKaikuSource build() {
        return ReportEditorJoiner.from(new ShinseishoCheckListKaikuSource()).join(this.editor).buildSource();
    }

}
