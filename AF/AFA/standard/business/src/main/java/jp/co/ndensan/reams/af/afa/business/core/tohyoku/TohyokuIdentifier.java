/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.tohyoku;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票区の識別子です。
 *
 * @reamsid_L AF-0290-020 lit
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class TohyokuIdentifier implements Serializable {

    private final Code 選挙種類;
    private final RString 投票区コード;

    /**
     * コンストラクタです。
     *
     * @param 選挙種類 選挙種類
     * @param 投票区コード 投票区コード
     */
    public TohyokuIdentifier(Code 選挙種類, RString 投票区コード) {
        this.選挙種類 = 選挙種類;
        this.投票区コード = 投票区コード;
    }
}
