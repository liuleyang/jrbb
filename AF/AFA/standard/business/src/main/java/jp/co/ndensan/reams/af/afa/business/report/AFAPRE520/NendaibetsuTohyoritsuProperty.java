/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE520;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE520.NenreibetsuTohyoritsuReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 年代別投票率集計表帳票プロパティクラスです。
 *
 * @reamsid_L AF-0290-035 lit
 */
public class NendaibetsuTohyoritsuProperty extends ReportPropertyBase<NenreibetsuTohyoritsuReportSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.年代別投票率集計表.value());
    private static final List<RString> PAGE_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(new RString(NenreibetsuTohyoritsuReportSource.ReportSourceFileds.tohyokuCode.name()),
                            new RString(NenreibetsuTohyoritsuReportSource.ReportSourceFileds.senkyoNo.name())));

    /**
     * インスタンスを生成します。
     */
    public NendaibetsuTohyoritsuProperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }

    @Override
    public Breakers<NenreibetsuTohyoritsuReportSource> defineBreakers(
            Breakers<NenreibetsuTohyoritsuReportSource> breakers,
            BreakerCatalog<NenreibetsuTohyoritsuReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(PAGE_BREAK_KEYS));
    }
}
