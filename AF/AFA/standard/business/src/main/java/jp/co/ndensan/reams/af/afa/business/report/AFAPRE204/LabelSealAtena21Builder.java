package jp.co.ndensan.reams.af.afa.business.report.AFAPRE204;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE204.LabelSealAtena21Source;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * ラベルシール（宛名シール用紙21面）
 *
 * @reamsid_L AF-0620-031 wangh
 */
public class LabelSealAtena21Builder implements ILabelSealAtena21Builder {

    private final LabelSealAtena21Editor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link LabelSealAtena21Editor}
     */
    public LabelSealAtena21Builder(LabelSealAtena21Editor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return NyujokenHagakiSource
     */
    @Override
    public LabelSealAtena21Source build() {
        return ReportEditorJoiner.from(new LabelSealAtena21Source()).join(this.editor).buildSource();
    }

}
