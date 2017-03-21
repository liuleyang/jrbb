/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.tohyokekkaprint;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT502TohyojoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 *
 * 投票集計表帳票用Entity
 *
 * @reamsid_L AF-0290-020 lit
 */
@lombok.Getter
@lombok.Setter
public class TohyokekkaPrintEntity implements IDbAccessable, Serializable {

    private AfT100ShohonEntity 抄本Entity;
    private AfT111SenkyoEntity 選挙Entity;
    private AfT201TohyoJokyoEntity 投票状況Entity;
    private UaFt200FindShikibetsuTaishoEntity 宛名情報Entity;
    private AfT112SenkyoninMeiboEntity 選挙人名簿Entity;
    private AfT113SenkyoShikakuEntity 選挙資格Entity;
    private AfT502TohyojoEntity 投票所Entity;
}
