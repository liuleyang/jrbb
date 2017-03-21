/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG301;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG301.KokugaiTennyushaChosahyoShokaiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 帳票レイアウトの改ページのクラスです。
 *
 * @reamsid_L AF-0360-065 b_caiyf
 */
public class KokugaiTennyushaChosahyoShokaiPageBreak extends PageBreaker<KokugaiTennyushaChosahyoShokaiSource> {

    @Override
    public List<RString> breakKeys() {
        return Collections.unmodifiableList(Arrays.asList(new RString(KokugaiTennyushaChosahyoShokaiSource.ReportSourceFields.tennyuZanTop5.name())));
    }

}
