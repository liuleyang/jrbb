package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @reamsid_L AF-0620-033 wangh
 */
public class AtenaSealGroupSource {

    private RString yubinno;
    private RString jushoa;
    private RString jushob;
    private RString jushoc;
    private RString jushola;
    private RString jusholb;
    private RString jusholc;
    private RString jushold;
    private RString atenaa;
    private RString atenab;
    private RString atenala;
    private RString atenalb;
    private RString koumokua;
    private RString koumokub;
    private RString koumokuc;
    private RString barcodeBarcode;
    private RString jushoList;
    private RString meishoList;
    private ShikibetsuCode shikibetsuCode;

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号 RString
     */
    public RString getYubinno() {
        return yubinno;
    }

    /**
     * 住所（上段）を返します。
     *
     * @return 住所（上段） RString
     */
    public RString getJushoa() {
        return jushoa;
    }

    /**
     * 名所Listを返します。
     *
     * @return 名所List RString
     */
    public RString getMeishoList() {
        return meishoList;
    }

    /**
     * 住所Listを返します。
     *
     * @return 住所List RString
     */
    public RString getJushoList() {
        return jushoList;
    }

    /**
     * 住所（中段）を返します。
     *
     * @return 住所（中段） RString
     */
    public RString getJushob() {
        return jushob;
    }

    /**
     * 住所（下段）を返します。
     *
     * @return 住所（下段）RString
     */
    public RString getJushoc() {
        return jushoc;
    }

    /**
     * 小-住所（１段目）を返します。
     *
     * @return 小-住所（１段目）RString
     */
    public RString getJushola() {
        return jushola;
    }

    /**
     * 小-住所（２段目）を返します。
     *
     * @return 小-住所（２段目） RString
     */
    public RString getJusholb() {
        return jusholb;
    }

    /**
     * 小-住所（３段目）を返します。
     *
     * @return 小-住所（３段目） RString
     */
    public RString getJusholc() {
        return jusholc;
    }

    /**
     * 小-住所（４段目）を返します。
     *
     * @return 小-住所（４段目）RString
     */
    public RString getJushold() {
        return jushold;
    }

    /**
     * 宛名（上段）を返します。
     *
     * @return 宛名（上段）RString
     */
    public RString getAtenaa() {
        return atenaa;
    }

    /**
     * 宛名（下段）を返します。
     *
     * @return 宛名（下段） RString
     */
    public RString getAtenab() {
        return atenab;
    }

    /**
     * 小-宛名（上段）を返します。
     *
     * @return 小-宛名（上段） RString
     */
    public RString getAtenala() {
        return atenala;
    }

    /**
     * 小-宛名（下段）を返します。
     *
     * @return 小-宛名（下段） RString
     */
    public RString getAtenalb() {
        return atenalb;
    }

    /**
     * 左下隅の項目を返します。
     *
     * @return 左下隅の項目 RString
     */
    public RString getKoumokua() {
        return koumokua;
    }

    /**
     * 右下隅の項目を返します。
     *
     * @return 右下隅の項目 RString
     */
    public RString getKoumokub() {
        return koumokub;
    }

    /**
     * 右上隅の項目を返します。
     *
     * @return 右上隅の項目 RString
     */
    public RString getKoumokuc() {
        return koumokuc;
    }

    /**
     * 郵便番号を設定します。
     *
     * @param yubinno RString
     */
    public void setYubinno(RString yubinno) {
        this.yubinno = yubinno;
    }

    /**
     * 住所（上段）を設定します。
     *
     * @param jushoa RString
     */
    public void setJushoa(RString jushoa) {
        this.jushoa = jushoa;
    }

    /**
     * 住所（中段）を設定します。
     *
     * @param jushob RString
     */
    public void setJushob(RString jushob) {
        this.jushob = jushob;
    }

    /**
     * 住所（下段）を設定します。
     *
     * @param jushoc RString
     */
    public void setJushoc(RString jushoc) {
        this.jushoc = jushoc;
    }

    /**
     * 小-住所（１段目）を設定します。
     *
     * @param jushola RString
     */
    public void setJushola(RString jushola) {
        this.jushola = jushola;
    }

    /**
     * 小-住所（２段目）を設定します。
     *
     * @param jusholb RString
     */
    public void setJusholb(RString jusholb) {
        this.jusholb = jusholb;
    }

    /**
     * 小-住所（３段目）を設定します。
     *
     * @param jusholc RString
     */
    public void setJusholc(RString jusholc) {
        this.jusholc = jusholc;
    }

    /**
     * 小-住所（４段目）を設定します。
     *
     * @param jushold RString
     */
    public void setJushold(RString jushold) {
        this.jushold = jushold;
    }

    /**
     * 住所Listを設定します。
     *
     * @param jushoList RString
     */
    public void setJushoList(RString jushoList) {
        this.jushoList = jushoList;
    }

    /**
     * 名所Listを設定します。
     *
     * @param meishoList RString
     */
    public void setMeishoList(RString meishoList) {
        this.meishoList = meishoList;
    }

    /**
     * 宛名（上段）を設定します。
     *
     * @param atenaa RString
     */
    public void setAtenaa(RString atenaa) {
        this.atenaa = atenaa;
    }

    /**
     * 宛名（下段）を設定します。
     *
     * @param atenab RString
     */
    public void setAtenab(RString atenab) {
        this.atenab = atenab;
    }

    /**
     * 小-宛名（上段）を設定します。
     *
     * @param atenala RString
     */
    public void setAtenala(RString atenala) {
        this.atenala = atenala;
    }

    /**
     * 小-宛名（下段）を設定します。
     *
     * @param atenalb RString
     */
    public void setAtenalb(RString atenalb) {
        this.atenalb = atenalb;
    }

    /**
     * 左下隅の項目を設定します。
     *
     * @param koumokua RString
     */
    public void setKoumokua(RString koumokua) {
        this.koumokua = koumokua;
    }

    /**
     * 右下隅の項目を設定します。
     *
     * @param koumokub RString
     */
    public void setKoumokub(RString koumokub) {
        this.koumokub = koumokub;
    }

    /**
     * 右上隅の項目を設定します。
     *
     * @param koumokuc RString
     */
    public void setKoumokuc(RString koumokuc) {
        this.koumokuc = koumokuc;
    }

    /**
     * カスタマバーコードを返します。
     *
     * @return カスタマバーコード RString
     */
    public RString getBarcodeBarcode() {
        return barcodeBarcode;
    }

    /**
     * カスタマバーコードを設定します。
     *
     * @param barcodeBarcode RString
     */
    public void setBarcodeBarcode(RString barcodeBarcode) {
        this.barcodeBarcode = barcodeBarcode;
    }

    /**
     * shikibetsuCodeを返します。
     *
     * @return shikibetsuCode ShikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * shikibetsuCodeを設定します。
     *
     * @param shikibetsuCode ShikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

}
