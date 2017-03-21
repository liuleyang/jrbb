/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 合計情報
 *
 * @reamsid_L AF-0460-033 wanghj
 */
public class GoukeiJouhou {

    private Decimal 有権者_男数;
    private Decimal 表示者_男数;
    private Decimal 公民権停止者_男数;
    private Decimal 有権者_女数;
    private Decimal 表示者_女数;
    private Decimal 公民権停止者_女数;

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
