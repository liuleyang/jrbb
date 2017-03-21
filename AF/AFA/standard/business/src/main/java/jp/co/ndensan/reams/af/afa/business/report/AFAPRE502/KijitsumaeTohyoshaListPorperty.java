package jp.co.ndensan.reams.af.afa.business.report.AFAPRE502;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE502.KijitsumaeTohyoshaListReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 期日前投票者一覧表
 *
 * @reamsid_L AF-0270-033 wangl
 */
public class KijitsumaeTohyoshaListPorperty extends ReportPropertyBase<KijitsumaeTohyoshaListReportSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRE502_期日前投票者一覧表.value());
    private static final List<RString> PAGE_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(new RString(KijitsumaeTohyoshaListReportSource.ReportSourceFields.key1.name()),
                            new RString(KijitsumaeTohyoshaListReportSource.ReportSourceFields.key2.name())));

    /**
     * 帳票ID
     */
    public KijitsumaeTohyoshaListPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }

    @Override
    public Breakers<KijitsumaeTohyoshaListReportSource> defineBreakers(Breakers<KijitsumaeTohyoshaListReportSource> breakers,
            BreakerCatalog<KijitsumaeTohyoshaListReportSource> catalog) {
        return breakers.add(catalog.new SimpleLayoutBreaker(PAGE_BREAK_KEYS));
    }
}
