/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME5030;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5030.NippoSakuseiChohyoSeirihyoDiv;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 【View】NippoSakuseiDiv内の <br />
 * NippoSakuseiChohyoDiv内の <br />
 * NippoSakuseiChohyoSeirihyoDivに対するコントローラです。
 *
 * @author N1823 有澤 礼恵
 */
public final class NippoSakuseiChohyoSeirihyo {

    private NippoSakuseiChohyoSeirihyo() {
    }

    /**
     * 抄本ドロップダウンリスト選択時の処理をするメソッドです。
     *
     * @param div NippoSakuseiChohyoSeirihyoDiv
     * @param senkyoShurui SenkyoShurui
     */
    public static void setData(NippoSakuseiChohyoSeirihyoDiv div, SenkyoShurui senkyoShurui) {

        div.getCcdSeirihyoTohyokuCode().initialize(senkyoShurui);
    }

    /**
     * 入力条件のクリア処理をするメソッドです。
     *
     * @param div NippoSakuseiChohyoSeirihyoDiv
     */
    public static void clearThisPanel(NippoSakuseiChohyoSeirihyoDiv div) {
        div.getCcdSeirihyoTohyokuCode().clearData();
        div.getTxtSeirihyoJuriYMD().setValue(RDate.getNowDate());
    }

}
