/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojikaiku;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT133KaikuSenkyoFuzuiEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 海区漁業調整委員会委員選挙時登録
 *
 * @reamsid_L AF-0470-020 wanghj
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KaikuTeiseishaMeiboEntity {

    private boolean idoJiyuCodeIsTenKyo;
    private RString beforeTohyokuCode;
    private FlexibleDate maxKijunYMD;

    private AfT100ShohonEntity afT100Shohon;
    private AfT112SenkyoninMeiboEntity afT112SenkyoninMeibo;
    private AfT113SenkyoShikakuEntity afT113SenkyoShikaku;
    private AfT133KaikuSenkyoFuzuiEntity afT133KaikuSenkyoFuzui;

    private UaFt200FindShikibetsuTaishoEntity afterUaft200;
    private UaFt200FindShikibetsuTaishoEntity beforeUaft200;

    private AfT100ShohonEntity afT100ShohonBefore;
    private AfT112SenkyoninMeiboEntity afT112SenkyoninMeiboBefore;
    private AfT113SenkyoShikakuEntity afT113SenkyoShikakuBefore;
    private AfT133KaikuSenkyoFuzuiEntity afT133KaikuSenkyoFuzuiBefore;

    /**
     * 同じサブタイトルを判断します。
     *
     * @param other KaikuTeiseishaMeiboEntity
     * @return 同じサブタイトル
     */
    public boolean is同じサブタイトル(KaikuTeiseishaMeiboEntity other) {
        return this.idoJiyuCodeIsTenKyo == other.isIdoJiyuCodeIsTenKyo();
    }

    /**
     * 同じ投票区を判断します。
     *
     * @param other KaikuTeiseishaMeiboEntity
     * @return 同じ投票区
     */
    public boolean is同じ投票区(KaikuTeiseishaMeiboEntity other) {
        return beforeTohyokuCode.equals(other.getBeforeTohyokuCode());
    }

}
