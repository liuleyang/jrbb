package jp.co.ndensan.reams.af.afa.business.report.AFAPRC203;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRC203.NankyokuSenkyoninShomeishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 南極選挙人証
 *
 * @reamsid_L AF-0220-020 lis2
 */
public class NankyokuSenkyoninShomeishoBuilder implements INankyokuSenkyoninShomeishoBuilder {

    private final NankyokuSenkyoninShomeishoEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link NankyokuSenkyoninShomeishoEditor}
     */
    public NankyokuSenkyoninShomeishoBuilder(NankyokuSenkyoninShomeishoEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return NankyokuSenkyoninShomeishoReportSource
     */
    @Override
    public NankyokuSenkyoninShomeishoReportSource build() {
        return ReportEditorJoiner.from(new NankyokuSenkyoninShomeishoReportSource()).join(this.editor).buildSource();
    }

}
