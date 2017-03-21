package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFA1010010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NogyoMeiboKoshinKijun のクラスファイル
 *
 * @author 自動生成
 */
public class NogyoMeiboKoshinKijunDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radShori")
    private RadioButton radShori;
    @JsonProperty("radSakuseiKijun")
    private RadioButton radSakuseiKijun;
    @JsonProperty("txtShohonName")
    private TextBox txtShohonName;
    @JsonProperty("txtKijunYMD")
    private TextBoxDate txtKijunYMD;
    @JsonProperty("btnSetYmd")
    private Button btnSetYmd;
    @JsonProperty("txtKakuteiYMD")
    private TextBoxDate txtKakuteiYMD;
    @JsonProperty("txtNenreiTotatsuYMD")
    private TextBoxDate txtNenreiTotatsuYMD;
    @JsonProperty("ccdShohonNameList")
    private ShohonNameListDiv ccdShohonNameList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradShori
     * @return radShori
     */
    @JsonProperty("radShori")
    public RadioButton getRadShori() {
        return radShori;
    }

    /*
     * setradShori
     * @param radShori radShori
     */
    @JsonProperty("radShori")
    public void setRadShori(RadioButton radShori) {
        this.radShori = radShori;
    }

    /*
     * getradSakuseiKijun
     * @return radSakuseiKijun
     */
    @JsonProperty("radSakuseiKijun")
    public RadioButton getRadSakuseiKijun() {
        return radSakuseiKijun;
    }

    /*
     * setradSakuseiKijun
     * @param radSakuseiKijun radSakuseiKijun
     */
    @JsonProperty("radSakuseiKijun")
    public void setRadSakuseiKijun(RadioButton radSakuseiKijun) {
        this.radSakuseiKijun = radSakuseiKijun;
    }

    /*
     * gettxtShohonName
     * @return txtShohonName
     */
    @JsonProperty("txtShohonName")
    public TextBox getTxtShohonName() {
        return txtShohonName;
    }

    /*
     * settxtShohonName
     * @param txtShohonName txtShohonName
     */
    @JsonProperty("txtShohonName")
    public void setTxtShohonName(TextBox txtShohonName) {
        this.txtShohonName = txtShohonName;
    }

    /*
     * gettxtKijunYMD
     * @return txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    public TextBoxDate getTxtKijunYMD() {
        return txtKijunYMD;
    }

    /*
     * settxtKijunYMD
     * @param txtKijunYMD txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    public void setTxtKijunYMD(TextBoxDate txtKijunYMD) {
        this.txtKijunYMD = txtKijunYMD;
    }

    /*
     * getbtnSetYmd
     * @return btnSetYmd
     */
    @JsonProperty("btnSetYmd")
    public Button getBtnSetYmd() {
        return btnSetYmd;
    }

    /*
     * setbtnSetYmd
     * @param btnSetYmd btnSetYmd
     */
    @JsonProperty("btnSetYmd")
    public void setBtnSetYmd(Button btnSetYmd) {
        this.btnSetYmd = btnSetYmd;
    }

    /*
     * gettxtKakuteiYMD
     * @return txtKakuteiYMD
     */
    @JsonProperty("txtKakuteiYMD")
    public TextBoxDate getTxtKakuteiYMD() {
        return txtKakuteiYMD;
    }

    /*
     * settxtKakuteiYMD
     * @param txtKakuteiYMD txtKakuteiYMD
     */
    @JsonProperty("txtKakuteiYMD")
    public void setTxtKakuteiYMD(TextBoxDate txtKakuteiYMD) {
        this.txtKakuteiYMD = txtKakuteiYMD;
    }

    /*
     * gettxtNenreiTotatsuYMD
     * @return txtNenreiTotatsuYMD
     */
    @JsonProperty("txtNenreiTotatsuYMD")
    public TextBoxDate getTxtNenreiTotatsuYMD() {
        return txtNenreiTotatsuYMD;
    }

    /*
     * settxtNenreiTotatsuYMD
     * @param txtNenreiTotatsuYMD txtNenreiTotatsuYMD
     */
    @JsonProperty("txtNenreiTotatsuYMD")
    public void setTxtNenreiTotatsuYMD(TextBoxDate txtNenreiTotatsuYMD) {
        this.txtNenreiTotatsuYMD = txtNenreiTotatsuYMD;
    }

    /*
     * getccdShohonNameList
     * @return ccdShohonNameList
     */
    @JsonProperty("ccdShohonNameList")
    public IShohonNameListDiv getCcdShohonNameList() {
        return ccdShohonNameList;
    }

    // </editor-fold>
}
