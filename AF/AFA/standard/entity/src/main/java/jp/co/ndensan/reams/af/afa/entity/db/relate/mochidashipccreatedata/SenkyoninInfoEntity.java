/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipccreatedata;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT133KaikuSenkyoFuzuiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT504TohyokuRelationEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT509KumiaiEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.cautionsha.UaFt400FindeCautionShaMapperEntity;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 *
 * 選挙人情報Entity
 *
 * @reamsid_L AF-0790-020 wanghj
 */
@lombok.Getter
@lombok.Setter
public class SenkyoninInfoEntity implements IDbAccessable, Serializable {

    private AfT100ShohonEntity 抄本Entity;
    private AfT111SenkyoEntity 選挙Entity;
    private AfT112SenkyoninMeiboEntity 選挙人名簿Entity;
    private AfT113SenkyoShikakuEntity 選挙資格Entity;
    private AfT114FuzaishaTohyoShikakuEntity 不在者投票資格Entity;
    private AfT133KaikuSenkyoFuzuiEntity 海区付随情報Entity;
    private AfT201TohyoJokyoEntity 投票状況Entity;
    private AfT504TohyokuRelationEntity 投票区投票所対応Entity;
    private AfT509KumiaiEntity 組合マスタEntity;
    private UaFt400FindeCautionShaMapperEntity findeCautionShaMapperEntity;
    private UaFt200FindShikibetsuTaishoEntity 宛名PSMEntity;
}
