/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT122ZaigaiSenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT124ZaigaiSenkyoninShinseiEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 定時登録データEntityクラスです。
 *
 * @reamsid_L AF-0010-020 wangm
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TeijiTourokuDataUpdateZaigaiEntity {

    private AfT124ZaigaiSenkyoninShinseiEntity zaigaiSenkyoninShinseiEntity;
    private AfT122ZaigaiSenkyoShikakuEntity zaigaiSenkyoShikakuEntity;

}
