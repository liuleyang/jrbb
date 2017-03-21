package jp.co.ndensan.reams.af.afa.business.report.AFAPRB302;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB302.ShinseishaShokaiBunshoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 申請者の被登録資格の照会文書
 *
 * @reamsid_L AF-0320-031 lis2
 */
public class ShinseishaShokaiBunshoBuilder implements IShinseishaShokaiBunshoBuilder {

    private final ShinseishaShokaiBunshoEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link ShinseishaShokaiBunshoEditor}
     */
    public ShinseishaShokaiBunshoBuilder(ShinseishaShokaiBunshoEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return ShinseishaShokaiBunshoReportSource
     */
    @Override
    public ShinseishaShokaiBunshoReportSource build() {
        return ReportEditorJoiner.from(new ShinseishaShokaiBunshoReportSource()).join(this.editor).buildSource();
    }

}
