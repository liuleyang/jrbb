/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.definition.message.AfQuestionMessages;
import jp.co.ndensan.reams.af.afa.definition.message.AfWarningMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ZaigaiSenkyoninJoho.ZaigaiSenkyoninJohoDiv;
import jp.co.ndensan.reams.af.afa.service.zaigaisenkyoninjoho.ZaigaiSenkyoninJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ButtonSelectPattern;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 * 【共有子Div】ZaigaiSenkyoninJohoDivに対するコントローラです。
 *
 * @reamsid_L AF-0320-011 lis
 */
public class ZaigaiSenkyoninJoho {

    private final RString 申請番号_採番 = new RString("申請番号");
    private final RString 在外交付番号_採番 = new RString("在外交付番号");

    /**
     * 申請番号の「採番」ボタンのイベントメソッドです。
     *
     * @param div ZaigaiSenkyoninJohoDiv
     * @return ResponseData<ZaigaiSenkyoninJohoDiv>
     */
    public ResponseData<ZaigaiSenkyoninJohoDiv> onClick_btnShinseiNoSaiban(ZaigaiSenkyoninJohoDiv div) {
        RString shinseiNo = Saiban.get(SubGyomuCode.AFA選挙本体, 申請番号_採番).nextString();
        div.getZaigaiShinseiJoho().getTxtShinseiNo().setValue(shinseiNo);
        return ResponseData.of(div).respond();
    }

    /**
     * 交付番号の「採番」ボタンのイベントメソッドです。
     *
     * @param div ZaigaiSenkyoninJohoDiv
     * @return ResponseData<ZaigaiSenkyoninJohoDiv>
     */
    public ResponseData<ZaigaiSenkyoninJohoDiv> onClick_btnKofuNoSaiban(ZaigaiSenkyoninJohoDiv div) {

        if (!ResponseHolder.isReRequest()) {
            RDate txtKofuYMD = div.getZaigaiShinseiJoho().getTxtKofuYMD().getValue();
            return ResponseData.of(div).addMessage(
                    AfQuestionMessages.交付番号採番確認.getReplacedMessage(ButtonSelectPattern.YesNo,
                            txtKofuYMD == null ? RString.EMPTY.toString() : txtKofuYMD.wareki().toDateString().toString())).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        RString txtKofuNo = Saiban.get(SubGyomuCode.AFA選挙本体, 在外交付番号_採番).nextString();
        div.getZaigaiShinseiJoho().getTxtKofuNo().setValue(txtKofuNo);
        return ResponseData.of(div).respond();
    }

    /**
     * 交付番号存在チェックのイベントメソッドです。
     *
     * @param div ZaigaiSenkyoninJohoDiv
     * @return ResponseData<ZaigaiSenkyoninJohoDiv>
     */
    public ResponseData<ZaigaiSenkyoninJohoDiv> onBlur_txtKofuNo(ZaigaiSenkyoninJohoDiv div) {
        ZaigaiSenkyoninJohoFinder zaigaiSenkyoninJohoFinder = ZaigaiSenkyoninJohoFinder.createInstance();
        int count = zaigaiSenkyoninJohoFinder.get在外選挙資格件数By交付番号(div.getZaigaiShinseiJoho().getTxtKofuNo().getValue());
        if (!ResponseHolder.isReRequest() && count > 0) {
            return ResponseData.of(div).addMessage(AfWarningMessages.交付番号存在確認.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

}
