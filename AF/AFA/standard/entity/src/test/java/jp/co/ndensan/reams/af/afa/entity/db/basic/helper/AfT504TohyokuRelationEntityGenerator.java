/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT504TohyokuRelationEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票区投票所対応エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT504TohyokuRelationEntityGenerator {

    public static final Code DEFAULT_選挙種類 = new Code(SenkyoShurui.国政選挙_地方選挙.getCode());
    public static final RString DEFAULT_投票区コード = new RString("T991");
    public static final RString DEFAULT_投票所コード = new RString("T991");
    public static final RString DEFAULT_選挙区コード = RString.HALF_SPACE;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT504TohyokuRelationEntityGenerator() {
    }

    public static AfT504TohyokuRelationEntity createAfT504TohyokuRelationEntity() {
        return createAfT504TohyokuRelationEntity(DEFAULT_選挙種類, DEFAULT_投票区コード);
    }

    public static AfT504TohyokuRelationEntity createAfT504TohyokuRelationEntity(Code senkyoShurui, RString tohyokuCode) {
        AfT504TohyokuRelationEntity entity = new AfT504TohyokuRelationEntity();
        entity.setSenkyoShurui(senkyoShurui);
        entity.setTohyokuCode(tohyokuCode);
        entity.setTohyojoCode(new RString(senkyoShurui.toString() + tohyokuCode.toString()));
        entity.setSenkyokuCode(DEFAULT_選挙区コード);
        return entity;
    }

}
