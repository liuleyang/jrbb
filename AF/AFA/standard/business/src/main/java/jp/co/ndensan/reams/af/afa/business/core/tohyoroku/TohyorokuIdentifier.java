/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.tohyoroku;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 期日前・当日投票録の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class TohyorokuIdentifier implements Serializable {

    private final ShohonNo 抄本番号;
    private final SenkyoNo 選挙番号;
    private final FlexibleDate 報告年月日;
    private final RString 施設コード;
    private final RString 投票区コード;

    /**
     * コンストラクタです。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙番号 選挙番号
     * @param 報告年月日 報告年月日
     * @param 施設コード 施設コード
     * @param 投票区コード 投票区コード
     */
    public TohyorokuIdentifier(
            ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            RString 施設コード,
            RString 投票区コード) {
        this.抄本番号 = 抄本番号;
        this.選挙番号 = 選挙番号;
        this.報告年月日 = 報告年月日;
        this.施設コード = 施設コード;
        this.投票区コード = 投票区コード;
    }
}
