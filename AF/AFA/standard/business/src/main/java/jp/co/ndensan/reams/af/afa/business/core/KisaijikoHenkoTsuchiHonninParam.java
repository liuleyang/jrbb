/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.af.afa.entity.db.relate.meibotorokuzaigai.ZaigaiSenkyoninShinseiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 記載事項変更通知（本人）
 *
 * @reamsid_L AF-0330-030 zhangl
 */
public class KisaijikoHenkoTsuchiHonninParam {

    private final ZaigaiSenkyoninShinseiJohoEntity 在外選挙人申請情報;
    private final ZaigaiSakuseiChohyo 画面帳票作成入力項目;

    private RString hakkoDaino;
    private RString hakkoYmd;
    private RString honninShimei1;
    private RString honninShimei2;
    private RString tsuchiMoto1;
    private RString tsuchiMoto2;
    private RString iinchoMei1;
    private RString iinchoMei2;
    private RString honbun1;
    private RString honbun2;
    private RString honbun3;
    private RString honbun4;
    private RString honbun5;
    private RString honbun6;
    private RString renrakusakiIinkaiMei;
    private RString renrakusakiYubinNo;
    private RString renrakusakiJusho1;
    private RString renrakusakiJusho2;
    private RString renrakusakiTitle1;
    private RString renrakusaki1;
    private RString renrakusakiTitle2;
    private RString renrakusaki2;
    private RString renrakusakiTitle3;
    private RString renrakusaki3;

    /**
     * コンストラクタです。
     *
     * @param 在外選挙人申請情報 ZaigaiSenkyoninShinseiJohoEntity
     * @param 画面帳票作成入力項目 ZaigaiSakuseiChohyo
     *
     */
    public KisaijikoHenkoTsuchiHonninParam(ZaigaiSenkyoninShinseiJohoEntity 在外選挙人申請情報, ZaigaiSakuseiChohyo 画面帳票作成入力項目) {
        this.在外選挙人申請情報 = 在外選挙人申請情報;
        this.画面帳票作成入力項目 = 画面帳票作成入力項目;
    }

    /**
     * 画面帳票作成入力項目
     *
     * @return 画面帳票作成入力項目 ZaigaiSakuseiChohyo
     */
    public ZaigaiSakuseiChohyo get画面帳票作成入力項目() {
        return 画面帳票作成入力項目;
    }

    /**
     * 在外選挙人申請情報list
     *
     * @return 在外選挙人申請情報list ZaigaiSenkyoninShinseiJohoEntity
     */
    public ZaigaiSenkyoninShinseiJohoEntity get在外選挙人申請情報() {
        return 在外選挙人申請情報;
    }

    /**
     * 発行番号
     *
     * @param hakkoDaino RString
     */
    public void setHakkoDaino(RString hakkoDaino) {
        this.hakkoDaino = hakkoDaino;
    }

    /**
     * 発行年月日
     *
     * @param hakkoYmd RString
     */
    public void setHakkoYmd(RString hakkoYmd) {
        this.hakkoYmd = hakkoYmd;
    }

    /**
     * 本人氏名1
     *
     * @param honninShimei1 RString
     */
    public void setHonninShimei1(RString honninShimei1) {
        this.honninShimei1 = honninShimei1;
    }

    /**
     * 本人氏名２
     *
     * @param honninShimei2 RString
     */
    public void setHonninShimei2(RString honninShimei2) {
        this.honninShimei2 = honninShimei2;
    }

    /**
     * 通知元市町村1
     *
     * @param tsuchiMoto1 RString
     */
    public void setTsuchiMoto1(RString tsuchiMoto1) {
        this.tsuchiMoto1 = tsuchiMoto1;
    }

    /**
     * 通知元市町村２
     *
     * @param tsuchiMoto2 RString
     */
    public void setTsuchiMoto2(RString tsuchiMoto2) {
        this.tsuchiMoto2 = tsuchiMoto2;
    }

    /**
     * 委員長名1
     *
     * @param iinchoMei1 RString
     */
    public void setIinchoMei1(RString iinchoMei1) {
        this.iinchoMei1 = iinchoMei1;
    }

    /**
     * 委員長名２
     *
     * @param iinchoMei2 RString
     */
    public void setIinchoMei2(RString iinchoMei2) {
        this.iinchoMei2 = iinchoMei2;
    }

    /**
     * 本文1
     *
     * @param honbun1 RString
     */
    public void setHonbun1(RString honbun1) {
        this.honbun1 = honbun1;
    }

    /**
     * 本文2
     *
     * @param honbun2 RString
     */
    public void setHonbun2(RString honbun2) {
        this.honbun2 = honbun2;
    }

    /**
     * 本文3
     *
     * @param honbun3 RString
     */
    public void setHonbun3(RString honbun3) {
        this.honbun3 = honbun3;
    }

    /**
     * 本文3
     *
     * @param honbun4 RString
     */
    public void setHonbun4(RString honbun4) {
        this.honbun4 = honbun4;
    }

    /**
     * 本文5
     *
     * @param honbun5 RString
     */
    public void setHonbun5(RString honbun5) {
        this.honbun5 = honbun5;
    }

    /**
     * 本文６
     *
     * @param honbun6 RString
     */
    public void setHonbun6(RString honbun6) {
        this.honbun6 = honbun6;
    }

    /**
     * 連絡先委員会名
     *
     * @param renrakusakiIinkaiMei RString
     */
    public void setRenrakusakiIinkaiMei(RString renrakusakiIinkaiMei) {
        this.renrakusakiIinkaiMei = renrakusakiIinkaiMei;
    }

    /**
     * 連絡先郵便番号
     *
     * @param renrakusakiYubinNo RString
     */
    public void setRenrakusakiYubinNo(RString renrakusakiYubinNo) {
        this.renrakusakiYubinNo = renrakusakiYubinNo;
    }

    /**
     * 連絡先住所1
     *
     * @param renrakusakiJusho1 RString
     */
    public void setRenrakusakiJusho1(RString renrakusakiJusho1) {
        this.renrakusakiJusho1 = renrakusakiJusho1;
    }

    /**
     * 連絡先住所２
     *
     * @param renrakusakiJusho2 RString
     */
    public void setRenrakusakiJusho2(RString renrakusakiJusho2) {
        this.renrakusakiJusho2 = renrakusakiJusho2;
    }

    /**
     * 連絡先タイトル1
     *
     * @param renrakusakiTitle1 RString
     */
    public void setRenrakusakiTitle1(RString renrakusakiTitle1) {
        this.renrakusakiTitle1 = renrakusakiTitle1;
    }

    /**
     * 連絡先1
     *
     * @param renrakusaki1 RString
     */
    public void setRenrakusaki1(RString renrakusaki1) {
        this.renrakusaki1 = renrakusaki1;
    }

    /**
     * 連絡先タイトル2
     *
     * @param renrakusakiTitle2 RString
     */
    public void setRenrakusakiTitle2(RString renrakusakiTitle2) {
        this.renrakusakiTitle2 = renrakusakiTitle2;
    }

    /**
     * 連絡先2
     *
     * @param renrakusaki2 RString
     */
    public void setRenrakusaki2(RString renrakusaki2) {
        this.renrakusaki2 = renrakusaki2;
    }

    /**
     * 連絡先タイトル３
     *
     * @param renrakusakiTitle3 RString
     */
    public void setRenrakusakiTitle3(RString renrakusakiTitle3) {
        this.renrakusakiTitle3 = renrakusakiTitle3;
    }

    /**
     * 連絡先３
     *
     * @param renrakusaki3 RString
     */
    public void setRenrakusaki3(RString renrakusaki3) {
        this.renrakusaki3 = renrakusaki3;
    }

    /**
     * 発行番号
     *
     * @return hakkoDaino RString
     */
    public RString getHakkoDaino() {
        return hakkoDaino;
    }

    /**
     * 発行年月日
     *
     * @return hakkoYmd RString
     */
    public RString getHakkoYmd() {
        return hakkoYmd;
    }

    /**
     * 本人氏名1
     *
     * @return honninShimei1 RString
     */
    public RString getHonninShimei1() {
        return honninShimei1;
    }

    /**
     * 本人氏名２
     *
     * @return honninShimei2 RString
     */
    public RString getHonninShimei2() {
        return honninShimei2;
    }

    /**
     * 通知元市町村名1
     *
     * @return tsuchiMoto1 RString
     */
    public RString getTsuchiMoto1() {
        return tsuchiMoto1;
    }

    /**
     * 通知元市町村名２
     *
     * @return tsuchiMoto2 RString
     */
    public RString getTsuchiMoto2() {
        return tsuchiMoto2;
    }

    /**
     * 委員長名1
     *
     * @return iinchoMei1 RString
     */
    public RString getIinchoMei1() {
        return iinchoMei1;
    }

    /**
     * 委員長名２
     *
     * @return iinchoMei2 RString
     */
    public RString getIinchoMei2() {
        return iinchoMei2;
    }

    /**
     * 本文1
     *
     * @return honbun1 RString
     */
    public RString getHonbun1() {
        return honbun1;
    }

    /**
     * 本文2
     *
     * @return honbun2 RString
     */
    public RString getHonbun2() {
        return honbun2;
    }

    /**
     * 本文3
     *
     * @return honbun3 RString
     */
    public RString getHonbun3() {
        return honbun3;
    }

    /**
     * 本文4
     *
     * @return honbun4 RString
     */
    public RString getHonbun4() {
        return honbun4;
    }

    /**
     * 本文5
     *
     * @return honbun5 RString
     */
    public RString getHonbun5() {
        return honbun5;
    }

    /**
     * 本文６
     *
     * @return honbun6 RString
     */
    public RString getHonbun6() {
        return honbun6;
    }

    /**
     * 連絡先委員会名
     *
     * @return renrakusakiIinkaiMei RString
     */
    public RString getRenrakusakiIinkaiMei() {
        return renrakusakiIinkaiMei;
    }

    /**
     * 連絡先郵便番号
     *
     * @return renrakusakiYubinNo RString
     */
    public RString getRenrakusakiYubinNo() {
        return renrakusakiYubinNo;
    }

    /**
     * 連絡先住所1
     *
     * @return renrakusakiJusho1 RString
     */
    public RString getRenrakusakiJusho1() {
        return renrakusakiJusho1;
    }

    /**
     * 連絡先住所２
     *
     * @return renrakusakiJusho2 RString
     */
    public RString getRenrakusakiJusho2() {
        return renrakusakiJusho2;
    }

    /**
     * 連絡先タイトル1
     *
     * @return renrakusakiTitle1 RString
     */
    public RString getRenrakusakiTitle1() {
        return renrakusakiTitle1;
    }

    /**
     * 連絡先1
     *
     * @return renrakusaki1 RString
     */
    public RString getRenrakusaki1() {
        return renrakusaki1;
    }

    /**
     * 連絡先タイトル2
     *
     * @return renrakusakiTitle2 RString
     */
    public RString getRenrakusakiTitle2() {
        return renrakusakiTitle2;
    }

    /**
     * 連絡先1
     *
     * @return renrakusaki1 RString
     */
    public RString getRenrakusaki2() {
        return renrakusaki2;
    }

    /**
     * 連絡先タイトル３
     *
     * @return renrakusakiTitle3 RString
     */
    public RString getRenrakusakiTitle3() {
        return renrakusakiTitle3;
    }

    /**
     * 連絡先３
     *
     * @return renrakusaki3 RString
     */
    public RString getRenrakusaki3() {
        return renrakusaki3;
    }
}
