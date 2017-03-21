package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ZaigaiSenkyoninJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JiyuNameList.IJiyuNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JiyuNameList.JiyuNameListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
public class ZaigaiShinseiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnKofuRireki")
    private ButtonDialog btnKofuRireki;
    @JsonProperty("ZaigaiShinseiKubun")
    private ZaigaiShinseiKubunDiv ZaigaiShinseiKubun;
    @JsonProperty("txtShinseiYMD")
    private TextBoxDate txtShinseiYMD;
    @JsonProperty("txtShinseiNo")
    private TextBoxCode txtShinseiNo;
    @JsonProperty("btnShinseiNoSaiban")
    private Button btnShinseiNoSaiban;
    @JsonProperty("txtTorisageYMD")
    private TextBoxDate txtTorisageYMD;
    @JsonProperty("ccdTorisageJiyu")
    private JiyuNameListDiv ccdTorisageJiyu;
    @JsonProperty("txtHonsekiShokaiYMD")
    private TextBoxDate txtHonsekiShokaiYMD;
    @JsonProperty("txtHonsekiKaitoYMD")
    private TextBoxDate txtHonsekiKaitoYMD;
    @JsonProperty("txtHonsekiTsutiYMD")
    private TextBoxDate txtHonsekiTsutiYMD;
    @JsonProperty("txtKyakkaYMD")
    private TextBoxDate txtKyakkaYMD;
    @JsonProperty("ccdKyakkaJiyu")
    private JiyuNameListDiv ccdKyakkaJiyu;
    @JsonProperty("txtKofuYMD")
    private TextBoxDate txtKofuYMD;
    @JsonProperty("txtKofuNo")
    private TextBox txtKofuNo;
    @JsonProperty("btnKofuNoSaiban")
    private Button btnKofuNoSaiban;
    @JsonProperty("ccdSaiKofuJiyu")
    private JiyuNameListDiv ccdSaiKofuJiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnKofuRireki
     * @return btnKofuRireki
     */
    @JsonProperty("btnKofuRireki")
    public ButtonDialog getBtnKofuRireki() {
        return btnKofuRireki;
    }

    /*
     * setbtnKofuRireki
     * @param btnKofuRireki btnKofuRireki
     */
    @JsonProperty("btnKofuRireki")
    public void setBtnKofuRireki(ButtonDialog btnKofuRireki) {
        this.btnKofuRireki = btnKofuRireki;
    }

    /*
     * getZaigaiShinseiKubun
     * @return ZaigaiShinseiKubun
     */
    @JsonProperty("ZaigaiShinseiKubun")
    public ZaigaiShinseiKubunDiv getZaigaiShinseiKubun() {
        return ZaigaiShinseiKubun;
    }

    /*
     * setZaigaiShinseiKubun
     * @param ZaigaiShinseiKubun ZaigaiShinseiKubun
     */
    @JsonProperty("ZaigaiShinseiKubun")
    public void setZaigaiShinseiKubun(ZaigaiShinseiKubunDiv ZaigaiShinseiKubun) {
        this.ZaigaiShinseiKubun = ZaigaiShinseiKubun;
    }

    /*
     * gettxtShinseiYMD
     * @return txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public TextBoxDate getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    /*
     * settxtShinseiYMD
     * @param txtShinseiYMD txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public void setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.txtShinseiYMD = txtShinseiYMD;
    }

    /*
     * gettxtShinseiNo
     * @return txtShinseiNo
     */
    @JsonProperty("txtShinseiNo")
    public TextBoxCode getTxtShinseiNo() {
        return txtShinseiNo;
    }

    /*
     * settxtShinseiNo
     * @param txtShinseiNo txtShinseiNo
     */
    @JsonProperty("txtShinseiNo")
    public void setTxtShinseiNo(TextBoxCode txtShinseiNo) {
        this.txtShinseiNo = txtShinseiNo;
    }

    /*
     * getbtnShinseiNoSaiban
     * @return btnShinseiNoSaiban
     */
    @JsonProperty("btnShinseiNoSaiban")
    public Button getBtnShinseiNoSaiban() {
        return btnShinseiNoSaiban;
    }

    /*
     * setbtnShinseiNoSaiban
     * @param btnShinseiNoSaiban btnShinseiNoSaiban
     */
    @JsonProperty("btnShinseiNoSaiban")
    public void setBtnShinseiNoSaiban(Button btnShinseiNoSaiban) {
        this.btnShinseiNoSaiban = btnShinseiNoSaiban;
    }

    /*
     * gettxtTorisageYMD
     * @return txtTorisageYMD
     */
    @JsonProperty("txtTorisageYMD")
    public TextBoxDate getTxtTorisageYMD() {
        return txtTorisageYMD;
    }

    /*
     * settxtTorisageYMD
     * @param txtTorisageYMD txtTorisageYMD
     */
    @JsonProperty("txtTorisageYMD")
    public void setTxtTorisageYMD(TextBoxDate txtTorisageYMD) {
        this.txtTorisageYMD = txtTorisageYMD;
    }

    /*
     * getccdTorisageJiyu
     * @return ccdTorisageJiyu
     */
    @JsonProperty("ccdTorisageJiyu")
    public IJiyuNameListDiv getCcdTorisageJiyu() {
        return ccdTorisageJiyu;
    }

    /*
     * gettxtHonsekiShokaiYMD
     * @return txtHonsekiShokaiYMD
     */
    @JsonProperty("txtHonsekiShokaiYMD")
    public TextBoxDate getTxtHonsekiShokaiYMD() {
        return txtHonsekiShokaiYMD;
    }

    /*
     * settxtHonsekiShokaiYMD
     * @param txtHonsekiShokaiYMD txtHonsekiShokaiYMD
     */
    @JsonProperty("txtHonsekiShokaiYMD")
    public void setTxtHonsekiShokaiYMD(TextBoxDate txtHonsekiShokaiYMD) {
        this.txtHonsekiShokaiYMD = txtHonsekiShokaiYMD;
    }

    /*
     * gettxtHonsekiKaitoYMD
     * @return txtHonsekiKaitoYMD
     */
    @JsonProperty("txtHonsekiKaitoYMD")
    public TextBoxDate getTxtHonsekiKaitoYMD() {
        return txtHonsekiKaitoYMD;
    }

    /*
     * settxtHonsekiKaitoYMD
     * @param txtHonsekiKaitoYMD txtHonsekiKaitoYMD
     */
    @JsonProperty("txtHonsekiKaitoYMD")
    public void setTxtHonsekiKaitoYMD(TextBoxDate txtHonsekiKaitoYMD) {
        this.txtHonsekiKaitoYMD = txtHonsekiKaitoYMD;
    }

    /*
     * gettxtHonsekiTsutiYMD
     * @return txtHonsekiTsutiYMD
     */
    @JsonProperty("txtHonsekiTsutiYMD")
    public TextBoxDate getTxtHonsekiTsutiYMD() {
        return txtHonsekiTsutiYMD;
    }

    /*
     * settxtHonsekiTsutiYMD
     * @param txtHonsekiTsutiYMD txtHonsekiTsutiYMD
     */
    @JsonProperty("txtHonsekiTsutiYMD")
    public void setTxtHonsekiTsutiYMD(TextBoxDate txtHonsekiTsutiYMD) {
        this.txtHonsekiTsutiYMD = txtHonsekiTsutiYMD;
    }

    /*
     * gettxtKyakkaYMD
     * @return txtKyakkaYMD
     */
    @JsonProperty("txtKyakkaYMD")
    public TextBoxDate getTxtKyakkaYMD() {
        return txtKyakkaYMD;
    }

    /*
     * settxtKyakkaYMD
     * @param txtKyakkaYMD txtKyakkaYMD
     */
    @JsonProperty("txtKyakkaYMD")
    public void setTxtKyakkaYMD(TextBoxDate txtKyakkaYMD) {
        this.txtKyakkaYMD = txtKyakkaYMD;
    }

    /*
     * getccdKyakkaJiyu
     * @return ccdKyakkaJiyu
     */
    @JsonProperty("ccdKyakkaJiyu")
    public IJiyuNameListDiv getCcdKyakkaJiyu() {
        return ccdKyakkaJiyu;
    }

    /*
     * gettxtKofuYMD
     * @return txtKofuYMD
     */
    @JsonProperty("txtKofuYMD")
    public TextBoxDate getTxtKofuYMD() {
        return txtKofuYMD;
    }

    /*
     * settxtKofuYMD
     * @param txtKofuYMD txtKofuYMD
     */
    @JsonProperty("txtKofuYMD")
    public void setTxtKofuYMD(TextBoxDate txtKofuYMD) {
        this.txtKofuYMD = txtKofuYMD;
    }

    /*
     * gettxtKofuNo
     * @return txtKofuNo
     */
    @JsonProperty("txtKofuNo")
    public TextBox getTxtKofuNo() {
        return txtKofuNo;
    }

    /*
     * settxtKofuNo
     * @param txtKofuNo txtKofuNo
     */
    @JsonProperty("txtKofuNo")
    public void setTxtKofuNo(TextBox txtKofuNo) {
        this.txtKofuNo = txtKofuNo;
    }

    /*
     * getbtnKofuNoSaiban
     * @return btnKofuNoSaiban
     */
    @JsonProperty("btnKofuNoSaiban")
    public Button getBtnKofuNoSaiban() {
        return btnKofuNoSaiban;
    }

    /*
     * setbtnKofuNoSaiban
     * @param btnKofuNoSaiban btnKofuNoSaiban
     */
    @JsonProperty("btnKofuNoSaiban")
    public void setBtnKofuNoSaiban(Button btnKofuNoSaiban) {
        this.btnKofuNoSaiban = btnKofuNoSaiban;
    }

    /*
     * getccdSaiKofuJiyu
     * @return ccdSaiKofuJiyu
     */
    @JsonProperty("ccdSaiKofuJiyu")
    public IJiyuNameListDiv getCcdSaiKofuJiyu() {
        return ccdSaiKofuJiyu;
    }

    // </editor-fold>
}
