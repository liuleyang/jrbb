package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KumiaiCodeSelect;
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

/**
 * KumiaiCodeSelect のクラスファイル
 *
 * @author 自動生成
 */
public class KumiaiCodeSelectDiv extends Panel implements IKumiaiCodeSelectDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKumiaiCode")
    private TextBoxCode txtKumiaiCode;
    @JsonProperty("btnKumiaiCode")
    private ButtonDialog btnKumiaiCode;
    @JsonProperty("txtKumiaiName")
    private TextBox txtKumiaiName;
    @JsonProperty("txtHdnSenkyoShurui")
    private RString txtHdnSenkyoShurui;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKumiaiCode
     * @return txtKumiaiCode
     */
    @JsonProperty("txtKumiaiCode")
    public TextBoxCode getTxtKumiaiCode() {
        return txtKumiaiCode;
    }

    /*
     * settxtKumiaiCode
     * @param txtKumiaiCode txtKumiaiCode
     */
    @JsonProperty("txtKumiaiCode")
    public void setTxtKumiaiCode(TextBoxCode txtKumiaiCode) {
        this.txtKumiaiCode = txtKumiaiCode;
    }

    /*
     * getbtnKumiaiCode
     * @return btnKumiaiCode
     */
    @JsonProperty("btnKumiaiCode")
    public ButtonDialog getBtnKumiaiCode() {
        return btnKumiaiCode;
    }

    /*
     * setbtnKumiaiCode
     * @param btnKumiaiCode btnKumiaiCode
     */
    @JsonProperty("btnKumiaiCode")
    public void setBtnKumiaiCode(ButtonDialog btnKumiaiCode) {
        this.btnKumiaiCode = btnKumiaiCode;
    }

    /*
     * gettxtKumiaiName
     * @return txtKumiaiName
     */
    @JsonProperty("txtKumiaiName")
    public TextBox getTxtKumiaiName() {
        return txtKumiaiName;
    }

    /*
     * settxtKumiaiName
     * @param txtKumiaiName txtKumiaiName
     */
    @JsonProperty("txtKumiaiName")
    public void setTxtKumiaiName(TextBox txtKumiaiName) {
        this.txtKumiaiName = txtKumiaiName;
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
    public void initialize(SenkyoShurui senkyoShurui) {
        getHandler().initialize(senkyoShurui);
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
    public void setReadOnlyMode(Boolean readOnlySetMode) {
        getHandler().setReadOnlyMode(readOnlySetMode);
    }

    @JsonIgnore
    public KumiaiCodeSelectHandler getHandler() {
        return new KumiaiCodeSelectHandler(this);
    }

    @Override
    public KumiaiCodeSelectDiv get組合コード選択Div() {
        return this;
    }
}
