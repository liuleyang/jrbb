/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyojoSelectDialog.TohyojoSelectDialogDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyojoSelectDialog.TohyojoSelectDialogHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 投票所選択ダイアログに対するコントローラです。
 *
 * @reamsid_L AF-0710-020 liuyj
 */
public class TohyojoSelectDialog {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div TohyojoSelectDialogDiv
     * @return ResponseData<ShisetsuSelectDialogDiv>
     */
    public ResponseData<TohyojoSelectDialogDiv> onLoad(TohyojoSelectDialogDiv div) {

        TohyojoSelectDialogHandler hander = createHandlerOf(div);
        hander.画面設定_投票所ダイアログ(div.getTxtHdnSelectedCode());

        return ResponseData.of(div).respond();
    }

    /**
     * 選択ボタンクリック時のイベントメソッドです。 <br />
     * グリッド行ダブルクリック時のイベントメソッドです。
     *
     * @param div TohyojoSelectDialogDiv
     * @return ResponseData<TohyojoSelectDialogDiv>
     */
    public ResponseData<TohyojoSelectDialogDiv> onSelectBySelectButton_closeOK(TohyojoSelectDialogDiv div) {
        div.setTxtHdnSelectedCode(div.getDgTohyojoSelect().getSelectedItems().get(0).getTxtTohyojoCode());
        div.setTxtHdnSelectedName(div.getDgTohyojoSelect().getSelectedItems().get(0).getTxtTohyojoName());
        div.setTxtHdnSelectedKanaName(div.getDgTohyojoSelect().getSelectedItems().get(0).getTxtKanaTohyojoName());

        return ResponseData.of(div).respond();
    }

    private TohyojoSelectDialogHandler createHandlerOf(TohyojoSelectDialogDiv div) {
        return new TohyojoSelectDialogHandler(div);
    }

}
