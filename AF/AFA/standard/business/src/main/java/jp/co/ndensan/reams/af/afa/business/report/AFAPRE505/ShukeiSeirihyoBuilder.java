package jp.co.ndensan.reams.af.afa.business.report.AFAPRE505;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE505.ShukeiSeirihyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 集計整理表
 *
 * @reamsid_L AF-0270-036 wangl
 */
public class ShukeiSeirihyoBuilder implements IShukeiSeirihyoBuilder {

    private final ShukeiSeirihyoEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link ShukeiSeirihyoEditor}
     */
    public ShukeiSeirihyoBuilder(ShukeiSeirihyoEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return ShukeiSeirihyoReportSource
     */
    @Override
    public ShukeiSeirihyoReportSource build() {
        return ReportEditorJoiner.from(new ShukeiSeirihyoReportSource()).join(this.editor).buildSource();
    }

}
