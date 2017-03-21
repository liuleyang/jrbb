package jp.co.ndensan.reams.af.afa.business.report.AFAPRB305;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB305.NotTorokuTsuchiRyojikanReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 登録を行わなかった旨の通知（領事官）
 *
 * @reamsid_L AF-0320-034 lis2
 */
public class NotTorokuTsuchiRyojikanBuilder implements INotTorokuTsuchiRyojikanBuilder {

    private final NotTorokuTsuchiRyojikanEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link NotTorokuTsuchiRyojikanEditor}
     */
    public NotTorokuTsuchiRyojikanBuilder(NotTorokuTsuchiRyojikanEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return NotTorokuTsuchiRyojikanReportSource
     */
    @Override
    public NotTorokuTsuchiRyojikanReportSource build() {
        return ReportEditorJoiner.from(new NotTorokuTsuchiRyojikanReportSource()).join(this.editor).buildSource();
    }

}
