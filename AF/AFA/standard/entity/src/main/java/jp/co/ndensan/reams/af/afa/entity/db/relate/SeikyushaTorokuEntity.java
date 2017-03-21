package jp.co.ndensan.reams.af.afa.entity.db.relate;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT402SeikyuDaihyoshaEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * 請求代表者一覧用Entityクラスです。
 *
 * @reamsid_L AF-0140-010 wangh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeikyushaTorokuEntity {

    private UaFt200FindShikibetsuTaishoEntity shikibetsuTaisho;
    private AfT402SeikyuDaihyoshaEntity aft402entity;

    private Code shikakuKubun; //選挙資格区分
}
