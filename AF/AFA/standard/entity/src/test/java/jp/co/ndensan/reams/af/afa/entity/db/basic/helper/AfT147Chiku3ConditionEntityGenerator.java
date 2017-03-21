/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT147Chiku3ConditionEntity;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;

/**
 * 地区3抽出条件エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT147Chiku3ConditionEntityGenerator {

    public static final ShohonNo DEFAULT_抄本番号 = new ShohonNo(999991);
    public static final ChikuCode DEFAULT_地区コード3 = new ChikuCode(DEFAULT_抄本番号.getColumnValue().toString());

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT147Chiku3ConditionEntityGenerator() {
    }

    public static AfT147Chiku3ConditionEntity createAfT147Chiku3ConditionEntity() {
        return createAfT147Chiku3ConditionEntity(DEFAULT_抄本番号);
    }

    public static AfT147Chiku3ConditionEntity createAfT147Chiku3ConditionEntity(ShohonNo shohonNo) {
        AfT147Chiku3ConditionEntity entity = new AfT147Chiku3ConditionEntity();
        entity.setShohonNo(shohonNo);
        entity.setChikuCode3(new ChikuCode(shohonNo.value().toString()));
        return entity;
    }

}
