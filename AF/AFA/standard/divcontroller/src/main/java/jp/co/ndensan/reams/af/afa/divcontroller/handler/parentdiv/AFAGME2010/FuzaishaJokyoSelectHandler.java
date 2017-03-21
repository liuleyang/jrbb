/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.FuzaishaJokyoSelectDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 【View】FuzaishaTohyoDiv内の <br />
 * 【子Div】FuzaishaTohyoJokyoDiv内の <br />
 * FuzaishaJokyoSelectDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0080-010 lit
 */
public final class FuzaishaJokyoSelectHandler {

    private FuzaishaJokyoSelectHandler() {
    }

    /**
     * 初期表示時のイベントメソッドです。
     *
     * @param div FuzaishaJokyoSelectDiv
     * @param mode RString
     */
    public static void initialize(FuzaishaJokyoSelectDiv div, RString mode) {
        RString blank = new RString("　　　　　　");
        List<KeyValueDataSource> keyValueList = new ArrayList<>();

        if (mode.equals(TohyoJokyo.請求.toRString())) {
            keyValueList.add(new KeyValueDataSource(TohyoJokyo.請求.getCode(), TohyoJokyo.請求.toRString().concat(blank)));
        } else if (mode.equals(TohyoJokyo.交付.toRString())) {
            keyValueList.add(new KeyValueDataSource(TohyoJokyo.交付.getCode(), TohyoJokyo.交付.toRString().concat(blank)));
        } else if (mode.equals(TohyoJokyo.受理.toRString())) {
            keyValueList.add(new KeyValueDataSource(TohyoJokyo.受理.getCode(), TohyoJokyo.受理.toRString()));
            keyValueList.add(new KeyValueDataSource(TohyoJokyo.返還.getCode(), TohyoJokyo.返還.toRString()));
            keyValueList.add(new KeyValueDataSource(TohyoJokyo.棄権.getCode(), TohyoJokyo.棄権.toRString()));
            keyValueList.add(new KeyValueDataSource(TohyoJokyo.受付拒否.getCode(), TohyoJokyo.受付拒否.toRString().concat(blank)));
        }
        keyValueList.add(new KeyValueDataSource(TohyoJokyo.取消.getCode(), TohyoJokyo.取消.toRString()));
        div.getRadFuzaishaTohyoJokyo().setDataSource(keyValueList);

        div.getRadFuzaishaTohyoJokyo().setSelectedIndex(0);
    }

    /**
     * 画面項目のクリアメソッドです。
     *
     * @param div FuzaishaJokyoSelectDiv
     */
    public static void clearThisPanel(FuzaishaJokyoSelectDiv div) {
        div.getRadFuzaishaTohyoJokyo().setSelectedIndex(0);
    }
}
