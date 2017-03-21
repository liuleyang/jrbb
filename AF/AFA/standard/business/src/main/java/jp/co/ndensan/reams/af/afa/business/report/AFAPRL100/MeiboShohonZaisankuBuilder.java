package jp.co.ndensan.reams.af.afa.business.report.AFAPRL100;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRL100.MeiboShohonZaisankuSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 財産区選挙人名簿抄本
 *
 * @reamsid_L AF-0600-030 lis
 */
public class MeiboShohonZaisankuBuilder implements IMeiboShohonZaisankuBuilder {

    private final MeiboShohonZaisankuEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link MeiboShohonZaisankuEditor}
     */
    public MeiboShohonZaisankuBuilder(MeiboShohonZaisankuEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return MeiboShohonZaisankuSource
     */
    @Override
    public MeiboShohonZaisankuSource build() {
        return ReportEditorJoiner.from(new MeiboShohonZaisankuSource()).join(this.editor).buildSource();
    }
}
