/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyojoCodeSelect.TohyojoCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyojoCodeSelect.TohyojoCodeSelectHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 【共有子Div】TohyojoCodeSelectDivに対するコントローラです。
 *
 * @reamsid_L AF-0710-020 liuyj
 */
public class TohyojoCodeSelect {

    /**
     * 投票区コードを入力後（フォーカス喪失時）のイベントメソッドです。
     *
     * @param div TohyokuCodeSelectDiv
     * @return ResponseData<TohyokuCodeSelectDiv>
     */
    public ResponseData<TohyojoCodeSelectDiv> onBlur_txtTohyojoCode(TohyojoCodeSelectDiv div) {
        div.getTxtTohyojoName().setValue(RString.EMPTY);
        ValidationMessageControlPairs validResult = div.getValidationHandler().validate();
        if (validResult.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validResult).respond();
        }
        TohyojoCodeSelectHandler handler = createHandlerOf(div);
        div.getTxtTohyojoName().setValue(handler.get投票所名称(div.getTxtTohyojoCode().getValue()));
        return ResponseData.of(div).respond();
    }

    /**
     * 選択ボタンのイベントメソッドです。
     *
     * @param div TohyokuCodeSelectDiv
     * @return ResponseData<TohyokuCodeSelectDiv>
     */
    public ResponseData<TohyojoCodeSelectDiv> onBeforeOpenDialog_btnTohyojoCode(TohyojoCodeSelectDiv div) {

        return ResponseData.of(div).respond();
    }

    /**
     * 投票所選択ダイアログ閉じるのイベントメソッドです。
     *
     * @param div TohyokuCodeSelectDiv
     * @return ResponseData<TohyokuCodeSelectDiv>
     */
    public ResponseData<TohyojoCodeSelectDiv> onOKClose_btnTohyojoCode(TohyojoCodeSelectDiv div) {

        return ResponseData.of(div).respond();
    }

    private TohyojoCodeSelectHandler createHandlerOf(TohyojoCodeSelectDiv div) {
        return new TohyojoCodeSelectHandler(div);
    }

}
