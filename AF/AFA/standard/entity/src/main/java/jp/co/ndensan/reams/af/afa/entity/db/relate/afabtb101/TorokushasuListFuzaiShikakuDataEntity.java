/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.afabtb101;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT115FuzaishaTohyoShikakuYubinEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.chiku.tohyoku.UrT0159TohyokuEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 登録者数リスト（不在者投票資格者分）を格納するEntityクラスです。
 *
 * @reamsid_L AF-0010-020 wangm
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TorokushasuListFuzaiShikakuDataEntity implements Serializable {

    private AfT100ShohonEntity afT100Shohon;
    private AfT111SenkyoEntity afT111Senkyo;
    private AfT112SenkyoninMeiboEntity afT112SenkyoninMeibo;
    private AfT113SenkyoShikakuEntity afT113SenkyoShikaku;
    private UaFt200FindShikibetsuTaishoEntity uaft200;

    private AfT501TohyokuEntity afT501;
    private UrT0159TohyokuEntity urV0159;

    private AfT114FuzaishaTohyoShikakuEntity afT114;
    private AfT115FuzaishaTohyoShikakuYubinEntity afT115;
}
