/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT509KumiaiEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 組合マスタエンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT509KumiaiEntityGenerator {

    public static final RString DEFAULT_組合コード = new RString("T999001");
    public static final RString DEFAULT_組合名称 = new RString("テスト組合");
    public static final RString DEFAULT_カナ組合名称 = RString.EMPTY;
    public static final RString DEFAULT_検索用カナ組合名称 = RString.EMPTY;
    public static final AtenaJusho DEFAULT_組合の住所等 = AtenaJusho.EMPTY;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT509KumiaiEntityGenerator() {
    }

    public static AfT509KumiaiEntity createAfT509KumiaiEntity() {
        return createAfT509KumiaiEntity(DEFAULT_組合コード);
    }

    public static AfT509KumiaiEntity createAfT509KumiaiEntity(RString kumiaiCode) {
        AfT509KumiaiEntity entity = new AfT509KumiaiEntity();
        entity.setKumiaiCode(kumiaiCode);
        entity.setKumiaiName(new RString(DEFAULT_組合名称.toString() + kumiaiCode));
        entity.setKanaKumiaiName(DEFAULT_カナ組合名称);
        entity.setSearchKumiaiName(DEFAULT_検索用カナ組合名称);
        entity.setJusho(DEFAULT_組合の住所等);
        return entity;
    }

}
