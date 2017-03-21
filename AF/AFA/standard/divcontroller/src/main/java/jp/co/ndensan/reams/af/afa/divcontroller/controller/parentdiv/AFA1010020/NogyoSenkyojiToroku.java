/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFA1010020;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFA1010020.NogyoSenkyojiTorokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFA1010020.AFA1010020TransitionEventName;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.ur.urz.definition.core.view.DisplayMode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * AFA1010020 農業委員会委員選挙人選挙時名簿作成 <br />
 * NogyoSenkyojiTorokuDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 */
public class NogyoSenkyojiToroku {

    private static final SenkyoShurui SENKYO_SHURUI = SenkyoShurui.農業委員会委員選挙;

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel NogyoSenkyojiTorokuDiv
     * @return ResponseData<NogyoSenkyojiTorokuDiv>
     */
    public ResponseData<NogyoSenkyojiTorokuDiv> onLoad(NogyoSenkyojiTorokuDiv mainPanel) {

        mainPanel.getCcdNogyoSenkyojiSenkyoNyuryoku().initialize(SENKYO_SHURUI, DisplayMode.新規);
//        NogyoSakuseiChohyo.setData(mainPanel.getNogyoMeiboNogyoSakuseiChohyo());

        ResponseData<NogyoSenkyojiTorokuDiv> response = new ResponseData<>();
        response.data = mainPanel;
        return response;
    }

    /**
     * 実行ボタン押下時のイベントメソッドです。
     *
     * @param mainPanel NogyoSenkyojiTorokuDiv
     * @return ResponseData<NogyoSenkyojiTorokuDiv>
     */
    public ResponseData<NogyoSenkyojiTorokuDiv> onClick_btnExecute(NogyoSenkyojiTorokuDiv mainPanel) {
        //TODO 農業・選挙人名簿更新バッチ起動処理

        return ResponseData.of(mainPanel)
                .forwardWithEventName(AFA1010020TransitionEventName.バッチ起動).respond();
    }
}
