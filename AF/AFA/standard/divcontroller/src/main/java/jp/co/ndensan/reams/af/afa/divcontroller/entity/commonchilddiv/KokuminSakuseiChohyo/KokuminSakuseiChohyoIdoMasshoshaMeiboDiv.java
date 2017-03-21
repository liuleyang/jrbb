package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
public class KokuminSakuseiChohyoIdoMasshoshaMeiboDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtMasshoYMD")
    private TextBoxDate txtMasshoYMD;
    @JsonProperty("lblMasshoshaMeibo")
    private Label lblMasshoshaMeibo;
    @JsonProperty("chkMasshoshaMeiboJuran")
    private CheckBoxList chkMasshoshaMeiboJuran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtMasshoYMD
     * @return txtMasshoYMD
     */
    @JsonProperty("txtMasshoYMD")
    public TextBoxDate getTxtMasshoYMD() {
        return txtMasshoYMD;
    }

    /*
     * settxtMasshoYMD
     * @param txtMasshoYMD txtMasshoYMD
     */
    @JsonProperty("txtMasshoYMD")
    public void setTxtMasshoYMD(TextBoxDate txtMasshoYMD) {
        this.txtMasshoYMD = txtMasshoYMD;
    }

    /*
     * getlblMasshoshaMeibo
     * @return lblMasshoshaMeibo
     */
    @JsonProperty("lblMasshoshaMeibo")
    public Label getLblMasshoshaMeibo() {
        return lblMasshoshaMeibo;
    }

    /*
     * setlblMasshoshaMeibo
     * @param lblMasshoshaMeibo lblMasshoshaMeibo
     */
    @JsonProperty("lblMasshoshaMeibo")
    public void setLblMasshoshaMeibo(Label lblMasshoshaMeibo) {
        this.lblMasshoshaMeibo = lblMasshoshaMeibo;
    }

    /*
     * getchkMasshoshaMeiboJuran
     * @return chkMasshoshaMeiboJuran
     */
    @JsonProperty("chkMasshoshaMeiboJuran")
    public CheckBoxList getChkMasshoshaMeiboJuran() {
        return chkMasshoshaMeiboJuran;
    }

    /*
     * setchkMasshoshaMeiboJuran
     * @param chkMasshoshaMeiboJuran chkMasshoshaMeiboJuran
     */
    @JsonProperty("chkMasshoshaMeiboJuran")
    public void setChkMasshoshaMeiboJuran(CheckBoxList chkMasshoshaMeiboJuran) {
        this.chkMasshoshaMeiboJuran = chkMasshoshaMeiboJuran;
    }

    // </editor-fold>
}
