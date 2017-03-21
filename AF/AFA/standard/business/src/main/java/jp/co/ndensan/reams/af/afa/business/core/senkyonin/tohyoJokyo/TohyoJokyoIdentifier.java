/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 投票状況の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class TohyoJokyoIdentifier implements Serializable {

    private final ShohonNo 抄本番号;
    private final ShikibetsuCode 識別コード;
    private final SenkyoNo 選挙番号;

    /**
     * コンストラクタです。
     *
     * @param 抄本番号 抄本番号
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     */
    public TohyoJokyoIdentifier(ShohonNo 抄本番号,
            ShikibetsuCode 識別コード,
            SenkyoNo 選挙番号) {
        this.抄本番号 = 抄本番号;
        this.識別コード = 識別コード;
        this.選挙番号 = 選挙番号;
    }
}
