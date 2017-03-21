/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KaikuSenkyojiTorokuEnum;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuTaishoShohonJoho.KaikuTaishoShohonJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuTaishoShohonJoho.KaikuTaishoShohonJohoHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 海区対象抄本情報共有子Divに対応するコントローラです。
 *
 * @reamsid_L AF-0470-020 jihb
 */
public class KaikuTaishoShohonJoho {

    /**
     * 新規処理と再処理のラジオボタンクリック時のイベントメソッドです。
     *
     * @param div KaikuTaishoShohonJohoDiv
     * @return ResponseData<KaikuTaishoShohonJohoDiv>
     */
    public ResponseData<KaikuTaishoShohonJohoDiv> onClick_radShori(KaikuTaishoShohonJohoDiv div) {

        if (div.getRadShori().getSelectedKey().equals(KaikuSenkyojiTorokuEnum.新規登録.getValue())) {
            getHandler(div).clearThisPanel();
        } else {
            getHandler(div).set選択抄本情報(new ShohonNo(div.getCcdShohonNameList().getDdlShohonItem().getSelectedKey()));
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 抄本ドロップダウンリストを選択時のイベントメソッドです。
     *
     * @param div KaikuTaishoShohonJohoDiv
     * @return ResponseData<KaikuTaishoShohonJohoDiv>
     */
    public ResponseData<KaikuTaishoShohonJohoDiv> onChange_ccdShohonNameList(KaikuTaishoShohonJohoDiv div) {

        div.getCcdShohonNameList().changeDdlShohon();
        getHandler(div).clearThisPanel();
        getHandler(div).set選択抄本情報(new ShohonNo(div.getCcdShohonNameList().getSelectedShohonNo()));

        return ResponseData.of(div).respond();
    }

    private KaikuTaishoShohonJohoHandler getHandler(KaikuTaishoShohonJohoDiv div) {
        return new KaikuTaishoShohonJohoHandler(div);
    }

}
