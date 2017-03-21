package jp.co.ndensan.reams.af.afa.business.report.AFAPRE502;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE502.KijitsumaeTohyoshaListReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 不在者投票者一覧表のページブレーククラス
 *
 * @reamsid_L AF-0270-032 wangl
 */
public class FuzaishaTohyoshaListPageBreak extends PageBreaker<KijitsumaeTohyoshaListReportSource> {

    @Override
    public List<RString> breakKeys() {
        List<RString> breakKeys = new ArrayList<>();
        breakKeys.add(new RString("key1"));
        breakKeys.add(new RString("key2"));
        return breakKeys;
    }

}
