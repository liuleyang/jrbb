/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT131KaikuSenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT133KaikuSenkyoFuzuiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TorokushaMeiboEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 新規登録者名簿を格納するEntityクラスです。
 *
 * @reamsid_L AF-0460-034 wanghj
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TorokushaMeibo {

    private FlexibleDate kijunYMD;
    private Code senkyoLevel;
    private AfT100ShohonEntity shohonEntity;
    private AfT111SenkyoEntity senkyoEntity;
    private AfT112SenkyoninMeiboEntity senkyoninMeiboEntity;
    private AfT113SenkyoShikakuEntity senkyoShikakuEntity;
    private UaFt200FindShikibetsuTaishoEntity shikibetsuTaishoEntity;
    private AfT131KaikuSenkyoEntity kaikuSenkyoEntity;
    private AfT133KaikuSenkyoFuzuiEntity kaikuSenkyoFuzuiEntity;

    /**
     * is同じレコードを返します。
     *
     * @param other TorokushaMeiboEntity
     * @return boolean
     */
    public boolean is同じレコード(TorokushaMeiboEntity other) {
        ShikibetsuCode shikibetsuCode = shikibetsuTaishoEntity.getShikibetsuCode();
        if (shikibetsuCode != null) {
            return shikibetsuCode.equals(other.getShikibetsuTaishoEntity().getShikibetsuCode());
        }
        return false;
    }
}
