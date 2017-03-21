/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJiyuCode.TohyoJiyuCodeDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJiyuCode.TohyoJiyuCodeHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 【共有子Div】TohyoJiyuCodeDivに対するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0070-013 liss
 */
public class TohyoJiyuCode {

    /**
     * 投票事由コードを入力後（フォーカス喪失時）のイベントメソッドです。
     *
     * @param div TohyoJiyuCodeDiv
     * @return ResponseData<TohyoJiyuCodeDiv>
     */
    public ResponseData<TohyoJiyuCodeDiv> onBlur_txtTohyoJiyuCode(TohyoJiyuCodeDiv div) {
        TohyoJiyuCodeHandler handler = createHandlerOf(div);
        return handler.onChange投票事由コード();

    }

    /**
     * 投票事由ドロップダウンリストを選択時のイベントメソッドです。
     *
     * @param div TohyoJiyuCodeDiv
     * @return ResponseData<TohyoJiyuCodeDiv>
     */
    public ResponseData<TohyoJiyuCodeDiv> onChange_ddlTohyoJiyu(TohyoJiyuCodeDiv div) {

        div.getTxtTohyoJiyuCode().setValue(div.getDdlTohyoJiyu().getSelectedKey());

        return ResponseData.of(div).respond();
    }

    /**
     * 投票事由コードを変化後のイベントメソッドです。
     *
     * @param div TohyoJiyuCodeDiv
     * @return ResponseData<TohyoJiyuCodeDiv>
     */
    public ResponseData<TohyoJiyuCodeDiv> onChange_txtTohyoJiyuCode(TohyoJiyuCodeDiv div) {
        return this.createHandlerOf(div).onChange投票事由コード();
    }

    private TohyoJiyuCodeHandler createHandlerOf(TohyoJiyuCodeDiv div) {
        return new TohyoJiyuCodeHandler(div);
    }

}
