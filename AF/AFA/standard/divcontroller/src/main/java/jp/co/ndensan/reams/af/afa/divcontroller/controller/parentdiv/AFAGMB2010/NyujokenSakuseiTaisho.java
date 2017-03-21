/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMB2010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2010.NyujokenSakuseiTaishoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB2010.NyujokenSakuseiTaishoHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 【View】NyujokenSakuseiIkkatsuDiv内の <br />
 * NyujokenSakuseiTaishoDivに対するコントローラです。 入場券発行（一括）
 *
 * @reamsid_L AF-0160-010 guyq
 */
public class NyujokenSakuseiTaisho {

    /**
     * 世帯で複数枚作成される世帯一覧表を作成するチェックボックスイベントメソッドです。
     *
     * @param mainPanel NyujokenSakuseiKobetsuDiv
     * @return ResponseData<NyujokenSakuseiIkkatsuDiv>
     */
    public ResponseData<NyujokenSakuseiTaishoDiv> onClick_setaiKonzou(NyujokenSakuseiTaishoDiv mainPanel) {
        ResponseData<NyujokenSakuseiTaishoDiv> response = new ResponseData<>();
        NyujokenSakuseiTaishoHandler.of(mainPanel).set世帯で複数();
        response.data = mainPanel;
        return response;
    }

}
