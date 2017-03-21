/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.cautionsha.UaFt400FindeCautionShaMapperEntity;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.chiku.tohyoku.UrT0159TohyokuEntity;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.zenkokujusho.UrT0101ZenkokuJushoEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 選挙人名簿抄本を格納するEntityクラスです。
 *
 * @reamsid_L AF-0010-020 wangm
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class SenkyoninMeiboShohonEntity {

    private int type;

    private AfT100ShohonEntity afT100Shohon;
    private AfT111SenkyoEntity afT111Senkyo;
    private AfT112SenkyoninMeiboEntity afT112SenkyoninMeibo;
    private AfT113SenkyoShikakuEntity afT113SenkyoShikaku;
    private UaFt200FindShikibetsuTaishoEntity uaft200;
    private UaFt200FindShikibetsuTaishoEntity uaft200ForAll;

    private UrT0101ZenkokuJushoEntity urT0101;

    private AfT201TohyoJokyoEntity afT201TohyoJokyo;
    private AfT114FuzaishaTohyoShikakuEntity afT114;

    private AfT501TohyokuEntity afT501;
    private UrT0159TohyokuEntity urV0159;

    private UaFt400FindeCautionShaMapperEntity uaft400;
}
