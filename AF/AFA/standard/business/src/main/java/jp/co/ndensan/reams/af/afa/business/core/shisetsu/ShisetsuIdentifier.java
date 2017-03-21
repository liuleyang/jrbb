/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.shisetsu;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShisetsuIdentifier implements Serializable {

    private final RString 施設コード;

    /**
     * コンストラクタです。
     *
     * @param 施設コード 施設コード
     */
    public ShisetsuIdentifier(RString 施設コード) {
        this.施設コード = 施設コード;
    }
}
