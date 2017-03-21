/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME1010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME1010.KijitsumaeTohyoJokyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME1010.KijitsumaeTohyoJokyoHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 【View】KijitsumaeTohyoDiv内の <br />
 * KijitsumaeTohyoJokyoDivに対するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0070-010 liss
 */
public class KijitsumaeTohyoJokyo {

    private static final RString 初期選択選挙番号 = new RString("1");

    /**
     * 抄本ドロップダウンリスト選択時の処理をするメソッドです。
     *
     * @param div KijitsumaeTohyoJokyoDiv
     * @param shohonNo 抄本番号
     */
    public static void setData(KijitsumaeTohyoJokyoDiv div, RString shohonNo) {

        div.setTxtHdnShohonNo(shohonNo);
        if (shohonNo.equals(RString.EMPTY)) {
            div.getRadSenkyoNo().getDataSource().clear();
            div.getDgKijitsumaeTohyoShukei().getDataSource().clear();

        } else {
            div.getRadSenkyoNo().setDataSource(getHandler().createSenkyoDataSource(shohonNo));
            div.getRadSenkyoNo().setSelectedKey(初期選択選挙番号);     // 選挙番号1を選択          
            div.getDgKijitsumaeTohyoShukei().setDataSource(
                    getHandler().createTohyoJokyoShukeiDataSource(shohonNo, div.getRadSenkyoNo().getSelectedKey()));
        }
    }

    /**
     * 選挙番号ラジオボタンを選択時のイベントメソッドです。
     *
     * @param div KijitsumaeTohyoJokyoDiv
     * @return ResponseData<KijitsumaeTohyoJokyoDiv>
     */
    public ResponseData<KijitsumaeTohyoJokyoDiv> onClick_radSenkyoNo(KijitsumaeTohyoJokyoDiv div) {

        div.getDgKijitsumaeTohyoShukei().setDataSource(
                getHandler().createTohyoJokyoShukeiDataSource(div.getTxtHdnShohonNo(), div.getRadSenkyoNo().getSelectedKey()));
        return ResponseData.of(div).respond();
    }

    private static KijitsumaeTohyoJokyoHandler getHandler() {
        return new KijitsumaeTohyoJokyoHandler();
    }
}
