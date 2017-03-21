/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMM2040;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2040.TohyoRelateMaintenanceDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2040.TohyoRelateMaintenanceHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * AFAGMM2040 投票区投票所対応保守 <br />
 * TohyoRelateMaintenanceDivに対応するコントローラです。
 *
 * @reamsid_L AF-0740-010 lis2
 */
public class TohyoRelateMaintenance {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div TohyoRelateMaintenanceDiv
     * @return ResponseData<TohyoRelateMaintenanceDiv>
     */
    public ResponseData<TohyoRelateMaintenanceDiv> onLoad(TohyoRelateMaintenanceDiv div) {
        TohyoRelateMaintenanceHandler.of(div).set初期化状態1();
        return ResponseData.of(div).respond();
    }

    /**
     * 投票区投票所対応画面の選挙種類選択共有子DIV
     *
     * @param div TohyoRelateMaintenanceDiv
     * @return ResponseData<TohyoRelateMaintenanceDiv>
     */
    public ResponseData<TohyoRelateMaintenanceDiv> onChange_ccdSenkyoShurui(TohyoRelateMaintenanceDiv div) {
        TohyoRelateMaintenanceHandler.of(div).set投票区投票所初期化画面();
        return ResponseData.of(div).respond();
    }

    /**
     * 投票区投票所対応画面の保存するボタンクリック時処理
     *
     * @param div TohyoRelateMaintenanceDiv
     * @return ResponseData<TohyoRelateMaintenanceDiv>
     */
    public ResponseData<TohyoRelateMaintenanceDiv> onClick_saveData(TohyoRelateMaintenanceDiv div) {
        if (null == div.getDgTohyoRelateList().getClickedItem()) {
            return ResponseData.of(div).respond();
        }
        if (div.getDgTohyoRelateList().getActiveRow().getTxtTohyojoCode().isNullOrEmpty()) {
            return TohyoRelateMaintenanceHandler.of(div).check投票所必須チェック();
        } else {
            TohyoRelateMaintenanceHandler.of(div).save投票区投票所();
        }
        return ResponseData.of(div).respond();
    }
}
