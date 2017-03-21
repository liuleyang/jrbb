package jp.co.ndensan.reams.af.afa.business.report.AFAPRE203;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE203.LabelSealAtena12Source;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * ラベルシール（宛名シール用紙12面）
 *
 * @reamsid_L AF-0620-030 wangh
 */
public class LabelSealAtena12Builder implements ILabelSealAtena12Builder {

    private final LabelSealAtena12Editor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link LabelSealAtena12Editor}
     */
    public LabelSealAtena12Builder(LabelSealAtena12Editor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return NyujokenHagakiSource
     */
    @Override
    public LabelSealAtena12Source build() {
        return ReportEditorJoiner.from(new LabelSealAtena12Source()).join(this.editor).buildSource();
    }

}
