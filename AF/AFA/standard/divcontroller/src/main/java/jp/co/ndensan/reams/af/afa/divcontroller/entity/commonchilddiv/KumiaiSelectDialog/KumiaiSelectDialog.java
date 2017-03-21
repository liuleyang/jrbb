/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KumiaiSelectDialog;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.kumiai.KumiaiResult;
import jp.co.ndensan.reams.af.afa.service.core.kumiai.kumiai.KumiaiManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 組合選択ダイアログ共有子Divのコントロールクラスです。
 *
 * @reamsid_L AF-0500-030 gyq
 */
public class KumiaiSelectDialog {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div KumiaiSelectDialogDiv
     * @return ResponseData
     */
    public ResponseData<KumiaiSelectDialogDiv> onLoad(KumiaiSelectDialogDiv div) {
//        ResponseData<KumiaiSelectDialogDiv> response = new ResponseData<>();
        RString 渡された組合コード = div.getTxtHdnSelectedCode();

        KumiaiManager kumiaiManager = KumiaiManager.createInstance();
        KumiaiResult kumiaiResult;
        if (!渡された組合コード.isEmpty()) {
            kumiaiResult = kumiaiManager.selectBy組合コード(渡された組合コード);
            if (kumiaiResult == null) {
                return ResponseData.of(div).addMessage(UrErrorMessages.存在しない.getMessage()).respond();
            } else {
                List<dgKumiaiSelect_Row> dataSource = new ArrayList<>();
                dataSource.add(KumiaiSelectDialogHandler.of().modelToRow(kumiaiResult));
                div.getDgKumiaiSelect().setDataSource(dataSource);
            }

        } else {
            List<KumiaiResult> kumiaiResultList = kumiaiManager.select組合マスタ();
            List<dgKumiaiSelect_Row> dataSource = new ArrayList<>();
            for (KumiaiResult kumiaiResults : kumiaiResultList) {
                dataSource.add(KumiaiSelectDialogHandler.of().modelToRow(kumiaiResults));
            }
            div.getDgKumiaiSelect().setDataSource(dataSource);

        }
//        response.data = div;
        return ResponseData.of(div).respond();
    }

    /**
     * 選択ボタンのイベントメソッドです。
     *
     * @param div KumiaiSelectDialogDiv
     * @return response
     */
    public ResponseData<KumiaiSelectDialogDiv> onSelectBySelectButton_closeOK(KumiaiSelectDialogDiv div) {
        RString 組合コード = div.getDgKumiaiSelect().getClickedItem().getTxtKumiaiCode();
        RString 組合名称 = div.getDgKumiaiSelect().getClickedItem().getTxtKumiaiName();
        div.setTxtHdnSelectedName(組合名称);
        div.setTxtHdnSelectedCode(組合コード);
        return ResponseData.of(div).respond();

    }

}
