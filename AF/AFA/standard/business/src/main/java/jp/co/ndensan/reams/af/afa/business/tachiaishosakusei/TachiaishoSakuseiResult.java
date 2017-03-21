/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.tachiaishosakusei;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在外交付履歴Resultクラス
 *
 * @reamsid_L AF-0320-014 xul
 */
public class TachiaishoSakuseiResult implements Serializable {

    private RString 氏名１;
    private RString 氏名２;
    private RString 氏名３;
    private RString 氏名４;

    /**
     * 氏名１取得
     *
     * @return 氏名１
     */
    public RString get氏名１() {
        return 氏名１;
    }

    /**
     * 氏名２取得
     *
     * @return 氏名２
     */
    public RString get氏名２() {
        return 氏名２;
    }

    /**
     * 氏名３取得
     *
     * @return 氏名３
     */
    public RString get氏名３() {
        return 氏名３;
    }

    /**
     * 氏名４取得
     *
     * @return 氏名４
     */
    public RString get氏名４() {
        return 氏名４;
    }

    /**
     * 氏名１ 設定
     *
     * @param 氏名１ RString
     */
    public void set氏名１(RString 氏名１) {
        this.氏名１ = 氏名１;
    }

    /**
     * 氏名２ 設定
     *
     * @param 氏名２ RString
     */
    public void set氏名２(RString 氏名２) {
        this.氏名２ = 氏名２;
    }

    /**
     * 氏名３ 設定
     *
     * @param 氏名３ RString
     */
    public void set氏名３(RString 氏名３) {
        this.氏名３ = 氏名３;
    }

    /**
     * 氏名４ 設定
     *
     * @param 氏名４ RString
     */
    public void set氏名４(RString 氏名４) {
        this.氏名４ = 氏名４;
    }

}
