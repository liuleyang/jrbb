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
 * 記載事項変更通知（領事官）
 *
 * @reamsid_L AF-0330-031 zhangl
 */
public class KisaijikoHenkoTsuchiRyojikanParam {

    private final ZaigaiSenkyoninShinseiJohoEntity 在外選挙人申請情報;
    private final AfT122ZaigaiSenkyoShikakuEntity 在外選挙資格;
    private final ZaigaiSakuseiChohyo 画面帳票作成入力項目;
    private final GamenParam 画面パラメータ;

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
    private RString shuseiYmd;
    private RString shuseiRiyu1;
    private RString shuseiRiyu2;
    private RString shuseiRiyu3;
    private RString shuseiRiyu4;
    private RString shuseiRiyu5;
    private RString shuseiMaeShimei;
    private RString shuseiMaeShimei1;
    private RString shuseiMaeShimei2;

    /**
     * コンストラクタです。
     *
     * @param 在外選挙人申請情報 ZaigaiSenkyoninShinseiJohoEntity
     * @param 在外選挙資格 AfT122ZaigaiSenkyoShikakuEntity
     * @param 画面帳票作成入力項目 ZaigaiSakuseiChohyo
     * @param 画面パラメータ GamenParam
     */
    public KisaijikoHenkoTsuchiRyojikanParam(ZaigaiSenkyoninShinseiJohoEntity 在外選挙人申請情報, AfT122ZaigaiSenkyoShikakuEntity 在外選挙資格,
            ZaigaiSakuseiChohyo 画面帳票作成入力項目, GamenParam 画面パラメータ) {
        this.在外選挙人申請情報 = 在外選挙人申請情報;
        this.在外選挙資格 = 在外選挙資格;
        this.画面帳票作成入力項目 = 画面帳票作成入力項目;
        this.画面パラメータ = 画面パラメータ;
    }

    /**
     * 画面パラメータ
     *
     * @return 画面パラメータ GamenParam
     */
    public GamenParam get画面パラメータ() {
        return 画面パラメータ;
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
     * 修正年月日
     *
     * @param shuseiYmd RString
     */
    public void setShuseiYmd(RString shuseiYmd) {
        this.shuseiYmd = shuseiYmd;
    }

    /**
     * 修正理由1
     *
     * @param shuseiRiyu1 RString
     */
    public void setShuseiRiyu1(RString shuseiRiyu1) {
        this.shuseiRiyu1 = shuseiRiyu1;
    }

    /**
     * 修正理由2
     *
     * @param shuseiRiyu2 RString
     */
    public void setShuseiRiyu2(RString shuseiRiyu2) {
        this.shuseiRiyu2 = shuseiRiyu2;
    }

    /**
     * 修正理由3
     *
     * @param shuseiRiyu3 RString
     */
    public void setShuseiRiyu3(RString shuseiRiyu3) {
        this.shuseiRiyu3 = shuseiRiyu3;
    }

    /**
     * 修正理由4
     *
     * @param shuseiRiyu4 RString
     */
    public void setShuseiRiyu4(RString shuseiRiyu4) {
        this.shuseiRiyu4 = shuseiRiyu4;
    }

    /**
     * 修正理由５
     *
     * @param shuseiRiyu5 RString
     */
    public void setShuseiRiyu5(RString shuseiRiyu5) {
        this.shuseiRiyu5 = shuseiRiyu5;
    }

    /**
     * 修正前氏名
     *
     * @param shuseiMaeShimei RString
     */
    public void setShuseiMaeShimei(RString shuseiMaeShimei) {
        this.shuseiMaeShimei = shuseiMaeShimei;
    }

    /**
     * 修正前氏名1
     *
     * @return shuseiMaeShimei1 RString
     */
    public RString getShuseiMaeShimei1() {
        return shuseiMaeShimei1;
    }

    /**
     * 修正前氏名２
     *
     * @return shuseiMaeShimei2 RString
     */
    public RString getShuseiMaeShimei2() {
        return shuseiMaeShimei2;
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
     * 修正年月日
     *
     * @return shuseiYmd RString
     */
    public RString getShuseiYmd() {
        return shuseiYmd;
    }

    /**
     * 修正理由1
     *
     * @return shuseiRiyu1 RString
     */
    public RString getShuseiRiyu1() {
        return shuseiRiyu1;
    }

    /**
     * 修正理由2
     *
     * @return shuseiRiyu2 RString
     */
    public RString getShuseiRiyu2() {
        return shuseiRiyu2;
    }

    /**
     * 修正理由3
     *
     * @return shuseiRiyu3 RString
     */
    public RString getShuseiRiyu3() {
        return shuseiRiyu3;
    }

    /**
     * 修正理由4
     *
     * @return shuseiRiyu4 RString
     */
    public RString getShuseiRiyu4() {
        return shuseiRiyu4;
    }

    /**
     * 修正理由５
     *
     * @return shuseiRiyu5 RString
     */
    public RString getShuseiRiyu5() {
        return shuseiRiyu5;
    }

    /**
     * 修正前氏名
     *
     * @return shuseiMaeShimei RString
     */
    public RString getShuseiMaeShimei() {
        return shuseiMaeShimei;
    }

    /**
     * 修正前氏名1
     *
     * @param shuseiMaeShimei1 RString
     */
    public void setShuseiMaeShimei1(RString shuseiMaeShimei1) {
        this.shuseiMaeShimei1 = shuseiMaeShimei1;
    }

    /**
     * 修正前氏名２
     *
     * @param shuseiMaeShimei2 RString
     */
    public void setShuseiMaeShimei2(RString shuseiMaeShimei2) {
        this.shuseiMaeShimei2 = shuseiMaeShimei2;
    }

}
