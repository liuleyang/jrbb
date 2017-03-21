/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyoku;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙区の識別子です。
 *
 * @reamsid_L AF-0290-020 lit
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class SenkyokuIdentifier implements Serializable {

    private final Code 選挙種類;
    private final RString 選挙区コード;

    /**
     * コンストラクタです。
     *
     * @param 選挙種類 選挙種類
     * @param 選挙区コード 選挙区コード
     */
    public SenkyokuIdentifier(Code 選挙種類, RString 選挙区コード) {
        this.選挙種類 = 選挙種類;
        this.選挙区コード = 選挙区コード;
    }
}
