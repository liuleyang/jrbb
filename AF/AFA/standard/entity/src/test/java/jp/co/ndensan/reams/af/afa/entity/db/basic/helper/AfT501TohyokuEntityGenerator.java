/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票区エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author N1823 有澤 礼恵
 */
public class AfT501TohyokuEntityGenerator {

    public static final Code DEFAULT_選挙種類 = new Code(SenkyoShurui.国政選挙_地方選挙.getCode());
    public static final RString DEFAULT_投票区コード = new RString("T991");
    public static final RString DEFAULT_投票区名 = new RString("テスト投票区");
    public static final RString DEFAULT_カナ投票区名 = new RString("ﾃｽﾄﾄｳﾋｮｳｸ");
    public static final RString DEFAULT_検索用カナ投票区名 = new RString("ﾃｽﾄﾄｳﾋｮｳｸ");
    public static final int DEFAULT_表示順 = 1;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT501TohyokuEntityGenerator() {
    }

    public static AfT501TohyokuEntity createAfT501TohyokuEntity() {
        return createAfT501TohyokuEntity(DEFAULT_選挙種類, DEFAULT_投票区コード);
    }

    public static AfT501TohyokuEntity createAfT501TohyokuEntity(Code senkyoShurui, RString tohyokuCode) {
        AfT501TohyokuEntity entity = new AfT501TohyokuEntity();
        entity.setSenkyoShurui(senkyoShurui);
        entity.setTohyokuCode(tohyokuCode);
        entity.setTohyokuName(new RString(DEFAULT_投票区名.toString() + senkyoShurui + tohyokuCode));
        entity.setKanaTohyokuName(DEFAULT_カナ投票区名);
        entity.setSearchKanaTohyokuName(DEFAULT_検索用カナ投票区名);
        entity.setHyojijun(DEFAULT_表示順);
        return entity;
    }

}
