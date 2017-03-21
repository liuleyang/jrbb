/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT121ZaigaiSenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在外選挙人名簿エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT121ZaigaiSenkyoninMeiboEntityGenerator {

    public static final ShohonNo DEFAULT_抄本番号 = new ShohonNo(9991);
    public static final RString DEFAULT_グループコード = new RString("0");
    public static final RString DEFAULT_投票区コード = new RString("0001");
    public static final RString DEFAULT_国外分類コード = new RString("000");
    public static final RString DEFAULT_冊 = new RString("00");
    public static final int DEFAULT_頁 = 1;
    public static final int DEFAULT_行 = 1;
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("999999999900001");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT121ZaigaiSenkyoninMeiboEntityGenerator() {
    }

    public static AfT121ZaigaiSenkyoninMeiboEntity createAfT121ZaigaiSenkyoninMeiboEntity() {
        return createAfT121ZaigaiSenkyoninMeiboEntity(DEFAULT_抄本番号, DEFAULT_投票区コード);
    }

    public static AfT121ZaigaiSenkyoninMeiboEntity createAfT121ZaigaiSenkyoninMeiboEntity(ShohonNo shohonNo, RString tohyokuCode) {
        AfT121ZaigaiSenkyoninMeiboEntity entity = new AfT121ZaigaiSenkyoninMeiboEntity();
        entity.setShohonNo(shohonNo);
        entity.setGroupCode(DEFAULT_グループコード);
        entity.setTohyokuCode(tohyokuCode);
        entity.setKokugaiBunruiCode(DEFAULT_国外分類コード);
        entity.setSatsu(DEFAULT_冊);
        entity.setPage(DEFAULT_頁);
        entity.setGyo(DEFAULT_行);
        entity.setShikibetsuCode(new ShikibetsuCode(shohonNo.getColumnValue().toString() + tohyokuCode.toString()));
        return entity;
    }
}
