package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.BarCodeNyuryoku.BarCodeNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.BarCodeNyuryoku.IBarCodeNyuryokuDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FuzaishaSenkyoninSearch のクラスファイル 
 * 
 * @author 自動生成
 */
public class FuzaishaSenkyoninSearchDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnSearchSimple")
    private ButtonDialog btnSearchSimple;
    @JsonProperty("lblWarningMessageJuri")
    private Label lblWarningMessageJuri;
    @JsonProperty("dgFuzaishaSenkyoninSearch")
    private DataGrid<dgFuzaishaSenkyoninSearch_Row> dgFuzaishaSenkyoninSearch;
    @JsonProperty("btnFuzaishaInput")
    private Button btnFuzaishaInput;
    @JsonProperty("ccdFuzaishaBarCode")
    private BarCodeNyuryokuDiv ccdFuzaishaBarCode;
    @JsonProperty("txtHdnShohonNo")
    private RString txtHdnShohonNo;
    @JsonProperty("txtHdnSenkyoShurui")
    private RString txtHdnSenkyoShurui;
    @JsonProperty("txtHdnShikibetsuCode")
    private RString txtHdnShikibetsuCode;
    @JsonProperty("txtHdnKidoMode")
    private RString txtHdnKidoMode;
    @JsonProperty("txtHdnShikibetsuCodeList")
    private RString txtHdnShikibetsuCodeList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnSearchSimple
     * @return btnSearchSimple
     */
    @JsonProperty("btnSearchSimple")
    public ButtonDialog getBtnSearchSimple() {
        return btnSearchSimple;
    }

    /*
     * setbtnSearchSimple
     * @param btnSearchSimple btnSearchSimple
     */
    @JsonProperty("btnSearchSimple")
    public void setBtnSearchSimple(ButtonDialog btnSearchSimple) {
        this.btnSearchSimple = btnSearchSimple;
    }

    /*
     * getlblWarningMessageJuri
     * @return lblWarningMessageJuri
     */
    @JsonProperty("lblWarningMessageJuri")
    public Label getLblWarningMessageJuri() {
        return lblWarningMessageJuri;
    }

    /*
     * setlblWarningMessageJuri
     * @param lblWarningMessageJuri lblWarningMessageJuri
     */
    @JsonProperty("lblWarningMessageJuri")
    public void setLblWarningMessageJuri(Label lblWarningMessageJuri) {
        this.lblWarningMessageJuri = lblWarningMessageJuri;
    }

    /*
     * getdgFuzaishaSenkyoninSearch
     * @return dgFuzaishaSenkyoninSearch
     */
    @JsonProperty("dgFuzaishaSenkyoninSearch")
    public DataGrid<dgFuzaishaSenkyoninSearch_Row> getDgFuzaishaSenkyoninSearch() {
        return dgFuzaishaSenkyoninSearch;
    }

    /*
     * setdgFuzaishaSenkyoninSearch
     * @param dgFuzaishaSenkyoninSearch dgFuzaishaSenkyoninSearch
     */
    @JsonProperty("dgFuzaishaSenkyoninSearch")
    public void setDgFuzaishaSenkyoninSearch(DataGrid<dgFuzaishaSenkyoninSearch_Row> dgFuzaishaSenkyoninSearch) {
        this.dgFuzaishaSenkyoninSearch = dgFuzaishaSenkyoninSearch;
    }

    /*
     * getbtnFuzaishaInput
     * @return btnFuzaishaInput
     */
    @JsonProperty("btnFuzaishaInput")
    public Button getBtnFuzaishaInput() {
        return btnFuzaishaInput;
    }

    /*
     * setbtnFuzaishaInput
     * @param btnFuzaishaInput btnFuzaishaInput
     */
    @JsonProperty("btnFuzaishaInput")
    public void setBtnFuzaishaInput(Button btnFuzaishaInput) {
        this.btnFuzaishaInput = btnFuzaishaInput;
    }

    /*
     * getccdFuzaishaBarCode
     * @return ccdFuzaishaBarCode
     */
    @JsonProperty("ccdFuzaishaBarCode")
    public IBarCodeNyuryokuDiv getCcdFuzaishaBarCode() {
        return ccdFuzaishaBarCode;
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
     * gettxtHdnShikibetsuCode
     * @return txtHdnShikibetsuCode
     */
    @JsonProperty("txtHdnShikibetsuCode")
    public RString getTxtHdnShikibetsuCode() {
        return txtHdnShikibetsuCode;
    }

    /*
     * settxtHdnShikibetsuCode
     * @param txtHdnShikibetsuCode txtHdnShikibetsuCode
     */
    @JsonProperty("txtHdnShikibetsuCode")
    public void setTxtHdnShikibetsuCode(RString txtHdnShikibetsuCode) {
        this.txtHdnShikibetsuCode = txtHdnShikibetsuCode;
    }

    /*
     * gettxtHdnKidoMode
     * @return txtHdnKidoMode
     */
    @JsonProperty("txtHdnKidoMode")
    public RString getTxtHdnKidoMode() {
        return txtHdnKidoMode;
    }

    /*
     * settxtHdnKidoMode
     * @param txtHdnKidoMode txtHdnKidoMode
     */
    @JsonProperty("txtHdnKidoMode")
    public void setTxtHdnKidoMode(RString txtHdnKidoMode) {
        this.txtHdnKidoMode = txtHdnKidoMode;
    }

    /*
     * gettxtHdnShikibetsuCodeList
     * @return txtHdnShikibetsuCodeList
     */
    @JsonProperty("txtHdnShikibetsuCodeList")
    public RString getTxtHdnShikibetsuCodeList() {
        return txtHdnShikibetsuCodeList;
    }

    /*
     * settxtHdnShikibetsuCodeList
     * @param txtHdnShikibetsuCodeList txtHdnShikibetsuCodeList
     */
    @JsonProperty("txtHdnShikibetsuCodeList")
    public void setTxtHdnShikibetsuCodeList(RString txtHdnShikibetsuCodeList) {
        this.txtHdnShikibetsuCodeList = txtHdnShikibetsuCodeList;
    }

    // </editor-fold>
}
