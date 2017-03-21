/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT122ZaigaiSenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meibotorokuzaigai.ZaigaiSenkyoninShinseiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 抹消通知（領事官）
 *
 * @reamsid_L AF-0350-031 wangh
 */
public class MasshoTsuchiRyojikanParam {

    private final ZaigaiSenkyoninShinseiJohoEntity 在外選挙人申請情報;
    private final AfT122ZaigaiSenkyoShikakuEntity 在外選挙資格;
    private final ZaigaiSakuseiChohyo 画面帳票作成入力項目;

    private RString hakkoDaino;
    private RString hakkoYmd;
    private RString tsuchiSakiS;
    private RString tsuchiSakiL;
    private RString tsuchiMoto1;
    private RString tsuchiMoto2;
    private RString iinchoMei1;
    private RString iinchoMei2;
    private RString honbun1;
    private RString honbun2;
    private RString honbun3;
    private RString shimei;
    private RString shimei1;
    private RString shimei2;
    private RString seinengappi;
    private RString seibetsuM;
    private RString seibetsuF;
    private RString torokuYmd;
    private RString senkyoShurui;
    private RString masshoYmd;
    private RString masshoRiyu1;
    private RString masshoRiyu2;
    private RString masshoRiyu3;
    private RString masshoRiyu4;

    /**
     * コンストラクタです。
     *
     * @param 在外選挙人申請情報 ZaigaiSenkyoninShinseiJohoEntity
     * @param 在外選挙資格 AfT122ZaigaiSenkyoShikakuEntity
     * @param 画面帳票作成入力項目 ZaigaiSakuseiChohyo
     */
    public MasshoTsuchiRyojikanParam(ZaigaiSenkyoninShinseiJohoEntity 在外選挙人申請情報, AfT122ZaigaiSenkyoShikakuEntity 在外選挙資格,
            ZaigaiSakuseiChohyo 画面帳票作成入力項目) {
        this.在外選挙人申請情報 = 在外選挙人申請情報;
        this.在外選挙資格 = 在外選挙資格;
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
     * 在外選挙資格
     *
     * @return 在外選挙資格 AfT122ZaigaiSenkyoShikakuEntity
     */
    public AfT122ZaigaiSenkyoShikakuEntity get在外選挙資格() {
        return 在外選挙資格;
    }

    /**
     * 在外選挙人申請情報
     *
     * @return 在外選挙人申請情報 ZaigaiSenkyoninShinseiJohoEntity
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
     * 通知先市町村名1
     *
     * @param tsuchiSakiS RString
     */
    public void setTsuchiSakiS(RString tsuchiSakiS) {
        this.tsuchiSakiS = tsuchiSakiS;
    }

    /**
     * 通知先市町村名２
     *
     * @param tsuchiSakiL RString
     */
    public void setTsuchiSakiL(RString tsuchiSakiL) {
        this.tsuchiSakiL = tsuchiSakiL;
    }

    /**
     * 通知元市町村名1
     *
     * @param tsuchiMoto1 RString
     */
    public void setTsuchiMoto1(RString tsuchiMoto1) {
        this.tsuchiMoto1 = tsuchiMoto1;
    }

    /**
     * 通知元市町村名２
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
     * 本文３
     *
     * @param honbun3 RString
     */
    public void setHonbun3(RString honbun3) {
        this.honbun3 = honbun3;
    }

    /**
     * 氏名
     *
     * @param shimei RString
     */
    public void setShimei(RString shimei) {
        this.shimei = shimei;
    }

    /**
     * 氏名1
     *
     * @param shimei1 RString
     */
    public void setShimei1(RString shimei1) {
        this.shimei1 = shimei1;
    }

    /**
     * 氏名2
     *
     * @param shimei2 RString
     */
    public void setShimei2(RString shimei2) {
        this.shimei2 = shimei2;
    }

    /**
     * 生年月日
     *
     * @param seinengappi RString
     */
    public void setSeinengappi(RString seinengappi) {
        this.seinengappi = seinengappi;
    }

    /**
     * 性別1
     *
     * @param seibetsuM RString
     */
    public void setSeibetsuM(RString seibetsuM) {
        this.seibetsuM = seibetsuM;
    }

    /**
     * 性別２
     *
     * @param seibetsuF RString
     */
    public void setSeibetsuF(RString seibetsuF) {
        this.seibetsuF = seibetsuF;
    }

    /**
     * 登録年月日
     *
     * @param torokuYmd RString
     */
    public void setTorokuYmd(RString torokuYmd) {
        this.torokuYmd = torokuYmd;
    }

    /**
     * 選挙種類
     *
     * @param senkyoShurui RString
     */
    public void setSenkyoShurui(RString senkyoShurui) {
        this.senkyoShurui = senkyoShurui;
    }

    /**
     * 抹消年月日
     *
     * @param masshoYmd RString
     */
    public void setMasshoYmd(RString masshoYmd) {
        this.masshoYmd = masshoYmd;
    }

    /**
     * 抹消理由１
     *
     * @param masshoRiyu1 RString
     */
    public void setMasshoRiyu1(RString masshoRiyu1) {
        this.masshoRiyu1 = masshoRiyu1;
    }

    /**
     * 抹消理由２
     *
     * @param masshoRiyu2 RString
     */
    public void setMasshoRiyu2(RString masshoRiyu2) {
        this.masshoRiyu2 = masshoRiyu2;
    }

    /**
     * 抹消理由３
     *
     * @param masshoRiyu3 RString
     */
    public void setMasshoRiyu3(RString masshoRiyu3) {
        this.masshoRiyu3 = masshoRiyu3;
    }

    /**
     * 抹消理由４
     *
     * @param masshoRiyu4 RString
     */
    public void setMasshoRiyu4(RString masshoRiyu4) {
        this.masshoRiyu4 = masshoRiyu4;
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
     * 通知先市町村名1
     *
     * @return tsuchiSakiS RString
     */
    public RString getTsuchiSakiS() {
        return tsuchiSakiS;
    }

    /**
     * 通知先市町村名２
     *
     * @return tsuchiSakiL RString
     */
    public RString getTsuchiSakiL() {
        return tsuchiSakiL;
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
     * 本文３
     *
     * @return honbun3 RString
     */
    public RString getHonbun3() {
        return honbun3;
    }

    /**
     * 氏名
     *
     * @return shimei RString
     */
    public RString getShimei() {
        return shimei;
    }

    /**
     * 氏名1
     *
     * @return shimei1 RString
     */
    public RString getShimei1() {
        return shimei1;
    }

    /**
     * 氏名2
     *
     * @return shimei2 RString
     */
    public RString getShimei2() {
        return shimei2;
    }

    /**
     * 生年月日
     *
     * @return seinengappi RString
     */
    public RString getSeinengappi() {
        return seinengappi;
    }

    /**
     * 性別1
     *
     * @return seibetsuM RString
     */
    public RString getSeibetsuM() {
        return seibetsuM;
    }

    /**
     * 性別２
     *
     * @return seibetsuF RString
     */
    public RString getSeibetsuF() {
        return seibetsuF;
    }

    /**
     * 登録年月日
     *
     * @return torokuYmd RString
     */
    public RString getTorokuYmd() {
        return torokuYmd;
    }

    /**
     * 選挙種類
     *
     * @return senkyoShurui RString
     */
    public RString getSenkyoShurui() {
        return senkyoShurui;
    }

    /**
     * 抹消年月日
     *
     * @return masshoYmd RString
     */
    public RString getMasshoYmd() {
        return masshoYmd;
    }

    /**
     * 抹消理由１
     *
     * @return masshoRiyu1 RString
     */
    public RString getMasshoRiyu1() {
        return masshoRiyu1;
    }

    /**
     * 抹消理由２
     *
     * @return masshoRiyu2 RString
     */
    public RString getMasshoRiyu2() {
        return masshoRiyu2;
    }

    /**
     * 抹消理由３
     *
     * @return masshoRiyu3 RString
     */
    public RString getMasshoRiyu3() {
        return masshoRiyu3;
    }

    /**
     * 抹消理由４
     *
     * @return masshoRiyu4 RString
     */
    public RString getMasshoRiyu4() {
        return masshoRiyu4;
    }

}
