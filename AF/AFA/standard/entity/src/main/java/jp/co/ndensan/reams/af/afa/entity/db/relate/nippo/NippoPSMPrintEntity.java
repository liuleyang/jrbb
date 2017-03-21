/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.nippo;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT507ShisetsuEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.chiku.tohyoku.UrT0159TohyokuEntity;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 *
 * 日報PSM関連帳票用Entity
 *
 * @reamsid_L AF-0270-020 xul
 */
@lombok.Getter
@lombok.Setter
public class NippoPSMPrintEntity implements IDbAccessable, Serializable {

    private AfT507ShisetsuEntity 施設Entity;
    private AfT100ShohonEntity 抄本Entity;
    private AfT111SenkyoEntity 選挙Entity;
    private AfT112SenkyoninMeiboEntity 選挙人名簿Entity;
    private AfT113SenkyoShikakuEntity 選挙資格Entity;
    private AfT201TohyoJokyoEntity 投票状況Entity;
    private UaFt200FindShikibetsuTaishoEntity 宛名PSMEntity;
    private AfT501TohyokuEntity afT501;
    private UrT0159TohyokuEntity urV0159;
}
