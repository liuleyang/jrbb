package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyojoCodeSelect;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;

/**
 * TohyojoCodeSelect のクラスファイル
 *
 * @reamsid_L AF-0710-020 liuyj
 */
public class TohyojoCodeSelectDiv extends Panel implements ITohyojoCodeSelectDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTohyojoCode")
    private TextBoxCode txtTohyojoCode;
    @JsonProperty("btnTohyojoCode")
    private ButtonDialog btnTohyojoCode;
    @JsonProperty("txtTohyojoName")
    private TextBox txtTohyojoName;
    @JsonProperty("selectedKanaName")
    private RString selectedKanaName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTohyojoCode
     * @return txtTohyojoCode
     */
    @JsonProperty("txtTohyojoCode")
    public TextBoxCode getTxtTohyojoCode() {
        return txtTohyojoCode;
    }

    /*
     * settxtTohyojoCode
     * @param txtTohyojoCode txtTohyojoCode
     */
    @JsonProperty("txtTohyojoCode")
    public void setTxtTohyojoCode(TextBoxCode txtTohyojoCode) {
        this.txtTohyojoCode = txtTohyojoCode;
    }

    /*
     * getbtnTohyojoCode
     * @return btnTohyojoCode
     */
    @JsonProperty("btnTohyojoCode")
    public ButtonDialog getBtnTohyojoCode() {
        return btnTohyojoCode;
    }

    /*
     * setbtnTohyojoCode
     * @param btnTohyojoCode btnTohyojoCode
     */
    @JsonProperty("btnTohyojoCode")
    public void setBtnTohyojoCode(ButtonDialog btnTohyojoCode) {
        this.btnTohyojoCode = btnTohyojoCode;
    }

    /*
     * gettxtTohyojoName
     * @return txtTohyojoName
     */
    @JsonProperty("txtTohyojoName")
    public TextBox getTxtTohyojoName() {
        return txtTohyojoName;
    }

    /*
     * settxtTohyojoName
     * @param txtTohyojoName txtTohyojoName
     */
    @JsonProperty("txtTohyojoName")
    public void setTxtTohyojoName(TextBox txtTohyojoName) {
        this.txtTohyojoName = txtTohyojoName;
    }

    /*
     * getselectedKanaName
     * @return selectedKanaName
     */
    @JsonProperty("selectedKanaName")
    public RString getSelectedKanaName() {
        return selectedKanaName;
    }

    /*
     * setselectedKanaName
     * @param selectedKanaName selectedKanaName
     */
    @JsonProperty("selectedKanaName")
    public void setSelectedKanaName(RString selectedKanaName) {
        this.selectedKanaName = selectedKanaName;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    //共有子Div自身のsetDisabledのセットができるように
    @JsonIgnore
    public TohyojoCodeSelectValidationHandler getValidationHandler() {
        return new TohyojoCodeSelectValidationHandler(this);
    }

    @Override
    public void initialize(RString tohyojoCode) {
        getHandler().initialize(tohyojoCode);
    }

    @JsonIgnore
    public TohyojoCodeSelectHandler getHandler() {
        return new TohyojoCodeSelectHandler(this);
    }

}
