/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 【共有子Div】ShohonNameListDivに対するコントローラです。
 *
 * @author N1823 有澤 礼恵
 */
public class ShohonNameList {

    /**
     * 過去分も含めるチェックボックスクリック時のイベントメソッドです。
     *
     * @param div ShohonNameListDiv
     * @return ResponseData
     */
    public ResponseData<ShohonNameListDiv> onclick_chkKakoShohon(ShohonNameListDiv div) {
        div.getHandler().click_chkKakoShohon();
        return ResponseData.of(div).respond();
    }
}
