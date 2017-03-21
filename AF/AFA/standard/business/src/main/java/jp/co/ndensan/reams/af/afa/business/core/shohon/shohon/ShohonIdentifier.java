/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.shohon.shohon;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;

/**
 * 抄本の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShohonIdentifier implements Serializable {

    private final ShohonNo 抄本番号;

    /**
     * コンストラクタです。
     *
     * @param 抄本番号 抄本番号
     */
    public ShohonIdentifier(ShohonNo 抄本番号) {
        this.抄本番号 = 抄本番号;
    }
}
