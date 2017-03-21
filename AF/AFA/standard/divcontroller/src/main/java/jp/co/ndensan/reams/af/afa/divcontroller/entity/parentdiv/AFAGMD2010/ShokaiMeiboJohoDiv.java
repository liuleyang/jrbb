package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMD2010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboBango.IMeiboBangoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboBango.MeiboBangoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.ITohyokuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.TohyokuCodeSelectDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShokaiMeiboJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokaiMeiboJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-04-25_11-07-54">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtGroupCode")
    private TextBox txtGroupCode;
    @JsonProperty("txtKokugaiBunruiCode")
    private TextBox txtKokugaiBunruiCode;
    @JsonProperty("ccdTohyokuCodeMeibo")
    private TohyokuCodeSelectDiv ccdTohyokuCodeMeibo;
    @JsonProperty("ccdMeiboBango")
    private MeiboBangoDiv ccdMeiboBango;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtGroupCode
     * @return txtGroupCode
     */
    @JsonProperty("txtGroupCode")
    public TextBox getTxtGroupCode() {
        return txtGroupCode;
    }

    /*
     * settxtGroupCode
     * @param txtGroupCode txtGroupCode
     */
    @JsonProperty("txtGroupCode")
    public void setTxtGroupCode(TextBox txtGroupCode) {
        this.txtGroupCode = txtGroupCode;
    }

    /*
     * gettxtKokugaiBunruiCode
     * @return txtKokugaiBunruiCode
     */
    @JsonProperty("txtKokugaiBunruiCode")
    public TextBox getTxtKokugaiBunruiCode() {
        return txtKokugaiBunruiCode;
    }

    /*
     * settxtKokugaiBunruiCode
     * @param txtKokugaiBunruiCode txtKokugaiBunruiCode
     */
    @JsonProperty("txtKokugaiBunruiCode")
    public void setTxtKokugaiBunruiCode(TextBox txtKokugaiBunruiCode) {
        this.txtKokugaiBunruiCode = txtKokugaiBunruiCode;
    }

    /*
     * getccdTohyokuCodeMeibo
     * @return ccdTohyokuCodeMeibo
     */
    @JsonProperty("ccdTohyokuCodeMeibo")
    public ITohyokuCodeSelectDiv getCcdTohyokuCodeMeibo() {
        return ccdTohyokuCodeMeibo;
    }

    /*
     * getccdMeiboBango
     * @return ccdMeiboBango
     */
    @JsonProperty("ccdMeiboBango")
    public IMeiboBangoDiv getCcdMeiboBango() {
        return ccdMeiboBango;
    }

    // </editor-fold>
}
