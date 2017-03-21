/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.meibotorokuzaigai;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT122ZaigaiSenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT123ZaigaiSenkyoninJushoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT503SenkyokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meibotorokuzaigai.ZaigaiSenkyoninShinseiJohoEntity;

/**
 * 在外選挙異動累積情報のBusiness
 *
 * @reamsid_L AF-0320-020 zhanggs
 */
public class ZaigaiSenkyoninJohoResult {

    private final ZaigaiSenkyoninShinseiJohoEntity 在外選挙人申請情報;
    private final AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報_本籍;
    private final AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報_最終住所;
    private final AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報_国内転入先住所;
    private final AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報_海外住所;
    private final AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報_海外送付先住所;
    private final AfT122ZaigaiSenkyoShikakuEntity 在外選挙資格;
    private final AfT503SenkyokuEntity 選挙情報;

    /**
     * コンストラクタです。<br/>
     *
     * @param 在外選挙人申請情報 ZaigaiSenkyoninShinseiJohoEntity
     * @param 在外選挙人住所情報_最終住所 AfT123ZaigaiSenkyoninJushoEntity
     * @param 在外選挙人住所情報_国内転入先住所 AfT123ZaigaiSenkyoninJushoEntity
     * @param 在外選挙人住所情報_海外住所 AfT123ZaigaiSenkyoninJushoEntity
     * @param 在外選挙人住所情報_本籍 AfT123ZaigaiSenkyoninJushoEntity
     * @param 在外選挙人住所情報_海外送付先住所 AfT123ZaigaiSenkyoninJushoEntity
     * @param 在外選挙資格 AfT122ZaigaiSenkyoShikakuEntity
     * @param 選挙情報 RString
     */
    public ZaigaiSenkyoninJohoResult(
            ZaigaiSenkyoninShinseiJohoEntity 在外選挙人申請情報,
            AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報_本籍,
            AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報_最終住所,
            AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報_国内転入先住所,
            AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報_海外住所,
            AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報_海外送付先住所,
            AfT122ZaigaiSenkyoShikakuEntity 在外選挙資格,
            AfT503SenkyokuEntity 選挙情報) {
        this.在外選挙人申請情報 = 在外選挙人申請情報;
        this.在外選挙人住所情報_本籍 = 在外選挙人住所情報_本籍;
        this.在外選挙人住所情報_最終住所 = 在外選挙人住所情報_最終住所;
        this.在外選挙人住所情報_国内転入先住所 = 在外選挙人住所情報_国内転入先住所;
        this.在外選挙人住所情報_海外住所 = 在外選挙人住所情報_海外住所;
        this.在外選挙人住所情報_海外送付先住所 = 在外選挙人住所情報_海外送付先住所;
        this.在外選挙資格 = 在外選挙資格;
        this.選挙情報 = 選挙情報;
    }

    /**
     * 在外選挙人申請情報を返します。
     *
     * @return 在外選挙人申請情報
     */
    public ZaigaiSenkyoninShinseiJohoEntity get在外選挙人申請情報() {
        return 在外選挙人申請情報;
    }

    /**
     * 在外選挙人住所情報_本籍を返します。
     *
     * @return 在外選挙人住所情報_本籍
     */
    public AfT123ZaigaiSenkyoninJushoEntity get在外選挙人住所情報_本籍() {
        return 在外選挙人住所情報_本籍;
    }

    /**
     * 在外選挙人住所情報_最終住所を返します。
     *
     * @return 在外選挙人住所情報_最終住所
     */
    public AfT123ZaigaiSenkyoninJushoEntity get在外選挙人住所情報_最終住所() {
        return 在外選挙人住所情報_最終住所;
    }

    /**
     * 在外選挙人住所情報_国内転入先住所を返します。
     *
     * @return 在外選挙人住所情報_国内転入先住所
     */
    public AfT123ZaigaiSenkyoninJushoEntity get在外選挙人住所情報_国内転入先住所() {
        return 在外選挙人住所情報_国内転入先住所;
    }

    /**
     * 在外選挙人住所情報_海外住所を返します。
     *
     * @return 在外選挙人住所情報_海外住所
     */
    public AfT123ZaigaiSenkyoninJushoEntity get在外選挙人住所情報_海外住所() {
        return 在外選挙人住所情報_海外住所;
    }

    /**
     * 在外選挙人住所情報_海外送付先住所を返します。
     *
     * @return 在外選挙人住所情報_海外送付先住所
     */
    public AfT123ZaigaiSenkyoninJushoEntity get在外選挙人住所情報_海外送付先住所() {
        return 在外選挙人住所情報_海外送付先住所;
    }

    /**
     * 在外選挙資格を返します。
     *
     * @return 在外選挙資格
     */
    public AfT122ZaigaiSenkyoShikakuEntity get在外選挙資格() {
        return 在外選挙資格;
    }

    /**
     * 選挙情報を返します。
     *
     * @return 選挙情報
     */
    public AfT503SenkyokuEntity get選挙情報() {
        return 選挙情報;
    }

}
