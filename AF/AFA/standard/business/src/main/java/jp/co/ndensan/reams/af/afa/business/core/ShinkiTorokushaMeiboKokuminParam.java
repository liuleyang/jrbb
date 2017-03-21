/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 補正登録者名簿
 *
 * @reamsid_L AF-0360-051 guancy
 */
public class ShinkiTorokushaMeiboKokuminParam {

    private RString タイトル1;
    private RString タイトル2;
    private RString 内容1;
    private RString 内容2;
    private RString 住所;
    private RString 作成条件;
    private SenkyoninShikakuInfo 選挙人資格情報Info;

    /**
     * コンストラクタです。
     *
     * @param 選挙人資格情報Info SenkyoninShikakuInfo
     */
    public ShinkiTorokushaMeiboKokuminParam(SenkyoninShikakuInfo 選挙人資格情報Info) {
        this.選挙人資格情報Info = 選挙人資格情報Info;
    }

    /**
     * タイトル1を返します。
     *
     * @return タイトル1 RString
     */
    public RString getタイトル1() {
        return タイトル1;
    }

    /**
     * タイトル2を返します。
     *
     * @return タイトル2 RString
     */
    public RString getタイトル2() {
        return タイトル2;
    }

    /**
     * 内容1を返します。
     *
     * @return 内容1 RString
     */
    public RString get内容1() {
        return 内容1;
    }

    /**
     * 内容2を返します。
     *
     * @return 内容2 RString
     */
    public RString get内容2() {
        return 内容2;
    }

    /**
     * 住所を返します。
     *
     * @return 住所 RString
     */
    public RString get住所() {
        return 住所;
    }

    /**
     * 作成条件を返します。
     *
     * @return 作成条件 RString
     */
    public RString get作成条件() {
        return 作成条件;
    }

    /**
     * 選挙人資格情報Infoを返します。
     *
     * @return 選挙人資格情報Info SenkyoninShikakuInfo
     */
    public SenkyoninShikakuInfo get選挙人資格情報Info() {
        return 選挙人資格情報Info;
    }

    /**
     * タイトル1を設定します。
     *
     * @param タイトル1 RString
     */
    public void setタイトル1(RString タイトル1) {
        this.タイトル1 = タイトル1;
    }

    /**
     * タイトル2を設定します。
     *
     * @param タイトル2 RString
     */
    public void setタイトル2(RString タイトル2) {
        this.タイトル2 = タイトル2;
    }

    /**
     * 内容1を設定します。
     *
     * @param 内容1 RString
     */
    public void set内容1(RString 内容1) {
        this.内容1 = 内容1;
    }

    /**
     * 内容2を設定します。
     *
     * @param 内容2 RString
     */
    public void set内容2(RString 内容2) {
        this.内容2 = 内容2;
    }

    /**
     * 住所を設定します。
     *
     * @param 住所 RString
     */
    public void set住所(RString 住所) {
        this.住所 = 住所;
    }

    /**
     * 作成条件を設定します。
     *
     * @param 作成条件 RString
     */
    public void set作成条件(RString 作成条件) {
        this.作成条件 = 作成条件;
    }

    /**
     * 選挙人資格情報Infoを設定します。
     *
     * @param 選挙人資格情報Info SenkyoninShikakuInfo
     */
    public void set選挙人資格情報Info(SenkyoninShikakuInfo 選挙人資格情報Info) {
        this.選挙人資格情報Info = 選挙人資格情報Info;
    }

}
