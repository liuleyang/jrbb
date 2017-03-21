/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT144JushoConditionEntity;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;

/**
 * 住所抽出条件エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT144JushoConditionEntityGenerator {

    public static final ShohonNo DEFAULT_抄本番号 = new ShohonNo(999991);
    public static final ChoikiCode DEFAULT_町域コード = new ChoikiCode("99999100");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT144JushoConditionEntityGenerator() {
    }

    public static AfT144JushoConditionEntity createAfT144JushoConditionEntity() {
        return createAfT144JushoConditionEntity(DEFAULT_抄本番号);
    }

    public static AfT144JushoConditionEntity createAfT144JushoConditionEntity(ShohonNo shohonNo) {
        AfT144JushoConditionEntity entity = new AfT144JushoConditionEntity();
        entity.setShohonNo(shohonNo);
        entity.setChoikiCode(new ChoikiCode(shohonNo.value().toString() + "00"));
        return entity;
    }

}
