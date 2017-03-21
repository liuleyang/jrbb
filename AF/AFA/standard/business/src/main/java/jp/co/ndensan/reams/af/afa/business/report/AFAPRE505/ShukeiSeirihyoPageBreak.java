package jp.co.ndensan.reams.af.afa.business.report.AFAPRE505;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE505.ShukeiSeirihyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 集計整理表
 *
 * @reamsid_L AF-0270-036 wangl
 */
public class ShukeiSeirihyoPageBreak extends PageBreaker<ShukeiSeirihyoReportSource> {

    @Override
    public List<RString> breakKeys() {
        List<RString> breakKeys = new ArrayList<>();
        breakKeys.add(new RString("senkyoNo"));
        return breakKeys;
    }

}
