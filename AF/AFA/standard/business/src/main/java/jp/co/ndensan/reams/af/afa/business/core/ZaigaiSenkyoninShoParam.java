/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT122ZaigaiSenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT123ZaigaiSenkyoninJushoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT503SenkyokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meibotorokuzaigai.ZaigaiSenkyoninShinseiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在外選挙人証
 *
 * @reamsid_L AF-0320-030 lis2
 */
public class ZaigaiSenkyoninShoParam {

    private final AfT503SenkyokuEntity 選挙情報;
    private final ZaigaiSenkyoninShinseiJohoEntity 在外選挙人申請情報;
    private final AfT122ZaigaiSenkyoShikakuEntity 在外選挙資格;
    private final AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報_最終住所;
    private final AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報_海外送付先住所;
    private RString kofuNo;
    private RString shimei;
    private RString yukoKikanStart1;
    private RString seibetsu;
    private RString yukoKikanEnd;
    private RString senkyoMei;
    private RString jusho;
    private RString sofusaki;
    private RString shuruiTitle;
    private RString hakkoYmd;
    private RString shichosonMei;

    /**
     * コンストラクタです。
     *
     * @param 選挙情報 AfT503SenkyokuEntity
     * @param 在外選挙人申請情報 ZaigaiSenkyoninShinseiJohoEntity
     * @param 在外選挙資格 AfT122ZaigaiSenkyoShikakuEntity
     * @param 在外選挙人住所情報_最終住所 AfT123ZaigaiSenkyoninJushoEntity
     * @param 在外選挙人住所情報_海外送付先住所 AfT123ZaigaiSenkyoninJushoEntity
     */
    public ZaigaiSenkyoninShoParam(
            AfT503SenkyokuEntity 選挙情報,
            ZaigaiSenkyoninShinseiJohoEntity 在外選挙人申請情報,
            AfT122ZaigaiSenkyoShikakuEntity 在外選挙資格,
            AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報_最終住所,
            AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報_海外送付先住所) {
        this.選挙情報 = 選挙情報;
        this.在外選挙人申請情報 = 在外選挙人申請情報;
        this.在外選挙資格 = 在外選挙資格;
        this.在外選挙人住所情報_最終住所 = 在外選挙人住所情報_最終住所;
        this.在外選挙人住所情報_海外送付先住所 = 在外選挙人住所情報_海外送付先住所;
    }

    /**
     * 交付番号
     *
     * @param kofuNo RString
     */
    public void setKofuNo(RString kofuNo) {
        this.kofuNo = kofuNo;
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
     * @param yukoKikanStart1 RString
     */
    public void setYukoKikanStart1(RString yukoKikanStart1) {
        this.yukoKikanStart1 = yukoKikanStart1;
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
     * 登録
     *
     * @param yukoKikanEnd RString
     */
    public void setYukoKikanEnd(RString yukoKikanEnd) {
        this.yukoKikanEnd = yukoKikanEnd;
    }

    /**
     * 選挙名
     *
     * @param senkyoMei RString
     */
    public void setSenkyoMei(RString senkyoMei) {
        this.senkyoMei = senkyoMei;
    }

    /**
     * 住所
     *
     * @param jusho RString
     */
    public void setJusho(RString jusho) {
        this.jusho = jusho;
    }

    /**
     * 送付先
     *
     * @param sofusaki RString
     */
    public void setSofusaki(RString sofusaki) {
        this.sofusaki = sofusaki;
    }

    /**
     * 選挙種類
     *
     * @param shuruiTitle RString
     */
    public void setShuruiTitle(RString shuruiTitle) {
        this.shuruiTitle = shuruiTitle;
    }

    /**
     * 発行日
     *
     * @param hakkoYmd RString
     */
    public void setHakkoYmd(RString hakkoYmd) {
        this.hakkoYmd = hakkoYmd;
    }

    /**
     * 市区町村
     *
     * @param shichosonMei RString
     */
    public void setShichosonMei(RString shichosonMei) {
        this.shichosonMei = shichosonMei;
    }

    /**
     * 交付番号
     *
     * @return kofuNo RString
     */
    public RString getKofuNo() {
        return kofuNo;
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
     * @return yukoKikanStart1 RString
     */
    public RString getYukoKikanStart1() {
        return yukoKikanStart1;
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
     * 登録
     *
     * @return yukoKikanEnd RString
     */
    public RString getYukoKikanEnd() {
        return yukoKikanEnd;
    }

    /**
     * 選挙名
     *
     * @return senkyoMei RString
     */
    public RString getSenkyoMei() {
        return senkyoMei;
    }

    /**
     * 住所
     *
     * @return jusho RString
     */
    public RString getJusho() {
        return jusho;
    }

    /**
     * 送付先
     *
     * @return sofusaki RString
     */
    public RString getSofusaki() {
        return sofusaki;
    }

    /**
     * 選挙種類
     *
     * @return shuruiTitle RString
     */
    public RString getShuruiTitle() {
        return shuruiTitle;
    }

    /**
     * 発行日
     *
     * @return 発行日
     */
    public RString getHakkoYmd() {
        return hakkoYmd;
    }

    /**
     * 市区町村
     *
     * @return 市区町村
     */
    public RString getShichosonMei() {
        return shichosonMei;
    }

    /**
     * 選挙情報リスト
     *
     * @return 選挙情報リスト
     */
    public AfT503SenkyokuEntity get選挙情報() {
        return 選挙情報;
    }

    /**
     * 在外選挙人申請情報
     *
     * @return 在外選挙人申請情報
     */
    public ZaigaiSenkyoninShinseiJohoEntity get在外選挙人申請情報() {
        return 在外選挙人申請情報;
    }

    /**
     * 在外選挙資格
     *
     * @return 在外選挙資格
     */
    public AfT122ZaigaiSenkyoShikakuEntity get在外選挙資格() {
        return 在外選挙資格;
    }

    /**
     * 在外選挙人住所情報_最終住所
     *
     * @return 在外選挙人住所情報_最終住所
     */
    public AfT123ZaigaiSenkyoninJushoEntity get在外選挙人住所情報_最終住所() {
        return 在外選挙人住所情報_最終住所;
    }

    /**
     * 在外選挙人住所情報_海外送付先住所
     *
     * @return 在外選挙人住所情報_海外送付先住所
     */
    public AfT123ZaigaiSenkyoninJushoEntity get在外選挙人住所情報_海外送付先住所() {
        return 在外選挙人住所情報_海外送付先住所;
    }

}
