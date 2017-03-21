/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT123ZaigaiSenkyoninJushoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.KatagakiCode;
import jp.co.ndensan.reams.uz.uza.biz.MailAddress;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在外選挙人国内住所情報エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤 礼恵
 */
public final class AfT123ZaigaiSenkyoninJushoEntityGenerator {

    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("999999999900001");
    public static final int DEFAULT_申請番号 = 999911;
    public static final Code DEFAULT_住所種類区分 = new Code("1");
    public static final YubinNo DEFAULT_郵便番号 = YubinNo.EMPTY;
    public static final ZenkokuJushoCode DEFAULT_全国住所コード = ZenkokuJushoCode.EMPTY;
    public static final AtenaJusho DEFAULT_住所 = new AtenaJusho("テスト在外選挙人国内住所情報");
    public static final AtenaBanchi DEFAULT_番地 = AtenaBanchi.EMPTY;
    public static final KatagakiCode DEFAULT_方書コード = KatagakiCode.EMPTY;
    public static final Katagaki DEFAULT_方書 = Katagaki.EMPTY;
    public static final RString DEFAULT_同居家族氏名 = RString.EMPTY;
    public static final RString DEFAULT_電話番号 = RString.EMPTY;
    public static final RString DEFAULT_FAX番号 = RString.EMPTY;
    public static final MailAddress DEFAULT_メールアドレス = MailAddress.EMPTY;
    public static final FlexibleDate DEFAULT_国外転出年月日 = FlexibleDate.EMPTY;
    public static final FlexibleDate DEFAULT_国内転入年月日 = FlexibleDate.EMPTY;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT123ZaigaiSenkyoninJushoEntityGenerator() {
    }

    public static AfT123ZaigaiSenkyoninJushoEntity createAfT123ZaigaiSenkyoninKokunaiJushoEntity() {
        return createAfT123ZaigaiSenkyoninKokunaiJushoEntity(DEFAULT_識別コード, DEFAULT_申請番号, DEFAULT_住所種類区分);
    }

    public static AfT123ZaigaiSenkyoninJushoEntity createAfT123ZaigaiSenkyoninKokunaiJushoEntity(
            ShikibetsuCode shikibetsuCode, int shinseiNo, Code jushoShuruiKubun) {
        AfT123ZaigaiSenkyoninJushoEntity entity = new AfT123ZaigaiSenkyoninJushoEntity();
        entity.setShikibetsuCode(shikibetsuCode);
        entity.setShinseiNo(shinseiNo);
        entity.setJushoShuruiKubun(jushoShuruiKubun);
        entity.setYubinNo(DEFAULT_郵便番号);
        entity.setZenkokuJushoCode(DEFAULT_全国住所コード);
        entity.setJusho(new AtenaJusho(DEFAULT_住所.toString() + shikibetsuCode + "：住所種類" + jushoShuruiKubun));
        entity.setBanchi(DEFAULT_番地);
        entity.setKatagakiCode(DEFAULT_方書コード);
        entity.setKatagaki(DEFAULT_方書);
        entity.setDokyoKazokuShimei(DEFAULT_同居家族氏名);
        entity.setTel(DEFAULT_電話番号);
        entity.setFax(DEFAULT_FAX番号);
        entity.setMail(DEFAULT_メールアドレス);
        entity.setKokugaiTenshutsuYMD(DEFAULT_国外転出年月日);
        entity.setKokunaiTennyuYMD(DEFAULT_国内転入年月日);
        return entity;
    }

}
