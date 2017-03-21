package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5030;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * NippoSakuseiChohyoJiyuChosho のクラスファイル 
 * 
 * @author 自動生成
 */
public class NippoSakuseiChohyoJiyuChoshoDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkKijitsumaeJiyuChosho")
    private CheckBoxList chkKijitsumaeJiyuChosho;
    @JsonProperty("txtJiyuChoshoKijitsumaeTohyoYMD")
    private TextBoxDateRange txtJiyuChoshoKijitsumaeTohyoYMD;
    @JsonProperty("chkFuzaishaJiyuChosho")
    private CheckBoxList chkFuzaishaJiyuChosho;
    @JsonProperty("txtJiyuChoshoJuriYMD")
    private TextBoxDateRange txtJiyuChoshoJuriYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkKijitsumaeJiyuChosho
     * @return chkKijitsumaeJiyuChosho
     */
    @JsonProperty("chkKijitsumaeJiyuChosho")
    public CheckBoxList getChkKijitsumaeJiyuChosho() {
        return chkKijitsumaeJiyuChosho;
    }

    /*
     * setchkKijitsumaeJiyuChosho
     * @param chkKijitsumaeJiyuChosho chkKijitsumaeJiyuChosho
     */
    @JsonProperty("chkKijitsumaeJiyuChosho")
    public void setChkKijitsumaeJiyuChosho(CheckBoxList chkKijitsumaeJiyuChosho) {
        this.chkKijitsumaeJiyuChosho = chkKijitsumaeJiyuChosho;
    }

    /*
     * gettxtJiyuChoshoKijitsumaeTohyoYMD
     * @return txtJiyuChoshoKijitsumaeTohyoYMD
     */
    @JsonProperty("txtJiyuChoshoKijitsumaeTohyoYMD")
    public TextBoxDateRange getTxtJiyuChoshoKijitsumaeTohyoYMD() {
        return txtJiyuChoshoKijitsumaeTohyoYMD;
    }

    /*
     * settxtJiyuChoshoKijitsumaeTohyoYMD
     * @param txtJiyuChoshoKijitsumaeTohyoYMD txtJiyuChoshoKijitsumaeTohyoYMD
     */
    @JsonProperty("txtJiyuChoshoKijitsumaeTohyoYMD")
    public void setTxtJiyuChoshoKijitsumaeTohyoYMD(TextBoxDateRange txtJiyuChoshoKijitsumaeTohyoYMD) {
        this.txtJiyuChoshoKijitsumaeTohyoYMD = txtJiyuChoshoKijitsumaeTohyoYMD;
    }

    /*
     * getchkFuzaishaJiyuChosho
     * @return chkFuzaishaJiyuChosho
     */
    @JsonProperty("chkFuzaishaJiyuChosho")
    public CheckBoxList getChkFuzaishaJiyuChosho() {
        return chkFuzaishaJiyuChosho;
    }

    /*
     * setchkFuzaishaJiyuChosho
     * @param chkFuzaishaJiyuChosho chkFuzaishaJiyuChosho
     */
    @JsonProperty("chkFuzaishaJiyuChosho")
    public void setChkFuzaishaJiyuChosho(CheckBoxList chkFuzaishaJiyuChosho) {
        this.chkFuzaishaJiyuChosho = chkFuzaishaJiyuChosho;
    }

    /*
     * gettxtJiyuChoshoJuriYMD
     * @return txtJiyuChoshoJuriYMD
     */
    @JsonProperty("txtJiyuChoshoJuriYMD")
    public TextBoxDateRange getTxtJiyuChoshoJuriYMD() {
        return txtJiyuChoshoJuriYMD;
    }

    /*
     * settxtJiyuChoshoJuriYMD
     * @param txtJiyuChoshoJuriYMD txtJiyuChoshoJuriYMD
     */
    @JsonProperty("txtJiyuChoshoJuriYMD")
    public void setTxtJiyuChoshoJuriYMD(TextBoxDateRange txtJiyuChoshoJuriYMD) {
        this.txtJiyuChoshoJuriYMD = txtJiyuChoshoJuriYMD;
    }

    // </editor-fold>
}
