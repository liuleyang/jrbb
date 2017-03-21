/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT143GyoseikuConditionEntity;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;

/**
 * 行政区抽出条件エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT143GyoseikuConditionEntityGenerator {

    public static final ShohonNo DEFAULT_抄本番号 = new ShohonNo(999991);
    public static final GyoseikuCode DEFAULT_行政区コード = new GyoseikuCode(DEFAULT_抄本番号.toString().substring(2, 6));

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT143GyoseikuConditionEntityGenerator() {
    }

    public static AfT143GyoseikuConditionEntity createAfT143GyoseikuConditionEntity() {
        return createAfT143GyoseikuConditionEntity(DEFAULT_抄本番号);
    }

    public static AfT143GyoseikuConditionEntity createAfT143GyoseikuConditionEntity(ShohonNo shohonNo) {
        AfT143GyoseikuConditionEntity entity = new AfT143GyoseikuConditionEntity();
        entity.setShohonNo(shohonNo);
        entity.setGyoseikuCode(new GyoseikuCode(shohonNo.value().toString().substring(2, 6)));
        return entity;
    }

}
