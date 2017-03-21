/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.business.shisetsucodeselect.ShisetsuCodeSelectModel;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelect.ShisetsuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelect.ShisetsuCodeSelectHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 【共有子Div】ShisetsuCodeSelectDivに対するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0080-035 qiuxy
 */
public class ShisetsuCodeSelect {

    /**
     * 施設コードを入力後（フォーカス喪失時）のイベントメソッドです。
     *
     * @param div ShisetsuCodeSelectDiv
     * @return ResponseData<ShisetsuCodeSelectDiv>
     */
    public ResponseData<ShisetsuCodeSelectDiv> onBlur_txtShisetsuCode(ShisetsuCodeSelectDiv div) {
        ValidationMessageControlPairs validResult = div.getValidationHandler().validate();
        if (validResult.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validResult).respond();
        }
        ShisetsuCodeSelectHandler handler = createHandlerOf(div);
        div.getTxtShisetsuName().setValue(handler.get施設名称(div.getTxtShisetsuCode().getValue()));

        return ResponseData.of(div).respond();

    }

    /**
     * 施設コードを入力後（フォーカス喪失時）のイベントメソッドです。
     *
     * @param div ShisetsuCodeSelectDiv
     * @return ResponseData<ShisetsuCodeSelectDiv>
     */
    public ResponseData<ShisetsuCodeSelectDiv> onBeforeOpenDialog_btnShisetsuCode(ShisetsuCodeSelectDiv div) {
        ShisetsuCodeSelectModel model = new ShisetsuCodeSelectModel();
        model.set施設コード(div.getTxtShisetsuCode().getValue());
        model.set本庁支所区分(ViewStateHolder.get(ViewStateKeys.本庁支所区分, boolean.class));
        model.setUsing施設種別(div.getIsUsingShisetsuShubetsu().equals(new RString("1")));
        model.set施設種別コード(div.getTxtHdnShisetsuShubetsu());
        div.setShisetsuCodeSelectModel(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }
//
//    /**
//     * 施設コードを入力後（フォーカス喪失時）のイベントメソッドです。
//     *
//     * @param div ShisetsuCodeSelectDiv
//     * @return ResponseData<ShisetsuCodeSelectDiv>
//     */
//    public ResponseData<ShisetsuCodeSelectDiv> onOKClose_btnShisetsuCode(ShisetsuCodeSelectDiv div) {
//        ShisetsuCodeSelectModel model = DataPassingConverter.deserialize(div.getShisetsuCodeSelectModel(), ShisetsuCodeSelectModel.class);
//        div.getTxtShisetsuCode().setValue(model.get施設コード());
//        div.getTxtShisetsuName().setValue(model.get施設名称());
//        return ResponseData.of(div).focusId(div.getTxtShisetsuCode().getSelectControlID()).respond();
//    }

    private ShisetsuCodeSelectHandler createHandlerOf(ShisetsuCodeSelectDiv div) {
        return new ShisetsuCodeSelectHandler(div);
    }

}
