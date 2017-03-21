/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyonin.fuzaishatohyoshikaku;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;

/**
 * 不在者投票資格の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class FuzaishaTohyoShikakuIdentifier implements Serializable {

    private final ShikibetsuCode 識別コード;
    private final Code 投票資格種類;
    private final BigSerial 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 識別コード 識別コード
     * @param 投票資格種類 投票資格種類
     * @param 履歴番号 履歴番号
     */
    public FuzaishaTohyoShikakuIdentifier(ShikibetsuCode 識別コード,
            Code 投票資格種類,
            BigSerial 履歴番号) {
        this.識別コード = 識別コード;
        this.投票資格種類 = 投票資格種類;
        this.履歴番号 = 履歴番号;
    }
}
