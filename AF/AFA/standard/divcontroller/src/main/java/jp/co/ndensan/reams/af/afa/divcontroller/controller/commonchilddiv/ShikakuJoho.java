/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShikakuJoho.ShikakuJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShikakuJoho.ShikakuJohoHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 【共有子Div】ShikakuJohoDivに対応するコントローラです。
 *
 * @reamsid_L AF-0180-015 lis2
 */
public class ShikakuJoho {

    /**
     * 選択ボタンクリック時のイベントメソッドです。 <br />
     * グリッド行ダブルクリック時のイベントメソッドです。
     *
     * @param div SenkyokuSelectDialogDiv
     * @return ResponseData<SenkyokuSelectDialogDiv>
     */
    public ResponseData<ShikakuJohoDiv> onChange_SenkyoShikaku(ShikakuJohoDiv div) {
        ResponseData<ShikakuJohoDiv> response = new ResponseData<>();
        RString 選挙種類 = div.getTxtHdnSenkyoShurui();
        new ShikakuJohoHandler(div).set選挙資格状態制御(SenkyoShurui.valueOf(選挙種類.toString()));

        response.data = div;
        return response;
    }

}
