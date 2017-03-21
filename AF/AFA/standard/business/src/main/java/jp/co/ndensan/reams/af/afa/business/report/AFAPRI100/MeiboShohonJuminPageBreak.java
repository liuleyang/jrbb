/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRI100;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRI100.MeiboShohonJuminSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 住民投票資格者名簿抄本ソースクラスです。
 *
 * @reamsid_L AF-0450-030 lis
 */
public class MeiboShohonJuminPageBreak extends PageBreaker<MeiboShohonJuminSource> {

    @Override
    public List<RString> breakKeys() {
        List<RString> breakKeys = new ArrayList<>();
        breakKeys.add(new RString("tohyokuCode"));
        breakKeys.add(new RString("key1"));
        breakKeys.add(new RString("key2"));
        breakKeys.add(new RString("key3"));
        breakKeys.add(new RString("key4"));
        breakKeys.add(new RString("totalPage"));
        return breakKeys;
    }

}
