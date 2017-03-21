/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyokuCodeSelect.SenkyokuCodeSelectDiv;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 【共有子Div】SenkyokuCodeSelectDivに対するコントローラです。
 *
 * @reamsid_L AF-0720-030 zhanggs
 */
public class SenkyokuCodeSelect {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div SenkyokuCodeSelectDiv
     * @return ResponseData<SenkyokuCodeSelectDiv>
     */
    public ResponseData<SenkyokuCodeSelectDiv> initialize(SenkyokuCodeSelectDiv div) {

        RString senkyoShurui = div.getTxtHdnSenkyoShurui();
        RString senkyokuCode = div.getTxtSenkyokuCode().getValue();

        return div.getHandler().initialize(new Code(senkyoShurui), senkyokuCode);
    }

    /**
     * 選挙区コードを入力後（フォーカス喪失時）のイベントメソッドです。
     *
     * @param div SenkyokuCodeSelectDiv
     * @return ResponseData<SenkyokuCodeSelectDiv>
     */
    public ResponseData<SenkyokuCodeSelectDiv> onBlur_txtSenkyokuCode(SenkyokuCodeSelectDiv div) {
        RString senkyoShurui = div.getTxtHdnSenkyoShurui();
        RString senkyokuCode = div.getTxtSenkyokuCode().getValue();
        RString 選挙区名称 = div.getHandler().get選挙区名称(new Code(senkyoShurui), senkyokuCode);
        if (!選挙区名称.isNullOrEmpty()) {
            div.getTxtSenkyokuName().setValue(選挙区名称);
        } else {
            div.getTxtSenkyokuName().setValue(RString.EMPTY);
            return div.getHandler().checkコード重複チェック();
        }

        return ResponseData.of(div).respond();

    }

    /**
     * 選択ボタンのイベントメソッドです。
     *
     * @param div SenkyokuCodeSelectDiv
     * @return ResponseData<SenkyokuCodeSelectDiv>
     */
    public ResponseData<SenkyokuCodeSelectDiv> onBeforeClick_btnDialog(SenkyokuCodeSelectDiv div) {

        return ResponseData.of(div).respond();
    }

    /**
     * 選択ボタンのイベントメソッドです。
     *
     * @param div SenkyokuCodeSelectDiv
     * @return ResponseData<SenkyokuCodeSelectDiv>
     */
    public ResponseData<SenkyokuCodeSelectDiv> onClick_btnDialog(SenkyokuCodeSelectDiv div) {
        return ResponseData.of(div).respond();
    }

}
