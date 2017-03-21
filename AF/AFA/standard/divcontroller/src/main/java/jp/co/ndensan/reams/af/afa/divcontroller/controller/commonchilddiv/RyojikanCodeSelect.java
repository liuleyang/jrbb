/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.business.core.ryojikan.RyojikanResult;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.RyojikanCodeSelect.RyojikanCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.service.core.ryojikan.RyojikanManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 領事官コード選択共有子DIVのコントロールクラスです。
 *
 * @reamsid_L AF-0320-015 xul
 */
public class RyojikanCodeSelect {

    /**
     * 領事官コードを入力後（フォーカス喪失時）のイベントメソッドです。
     *
     * @param div KumiaiCodeSelectDiv
     * @return ResponseData<KumiaiCodeSelectDiv>
     */
    public ResponseData<RyojikanCodeSelectDiv> onBlur_txtRyojikanCode(RyojikanCodeSelectDiv div) {
        RyojikanManager ryojikanManager = RyojikanManager.createInstance();
        RyojikanResult ryojikanResult = ryojikanManager.selectBy領事官コード(div.getTxtRyojikanCode().getValue());
        RString 領事官名称 = RString.EMPTY;
        if (ryojikanResult != null) {
            領事官名称 = ryojikanResult.get領事官名称();
        }
        div.getTxtRyojikanName().setValue(領事官名称);
        return getResponseData(div);
    }

    private ResponseData<RyojikanCodeSelectDiv> getResponseData(RyojikanCodeSelectDiv div) {
        ResponseData<RyojikanCodeSelectDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    /**
     * 領事官コード選択ボタンを押下メソッドです。
     *
     * @param div KumiaiCodeSelectDiv
     * @return ResponseData<KumiaiCodeSelectDiv>
     */
    public ResponseData<RyojikanCodeSelectDiv> onBeforeOpenDialog_checkRyojikanSelect(RyojikanCodeSelectDiv div) {
        RyojikanManager ryojikanManager = RyojikanManager.createInstance();
        if (!div.getTxtRyojikanCode().getValue().isEmpty()) {
            RyojikanResult ryojikanResult = ryojikanManager.selectBy領事官コード(div.getTxtRyojikanCode().getValue());
            if (ryojikanResult == null) {
                throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("領事官コード"));
            }
        }
        return getResponseData(div);
    }

}
