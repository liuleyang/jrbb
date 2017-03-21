/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票者一覧表
 *
 * @reamsid_L AF-0270-034 wangl
 */
public class TohyoJokyoEntity {

    private RString 受付番号;
    private RString 投票区;
    private int 頁;
    private int 行;
    private RString 名称;
    private RString 性別コード;
    private RDate 生年月日;
    private RString 住民種別;
    private RString 投票事由コード;
    private RString 請求方法;
    private RString 施設コード;
    private RString 投票状況;
    private RDate 交付年月日;
    private RDate 受理年月日;
    private RDate 投票年月日;
    private RString 交付方法;
    private boolean 代理投票有フラグ;
    private boolean 点字フラグ;
    private RString 識別コード;

    private RString 期日前不在者_場合;
    private RString 選挙種類;
    private RString 選挙番号;

    /**
     * 受付番号を返します。
     *
     * @return 受付番号 RString
     */
    public RString get受付番号() {
        return 受付番号;
    }

    /**
     * 投票区を返します。
     *
     * @return 投票区 RString
     */
    public RString get投票区() {
        return 投票区;
    }

    /**
     * 頁を返します。
     *
     * @return 頁 int
     */
    public int get頁() {
        return 頁;
    }

    /**
     * 行を返します。
     *
     * @return 行 int
     */
    public int get行() {
        return 行;
    }

    /**
     * 名称を返します。
     *
     * @return 名称 RString
     */
    public RString get名称() {
        return 名称;
    }

    /**
     * 性別コードを返します。
     *
     * @return 性別コード RString
     */
    public RString get性別コード() {
        return 性別コード;
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日 RDate
     */
    public RDate get生年月日() {
        return 生年月日;
    }

    /**
     * 住民種別を返します。
     *
     * @return 住民種別 RString
     */
    public RString get住民種別() {
        return 住民種別;
    }

    /**
     * 投票事由コードを返します。
     *
     * @return 投票事由コード RString
     */
    public RString get投票事由コード() {
        return 投票事由コード;
    }

    /**
     * 請求方法を返します。
     *
     * @return 請求方法 RString
     */
    public RString get請求方法() {
        return 請求方法;
    }

    /**
     * 施設コードを返します。
     *
     * @return 施設コード RString
     */
    public RString get施設コード() {
        return 施設コード;
    }

    /**
     * 投票状況を返します。
     *
     * @return 投票状況 RString
     */
    public RString get投票状況() {
        return 投票状況;
    }

    /**
     * 交付年月日を返します。
     *
     * @return 交付年月日 RDate
     */
    public RDate get交付年月日() {
        return 交付年月日;
    }

    /**
     * 受理年月日を返します。
     *
     * @return 受理年月日 RDate
     */
    public RDate get受理年月日() {
        return 受理年月日;
    }

    /**
     * 投票年月日を返します。
     *
     * @return 投票年月日 RDate
     */
    public RDate get投票年月日() {
        return 投票年月日;
    }

    /**
     * 交付方法を返します。
     *
     * @return 交付方法 RString
     */
    public RString get交付方法() {
        return 交付方法;
    }

    /**
     * 代理投票有フラグを返します。
     *
     * @return 代理投票有フラグ boolean
     */
    public boolean is代理投票有フラグ() {
        return 代理投票有フラグ;
    }

    /**
     * 点字フラグを返します。
     *
     * @return 点字フラグ boolean
     */
    public boolean is点字フラグ() {
        return 点字フラグ;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード RString
     */
    public RString get識別コード() {
        return 識別コード;
    }

    /**
     * 期日前不在者_場合を返します。
     *
     * @return 期日前不在者_場合 RString
     */
    public RString get期日前不在者_場合() {
        return 期日前不在者_場合;
    }

    /**
     * 選挙種類を返します。
     *
     * @return 選挙種類 RString
     */
    public RString get選挙種類() {
        return 選挙種類;
    }

    /**
     * 選挙番号を返します。
     *
     * @return 選挙番号 RString
     */
    public RString get選挙番号() {
        return 選挙番号;
    }

    /**
     * 受付番号を設定します。
     *
     * @param 受付番号 RString
     */
    public void set受付番号(RString 受付番号) {
        this.受付番号 = 受付番号;
    }

    /**
     * 投票区を設定します。
     *
     * @param 投票区 RString
     */
    public void set投票区(RString 投票区) {
        this.投票区 = 投票区;
    }

    /**
     * 頁を設定します。
     *
     * @param 頁 int
     */
    public void set頁(int 頁) {
        this.頁 = 頁;
    }

    /**
     * 行を設定します。
     *
     * @param 行 int
     */
    public void set行(int 行) {
        this.行 = 行;
    }

    /**
     * 名称を設定します。
     *
     * @param 名称 RString
     */
    public void set名称(RString 名称) {
        this.名称 = 名称;
    }

    /**
     * 性別コードを設定します。
     *
     * @param 性別コード RString
     */
    public void set性別コード(RString 性別コード) {
        this.性別コード = 性別コード;
    }

    /**
     * 生年月日を設定します。
     *
     * @param 生年月日 RDate
     */
    public void set生年月日(RDate 生年月日) {
        this.生年月日 = 生年月日;
    }

    /**
     * 住民種別を設定します。
     *
     * @param 住民種別 RString
     */
    public void set住民種別(RString 住民種別) {
        this.住民種別 = 住民種別;
    }

    /**
     * 投票事由コードを設定します。
     *
     * @param 投票事由コード RString
     */
    public void set投票事由コード(RString 投票事由コード) {
        this.投票事由コード = 投票事由コード;
    }

    /**
     * 請求方法を設定します。
     *
     * @param 請求方法 RString
     */
    public void set請求方法(RString 請求方法) {
        this.請求方法 = 請求方法;
    }

    /**
     * 施設コードを設定します。
     *
     * @param 施設コード RString
     */
    public void set施設コード(RString 施設コード) {
        this.施設コード = 施設コード;
    }

    /**
     * 投票状況を設定します。
     *
     * @param 投票状況 RString
     */
    public void set投票状況(RString 投票状況) {
        this.投票状況 = 投票状況;
    }

    /**
     * 交付年月日を設定します。
     *
     * @param 交付年月日 RDate
     */
    public void set交付年月日(RDate 交付年月日) {
        this.交付年月日 = 交付年月日;
    }

    /**
     * 受理年月日を設定します。
     *
     * @param 受理年月日 RDate
     */
    public void set受理年月日(RDate 受理年月日) {
        this.受理年月日 = 受理年月日;
    }

    /**
     * 投票年月日を設定します。
     *
     * @param 投票年月日 RDate
     */
    public void set投票年月日(RDate 投票年月日) {
        this.投票年月日 = 投票年月日;
    }

    /**
     * 交付方法を設定します。
     *
     * @param 交付方法 RString
     */
    public void set交付方法(RString 交付方法) {
        this.交付方法 = 交付方法;
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
     * 点字フラグを設定します。
     *
     * @param 点字フラグ boolean
     */
    public void set点字フラグ(boolean 点字フラグ) {
        this.点字フラグ = 点字フラグ;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード boolean
     */
    public void set識別コード(RString 識別コード) {
        this.識別コード = 識別コード;
    }

    /**
     * 期日前不在者_場合を設定します。
     *
     * @param 期日前不在者_場合 RString
     */
    public void set期日前不在者_場合(RString 期日前不在者_場合) {
        this.期日前不在者_場合 = 期日前不在者_場合;
    }

    /**
     * 選挙種類を設定します。
     *
     * @param 選挙種類 RString
     */
    public void set選挙種類(RString 選挙種類) {
        this.選挙種類 = 選挙種類;
    }

    /**
     * 選挙番号を設定します。
     *
     * @param 選挙番号 RString
     */
    public void set選挙番号(RString 選挙番号) {
        this.選挙番号 = 選挙番号;
    }

}
