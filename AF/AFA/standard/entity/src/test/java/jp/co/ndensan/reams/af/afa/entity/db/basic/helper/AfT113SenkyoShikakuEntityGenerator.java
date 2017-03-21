/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afx.definition.core.enumeratedtype.SenkyoShikaku;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙資格エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤礼恵
 */
public final class AfT113SenkyoShikakuEntityGenerator {

    public static final Code DEFAULT_選挙種類_定時 = new Code(SenkyoShurui.定時登録.getCode());
    public static final Code DEFAULT_選挙種類_通常 = new Code(SenkyoShurui.国政選挙_地方選挙.getCode());
    public static final ShikibetsuCode DEFAULT_識別コード9991 = new ShikibetsuCode("999999999900001");
    public static final ShikibetsuCode DEFAULT_識別コード9992 = new ShikibetsuCode("999999999900002");
    public static final ShikibetsuCode DEFAULT_識別コード9993 = new ShikibetsuCode("999999999900003");
    public static final Code DEFAULT_選挙資格区分 = new Code(SenkyoShikaku.有権者.getコード());
    public static final RString DEFAULT_投票区コード = new RString("001");
    public static final FlexibleDate DEFAULT_名簿登録年月日 = new FlexibleDate("20141201");
    public static final Code DEFAULT_登録事由コード = new Code("11");
    public static final FlexibleDate DEFAULT_登録停止年月日 = FlexibleDate.EMPTY;
    public static final Code DEFAULT_登録停止事由コード = Code.EMPTY;
    public static final FlexibleDate DEFAULT_表示年月日 = FlexibleDate.EMPTY;
    public static final Code DEFAULT_表示事由コード = Code.EMPTY;
    public static final FlexibleDate DEFAULT_表示消除年月日 = FlexibleDate.EMPTY;
    public static final FlexibleDate DEFAULT_表示消除予定年月日 = FlexibleDate.EMPTY;
    public static final FlexibleDate DEFAULT_抹消年月日 = FlexibleDate.EMPTY;
    public static final Code DEFAULT_抹消事由コード = Code.EMPTY;
    public static final FlexibleDate DEFAULT_刑期終了年月日 = FlexibleDate.EMPTY;
    public static final boolean DEFAULT_2刑持ちフラグ = Boolean.FALSE;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT113SenkyoShikakuEntityGenerator() {
    }

    public static AfT113SenkyoShikakuEntity createAfT113SenkyoShikakuEntity() {
        return createAfT113SenkyoShikakuEntity(DEFAULT_選挙種類_通常, DEFAULT_識別コード9991);
    }

    public static AfT113SenkyoShikakuEntity createAfT113SenkyoShikakuEntity(Code senkyoShurui, ShikibetsuCode shikibetsuCode) {
        AfT113SenkyoShikakuEntity entity = new AfT113SenkyoShikakuEntity();
        entity.setSenkyoShurui(senkyoShurui);
        entity.setShikibetsuCode(shikibetsuCode);
        entity.setShikakuKubun(DEFAULT_選挙資格区分);
        entity.setTohyokuCode(DEFAULT_投票区コード);
        entity.setMeiboTorokuYMD(DEFAULT_名簿登録年月日);
        entity.setTorokuJiyuCode(DEFAULT_登録事由コード);
        entity.setTorokuTeishiYMD(DEFAULT_登録停止年月日);
        entity.setTorokuTeishiJiyuCode(DEFAULT_登録停止事由コード);
        entity.setHyojiYMD(DEFAULT_表示年月日);
        entity.setHyojiJiyuCode(DEFAULT_表示事由コード);
        entity.setHyojiShojoYMD(DEFAULT_表示消除年月日);
        entity.setHyojiShojoYoteiYMD(DEFAULT_表示消除予定年月日);
        entity.setMasshoYMD(DEFAULT_抹消年月日);
        entity.setMasshoJiyuCode(DEFAULT_抹消事由コード);
        entity.setKeikiShuryoYMD(DEFAULT_刑期終了年月日);
        entity.setNikeimochiFlag(DEFAULT_2刑持ちフラグ);
        return entity;
    }

}
