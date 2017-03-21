/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.af.afa.entity.db.relate.kokumintohyoji;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 訂正者名簿を格納するEntityクラスです。
 *
 * @reamsid_L AF-0360-053 caijj2
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TeiseishaMeiboEntity {

    private boolean idoJiyuCodeIsTenKyo;
    private RString beforeTohyokuCode;
    private FlexibleDate maxKijunYMD;
    
    private AfT100ShohonEntity afT100Shohon;
    private AfT112SenkyoninMeiboEntity afT112SenkyoninMeibo;
    private AfT113SenkyoShikakuEntity afT113SenkyoShikaku;

    private UaFt200FindShikibetsuTaishoEntity afterUaft200;
    private UaFt200FindShikibetsuTaishoEntity beforeUaft200;

    private AfT113SenkyoShikakuEntity afT113SenkyoShikakuAfter;

    /**
     * 同じサブタイトルを判断します。
     *
     * @param other TeiseishaMeiboEntity
     * @return 同じサブタイトル
     */
    public boolean is同じサブタイトル(TeiseishaMeiboEntity other) {
        return this.idoJiyuCodeIsTenKyo == other.isIdoJiyuCodeIsTenKyo();
    }

    /**
     * 同じ投票区を判断します。
     *
     * @param other TeiseishaMeiboEntity
     * @return 同じ投票区
     */
    public boolean is同じ投票区(TeiseishaMeiboEntity other) {
        return beforeTohyokuCode.equals(other.getBeforeTohyokuCode());
    }
}
