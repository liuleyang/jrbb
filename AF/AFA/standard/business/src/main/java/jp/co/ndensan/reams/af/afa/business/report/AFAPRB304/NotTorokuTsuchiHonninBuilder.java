package jp.co.ndensan.reams.af.afa.business.report.AFAPRB304;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB304.NotTorokuTsuchiHonninReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 登録を行わなかった旨の通知（本人）
 *
 * @reamsid_L AF-0320-033 lis2
 */
public class NotTorokuTsuchiHonninBuilder implements INotTorokuTsuchiHonninBuilder {

    private final NotTorokuTsuchiHonninEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link NotTorokuTsuchiHonninEditor}
     */
    public NotTorokuTsuchiHonninBuilder(NotTorokuTsuchiHonninEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return NotTorokuTsuchiHonninReportSource
     */
    @Override
    public NotTorokuTsuchiHonninReportSource build() {
        return ReportEditorJoiner.from(new NotTorokuTsuchiHonninReportSource()).join(this.editor).buildSource();
    }

}
