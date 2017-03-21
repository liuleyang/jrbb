/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.barcodejuri;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * AFAGME2040 投票受付　施設一括バーコード受理の検索結果Entityクラスです。
 *
 * @reamsid_L AF-0240-010 qiuxy
 */
@lombok.Getter
@lombok.Setter
public class BarCodeJuriEntity implements Cloneable, Serializable {

    private UaFt200FindShikibetsuTaishoEntity shikibetsuTaisho;
    private AfT100ShohonEntity shohon;
    private AfT111SenkyoEntity senkyo;
    private AfT112SenkyoninMeiboEntity senkyoninMeibo;
    private AfT113SenkyoShikakuEntity senkyoShikaku;
    private AfT201TohyoJokyoEntity tohyoJokyo;

}
