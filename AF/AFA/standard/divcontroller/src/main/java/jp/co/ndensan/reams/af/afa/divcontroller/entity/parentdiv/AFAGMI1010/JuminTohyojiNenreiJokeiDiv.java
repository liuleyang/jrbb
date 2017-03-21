package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMI1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JuminTohyojiNenreiJokei のクラスファイル 
 * 
 * @author 自動生成
 */
public class JuminTohyojiNenreiJokeiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNenreiKijunYmd")
    private TextBoxDate txtNenreiKijunYmd;
    @JsonProperty("lblNenreiKijunYmd")
    private Label lblNenreiKijunYmd;
    @JsonProperty("txtNenrei")
    private TextBoxNum txtNenrei;
    @JsonProperty("chkNenreiKijun")
    private CheckBoxList chkNenreiKijun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtNenreiKijunYmd
     * @return txtNenreiKijunYmd
     */
    @JsonProperty("txtNenreiKijunYmd")
    public TextBoxDate getTxtNenreiKijunYmd() {
        return txtNenreiKijunYmd;
    }

    /*
     * settxtNenreiKijunYmd
     * @param txtNenreiKijunYmd txtNenreiKijunYmd
     */
    @JsonProperty("txtNenreiKijunYmd")
    public void setTxtNenreiKijunYmd(TextBoxDate txtNenreiKijunYmd) {
        this.txtNenreiKijunYmd = txtNenreiKijunYmd;
    }

    /*
     * getlblNenreiKijunYmd
     * @return lblNenreiKijunYmd
     */
    @JsonProperty("lblNenreiKijunYmd")
    public Label getLblNenreiKijunYmd() {
        return lblNenreiKijunYmd;
    }

    /*
     * setlblNenreiKijunYmd
     * @param lblNenreiKijunYmd lblNenreiKijunYmd
     */
    @JsonProperty("lblNenreiKijunYmd")
    public void setLblNenreiKijunYmd(Label lblNenreiKijunYmd) {
        this.lblNenreiKijunYmd = lblNenreiKijunYmd;
    }

    /*
     * gettxtNenrei
     * @return txtNenrei
     */
    @JsonProperty("txtNenrei")
    public TextBoxNum getTxtNenrei() {
        return txtNenrei;
    }

    /*
     * settxtNenrei
     * @param txtNenrei txtNenrei
     */
    @JsonProperty("txtNenrei")
    public void setTxtNenrei(TextBoxNum txtNenrei) {
        this.txtNenrei = txtNenrei;
    }

    /*
     * getchkNenreiKijun
     * @return chkNenreiKijun
     */
    @JsonProperty("chkNenreiKijun")
    public CheckBoxList getChkNenreiKijun() {
        return chkNenreiKijun;
    }

    /*
     * setchkNenreiKijun
     * @param chkNenreiKijun chkNenreiKijun
     */
    @JsonProperty("chkNenreiKijun")
    public void setChkNenreiKijun(CheckBoxList chkNenreiKijun) {
        this.chkNenreiKijun = chkNenreiKijun;
    }

    // </editor-fold>
}
