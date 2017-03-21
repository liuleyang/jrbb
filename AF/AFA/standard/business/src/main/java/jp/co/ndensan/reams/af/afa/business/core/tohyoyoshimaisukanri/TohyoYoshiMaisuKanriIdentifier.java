/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.tohyoyoshimaisukanri;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票区の識別子です。
 *
 * @reamsid_L AF-0130-020 lit
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class TohyoYoshiMaisuKanriIdentifier implements Serializable {

    private final ShohonNo 抄本番号;
    private final SenkyoNo 選挙番号;
    private final RString 投票区コード;

    /**
     * コンストラクタです。
     *
     * @param 抄本番号 ShohonNo
     * @param 選挙番号 SenkyoNo
     * @param 投票区コード RString
     */
    public TohyoYoshiMaisuKanriIdentifier(ShohonNo 抄本番号, SenkyoNo 選挙番号, RString 投票区コード) {
        this.抄本番号 = 抄本番号;
        this.選挙番号 = 選挙番号;
        this.投票区コード = 投票区コード;
    }
}
