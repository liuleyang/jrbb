package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KijitsumaeTohyoJokyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class KijitsumaeTohyoJokyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radSenkyoNo")
    private RadioButton radSenkyoNo;
    @JsonProperty("btnSaishinka")
    private Button btnSaishinka;
    @JsonProperty("dgKijitsumaeTohyoShukei")
    private DataGrid<dgKijitsumaeTohyoShukei_Row> dgKijitsumaeTohyoShukei;
    @JsonProperty("txtHdnShohonNo")
    private RString txtHdnShohonNo;

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
     * getdgKijitsumaeTohyoShukei
     * @return dgKijitsumaeTohyoShukei
     */
    @JsonProperty("dgKijitsumaeTohyoShukei")
    public DataGrid<dgKijitsumaeTohyoShukei_Row> getDgKijitsumaeTohyoShukei() {
        return dgKijitsumaeTohyoShukei;
    }

    /*
     * setdgKijitsumaeTohyoShukei
     * @param dgKijitsumaeTohyoShukei dgKijitsumaeTohyoShukei
     */
    @JsonProperty("dgKijitsumaeTohyoShukei")
    public void setDgKijitsumaeTohyoShukei(DataGrid<dgKijitsumaeTohyoShukei_Row> dgKijitsumaeTohyoShukei) {
        this.dgKijitsumaeTohyoShukei = dgKijitsumaeTohyoShukei;
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

    // </editor-fold>
}
