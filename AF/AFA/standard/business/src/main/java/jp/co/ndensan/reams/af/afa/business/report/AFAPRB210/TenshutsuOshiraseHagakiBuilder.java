package jp.co.ndensan.reams.af.afa.business.report.AFAPRB210;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB210.TenshutsuOshiraseHagakiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 転出者お知らせハガキ
 *
 * @reamsid_L AF-0160-035 jihb
 */
public class TenshutsuOshiraseHagakiBuilder implements ITenshutsuOshiraseHagakiBuilder {

    private final TenshutsuOshiraseHagakiEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link TenshutsuOshiraseHagakiEditor}
     */
    public TenshutsuOshiraseHagakiBuilder(TenshutsuOshiraseHagakiEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return NyujokenHagakiSource
     */
    @Override
    public TenshutsuOshiraseHagakiSource build() {
        return ReportEditorJoiner.from(new TenshutsuOshiraseHagakiSource()).join(this.editor).buildSource();
    }

}
