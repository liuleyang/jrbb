/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JushoJokenSelect.JushoJokenSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JushoJokenSelect.JushoJokenSelectHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * JushoJokenSelect のクラスファイル
 *
 * @reamsid_L AF-0450-011 jihb
 */
public class JushoJokenSelect {

    /**
     * 住所条件のonChangeのイベントメソッドです。
     *
     * @param div JushoJokenSelectDiv
     * @return ResponseData
     */
    public ResponseData<JushoJokenSelectDiv> onChange_radJushoJoken(JushoJokenSelectDiv div) {
        getHandler(div).onChange_radJushoJoken();
        return ResponseData.of(div).respond();
    }

    private JushoJokenSelectHandler getHandler(JushoJokenSelectDiv div) {
        return new JushoJokenSelectHandler(div);
    }

}
