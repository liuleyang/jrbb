/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMM1020;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM1020.CodeMasterMainDiv;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * AFAGMM1020 コードマスタ保守 <br />
 * CodeMasterMaintenanceDivに対応するコントローラです。
 *
 * @reamsid_L AF-0650-010 chenh
 */
public class CodeMasterMaintenance {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div CodeMasterMaintenanceDiv
     * @return ResponseData<CodeMasterMaintenanceDiv>
     */
    public ResponseData<CodeMasterMainDiv> onLoad(CodeMasterMainDiv div) {

        div.getCcdCodeMasterMaintenance().load(SubGyomuCode.AFA選挙本体);

        return ResponseData.of(div).respond();
    }

}
