/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 期日前投票者一覧表
 *
 * @reamsid_L AF-0270-033 wangl
 */
public class KijitsumaeTohyoshaIchiran {

    private RString サブタイトル;
    private RString 選挙番号;
    private RString 投票区コード;
    private RString 投票区名;
    private RString 受付番号;
    private RString 投票区;
    private RString 頁;
    private RString 行;
    private RString 名称;
    private RString 性別コード;
    private FlexibleDate 生年月日;
    private Code 投票事由コード;
    private RString 施設コード;
    private Code 投票状況コード;
    private RDate 交付年月日;
    private RDate 受理年月日;
    private RTime 受理時刻;

    private Code 交付方法;
    private Code 受理方法;
    private boolean 代理投票有フラグ;
    private boolean 点字フラグ;

    /**
     * サブタイトルを設定します。
     *
     * @param サブタイトル RString
     */
    public void setサブタイトル(RString サブタイトル) {
        this.サブタイトル = サブタイトル;
    }

    /**
     * 選挙番号を設定します。
     *
     * @param 選挙番号 RString
     */
    public void set選挙番号(RString 選挙番号) {
        this.選挙番号 = 選挙番号;
    }

    /**
     * 投票区コードを設定します。
     *
     * @param 投票区コード RString
     */
    public void set投票区コード(RString 投票区コード) {
        this.投票区コード = 投票区コード;
    }

    /**
     * 投票区名を設定します。
     *
     * @param 投票区名 RString
     */
    public void set投票区名(RString 投票区名) {
        this.投票区名 = 投票区名;
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
     * @param 頁 RString
     */
    public void set頁(RString 頁) {
        this.頁 = 頁;
    }

    /**
     * 行を設定します。
     *
     * @param 行 RString
     */
    public void set行(RString 行) {
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
     * @param 生年月日 FlexibleDate
     */
    public void set生年月日(FlexibleDate 生年月日) {
        this.生年月日 = 生年月日;
    }

    /**
     * 投票事由コードを設定します。
     *
     * @param 投票事由コード Code
     */
    public void set投票事由コード(Code 投票事由コード) {
        this.投票事由コード = 投票事由コード;
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
     * 投票状況コードを設定します。
     *
     * @param 投票状況コード Code
     */
    public void set投票状況コード(Code 投票状況コード) {
        this.投票状況コード = 投票状況コード;
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
     * 受理時刻を設定します。
     *
     * @param 受理時刻 RTime
     */
    public void set受理時刻(RTime 受理時刻) {
        this.受理時刻 = 受理時刻;
    }

    /**
     * 交付方法を設定します。
     *
     * @param 交付方法 Code
     */
    public void set交付方法(Code 交付方法) {
        this.交付方法 = 交付方法;
    }

    /**
     * 受理方法を設定します。
     *
     * @param 受理方法 Code
     */
    public void set受理方法(Code 受理方法) {
        this.受理方法 = 受理方法;
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
     * サブタイトルを返します。
     *
     * @return サブタイトル
     */
    public RString getサブタイトル() {
        return this.サブタイトル;
    }

    /**
     * 選挙番号を返します。
     *
     * @return 選挙番号
     */
    public RString get選挙番号() {
        return this.選挙番号;
    }

    /**
     * 投票区コードを返します。
     *
     * @return 投票区コード
     */
    public RString get投票区コード() {
        return this.投票区コード;
    }

    /**
     * 投票区名を返します。
     *
     * @return 投票区名
     */
    public RString get投票区名() {
        return this.投票区名;
    }

    /**
     * 受付番号を返します。
     *
     * @return 受付番号
     */
    public RString get受付番号() {
        return this.受付番号;
    }

    /**
     * 投票区を返します。
     *
     * @return 投票区
     */
    public RString get投票区() {
        return this.投票区;
    }

    /**
     * 頁を返します。
     *
     * @return 頁
     */
    public RString get頁() {
        return this.頁;
    }

    /**
     * 行を返します。
     *
     * @return 行
     */
    public RString get行() {
        return this.行;
    }

    /**
     * 名称を返します。
     *
     * @return 名称
     */
    public RString get名称() {
        return this.名称;
    }

    /**
     * 性別コードを返します。
     *
     * @return 性別コード
     */
    public RString get性別コード() {
        return this.性別コード;
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return this.生年月日;
    }

    /**
     * 投票事由コードを返します。
     *
     * @return 投票事由コード
     */
    public Code get投票事由コード() {
        return this.投票事由コード;
    }

    /**
     * 施設コードを返します。
     *
     * @return 施設コード
     */
    public RString get施設コード() {
        return this.施設コード;
    }

    /**
     * 投票状況コードを返します。
     *
     * @return 投票状況コード
     */
    public Code get投票状況コード() {
        return this.投票状況コード;
    }

    /**
     * 交付年月日を返します。
     *
     * @return 交付年月日
     */
    public RDate get交付年月日() {
        return this.交付年月日;
    }

    /**
     * 受理年月日を返します。
     *
     * @return 受理年月日
     */
    public RDate get受理年月日() {
        return this.受理年月日;
    }

    /**
     * 受理時刻を返します。
     *
     * @return 受理時刻
     */
    public RTime get受理時刻() {
        return this.受理時刻;
    }

    /**
     * 交付方法を返します。
     *
     * @return 交付方法
     */
    public Code get交付方法() {
        return this.交付方法;
    }

    /**
     * 受理方法を返します。
     *
     * @return 受理方法
     */
    public Code get受理方法() {
        return this.受理方法;
    }

    /**
     * 代理投票有フラグを返します。
     *
     * @return 代理投票有フラグ
     */
    public boolean is代理投票有フラグ() {
        return this.代理投票有フラグ;
    }

    /**
     * 点字フラグを返します。
     *
     * @return 点字フラグ
     */
    public boolean is点字フラグ() {
        return this.点字フラグ;
    }
}
