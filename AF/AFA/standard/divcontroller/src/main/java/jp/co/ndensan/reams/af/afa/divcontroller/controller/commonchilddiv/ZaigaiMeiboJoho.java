package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ZaigaiMeiboJoho.ZaigaiMeiboJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ZaigaiMeiboJoho.ZaigaiMeiboJohoHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ZaigaiMeiboJohoのクラスファイル
 *
 * @reamsid_L AF-0320-013 xul
 */
public class ZaigaiMeiboJoho extends Panel {

    /**
     * 表示事由ドロップダウンのclickのイベントメソッドです。
     *
     * @param div ZaigaiMeiboJohoDiv
     * @return ResponseData
     */
    public ResponseData<ZaigaiMeiboJohoDiv> onChange_ddlJiyuName(ZaigaiMeiboJohoDiv div) {
        getHandler(div).onChange_ddlJiyuName();
        return ResponseData.of(div).respond();
    }

    private ZaigaiMeiboJohoHandler getHandler(ZaigaiMeiboJohoDiv div) {
        return new ZaigaiMeiboJohoHandler(div);
    }
}
