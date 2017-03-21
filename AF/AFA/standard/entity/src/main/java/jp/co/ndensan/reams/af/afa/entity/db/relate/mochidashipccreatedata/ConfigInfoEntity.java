/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipccreatedata;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 *
 * コンフィグ情報Entity
 *
 * @reamsid_L AF-0790-020 wanghj
 */
@lombok.Getter
@lombok.Setter
public class ConfigInfoEntity implements IDbAccessable, Serializable {

    private UzT0001StandardConfigEntity uzT0001Entity;
    private UzT0002CustomConfigEntity uzT0002Entity;

}
