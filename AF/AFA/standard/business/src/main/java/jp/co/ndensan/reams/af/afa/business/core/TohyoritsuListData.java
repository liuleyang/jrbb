/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 投票率集計表帳票出力のデータリスト用対象クラスです。
 *
 * @reamsid_L AF-0290-035 lit
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TohyoritsuListData {

    private RString ラベル = RString.EMPTY;
    private Decimal 有権者男数 = Decimal.ZERO;
    private Decimal 有権者女数 = Decimal.ZERO;
    private Decimal 投票者男数 = Decimal.ZERO;
    private Decimal 投票者女数 = Decimal.ZERO;
    private Decimal 棄権者男数 = Decimal.ZERO;
    private Decimal 棄権者女数 = Decimal.ZERO;
    private Decimal 投票率男 = Decimal.ZERO;
    private Decimal 投票率女 = Decimal.ZERO;

    private Decimal 不在投票者男 = Decimal.ZERO;
    private Decimal 不在投票者女 = Decimal.ZERO;
    private Decimal 期日前投票男 = Decimal.ZERO;
    private Decimal 期日前投票女 = Decimal.ZERO;
    private Decimal 交付男 = Decimal.ZERO;
    private Decimal 交付女 = Decimal.ZERO;

    /**
     * 有権者数を合計。
     *
     * @return 有権者数
     */
    public Decimal get有権者数() {
        return 有権者男数.add(有権者女数);
    }

    /**
     * 投票者数を合計。
     *
     * @return 投票者数
     */
    public Decimal get投票者数() {
        return 投票者男数.add(投票者女数);
    }

    /**
     * 棄権者数を合計。
     *
     * @return 棄権者数
     */
    public Decimal get棄権者数() {
        return 棄権者男数.add(棄権者女数);
    }

    /**
     * 不在投票者数を合計。
     *
     * @return 不在投票者数
     */
    public Decimal get不在投票者数() {
        return 不在投票者男.add(不在投票者女);
    }

    /**
     * 期日前投票数を合計。
     *
     * @return 期日前投票数
     */
    public Decimal get期日前投票数() {
        return 期日前投票男.add(期日前投票女);
    }

    /**
     * 交付数を合計。
     *
     * @return 交付数
     */
    public Decimal get交付数() {
        return 交付男.add(交付女);
    }
}
