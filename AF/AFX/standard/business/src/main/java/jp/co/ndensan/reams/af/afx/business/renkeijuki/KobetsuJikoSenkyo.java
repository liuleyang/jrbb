/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afx.business.renkeijuki;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙の個別記載事項クラスです。
 *
 * @author
 */
public class KobetsuJikoSenkyo {

    private ShikibetsuCode shikibetsuCode;
    private RString senkyoShikaku;

    /**
     * コンストラクタです。
     */
    public KobetsuJikoSenkyo() {
        this.shikibetsuCode = ShikibetsuCode.EMPTY;
        this.senkyoShikaku = RString.EMPTY;
    }

    /**
     * 識別コードを返します。
     *
     * @return ShikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 選挙資格を返します。
     *
     * @return RString
     */
    public RString getSenkyoShikaku() {
        return senkyoShikaku;
    }

    /**
     * 識別コードをセットします。
     *
     * @param shikibetsuCode ShikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 選挙資格をセットします。
     *
     * @param senkyoShikaku RString
     */
    public void setSenkyoShikaku(RString senkyoShikaku) {
        this.senkyoShikaku = senkyoShikaku;
    }

}
