/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 登録者数リスト（海区選挙）
 *
 * @reamsid_L AF-0460-033 wanghj
 */
public class TorokushasuListParam {

    private RDate 基準日;
    private RString 明細タイトル住所;
    private RString 投票区コード;
    private RString 集計地区名;
    private Decimal 有権者_男数;
    private Decimal 表示者_男数;
    private Decimal 公民権停止者_男数;
    private Decimal 有権者_女数;
    private Decimal 表示者_女数;
    private Decimal 公民権停止者_女数;

    /**
     * 投票区コードを設定します。
     *
     * @param 投票区コード RString
     */
    public void set投票区コード(RString 投票区コード) {
        this.投票区コード = 投票区コード;
    }

    /**
     * 投票区コードを返します。
     *
     * @return 投票区コード RString
     */
    public RString get投票区コード() {
        return this.投票区コード;
    }

    /**
     * 集計地区名を返します。
     *
     * @return 集計地区名 RString
     */
    public RString get集計地区名() {
        return this.集計地区名;
    }

    /**
     * 集計地区名を設定します。
     *
     * @param 集計地区名 RString
     */
    public void set集計地区名(RString 集計地区名) {
        this.集計地区名 = 集計地区名;
    }

    /**
     * 基準日を設定します。
     *
     * @param 基準日 RDate
     */
    public void set基準日(RDate 基準日) {
        this.基準日 = 基準日;
    }

    /**
     * 明細タイトル住所を設定します。
     *
     * @param 明細タイトル住所 RString
     */
    public void set明細タイトル住所(RString 明細タイトル住所) {
        this.明細タイトル住所 = 明細タイトル住所;
    }

    /**
     * 明細タイトル住所
     *
     * @return 明細タイトル住所 RString
     */
    public RString get明細タイトル住所() {
        return 明細タイトル住所;
    }

    /**
     * 基準日
     *
     * @return 基準日 RDate
     */
    public RDate get基準日() {
        return 基準日;
    }

    /**
     * 有権者_男数を返します。
     *
     * @return 有権者_男数 Decimal
     */
    public Decimal get有権者_男数() {
        return this.有権者_男数;
    }

    /**
     * 表示者_男数を返します。
     *
     * @return 表示者_男数 Decimal
     */
    public Decimal get表示者_男数() {
        return this.表示者_男数;
    }

    /**
     * 公民権停止者_男数を返します。
     *
     * @return 公民権停止者_男数 Decimal
     */
    public Decimal get公民権停止者_男数() {
        return this.公民権停止者_男数;
    }

    /**
     * 有権者_女数を返します。
     *
     * @return 有権者_女数 Decimal
     */
    public Decimal get有権者_女数() {
        return this.有権者_女数;
    }

    /**
     * 表示者_女数を返します。
     *
     * @return 表示者_女数 Decimal
     */
    public Decimal get表示者_女数() {
        return this.表示者_女数;
    }

    /**
     * 公民権停止者_女数を返します。
     *
     * @return 公民権停止者_女数 Decimal
     */
    public Decimal get公民権停止者_女数() {
        return this.公民権停止者_女数;
    }

    /**
     * 有権者_男数を設定します。
     *
     * @param 有権者_男数 Decimal
     */
    public void set有権者_男数(Decimal 有権者_男数) {
        this.有権者_男数 = 有権者_男数;
    }

    /**
     * 表示者_男数を設定します。
     *
     * @param 表示者_男数 Decimal
     */
    public void set表示者_男数(Decimal 表示者_男数) {
        this.表示者_男数 = 表示者_男数;
    }

    /**
     * 公民権停止者_男数を設定します。
     *
     * @param 公民権停止者_男数 Decimal
     */
    public void set公民権停止者_男数(Decimal 公民権停止者_男数) {
        this.公民権停止者_男数 = 公民権停止者_男数;
    }

    /**
     * 有権者_女数を設定します。
     *
     * @param 有権者_女数 Decimal
     */
    public void set有権者_女数(Decimal 有権者_女数) {
        this.有権者_女数 = 有権者_女数;
    }

    /**
     * 表示者_女数を設定します。
     *
     * @param 表示者_女数 Decimal
     */
    public void set表示者_女数(Decimal 表示者_女数) {
        this.表示者_女数 = 表示者_女数;
    }

    /**
     * 公民権停止者_女数を設定します。
     *
     * @param 公民権停止者_女数 Decimal
     */
    public void set公民権停止者_女数(Decimal 公民権停止者_女数) {
        this.公民権停止者_女数 = 公民権停止者_女数;
    }

}
