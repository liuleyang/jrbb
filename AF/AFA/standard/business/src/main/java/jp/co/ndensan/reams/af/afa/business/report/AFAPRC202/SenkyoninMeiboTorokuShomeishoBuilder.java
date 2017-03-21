package jp.co.ndensan.reams.af.afa.business.report.AFAPRC202;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRC202.SenkyoninMeiboTorokuShomeishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 選挙人名簿登録証明書
 *
 * @reamsid_L AF-0210-030 lis2
 */
public class SenkyoninMeiboTorokuShomeishoBuilder implements ISenkyoninMeiboTorokuShomeishoBuilder {

    private final SenkyoninMeiboTorokuShomeishoEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link SenkyoninMeiboTorokuShomeishoEditor}
     */
    public SenkyoninMeiboTorokuShomeishoBuilder(SenkyoninMeiboTorokuShomeishoEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return SenkyoninMeiboTorokuShomeishoReportSource
     */
    @Override
    public SenkyoninMeiboTorokuShomeishoReportSource build() {
        return ReportEditorJoiner.from(new SenkyoninMeiboTorokuShomeishoReportSource()).join(this.editor).buildSource();
    }

}
