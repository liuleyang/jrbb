/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.contexts;

import jp.co.ndensan.reams.uz.uza.core.validation.IContext;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設コード選択のコンテキストです。
 *
 * @author N1823 有澤 礼恵
 */
public class ShisetsuCodeSelectContext implements IContext {

    private final RString shisetsuCode;

    /**
     * コンストラクタです。
     *
     * @param shisetsuCode 施設コード
     */
    public ShisetsuCodeSelectContext(RString shisetsuCode) {
        this.shisetsuCode = shisetsuCode;
    }

    /**
     * 施設コードを返します。
     *
     * @return 施設コード
     */
    public RString getShisetsuCode() {
        return shisetsuCode;
    }

}
