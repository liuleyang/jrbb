/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.afabtb101;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT115FuzaishaTohyoShikakuYubinEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 不在者投票資格者名簿を格納するクラスです。
 *
 * @reamsid_L AF-0030-035 qiuxy
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class FuzaiShikakushaMeiboEntity implements Serializable {

    private RString breakPage;
    private FlexibleDate maxKijunYMD;
    private AfT100ShohonEntity shohonEntity;
    private AfT112SenkyoninMeiboEntity senkyoninMeiboEntity;
    private AfT113SenkyoShikakuEntity senkyoShikakuEntity;
    private AfT114FuzaishaTohyoShikakuEntity fuzaishaTohyoShikakuEntity;
    private AfT115FuzaishaTohyoShikakuYubinEntity fuzaishaTohyoShikakuYubinEntity;
    private UaFt200FindShikibetsuTaishoEntity shikibetsuTaishoEntity;
}
