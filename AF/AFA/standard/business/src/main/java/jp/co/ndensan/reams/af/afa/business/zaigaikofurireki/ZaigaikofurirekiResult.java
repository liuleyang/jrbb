/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.zaigaikofurireki;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT122ZaigaiSenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT123ZaigaiSenkyoninJushoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT124ZaigaiSenkyoninShinseiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.zaigaikofurirekidialog.ZaigaiKofuRirekiEntity;

/**
 * 在外交付履歴Resultクラス
 *
 * @reamsid_L AF-0320-014 xul
 */
public class ZaigaikofurirekiResult implements Serializable {

    private final AfT124ZaigaiSenkyoninShinseiEntity 在外選挙人申請情報;
    private final AfT122ZaigaiSenkyoShikakuEntity 在外選挙資格;
    private final AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報;

    /**
     * コンストラクタです。
     *
     * @param entity ZaigaiKofuRirekiEntity
     */
    public ZaigaikofurirekiResult(ZaigaiKofuRirekiEntity entity) {
        this.在外選挙人申請情報 = entity.get在外選挙人申請情報();
        this.在外選挙資格 = entity.get在外選挙資格();
        this.在外選挙人住所情報 = entity.get在外選挙人住所情報();
    }

    /**
     * コンストラクタです。
     *
     * @param 在外選挙人申請情報 AfT124ZaigaiSenkyoninShinseiEntity
     * @param 在外選挙資格 AfT122ZaigaiSenkyoShikakuEntity
     * @param 在外選挙人住所情報 AfT123ZaigaiSenkyoninJushoEntity
     */
    public ZaigaikofurirekiResult(
            AfT124ZaigaiSenkyoninShinseiEntity 在外選挙人申請情報,
            AfT122ZaigaiSenkyoShikakuEntity 在外選挙資格,
            AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報) {
        this.在外選挙人申請情報 = 在外選挙人申請情報;
        this.在外選挙資格 = 在外選挙資格;
        this.在外選挙人住所情報 = 在外選挙人住所情報;
    }

    /**
     * 在外選挙人申請情報
     *
     * @return 在外選挙人申請情報
     */
    public AfT124ZaigaiSenkyoninShinseiEntity get在外選挙人申請情報() {
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
    public AfT123ZaigaiSenkyoninJushoEntity get在外選挙人住所情報() {
        return 在外選挙人住所情報;
    }
}
