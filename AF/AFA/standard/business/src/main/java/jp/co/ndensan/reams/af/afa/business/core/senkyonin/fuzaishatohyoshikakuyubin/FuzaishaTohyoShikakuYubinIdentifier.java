/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyonin.fuzaishatohyoshikakuyubin;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;

/**
 * 郵便投票資格付随情報の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class FuzaishaTohyoShikakuYubinIdentifier implements Serializable {

    private final ShikibetsuCode 識別コード;
    private final BigSerial 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 識別コード 識別コード
     * @param 履歴番号 履歴番号
     */
    public FuzaishaTohyoShikakuYubinIdentifier(ShikibetsuCode 識別コード,
            BigSerial 履歴番号) {
        this.識別コード = 識別コード;
        this.履歴番号 = 履歴番号;
    }
}
