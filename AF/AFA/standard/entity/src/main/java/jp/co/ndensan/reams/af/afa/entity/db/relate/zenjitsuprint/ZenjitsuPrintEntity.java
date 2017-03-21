/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.zenjitsuprint;

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
 * 投票日前日関連帳票用Entity
 *
 * @reamsid_L AF-0280-020 lit
 */
@lombok.Getter
@lombok.Setter
public class ZenjitsuPrintEntity implements IDbAccessable, Serializable {

    private AfT100ShohonEntity 抄本Entity;
    private AfT111SenkyoEntity 選挙Entity;
    private AfT112SenkyoninMeiboEntity 選挙人名簿Entity;
    private AfT113SenkyoShikakuEntity 選挙資格Entity;
    private AfT201TohyoJokyoEntity 投票状況Entity;
    private AfT507ShisetsuEntity 施設Entity;
    private UaFt200FindShikibetsuTaishoEntity 宛名情報Entity;
    private AfT501TohyokuEntity 投票区Entity;
    private UrT0159TohyokuEntity 投票区UrEntity;
}
