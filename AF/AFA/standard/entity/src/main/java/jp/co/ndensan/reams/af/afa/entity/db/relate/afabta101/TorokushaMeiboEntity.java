/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.cautionsha.UaFt400FindeCautionShaMapperEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 新規登録者名簿を格納するEntityクラスです。
 *
 * @reamsid_L AF-0010-039 qiuxy
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TorokushaMeiboEntity {

    private FlexibleDate kijunYMD;
    private Code senkyoLevel;
    private AfT100ShohonEntity shohonEntity;
    private AfT112SenkyoninMeiboEntity senkyoninMeiboEntity;
    private AfT113SenkyoShikakuEntity senkyoShikakuEntity;
    private UaFt200FindShikibetsuTaishoEntity shikibetsuTaishoEntity;
    private UaFt200FindShikibetsuTaishoEntity shikibetsuTaishoEntityForAll;
    private UaFt400FindeCautionShaMapperEntity findeCautionShaMapperEntity;
    private AfT111SenkyoEntity senkyoEntity;
    private RString 合計;
    private Boolean 出力区分_空白行;
    private Boolean 出力区分_合計行;
    private RString 帳票ID;
    private RString サブタイトル;
    private RString タイトル;

    /**
     * is同じレコードを返します。
     *
     * @param other TorokushaMeiboEntity
     * @return boolean
     */
    public boolean is同じレコード(TorokushaMeiboEntity other) {
        return shikibetsuTaishoEntity.getShikibetsuCode().equals(other.getShikibetsuTaishoEntity().getShikibetsuCode());
    }
}
