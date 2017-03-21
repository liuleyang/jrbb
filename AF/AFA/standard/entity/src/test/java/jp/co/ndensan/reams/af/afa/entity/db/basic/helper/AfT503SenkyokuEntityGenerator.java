/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT503SenkyokuEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙区エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT503SenkyokuEntityGenerator {

    public static final Code DEFAULT_選挙種類 = new Code(SenkyoShurui.国政選挙_地方選挙.getCode());
    public static final RString DEFAULT_選挙区コード = new RString("T991");
    public static final RString DEFAULT_選挙区名 = new RString("テスト選挙区");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT503SenkyokuEntityGenerator() {
    }

    public static AfT503SenkyokuEntity createAfT503SenkyokuEntity() {
        return createAfT503SenkyokuEntity(DEFAULT_選挙種類, DEFAULT_選挙区コード);
    }

    public static AfT503SenkyokuEntity createAfT503SenkyokuEntity(Code senkyoShurui, RString senkyokuCode) {
        AfT503SenkyokuEntity entity = new AfT503SenkyokuEntity();
        entity.setSenkyoShurui(senkyoShurui);
        entity.setSenkyokuCode(senkyokuCode);
        entity.setSenkyokuName(new RString(DEFAULT_選挙区名.toString() + senkyoShurui + senkyokuCode));
        return entity;
    }

}
