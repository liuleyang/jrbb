/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT302SaibaninYoteishaEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;

/**
 * 裁判員候補者予定者名簿エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT302SaibaninYoteishaEntityGenerator {

    public static final RYear DEFAULT_年度 = new RYear("9991");
    public static final int DEFAULT_選管通番 = 9990001;
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("123456789012");
    public static final AtenaMeisho DEFAULT_氏名 = new AtenaMeisho("テスト裁判員予定者名簿");
    public static final FlexibleDate DEFAULT_生年月日 = new FlexibleDate("19990919");
    public static final YubinNo DEFAULT_郵便番号 = YubinNo.EMPTY;
    public static final RString DEFAULT_住所 = RString.EMPTY;
    public static final RString DEFAULT_本籍地 = RString.EMPTY;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT302SaibaninYoteishaEntityGenerator() {
    }

    public static AfT302SaibaninYoteishaEntity createAfT302SaibaninYoteishaEntity() {
        return createAfT302SaibaninYoteishaEntity(DEFAULT_年度, DEFAULT_選管通番);
    }

    public static AfT302SaibaninYoteishaEntity createAfT302SaibaninYoteishaEntity(RYear nendo, int renban) {
        AfT302SaibaninYoteishaEntity entity = new AfT302SaibaninYoteishaEntity();
        entity.setNendo(nendo);
        entity.setSenkanRenban(renban);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setShimei(new AtenaMeisho(DEFAULT_氏名.toString() + nendo + "：連番" + renban));
        entity.setSeinengappiYMD(DEFAULT_生年月日);
        entity.setYubinNo(DEFAULT_郵便番号);
        entity.setJusho(DEFAULT_住所);
        entity.setHonsekichi(DEFAULT_本籍地);
        return entity;
    }

}
