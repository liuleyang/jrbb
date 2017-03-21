package jp.co.ndensan.reams.af.afa.business.report.AFAPRE205;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE205.LayoutBreakItems;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE205.ShisetsuSofushoSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 施設送付書
 *
 * @reamsid_L AF-0250-030 jihb
 */
public class ShisetsuSofushoPorperty extends ReportPropertyBase<ShisetsuSofushoSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRE205_施設送付書.value());

    /**
     * 帳票ID
     */
    public ShisetsuSofushoPorperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }

    @Override
    public Breakers<ShisetsuSofushoSource> defineBreakers(Breakers<ShisetsuSofushoSource> breakers,
            BreakerCatalog<ShisetsuSofushoSource> catalog) {
        return breakers.add(catalog.new SimpleLayoutBreaker(





            ShisetsuSofushoSource.LAYOUT_BREAK_KEYS) {
            @Override
            public ReportLineRecord<ShisetsuSofushoSource> occuredBreak(ReportLineRecord<ShisetsuSofushoSource> currentRecord,
                    ReportLineRecord<ShisetsuSofushoSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord.equals(ReportLineRecord.LAST_RECORD)) {
                    return currentRecord;
                }
                LayoutBreakItems layout = nextRecord.getSource().layoutBreakItem;
                nextRecord.setFormGroupIndex(layout.index());
                return currentRecord;
            }
        }).fixed();
    }
}
