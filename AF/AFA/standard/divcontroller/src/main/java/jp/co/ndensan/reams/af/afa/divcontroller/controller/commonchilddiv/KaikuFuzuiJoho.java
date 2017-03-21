/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuFuzuiJoho.KaikuFuzuiJohoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 海区付随情報クラスです。
 *
 * @reamsid_L AF-0500-020 gyq
 */
public class KaikuFuzuiJoho {

    /**
     *
     * @param div JotaiHenkoDialogDiv
     * @return ResponseData<JotaiHenkoDialogDiv>
     */
    public ResponseData<KaikuFuzuiJohoDiv> onChange_ddlShohonData(KaikuFuzuiJohoDiv div) {
        ResponseData<KaikuFuzuiJohoDiv> response = new ResponseData<>();
        div.getCcdShohonNameList().changeDdlShohon();

        response.data = div;
        return response;
    }

}
