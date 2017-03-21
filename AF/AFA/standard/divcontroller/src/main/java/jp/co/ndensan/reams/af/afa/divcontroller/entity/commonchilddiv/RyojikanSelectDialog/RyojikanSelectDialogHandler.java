/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.RyojikanSelectDialog;

import jp.co.ndensan.reams.af.afa.business.core.ryojikan.RyojikanResult;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 領事官コード選択共有子DIVのコントロールクラスです。
 *
 * @reamsid_L AF-0320-015 xul
 */
public class RyojikanSelectDialogHandler {

    private final RyojikanSelectDialogDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 組合コード選択Div
     */
    public RyojikanSelectDialogHandler(RyojikanSelectDialogDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ
     *
     * @param div 領事官コード選択共有子DIV
     * @return HenreiChohyoShokaiHandler
     */
    public static RyojikanSelectDialogHandler of(RyojikanSelectDialogDiv div) {
        return new RyojikanSelectDialogHandler(div);
    }

    /**
     * 領事官マスタのセットします。
     *
     * @param ryojikanResult RyojikanResult
     * @return dgKumiaiSelect_Row
     */
    public dgRyojikanSelect_Row modelToRow(RyojikanResult ryojikanResult) {
        dgRyojikanSelect_Row row = new dgRyojikanSelect_Row();
        row.setTxtRyojikanCode(ryojikanResult.get領事官コード());
        row.setTxtRyojikanName(ryojikanResult.get領事官名称());
        row.setTxtKanaRyojikanName(ryojikanResult.getカナ領事官名称());
        row.setTxtHyojijun(new RString(String.valueOf(ryojikanResult.get表示順())));
        div.getDgRyojikanSelect();
        return row;
    }
}
