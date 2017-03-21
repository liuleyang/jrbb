/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT510RyojikanEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 領事官エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT510RyojikanEntityGenerator {

    public static final RString DEFAULT_領事官コード = new RString("T11");
    public static final RString DEFAULT_領事官名称 = new RString("テスト領事官");
    public static final RString DEFAULT_カナ領事官名称 = RString.EMPTY;
    public static final RString DEFAULT_検索用カナ領事官名称 = RString.EMPTY;
    public static final int DEFAULT_表示順 = 1;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT510RyojikanEntityGenerator() {
    }

    public static AfT510RyojikanEntity createAfT510RyojikanEntity() {
        return createAfT510RyojikanEntity(DEFAULT_領事官コード);
    }

    public static AfT510RyojikanEntity createAfT510RyojikanEntity(RString ryojikanCode) {
        AfT510RyojikanEntity entity = new AfT510RyojikanEntity();
        entity.setRyojikanCode(ryojikanCode);
        entity.setRyojikanName(new RString(DEFAULT_領事官名称.toString() + ryojikanCode));
        entity.setKanaRyojikanName(DEFAULT_カナ領事官名称);
        entity.setSearchKanaRyojikanName(DEFAULT_検索用カナ領事官名称);
        entity.setHyojijun(DEFAULT_表示順);
        return entity;
    }

}
