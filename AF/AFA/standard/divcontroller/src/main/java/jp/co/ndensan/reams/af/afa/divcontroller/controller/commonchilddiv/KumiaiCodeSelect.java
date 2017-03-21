/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.business.core.kumiai.KumiaiResult;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KumiaiCodeSelect.KumiaiCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.service.core.kumiai.kumiai.KumiaiManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 【共有子Div】KumiaiCodeSelectDivに対するコントローラです。
 *
 * @reamsid_L AF-0500-030 gyq
 */
public class KumiaiCodeSelect {

    /**
     * 組合コードを入力後（フォーカス喪失時）のイベントメソッドです。
     *
     * @param div KumiaiCodeSelectDiv
     * @return ResponseData<KumiaiCodeSelectDiv>
     */
    public ResponseData<KumiaiCodeSelectDiv> onBlur_txtKumiaiCode(KumiaiCodeSelectDiv div) {

        KumiaiManager kumiaiManager = KumiaiManager.createInstance();
        KumiaiResult kumiaiResult;
        kumiaiResult = kumiaiManager.selectBy組合コード(div.getTxtKumiaiCode().getValue());
        RString 組合名称 = RString.EMPTY;
        if (kumiaiResult != null) {
            組合名称 = kumiaiResult.get組合名称();
        }
        div.getTxtKumiaiName().setValue(組合名称);

        return getResponseData(div);
    }

    private ResponseData<KumiaiCodeSelectDiv> getResponseData(KumiaiCodeSelectDiv div) {
        ResponseData<KumiaiCodeSelectDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    /**
     * 組合選択ボタンを押下メソッドです。
     *
     * @param div KumiaiCodeSelectDiv
     * @return ResponseData<KumiaiCodeSelectDiv>
     */
    public ResponseData<KumiaiCodeSelectDiv> onBeforeOpenDialog_checkBtnKumiaiCode(KumiaiCodeSelectDiv div) {

        KumiaiManager kumiaiManager = KumiaiManager.createInstance();
        if (!div.getTxtKumiaiCode().getValue().isEmpty()) {
            KumiaiResult kumiaiResult = kumiaiManager.selectBy組合コード(div.getTxtKumiaiCode().getValue());
            if (kumiaiResult == null) {
                throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("組合コード"));
            }
        }

        return getResponseData(div);
    }

}
