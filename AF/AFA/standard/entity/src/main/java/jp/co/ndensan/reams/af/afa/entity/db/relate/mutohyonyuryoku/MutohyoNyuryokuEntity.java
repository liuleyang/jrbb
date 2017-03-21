/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.mutohyonyuryoku;

import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 入力クラスです。
 *
 * @reamsid_L AF-0110-010 wangxt2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class MutohyoNyuryokuEntity {

    private ShohonNo shohonNo;
    private RString tohyokuCode;
    private int page;
    private int gyo;
    private SenkyoNo senkyoNo;
    private AfT112SenkyoninMeiboEntity senkyoninMeiboEntity;
    private UaFt200FindShikibetsuTaishoEntity atenaPSMEntity;
    private AfT100ShohonEntity shohonEntity;
    private AfT111SenkyoEntity senkyoEntity;
    private AfT113SenkyoShikakuEntity senkyoShikakuEntity;
    private AfT201TohyoJokyoEntity tohyoJokyoEntity;

}
