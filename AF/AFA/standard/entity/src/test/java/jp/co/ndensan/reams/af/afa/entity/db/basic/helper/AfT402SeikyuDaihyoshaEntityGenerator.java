/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT402SeikyuDaihyoshaEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 直接請求代表者エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT402SeikyuDaihyoshaEntityGenerator {

    public static final int DEFAULT_直接請求番号 = 9991;
    public static final ShikibetsuCode DEFAULT_請求代表者識別コード = new ShikibetsuCode("999999999001");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT402SeikyuDaihyoshaEntityGenerator() {
    }

    public static AfT402SeikyuDaihyoshaEntity createAfT402SeikyuDaihyoshaEntity() {
        return createAfT402SeikyuDaihyoshaEntity(DEFAULT_直接請求番号, DEFAULT_請求代表者識別コード);
    }

    public static AfT402SeikyuDaihyoshaEntity createAfT402SeikyuDaihyoshaEntity(int seikyuNo, ShikibetsuCode shikibetsuCode) {
        AfT402SeikyuDaihyoshaEntity entity = new AfT402SeikyuDaihyoshaEntity();
        entity.setSeikyuNo(seikyuNo);
        entity.setSeikyuShikibetsuCode(shikibetsuCode);
        return entity;
    }

}
