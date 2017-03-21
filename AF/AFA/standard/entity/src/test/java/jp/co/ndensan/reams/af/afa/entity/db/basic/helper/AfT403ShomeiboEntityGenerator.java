/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT403ShomeiboEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 署名者名簿エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT403ShomeiboEntityGenerator {

    public static final int DEFAULT_直接請求番号 = 9991;
    public static final RString DEFAULT_冊 = new RString("99");
    public static final int DEFAULT_頁 = 999999;
    public static final int DEFAULT_行 = 1;
    public static final Code DEFAULT_審査区分 = new Code("1");
    public static final Code DEFAULT_無効事由コード = Code.EMPTY;
    public static final FlexibleDate DEFAULT_署名年月日 = new FlexibleDate("20140401");
    public static final ShikibetsuCode DEFAULT_署名者識別コード = new ShikibetsuCode("123456789012");
    public static final AtenaMeisho DEFAULT_漢字氏名 = new AtenaMeisho("テスト署名者名簿");
    public static final AtenaKanaMeisho DEFAULT_カナ氏名 = AtenaKanaMeisho.EMPTY;
    public static final AtenaKanaMeisho DEFAULT_検索用カナ氏名 = AtenaKanaMeisho.EMPTY;
    public static final FlexibleDate DEFAULT_生年月日 = new FlexibleDate("19990909");
    public static final RString DEFAULT_性別コード = new RString("1");
    public static final AtenaJusho DEFAULT_住所 = AtenaJusho.EMPTY;
    public static final ShikibetsuCode DEFAULT_代筆者識別コード = ShikibetsuCode.EMPTY;
    public static final AtenaMeisho DEFAULT_代筆者漢字氏名 = AtenaMeisho.EMPTY;
    public static final FlexibleDate DEFAULT_代筆者生年月日 = FlexibleDate.EMPTY;
    public static final RString DEFAULT_代筆者性別コード = RString.EMPTY;
    public static final AtenaJusho DEFAULT_代筆者住所 = AtenaJusho.EMPTY;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT403ShomeiboEntityGenerator() {
    }

    public static AfT403ShomeiboEntity createAfT403ShomeiboEntity() {
        return createAfT403ShomeiboEntity(DEFAULT_直接請求番号, DEFAULT_行);
    }

    public static AfT403ShomeiboEntity createAfT403ShomeiboEntity(int seikyuNo, int gyo) {
        AfT403ShomeiboEntity entity = new AfT403ShomeiboEntity();
        entity.setSeikyuNo(seikyuNo);
        entity.setSatsu(DEFAULT_冊);
        entity.setPage(DEFAULT_頁);
        entity.setGyo(gyo);
        entity.setShinsaKubun(DEFAULT_審査区分);
        entity.setMukoJiyuCode(DEFAULT_無効事由コード);
        entity.setShomeiYMD(DEFAULT_署名年月日);
        entity.setShomeishaShikibetsuCode(DEFAULT_署名者識別コード);
        entity.setKanjiShimei(new AtenaMeisho(DEFAULT_漢字氏名.toString() + seikyuNo + "：頁1：行" + gyo));
        entity.setKanaShimei(DEFAULT_カナ氏名);
        entity.setSearchKanaShimei(DEFAULT_検索用カナ氏名);
        entity.setSeinengappiYMD(DEFAULT_生年月日);
        entity.setSeibetsuCode(DEFAULT_性別コード);
        entity.setJusho(DEFAULT_住所);
        entity.setDaihitsushaShikibetsuCode(DEFAULT_代筆者識別コード);
        entity.setDaihitsushaKanjiShimei(DEFAULT_代筆者漢字氏名);
        entity.setDaihitsushaSeinengappiYMD(DEFAULT_代筆者生年月日);
        entity.setDaihitsushaSeibetsuCode(DEFAULT_代筆者性別コード);
        entity.setDaihitsushaJusho(DEFAULT_代筆者住所);
        return entity;
    }

}
