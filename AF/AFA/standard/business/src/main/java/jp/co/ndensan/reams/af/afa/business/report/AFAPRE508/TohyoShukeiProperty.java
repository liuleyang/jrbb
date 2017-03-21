/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE508;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE508.TohyoShukeiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 投票日前日関連帳票プロパティクラスです。
 *
 * @reamsid_L AF-0280-025 lit
 */
public class TohyoShukeiProperty extends ReportPropertyBase<TohyoShukeiReportSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.投票集計表.value());
    private static final List<RString> PAGE_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(new RString(TohyoShukeiReportSource.ReportSourceFileds.tohyokuCode.name()),
                            new RString(TohyoShukeiReportSource.ReportSourceFileds.senkyoNo.name())));

    /**
     * インスタンスを生成します。
     */
    public TohyoShukeiProperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }

    @Override
    public Breakers<TohyoShukeiReportSource> defineBreakers(
            Breakers<TohyoShukeiReportSource> breakers,
            BreakerCatalog<TohyoShukeiReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(PAGE_BREAK_KEYS));
    }
}
