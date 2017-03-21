/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyo.SakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyo.SakuseiChohyoHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 【共有子Div】SakuseiChohyoDivに対するコントローラです。
 *
 * @author N1823 有澤 礼恵
 */
public class SakuseiChohyo {

    /**
     * 出力条件のonChangeインベントです。
     *
     * @param div SakuseiChohyoDiv
     * @return ResponseData<SakuseiChohyoDiv>
     */
    public ResponseData<SakuseiChohyoDiv> onChange_RadEikyuMeiboShoriKubun(SakuseiChohyoDiv div) {
        SakuseiChohyoHandler handler = getHandler(div);
        handler.onChange_出力条件();
        return this.getResponseData(div);
    }

    private SakuseiChohyoHandler getHandler(SakuseiChohyoDiv div) {
        return new SakuseiChohyoHandler(div);
    }

    private ResponseData<SakuseiChohyoDiv> getResponseData(SakuseiChohyoDiv div) {
        ResponseData<SakuseiChohyoDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }
}
