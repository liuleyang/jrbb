package jp.co.ndensan.reams.af.afa.business.report.AFAPRE205;

import jp.co.ndensan.reams.af.afa.business.core.ShisetsuSofushoParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE205.ShisetsuSofushoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 施設送付書
 *
 * @reamsid_L AF-0250-030 jihb
 */
public class ShisetsuSofushoReport extends Report<ShisetsuSofushoSource> {

    private static final RString ONE = new RString("1");
    private final ShisetsuSofushoParam target;

    /**
     * コンストラクタです。
     *
     * @param target ShisetsuSofushoParam
     */
    public ShisetsuSofushoReport(ShisetsuSofushoParam target) {
        this.target = target;
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<ShisetsuSofushoSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<ShisetsuSofushoSource> reportSourceWriter) {
        if (ONE.equals(target.getページ())) {
            IShisetsuSofushoEditor editor = new ShisetsuSofushoEditor(target);
            IShisetsuSofushoBuilder builder = new ShisetsuSofushoBuilder(editor);
            reportSourceWriter.writeLine(builder);
        } else {
            IShisetsuSofushoEditor editor = new ShisetsuSofushoMeisaiEditor(target);
            IShisetsuSofushoBuilder builder = new ShisetsuSofushoBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
