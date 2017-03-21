/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.tohyojyo;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票所の識別子です。
 *
 * @reamsid_L AF-0280-020 lit
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class TohyojoIdentifier implements Serializable {

    private final RString 投票所コード;

    /**
     * コンストラクタです。
     *
     * @param 投票所コード 投票所コード
     */
    public TohyojoIdentifier(RString 投票所コード) {
        this.投票所コード = 投票所コード;
    }
}
