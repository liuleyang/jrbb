package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.RyojikanCodeSelect;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;

/**
 * RyojikanCodeSelect のクラスファイル
 *
 * @author 自動生成
 */
public class RyojikanCodeSelectDiv extends Panel implements IRyojikanCodeSelectDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtRyojikanCode")
    private TextBoxCode txtRyojikanCode;
    @JsonProperty("btnRyojikanCode")
    private ButtonDialog btnRyojikanCode;
    @JsonProperty("txtRyojikanName")
    private TextBox txtRyojikanName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtRyojikanCode
     * @return txtRyojikanCode
     */
    @JsonProperty("txtRyojikanCode")
    public TextBoxCode getTxtRyojikanCode() {
        return txtRyojikanCode;
    }

    /*
     * settxtRyojikanCode
     * @param txtRyojikanCode txtRyojikanCode
     */
    @JsonProperty("txtRyojikanCode")
    public void setTxtRyojikanCode(TextBoxCode txtRyojikanCode) {
        this.txtRyojikanCode = txtRyojikanCode;
    }

    /*
     * getbtnRyojikanCode
     * @return btnRyojikanCode
     */
    @JsonProperty("btnRyojikanCode")
    public ButtonDialog getBtnRyojikanCode() {
        return btnRyojikanCode;
    }

    /*
     * setbtnRyojikanCode
     * @param btnRyojikanCode btnRyojikanCode
     */
    @JsonProperty("btnRyojikanCode")
    public void setBtnRyojikanCode(ButtonDialog btnRyojikanCode) {
        this.btnRyojikanCode = btnRyojikanCode;
    }

    /*
     * gettxtRyojikanName
     * @return txtRyojikanName
     */
    @JsonProperty("txtRyojikanName")
    public TextBox getTxtRyojikanName() {
        return txtRyojikanName;
    }

    /*
     * settxtRyojikanName
     * @param txtRyojikanName txtRyojikanName
     */
    @JsonProperty("txtRyojikanName")
    public void setTxtRyojikanName(TextBox txtRyojikanName) {
        this.txtRyojikanName = txtRyojikanName;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(RString code) {
        RyojikanCodeSelectHandler.of(this).initialize(code);
    }

    @Override
    public void clear() {
        RyojikanCodeSelectHandler.of(this).clear();
    }

}
