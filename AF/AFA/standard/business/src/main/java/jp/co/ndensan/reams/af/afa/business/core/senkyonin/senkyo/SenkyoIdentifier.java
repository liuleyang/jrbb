/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyo;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;

/**
 * 選挙の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class SenkyoIdentifier implements Serializable {

    private final ShohonNo 抄本番号;
    private final SenkyoNo 選挙番号;

    /**
     * コンストラクタです。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙番号 選挙番号
     */
    public SenkyoIdentifier(ShohonNo 抄本番号,
            SenkyoNo 選挙番号) {
        this.抄本番号 = 抄本番号;
        this.選挙番号 = 選挙番号;
    }
}
