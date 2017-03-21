/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.business.shisetsucodeselect.ShisetsuCodeSelectModel;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuSelectDialog.ShisetsuSelectDialogDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 施設選択ダイアログに対するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0080-035 qiuxy
 */
public class ShisetsuSelectDialog {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel ShisetsuSelectDialogDiv
     * @return ResponseData<ShisetsuSelectDialogDiv>
     */
    public ResponseData<ShisetsuSelectDialogDiv> onLoad(ShisetsuSelectDialogDiv mainPanel) {

        ShisetsuCodeSelectModel model = DataPassingConverter.deserialize(mainPanel.getShisetsuCodeSelectModel(), ShisetsuCodeSelectModel.class);
        boolean is本庁支所 = model.is本庁支所区分();
        mainPanel.getHandler().setIntialShisetsuShubetsu(is本庁支所, model);

        RString 施設種別コード = mainPanel.getDdlShisetsuShubetsu().getSelectedKey();
        mainPanel.getDgShisetsuSelect().setDataSource(mainPanel.getHandler().setDataSourceToDataGrid(施設種別コード));

        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 選択ボタンクリック時のイベントメソッドです。 <br />
     * グリッド行ダブルクリック時のイベントメソッドです。
     *
     * @param div ShisetsuSelectDialogDiv
     * @return ResponseData<ShisetsuSelectDialogDiv>
     */
    public ResponseData<ShisetsuSelectDialogDiv> onSelectBySelectButton_closeOK(ShisetsuSelectDialogDiv div) {
        ShisetsuCodeSelectModel model = new ShisetsuCodeSelectModel();
        model.set施設コード(div.getDgShisetsuSelect().getSelectedItems().get(0).getTxtShisetsuCode());
        model.set施設名称(div.getDgShisetsuSelect().getSelectedItems().get(0).getTxtShisetsuName());
        div.setShisetsuCodeSelectModel(DataPassingConverter.serialize(model));
        div.setTxtHdnSelectedCode(div.getDgShisetsuSelect().getSelectedItems().get(0).getTxtShisetsuCode());
        div.setTxtHdnSelectedName(div.getDgShisetsuSelect().getSelectedItems().get(0).getTxtShisetsuName());
        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 施設種別DDLを変更した時のイベントメソッドです。
     *
     * @param div ShisetsuSelectDialogDiv
     * @return ResponseData<ShisetsuSelectDialogDiv>
     */
    public ResponseData<ShisetsuSelectDialogDiv> onChange_ddlShisetsuShubetsu(ShisetsuSelectDialogDiv div) {

        if (div.getDdlShisetsuShubetsu().getSelectedKey().equals(RString.EMPTY)) {
            div.getDgShisetsuSelect().getDataSource().clear();
        } else {
            div.getDgShisetsuSelect().setDataSource(div.getHandler().setDataSourceToDataGrid(div.getDdlShisetsuShubetsu().getSelectedKey()));
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「取消」ボタンを押した時のイベントメソッドです。
     *
     * @param div ShisetsuSelectDialogDiv
     * @return ResponseData<ShisetsuSelectDialogDiv>
     */
    public ResponseData<ShisetsuSelectDialogDiv> onClick_btnCancel(ShisetsuSelectDialogDiv div) {

        return ResponseData.of(div).dialogNGClose();
    }

}
