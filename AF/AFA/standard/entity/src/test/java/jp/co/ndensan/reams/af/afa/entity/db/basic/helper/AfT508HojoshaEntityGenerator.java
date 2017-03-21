/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT508HojoshaEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 補助者エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT508HojoshaEntityGenerator {

    public static final ShohonNo DEFAULT_抄本番号 = new ShohonNo(999991);
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("999999999900001");
    public static final RString DEFAULT_投票所コード = RString.EMPTY;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT508HojoshaEntityGenerator() {
    }

    public static AfT508HojoshaEntity createAfT508HojoshaEntity() {
        return createAfT508HojoshaEntity(DEFAULT_抄本番号, DEFAULT_識別コード);
    }

    public static AfT508HojoshaEntity createAfT508HojoshaEntity(ShohonNo shohonNo, ShikibetsuCode shikibetsuCode) {
        AfT508HojoshaEntity entity = new AfT508HojoshaEntity();
        entity.setShohonNo(shohonNo);
        entity.setShikibetsuCode(shikibetsuCode);
        entity.setTohyojoCode(DEFAULT_投票所コード);
        return entity;
    }

}
