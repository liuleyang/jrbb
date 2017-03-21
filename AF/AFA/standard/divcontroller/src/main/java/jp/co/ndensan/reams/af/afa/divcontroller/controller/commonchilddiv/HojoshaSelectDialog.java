/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.hojoshanyuryoku.HojoshaNyuryokuSearchResult;
import jp.co.ndensan.reams.af.afa.business.hojoshaselectdialog.HojoshaSelectDialogModel;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.HojoshaSelectDialog.HojoshaSelectDialogDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.HojoshaSelectDialog.dgHojoshaSelect_Row;
import jp.co.ndensan.reams.af.afa.service.hojoshanyuryoku.HojoshaNyuryokuFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 補助者選択ダイアログに対応するコントローラです。
 *
 * @reamsid_L AF-0080-030 wangm
 */
public class HojoshaSelectDialog {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel HojoshaSelectDialogDiv
     * @return ResponseData<HojoshaSelectDialogDiv>
     */
    public ResponseData<HojoshaSelectDialogDiv> onLoad(HojoshaSelectDialogDiv mainPanel) {

        HojoshaSelectDialogModel model = DataPassingConverter.deserialize(mainPanel.getHojoshaSelectDialogModel(), HojoshaSelectDialogModel.class);

        ShohonNo shohonNo = model.getShohonNo();
        HojoshaNyuryokuFinder finder = InstanceProvider.create(HojoshaNyuryokuFinder.class);

        List<HojoshaNyuryokuSearchResult> rslt = finder.get補助者一覧(shohonNo, model.getTohyokuCode()).records();

        if (rslt.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("補助者"));
        }
        List<dgHojoshaSelect_Row> rowList = new ArrayList<>();
        for (HojoshaNyuryokuSearchResult searchResult : rslt) {
            rowList.add(new dgHojoshaSelect_Row(searchResult.get補助者識別コード().getColumnValue(),
                    searchResult.get宛名PSM名称(),
                    searchResult.get投票所名称(),
                    RString.EMPTY,
                    RString.EMPTY));

        }

        mainPanel.getCcdShohonName().initialize();
        mainPanel.getDgHojoshaSelect().setDataSource(rowList);

        if (shohonNo != null) {
            mainPanel.getCcdShohonName().selectedShohon(new RString(shohonNo.getColumnValue()));
            mainPanel.getCcdShohonName().setReadOnlyMode(true);
        }

        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 選択ボタンクリック時のイベントメソッドです。 <br />
     * グリッド行ダブルクリック時のイベントメソッドです。
     *
     * @param div HojoshaSelectDialogDiv
     * @return ResponseData<HojoshaSelectDialogDiv>
     */
    public ResponseData<HojoshaSelectDialogDiv> onSelectBySelectButton(HojoshaSelectDialogDiv div) {

        dgHojoshaSelect_Row row = div.getDgHojoshaSelect().getSelectedItems().get(0);

        HojoshaSelectDialogModel model = DataPassingConverter.deserialize(div.getHojoshaSelectDialogModel(), HojoshaSelectDialogModel.class);
        model.setMeisho(row.getTxtHojoshaName());
        model.setShikibetsuCode(row.getTxtShikibetsuCode());

        div.setHojoshaSelectDialogModel(DataPassingConverter.serialize(model));

        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 取消ボタンクリック時のイベントメソッドです。
     *
     * @param div HojoshaSelectDialogDiv
     * @return ResponseData<HojoshaSelectDialogDiv>
     */
    public ResponseData<HojoshaSelectDialogDiv> cancel(HojoshaSelectDialogDiv div) {

        return ResponseData.of(div).dialogNGClose();
    }
}
