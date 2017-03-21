/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.shikakujoho;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 資格情報共有子DIVクラスです。
 *
 * @reamsid_L AF-0180-015 lis2
 */
public class ShikakuJohoParameter {

    private ShikibetsuCode shikibetsuCode;

    private Code senkyoShurui;

    private int wksenkyoShurui;

    /**
     * 識別コードを取得します。
     *
     * @return ShikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 選挙種類を取得します。
     *
     * @return Code
     */
    public Code getSenkyoShurui() {
        return senkyoShurui;
    }

    /**
     * 選挙種類がの国政選挙・地方選挙を取得します。
     *
     * @return int
     */
    public int getWksenkyoShurui() {
        return wksenkyoShurui;
    }

    /**
     * 識別コードを設定します。
     *
     * @param shikibetsuCode ShikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 選挙種類を設定します。
     *
     * @param senkyoShurui Code
     */
    public void setSenkyoShurui(Code senkyoShurui) {
        this.senkyoShurui = senkyoShurui;
    }

    /**
     * 選挙種類がの国政選挙・地方選挙を設定します。
     *
     * @param wksenkyoShurui int
     */
    public void setWksenkyoShurui(int wksenkyoShurui) {
        this.wksenkyoShurui = wksenkyoShurui;
    }

}
