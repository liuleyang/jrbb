/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙人名簿エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤礼恵
 */
public final class AfT112SenkyoninMeiboEntityGenerator {

    public static final ShohonNo DEFAULT_抄本番号999991 = new ShohonNo(999991);
    public static final ShohonNo DEFAULT_抄本番号999992 = new ShohonNo(999992);
    public static final ShohonNo DEFAULT_抄本番号999999 = new ShohonNo(999999);
    public static final RString DEFAULT_グループコード = new RString("0");
    public static final RString DEFAULT_投票区コード = new RString("0001");
    public static final RString DEFAULT_冊 = new RString("00");
    public static final int DEFAULT_頁 = 1;
    public static final int DEFAULT_行 = 1;
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("999999999900001");
    public static final boolean DEFAULT_投票区変更抹消フラグ = Boolean.FALSE;
    public static final int DEFAULT_連番 = 1;
    public static final int DEFAULT_枝番 = 0;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT112SenkyoninMeiboEntityGenerator() {
    }

    public static AfT112SenkyoninMeiboEntity createAfT112SenkyoninMeiboEntity() {
        return createAfT112SenkyoninMeiboEntity(DEFAULT_抄本番号999991, DEFAULT_頁);
    }

    public static AfT112SenkyoninMeiboEntity createAfT112SenkyoninMeiboEntity(ShohonNo shohonNo, int gyo) {
        AfT112SenkyoninMeiboEntity entity = new AfT112SenkyoninMeiboEntity();
        entity.setShohonNo(shohonNo);
        entity.setGroupCode(DEFAULT_グループコード);
        entity.setTohyokuCode(DEFAULT_投票区コード);
        entity.setSatsu(DEFAULT_冊);
        entity.setPage(DEFAULT_頁);
        entity.setGyo(gyo);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setTohyokuHenkoMasshoFlag(DEFAULT_投票区変更抹消フラグ);
        entity.setRenban(DEFAULT_連番);
        entity.setEdaban(DEFAULT_枝番);
        return entity;
    }

}
