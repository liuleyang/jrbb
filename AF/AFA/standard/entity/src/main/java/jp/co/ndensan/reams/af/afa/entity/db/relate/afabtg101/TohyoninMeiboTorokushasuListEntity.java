/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.afabtg101;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.chiku.tohyoku.UrT0159TohyokuEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 投票人名簿登録者数リストのデータを格納するクラスです。
 *
 * @reamsid_L AF-0360-054 qiuxy
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TohyoninMeiboTorokushasuListEntity implements Serializable {

    private AfT111SenkyoEntity senkyoEntity;
    private AfT100ShohonEntity shohonEntity;
    private AfT112SenkyoninMeiboEntity senkyoninMeiboEntity;
    private AfT113SenkyoShikakuEntity senkyoShikakuEntity;
    private UaFt200FindShikibetsuTaishoEntity shikibetsuTaishoEntity;
    private AfT501TohyokuEntity afTohyokuEntity;
    private UrT0159TohyokuEntity urTohyokuEntity;
}
