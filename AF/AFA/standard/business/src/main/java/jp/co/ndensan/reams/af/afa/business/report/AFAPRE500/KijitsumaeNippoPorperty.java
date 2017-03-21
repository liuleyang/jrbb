package jp.co.ndensan.reams.af.afa.business.report.AFAPRE500;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE500.KijitsumaeNippoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 期日前投票日報
 *
 * @reamsid_L AF-0270-030 wangl
 */
public class KijitsumaeNippoPorperty extends ReportPropertyBase<KijitsumaeNippoReportSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRE500_期日前投票日報.value());
    private static final List<RString> PAGE_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(new RString(KijitsumaeNippoReportSource.ReportSourceFields.senkyoNo.name()),
                            new RString(KijitsumaeNippoReportSource.ReportSourceFields.shisetsuCode.name())));

    /**
     * 帳票ID
     */
    public KijitsumaeNippoPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }

    @Override
    public Breakers<KijitsumaeNippoReportSource> defineBreakers(Breakers<KijitsumaeNippoReportSource> breakers,
            BreakerCatalog<KijitsumaeNippoReportSource> catalog) {
        return breakers.add(catalog.new SimpleLayoutBreaker(PAGE_BREAK_KEYS));
    }
}
