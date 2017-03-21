/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelectRange;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShisetsuShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * ShisetsuCodeSelectRangeDiv の操作を担当するクラスです。
 *
 *
 * @reamsid_L AF-0270-012 xul
 */
public class ShisetsuCodeSelectRangeHandler {

    private final ShisetsuCodeSelectRangeDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 施設コード範囲入力Div
     */
    public ShisetsuCodeSelectRangeHandler(ShisetsuCodeSelectRangeDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     */
    public void initialize() {
        div.getCcdShisetsuCodeFrom().initialize();
        div.getCcdShisetsuCodeTo().initialize();
    }

    /**
     * 引数の施設コードから、この共有子Divの初期表示を行います。
     *
     * @param fromCode 開始施設コード
     * @param toCode 終了施設コード
     * @param 施設種別 ShisetsuShubetsu
     */
    public void initialize(RString fromCode, RString toCode, ShisetsuShubetsu 施設種別) {
        div.getCcdShisetsuCodeFrom().initialize(施設種別, false, fromCode);
        RString 施設名称From = div.getCcdShisetsuCodeFrom().get施設名称();
        div.setTxthidShisetsuNameFrom(施設名称From);

        div.getCcdShisetsuCodeTo().initialize(施設種別, false, toCode);
        RString 施設名称To = div.getCcdShisetsuCodeTo().get施設名称();
        div.setTxthidShisetsuNameTo(施設名称To);

    }

    /**
     * 画面クリアのメソッドです。
     *
     */
    public void clearThisPanel() {
        div.getCcdShisetsuCodeFrom().clear();
        div.getCcdShisetsuCodeTo().clear();
    }

    /**
     * 施設名称Fromを取得します。
     *
     * @return 施設名称
     */
    public RString get施設名称From() {
        return div.getTxthidShisetsuNameFrom();
    }

    /**
     * 施設名称Toを取得します。
     *
     * @return 施設名称
     */
    public RString get施設名称To() {
        return div.getTxthidShisetsuNameTo();
    }

    /**
     * 関係チェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 関係チェック() {
        return getShisetsuCodeSelectRangeValidationHandler(div).validate();
    }

    private ShisetsuCodeSelectRangeValidationHandler getShisetsuCodeSelectRangeValidationHandler(ShisetsuCodeSelectRangeDiv div) {
        return new ShisetsuCodeSelectRangeValidationHandler(div);
    }

}
