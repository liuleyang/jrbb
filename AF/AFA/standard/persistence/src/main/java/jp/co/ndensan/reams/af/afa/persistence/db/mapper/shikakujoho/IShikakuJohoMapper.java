/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.shikakujoho;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT122ZaigaiSenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.shikakujoho.ShikakuJohoEntity;

/**
 * 資格情報共有子DIVクラスです。
 *
 * @reamsid_L AF-0180-015 lis2
 */
public interface IShikakuJohoMapper {

    /**
     * 選挙資格を取得します。
     *
     * @param shikakuJohoEntity ShikakuJohoEntity
     * @return 選挙資格 AfT113SenkyoShikakuEntity
     */
    AfT113SenkyoShikakuEntity selectSenkyoShikaku(ShikakuJohoEntity shikakuJohoEntity);

    /**
     * 在外選挙資格を取得します。
     *
     * @param shikakuJohoEntity ShikakuJohoEntity
     * @return 在外選挙資格 AfT122ZaigaiSenkyoShikakuEntity
     */
    AfT122ZaigaiSenkyoShikakuEntity selectZaigaiSenkyoShikaku(ShikakuJohoEntity shikakuJohoEntity);

}
