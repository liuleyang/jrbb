/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT142TohyokuConditionEntity;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票区抽出条件エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT142TohyokuConditionEntityGenerator {

    public static final ShohonNo DEFAULT_抄本番号 = new ShohonNo(999991);
    public static final RString DEFAULT_投票区コード = new RString(DEFAULT_抄本番号.getColumnValue().toString().substring(2, 6));

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT142TohyokuConditionEntityGenerator() {
    }

    public static AfT142TohyokuConditionEntity createAfT142TohyokuConditionEntity() {
        return createAfT142TohyokuConditionEntity(DEFAULT_抄本番号);
    }

    public static AfT142TohyokuConditionEntity createAfT142TohyokuConditionEntity(ShohonNo shohonNo) {
        AfT142TohyokuConditionEntity entity = new AfT142TohyokuConditionEntity();
        entity.setShohonNo(shohonNo);
        entity.setTohyokuCode(new RString(shohonNo.value().toString().substring(2, 6)));
        return entity;
    }

}
