/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.tohyoroku.tachiaininhikitsugi;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 立会人引継の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class TachiaininHikitsugiIdentifier implements Serializable {

    private final ShohonNo 抄本番号;
    private final SenkyoNo 選挙番号;
    private final FlexibleDate 報告年月日;
    private final RString 施設コード;
    private final RString 投票区コード;
    private final int 立会人連番;
    private final Code 投票録項目種類;
    private final int 連番;

    /**
     * コンストラクタです。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙番号 選挙番号
     * @param 報告年月日 報告年月日
     * @param 施設コード 施設コード
     * @param 投票区コード 投票区コード
     * @param 立会人連番 立会人連番
     * @param 投票録項目種類 投票録項目種類
     * @param 連番 連番
     */
    public TachiaininHikitsugiIdentifier(ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            RString 施設コード,
            RString 投票区コード,
            int 立会人連番,
            Code 投票録項目種類,
            int 連番) {
        this.抄本番号 = 抄本番号;
        this.選挙番号 = 選挙番号;
        this.報告年月日 = 報告年月日;
        this.施設コード = 施設コード;
        this.投票区コード = 投票区コード;
        this.立会人連番 = 立会人連番;
        this.投票録項目種類 = 投票録項目種類;
        this.連番 = 連番;
    }
}
