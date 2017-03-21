/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KokuminSakuseiChohyoType;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo.KokuminSakuseiChohyoMasshoTsuchiDiv;

/**
 * 【共有子Div】KokuminSakuseiChohyoDiv内の<br />
 * KokuminSakuseiChohyoMasshoTsuchiDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0360-012 liwuls
 */
public final class KokuminSakuseiChohyoMasshoTsuchi {

    private KokuminSakuseiChohyoMasshoTsuchi() {
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div KokuminSakuseiChohyoMasshoTsuchiDiv
     */
    public static void setData(KokuminSakuseiChohyoMasshoTsuchiDiv div) {
        div.getCcdPrintNaiyoMasshoTsuchi().initialize(KokuminSakuseiChohyoType.国民_未登録者抹消.getValue());
    }

    /**
     * 項目をクリアします。
     *
     * @param div KokuminSakuseiChohyoMasshoTsuchiDiv
     */
    public static void clearData(KokuminSakuseiChohyoMasshoTsuchiDiv div) {
        div.getCcdPrintNaiyoMasshoTsuchi().clearData();
        div.getChkSealMasshoTsuchi().setSelectedItems(div.getChkSealMasshoTsuchi().getDataSource());
        div.getChkMasshoTsuchiIchiran().setSelectedItems(div.getChkMasshoTsuchiIchiran().getDataSource());
    }

}
