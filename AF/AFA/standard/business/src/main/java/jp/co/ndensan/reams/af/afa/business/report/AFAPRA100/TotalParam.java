/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA100;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.Seibetsu;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 選挙人名簿抄本集計のパラメータクラスです。
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TotalParam {

    private final RString 出力順;
    private RString 集計印字;
    private Decimal maleCount;
    private Decimal feMaleCount;
    private Decimal totalCount;

    /**
     * コンストラクタです。
     *
     * @param 出力順 RString
     */
    public TotalParam(RString 出力順) {
        this.出力順 = 出力順;
        this.集計印字 = RString.EMPTY;
        maleCount = Decimal.ZERO;
        feMaleCount = Decimal.ZERO;
        totalCount = Decimal.ZERO;
    }

    /**
     * コンストラクタです。
     *
     * @param trgt TotalParameter(出力順をコピーのみ)
     */
    public TotalParam(TotalParam trgt) {
        this.出力順 = trgt.出力順;
        this.集計印字 = RString.EMPTY;
        maleCount = Decimal.ZERO;
        feMaleCount = Decimal.ZERO;
        totalCount = Decimal.ZERO;
    }

    /**
     * カウント方法です。
     *
     * @param 性別 RString
     */
    public void add(RString 性別) {
        if (Seibetsu.男.code().equals(性別)) {
            maleCount = maleCount.add(Decimal.ONE);
            totalCount = totalCount.add(Decimal.ONE);
        } else if (Seibetsu.女.code().equals(性別)) {
            feMaleCount = feMaleCount.add(Decimal.ONE);
            totalCount = totalCount.add(Decimal.ONE);
        }
    }
}
