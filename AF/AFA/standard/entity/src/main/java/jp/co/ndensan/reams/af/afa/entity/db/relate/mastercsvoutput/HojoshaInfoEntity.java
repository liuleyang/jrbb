/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.mastercsvoutput;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT502TohyojoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT508HojoshaEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 *
 * 補助者情報Entity
 *
 * @reamsid_L AF-0670-010 lis
 */
@lombok.Getter
@lombok.Setter
public class HojoshaInfoEntity implements IDbAccessable, Serializable {

    private AfT100ShohonEntity 抄本Entity;
    private AfT508HojoshaEntity 補助者Entity;
    private AfT502TohyojoEntity 投票所Entity;
    private UaFt200FindShikibetsuTaishoEntity 宛名PSMEntity;
}
