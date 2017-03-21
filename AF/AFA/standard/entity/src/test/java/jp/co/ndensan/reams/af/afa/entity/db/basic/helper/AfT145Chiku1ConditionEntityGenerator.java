/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT145Chiku1ConditionEntity;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;

/**
 * 地区1抽出条件エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT145Chiku1ConditionEntityGenerator {

    public static final ShohonNo DEFAULT_抄本番号 = new ShohonNo(999991);
    public static final ChikuCode DEFAULT_地区コード1 = new ChikuCode(DEFAULT_抄本番号.getColumnValue().toString());

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT145Chiku1ConditionEntityGenerator() {
    }

    public static AfT145Chiku1ConditionEntity createAfT145Chiku1ConditionEntity() {
        return createAfT145Chiku1ConditionEntity(DEFAULT_抄本番号);
    }

    public static AfT145Chiku1ConditionEntity createAfT145Chiku1ConditionEntity(ShohonNo shohonNo) {
        AfT145Chiku1ConditionEntity entity = new AfT145Chiku1ConditionEntity();
        entity.setShohonNo(shohonNo);
        entity.setChikuCode1(new ChikuCode(shohonNo.value().toString()));
        return entity;
    }

}
