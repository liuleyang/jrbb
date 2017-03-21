/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 送致書帳票出力の帳票用対象クラスです。
 *
 * @reamsid_L AF-0280-030 lit
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SochishoParam {

    private RString 投票区コード = RString.EMPTY;
    private RString 市町村名 = RString.EMPTY;
    private Decimal 不在者投票者男数 = Decimal.ZERO;
    private Decimal 不在者投票者女数 = Decimal.ZERO;
    private Decimal 名簿登録者男数 = Decimal.ZERO;
    private Decimal 名簿登録者女数 = Decimal.ZERO;
    private Decimal 有権者男数 = Decimal.ZERO;
    private Decimal 有権者女数 = Decimal.ZERO;
    private Decimal 受数_投票用紙 = Decimal.ZERO;
    private Decimal 受数_点字投票用紙 = Decimal.ZERO;
    private Decimal 受数_仮投票用封筒 = Decimal.ZERO;
}
