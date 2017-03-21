/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.RyojikanCodeSelect;

import jp.co.ndensan.reams.af.afa.business.core.ryojikan.RyojikanResult;
import jp.co.ndensan.reams.af.afa.service.core.ryojikan.RyojikanManager;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 領事官コード選択共有子DIVのコントロールクラスです。
 *
 * @reamsid_L AF-0320-015 xul
 */
public class RyojikanCodeSelectHandler {

    private final RyojikanCodeSelectDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 組合コード選択Div
     */
    public RyojikanCodeSelectHandler(RyojikanCodeSelectDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ
     *
     * @param div 領事官コード選択共有子DIV
     * @return HenreiChohyoShokaiHandler
     */
    public static RyojikanCodeSelectHandler of(RyojikanCodeSelectDiv div) {
        return new RyojikanCodeSelectHandler(div);
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param 渡された領事官コード RString
     */
    public void initialize(RString 渡された領事官コード) {
        clear();
        div.getTxtRyojikanCode().setValue(渡された領事官コード);
        RyojikanManager ryojikanManager = RyojikanManager.createInstance();
        RyojikanResult ryojikanResult = ryojikanManager.selectBy領事官コード(渡された領事官コード);
        if (ryojikanResult != null) {
            div.getTxtRyojikanName().setValue(ryojikanResult.get領事官名称());
        }
    }

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     */
    public void clear() {
        div.getTxtRyojikanCode().clearValue();
        div.getTxtRyojikanName().clearValue();
    }

}
