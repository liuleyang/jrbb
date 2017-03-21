/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 期日前投票日報
 *
 * @reamsid_L AF-0270-030 wangl
 */
public class KomokuShukei {

    private RString 性別;
    private boolean 点字フラグ;
    private boolean 代理投票有フラグ;

    /**
     * 性別を設定します。
     *
     * @param 性別 RString
     */
    public void set性別(RString 性別) {
        this.性別 = 性別;
    }

    /**
     * 点字フラグを設定します。
     *
     * @param 点字フラグ boolean
     */
    public void set点字フラグ(boolean 点字フラグ) {
        this.点字フラグ = 点字フラグ;
    }

    /**
     * 代理投票有フラグを設定します。
     *
     * @param 代理投票有フラグ boolean
     */
    public void set代理投票有フラグ(boolean 代理投票有フラグ) {
        this.代理投票有フラグ = 代理投票有フラグ;
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public RString get性別() {
        return this.性別;
    }

    /**
     * 点字フラグを返します。
     *
     * @return 点字フラグ
     */
    public boolean is点字フラグ() {
        return this.点字フラグ;
    }

    /**
     * 代理投票有フラグを返します。
     *
     * @return 代理投票有フラグ
     */
    public boolean is代理投票有フラグ() {
        return this.代理投票有フラグ;
    }
}
