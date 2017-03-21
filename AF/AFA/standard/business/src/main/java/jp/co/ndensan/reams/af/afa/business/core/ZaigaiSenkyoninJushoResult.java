/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import java.io.Serializable;
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
 * 在外選挙人住所情報
 *
 * @reamsid_L AF-0320-010 lis
 */
public class ZaigaiSenkyoninJushoResult {

    private AfT123ZaigaiSenkyoninJushoEntity entity;

    /**
     * コンストラクタです。
     */
    public ZaigaiSenkyoninJushoResult() {
        entity = new AfT123ZaigaiSenkyoninJushoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity AfT123ZaigaiSenkyoninJushoEntity
     */
    public ZaigaiSenkyoninJushoResult(AfT123ZaigaiSenkyoninJushoEntity entity) {
        this.entity = entity;
    }

    /**
     * AfT123ZaigaiSenkyoninJushoEntityを返します。
     *
     * @return AfT123ZaigaiSenkyoninJushoEntity
     */
    public AfT123ZaigaiSenkyoninJushoEntity getEntity() {
        return entity;
    }

    /**
     * AfT123ZaigaiSenkyoninJushoEntityを設定します。
     *
     * @param entity AfT123ZaigaiSenkyoninJushoEntity
     */
    public void setEntity(AfT123ZaigaiSenkyoninJushoEntity entity) {
        this.entity = entity;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return this.entity.getShikibetsuCode();
    }

    /**
     * 申請番号を返します。
     *
     * @return 申請番号
     */
    public int get申請番号() {
        return this.entity.getShinseiNo();
    }

    /**
     * 住所種類区分を返します。
     *
     * @return 住所種類区分
     */
    public Code get住所種類区分() {
        return this.entity.getJushoShuruiKubun();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return this.entity.getYubinNo();
    }

    /**
     * 全国住所コードを返します。
     *
     * @return 全国住所コード
     */
    public ZenkokuJushoCode get全国住所コード() {
        return this.entity.getZenkokuJushoCode();
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return this.entity.getJusho();
    }

    /**
     * 番地を返します。
     *
     * @return 番地
     */
    public AtenaBanchi get番地() {
        return this.entity.getBanchi();
    }

    /**
     * 方書コードを返します。
     *
     * @return 方書コード
     */
    public KatagakiCode get方書コード() {
        return this.entity.getKatagakiCode();
    }

    /**
     * 方書を返します。
     *
     * @return 方書
     */
    public Katagaki get方書() {
        return this.entity.getKatagaki();
    }

    /**
     * 同居家族氏名を返します。
     *
     * @return 同居家族氏名
     */
    public RString get同居家族氏名() {
        return this.entity.getDokyoKazokuShimei();
    }

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    public RString get電話番号() {
        return this.entity.getTel();
    }

    /**
     * FAX番号を返します。
     *
     * @return FAX番号
     */
    public RString getFAX番号() {
        return this.entity.getFax();
    }

    /**
     * メールアドレスを返します。
     *
     * @return メールアドレス
     */
    public MailAddress getメールアドレス() {
        return this.entity.getMail();
    }

    /**
     * 国外転出年月日を返します。
     *
     * @return 国外転出年月日
     */
    public FlexibleDate get国外転出年月日() {
        return this.entity.getKokugaiTenshutsuYMD();
    }

    /**
     * 国内転入年月日を返します。
     *
     * @return 国内転入年月日
     */
    public FlexibleDate get国内転入年月日() {
        return this.entity.getKokunaiTennyuYMD();
    }

    /**
     * 識別コードを設定します。
     *
     * @param shikibetsuCode 識別コード
     */
    public void set識別コード(ShikibetsuCode shikibetsuCode) {
        this.entity.setShikibetsuCode(shikibetsuCode);
    }

    /**
     * 申請番号を設定します。
     *
     * @param shinseiNo 申請番号
     */
    public void set申請番号(int shinseiNo) {
        this.entity.setShinseiNo(shinseiNo);
    }

    /**
     * 住所種類区分を設定します。
     *
     * @param jushoShuruiKubun 住所種類区分
     */
    public void set住所種類区分(Code jushoShuruiKubun) {
        this.entity.setJushoShuruiKubun(jushoShuruiKubun);
    }

    /**
     * 郵便番号を設定します。
     *
     * @param yubinNo 郵便番号
     */
    public void set郵便番号(YubinNo yubinNo) {
        this.entity.setYubinNo(yubinNo);
    }

    /**
     * 全国住所コードを設定します。
     *
     * @param zenkokuJushoCode 全国住所コード
     */
    public void set全国住所コード(ZenkokuJushoCode zenkokuJushoCode) {
        this.entity.setZenkokuJushoCode(zenkokuJushoCode);
    }

    /**
     * 住所を設定します。
     *
     * @param jusho 住所
     */
    public void set住所(AtenaJusho jusho) {
        this.entity.setJusho(jusho);
    }

    /**
     * 番地を設定します。
     *
     * @param banchi 番地
     */
    public void set番地(AtenaBanchi banchi) {
        this.entity.setBanchi(banchi);
    }

    /**
     * 方書コードを設定します。
     *
     * @param katagakiCode 方書コード
     */
    public void set方書コード(KatagakiCode katagakiCode) {
        this.entity.setKatagakiCode(katagakiCode);
    }

    /**
     * 方書を設定します。
     *
     * @param katagaki 方書
     */
    public void set方書(Katagaki katagaki) {
        this.entity.setKatagaki(katagaki);
    }

    /**
     * 同居家族氏名を設定します。
     *
     * @param dokyoKazokuShimei 同居家族氏名
     */
    public void set同居家族氏名(RString dokyoKazokuShimei) {
        this.entity.setDokyoKazokuShimei(dokyoKazokuShimei);
    }

    /**
     * 電話番号を設定します。
     *
     * @param tel 電話番号
     */
    public void set電話番号(RString tel) {
        this.entity.setTel(tel);
    }

    /**
     * FAX番号を設定します。
     *
     * @param fax FAX番号
     */
    public void setFAX番号(RString fax) {
        this.entity.setFax(fax);
    }

    /**
     * メールアドレスを設定します。
     *
     * @param mail メールアドレス
     */
    public void setメールアドレス(MailAddress mail) {
        this.entity.setMail(mail);
    }

    /**
     * 国外転出年月日を設定します。
     *
     * @param kokugaiTenshutsuYMD 国外転出年月日
     */
    public void set国外転出年月日(FlexibleDate kokugaiTenshutsuYMD) {
        this.entity.setKokugaiTenshutsuYMD(kokugaiTenshutsuYMD);
    }

    /**
     * 国内転入年月日を設定します。
     *
     * @param kokunaiTennyuYMD 国内転入年月日
     */
    public void set国内転入年月日(FlexibleDate kokunaiTennyuYMD) {
        this.entity.setKokunaiTennyuYMD(kokunaiTennyuYMD);
    }

    /**
     * このオブジェクトのシリアライズ形式を提供します。 戻り値である{@link Serializable}のインスタンスは、デシリアライズ時に、このオブジェクトを生成します。
     *
     * @return このオブジェクトのシリアライズ形式
     */
    public Serializable serialize() {
        return new _SerializationProxy(this);
    }

    private static final class _SerializationProxy implements Serializable {

        private final AfT123ZaigaiSenkyoninJushoEntity zaigaiSenkyoninJushoEntity;
        private static final long serialVersionUID = 351900186803745749L;

        private _SerializationProxy(ZaigaiSenkyoninJushoResult result) {
            this.zaigaiSenkyoninJushoEntity = result.getEntity();
        }

        private Object readResolve() {
            return new ZaigaiSenkyoninJushoResult(zaigaiSenkyoninJushoEntity);
        }
    }
}
