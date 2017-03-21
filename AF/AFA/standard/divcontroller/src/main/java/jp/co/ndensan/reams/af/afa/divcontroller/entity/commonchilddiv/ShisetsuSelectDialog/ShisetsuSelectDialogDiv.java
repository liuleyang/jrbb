package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuSelectDialog;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShisetsuSelectDialog のクラスファイルです。
 *
 * @author 自動生成
 * @reamsid_L AF-0080-035 qiuxy
 */
public class ShisetsuSelectDialogDiv extends Panel implements IShisetsuSelectDialogDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-04-25_11-07-54">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlShisetsuShubetsu")
    private DropDownList ddlShisetsuShubetsu;
    @JsonProperty("dgShisetsuSelect")
    private DataGrid<dgShisetsuSelect_Row> dgShisetsuSelect;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("txtHdnSelectedCode")
    private RString txtHdnSelectedCode;
    @JsonProperty("txtHdnSelectedName")
    private RString txtHdnSelectedName;
    @JsonProperty("ShisetsuCodeSelectModel")
    private RString ShisetsuCodeSelectModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlShisetsuShubetsu
     * @return ddlShisetsuShubetsu
     */
    @JsonProperty("ddlShisetsuShubetsu")
    public DropDownList getDdlShisetsuShubetsu() {
        return ddlShisetsuShubetsu;
    }

    /*
     * setddlShisetsuShubetsu
     * @param ddlShisetsuShubetsu ddlShisetsuShubetsu
     */
    @JsonProperty("ddlShisetsuShubetsu")
    public void setDdlShisetsuShubetsu(DropDownList ddlShisetsuShubetsu) {
        this.ddlShisetsuShubetsu = ddlShisetsuShubetsu;
    }

    /*
     * getdgShisetsuSelect
     * @return dgShisetsuSelect
     */
    @JsonProperty("dgShisetsuSelect")
    public DataGrid<dgShisetsuSelect_Row> getDgShisetsuSelect() {
        return dgShisetsuSelect;
    }

    /*
     * setdgShisetsuSelect
     * @param dgShisetsuSelect dgShisetsuSelect
     */
    @JsonProperty("dgShisetsuSelect")
    public void setDgShisetsuSelect(DataGrid<dgShisetsuSelect_Row> dgShisetsuSelect) {
        this.dgShisetsuSelect = dgShisetsuSelect;
    }

    /*
     * getbtnCancel
     * @return btnCancel
     */
    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    /*
     * setbtnCancel
     * @param btnCancel btnCancel
     */
    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel = btnCancel;
    }

    /*
     * gettxtHdnSelectedCode
     * @return txtHdnSelectedCode
     */
    @JsonProperty("txtHdnSelectedCode")
    public RString getTxtHdnSelectedCode() {
        return txtHdnSelectedCode;
    }

    /*
     * settxtHdnSelectedCode
     * @param txtHdnSelectedCode txtHdnSelectedCode
     */
    @JsonProperty("txtHdnSelectedCode")
    public void setTxtHdnSelectedCode(RString txtHdnSelectedCode) {
        this.txtHdnSelectedCode = txtHdnSelectedCode;
    }

    /*
     * gettxtHdnSelectedName
     * @return txtHdnSelectedName
     */
    @JsonProperty("txtHdnSelectedName")
    public RString getTxtHdnSelectedName() {
        return txtHdnSelectedName;
    }

    /*
     * settxtHdnSelectedName
     * @param txtHdnSelectedName txtHdnSelectedName
     */
    @JsonProperty("txtHdnSelectedName")
    public void setTxtHdnSelectedName(RString txtHdnSelectedName) {
        this.txtHdnSelectedName = txtHdnSelectedName;
    }

    /*
     * getShisetsuCodeSelectModel
     * @return ShisetsuCodeSelectModel
     */
    @JsonProperty("ShisetsuCodeSelectModel")
    public RString getShisetsuCodeSelectModel() {
        return ShisetsuCodeSelectModel;
    }

    /*
     * setShisetsuCodeSelectModel
     * @param ShisetsuCodeSelectModel ShisetsuCodeSelectModel
     */
    @JsonProperty("ShisetsuCodeSelectModel")
    public void setShisetsuCodeSelectModel(RString ShisetsuCodeSelectModel) {
        this.ShisetsuCodeSelectModel = ShisetsuCodeSelectModel;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @JsonIgnore
    public ShisetsuSelectDialogHandler getHandler() {
        return new ShisetsuSelectDialogHandler(this);
    }
}
