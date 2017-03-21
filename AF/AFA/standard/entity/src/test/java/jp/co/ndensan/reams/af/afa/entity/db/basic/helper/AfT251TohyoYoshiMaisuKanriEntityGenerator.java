/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT251TohyoYoshiMaisuKanriEntity;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票用紙枚数管理エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT251TohyoYoshiMaisuKanriEntityGenerator {

    public static final ShohonNo DEFAULT_抄本番号 = new ShohonNo(9991);
    public static final SenkyoNo DEFAULT_選挙番号 = new SenkyoNo(1);
    public static final RString DEFAULT_投票区コード = new RString("001");
    public static final int DEFAULT_投票用紙枚数 = 9991;
    public static final int DEFAULT_点字用紙 = 999;
    public static final int DEFAULT_封筒枚数 = 100;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT251TohyoYoshiMaisuKanriEntityGenerator() {
    }

    public static AfT251TohyoYoshiMaisuKanriEntity createAfT251TohyoYoshiMaisuKanriEntity() {
        return createAfT251TohyoYoshiMaisuKanriEntity(DEFAULT_抄本番号, DEFAULT_選挙番号);
    }

    public static AfT251TohyoYoshiMaisuKanriEntity createAfT251TohyoYoshiMaisuKanriEntity(ShohonNo shohonNo, SenkyoNo senkyoNo) {
        AfT251TohyoYoshiMaisuKanriEntity entity = new AfT251TohyoYoshiMaisuKanriEntity();
        entity.setShohonNo(shohonNo);
        entity.setSenkyoNo(senkyoNo);
        entity.setTohyokuCode(DEFAULT_投票区コード);
        entity.setTohyoYoshiMaisu(DEFAULT_投票用紙枚数);
        entity.setTenjiYoshiMaisu(DEFAULT_点字用紙);
        entity.setKariFutoMaisu(DEFAULT_封筒枚数);
        return entity;
    }

}
