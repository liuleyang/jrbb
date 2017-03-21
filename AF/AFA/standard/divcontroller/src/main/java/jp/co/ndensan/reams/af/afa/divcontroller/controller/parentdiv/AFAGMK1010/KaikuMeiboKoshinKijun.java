/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMK1010;

import jp.co.ndensan.reams.af.afa.business.MeiboSakuseiKaiku;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1010.KaikuMeiboKoshinKijunDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 【View】KaikuMeiboSakuseiDiv内の<br />
 * KaikuMeiboKoshinKijunDivに対応するコントローラです。
 *
 * @reamsid_L AF-0460-010 liuyj
 */
public class KaikuMeiboKoshinKijun {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div KaikuMeiboKoshinKijunDiv
     * @param senkyoShurui SenkyoShurui
     */
    public static void load(KaikuMeiboKoshinKijunDiv div, SenkyoShurui senkyoShurui) {
        RString menuID = ResponseHolder.getMenuID();
        ViewState.setメニューID(menuID);

        div.getCcdShohonNameList().initialize(senkyoShurui);
        div.getRadSakuseiKijun().setSelectedKey(new RString("0"));
    }

    /**
     * 日付設定ボタンクリック時のイベントメソッドです。
     *
     * @param div KaikuMeiboKoshinKijunDiv
     * @return ResponseData<KaikuMeiboKoshinKijunDiv>
     */
    public ResponseData<KaikuMeiboKoshinKijunDiv> onClick_btnSetYmd(KaikuMeiboKoshinKijunDiv div) {
        MeiboSakuseiKaiku meiboSakuseiKaiku = new MeiboSakuseiKaiku();
        RDate 基準日 = div.getTxtKijunYMD().getValue();
        if (null != 基準日) {
            div.getTxtKakuteiYMD().setValue(meiboSakuseiKaiku.get日付(基準日).get名簿確定日());
            div.getTxtNenreiTotatsuYMD().setValue(meiboSakuseiKaiku.get日付(基準日).get年齢到達日());
        }
        return ResponseData.of(div).respond();
    }
}
