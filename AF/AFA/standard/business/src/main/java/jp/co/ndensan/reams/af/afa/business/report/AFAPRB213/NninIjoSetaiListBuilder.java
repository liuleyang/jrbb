package jp.co.ndensan.reams.af.afa.business.report.AFAPRB213;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB213.NninIjoSetaiListSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * n人以上世帯一覧表
 *
 * @reamsid_L AF-0160-037 wangh
 */
public class NninIjoSetaiListBuilder implements INninIjoSetaiListBuilder {

    private final NninIjoSetaiListEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link NninIjoSetaiListEditor}
     */
    public NninIjoSetaiListBuilder(NninIjoSetaiListEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return NyujokenHagakiSource
     */
    @Override
    public NninIjoSetaiListSource build() {
        return ReportEditorJoiner.from(new NninIjoSetaiListSource()).join(this.editor).buildSource();
    }

}
