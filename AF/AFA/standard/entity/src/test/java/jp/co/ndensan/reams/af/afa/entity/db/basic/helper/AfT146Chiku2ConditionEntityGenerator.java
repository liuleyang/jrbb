/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT146Chiku2ConditionEntity;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;

/**
 * 地区2抽出条件エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT146Chiku2ConditionEntityGenerator {

    public static final ShohonNo DEFAULT_抄本番号 = new ShohonNo(999991);
    public static final ChikuCode DEFAULT_地区コード2 = new ChikuCode(DEFAULT_抄本番号.getColumnValue().toString());

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT146Chiku2ConditionEntityGenerator() {
    }

    public static AfT146Chiku2ConditionEntity createAfT146Chiku2ConditionEntity() {
        return createAfT146Chiku2ConditionEntity(DEFAULT_抄本番号);
    }

    public static AfT146Chiku2ConditionEntity createAfT146Chiku2ConditionEntity(ShohonNo shohonNo) {
        AfT146Chiku2ConditionEntity entity = new AfT146Chiku2ConditionEntity();
        entity.setShohonNo(shohonNo);
        entity.setChikuCode2(new ChikuCode(shohonNo.value().toString()));
        return entity;
    }

}
