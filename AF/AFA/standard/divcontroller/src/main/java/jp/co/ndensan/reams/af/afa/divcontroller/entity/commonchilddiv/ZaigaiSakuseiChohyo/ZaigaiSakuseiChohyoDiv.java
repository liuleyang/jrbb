package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ZaigaiSakuseiChohyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ZaigaiSakuseiChohyo のクラスファイル
 *
 * @reamsid_L AF-0320-012 zhanggs
 */
public class ZaigaiSakuseiChohyoDiv extends Panel implements IZaigaiSakuseiChohyoDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchi")
    private ZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchiDiv ZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchi;
    @JsonProperty("ZaigaiSakuseiChohyoTorikeshiHonnin")
    private ZaigaiSakuseiChohyoTorikeshiHonninDiv ZaigaiSakuseiChohyoTorikeshiHonnin;
    @JsonProperty("ZaigaiSakuseiChohyoTorikeshiRyojikan")
    private ZaigaiSakuseiChohyoTorikeshiRyojikanDiv ZaigaiSakuseiChohyoTorikeshiRyojikan;
    @JsonProperty("ZaigaiSakuseiChohyoToroku")
    private ZaigaiSakuseiChohyoTorokuDiv ZaigaiSakuseiChohyoToroku;
    @JsonProperty("ZaigaiSakuseiChohyoHenkoHonnin")
    private ZaigaiSakuseiChohyoHenkoHonninDiv ZaigaiSakuseiChohyoHenkoHonnin;
    @JsonProperty("ZaigaiSakuseiChohyoHenkoRyojikan")
    private ZaigaiSakuseiChohyoHenkoRyojikanDiv ZaigaiSakuseiChohyoHenkoRyojikan;
    @JsonProperty("ZaigaiSakuseiChohyoSaiKofu")
    private ZaigaiSakuseiChohyoSaiKofuDiv ZaigaiSakuseiChohyoSaiKofu;
    @JsonProperty("ZaigaiSakuseiChohyoMasshoHonsekichi")
    private ZaigaiSakuseiChohyoMasshoHonsekichiDiv ZaigaiSakuseiChohyoMasshoHonsekichi;
    @JsonProperty("ZaigaiSakuseiChohyoMasshoRyojikan")
    private ZaigaiSakuseiChohyoMasshoRyojikanDiv ZaigaiSakuseiChohyoMasshoRyojikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchi
     * @return ZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchi
     */
    @JsonProperty("ZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchi")
    @Override
    public ZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchiDiv getZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchi() {
        return ZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchi;
    }

    /*
     * setZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchi
     * @param ZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchi ZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchi
     */
    @JsonProperty("ZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchi")
    public void setZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchi(ZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchiDiv ZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchi) {
        this.ZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchi = ZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchi;
    }

    /*
     * getZaigaiSakuseiChohyoTorikeshiHonnin
     * @return ZaigaiSakuseiChohyoTorikeshiHonnin
     */
    @JsonProperty("ZaigaiSakuseiChohyoTorikeshiHonnin")
    @Override
    public ZaigaiSakuseiChohyoTorikeshiHonninDiv getZaigaiSakuseiChohyoTorikeshiHonnin() {
        return ZaigaiSakuseiChohyoTorikeshiHonnin;
    }

    /*
     * setZaigaiSakuseiChohyoTorikeshiHonnin
     * @param ZaigaiSakuseiChohyoTorikeshiHonnin ZaigaiSakuseiChohyoTorikeshiHonnin
     */
    @JsonProperty("ZaigaiSakuseiChohyoTorikeshiHonnin")
    public void setZaigaiSakuseiChohyoTorikeshiHonnin(ZaigaiSakuseiChohyoTorikeshiHonninDiv ZaigaiSakuseiChohyoTorikeshiHonnin) {
        this.ZaigaiSakuseiChohyoTorikeshiHonnin = ZaigaiSakuseiChohyoTorikeshiHonnin;
    }

    /*
     * getZaigaiSakuseiChohyoTorikeshiRyojikan
     * @return ZaigaiSakuseiChohyoTorikeshiRyojikan
     */
    @JsonProperty("ZaigaiSakuseiChohyoTorikeshiRyojikan")
    @Override
    public ZaigaiSakuseiChohyoTorikeshiRyojikanDiv getZaigaiSakuseiChohyoTorikeshiRyojikan() {
        return ZaigaiSakuseiChohyoTorikeshiRyojikan;
    }

    /*
     * setZaigaiSakuseiChohyoTorikeshiRyojikan
     * @param ZaigaiSakuseiChohyoTorikeshiRyojikan ZaigaiSakuseiChohyoTorikeshiRyojikan
     */
    @JsonProperty("ZaigaiSakuseiChohyoTorikeshiRyojikan")
    public void setZaigaiSakuseiChohyoTorikeshiRyojikan(ZaigaiSakuseiChohyoTorikeshiRyojikanDiv ZaigaiSakuseiChohyoTorikeshiRyojikan) {
        this.ZaigaiSakuseiChohyoTorikeshiRyojikan = ZaigaiSakuseiChohyoTorikeshiRyojikan;
    }

    /*
     * getZaigaiSakuseiChohyoToroku
     * @return ZaigaiSakuseiChohyoToroku
     */
    @JsonProperty("ZaigaiSakuseiChohyoToroku")
    @Override
    public ZaigaiSakuseiChohyoTorokuDiv getZaigaiSakuseiChohyoToroku() {
        return ZaigaiSakuseiChohyoToroku;
    }

    /*
     * setZaigaiSakuseiChohyoToroku
     * @param ZaigaiSakuseiChohyoToroku ZaigaiSakuseiChohyoToroku
     */
    @JsonProperty("ZaigaiSakuseiChohyoToroku")
    public void setZaigaiSakuseiChohyoToroku(ZaigaiSakuseiChohyoTorokuDiv ZaigaiSakuseiChohyoToroku) {
        this.ZaigaiSakuseiChohyoToroku = ZaigaiSakuseiChohyoToroku;
    }

    /*
     * getZaigaiSakuseiChohyoHenkoHonnin
     * @return ZaigaiSakuseiChohyoHenkoHonnin
     */
    @JsonProperty("ZaigaiSakuseiChohyoHenkoHonnin")
    @Override
    public ZaigaiSakuseiChohyoHenkoHonninDiv getZaigaiSakuseiChohyoHenkoHonnin() {
        return ZaigaiSakuseiChohyoHenkoHonnin;
    }

    /*
     * setZaigaiSakuseiChohyoHenkoHonnin
     * @param ZaigaiSakuseiChohyoHenkoHonnin ZaigaiSakuseiChohyoHenkoHonnin
     */
    @JsonProperty("ZaigaiSakuseiChohyoHenkoHonnin")
    public void setZaigaiSakuseiChohyoHenkoHonnin(ZaigaiSakuseiChohyoHenkoHonninDiv ZaigaiSakuseiChohyoHenkoHonnin) {
        this.ZaigaiSakuseiChohyoHenkoHonnin = ZaigaiSakuseiChohyoHenkoHonnin;
    }

    /*
     * getZaigaiSakuseiChohyoHenkoRyojikan
     * @return ZaigaiSakuseiChohyoHenkoRyojikan
     */
    @JsonProperty("ZaigaiSakuseiChohyoHenkoRyojikan")
    @Override
    public ZaigaiSakuseiChohyoHenkoRyojikanDiv getZaigaiSakuseiChohyoHenkoRyojikan() {
        return ZaigaiSakuseiChohyoHenkoRyojikan;
    }

    /*
     * setZaigaiSakuseiChohyoHenkoRyojikan
     * @param ZaigaiSakuseiChohyoHenkoRyojikan ZaigaiSakuseiChohyoHenkoRyojikan
     */
    @JsonProperty("ZaigaiSakuseiChohyoHenkoRyojikan")
    public void setZaigaiSakuseiChohyoHenkoRyojikan(ZaigaiSakuseiChohyoHenkoRyojikanDiv ZaigaiSakuseiChohyoHenkoRyojikan) {
        this.ZaigaiSakuseiChohyoHenkoRyojikan = ZaigaiSakuseiChohyoHenkoRyojikan;
    }

    /*
     * getZaigaiSakuseiChohyoSaiKofu
     * @return ZaigaiSakuseiChohyoSaiKofu
     */
    @JsonProperty("ZaigaiSakuseiChohyoSaiKofu")
    @Override
    public ZaigaiSakuseiChohyoSaiKofuDiv getZaigaiSakuseiChohyoSaiKofu() {
        return ZaigaiSakuseiChohyoSaiKofu;
    }

    /*
     * setZaigaiSakuseiChohyoSaiKofu
     * @param ZaigaiSakuseiChohyoSaiKofu ZaigaiSakuseiChohyoSaiKofu
     */
    @JsonProperty("ZaigaiSakuseiChohyoSaiKofu")
    public void setZaigaiSakuseiChohyoSaiKofu(ZaigaiSakuseiChohyoSaiKofuDiv ZaigaiSakuseiChohyoSaiKofu) {
        this.ZaigaiSakuseiChohyoSaiKofu = ZaigaiSakuseiChohyoSaiKofu;
    }

    /*
     * getZaigaiSakuseiChohyoMasshoHonsekichi
     * @return ZaigaiSakuseiChohyoMasshoHonsekichi
     */
    @JsonProperty("ZaigaiSakuseiChohyoMasshoHonsekichi")
    @Override
    public ZaigaiSakuseiChohyoMasshoHonsekichiDiv getZaigaiSakuseiChohyoMasshoHonsekichi() {
        return ZaigaiSakuseiChohyoMasshoHonsekichi;
    }

    /*
     * setZaigaiSakuseiChohyoMasshoHonsekichi
     * @param ZaigaiSakuseiChohyoMasshoHonsekichi ZaigaiSakuseiChohyoMasshoHonsekichi
     */
    @JsonProperty("ZaigaiSakuseiChohyoMasshoHonsekichi")
    public void setZaigaiSakuseiChohyoMasshoHonsekichi(ZaigaiSakuseiChohyoMasshoHonsekichiDiv ZaigaiSakuseiChohyoMasshoHonsekichi) {
        this.ZaigaiSakuseiChohyoMasshoHonsekichi = ZaigaiSakuseiChohyoMasshoHonsekichi;
    }

    /*
     * getZaigaiSakuseiChohyoMasshoRyojikan
     * @return ZaigaiSakuseiChohyoMasshoRyojikan
     */
    @JsonProperty("ZaigaiSakuseiChohyoMasshoRyojikan")
    @Override
    public ZaigaiSakuseiChohyoMasshoRyojikanDiv getZaigaiSakuseiChohyoMasshoRyojikan() {
        return ZaigaiSakuseiChohyoMasshoRyojikan;
    }

    /*
     * setZaigaiSakuseiChohyoMasshoRyojikan
     * @param ZaigaiSakuseiChohyoMasshoRyojikan ZaigaiSakuseiChohyoMasshoRyojikan
     */
    @JsonProperty("ZaigaiSakuseiChohyoMasshoRyojikan")
    public void setZaigaiSakuseiChohyoMasshoRyojikan(ZaigaiSakuseiChohyoMasshoRyojikanDiv ZaigaiSakuseiChohyoMasshoRyojikan) {
        this.ZaigaiSakuseiChohyoMasshoRyojikan = ZaigaiSakuseiChohyoMasshoRyojikan;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(RString... shinseiJotai) {
        getHandler().initialize(shinseiJotai);
    }

    @JsonIgnore
    public ZaigaiSakuseiChohyoHandler getHandler() {
        return new ZaigaiSakuseiChohyoHandler(this);
    }

}
