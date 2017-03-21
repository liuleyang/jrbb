/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2050;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2050.SofushoSakuseiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 施設送付書発行のハンドラクラスです。
 *
 * @reamsid_L AF-0250-010 jihb
 */
public class SofushoSakuseiHandler {

    private final SofushoSakuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SofushoSakuseiDiv
     */
    public SofushoSakuseiHandler(SofushoSakuseiDiv div) {
        this.div = div;
    }

    /**
     * 初期化処理です。
     *
     * @return Success : true || Fail : false
     */
    public boolean initialize() {
        ViewState.setメニューID(AFAMenuId.AFAMNE2050_施設送付書発行.menuId());
        div.getCcdSofushoShohonSenkyoList().initialize();
        if (div.getCcdSofushoShohonSenkyoList().getCcdShohonNameList().getShohonListSize() == 0) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;

    }

    /**
     * 「実行するボタン」押下のチェックする。
     *
     * @return ResponseData
     */
    public ResponseData check入力内容() {
        ValidationMessageControlPairs controlErrorPairs = div.getSofushoSakuseiJoken().getCcdShisetsuCode().関係チェック();
        controlErrorPairs.add(new SofushoSakuseiValidationHandler(div).validate交付日開始と終了入力チェック());
        controlErrorPairs.add(new SofushoSakuseiValidationHandler(div).validate交付日開始と終了の大小チェック());
        if (controlErrorPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
        }
        return ResponseData.of(div).respond();
    }
}
