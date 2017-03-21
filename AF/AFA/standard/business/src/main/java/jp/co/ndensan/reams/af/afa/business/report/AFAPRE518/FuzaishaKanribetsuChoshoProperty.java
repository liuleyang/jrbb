/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE518;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE518.FuzaishaKanribetsuChoshoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 不在者投票管理者別の調書帳票プロパティクラスです。
 *
 * @reamsid_L AF-0280-035 lit
 */
public class FuzaishaKanribetsuChoshoProperty extends ReportPropertyBase<FuzaishaKanribetsuChoshoReportSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.不在者投票管理者別の調書.value());
    private static final List<RString> PAGE_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(new RString(FuzaishaKanribetsuChoshoReportSource.ReportSourceFileds.senkyoNo.name())));

    /**
     * インスタンスを生成します。
     */
    public FuzaishaKanribetsuChoshoProperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }

    @Override
    public Breakers<FuzaishaKanribetsuChoshoReportSource> defineBreakers(
            Breakers<FuzaishaKanribetsuChoshoReportSource> breakers,
            BreakerCatalog<FuzaishaKanribetsuChoshoReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(PAGE_BREAK_KEYS));
    }
}
