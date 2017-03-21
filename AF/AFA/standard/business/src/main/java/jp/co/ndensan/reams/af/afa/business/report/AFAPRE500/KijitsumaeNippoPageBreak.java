package jp.co.ndensan.reams.af.afa.business.report.AFAPRE500;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE500.KijitsumaeNippoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 期日前投票日報
 *
 * @reamsid_L AF-0270-030 wangl
 */
public class KijitsumaeNippoPageBreak extends PageBreaker<KijitsumaeNippoReportSource> {

    @Override
    public List<RString> breakKeys() {
        List<RString> breakKeys = new ArrayList<>();
        breakKeys.add(new RString("senkyoNo"));
        breakKeys.add(new RString("shisetsuCode"));
        return breakKeys;
    }
}
