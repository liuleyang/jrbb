package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyokuCodeSelect;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;

/**
 * SenkyokuCodeSelect のクラスファイル
 *
 * @author 自動生成
 */
public class SenkyokuCodeSelectDiv extends Panel implements ISenkyokuCodeSelectDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSenkyokuCode")
    private TextBoxCode txtSenkyokuCode;
    @JsonProperty("btnSenkyokuCode")
    private ButtonDialog btnSenkyokuCode;
    @JsonProperty("txtSenkyokuName")
    private TextBox txtSenkyokuName;
    @JsonProperty("txtHdnSenkyoShurui")
    private RString txtHdnSenkyoShurui;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSenkyokuCode
     * @return txtSenkyokuCode
     */
    @JsonProperty("txtSenkyokuCode")
    public TextBoxCode getTxtSenkyokuCode() {
        return txtSenkyokuCode;
    }

    /*
     * settxtSenkyokuCode
     * @param txtSenkyokuCode txtSenkyokuCode
     */
    @JsonProperty("txtSenkyokuCode")
    public void setTxtSenkyokuCode(TextBoxCode txtSenkyokuCode) {
        this.txtSenkyokuCode = txtSenkyokuCode;
    }

    /*
     * getbtnSenkyokuCode
     * @return btnSenkyokuCode
     */
    @JsonProperty("btnSenkyokuCode")
    public ButtonDialog getBtnSenkyokuCode() {
        return btnSenkyokuCode;
    }

    /*
     * setbtnSenkyokuCode
     * @param btnSenkyokuCode btnSenkyokuCode
     */
    @JsonProperty("btnSenkyokuCode")
    public void setBtnSenkyokuCode(ButtonDialog btnSenkyokuCode) {
        this.btnSenkyokuCode = btnSenkyokuCode;
    }

    /*
     * gettxtSenkyokuName
     * @return txtSenkyokuName
     */
    @JsonProperty("txtSenkyokuName")
    public TextBox getTxtSenkyokuName() {
        return txtSenkyokuName;
    }

    /*
     * settxtSenkyokuName
     * @param txtSenkyokuName txtSenkyokuName
     */
    @JsonProperty("txtSenkyokuName")
    public void setTxtSenkyokuName(TextBox txtSenkyokuName) {
        this.txtSenkyokuName = txtSenkyokuName;
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

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize() {
        getHandler().initialize();
    }

    @Override
    public void initialize(SenkyoShurui senkyoShurui) {
        getHandler().initialize(senkyoShurui);
    }

    @Override
    public ResponseData initialize(Code senkyoShurui, RString senkyokuCode) {
        return getHandler().initialize(senkyoShurui, senkyokuCode);
    }

    @Override
    public void initialize(RString code) {
        getHandler().initialize(code);
    }

    @Override
    public void clear() {
        getHandler().clear();
    }

    @Override
    public RString get選挙区名称(Code senkyoshurui, RString senkyokuCode) {
        return getHandler().get選挙区名称(senkyoshurui, senkyokuCode);
    }

    @Override
    public void setReadOnlyMode(Boolean readOnlySetMode) {
        getHandler().setReadOnlyMode(readOnlySetMode);
    }

    @JsonIgnore
    public SenkyokuCodeSelectHandler getHandler() {
        return new SenkyokuCodeSelectHandler(this);
    }

    @Override
    public RString get選挙区コード() {
        return getHandler().get選挙区コード();
    }

}
