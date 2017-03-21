/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.kokumintohyoji;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 未登録者抹消通知一覧表を格納するクラスです。
 *
 * @reamsid_L AF-0360-060 zhoujie3
 */
@Getter
@Setter
public class MitorokushaMasshoTsuchiListEntity {

    private AfT100ShohonEntity shohonEntity;
    private AfT112SenkyoninMeiboEntity senkyoninMeiboEntity;
    private AfT111SenkyoEntity senkyoEntity;
    private AfT113SenkyoShikakuEntity senkyoShikakuEntity;
    private UaFt200FindShikibetsuTaishoEntity shikibetsuTaishoEntity;
    private int senkyoCount;
    private RString 集計;
    private boolean 出力区分_集計行;
    private boolean 出力区分_空白行;
}
