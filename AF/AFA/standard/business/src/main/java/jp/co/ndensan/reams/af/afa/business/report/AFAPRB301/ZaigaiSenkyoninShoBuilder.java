package jp.co.ndensan.reams.af.afa.business.report.AFAPRB301;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB301.ZaigaiSenkyoninShoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 在外選挙人証
 *
 * @reamsid_L AF-0320-030 lis2
 */
public class ZaigaiSenkyoninShoBuilder implements IZaigaiSenkyoninShoBuilder {

    private final ZaigaiSenkyoninShoEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link ZaigaiSenkyoninShoEditor}
     */
    public ZaigaiSenkyoninShoBuilder(ZaigaiSenkyoninShoEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return ZaigaiSenkyoninShoReportSource
     */
    @Override
    public ZaigaiSenkyoninShoReportSource build() {
        return ReportEditorJoiner.from(new ZaigaiSenkyoninShoReportSource()).join(this.editor).buildSource();
    }

}
