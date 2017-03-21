/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA100;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA100.MeiboShohonSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 選挙人名簿抄本のページブレーククラス
 *
 */
public class MeiboShohonPageBreak extends PageBreaker<MeiboShohonSource> {

    @Override
    public List<RString> breakKeys() {
        List<RString> breakKeys = new ArrayList<>();
        breakKeys.add(new RString("realPage"));
        return breakKeys;
    }

}
