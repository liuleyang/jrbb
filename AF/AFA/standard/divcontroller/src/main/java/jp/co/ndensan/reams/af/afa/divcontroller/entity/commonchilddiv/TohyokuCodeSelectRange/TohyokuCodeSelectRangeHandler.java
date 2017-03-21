/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelectRange;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * TohyokuCodeSelectRangeDiv の操作を担当するクラスです。
 * <p>
 * このクラスを通してTohyokuCodeSelectRangeDivの表示の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 * @reamsid_L AF-0270-013 xul
 */
public class TohyokuCodeSelectRangeHandler {

    private final TohyokuCodeSelectRangeDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 投票区コード範囲入力Div
     */
    public TohyokuCodeSelectRangeHandler(TohyokuCodeSelectRangeDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param senkyoShurui SenkyoShurui
     */
    public void initialize(SenkyoShurui senkyoShurui) {
        SenkyoShurui senkyoShuruiCode = senkyoShurui;
        div.getCcdTohyokuCodeFrom().initialize(senkyoShuruiCode, true);
        div.getCcdTohyokuCodeTo().initialize(senkyoShuruiCode, true);
    }

    /**
     * 引数の投票区コードから、この共有子Divの初期表示を行います。
     *
     * @param fromCode 開始投票区コード
     * @param toCode 終了投票区コード
     */
    public void initialize(RString fromCode, RString toCode) {
        div.getCcdTohyokuCodeFrom().initialize(fromCode);
        div.getCcdTohyokuCodeTo().initialize(toCode);
    }

    /**
     * この共有子Divのkを行います。
     *
     */
    public void clear() {
        clearThisPanel();
    }

    /**
     * 画面クリアのメソッドです。
     *
     */
    public void clearThisPanel() {
        div.getCcdTohyokuCodeFrom().clear();
        div.getCcdTohyokuCodeTo().clear();
    }

    /**
     * 関係チェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 関係チェック() {
        return getTohyokuCodeSelectRangeValidationHandler(div).validate();
    }

    private TohyokuCodeSelectRangeValidationHandler getTohyokuCodeSelectRangeValidationHandler(TohyokuCodeSelectRangeDiv div) {
        return new TohyokuCodeSelectRangeValidationHandler(div);
    }
}
