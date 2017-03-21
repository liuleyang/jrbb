/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojikaiku;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT131KaikuSenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT133KaikuSenkyoFuzuiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.cautionsha.UaFt400FindeCautionShaMapperEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 海区漁業調整委員会委員選挙時登録
 *
 * @reamsid_L AF-0470-020 wanghj
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class SenkyojiKaikuEntity {

    private FlexibleDate kijunYMD;
    private Code senkyoLevel;
    private AfT100ShohonEntity shohonEntity;
    private AfT111SenkyoEntity senkyoEntity;
    private AfT112SenkyoninMeiboEntity senkyoninMeiboEntity;
    private AfT113SenkyoShikakuEntity senkyoShikakuEntity;
    private UaFt200FindShikibetsuTaishoEntity shikibetsuTaishoEntity;
    private AfT131KaikuSenkyoEntity kaikuSenkyoEntity;
    private AfT133KaikuSenkyoFuzuiEntity kaikuSenkyoFuzuiEntity;
    private AfT501TohyokuEntity afT501TohyokuEntity;
    private AfT113SenkyoShikakuEntity subAfT113Entity;
    private UaFt400FindeCautionShaMapperEntity findeCautionShaMapperEntity;

    /**
     * is同じレコードを返します。
     *
     * @param other TorokushaMeiboEntity
     * @return boolean
     */
    public boolean is同じレコード(SenkyojiKaikuEntity other) {
        return shikibetsuTaishoEntity.getShikibetsuCode().equals(other.getShikibetsuTaishoEntity().getShikibetsuCode());
    }

}
