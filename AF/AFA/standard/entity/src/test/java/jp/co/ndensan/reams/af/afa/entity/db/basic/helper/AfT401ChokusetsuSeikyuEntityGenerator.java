/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT401ChokusetsuSeikyuEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 直接請求エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT401ChokusetsuSeikyuEntityGenerator {

    public static final int DEFAULT_直接請求番号 = 9991;
    public static final FlexibleDate DEFAULT_請求年月日 = new FlexibleDate("20141212");
    public static final RString DEFAULT_請求名 = new RString("テスト直接請求名");
    public static final RString DEFAULT_請求内容 = RString.EMPTY;
    public static final FlexibleDate DEFAULT_交付年月日 = new FlexibleDate("20141215");
    public static final FlexibleDate DEFAULT_提出期限年月日 = new FlexibleDate("20150101");
    public static final Code DEFAULT_交付組織コード = Code.EMPTY;
    public static final boolean DEFAULT_署名簿登録済フラグ = Boolean.FALSE;
    public static final ShohonNo DEFAULT_抄本番号 = new ShohonNo(9991);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT401ChokusetsuSeikyuEntityGenerator() {
    }

    public static AfT401ChokusetsuSeikyuEntity createAfT401ChokusetsuSeikyuEntity() {
        return createAfT401ChokusetsuSeikyuEntity(DEFAULT_直接請求番号);
    }

    public static AfT401ChokusetsuSeikyuEntity createAfT401ChokusetsuSeikyuEntity(int seikyuNo) {
        AfT401ChokusetsuSeikyuEntity entity = new AfT401ChokusetsuSeikyuEntity();
        entity.setSeikyuNo(seikyuNo);
        entity.setSeikyuYMD(DEFAULT_請求年月日);
        entity.setSeikyuMei(new RString(DEFAULT_請求名.toString() + seikyuNo));
        entity.setSeikyuNaiyo(DEFAULT_請求内容);
        entity.setKofuYMD(DEFAULT_交付年月日);
        entity.setTeishutsuKigenYMD(DEFAULT_提出期限年月日);
        entity.setKofuSoshikiCode(DEFAULT_交付組織コード);
        entity.setTorokuZumiFlag(DEFAULT_署名簿登録済フラグ);
        entity.setShohonNo(DEFAULT_抄本番号);
        return entity;
    }

}
