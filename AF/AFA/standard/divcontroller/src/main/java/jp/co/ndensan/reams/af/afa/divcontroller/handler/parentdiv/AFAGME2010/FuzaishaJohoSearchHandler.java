/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.FuzaishaJohoSearchDiv;

/**
 * 【View】FuzaishaTohyoDiv内の <br />
 * FuzaishaJohoSearchDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0080-010 lit
 */
public final class FuzaishaJohoSearchHandler {

    private FuzaishaJohoSearchHandler() {
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div TohyorokuSakuseiJokenDiv
     * @return 抄本があるかどうか
     */
    public static boolean initialize(FuzaishaJohoSearchDiv div) {
        div.getCcdShohonNameList().initialize();
        div.getCcdShohonNameList().setChkKakoShohonCheckMode(false);

        if (div.getCcdShohonNameList().getShohonListSize() == 0) {

            div.getCcdShohonNameList().setChkKakoShohonCheckMode(true);
            div.getCcdShohonNameList().setChkKakoShohonDisplayNoneMode(false);
            div.getCcdShohonNameList().initialize();
            
            if (div.getCcdShohonNameList().getShohonListSize() == 0) {
                return false;
            }
            div.getCcdShohonNameList().selectedShohon(div.getCcdShohonNameList().get一番近い過去抄本番号());
        } else {
            div.getCcdShohonNameList().selectedShohon(div.getCcdShohonNameList().get一番近い未来抄本番号());
        }

        div.getCcdShisetsuCode().initialize();
        return true;
    }

    /**
     * クリアです。
     *
     * @param div TohyorokuSakuseiJokenDiv
     */
    public static void clearThisPanel(FuzaishaJohoSearchDiv div) {
        div.getCcdShohonNameList().clear();
        div.getCcdShohonNameList().setChkKakoShohonCheckMode(false);
        div.getCcdShisetsuCode().clear();
    }

}
