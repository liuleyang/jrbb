/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipccreatedata;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 *
 * 抄本対象Entity
 *
 * @reamsid_L AF-0790-020 wanghj
 */
@lombok.Getter
@lombok.Setter
public class ShohonInfoEntity implements IDbAccessable, Serializable {

    private AfT100ShohonEntity 抄本Entity;
    private AfT111SenkyoEntity 選挙Entity;
}
