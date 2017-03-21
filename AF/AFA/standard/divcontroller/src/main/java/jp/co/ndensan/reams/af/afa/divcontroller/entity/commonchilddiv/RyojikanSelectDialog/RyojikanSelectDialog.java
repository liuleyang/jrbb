/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.RyojikanSelectDialog;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ryojikan.RyojikanResult;
import jp.co.ndensan.reams.af.afa.service.core.ryojikan.RyojikanManager;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 領事官コード選択共有子DIVのコントロールクラスです。
 *
 * @reamsid_L AF-0320-015 xul
 */
public class RyojikanSelectDialog {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div KumiaiSelectDialogDiv
     * @return ResponseData
     */
    public ResponseData<RyojikanSelectDialogDiv> onLoad(RyojikanSelectDialogDiv div) {
        ResponseData<RyojikanSelectDialogDiv> response = new ResponseData<>();
        RString 渡された領事官コード = div.getTxtHdnSelectedCode();

        RyojikanManager ryojikanManager = RyojikanManager.createInstance();
        RyojikanResult ryojikanResult;
        if (!渡された領事官コード.isEmpty()) {
            ryojikanResult = ryojikanManager.selectBy領事官コード(渡された領事官コード);
            if (ryojikanResult != null) {
                List<dgRyojikanSelect_Row> dataSource = new ArrayList<>();
                dataSource.add(RyojikanSelectDialogHandler.of(div).modelToRow(ryojikanResult));
                div.getDgRyojikanSelect().setDataSource(dataSource);
            }

        } else {
            List<RyojikanResult> ryojikanResultList = ryojikanManager.select領事官マスタ();
            List<dgRyojikanSelect_Row> dataSource = new ArrayList<>();
            for (RyojikanResult ryojikanResults : ryojikanResultList) {
                dataSource.add(RyojikanSelectDialogHandler.of(div).modelToRow(ryojikanResults));
            }
            div.getDgRyojikanSelect().setDataSource(dataSource);

        }
        response.data = div;
        return response;
    }

    /**
     * 選択ボタンのイベントメソッドです。
     *
     * @param div KumiaiSelectDialogDiv
     * @return response
     */
    public ResponseData<RyojikanSelectDialogDiv> onSelectBySelectButton_closeOK(RyojikanSelectDialogDiv div) {
        ResponseData<RyojikanSelectDialogDiv> response = new ResponseData<>();
        RString 領事官コード = div.getDgRyojikanSelect().getClickedItem().getTxtRyojikanCode();
        RString 領事官名称 = div.getDgRyojikanSelect().getClickedItem().getTxtRyojikanName();
        div.setTxtHdnSelectedCode(領事官コード);
        div.setTxtHdnSelectedName(領事官名称);
        response.data = div;
        return response;
    }
}
