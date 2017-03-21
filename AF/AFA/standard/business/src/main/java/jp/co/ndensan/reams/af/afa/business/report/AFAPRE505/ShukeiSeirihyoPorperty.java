package jp.co.ndensan.reams.af.afa.business.report.AFAPRE505;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE505.ShukeiSeirihyoReportSource;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE508.TohyoShukeiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 集計整理表
 *
 * @reamsid_L AF-0270-036 wangl
 */
public class ShukeiSeirihyoPorperty extends ReportPropertyBase<ShukeiSeirihyoReportSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRE505_集計整理表.value());
    private static final List<RString> PAGE_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(new RString(TohyoShukeiReportSource.ReportSourceFileds.tohyokuCode.name()),
                            new RString(TohyoShukeiReportSource.ReportSourceFileds.senkyoNo.name())));

    /**
     * 帳票ID
     */
    public ShukeiSeirihyoPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }

    @Override
    public Breakers<ShukeiSeirihyoReportSource> defineBreakers(Breakers<ShukeiSeirihyoReportSource> breakers,
            BreakerCatalog<ShukeiSeirihyoReportSource> catalog) {
        return breakers.add(catalog.new SimpleLayoutBreaker(PAGE_BREAK_KEYS));
    }
}
