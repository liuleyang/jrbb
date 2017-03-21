/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShisetsuShubetsu;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT507ShisetsuEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT507ShisetsuEntityGenerator {

    public static final RString DEFAULT_施設コード = new RString("T011");
    public static final Code DEFAULT_施設種別 = new Code(ShisetsuShubetsu.病院.getCode());
    public static final RString DEFAULT_施設名称 = new RString("テスト施設");
    public static final RString DEFAULT_カナ施設名称 = new RString("ﾃｽﾄｼｾﾂ");
    public static final RString DEFAULT_検索用カナ施設名称 = new RString("ﾃｽﾄｼｾﾂ");
    public static final YubinNo DEFAULT_郵便番号 = YubinNo.EMPTY;
    public static final AtenaJusho DEFAULT_住所 = AtenaJusho.EMPTY;
    public static final AtenaMeisho DEFAULT_施設宛名 = AtenaMeisho.EMPTY;
    public static final TelNo DEFAULT_電話番号 = TelNo.EMPTY;
    public static final TelNo DEFAULT_FAX番号 = TelNo.EMPTY;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT507ShisetsuEntityGenerator() {
    }

    public static AfT507ShisetsuEntity createAfT507ShisetsuEntity() {
        return createAfT507ShisetsuEntity(DEFAULT_施設コード);
    }

    public static AfT507ShisetsuEntity createAfT507ShisetsuEntity(RString shisetsuCode) {
        AfT507ShisetsuEntity entity = new AfT507ShisetsuEntity();
        entity.setShisetsuCode(shisetsuCode);
        entity.setShisetsuShubetsu(DEFAULT_施設種別);
        entity.setShisetsuName(new RString(DEFAULT_施設名称.toString() + shisetsuCode));
        entity.setKanaShisetsuName(DEFAULT_カナ施設名称);
        entity.setSearchKanaShisetsuName(DEFAULT_検索用カナ施設名称);
        entity.setYubinNo(DEFAULT_郵便番号);
        entity.setJusho(DEFAULT_住所);
        entity.setShisetsuAtena(DEFAULT_施設宛名);
        entity.setTelNo(DEFAULT_電話番号);
        entity.setFaxNo(DEFAULT_FAX番号);
        return entity;
    }

}
