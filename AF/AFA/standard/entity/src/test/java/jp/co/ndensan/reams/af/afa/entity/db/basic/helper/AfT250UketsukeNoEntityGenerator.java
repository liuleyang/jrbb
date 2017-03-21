/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT250UketsukeNoEntity;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受付番号採番管理エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT250UketsukeNoEntityGenerator {

    public static final ShohonNo DEFAULT_抄本番号 = new ShohonNo(9991);
    public static final Code DEFAULT_施設種別 = new Code("1");
    public static final RString DEFAULT_施設コード = RString.EMPTY;
    public static final Code DEFAULT_期日前不在者区分 = new Code(TohyoJokyo.期日前.getCode());
    public static final long DEFAULT_番号 = 9991;
    public static final long DEFAULT_MAX番号 = 999999999;
    public static final long DEFAULT_MIN番号 = 000000000;
    public static final int DEFAULT_有効桁数 = 9;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT250UketsukeNoEntityGenerator() {
    }

    public static AfT250UketsukeNoEntity createAfT250UketsukeNoEntity() {
        return createAfT250UketsukeNoEntity(DEFAULT_抄本番号, DEFAULT_施設種別);
    }

    public static AfT250UketsukeNoEntity createAfT250UketsukeNoEntity(ShohonNo shohonNo, Code kijitsuFuzaiKbn) {
        AfT250UketsukeNoEntity entity = new AfT250UketsukeNoEntity();
        entity.setShohonNo(shohonNo);
        entity.setShisetsuShubetsu(DEFAULT_施設種別);
        entity.setCode(DEFAULT_施設コード);
        entity.setKijitsuFuzaiKubun(kijitsuFuzaiKbn);
        entity.setCurrentNumber(shohonNo.value());
        entity.setMaxNumber(DEFAULT_MAX番号);
        entity.setMinNumber(DEFAULT_MIN番号);
        entity.setEffectiveDigit(DEFAULT_有効桁数);
        return entity;
    }

}
