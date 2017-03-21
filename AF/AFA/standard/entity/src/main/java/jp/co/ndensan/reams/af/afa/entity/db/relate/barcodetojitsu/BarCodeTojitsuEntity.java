/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.barcodetojitsu;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * AFAGME4020 バーコード一括当日投票入力
 *
 * @reamsid_L AF-0115-010 xul
 */
@lombok.Getter
@lombok.Setter
public class BarCodeTojitsuEntity implements Cloneable, Serializable {

    private UaFt200FindShikibetsuTaishoEntity shikibetsuTaisho;
    private AfT100ShohonEntity shohon;
    private AfT111SenkyoEntity senkyo;
    private AfT112SenkyoninMeiboEntity senkyoninMeibo;
    private AfT113SenkyoShikakuEntity senkyoShikaku;
    private AfT201TohyoJokyoEntity tohyoJokyoEntity;

}
