/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG303;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG303.KokugaiTennyushaChosahyoKaitoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 帳票レイアウトの改ページのクラスです。
 *
 * @reamsid_L AF-0360-068 b_caiyf
 */
public class KokugaiTennyushaChosahyoKaitoPageBreak extends PageBreaker<KokugaiTennyushaChosahyoKaitoSource> {

    @Override
    public List<RString> breakKeys() {
        return Collections.unmodifiableList(Arrays.asList(new RString(KokugaiTennyushaChosahyoKaitoSource.ReportSourceFields.tennyuZanTop5.name())));
    }

}
