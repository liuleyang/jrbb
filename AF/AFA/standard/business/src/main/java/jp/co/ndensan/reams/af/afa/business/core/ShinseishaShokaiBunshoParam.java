/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT122ZaigaiSenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT123ZaigaiSenkyoninJushoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meibotorokuzaigai.ZaigaiSenkyoninShinseiJohoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請者の被登録資格の照会文書
 *
 * @reamsid_L AF-0320-031 lis2
 */
public class ShinseishaShokaiBunshoParam {

    private final ZaigaiSenkyoninShinseiJohoEntity 在外選挙人申請情報;
    private final AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報_本籍;
    private final AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報_最終住所;
    private final AfT122ZaigaiSenkyoShikakuEntity 在外選挙資格;
    private final ZaigaiSakuseiChohyo 画面帳票作成入力項目;

    private RString yubinNo;
    private RString hakkoDaino;
    private RString hakkoYmd;
    private RString shokaiSaki;
    private RString shokaiSakiL;
    private RString shokaiMoto2;
    private RString shokaiMoto1;
    private RString iinchoMei1;
    private RString iinchoMei2;
    private RString senkyoShurui;
    private RString cityKubun;
    private RString shimei1;
    private RString shimei2;
    private RString shimei3;
    private RString seinengappi;
    private RString seibetsu;
    private RString sakuseiYmd;
    private RString honsekiU;
    private RString honsekiD;
    private RString honsekiTorokuKubunHon;
    private RString honsekiTorokuKubunEnd;
    private RString endJusho1;
    private RString endJusho2;
    private RString endJusho3;
    private RString gengo;
    private RString kaitoSakiLu;
    private RString kaitoSakiLd;
    private RString kaitoSakiRd;

    private Association 地方公共団体;

    /**
     * コンストラクタです。
     *
     * @param 在外選挙人申請情報 ZaigaiSenkyoninShinseiJohoEntity
     * @param 在外選挙人住所情報_本籍 AfT123ZaigaiSenkyoninJushoEntity
     * @param 在外選挙人住所情報_最終住所 AfT123ZaigaiSenkyoninJushoEntity
     * @param 在外選挙資格 AfT122ZaigaiSenkyoShikakuEntity
     * @param 画面帳票作成入力項目 ZaigaiSakuseiChohyo
     */
    public ShinseishaShokaiBunshoParam(
            ZaigaiSenkyoninShinseiJohoEntity 在外選挙人申請情報,
            AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報_本籍,
            AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報_最終住所,
            AfT122ZaigaiSenkyoShikakuEntity 在外選挙資格,
            ZaigaiSakuseiChohyo 画面帳票作成入力項目) {
        this.在外選挙人申請情報 = 在外選挙人申請情報;
        this.在外選挙人住所情報_本籍 = 在外選挙人住所情報_本籍;
        this.在外選挙人住所情報_最終住所 = 在外選挙人住所情報_最終住所;
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
     * 在外選挙人申請情報
     *
     * @return 在外選挙人申請情報 ZaigaiSenkyoninShinseiJohoEntity
     */
    public ZaigaiSenkyoninShinseiJohoEntity get在外選挙人申請情報() {
        return 在外選挙人申請情報;
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
     * 在外選挙人住所情報_最終住所
     *
     * @return 在外選挙人住所情報_最終住所 AfT123ZaigaiSenkyoninJushoEntity
     */
    public AfT123ZaigaiSenkyoninJushoEntity get在外選挙人住所情報_最終住所() {
        return 在外選挙人住所情報_最終住所;
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
     * @param shokaiSaki RString
     */
    public void setShokaiSaki(RString shokaiSaki) {
        this.shokaiSaki = shokaiSaki;
    }

    /**
     * 通知先市町村２
     *
     * @param shokaiSakiL RString
     */
    public void setShokaiSakiL(RString shokaiSakiL) {
        this.shokaiSakiL = shokaiSakiL;
    }

    /**
     * 照会元市町村名２
     *
     * @param shokaiMoto2 RString
     */
    public void setShokaiMoto2(RString shokaiMoto2) {
        this.shokaiMoto2 = shokaiMoto2;
    }

    /**
     * 照会元市町村名１
     *
     * @param shokaiMoto1 RString
     */
    public void setShokaiMoto1(RString shokaiMoto1) {
        this.shokaiMoto1 = shokaiMoto1;
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
     * 選挙種類
     *
     * @param senkyoShurui RString
     */
    public void setSenkyoShurui(RString senkyoShurui) {
        this.senkyoShurui = senkyoShurui;
    }

    /**
     * 市区町村区分
     *
     * @param cityKubun RString
     */
    public void setCityKubun(RString cityKubun) {
        this.cityKubun = cityKubun;
    }

    /**
     * 氏名
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
     * 氏名１
     *
     * @param shimei3 RString
     */
    public void setShimei3(RString shimei3) {
        this.shimei3 = shimei3;
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
     * 性別
     *
     * @param seibetsu RString
     */
    public void setSeibetsu(RString seibetsu) {
        this.seibetsu = seibetsu;
    }

    /**
     * 作成年月日
     *
     * @param sakuseiYmd RString
     */
    public void setSakuseiYmd(RString sakuseiYmd) {
        this.sakuseiYmd = sakuseiYmd;
    }

    /**
     * 本籍１
     *
     * @param honsekiU RString
     */
    public void setHonsekiU(RString honsekiU) {
        this.honsekiU = honsekiU;
    }

    /**
     * 本籍２
     *
     * @param honsekiD RString
     */
    public void setHonsekiD(RString honsekiD) {
        this.honsekiD = honsekiD;
    }

    /**
     * 本籍登録区分１
     *
     * @param honsekiTorokuKubunHon RString
     */
    public void setHonsekiTorokuKubunHon(RString honsekiTorokuKubunHon) {
        this.honsekiTorokuKubunHon = honsekiTorokuKubunHon;
    }

    /**
     * 本籍登録区分２
     *
     * @param honsekiTorokuKubunEnd RString
     */
    public void setHonsekiTorokuKubunEnd(RString honsekiTorokuKubunEnd) {
        this.honsekiTorokuKubunEnd = honsekiTorokuKubunEnd;
    }

    /**
     * 最終住所１
     *
     * @param endJusho1 RString
     */
    public void setEndJusho1(RString endJusho1) {
        this.endJusho1 = endJusho1;
    }

    /**
     * 最終住所２
     *
     * @param endJusho2 RString
     */
    public void setEndJusho2(RString endJusho2) {
        this.endJusho2 = endJusho2;
    }

    /**
     * 最終住所３
     *
     * @param endJusho3 RString
     */
    public void setEndJusho3(RString endJusho3) {
        this.endJusho3 = endJusho3;
    }

    /**
     * 元号
     *
     * @param gengo RString
     */
    public void setGengo(RString gengo) {
        this.gengo = gengo;
    }

    /**
     * 回答先市町村名１
     *
     * @param kaitoSakiLu RString
     */
    public void setKaitoSakiLu(RString kaitoSakiLu) {
        this.kaitoSakiLu = kaitoSakiLu;
    }

    /**
     * 回答先市町村名２
     *
     * @param kaitoSakiLd RString
     */
    public void setKaitoSakiLd(RString kaitoSakiLd) {
        this.kaitoSakiLd = kaitoSakiLd;
    }

    /**
     * 回答先市町村名３
     *
     * @param kaitoSakiRd RString
     */
    public void setKaitoSakiRd(RString kaitoSakiRd) {
        this.kaitoSakiRd = kaitoSakiRd;
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
     * 通知先市町村１
     *
     * @return shokaiSaki RString
     */
    public RString getShokaiSaki() {
        return shokaiSaki;
    }

    /**
     * 通知先市町村２
     *
     * @return shokaiSakiL RString
     */
    public RString getShokaiSakiL() {
        return shokaiSakiL;
    }

    /**
     * 照会元市町村名２
     *
     * @return shokaiMoto2 RString
     */
    public RString getShokaiMoto2() {
        return shokaiMoto2;
    }

    /**
     * 照会元市町村名１
     *
     * @return shokaiMoto1 RString
     */
    public RString getShokaiMoto1() {
        return shokaiMoto1;
    }

    /**
     * 委員長名１
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
     * 選挙種類
     *
     * @return senkyoShurui RString
     */
    public RString getSenkyoShurui() {
        return senkyoShurui;
    }

    /**
     * 市区町村区分
     *
     * @return cityKubun RString
     */
    public RString getCityKubun() {
        return cityKubun;
    }

    /**
     * 氏名
     *
     * @return shimei1 RString
     */
    public RString getShimei1() {
        return shimei1;
    }

    /**
     * 氏名２
     *
     * @return shimei2 RString
     */
    public RString getShimei2() {
        return shimei2;
    }

    /**
     * 氏名１
     *
     * @return shimei3 RString
     */
    public RString getShimei3() {
        return shimei3;
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
     * 性別
     *
     * @return seibetsu RString
     */
    public RString getSeibetsu() {
        return seibetsu;
    }

    /**
     * 作成年月日
     *
     * @return sakuseiYmd RString
     */
    public RString getSakuseiYmd() {
        return sakuseiYmd;
    }

    /**
     * 本籍１
     *
     * @return honsekiU RString
     */
    public RString getHonsekiU() {
        return honsekiU;
    }

    /**
     * 本籍２
     *
     * @return honsekiD RString
     */
    public RString getHonsekiD() {
        return honsekiD;
    }

    /**
     * 本籍登録区分１
     *
     * @return honsekiTorokuKubunHon RString
     */
    public RString getHonsekiTorokuKubunHon() {
        return honsekiTorokuKubunHon;
    }

    /**
     * 本籍登録区分２
     *
     * @return honsekiTorokuKubunEnd RString
     */
    public RString getHonsekiTorokuKubunEnd() {
        return honsekiTorokuKubunEnd;
    }

    /**
     * 最終住所１
     *
     * @return endJusho1 RString
     */
    public RString getEndJusho1() {
        return endJusho1;
    }

    /**
     * 最終住所２
     *
     * @return endJusho2 RString
     */
    public RString getEndJusho2() {
        return endJusho2;
    }

    /**
     * 最終住所３
     *
     * @return endJusho3 RString
     */
    public RString getEndJusho3() {
        return endJusho3;
    }

    /**
     * 元号
     *
     * @return gengo RString
     */
    public RString getGengo() {
        return gengo;
    }

    /**
     * 回答先市町村名1
     *
     * @return kaitoSakiLu RString
     */
    public RString getKaitoSakiLu() {
        return kaitoSakiLu;
    }

    /**
     * 回答先市町村名2
     *
     * @return kaitoSakiLd RString
     */
    public RString getKaitoSakiLd() {
        return kaitoSakiLd;
    }

    /**
     * 回答先市町村名３
     *
     * @return kaitoSakiRd RString
     */
    public RString getKaitoSakiRd() {
        return kaitoSakiRd;
    }

    /**
     * 地方公共団体
     *
     * @return 地方公共団体 Association
     */
    public Association get地方公共団体() {
        return 地方公共団体;
    }

    /**
     * 地方公共団体
     *
     * @param 地方公共団体 Association
     */
    public void set地方公共団体(Association 地方公共団体) {
        this.地方公共団体 = 地方公共団体;
    }

}
