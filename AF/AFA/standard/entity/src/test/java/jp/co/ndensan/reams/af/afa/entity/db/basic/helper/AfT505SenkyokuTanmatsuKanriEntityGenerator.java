/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT505SenkyokuTanmatsuKanriEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙区端末管理エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT505SenkyokuTanmatsuKanriEntityGenerator {

    public static final Code DEFAULT_選挙種類 = new Code(SenkyoShurui.国政選挙_地方選挙.getCode());
    public static final RString DEFAULT_選挙区コード = new RString("T991");
    public static final RString DEFAULT_端末ID = new RString("テスト端末");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT505SenkyokuTanmatsuKanriEntityGenerator() {
    }

    public static AfT505SenkyokuTanmatsuKanriEntity createAfT505SenkyokuTanmatsuKanriEntity() {
        return createAfT505SenkyokuTanmatsuKanriEntity(DEFAULT_選挙種類, DEFAULT_選挙区コード);
    }

    public static AfT505SenkyokuTanmatsuKanriEntity createAfT505SenkyokuTanmatsuKanriEntity(Code senkyoShurui, RString senkyokuCode) {
        AfT505SenkyokuTanmatsuKanriEntity entity = new AfT505SenkyokuTanmatsuKanriEntity();
        entity.setSenkyoShurui(senkyoShurui);
        entity.setSenkyokuCode(senkyokuCode);
        entity.setTanmatsuID(new RString(DEFAULT_端末ID.toString() + senkyoShurui + senkyokuCode));
        return entity;
    }

}
