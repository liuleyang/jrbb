package jp.co.ndensan.reams.af.afa.business.report.AFAPRB201;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB201.Nyujoken3tsuoriSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 投票所入場券（個票3つ折り）
 *
 * @reamsid_L AF-0160-031 zhanggs
 */
public class Nyujoken3tsuoriBuilder implements INyujoken3tsuoriBuilder {

    private final Nyujoken3tsuoriEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link Nyujoken3tsuoriEditor}
     */
    public Nyujoken3tsuoriBuilder(Nyujoken3tsuoriEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return NyujokenHagakiSource
     */
    @Override
    public Nyujoken3tsuoriSource build() {
        return ReportEditorJoiner.from(new Nyujoken3tsuoriSource()).join(this.editor).buildSource();
    }

}
