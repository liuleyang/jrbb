/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE506;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE506.KijitsumaeTohyorokuReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 期日前投票録プロパティクラスです。
 *
 * @reamsid_L AF-0130-020 lit
 */
public class KijitsumaeTohyorokuOneMaiProperty extends ReportPropertyBase<KijitsumaeTohyorokuReportSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.期日前投票録1枚タイプ.value());

    /**
     * インスタンスを生成します。
     */
    public KijitsumaeTohyorokuOneMaiProperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }

    @Override
    public Breakers<KijitsumaeTohyorokuReportSource> defineBreakers(
            Breakers<KijitsumaeTohyorokuReportSource> breakers,
            BreakerCatalog<KijitsumaeTohyorokuReportSource> catalog) {
        return breakers.add(catalog.new SimpleLayoutBreaker(








            KijitsumaeTohyorokuReportSource.LAYOUT_BREAK_KEYS) {
            @Override
            public ReportLineRecord<KijitsumaeTohyorokuReportSource> occuredBreak(
                    ReportLineRecord<KijitsumaeTohyorokuReportSource> currentRecord,
                    ReportLineRecord<KijitsumaeTohyorokuReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord.equals(ReportLineRecord.LAST_RECORD)) {
                    return currentRecord;
                }
                KijitsumaeTohyorokuReportSource.Layouts layout = nextRecord.getSource().layout;
                nextRecord.setFormGroupIndex(layout.index());
                return currentRecord;
            }
        }).fixed();
    }
}
