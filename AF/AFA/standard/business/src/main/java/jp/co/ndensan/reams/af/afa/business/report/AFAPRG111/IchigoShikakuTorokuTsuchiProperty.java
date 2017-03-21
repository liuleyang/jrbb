/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG111;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG111.IchigoShikakuTorokuTsuchiSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 1号資格登録通知（様式1）帳票プロパティクラスです。
 *
 * @reamsid_L AF-0360-055 caijj2
 */
public class IchigoShikakuTorokuTsuchiProperty extends ReportPropertyBase<IchigoShikakuTorokuTsuchiSource> {

    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRG111_1号資格登録通知_様式1.value());
    private static final List<RString> PAGE_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(new RString(IchigoShikakuTorokuTsuchiSource.ReportSourceFields.tennyuZanTop5.name())));

    /**
     * インスタンスを生成します。
     */
    public IchigoShikakuTorokuTsuchiProperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }

    @Override
    public Breakers<IchigoShikakuTorokuTsuchiSource> defineBreakers(
            Breakers<IchigoShikakuTorokuTsuchiSource> breakers,
            BreakerCatalog<IchigoShikakuTorokuTsuchiSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(PAGE_BREAK_KEYS));
    }
}
