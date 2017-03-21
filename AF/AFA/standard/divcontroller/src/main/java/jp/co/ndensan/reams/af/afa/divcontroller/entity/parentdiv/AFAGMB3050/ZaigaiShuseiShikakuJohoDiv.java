package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB3050;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboBango.IMeiboBangoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboBango.MeiboBangoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.ITohyokuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.TohyokuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ZaigaiMeiboJoho.IZaigaiMeiboJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ZaigaiMeiboJoho.ZaigaiMeiboJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ZaigaiShuseiShikakuJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZaigaiShuseiShikakuJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ZaigaiShuseiMeiboJoho")
    private ZaigaiShuseiMeiboJohoDiv ZaigaiShuseiMeiboJoho;
    @JsonProperty("ccdZaigaiMeiboJoho")
    private ZaigaiMeiboJohoDiv ccdZaigaiMeiboJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getZaigaiShuseiMeiboJoho
     * @return ZaigaiShuseiMeiboJoho
     */
    @JsonProperty("ZaigaiShuseiMeiboJoho")
    public ZaigaiShuseiMeiboJohoDiv getZaigaiShuseiMeiboJoho() {
        return ZaigaiShuseiMeiboJoho;
    }

    /*
     * setZaigaiShuseiMeiboJoho
     * @param ZaigaiShuseiMeiboJoho ZaigaiShuseiMeiboJoho
     */
    @JsonProperty("ZaigaiShuseiMeiboJoho")
    public void setZaigaiShuseiMeiboJoho(ZaigaiShuseiMeiboJohoDiv ZaigaiShuseiMeiboJoho) {
        this.ZaigaiShuseiMeiboJoho = ZaigaiShuseiMeiboJoho;
    }

    /*
     * getccdZaigaiMeiboJoho
     * @return ccdZaigaiMeiboJoho
     */
    @JsonProperty("ccdZaigaiMeiboJoho")
    public IZaigaiMeiboJohoDiv getCcdZaigaiMeiboJoho() {
        return ccdZaigaiMeiboJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtGroupCode() {
        return this.getZaigaiShuseiMeiboJoho().getTxtGroupCode();
    }

    @JsonIgnore
    public void  setTxtGroupCode(TextBox txtGroupCode) {
        this.getZaigaiShuseiMeiboJoho().setTxtGroupCode(txtGroupCode);
    }

    @JsonIgnore
    public TextBox getTxtKokugaiBunruiCode() {
        return this.getZaigaiShuseiMeiboJoho().getTxtKokugaiBunruiCode();
    }

    @JsonIgnore
    public void  setTxtKokugaiBunruiCode(TextBox txtKokugaiBunruiCode) {
        this.getZaigaiShuseiMeiboJoho().setTxtKokugaiBunruiCode(txtKokugaiBunruiCode);
    }

    @JsonIgnore
    public ITohyokuCodeSelectDiv getCcdTohyokuCodeMeibo() {
        return this.getZaigaiShuseiMeiboJoho().getCcdTohyokuCodeMeibo();
    }

    @JsonIgnore
    public IMeiboBangoDiv getCcdMeiboBango() {
        return this.getZaigaiShuseiMeiboJoho().getCcdMeiboBango();
    }

    // </editor-fold>
}
