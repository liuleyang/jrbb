package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME3010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.ITohyokuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.TohyokuCodeSelectDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TojitsuTohyoJokyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class TojitsuTohyoJokyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radSenkyoNo")
    private RadioButton radSenkyoNo;
    @JsonProperty("radShukeiTani")
    private RadioButton radShukeiTani;
    @JsonProperty("txtTime")
    private TextBoxTime txtTime;
    @JsonProperty("btnSaishinka")
    private Button btnSaishinka;
    @JsonProperty("dgTojitsuTohyoShukei")
    private DataGrid<dgTojitsuTohyoShukei_Row> dgTojitsuTohyoShukei;
    @JsonProperty("ccdTojitsuTohyokuCode")
    private TohyokuCodeSelectDiv ccdTojitsuTohyokuCode;
    @JsonProperty("txtHdnShohonNo")
    private RString txtHdnShohonNo;
    @JsonProperty("txtHdnSenkyoShurui")
    private RString txtHdnSenkyoShurui;
    @JsonProperty("txtHdnTohyokuCode")
    private RString txtHdnTohyokuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradSenkyoNo
     * @return radSenkyoNo
     */
    @JsonProperty("radSenkyoNo")
    public RadioButton getRadSenkyoNo() {
        return radSenkyoNo;
    }

    /*
     * setradSenkyoNo
     * @param radSenkyoNo radSenkyoNo
     */
    @JsonProperty("radSenkyoNo")
    public void setRadSenkyoNo(RadioButton radSenkyoNo) {
        this.radSenkyoNo = radSenkyoNo;
    }

    /*
     * getradShukeiTani
     * @return radShukeiTani
     */
    @JsonProperty("radShukeiTani")
    public RadioButton getRadShukeiTani() {
        return radShukeiTani;
    }

    /*
     * setradShukeiTani
     * @param radShukeiTani radShukeiTani
     */
    @JsonProperty("radShukeiTani")
    public void setRadShukeiTani(RadioButton radShukeiTani) {
        this.radShukeiTani = radShukeiTani;
    }

    /*
     * gettxtTime
     * @return txtTime
     */
    @JsonProperty("txtTime")
    public TextBoxTime getTxtTime() {
        return txtTime;
    }

    /*
     * settxtTime
     * @param txtTime txtTime
     */
    @JsonProperty("txtTime")
    public void setTxtTime(TextBoxTime txtTime) {
        this.txtTime = txtTime;
    }

    /*
     * getbtnSaishinka
     * @return btnSaishinka
     */
    @JsonProperty("btnSaishinka")
    public Button getBtnSaishinka() {
        return btnSaishinka;
    }

    /*
     * setbtnSaishinka
     * @param btnSaishinka btnSaishinka
     */
    @JsonProperty("btnSaishinka")
    public void setBtnSaishinka(Button btnSaishinka) {
        this.btnSaishinka = btnSaishinka;
    }

    /*
     * getdgTojitsuTohyoShukei
     * @return dgTojitsuTohyoShukei
     */
    @JsonProperty("dgTojitsuTohyoShukei")
    public DataGrid<dgTojitsuTohyoShukei_Row> getDgTojitsuTohyoShukei() {
        return dgTojitsuTohyoShukei;
    }

    /*
     * setdgTojitsuTohyoShukei
     * @param dgTojitsuTohyoShukei dgTojitsuTohyoShukei
     */
    @JsonProperty("dgTojitsuTohyoShukei")
    public void setDgTojitsuTohyoShukei(DataGrid<dgTojitsuTohyoShukei_Row> dgTojitsuTohyoShukei) {
        this.dgTojitsuTohyoShukei = dgTojitsuTohyoShukei;
    }

    /*
     * getccdTojitsuTohyokuCode
     * @return ccdTojitsuTohyokuCode
     */
    @JsonProperty("ccdTojitsuTohyokuCode")
    public ITohyokuCodeSelectDiv getCcdTojitsuTohyokuCode() {
        return ccdTojitsuTohyokuCode;
    }

    /*
     * gettxtHdnShohonNo
     * @return txtHdnShohonNo
     */
    @JsonProperty("txtHdnShohonNo")
    public RString getTxtHdnShohonNo() {
        return txtHdnShohonNo;
    }

    /*
     * settxtHdnShohonNo
     * @param txtHdnShohonNo txtHdnShohonNo
     */
    @JsonProperty("txtHdnShohonNo")
    public void setTxtHdnShohonNo(RString txtHdnShohonNo) {
        this.txtHdnShohonNo = txtHdnShohonNo;
    }

    /*
     * gettxtHdnSenkyoShurui
     * @return txtHdnSenkyoShurui
     */
    @JsonProperty("txtHdnSenkyoShurui")
    public RString getTxtHdnSenkyoShurui() {
        return txtHdnSenkyoShurui;
    }

    /*
     * settxtHdnSenkyoShurui
     * @param txtHdnSenkyoShurui txtHdnSenkyoShurui
     */
    @JsonProperty("txtHdnSenkyoShurui")
    public void setTxtHdnSenkyoShurui(RString txtHdnSenkyoShurui) {
        this.txtHdnSenkyoShurui = txtHdnSenkyoShurui;
    }

    /*
     * gettxtHdnTohyokuCode
     * @return txtHdnTohyokuCode
     */
    @JsonProperty("txtHdnTohyokuCode")
    public RString getTxtHdnTohyokuCode() {
        return txtHdnTohyokuCode;
    }

    /*
     * settxtHdnTohyokuCode
     * @param txtHdnTohyokuCode txtHdnTohyokuCode
     */
    @JsonProperty("txtHdnTohyokuCode")
    public void setTxtHdnTohyokuCode(RString txtHdnTohyokuCode) {
        this.txtHdnTohyokuCode = txtHdnTohyokuCode;
    }

    // </editor-fold>
}
