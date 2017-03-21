/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT133KaikuSenkyoFuzuiEntity;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 海区付随情報エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT133KaikuSenkyoFuzuiEntityGenerator {

    public static final ShohonNo DEFAULT_抄本番号 = new ShohonNo(999991);
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("999999999900001");
    public static final RString DEFAULT_漁業者番号 = DEFAULT_識別コード.getColumnValue().substring(5, 15);
    public static final int DEFAULT_漁業日数_漁業者 = 100;
    public static final int DEFAULT_漁業日数_漁業従事者 = 60;
    public static final Code DEFAULT_漁業種類 = Code.EMPTY;
    public static final Code DEFAULT_使用漁船種別 = Code.EMPTY;
    public static final RString DEFAULT_船名 = RString.EMPTY;
    public static final RString DEFAULT_登録番号 = RString.EMPTY;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT133KaikuSenkyoFuzuiEntityGenerator() {
    }

    public static AfT133KaikuSenkyoFuzuiEntity createAfT133KaikuSenkyoFuzuiEntity() {
        return createAfT133KaikuSenkyoFuzuiEntity(DEFAULT_抄本番号, DEFAULT_識別コード);
    }

    public static AfT133KaikuSenkyoFuzuiEntity createAfT133KaikuSenkyoFuzuiEntity(ShohonNo shohonNo, ShikibetsuCode shikibetsuCode) {
        AfT133KaikuSenkyoFuzuiEntity entity = new AfT133KaikuSenkyoFuzuiEntity();
        entity.setShohonNo(shohonNo);
        entity.setShikibetsuCode(shikibetsuCode);
        entity.setGyogyoshaNo(shikibetsuCode.value().substring(5, 15));
        entity.setNissuGyogyosha(DEFAULT_漁業日数_漁業者);
        entity.setNissuJujisha(DEFAULT_漁業日数_漁業従事者);
        entity.setGyogyoShurui(DEFAULT_漁業種類);
        entity.setGyosenShubetsu(DEFAULT_使用漁船種別);
        entity.setSenmei(DEFAULT_船名);
        entity.setTorokuNo(DEFAULT_登録番号);
        return entity;
    }

}
