/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.af.afa.definition.processprm.tohyokekkaprint.AFABTE505SelectProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 時間別投票者集計表帳票出力の帳票用対象クラスです。
 *
 * @reamsid_L AF-0290-037 lit
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JikanbetsuTohyoshaParam {

    private int subTitle = 0;
    private RString 選挙番号 = RString.EMPTY;
    private RString 選挙名 = RString.EMPTY;
    private RString 時間帯1 = RString.EMPTY;
    private RString 時間帯2 = RString.EMPTY;
    private RString 時間帯3 = RString.EMPTY;
    private RString 時間帯4 = RString.EMPTY;
    private RString 時間帯5 = RString.EMPTY;
    private RString 投票区コード = RString.EMPTY;
    private RString 投票所名称 = RString.EMPTY;
    private Decimal 時間帯1男数 = Decimal.ZERO;
    private Decimal 時間帯1女数 = Decimal.ZERO;
    private Decimal 時間帯2男数 = Decimal.ZERO;
    private Decimal 時間帯2女数 = Decimal.ZERO;
    private Decimal 時間帯3男数 = Decimal.ZERO;
    private Decimal 時間帯3女数 = Decimal.ZERO;
    private Decimal 時間帯4男数 = Decimal.ZERO;
    private Decimal 時間帯4女数 = Decimal.ZERO;
    private Decimal 時間帯5男数 = Decimal.ZERO;
    private Decimal 時間帯5女数 = Decimal.ZERO;

    private ZenjitsuCommonJohoItem commonHeader;
    private AFABTE505SelectProcessParameter param;

    /**
     * 時間帯1計数を返す。
     *
     * @return 時間帯1計数
     */
    public Decimal get時間帯1計数() {
        return null != 時間帯1男数 && null != 時間帯1女数 ? 時間帯1男数.add(時間帯1女数) : null;
    }

    /**
     * 時間帯2計数を返す。
     *
     * @return 時間帯2計数
     */
    public Decimal get時間帯2計数() {
        return null != 時間帯2男数 && null != 時間帯2女数 ? 時間帯2男数.add(時間帯2女数) : null;
    }

    /**
     * 時間帯3計数を返す。
     *
     * @return 時間帯3計数
     */
    public Decimal get時間帯3計数() {
        return null != 時間帯3男数 && null != 時間帯3女数 ? 時間帯3男数.add(時間帯3女数) : null;
    }

    /**
     * 時間帯4計数を返す。
     *
     * @return 時間帯4計数
     */
    public Decimal get時間帯4計数() {
        return null != 時間帯4男数 && null != 時間帯4女数 ? 時間帯4男数.add(時間帯4女数) : null;
    }

    /**
     * 時間帯5計数を返す。
     *
     * @return 時間帯5計数
     */
    public Decimal get時間帯5計数() {
        return null != 時間帯5男数 && null != 時間帯5女数 ? 時間帯5男数.add(時間帯5女数) : null;
    }

    /**
     * サブタイトルを返す。
     *
     * @return サブタイトル　サブタイトル
     */
    public RString getサブタイトル() {
        return new RString("（").concat(new RString(String.valueOf(subTitle))).concat(new RString("）"));
    }
}
