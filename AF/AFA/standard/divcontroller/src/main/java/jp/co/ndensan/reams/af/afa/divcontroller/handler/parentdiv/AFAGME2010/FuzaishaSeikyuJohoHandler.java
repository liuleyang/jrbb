/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SeikyuHoho;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.FuzaishaSeikyuJohoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 【View】FuzaishaTohyoDiv内の <br />
 * 【子Div】FuzaishaTohyoJokyoDiv内の <br />
 * FuzaishaSeikyuJohoDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0080-010 lit
 */
public final class FuzaishaSeikyuJohoHandler {

    private FuzaishaSeikyuJohoHandler() {
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div FuzaishaSeikyuJohoDiv
     * @param senkyoShurui SenkyoShurui
     */
    public static void initialize(FuzaishaSeikyuJohoDiv div, SenkyoShurui senkyoShurui) {
        div.getCcdFuzaishaTohyoJiyu().initialize(senkyoShurui, TohyoJokyo.請求);
        div.getTxtSeikyuYMD().setValue(RDate.getNowDate());
        List<KeyValueDataSource> keyValueList = new ArrayList<>();
        keyValueList.add(new KeyValueDataSource(SeikyuHoho.直接_本人.getCode(), SeikyuHoho.直接_本人.toRString()));
        keyValueList.add(new KeyValueDataSource(SeikyuHoho.直接_代理人.getCode(), SeikyuHoho.直接_代理人.toRString()));
        keyValueList.add(new KeyValueDataSource(SeikyuHoho.郵便.getCode(), SeikyuHoho.郵便.toRString()));
        div.getRadSeikyusha().setDataSource(keyValueList);
        div.getRadSeikyusha().setSelectedKey(SeikyuHoho.直接_本人.getCode());
    }

    /**
     * 初期値をセットするメソッドです。
     *
     * @param div FuzaishaSeikyuJohoDiv
     */
    public static void clearThisPanel(FuzaishaSeikyuJohoDiv div) {
        div.getRadSeikyusha().setSelectedKey(SeikyuHoho.直接_本人.getCode());
        div.getTxtSeikyuYMD().setValue(RDate.getNowDate());
        // TODO. パラメータ.選挙種類≠「0:定時登録」の設定
        div.getCcdFuzaishaTohyoJiyu().initialize(SenkyoShurui.定時登録, null);
    }

    /**
     * 投票状況クリック時のイベントメソッドです。
     *
     * @param div FuzaishaSeikyuJohoDiv
     * @param blnShiyoFuka Boolean True：画面での入力不可、False：画面での入力可
     */
    public static void setHyoji(FuzaishaSeikyuJohoDiv div, Boolean blnShiyoFuka) {
        // blnShiyoFuka  True：画面での入力不可、False：画面での入力可
        div.getRadSeikyusha().setDisabled(blnShiyoFuka);
        div.getTxtSeikyuYMD().setReadOnly(blnShiyoFuka);
        div.getCcdFuzaishaTohyoJiyu().setReadOnlyMode(blnShiyoFuka);
    }

}
