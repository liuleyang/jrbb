package jp.co.ndensan.reams.af.afa.business.report.AFAPRE501;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE501.FuzaihsaNippoReportSource;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE508.TohyoShukeiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 不在者投票日報
 *
 * @reamsid_L AF-0270-031 wangl
 */
public class FuzaihsaNippoPorperty extends ReportPropertyBase<FuzaihsaNippoReportSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRE501_不在者投票日報.value());
    private static final List<RString> PAGE_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(new RString(TohyoShukeiReportSource.ReportSourceFileds.senkyoNo.name())));

    /**
     * 帳票ID
     */
    public FuzaihsaNippoPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }

    @Override
    public Breakers<FuzaihsaNippoReportSource> defineBreakers(Breakers<FuzaihsaNippoReportSource> breakers,
            BreakerCatalog<FuzaihsaNippoReportSource> catalog) {
        return breakers.add(catalog.new SimpleLayoutBreaker(PAGE_BREAK_KEYS));
    }
}
