/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE301;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE301.TojitsuTohyorokuReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 当日投票録プロパティクラスです。
 *
 * @reamsid_L AF-0130-021 lit
 */
public class TojitsuTohyorokuProperty extends ReportPropertyBase<TojitsuTohyorokuReportSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.当日投票録.value());

    /**
     * インスタンスを生成します。
     */
    public TojitsuTohyorokuProperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }

    @Override
    public Breakers<TojitsuTohyorokuReportSource> defineBreakers(
            Breakers<TojitsuTohyorokuReportSource> breakers,
            BreakerCatalog<TojitsuTohyorokuReportSource> catalog) {
        return breakers.add(catalog.new SimpleLayoutBreaker(







            TojitsuTohyorokuReportSource.LAYOUT_BREAK_KEYS) {
            @Override
            public ReportLineRecord<TojitsuTohyorokuReportSource> occuredBreak(
                    ReportLineRecord<TojitsuTohyorokuReportSource> currentRecord,
                    ReportLineRecord<TojitsuTohyorokuReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord.equals(ReportLineRecord.LAST_RECORD)) {
                    return currentRecord;
                }
                TojitsuTohyorokuReportSource.Layouts layout = nextRecord.getSource().layout;
                nextRecord.setFormGroupIndex(layout.index());
                return currentRecord;
            }
        }).fixed();
    }
}
