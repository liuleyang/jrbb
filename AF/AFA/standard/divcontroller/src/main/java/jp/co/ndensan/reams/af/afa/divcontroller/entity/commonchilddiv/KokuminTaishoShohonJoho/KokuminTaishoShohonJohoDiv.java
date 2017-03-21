package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminTaishoShohonJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.ur.urz.definition.core.view.DisplayMode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
public class KokuminTaishoShohonJohoDiv extends Panel implements IKokuminTaishoShohonJohoDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radShori")
    private RadioButton radShori;
    @JsonProperty("ccdShohonNameList")
    private ShohonNameListDiv ccdShohonNameList;
    @JsonProperty("txtShohonName")
    private TextBox txtShohonName;
    @JsonProperty("txtTohyoYMD")
    private TextBoxDate txtTohyoYMD;
    @JsonProperty("btnSetYmd")
    private Button btnSetYmd;
    @JsonProperty("txtKijunYMD")
    private TextBoxDate txtKijunYMD;
    @JsonProperty("txtMeiboTorokuYMD")
    private TextBoxDate txtMeiboTorokuYMD;
    @JsonProperty("txtNenreiTotatsuYMD")
    private TextBoxDate txtNenreiTotatsuYMD;
    @JsonProperty("txtTokuteiKigenYMD")
    private TextBoxDate txtTokuteiKigenYMD;
    @JsonProperty("txtTohyoUketsukeYMD")
    private TextBoxDate txtTohyoUketsukeYMD;
    @JsonProperty("btnSetChohyoYmd")
    private Button btnSetChohyoYmd;
    @JsonProperty("btnHdnChangeShohon")
    private Button btnHdnChangeShohon;
    @JsonProperty("txtHidShohonNo")
    private RString txtHidShohonNo;

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
     * gettxtMeiboTorokuYMD
     * @return txtMeiboTorokuYMD
     */
    @JsonProperty("txtMeiboTorokuYMD")
    public TextBoxDate getTxtMeiboTorokuYMD() {
        return txtMeiboTorokuYMD;
    }

    /*
     * settxtMeiboTorokuYMD
     * @param txtMeiboTorokuYMD txtMeiboTorokuYMD
     */
    @JsonProperty("txtMeiboTorokuYMD")
    public void setTxtMeiboTorokuYMD(TextBoxDate txtMeiboTorokuYMD) {
        this.txtMeiboTorokuYMD = txtMeiboTorokuYMD;
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
     * gettxtTokuteiKigenYMD
     * @return txtTokuteiKigenYMD
     */
    @JsonProperty("txtTokuteiKigenYMD")
    public TextBoxDate getTxtTokuteiKigenYMD() {
        return txtTokuteiKigenYMD;
    }

    /*
     * settxtTokuteiKigenYMD
     * @param txtTokuteiKigenYMD txtTokuteiKigenYMD
     */
    @JsonProperty("txtTokuteiKigenYMD")
    public void setTxtTokuteiKigenYMD(TextBoxDate txtTokuteiKigenYMD) {
        this.txtTokuteiKigenYMD = txtTokuteiKigenYMD;
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
     * getbtnSetChohyoYmd
     * @return btnSetChohyoYmd
     */
    @JsonProperty("btnSetChohyoYmd")
    public Button getBtnSetChohyoYmd() {
        return btnSetChohyoYmd;
    }

    /*
     * setbtnSetChohyoYmd
     * @param btnSetChohyoYmd btnSetChohyoYmd
     */
    @JsonProperty("btnSetChohyoYmd")
    public void setBtnSetChohyoYmd(Button btnSetChohyoYmd) {
        this.btnSetChohyoYmd = btnSetChohyoYmd;
    }

    /*
     * getbtnHdnChangeShohon
     * @return btnHdnChangeShohon
     */
    @JsonProperty("btnHdnChangeShohon")
    public Button getBtnHdnChangeShohon() {
        return btnHdnChangeShohon;
    }

    /*
     * setbtnHdnChangeShohon
     * @param btnHdnChangeShohon btnHdnChangeShohon
     */
    @JsonProperty("btnHdnChangeShohon")
    public void setBtnHdnChangeShohon(Button btnHdnChangeShohon) {
        this.btnHdnChangeShohon = btnHdnChangeShohon;
    }

    /*
     * gettxtHidShohonNo
     * @return txtHidShohonNo
     */
    @JsonProperty("txtHidShohonNo")
    public RString getTxtHidShohonNo() {
        return txtHidShohonNo;
    }

    /*
     * settxtHidShohonNo
     * @param txtHidShohonNo txtHidShohonNo
     */
    @JsonProperty("txtHidShohonNo")
    public void setTxtHidShohonNo(RString txtHidShohonNo) {
        this.txtHidShohonNo = txtHidShohonNo;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(DisplayMode displayMode) {
        getHandler().initialize(displayMode);
    }

    @Override
    public void initialSetting() {
        getHandler().initialSetting();
    }

    @Override
    public void clearData() {
        getHandler().clearThisPanel();
    }

    @Override
    public void clickRadShori() {
        getHandler().clickRadShori();
    }

    @Override
    public RString getShoriMode() {
        return getHandler().getShoriMode();
    }

    @JsonIgnore
    public KokuminTaishoShohonJohoHandler getHandler() {
        return new KokuminTaishoShohonJohoHandler(this);
    }

    @Override
    public void initialize(SenkyoShurui senkyoShurui) {
        getHandler().initialize(senkyoShurui);
    }

    @Override
    public KokuminTaishoShohonJohoDiv get国民投票抄本情報() {
        return this;
    }

    @Override
    public RString getHidShohonNo() {
        return this.getTxtHidShohonNo();
    }

    @Override
    public ValidationMessageControlPairs エラーチェックです() {
        return getHandler().エラーチェックです();
    }

    @Override
    public ValidationMessageControlPairs ウォーニングチェックです() {
        return getHandler().ウォーニングチェックです();
    }

    @Override
    public ValidationMessageControlPairs setChohyoYmdチェックです() {
        return getHandler().setChohyoYmdチェックです();
    }

}
