package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxTohyokuCode;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * TohyokuCodeSelect のクラスファイル
 *
 * @author 自動生成
 */
public class TohyokuCodeSelectDiv extends Panel implements ITohyokuCodeSelectDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTohyokuCode")
    private TextBoxCode txtTohyokuCode;
    @JsonProperty("btnTohyokuCode")
    private ButtonDialog btnTohyokuCode;
    @JsonProperty("txtTohyokuName")
    private TextBox txtTohyokuName;
    @JsonProperty("txtTohyokuCodeDomain")
    private TextBoxTohyokuCode txtTohyokuCodeDomain;
    @JsonProperty("txtHdnSenkyoShurui")
    private RString txtHdnSenkyoShurui;
    @JsonProperty("isNyuryokuCheckByCommonChildDiv")
    private RString isNyuryokuCheckByCommonChildDiv;
    @JsonProperty("tohyokuCodeSelectModel")
    private RString tohyokuCodeSelectModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTohyokuCode
     * @return txtTohyokuCode
     */
    @JsonProperty("txtTohyokuCode")
    public TextBoxCode getTxtTohyokuCode() {
        return txtTohyokuCode;
    }

    /*
     * settxtTohyokuCode
     * @param txtTohyokuCode txtTohyokuCode
     */
    @JsonProperty("txtTohyokuCode")
    public void setTxtTohyokuCode(TextBoxCode txtTohyokuCode) {
        this.txtTohyokuCode = txtTohyokuCode;
    }

    /*
     * getbtnTohyokuCode
     * @return btnTohyokuCode
     */
    @JsonProperty("btnTohyokuCode")
    public ButtonDialog getBtnTohyokuCode() {
        return btnTohyokuCode;
    }

    /*
     * setbtnTohyokuCode
     * @param btnTohyokuCode btnTohyokuCode
     */
    @JsonProperty("btnTohyokuCode")
    public void setBtnTohyokuCode(ButtonDialog btnTohyokuCode) {
        this.btnTohyokuCode = btnTohyokuCode;
    }

    /*
     * gettxtTohyokuName
     * @return txtTohyokuName
     */
    @JsonProperty("txtTohyokuName")
    public TextBox getTxtTohyokuName() {
        return txtTohyokuName;
    }

    /*
     * settxtTohyokuName
     * @param txtTohyokuName txtTohyokuName
     */
    @JsonProperty("txtTohyokuName")
    public void setTxtTohyokuName(TextBox txtTohyokuName) {
        this.txtTohyokuName = txtTohyokuName;
    }

    /*
     * gettxtTohyokuCodeDomain
     * @return txtTohyokuCodeDomain
     */
    @JsonProperty("txtTohyokuCodeDomain")
    public TextBoxTohyokuCode getTxtTohyokuCodeDomain() {
        return txtTohyokuCodeDomain;
    }

    /*
     * settxtTohyokuCodeDomain
     * @param txtTohyokuCodeDomain txtTohyokuCodeDomain
     */
    @JsonProperty("txtTohyokuCodeDomain")
    public void setTxtTohyokuCodeDomain(TextBoxTohyokuCode txtTohyokuCodeDomain) {
        this.txtTohyokuCodeDomain = txtTohyokuCodeDomain;
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
     * getisNyuryokuCheckByCommonChildDiv
     * @return isNyuryokuCheckByCommonChildDiv
     */
    @JsonProperty("isNyuryokuCheckByCommonChildDiv")
    public RString getIsNyuryokuCheckByCommonChildDiv() {
        return isNyuryokuCheckByCommonChildDiv;
    }

    /*
     * setisNyuryokuCheckByCommonChildDiv
     * @param isNyuryokuCheckByCommonChildDiv isNyuryokuCheckByCommonChildDiv
     */
    @JsonProperty("isNyuryokuCheckByCommonChildDiv")
    public void setIsNyuryokuCheckByCommonChildDiv(RString isNyuryokuCheckByCommonChildDiv) {
        this.isNyuryokuCheckByCommonChildDiv = isNyuryokuCheckByCommonChildDiv;
    }

    /*
     * gettohyokuCodeSelectModel
     * @return tohyokuCodeSelectModel
     */
    @JsonProperty("tohyokuCodeSelectModel")
    public RString getTohyokuCodeSelectModel() {
        return tohyokuCodeSelectModel;
    }

    /*
     * settohyokuCodeSelectModel
     * @param tohyokuCodeSelectModel tohyokuCodeSelectModel
     */
    @JsonProperty("tohyokuCodeSelectModel")
    public void setTohyokuCodeSelectModel(RString tohyokuCodeSelectModel) {
        this.tohyokuCodeSelectModel = tohyokuCodeSelectModel;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize() {
        getHandler().initialize();
    }

    @Override
    public void initialize(SenkyoShurui senkyoShurui, boolean isNyuryokuCheckByCommonChildDiv) {
        if (isNyuryokuCheckByCommonChildDiv) {
            getHandler().initialize(senkyoShurui, new RString("1"));
        } else {
            getHandler().initialize(senkyoShurui, new RString("0"));
        }
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
    public RString get投票区名称() {
        return txtTohyokuName.getText();
    }

    @Override
    public void set投票区名称() {
        txtTohyokuName.setValue(getHandler().get投票区名称());
    }

    @Override
    public void setReadOnlyMode(Boolean readOnlySetMode) {
        getHandler().setReadOnlyMode(readOnlySetMode);
    }

    @JsonIgnore
    public TohyokuCodeSelectHandler getHandler() {
        return new TohyokuCodeSelectHandler(this);
    }

    @Override
    public RString get投票区コード() {
        return this.txtTohyokuCode.getValue();
    }

    @Override
    public ValidationMessageControlPairs 投票区コードチェック() {
        return getHandler().投票区コードチェック();
    }
}
