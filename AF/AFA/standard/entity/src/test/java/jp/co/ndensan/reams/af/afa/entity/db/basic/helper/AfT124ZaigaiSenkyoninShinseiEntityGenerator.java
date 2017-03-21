/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT124ZaigaiSenkyoninShinseiEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在外選挙人申請情報エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT124ZaigaiSenkyoninShinseiEntityGenerator {

    public static final int DEFAULT_申請番号 = 999991;
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("999999999900001");
    public static final FlexibleDate DEFAULT_住定年月日 = FlexibleDate.getNowDate();
    public static final RString DEFAULT_領事官コード = RString.EMPTY;
    public static final RString DEFAULT_国籍コード = RString.EMPTY;
    public static final AtenaMeisho DEFAULT_申請者氏名 = AtenaMeisho.EMPTY;
    public static final AtenaKanaMeisho DEFAULT_申請者カナ氏名 = AtenaKanaMeisho.EMPTY;
    public static final FlexibleDate DEFAULT_生年月日 = FlexibleDate.EMPTY;
    public static final RString DEFAULT_性別 = RString.EMPTY;
    public static final Code DEFAULT_申請区分 = new Code("1");
    public static final FlexibleDate DEFAULT_申請年月日 = FlexibleDate.getNowDate();
    public static final FlexibleDate DEFAULT_申請内容変更年月日 = FlexibleDate.EMPTY;
    public static final Code DEFAULT_申請内容変更事由コード = Code.EMPTY;
    public static final FlexibleDate DEFAULT_申請取下年月日 = FlexibleDate.EMPTY;
    public static final Code DEFAULT_申請取下事由コード = Code.EMPTY;
    public static final FlexibleDate DEFAULT_却下年月日 = FlexibleDate.EMPTY;
    public static final Code DEFAULT_却下事由コード = Code.EMPTY;
    public static final FlexibleDate DEFAULT_本籍地照会年月日 = FlexibleDate.EMPTY;
    public static final FlexibleDate DEFAULT_本籍地回答年月日 = FlexibleDate.EMPTY;
    public static final FlexibleDate DEFAULT_本籍地通知年月日 = FlexibleDate.EMPTY;
    public static final RString DEFAULT_特記事項 = new RString("テスト在外選挙人申請情報");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT124ZaigaiSenkyoninShinseiEntityGenerator() {
    }

    public static AfT124ZaigaiSenkyoninShinseiEntity createAfT124ZaigaiSenkyoninShinseiEntity() {
        return createAfT124ZaigaiSenkyoninShinseiEntity(DEFAULT_申請番号, DEFAULT_識別コード);
    }

    public static AfT124ZaigaiSenkyoninShinseiEntity createAfT124ZaigaiSenkyoninShinseiEntity(int shinseiNo, ShikibetsuCode shikibetsuCode) {
        AfT124ZaigaiSenkyoninShinseiEntity entity = new AfT124ZaigaiSenkyoninShinseiEntity();
        entity.setShinseiNo(shinseiNo);
        entity.setShikibetsuCode(shikibetsuCode);
        entity.setJuteiYMD(DEFAULT_住定年月日);
        entity.setRyojikanCode(DEFAULT_領事官コード);
        entity.setKokusekiCode(DEFAULT_国籍コード);
        entity.setShinseishaShimei(DEFAULT_申請者氏名);
        entity.setShinseishaKanaShimei(DEFAULT_申請者カナ氏名);
        entity.setSeinengappiYMD(DEFAULT_生年月日);
        entity.setSeibetsuCode(DEFAULT_性別);
        entity.setShinseiKubun(DEFAULT_申請区分);
        entity.setShinseiYMD(DEFAULT_申請年月日);
        entity.setHenkoYMD(DEFAULT_申請内容変更年月日);
        entity.setHenkoJiyuCode(DEFAULT_申請内容変更事由コード);
        entity.setTorisageYMD(DEFAULT_申請取下年月日);
        entity.setTorisageJiyuCode(DEFAULT_申請取下事由コード);
        entity.setKyakkaYMD(DEFAULT_却下年月日);
        entity.setKyakkaJiyuCode(DEFAULT_却下事由コード);
        entity.setHonsekiShokaiYMD(DEFAULT_本籍地照会年月日);
        entity.setHonsekiKaitoYMD(DEFAULT_本籍地回答年月日);
        entity.setHonsekiTsuchiYMD(DEFAULT_本籍地通知年月日);
        entity.setTokkiJiko(new RString(DEFAULT_特記事項.toString() + shinseiNo + "：識別コード" + shikibetsuCode));
        return entity;
    }

}
