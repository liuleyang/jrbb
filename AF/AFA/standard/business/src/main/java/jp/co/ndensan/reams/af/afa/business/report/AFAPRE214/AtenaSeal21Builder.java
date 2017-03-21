package jp.co.ndensan.reams.af.afa.business.report.AFAPRE214;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE214.AtenaSeal21Source;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 宛名シール21面
 *
 * @reamsid_L AF-0620-033 wangh
 */
public class AtenaSeal21Builder implements IAtenaSeal21Builder {

    private final AtenaSeal21Editor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link AtenaSeal21Editor}
     */
    public AtenaSeal21Builder(AtenaSeal21Editor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return AtenaSeal21Source
     */
    @Override
    public AtenaSeal21Source build() {
        return ReportEditorJoiner.from(new AtenaSeal21Source()).join(this.editor).buildSource();
    }

}
