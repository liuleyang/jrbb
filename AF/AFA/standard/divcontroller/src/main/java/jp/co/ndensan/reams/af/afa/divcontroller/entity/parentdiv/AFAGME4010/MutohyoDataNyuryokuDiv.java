package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME4010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * MutohyoDataNyuryoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class MutohyoDataNyuryokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblSenkyoRyakuName")
    private Label lblSenkyoRyakuName;
    @JsonProperty("btnAllOff")
    private Button btnAllOff;
    @JsonProperty("btnAllOn")
    private Button btnAllOn;
    @JsonProperty("lblCheckNaiyo")
    private Label lblCheckNaiyo;
    @JsonProperty("dgMutohyoData")
    private DataGrid<dgMutohyoData_Row> dgMutohyoData;
    @JsonProperty("ChangePage")
    private ChangePageDiv ChangePage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblSenkyoRyakuName
     * @return lblSenkyoRyakuName
     */
    @JsonProperty("lblSenkyoRyakuName")
    public Label getLblSenkyoRyakuName() {
        return lblSenkyoRyakuName;
    }

    /*
     * setlblSenkyoRyakuName
     * @param lblSenkyoRyakuName lblSenkyoRyakuName
     */
    @JsonProperty("lblSenkyoRyakuName")
    public void setLblSenkyoRyakuName(Label lblSenkyoRyakuName) {
        this.lblSenkyoRyakuName = lblSenkyoRyakuName;
    }

    /*
     * getbtnAllOff
     * @return btnAllOff
     */
    @JsonProperty("btnAllOff")
    public Button getBtnAllOff() {
        return btnAllOff;
    }

    /*
     * setbtnAllOff
     * @param btnAllOff btnAllOff
     */
    @JsonProperty("btnAllOff")
    public void setBtnAllOff(Button btnAllOff) {
        this.btnAllOff = btnAllOff;
    }

    /*
     * getbtnAllOn
     * @return btnAllOn
     */
    @JsonProperty("btnAllOn")
    public Button getBtnAllOn() {
        return btnAllOn;
    }

    /*
     * setbtnAllOn
     * @param btnAllOn btnAllOn
     */
    @JsonProperty("btnAllOn")
    public void setBtnAllOn(Button btnAllOn) {
        this.btnAllOn = btnAllOn;
    }

    /*
     * getlblCheckNaiyo
     * @return lblCheckNaiyo
     */
    @JsonProperty("lblCheckNaiyo")
    public Label getLblCheckNaiyo() {
        return lblCheckNaiyo;
    }

    /*
     * setlblCheckNaiyo
     * @param lblCheckNaiyo lblCheckNaiyo
     */
    @JsonProperty("lblCheckNaiyo")
    public void setLblCheckNaiyo(Label lblCheckNaiyo) {
        this.lblCheckNaiyo = lblCheckNaiyo;
    }

    /*
     * getdgMutohyoData
     * @return dgMutohyoData
     */
    @JsonProperty("dgMutohyoData")
    public DataGrid<dgMutohyoData_Row> getDgMutohyoData() {
        return dgMutohyoData;
    }

    /*
     * setdgMutohyoData
     * @param dgMutohyoData dgMutohyoData
     */
    @JsonProperty("dgMutohyoData")
    public void setDgMutohyoData(DataGrid<dgMutohyoData_Row> dgMutohyoData) {
        this.dgMutohyoData = dgMutohyoData;
    }

    /*
     * getChangePage
     * @return ChangePage
     */
    @JsonProperty("ChangePage")
    public ChangePageDiv getChangePage() {
        return ChangePage;
    }

    /*
     * setChangePage
     * @param ChangePage ChangePage
     */
    @JsonProperty("ChangePage")
    public void setChangePage(ChangePageDiv ChangePage) {
        this.ChangePage = ChangePage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnBefore() {
        return this.getChangePage().getBtnBefore();
    }

    @JsonIgnore
    public void  setBtnBefore(Button btnBefore) {
        this.getChangePage().setBtnBefore(btnBefore);
    }

    @JsonIgnore
    public Button getBtnAfter() {
        return this.getChangePage().getBtnAfter();
    }

    @JsonIgnore
    public void  setBtnAfter(Button btnAfter) {
        this.getChangePage().setBtnAfter(btnAfter);
    }

    // </editor-fold>
}
