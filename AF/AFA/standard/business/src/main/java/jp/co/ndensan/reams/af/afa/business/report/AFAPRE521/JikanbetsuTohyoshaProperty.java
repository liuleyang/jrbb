/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE521;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE521.JikanbetsuTohyoshaReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 時間別投票者集計表帳票プロパティクラスです。
 *
 * @reamsid_L AF-0290-037 lit
 */
public class JikanbetsuTohyoshaProperty extends ReportPropertyBase<JikanbetsuTohyoshaReportSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.時間別投票者集計表.value());
    private static final List<RString> PAGE_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(new RString(JikanbetsuTohyoshaReportSource.ReportSourceFileds.subTitle.name()),
                            new RString(JikanbetsuTohyoshaReportSource.ReportSourceFileds.senkyoNo.name())));

    /**
     * インスタンスを生成します。
     */
    public JikanbetsuTohyoshaProperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }

    @Override
    public Breakers<JikanbetsuTohyoshaReportSource> defineBreakers(
            Breakers<JikanbetsuTohyoshaReportSource> breakers,
            BreakerCatalog<JikanbetsuTohyoshaReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(PAGE_BREAK_KEYS));
    }
}
