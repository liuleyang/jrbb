/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.business.tohyokucodeselect.TohyokuCodeSelectModel;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.TohyokuCodeSelectDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 【共有子Div】TohyokuCodeSelectDivに対するコントローラです。
 *
 * @reamsid_L AF-0070-015 liss
 */
public class TohyokuCodeSelect {

    private static final RString CHECKBYCOMMONCHILDDIV = new RString("1");

    /**
     * 投票区コードを入力後（フォーカス喪失時）のイベントメソッドです。
     *
     * @param div TohyokuCodeSelectDiv
     * @return ResponseData<TohyokuCodeSelectDiv>
     */
    public ResponseData<TohyokuCodeSelectDiv> onBlur_txtTohyokuCode(TohyokuCodeSelectDiv div) {
        if (div.getIsNyuryokuCheckByCommonChildDiv().equals(CHECKBYCOMMONCHILDDIV)) {
            if (!RString.isNullOrEmpty(div.get投票区コード())) {
                ValidationMessageControlPairs pairs = div.getHandler().投票区コードチェック();
                //CHECKSTYLE IGNORE NestedIfDepth FOR NEXT 1 LINES
                if (pairs.iterator().hasNext()) {
                    return ResponseData.of(div).addValidationMessages(pairs).respond();
                }
                div.getTxtTohyokuName().setValue(div.getHandler().get投票区名称());
            } else {
                div.getTxtTohyokuName().clearValue();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログボタンをクリックするイベントメソッドです。
     *
     * @param div TohyokuCodeSelectDiv
     * @return ResponseData<TohyokuCodeSelectDiv>
     */
    public ResponseData<TohyokuCodeSelectDiv> onBeforeOpenDialog_btnTohyokuCode(TohyokuCodeSelectDiv div) {
        TohyokuCodeSelectModel model = new TohyokuCodeSelectModel();
        model.set選挙種類コード(div.getTxtHdnSenkyoShurui());
        div.setTohyokuCodeSelectModel(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }
}
