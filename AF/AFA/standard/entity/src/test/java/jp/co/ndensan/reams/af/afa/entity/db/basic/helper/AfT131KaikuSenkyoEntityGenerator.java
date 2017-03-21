/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT131KaikuSenkyoEntity;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RYear;

/**
 * 農業_海区名簿更新日エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT131KaikuSenkyoEntityGenerator {

    public static final ShohonNo DEFAULT_抄本番号 = new ShohonNo(999991);
    public static final RYear DEFAULT_年度 = new RYear("2014");
    public static final FlexibleDate DEFAULT_名簿作成年月日 = new FlexibleDate("20140101");
    public static final FlexibleDate DEFAULT_名簿確定年月日 = new FlexibleDate("20140331");
    public static final FlexibleDate DEFAULT_名簿最新化年月日 = new FlexibleDate("20140331");
    public static final boolean DEFAULT_選挙時登録フラグ = Boolean.FALSE;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT131KaikuSenkyoEntityGenerator() {
    }

    public static AfT131KaikuSenkyoEntity createAfT131NogyoKaikuSenkyoEntity() {
        return createAfT131NogyoKaikuSenkyoEntity(DEFAULT_抄本番号, DEFAULT_年度);
    }

    public static AfT131KaikuSenkyoEntity createAfT131NogyoKaikuSenkyoEntity(ShohonNo shohonNo, RYear nendo) {
        AfT131KaikuSenkyoEntity entity = new AfT131KaikuSenkyoEntity();
        entity.setShohonNo(shohonNo);
        entity.setNendo(nendo);
        entity.setSakuseiYMD(DEFAULT_名簿作成年月日);
        entity.setKakuteiYMD(DEFAULT_名簿確定年月日);
        entity.setSaishinkaYMD(DEFAULT_名簿最新化年月日);
        entity.setSenkyojiTorokuFlag(DEFAULT_選挙時登録フラグ);
        return entity;
    }

}
