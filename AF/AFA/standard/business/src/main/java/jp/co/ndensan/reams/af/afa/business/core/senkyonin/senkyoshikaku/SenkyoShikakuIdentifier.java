/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoshikaku;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;

/**
 * 選挙資格の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class SenkyoShikakuIdentifier implements Serializable {

    private final Code 選挙種類;
    private final ShikibetsuCode 識別コード;
    private final BigSerial 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 選挙種類 選挙種類
     * @param 識別コード 識別コード
     * @param 履歴番号 履歴番号
     */
    public SenkyoShikakuIdentifier(Code 選挙種類,
            ShikibetsuCode 識別コード,
            BigSerial 履歴番号) {
        this.選挙種類 = 選挙種類;
        this.識別コード = 識別コード;
        this.履歴番号 = 履歴番号;
    }
}
