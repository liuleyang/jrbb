/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KyohiJiyuNyuryoku.KyohiJiyuNyuryokuHandler;
import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KyohiJiyuNyuryoku.KyohiJiyuNyuryokuDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 【共有子Div】KyohiJiyuNyuryokuDivに対するコントローラです。
 *
 * @author N1823 有澤 礼恵
 */
public class KyohiJiyuNyuryoku implements Serializable {

    /**
     * 初期表示を行います。
     *
     * @param requestDiv 拒否事由入力共有子Div
     * @return 引数のDivを持つResponseData型
     */
    public ResponseData<KyohiJiyuNyuryokuDiv> onLoad(KyohiJiyuNyuryokuDiv requestDiv) {

        KyohiJiyuNyuryokuHandler handler = getHandler(requestDiv);
        handler.initialSetting();

        return getResponseData(requestDiv);
    }

    private KyohiJiyuNyuryokuHandler getHandler(KyohiJiyuNyuryokuDiv requestDiv) {
        return new KyohiJiyuNyuryokuHandler(requestDiv);
    }

    private ResponseData<KyohiJiyuNyuryokuDiv> getResponseData(KyohiJiyuNyuryokuDiv requestDiv) {

        ResponseData<KyohiJiyuNyuryokuDiv> response = new ResponseData();
        response.data = requestDiv;

        return response;
    }

}
