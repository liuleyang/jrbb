/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.kijitsumaetohyo;

import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.TohyoShikakuHantei;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT505SenkyokuTanmatsuKanriEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoJohoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.kijitsumaetohyo.KijitsumaeSenkyoShikakuEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 期日前投票情報の投票資格データクラスです。
 *
 * @reamsid_L AF-0070-010 liss
 */
public class KijitsumaeSenkyoShikaku implements Serializable {

    private final UaFt200FindShikibetsuTaishoEntity uaft200;
    private final AfT100ShohonEntity aft100;
    private final AfT112SenkyoninMeiboEntity aft112;
    private final AfT113SenkyoShikakuEntity aft113;
    private final AfT505SenkyokuTanmatsuKanriEntity aft505;
    private final AfT114FuzaishaTohyoShikakuEntity aft114;
    private final int aft505Count;

    /**
     * コンストラクタです。
     *
     * @param entity コンストラクタです。
     * @param aft505Count int
     */
    public KijitsumaeSenkyoShikaku(KijitsumaeSenkyoShikakuEntity entity, int aft505Count) {
        this.aft100 = entity.getAft100();
        this.uaft200 = entity.getUaft200();
        this.aft112 = entity.getAft112();
        this.aft113 = entity.getAft113();
        this.aft505 = entity.getAft505();
        this.aft114 = entity.getAft114();
        this.aft505Count = aft505Count;
    }

    /**
     * 投票資格判断を返します。
     *
     * @param 投票状況情報List List<KijitsumaeTohyoJokyo>
     * @param 判定基準日 FlexibleDate
     * @return 投票状況判断
     */
    public boolean has投票資格(List<KijitsumaeTohyoJokyo> 投票状況情報List, FlexibleDate 判定基準日) {

        return new TohyoShikakuHantei(null, null, null).has投票資格Old(to投票状況(投票状況情報List), uaft200.getShikibetsuCode(), 判定基準日);
    }

    /**
     * 期日前投票状況情報を返します。
     *
     * @param 投票状況情報List List<KijitsumaeTohyoJokyo>
     * @return 期日前投票状況情報
     */
    public KijitsumaeTohyoChohyoData to期日前投票状況情報(List<KijitsumaeTohyoJokyo> 投票状況情報List) {

        return new KijitsumaeTohyoChohyoData(to投票状況(投票状況情報List));
    }

    private SenkyoninTohyoJokyoEntity to投票状況(List<KijitsumaeTohyoJokyo> 投票状況情報List) {
        SenkyoninTohyoJokyoEntity 投票状況 = new SenkyoninTohyoJokyoEntity();
        投票状況.setAtenaPSMEntity(uaft200);
        投票状況.setSenkyoninMeiboEntity(aft112);
        投票状況.setSenkyoShikakuEntity(aft113);

        SenkyoJohoEntity senkyoJohoEntity = new SenkyoJohoEntity();
        senkyoJohoEntity.setShohonEntity(aft100);

        List<AfT111SenkyoEntity> afT111SenkyoEntitys = new ArrayList<>();
        List<AfT201TohyoJokyoEntity> afT201TohyoJokyoEntitys = new ArrayList<>();
        for (KijitsumaeTohyoJokyo kijitsumaeTohyoJokyo : 投票状況情報List) {
            afT111SenkyoEntitys.add(kijitsumaeTohyoJokyo.getAft111());
            AfT201TohyoJokyoEntity aft201 = kijitsumaeTohyoJokyo.getAft201();
            afT201TohyoJokyoEntitys.add(aft201);
        }
        senkyoJohoEntity.setSenkyoEntity(afT111SenkyoEntitys);
        投票状況.setSenkyoJohoEntity(senkyoJohoEntity);
        投票状況.setTohyoJokyoEntityList(afT201TohyoJokyoEntitys);
        if (aft505 != null) {

            投票状況.setSenkyokuTanmatsuKanriEntityList(Arrays.asList(aft505));
        } else {
            投票状況.setSenkyokuTanmatsuKanriEntityList(null);
        }
        投票状況.setAft505Count(aft505Count);
        投票状況.setFuzaishaTohyoShikakuEntity(aft114);

        return 投票状況;
    }
}
