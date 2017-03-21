package jp.co.ndensan.reams.af.afa.business.report.AFAPRE213;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE213.AtenaSeal12Source;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 宛名シール12面
 *
 * @reamsid_L AF-0620-032 wangh
 */
public class AtenaSeal12Builder implements IAtenaSeal12Builder {

    private final AtenaSeal12Editor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link AtenaSeal12Editor}
     */
    public AtenaSeal12Builder(AtenaSeal12Editor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return AtenaSeal12Source
     */
    @Override
    public AtenaSeal12Source build() {
        return ReportEditorJoiner.from(new AtenaSeal12Source()).join(this.editor).buildSource();
    }

}
