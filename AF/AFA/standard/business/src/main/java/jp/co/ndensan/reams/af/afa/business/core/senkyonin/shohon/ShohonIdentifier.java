/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyonin.shohon;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * 抄本の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShohonIdentifier implements Serializable {

    private final ShohonNo 抄本番号;
    private final Code 選挙種類;

    /**
     * コンストラクタです。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙種類 選挙種類
     */
    public ShohonIdentifier(ShohonNo 抄本番号,
            Code 選挙種類) {
        this.抄本番号 = 抄本番号;
        this.選挙種類 = 選挙種類;
    }
}
