/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT122ZaigaiSenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT123ZaigaiSenkyoninJushoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meibotorokuzaigai.ZaigaiSenkyoninShinseiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 登録した旨の通知
 *
 * @reamsid_L AF-0320-032 lis2
 */
public class TorokuTsuchiParam {

    private final AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報_本籍;
    private final ZaigaiSenkyoninShinseiJohoEntity 在外選挙人申請情報;
    private final AfT122ZaigaiSenkyoShikakuEntity 在外選挙資格;
    private final ZaigaiSakuseiChohyo 画面帳票作成入力項目;

    private RString yubinNo;
    private RString hakkoDaino;
    private RString hakkoYmd;
    private RString tsuchiSaki;
    private RString tsuchiSakiL;
    private RString tsuchiMoto1;
    private RString tsuchiMoto2;
    private RString iinchoMei1;
    private RString iinchoMei2;
    private RString honbun1;
    private RString honbun2;
    private RString shimei1;
    private RString shimei2;
    private RString shimei3;
    private RString shimei4;
    private RString shimei;
    private RString seinengappi;
    private RString seibetsuM;
    private RString seibetsuF;
    private RString torokuYmd;
    private RString honseki1;
    private RString honseki2;
    private RString honseki3;
    private RString honseki4;

    /**
     * コンストラクタです。
     *
     * @param 在外選挙人住所情報_本籍 AfT123ZaigaiSenkyoninJushoEntity
     * @param 在外選挙人申請情報 ZaigaiSenkyoninShinseiJohoEntity
     * @param 在外選挙資格 AfT122ZaigaiSenkyoShikakuEntity
     * @param 画面帳票作成入力項目 ZaigaiSakuseiChohyo
     */
    public TorokuTsuchiParam(
            AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報_本籍,
            ZaigaiSenkyoninShinseiJohoEntity 在外選挙人申請情報,
            AfT122ZaigaiSenkyoShikakuEntity 在外選挙資格,
            ZaigaiSakuseiChohyo 画面帳票作成入力項目) {
        this.在外選挙人住所情報_本籍 = 在外選挙人住所情報_本籍;
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
     * 在外選挙人住所情報_本籍
     *
     * @return 在外選挙人住所情報_本籍 AfT123ZaigaiSenkyoninJushoEntity
     */
    public AfT123ZaigaiSenkyoninJushoEntity get在外選挙人住所情報_本籍() {
        return 在外選挙人住所情報_本籍;
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
     * 郵便番号
     *
     * @return yubinNo RString
     */
    public RString getYubinNo() {
        return yubinNo;
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
     * 通知先市町村1
     *
     * @return tsuchiSaki RString
     */
    public RString getTsuchiSaki() {
        return tsuchiSaki;
    }

    /**
     * 通知先市町村２
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
     * 本文２
     *
     * @return honbun2 RString
     */
    public RString getHonbun2() {
        return honbun2;
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
     * 氏名3
     *
     * @return shimei3 RString
     */
    public RString getShimei3() {
        return shimei3;
    }

    /**
     * 氏名４
     *
     * @return shimei4 RString
     */
    public RString getShimei4() {
        return shimei4;
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
     * 生年月日
     *
     * @return seinengappi RString
     */
    public RString getSeinengappi() {
        return seinengappi;
    }

    /**
     * 性別１
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
     * 本籍１
     *
     * @return honseki1 RString
     */
    public RString getHonseki1() {
        return honseki1;
    }

    /**
     * 本籍２
     *
     * @return honseki2 RString
     */
    public RString getHonseki2() {
        return honseki2;
    }

    /**
     * 本籍３
     *
     * @return honseki3 RString
     */
    public RString getHonseki3() {
        return honseki3;
    }

    /**
     * 本籍４
     *
     * @return honseki4 RString
     */
    public RString getHonseki4() {
        return honseki4;
    }

    /**
     * 郵便番号
     *
     * @param yubinNo RString
     */
    public void setYubinNo(RString yubinNo) {
        this.yubinNo = yubinNo;
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
     * 通知先市町村１
     *
     * @param tsuchiSaki RString
     */
    public void setTsuchiSaki(RString tsuchiSaki) {
        this.tsuchiSaki = tsuchiSaki;
    }

    /**
     * 通知先市町村２
     *
     * @param tsuchiSakiL RString
     */
    public void setTsuchiSakiL(RString tsuchiSakiL) {
        this.tsuchiSakiL = tsuchiSakiL;
    }

    /**
     * 通知元市町村名１
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
     * 委員長名１
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
     * 本文１
     *
     * @param honbun1 RString
     */
    public void setHonbun1(RString honbun1) {
        this.honbun1 = honbun1;
    }

    /**
     * 本文２
     *
     * @param honbun2 RString
     */
    public void setHonbun2(RString honbun2) {
        this.honbun2 = honbun2;
    }

    /**
     * 氏名１
     *
     * @param shimei1 RString
     */
    public void setShimei1(RString shimei1) {
        this.shimei1 = shimei1;
    }

    /**
     * 氏名２
     *
     * @param shimei2 RString
     */
    public void setShimei2(RString shimei2) {
        this.shimei2 = shimei2;
    }

    /**
     * 氏名３
     *
     * @param shimei3 RString
     */
    public void setShimei3(RString shimei3) {
        this.shimei3 = shimei3;
    }

    /**
     * 氏名４
     *
     * @param shimei4 RString
     */
    public void setShimei4(RString shimei4) {
        this.shimei4 = shimei4;
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
     * 生年月日
     *
     * @param seinengappi RString
     */
    public void setSeinengappi(RString seinengappi) {
        this.seinengappi = seinengappi;
    }

    /**
     * 性別１
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
     * 本籍１
     *
     * @param honseki1 RString
     */
    public void setHonseki1(RString honseki1) {
        this.honseki1 = honseki1;
    }

    /**
     * 本籍２
     *
     * @param honseki2 RString
     */
    public void setHonseki2(RString honseki2) {
        this.honseki2 = honseki2;
    }

    /**
     * 本籍３
     *
     * @param honseki3 RString
     */
    public void setHonseki3(RString honseki3) {
        this.honseki3 = honseki3;
    }

    /**
     * 本籍４
     *
     * @param honseki4 RString
     */
    public void setHonseki4(RString honseki4) {
        this.honseki4 = honseki4;
    }

}
