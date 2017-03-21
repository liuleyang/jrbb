/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.zaigaikofurirekidialog;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT122ZaigaiSenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT123ZaigaiSenkyoninJushoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT124ZaigaiSenkyoninShinseiEntity;

/**
 * 在外交付履歴RelateEntityクラスです。
 *
 * @reamsid_L AF-0320-014 xul
 */
@lombok.Getter
@lombok.Setter
public class ZaigaiKofuRirekiEntity implements Cloneable, Serializable {

    private AfT124ZaigaiSenkyoninShinseiEntity 在外選挙人申請情報;

    private AfT122ZaigaiSenkyoShikakuEntity 在外選挙資格;

    private AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報;

}
