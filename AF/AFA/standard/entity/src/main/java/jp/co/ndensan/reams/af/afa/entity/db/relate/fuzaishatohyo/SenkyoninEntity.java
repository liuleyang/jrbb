/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.fuzaishatohyo;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 *
 * 選挙人Entity
 *
 * @reamsid_L AF-0080-010 lit
 */
@lombok.Getter
@lombok.Setter
public class SenkyoninEntity {

    private boolean 実データフラグ;
    private UaFt200FindShikibetsuTaishoEntity 宛名情報Entity;
    private AfT100ShohonEntity 抄本Entity;
    private AfT111SenkyoEntity 選挙Entity;
    private AfT112SenkyoninMeiboEntity 選挙人名簿Entity;
    private AfT113SenkyoShikakuEntity 選挙資格Entity;

}
