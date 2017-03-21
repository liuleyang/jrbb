package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2030;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SenkyokuInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class SenkyokuInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtCode")
    private TextBoxCode txtCode;
    @JsonProperty("txtName")
    private TextBox txtName;
    @JsonProperty("btnAddNew")
    private Button btnAddNew;
    @JsonProperty("btnStop")
    private Button btnStop;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtCode
     * @return txtCode
     */
    @JsonProperty("txtCode")
    public TextBoxCode getTxtCode() {
        return txtCode;
    }

    /*
     * settxtCode
     * @param txtCode txtCode
     */
    @JsonProperty("txtCode")
    public void setTxtCode(TextBoxCode txtCode) {
        this.txtCode = txtCode;
    }

    /*
     * gettxtName
     * @return txtName
     */
    @JsonProperty("txtName")
    public TextBox getTxtName() {
        return txtName;
    }

    /*
     * settxtName
     * @param txtName txtName
     */
    @JsonProperty("txtName")
    public void setTxtName(TextBox txtName) {
        this.txtName = txtName;
    }

    /*
     * getbtnAddNew
     * @return btnAddNew
     */
    @JsonProperty("btnAddNew")
    public Button getBtnAddNew() {
        return btnAddNew;
    }

    /*
     * setbtnAddNew
     * @param btnAddNew btnAddNew
     */
    @JsonProperty("btnAddNew")
    public void setBtnAddNew(Button btnAddNew) {
        this.btnAddNew = btnAddNew;
    }

    /*
     * getbtnStop
     * @return btnStop
     */
    @JsonProperty("btnStop")
    public Button getBtnStop() {
        return btnStop;
    }

    /*
     * setbtnStop
     * @param btnStop btnStop
     */
    @JsonProperty("btnStop")
    public void setBtnStop(Button btnStop) {
        this.btnStop = btnStop;
    }

    // </editor-fold>
}
