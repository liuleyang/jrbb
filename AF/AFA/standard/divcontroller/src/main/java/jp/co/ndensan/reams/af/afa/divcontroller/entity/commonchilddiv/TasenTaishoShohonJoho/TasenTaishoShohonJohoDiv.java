package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TasenTaishoShohonJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyoShuruiSelect.ISenkyoShuruiSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyoShuruiSelect.SenkyoShuruiSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyokuCodeSelect.ISenkyokuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyokuCodeSelect.SenkyokuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.ur.urz.definition.core.view.DisplayMode;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
public class TasenTaishoShohonJohoDiv extends Panel implements ITasenTaishoShohonJohoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdSenkyoShurui")
    private SenkyoShuruiSelectDiv ccdSenkyoShurui;
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
    @JsonProperty("ccdSenkyokuCode")
    private SenkyokuCodeSelectDiv ccdSenkyokuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdSenkyoShurui
     * @return ccdSenkyoShurui
     */
    @JsonProperty("ccdSenkyoShurui")
    public ISenkyoShuruiSelectDiv getCcdSenkyoShurui() {
        return ccdSenkyoShurui;
    }

    /*
     * gettxtShiyoShohon
     * @return txtShiyoShohon
     */
    @JsonProperty("txtShiyoShohon")
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
    public IShohonNameListDiv getCcdShohonNameList() {
        return ccdShohonNameList;
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
     * gettxtSenkyoName
     * @return txtSenkyoName
     */
    @JsonProperty("txtSenkyoName")
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
     * getccdSenkyokuCode
     * @return ccdSenkyokuCode
     */
    @JsonProperty("ccdSenkyokuCode")
    public ISenkyokuCodeSelectDiv getCcdSenkyokuCode() {
        return ccdSenkyokuCode;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(SenkyoShurui senkyoShurui, DisplayMode displayMode) {
        getHandler().initialize(senkyoShurui, displayMode);
    }

    @Override
    public void clearData() {
        getHandler().clearThisPanel();
    }

    @JsonIgnore
    public TasenTaishoShohonJohoHandler getHandler() {
        return new TasenTaishoShohonJohoHandler(this);
    }

}
