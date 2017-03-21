/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMA1020;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.message.AfWarningMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1020.TohyokuHenkoMeiboBangoJohoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * TohyokuHenkoMeiboBangoJohoDivに対応するコントローラです。
 *
 * @reamsid_L AF-0050-010 qiuxy
 */
public class TohyokuHenkoMeiboBangoJoho {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div TohyokuHenkoMeiboBangoJohoDiv
     * @param senkyoShurui SenkyoShurui
     */
    public static void onLoad(TohyokuHenkoMeiboBangoJohoDiv div, SenkyoShurui senkyoShurui) {
        clearThisPanel(div);

        div.getCcdTohyokuBefore().initialize(senkyoShurui, true);
        div.getCcdTohyokuAfter().initialize(senkyoShurui, false);
        div.getCcdTohyokuBefore().setReadOnlyMode(Boolean.TRUE);
        div.getCcdTohyokuAfter().setReadOnlyMode(Boolean.FALSE);
        // 冊の表示有無は管理情報から判断する。今回は非表示にしておく
        div.getCcdMeiboBangoBefore().initialize();
        div.getCcdMeiboBangoAfter().initialize();
        div.getBtnBangoSanshutsu().setDisabled(Boolean.TRUE);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), Boolean.TRUE);
    }

    /**
     * 変更後の投票区コードのイベントメソッドです。
     *
     * @param div TohyokuHenkoMeiboBangoJohoDiv
     * @return ResponseData<TohyokuHenkoMeiboBangoJohoDiv>
     */
    public ResponseData<TohyokuHenkoMeiboBangoJohoDiv> onBlur_txtTohyokuCode(TohyokuHenkoMeiboBangoJohoDiv div) {
        div.getCcdMeiboBangoAfter().clear();

        if (!ResponseHolder.isReRequest() && is変更前後投票区コード同じ(div)) {
            return ResponseData.of(div).addMessage(AfWarningMessages.投票区変更_未変更.getMessage()).respond();
        }
        ValidationMessageControlPairs pairs = div.getCcdTohyokuAfter().投票区コードチェック();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        div.getCcdTohyokuAfter().set投票区名称();
        div.getBtnBangoSanshutsu().setDisabled(Boolean.FALSE);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), Boolean.TRUE);
        return ResponseData.of(div).respond();
    }

    /**
     * 変更後の投票区コードのイベントメソッドです。
     *
     * @param div TohyokuHenkoMeiboBangoJohoDiv
     * @return ResponseData<TohyokuHenkoMeiboBangoJohoDiv>
     */
    public ResponseData<TohyokuHenkoMeiboBangoJohoDiv> onOKClose_btnTohyokuCode(TohyokuHenkoMeiboBangoJohoDiv div) {
        div.getCcdMeiboBangoAfter().clear();

        if (!ResponseHolder.isReRequest() && is変更前後投票区コード同じ(div)) {
            return ResponseData.of(div).addMessage(AfWarningMessages.投票区変更_未変更.getMessage()).respond();
        } else {
            div.getBtnBangoSanshutsu().setDisabled(Boolean.FALSE);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), Boolean.TRUE);
        }
        return ResponseData.of(div).respond();
    }

    private static boolean is変更前後投票区コード同じ(TohyokuHenkoMeiboBangoJohoDiv div) {
        RString tohyokuCodeAfter = div.getCcdTohyokuAfter().get投票区コード();
        RString tohyokuCodeBefore = div.getCcdTohyokuBefore().get投票区コード();
        return tohyokuCodeAfter.equals(tohyokuCodeBefore);
    }

    private static void clearThisPanel(TohyokuHenkoMeiboBangoJohoDiv div) {
        div.getCcdTohyokuBefore().clear();
        div.getCcdTohyokuAfter().clear();
        div.getCcdMeiboBangoBefore().clear();
        div.getCcdMeiboBangoAfter().clear();
        div.getRadTekiyoNaiyo().setSelectedKey(new RString("key0"));
    }

}
