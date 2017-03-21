/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.kokumintohyoji;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 1号資格登録通知（様式1）を格納するクラスです。
 *
 * @reamsid_L AF-0360-055 caijj2
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class IchigoShikakuTorokuTsuchiListEntity implements Serializable {

    private AfT100ShohonEntity shohonEntity;
    private AfT112SenkyoninMeiboEntity senkyoninMeiboEntity;
    private AfT111SenkyoEntity senkyoEntity;
    private AfT113SenkyoShikakuEntity senkyoShikakuEntity;
    private UaFt200FindShikibetsuTaishoEntity shikibetsuTaishoEntity;
    private Boolean hasOtherSenkyo;
    private int senkyoCount;
}
