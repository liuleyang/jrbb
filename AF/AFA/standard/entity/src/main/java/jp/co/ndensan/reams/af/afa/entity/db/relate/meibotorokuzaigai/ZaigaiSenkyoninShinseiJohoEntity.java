/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.meibotorokuzaigai;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT124ZaigaiSenkyoninShinseiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT510RyojikanEntity;

/**
 * 在外選挙人申請情報RelateEntityクラスです。
 *
 * @reamsid_L AF-0320-020 zhanggs
 */
@lombok.Getter
@lombok.Setter
public class ZaigaiSenkyoninShinseiJohoEntity implements Cloneable, Serializable {

    private AfT510RyojikanEntity 領事官;
    private AfT124ZaigaiSenkyoninShinseiEntity 申請情報;
}
