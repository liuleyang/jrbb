/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA111;

import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA111.NijuTorokuTsuchishoCommonSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.LayoutBreaker;

/**
 * 帳票レイアウトの切り替えのクラスです。
 * 
 */
public class NijuTorokuTsuchishoLayoutBreak extends LayoutBreaker<NijuTorokuTsuchishoCommonSource> {

    @Override
    public List<RString> breakKeys() {
        return NijuTorokuTsuchishoCommonSource.LAYOUT_BREAK_KEYS;
    }

    @Override
    public ReportLineRecord<NijuTorokuTsuchishoCommonSource> occuredBreak(ReportLineRecord<NijuTorokuTsuchishoCommonSource> currentRecord,
            ReportLineRecord<NijuTorokuTsuchishoCommonSource> nextRecord, ReportDynamicChart dynamicChart) {
        if (nextRecord == ReportLineRecord.LAST_RECORD) {
            return currentRecord;
        }
        RString layout = nextRecord.getSource().layout;
        nextRecord.setFormGroupIndex(Integer.parseInt(layout.toString()));
        return currentRecord;
    }

}
