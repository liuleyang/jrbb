/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT122ZaigaiSenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在外選挙資格エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT122ZaigaiSenkyoShikakuEntityGenerator {

    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("999999999900001");
    public static final int DEFAULT_申請番号 = 999911;
    public static final Code DEFAULT_国民投票区分 = new Code("1");
    public static final ShohonNo DEFAULT_国民投票抄本番号 = new ShohonNo(9999999);
    public static final Code DEFAULT_本籍地登録区分 = new Code("0");
    public static final RString DEFAULT_交付番号 = new RString("99202019990");
    public static final FlexibleDate DEFAULT_交付年月日 = FlexibleDate.getNowDate();
    public static final Code DEFAULT_選挙資格区分 = new Code("1");
    public static final RString DEFAULT_投票区コード = new RString("9991");
    public static final FlexibleDate DEFAULT_名簿登録年月日 = FlexibleDate.EMPTY;
    public static final FlexibleDate DEFAULT_表示年月日 = FlexibleDate.EMPTY;
    public static final Code DEFAULT_表示事由コード = Code.EMPTY;
    public static final FlexibleDate DEFAULT_抹消年月日 = FlexibleDate.EMPTY;
    public static final Code DEFAULT_抹消事由コード = Code.EMPTY;
    public static final Code DEFAULT_修正区分 = Code.EMPTY;
    public static final FlexibleDate DEFAULT_修正年月日 = FlexibleDate.EMPTY;
    public static final Code DEFAULT_再交付事由コード = Code.EMPTY;
    public static final Code DEFAULT_記載事項変更事由コード = Code.EMPTY;
    public static final RString DEFAULT_特記事項 = new RString("テスト在外選挙資格");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT122ZaigaiSenkyoShikakuEntityGenerator() {
    }

    public static AfT122ZaigaiSenkyoShikakuEntity createAfT122ZaigaiSenkyoShikakuEntity() {
        return createAfT122ZaigaiSenkyoShikakuEntity(DEFAULT_識別コード, DEFAULT_申請番号);
    }

    public static AfT122ZaigaiSenkyoShikakuEntity createAfT122ZaigaiSenkyoShikakuEntity(ShikibetsuCode shikibetsuCode, int shinseiNo) {
        AfT122ZaigaiSenkyoShikakuEntity entity = new AfT122ZaigaiSenkyoShikakuEntity();
        entity.setShikibetsuCode(shikibetsuCode);
        entity.setShinseiNo(shinseiNo);
        entity.setKokuminTohyoKubun(DEFAULT_国民投票区分);
        entity.setKokuminShohonNo(new ShohonNo(9999999));
        entity.setHonsekiTorokuKubun(DEFAULT_本籍地登録区分);
        entity.setKofuNo(DEFAULT_交付番号);
        entity.setKofuYMD(DEFAULT_交付年月日);
        entity.setShikakuKubun(DEFAULT_選挙資格区分);
        entity.setTohyokuCode(DEFAULT_投票区コード);
        entity.setMeiboTorokuYMD(DEFAULT_名簿登録年月日);
        entity.setHyojiYMD(DEFAULT_表示年月日);
        entity.setHyojiJiyuCode(DEFAULT_表示事由コード);
        entity.setMasshoYMD(DEFAULT_抹消年月日);
        entity.setMasshoJiyuCode(DEFAULT_抹消事由コード);
        entity.setShuseiKubun(DEFAULT_修正区分);
        entity.setShuseiYMD(DEFAULT_修正年月日);
        entity.setSaiKofuJiyuCode(DEFAULT_再交付事由コード);
        entity.setHenkoJiyuCode(DEFAULT_記載事項変更事由コード);
        entity.setTokkiJiko(new RString(DEFAULT_特記事項.toString() + shikibetsuCode.toString() + "：申請番号" + shinseiNo));
        return entity;
    }

}
