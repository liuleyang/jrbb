/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.af.afa.business.report.AFAPRG112;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG112.IchigoShikakuTorokuTsuchiListSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 1号資格登録通知一覧表帳票プロパティクラスです。
 *
 * @reamsid_L AF-0360-056 caijj2
 */
public class IchigoShikakuTorokuTsuchiListProperty extends ReportPropertyBase<IchigoShikakuTorokuTsuchiListSource> {
    
    private static final ReportId ID = new ReportId(ReportIdKeys.AFAPRG112_1号資格登録通知一覧表.value());
    private static final List<RString> PAGE_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(new RString(IchigoShikakuTorokuTsuchiListSource.ReportSourceFileds.tennyuZanTop5.name())));
    
    /**
     * インスタンスを生成します。
     */
    public IchigoShikakuTorokuTsuchiListProperty() {
        super(SubGyomuCode.AFA選挙本体, ID);
    }

    @Override
    public Breakers<IchigoShikakuTorokuTsuchiListSource> defineBreakers(
            Breakers<IchigoShikakuTorokuTsuchiListSource> breakers,
            BreakerCatalog<IchigoShikakuTorokuTsuchiListSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(PAGE_BREAK_KEYS));
    }
}
