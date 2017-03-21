/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.meibosakuseikaiku;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT131KaikuSenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT133KaikuSenkyoFuzuiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 海区漁業調整委員会委員選挙人名簿作成
 *
 * @reamsid_L AF-0460-020 wanghj
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class MeiboSakuseiKaikuEntity {

    private UaFt200FindShikibetsuTaishoEntity uaFt200Entity;

    private AfT113SenkyoShikakuEntity afT113Entity;

    private AfT100ShohonEntity afT100Entity;

    private AfT111SenkyoEntity afT111SenkyoEntity;

    private AfT112SenkyoninMeiboEntity afT112SenkyoninMeibEntity;

    private AfT131KaikuSenkyoEntity afT131KaikuSenkyo;

    private AfT133KaikuSenkyoFuzuiEntity afT133KaikuSenkyoFuzui;

    private AfT501TohyokuEntity afT501TohyokuEntity;

    private AfT113SenkyoShikakuEntity subAfT113Entity;

}
