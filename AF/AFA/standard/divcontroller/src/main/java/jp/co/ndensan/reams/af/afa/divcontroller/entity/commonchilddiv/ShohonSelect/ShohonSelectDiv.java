package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonSelect;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
public class ShohonSelectDiv extends Panel implements IShohonSelectDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdShohonNameList")
    private ShohonNameListDiv ccdShohonNameList;
    @JsonProperty("txtTohyoYMD")
    private TextBoxDate txtTohyoYMD;
    @JsonProperty("txtPrintJotai")
    private TextBox txtPrintJotai;
    @JsonProperty("btnHdnChangeShohon")
    private Button btnHdnChangeShohon;
    @JsonProperty("dgShohonSelect")
    private DataGrid<dgShohonSelect_Row> dgShohonSelect;
    @JsonProperty("HidShohonNo")
    private RString HidShohonNo;
    @JsonProperty("hidSenkyoShurui")
    private RString hidSenkyoShurui;
    @JsonProperty("hidShohonName")
    private RString hidShohonName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdShohonNameList
     * @return ccdShohonNameList
     */
    @JsonProperty("ccdShohonNameList")
    public IShohonNameListDiv getCcdShohonNameList() {
        return ccdShohonNameList;
    }

    /*
     * gettxtTohyoYMD
     * @return txtTohyoYMD
     */
    @JsonProperty("txtTohyoYMD")
    public TextBoxDate getTxtTohyoYMD() {
        return txtTohyoYMD;
    }

    /*
     * settxtTohyoYMD
     * @param txtTohyoYMD txtTohyoYMD
     */
    @JsonProperty("txtTohyoYMD")
    public void setTxtTohyoYMD(TextBoxDate txtTohyoYMD) {
        this.txtTohyoYMD = txtTohyoYMD;
    }

    /*
     * gettxtPrintJotai
     * @return txtPrintJotai
     */
    @JsonProperty("txtPrintJotai")
    public TextBox getTxtPrintJotai() {
        return txtPrintJotai;
    }

    /*
     * settxtPrintJotai
     * @param txtPrintJotai txtPrintJotai
     */
    @JsonProperty("txtPrintJotai")
    public void setTxtPrintJotai(TextBox txtPrintJotai) {
        this.txtPrintJotai = txtPrintJotai;
    }

    /*
     * getbtnHdnChangeShohon
     * @return btnHdnChangeShohon
     */
    @JsonProperty("btnHdnChangeShohon")
    public Button getBtnHdnChangeShohon() {
        return btnHdnChangeShohon;
    }

    /*
     * setbtnHdnChangeShohon
     * @param btnHdnChangeShohon btnHdnChangeShohon
     */
    @JsonProperty("btnHdnChangeShohon")
    public void setBtnHdnChangeShohon(Button btnHdnChangeShohon) {
        this.btnHdnChangeShohon = btnHdnChangeShohon;
    }

    /*
     * getdgShohonSelect
     * @return dgShohonSelect
     */
    @JsonProperty("dgShohonSelect")
    public DataGrid<dgShohonSelect_Row> getDgShohonSelect() {
        return dgShohonSelect;
    }

    /*
     * setdgShohonSelect
     * @param dgShohonSelect dgShohonSelect
     */
    @JsonProperty("dgShohonSelect")
    public void setDgShohonSelect(DataGrid<dgShohonSelect_Row> dgShohonSelect) {
        this.dgShohonSelect = dgShohonSelect;
    }

    /*
     * getHidShohonNo
     * @return HidShohonNo
     */
    @JsonProperty("HidShohonNo")
    public RString getHidShohonNo() {
        return HidShohonNo;
    }

    /*
     * setHidShohonNo
     * @param HidShohonNo HidShohonNo
     */
    @JsonProperty("HidShohonNo")
    public void setHidShohonNo(RString HidShohonNo) {
        this.HidShohonNo = HidShohonNo;
    }

    /*
     * gethidSenkyoShurui
     * @return hidSenkyoShurui
     */
    @JsonProperty("hidSenkyoShurui")
    public RString getHidSenkyoShurui() {
        return hidSenkyoShurui;
    }

    /*
     * sethidSenkyoShurui
     * @param hidSenkyoShurui hidSenkyoShurui
     */
    @JsonProperty("hidSenkyoShurui")
    public void setHidSenkyoShurui(RString hidSenkyoShurui) {
        this.hidSenkyoShurui = hidSenkyoShurui;
    }

    /*
     * gethidShohonName
     * @return hidShohonName
     */
    @JsonProperty("hidShohonName")
    public RString getHidShohonName() {
        return hidShohonName;
    }

    /*
     * sethidShohonName
     * @param hidShohonName hidShohonName
     */
    @JsonProperty("hidShohonName")
    public void setHidShohonName(RString hidShohonName) {
        this.hidShohonName = hidShohonName;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize() {
        getHandler().initialize();
    }

    @Override
    public void initialSetting() {
        getHandler().initialSetting();
    }

    @Override
    public void clearData() {
        getHandler().clearThisPanel();
    }

    @JsonIgnore
    public ShohonSelectHandler getHandler() {
        return new ShohonSelectHandler(this);
    }

    @Override
    public RString get抄本番号() {
        return this.getHidShohonNo();
    }

    @Override
    public RString get選挙種類() {
        return this.getHidSenkyoShurui();
    }

    @Override
    public ShohonSelectDiv get抄本選択共有情報() {
        return this;
    }

}
