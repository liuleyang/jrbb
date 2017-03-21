package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.AtenaSealLayout.AtenaSealLayoutDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.AtenaSealLayout.AtenaSealLayoutHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * AtenaSealLayout のクラスファイル
 *
 * @reamsid_L AF-0620-013 jihb
 */
public class AtenaSealLayout extends Panel {

    /**
     * 住所のonChangeのイベントメソッドです。
     *
     * @param div AtenaSealLayoutDiv
     * @return ResponseData
     */
    public ResponseData<AtenaSealLayoutDiv> onChange_ddlJusho(AtenaSealLayoutDiv div) {
        getHandler(div).onChange_ddlJusho();
        return ResponseData.of(div).respond();
    }

    /**
     * 宛名のonChangeのイベントメソッドです。
     *
     * @param div AtenaSealLayoutDiv
     * @return ResponseData
     */
    public ResponseData<AtenaSealLayoutDiv> onChange_ddlAtena(AtenaSealLayoutDiv div) {
        getHandler(div).onChange_ddlAtena();
        return ResponseData.of(div).respond();
    }

    private AtenaSealLayoutHandler getHandler(AtenaSealLayoutDiv div) {
        return new AtenaSealLayoutHandler(div);
    }
}
