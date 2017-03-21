package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuTaishoShohonJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * KaikuTaishoShohonJoho のクラスファイル
 *
 * @author 自動生成
 */
public class KaikuTaishoShohonJohoDiv extends Panel implements IKaikuTaishoShohonJohoDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShiyoShohon")
    private TextBox txtShiyoShohon;
    @JsonProperty("radShori")
    private RadioButton radShori;
    @JsonProperty("ccdShohonNameList")
    private ShohonNameListDiv ccdShohonNameList;
    @JsonProperty("txtShohonName")
    private TextBox txtShohonName;
    @JsonProperty("txtSenkyoName")
    private TextBox txtSenkyoName;
    @JsonProperty("txtKijunYMD")
    private TextBoxDate txtKijunYMD;
    @JsonProperty("txtTohyoYMD")
    private TextBoxDate txtTohyoYMD;
    @JsonProperty("txtTohyoUketsukeYMD")
    private TextBoxDate txtTohyoUketsukeYMD;
    @JsonProperty("chkMutohyo")
    private CheckBoxList chkMutohyo;
    @JsonProperty("hidMotoData")
    private RString hidMotoData;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShiyoShohon
     * @return txtShiyoShohon
     */
    @JsonProperty("txtShiyoShohon")
    @Override
    public TextBox getTxtShiyoShohon() {
        return txtShiyoShohon;
    }

    /*
     * settxtShiyoShohon
     * @param txtShiyoShohon txtShiyoShohon
     */
    @JsonProperty("txtShiyoShohon")
    public void setTxtShiyoShohon(TextBox txtShiyoShohon) {
        this.txtShiyoShohon = txtShiyoShohon;
    }

    /*
     * getradShori
     * @return radShori
     */
    @JsonProperty("radShori")
    @Override
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
     * getccdShohonNameList
     * @return ccdShohonNameList
     */
    @JsonProperty("ccdShohonNameList")
    @Override
    public IShohonNameListDiv getCcdShohonNameList() {
        return ccdShohonNameList;
    }

    /*
     * gettxtShohonName
     * @return txtShohonName
     */
    @JsonProperty("txtShohonName")
    @Override
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
     * gettxtSenkyoName
     * @return txtSenkyoName
     */
    @JsonProperty("txtSenkyoName")
    @Override
    public TextBox getTxtSenkyoName() {
        return txtSenkyoName;
    }

    /*
     * settxtSenkyoName
     * @param txtSenkyoName txtSenkyoName
     */
    @JsonProperty("txtSenkyoName")
    public void setTxtSenkyoName(TextBox txtSenkyoName) {
        this.txtSenkyoName = txtSenkyoName;
    }

    /*
     * gettxtKijunYMD
     * @return txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    @Override
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
     * gettxtTohyoYMD
     * @return txtTohyoYMD
     */
    @JsonProperty("txtTohyoYMD")
    @Override
    public TextBoxDate getTxtTohyoYMD() {
        return txtTohyoYMD;
    }

    /*
     * settxtTohyoYMD
     * @param txtTohyoYMD txtTohyoYMD
     */
    @JsonProperty("txtTohyoYMD")
    public void setTxtTohyoYMD(TextBoxDate txtTohyoYMD) {
        this.txtTohyoYMD = txtTohyoYMD;
    }

    /*
     * gettxtTohyoUketsukeYMD
     * @return txtTohyoUketsukeYMD
     */
    @JsonProperty("txtTohyoUketsukeYMD")
    @Override
    public TextBoxDate getTxtTohyoUketsukeYMD() {
        return txtTohyoUketsukeYMD;
    }

    /*
     * settxtTohyoUketsukeYMD
     * @param txtTohyoUketsukeYMD txtTohyoUketsukeYMD
     */
    @JsonProperty("txtTohyoUketsukeYMD")
    public void setTxtTohyoUketsukeYMD(TextBoxDate txtTohyoUketsukeYMD) {
        this.txtTohyoUketsukeYMD = txtTohyoUketsukeYMD;
    }

    /*
     * getchkMutohyo
     * @return chkMutohyo
     */
    @JsonProperty("chkMutohyo")
    @Override
    public CheckBoxList getChkMutohyo() {
        return chkMutohyo;
    }

    /*
     * setchkMutohyo
     * @param chkMutohyo chkMutohyo
     */
    @JsonProperty("chkMutohyo")
    public void setChkMutohyo(CheckBoxList chkMutohyo) {
        this.chkMutohyo = chkMutohyo;
    }

    /*
     * gethidMotoData
     * @return hidMotoData
     */
    @JsonProperty("hidMotoData")
    @Override
    public RString getHidMotoData() {
        return hidMotoData;
    }

    /*
     * sethidMotoData
     * @param hidMotoData hidMotoData
     */
    @JsonProperty("hidMotoData")
    public void setHidMotoData(RString hidMotoData) {
        this.hidMotoData = hidMotoData;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public boolean initialize() {
        return getHandler().initialize();
    }

    @Override
    public void clearData() {
        getHandler().clearThisPanel();
    }

    @JsonIgnore
    public KaikuTaishoShohonJohoHandler getHandler() {
        return new KaikuTaishoShohonJohoHandler(this);
    }

    @Override
    public ValidationMessageControlPairs 入力日付のチェック() {
        return getValidationHandler().validate();
    }

    @JsonIgnore
    public KaikuTaishoShohonJohoValidationHandler getValidationHandler() {
        return new KaikuTaishoShohonJohoValidationHandler(this);
    }
}
