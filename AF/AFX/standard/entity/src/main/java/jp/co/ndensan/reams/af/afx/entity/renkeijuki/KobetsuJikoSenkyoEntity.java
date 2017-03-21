/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afx.entity.renkeijuki;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 *
 * @author
 */
public class KobetsuJikoSenkyoEntity {

    private final ShikibetsuCode shikibetsuCode;
    private final Code shikakuKubun;

    /**
     * コンストラクタです。
     */
    public KobetsuJikoSenkyoEntity() {
        this.shikibetsuCode = ShikibetsuCode.EMPTY;
        this.shikakuKubun = Code.EMPTY;
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param shikibetsuCode 識別コード
     * @param shikakuKubun 選挙資格区分
     */
    public KobetsuJikoSenkyoEntity(ShikibetsuCode shikibetsuCode, Code shikakuKubun) {
        this.shikibetsuCode = shikibetsuCode;
        this.shikakuKubun = shikakuKubun;
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
     * @return Code
     */
    public Code getShikakuKubun() {
        return shikakuKubun;
    }

}
