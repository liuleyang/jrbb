package jp.co.ndensan.reams.af.afa.business.report.AFAPRC201;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRC201.YubinTohyoShomeishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 郵便等投票証明書
 *
 * @reamsid_L AF-0200-030 lis2
 */
public class YubinTohyoShomeishoBuilder implements IYubinTohyoShomeishoBuilder {

    private final YubinTohyoShomeishoEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link YubinTohyoShomeishoEditor}
     */
    public YubinTohyoShomeishoBuilder(YubinTohyoShomeishoEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return YubinTohyoShomeishoReportSource
     */
    @Override
    public YubinTohyoShomeishoReportSource build() {
        return ReportEditorJoiner.from(new YubinTohyoShomeishoReportSource()).join(this.editor).buildSource();
    }

}
