package jp.co.ndensan.reams.af.afa.business.report.AFAPRB214;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB214.NyujokenTestPrintDataListSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 入場券テストデータ抽出一覧表
 *
 * @reamsid_L AF-0160-038 wangh
 */
public class NyujokenTestPrintDataListBuilder implements INyujokenTestPrintDataListBuilder {

    private final NyujokenTestPrintDataListEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link NyujokenTestPrintDataListEditor}
     */
    public NyujokenTestPrintDataListBuilder(NyujokenTestPrintDataListEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return NyujokenTestPrintDataListSource
     */
    @Override
    public NyujokenTestPrintDataListSource build() {
        return ReportEditorJoiner.from(new NyujokenTestPrintDataListSource()).join(this.editor).buildSource();
    }
}
