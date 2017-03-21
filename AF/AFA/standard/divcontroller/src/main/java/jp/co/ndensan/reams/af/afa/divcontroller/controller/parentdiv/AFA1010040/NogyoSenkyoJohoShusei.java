/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFA1010040;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFA1010040.NogyoSenkyoJohoShuseiDiv;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.ur.urz.definition.core.view.DisplayMode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * AFA1010040 農業委員会委員選挙情報修正 <br />
 * NogyoSenkyoJohoShuseiDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 */
public class NogyoSenkyoJohoShusei {

    private static final SenkyoShurui SENKYO_SHURUI = SenkyoShurui.農業委員会委員選挙;

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel NogyoSenkyoJohoShuseiDiv
     * @return ResponseData<NogyoSenkyoJohoShuseiDiv>
     */
    public ResponseData<NogyoSenkyoJohoShuseiDiv> onLoad(NogyoSenkyoJohoShuseiDiv mainPanel) {

        mainPanel.getCcdNogyoShusei().initialize(SENKYO_SHURUI, DisplayMode.修正);

        ResponseData<NogyoSenkyoJohoShuseiDiv> response = new ResponseData<>();
        response.data = mainPanel;
        return response;
    }

}
