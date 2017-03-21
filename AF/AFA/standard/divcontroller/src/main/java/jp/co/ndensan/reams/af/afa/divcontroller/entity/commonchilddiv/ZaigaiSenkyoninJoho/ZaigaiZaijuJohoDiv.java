package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ZaigaiSenkyoninJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.RyojikanCodeSelect.IRyojikanCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.RyojikanCodeSelect.RyojikanCodeSelectDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.CodeInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.ICodeInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
public class ZaigaiZaijuJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdKokuseki")
    private CodeInputDiv ccdKokuseki;
    @JsonProperty("txtKaigaiJusho")
    private TextBoxJusho txtKaigaiJusho;
    @JsonProperty("txtDokyoKazoku")
    private TextBox txtDokyoKazoku;
    @JsonProperty("txtKaigaiTelNo")
    private TextBoxTelNo txtKaigaiTelNo;
    @JsonProperty("txtKaigaiFaxNo")
    private TextBoxTelNo txtKaigaiFaxNo;
    @JsonProperty("txtKaigaiMailAddress")
    private TextBoxMailAddress txtKaigaiMailAddress;
    @JsonProperty("ccdRyojikan")
    private RyojikanCodeSelectDiv ccdRyojikan;
    @JsonProperty("txtJuteiYMD")
    private TextBoxDate txtJuteiYMD;
    @JsonProperty("lblSofusaki")
    private Label lblSofusaki;
    @JsonProperty("txtKaigaiSofusakiJusho")
    private TextBoxJusho txtKaigaiSofusakiJusho;
    @JsonProperty("txtKaigaiSofusakiAtena")
    private TextBox txtKaigaiSofusakiAtena;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdKokuseki
     * @return ccdKokuseki
     */
    @JsonProperty("ccdKokuseki")
    public ICodeInputDiv getCcdKokuseki() {
        return ccdKokuseki;
    }

    /*
     * gettxtKaigaiJusho
     * @return txtKaigaiJusho
     */
    @JsonProperty("txtKaigaiJusho")
    public TextBoxJusho getTxtKaigaiJusho() {
        return txtKaigaiJusho;
    }

    /*
     * settxtKaigaiJusho
     * @param txtKaigaiJusho txtKaigaiJusho
     */
    @JsonProperty("txtKaigaiJusho")
    public void setTxtKaigaiJusho(TextBoxJusho txtKaigaiJusho) {
        this.txtKaigaiJusho = txtKaigaiJusho;
    }

    /*
     * gettxtDokyoKazoku
     * @return txtDokyoKazoku
     */
    @JsonProperty("txtDokyoKazoku")
    public TextBox getTxtDokyoKazoku() {
        return txtDokyoKazoku;
    }

    /*
     * settxtDokyoKazoku
     * @param txtDokyoKazoku txtDokyoKazoku
     */
    @JsonProperty("txtDokyoKazoku")
    public void setTxtDokyoKazoku(TextBox txtDokyoKazoku) {
        this.txtDokyoKazoku = txtDokyoKazoku;
    }

    /*
     * gettxtKaigaiTelNo
     * @return txtKaigaiTelNo
     */
    @JsonProperty("txtKaigaiTelNo")
    public TextBoxTelNo getTxtKaigaiTelNo() {
        return txtKaigaiTelNo;
    }

    /*
     * settxtKaigaiTelNo
     * @param txtKaigaiTelNo txtKaigaiTelNo
     */
    @JsonProperty("txtKaigaiTelNo")
    public void setTxtKaigaiTelNo(TextBoxTelNo txtKaigaiTelNo) {
        this.txtKaigaiTelNo = txtKaigaiTelNo;
    }

    /*
     * gettxtKaigaiFaxNo
     * @return txtKaigaiFaxNo
     */
    @JsonProperty("txtKaigaiFaxNo")
    public TextBoxTelNo getTxtKaigaiFaxNo() {
        return txtKaigaiFaxNo;
    }

    /*
     * settxtKaigaiFaxNo
     * @param txtKaigaiFaxNo txtKaigaiFaxNo
     */
    @JsonProperty("txtKaigaiFaxNo")
    public void setTxtKaigaiFaxNo(TextBoxTelNo txtKaigaiFaxNo) {
        this.txtKaigaiFaxNo = txtKaigaiFaxNo;
    }

    /*
     * gettxtKaigaiMailAddress
     * @return txtKaigaiMailAddress
     */
    @JsonProperty("txtKaigaiMailAddress")
    public TextBoxMailAddress getTxtKaigaiMailAddress() {
        return txtKaigaiMailAddress;
    }

    /*
     * settxtKaigaiMailAddress
     * @param txtKaigaiMailAddress txtKaigaiMailAddress
     */
    @JsonProperty("txtKaigaiMailAddress")
    public void setTxtKaigaiMailAddress(TextBoxMailAddress txtKaigaiMailAddress) {
        this.txtKaigaiMailAddress = txtKaigaiMailAddress;
    }

    /*
     * getccdRyojikan
     * @return ccdRyojikan
     */
    @JsonProperty("ccdRyojikan")
    public IRyojikanCodeSelectDiv getCcdRyojikan() {
        return ccdRyojikan;
    }

    /*
     * gettxtJuteiYMD
     * @return txtJuteiYMD
     */
    @JsonProperty("txtJuteiYMD")
    public TextBoxDate getTxtJuteiYMD() {
        return txtJuteiYMD;
    }

    /*
     * settxtJuteiYMD
     * @param txtJuteiYMD txtJuteiYMD
     */
    @JsonProperty("txtJuteiYMD")
    public void setTxtJuteiYMD(TextBoxDate txtJuteiYMD) {
        this.txtJuteiYMD = txtJuteiYMD;
    }

    /*
     * getlblSofusaki
     * @return lblSofusaki
     */
    @JsonProperty("lblSofusaki")
    public Label getLblSofusaki() {
        return lblSofusaki;
    }

    /*
     * setlblSofusaki
     * @param lblSofusaki lblSofusaki
     */
    @JsonProperty("lblSofusaki")
    public void setLblSofusaki(Label lblSofusaki) {
        this.lblSofusaki = lblSofusaki;
    }

    /*
     * gettxtKaigaiSofusakiJusho
     * @return txtKaigaiSofusakiJusho
     */
    @JsonProperty("txtKaigaiSofusakiJusho")
    public TextBoxJusho getTxtKaigaiSofusakiJusho() {
        return txtKaigaiSofusakiJusho;
    }

    /*
     * settxtKaigaiSofusakiJusho
     * @param txtKaigaiSofusakiJusho txtKaigaiSofusakiJusho
     */
    @JsonProperty("txtKaigaiSofusakiJusho")
    public void setTxtKaigaiSofusakiJusho(TextBoxJusho txtKaigaiSofusakiJusho) {
        this.txtKaigaiSofusakiJusho = txtKaigaiSofusakiJusho;
    }

    /*
     * gettxtKaigaiSofusakiAtena
     * @return txtKaigaiSofusakiAtena
     */
    @JsonProperty("txtKaigaiSofusakiAtena")
    public TextBox getTxtKaigaiSofusakiAtena() {
        return txtKaigaiSofusakiAtena;
    }

    /*
     * settxtKaigaiSofusakiAtena
     * @param txtKaigaiSofusakiAtena txtKaigaiSofusakiAtena
     */
    @JsonProperty("txtKaigaiSofusakiAtena")
    public void setTxtKaigaiSofusakiAtena(TextBox txtKaigaiSofusakiAtena) {
        this.txtKaigaiSofusakiAtena = txtKaigaiSofusakiAtena;
    }

    // </editor-fold>
}
