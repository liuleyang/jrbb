/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 不在者投票資格エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤礼恵
 */
public final class AfT114FuzaishaTohyoShikakuEntityGenerator {

    public static final ShikibetsuCode DEFAULT_識別コード9991 = new ShikibetsuCode("999999999900001");
    public static final ShikibetsuCode DEFAULT_識別コード9992 = new ShikibetsuCode("999999999900002");
    public static final ShikibetsuCode DEFAULT_識別コード9993 = new ShikibetsuCode("999999999900003");
    public static final Code DEFAULT_投票資格種類_郵便 = new Code("1");
    public static final Code DEFAULT_投票資格種類_船員 = new Code("2");
    public static final Code DEFAULT_投票資格種類_南極 = new Code("3");
    public static final FlexibleDate DEFAULT_交付年月日 = new FlexibleDate("20141201");
    public static final RString DEFAULT_交付番号 = new RString("999999999900001");
    public static final FlexibleDate DEFAULT_資格登録年月日 = new FlexibleDate("20141201");
    public static final FlexibleDate DEFAULT_資格満了年月日 = new FlexibleDate("20201201");
    public static final FlexibleDate DEFAULT_資格抹消年月日 = FlexibleDate.EMPTY;
    public static final Code DEFAULT_資格抹消事由コード = Code.EMPTY;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT114FuzaishaTohyoShikakuEntityGenerator() {
    }

    public static AfT114FuzaishaTohyoShikakuEntity createAfT114FuzaishaTohyoShikakuEntity() {
        return createAfT114FuzaishaTohyoShikakuEntity(DEFAULT_識別コード9991, DEFAULT_投票資格種類_郵便);
    }

    public static AfT114FuzaishaTohyoShikakuEntity createAfT114FuzaishaTohyoShikakuEntity(
            ShikibetsuCode shikibetsuCode, Code tohyoShikakuShurui) {
        AfT114FuzaishaTohyoShikakuEntity entity = new AfT114FuzaishaTohyoShikakuEntity();
        entity.setShikibetsuCode(shikibetsuCode);
        entity.setTohyoShikakuShurui(tohyoShikakuShurui);
        entity.setKofuYMD(DEFAULT_交付年月日);
        entity.setKofuNo(DEFAULT_交付番号);
        entity.setShikakuTorokuYMD(DEFAULT_資格登録年月日);
        entity.setShikakuManryoYMD(DEFAULT_資格満了年月日);
        entity.setShikakuMasshoYMD(DEFAULT_資格抹消年月日);
        entity.setShikakuMasshoJiyuCode(DEFAULT_資格抹消事由コード);
        return entity;
    }
}
