/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.xml.kijitsumaetohyo;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT505SenkyokuTanmatsuKanriEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 期日前投票情報の投票資格entityクラスです。
 *
 * @reamsid_L AF-0070-010 liss
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KijitsumaeSenkyoShikakuEntity {

    private UaFt200FindShikibetsuTaishoEntity uaft200;
    private AfT100ShohonEntity aft100;
    private AfT112SenkyoninMeiboEntity aft112;
    private AfT113SenkyoShikakuEntity aft113;
    private AfT505SenkyokuTanmatsuKanriEntity aft505;
    private AfT114FuzaishaTohyoShikakuEntity aft114;
}
