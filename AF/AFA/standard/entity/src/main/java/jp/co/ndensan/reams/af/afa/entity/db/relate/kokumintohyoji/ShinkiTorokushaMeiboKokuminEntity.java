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
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT115FuzaishaTohyoShikakuYubinEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 補正登録者名簿を格納するクラスです
 *
 * @author zhoujie3
 */
@Getter
@Setter
public class ShinkiTorokushaMeiboKokuminEntity {

    private AfT100ShohonEntity shohonEntity;
    private AfT112SenkyoninMeiboEntity senkyoninMeiboEntity;
    private AfT111SenkyoEntity senkyoEntity;
    private AfT113SenkyoShikakuEntity senkyoShikakuEntity;
    private AfT114FuzaishaTohyoShikakuEntity fuzaishaTohyoShikakuEntity;
    private AfT115FuzaishaTohyoShikakuYubinEntity fuzaishaTohyoShikakuYubinEntity;
    private UaFt200FindShikibetsuTaishoEntity shikibetsuTaishoEntity;
    private AfT201TohyoJokyoEntity tohyoJokyoEntity;
    private RString 合計;
    private Boolean 出力区分_空白行;
    private Boolean 出力区分_合計行;
    private RString 帳票ID;
}
