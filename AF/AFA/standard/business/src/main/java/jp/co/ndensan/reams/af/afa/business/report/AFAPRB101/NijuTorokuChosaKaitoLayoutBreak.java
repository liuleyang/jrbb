/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRB101;

import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB101.NijuTorokuChosaKaitoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.LayoutBreaker;

/**
 * 帳票レイアウトの切り替えのクラスです。
 *
 * @reamsid_L AF-0030-034 liss
 */
public class NijuTorokuChosaKaitoLayoutBreak extends LayoutBreaker<NijuTorokuChosaKaitoSource> {

    @Override
    public List<RString> breakKeys() {
        return NijuTorokuChosaKaitoSource.LAYOUT_BREAK_KEYS;
    }

    @Override
    public ReportLineRecord<NijuTorokuChosaKaitoSource> occuredBreak(ReportLineRecord<NijuTorokuChosaKaitoSource> currentRecord,
            ReportLineRecord<NijuTorokuChosaKaitoSource> nextRecord, ReportDynamicChart dynamicChart) {
        if (nextRecord == ReportLineRecord.LAST_RECORD) {
            return currentRecord;
        }
        RString layout = nextRecord.getSource().layout;
        nextRecord.setFormGroupIndex(Integer.parseInt(layout.toString()));
        return currentRecord;
    }
}
