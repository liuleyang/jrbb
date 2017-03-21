/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFA1010010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFA1010010.NogyoMeiboSakuseiDiv;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * AFA1010010 農業委員会委員選挙人名簿作成 <br />
 * NogyoMeiboSakuseiDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 */
public class NogyoMeiboSakusei {

    private static final SenkyoShurui SENKYO_SHURUI = SenkyoShurui.農業委員会委員選挙;

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel NogyoMeiboSakuseiDiv
     * @return ResponseData<NogyoMeiboSakuseiDiv>
     */
    public ResponseData<NogyoMeiboSakuseiDiv> onLoad(NogyoMeiboSakuseiDiv mainPanel) {

        NogyoMeiboKoshinKijun.initialize(mainPanel.getNogyoMeiboKoshinKijun(), SENKYO_SHURUI);
//        NogyoSakuseiChohyo.setData(mainPanel.getNogyoMeiboNogyoSakuseiChohyo());

        ResponseData<NogyoMeiboSakuseiDiv> response = new ResponseData<>();
        response.data = mainPanel;
        return response;
    }

}
