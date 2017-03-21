/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.shikakujoho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 資格情報Entityクラスです。
 *
 * @reamsid_L AF-0180-015 liuyj
 */
public class ShikakuJohoEntity implements Cloneable, Serializable {

    private ShikibetsuCode shikibetsuCode;

    private Code senkyoShurui;

    private int wksenkyoShurui;

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 選挙種類を返します。
     *
     * @return 選挙種類
     */
    public Code getSenkyoShurui() {
        return senkyoShurui;
    }

    /**
     * 選挙種類がの国政選挙・地方選挙を返します。
     *
     * @return 選挙種類がの国政選挙・地方選挙
     */
    public int getWksenkyoShurui() {
        return wksenkyoShurui;
    }

    /**
     * 識別コードを返します。
     *
     * @param shikibetsuCode ShikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 選挙種類を返します。
     *
     * @param senkyoShurui Code
     */
    public void setSenkyoShurui(Code senkyoShurui) {
        this.senkyoShurui = senkyoShurui;
    }

    /**
     * 選挙種類がの国政選挙・地方選挙を返します。
     *
     * @param wksenkyoShurui int
     */
    public void setWksenkyoShurui(int wksenkyoShurui) {
        this.wksenkyoShurui = wksenkyoShurui;
    }

}
