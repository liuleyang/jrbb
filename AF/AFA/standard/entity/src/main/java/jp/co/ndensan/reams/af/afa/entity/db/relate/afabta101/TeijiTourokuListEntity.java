/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoJohoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 定時登録のデータを格納するEntityクラスです。
 *
 * @reamsid_L AF-0010-020 wangm
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TeijiTourokuListEntity {

    private AfT100ShohonEntity afT100Shohon;
    private AfT111SenkyoEntity afT111Senkyo;
    private AfT112SenkyoninMeiboEntity afT112SenkyoninMeibo;
    private AfT113SenkyoShikakuEntity afT113SenkyoShikaku;
    private UaFt200FindShikibetsuTaishoEntity uaft200;

    /**
     * 選挙人資格の情報になります。
     *
     * @return SenkyoninTohyoJokyoEntity
     */
    public SenkyoninTohyoJokyoEntity toSenkyoninTohyoJokyoEntity() {
        SenkyoninTohyoJokyoEntity entity = new SenkyoninTohyoJokyoEntity();

        SenkyoJohoEntity senkyoJohoEntity = new SenkyoJohoEntity();
        senkyoJohoEntity.setShohonEntity(afT100Shohon);
        List<AfT111SenkyoEntity> aft111List = new ArrayList<>();
        aft111List.add(afT111Senkyo);
        senkyoJohoEntity.setSenkyoEntity(aft111List);
        entity.setSenkyoJohoEntity(senkyoJohoEntity);

        entity.setAtenaPSMEntity(uaft200);
        entity.setSenkyoninMeiboEntity(afT112SenkyoninMeibo);
        entity.setSenkyoShikakuEntity(afT113SenkyoShikaku);

        return entity;
    }

    /**
     * 識別コードのgetメソッドです。
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return uaft200.getShikibetsuCode();
    }

    /**
     * 抄本番号のgetメソッドです。
     *
     * @return 抄本番号
     */
    public ShohonNo getShohonNo() {
        return afT100Shohon == null ? null : afT100Shohon.getShohonNo();
    }
}
