package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.YubinShikaku;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JiyuNameList.IJiyuNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JiyuNameList.JiyuNameListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxKana;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxAtenaMeisho;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxJusho;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxSetaiCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxShikibetsuCode;

/**
 * YubinShikaku のクラスファイル
 *
 * @reamsid_L AF-0200-020 liuj2
 */
public class YubinShikakuDiv extends Panel implements IYubinShikakuDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radShikakuKubun")
    private RadioButton radShikakuKubun;
    @JsonProperty("chkShikakuJoken")
    private CheckBoxList chkShikakuJoken;
    @JsonProperty("txtShikakuTorokuYMD")
    private TextBoxDate txtShikakuTorokuYMD;
    @JsonProperty("txtKofuYMD")
    private TextBoxDate txtKofuYMD;
    @JsonProperty("txtKofuNo")
    private TextBox txtKofuNo;
    @JsonProperty("btnSaiban")
    private Button btnSaiban;
    @JsonProperty("txtManryoYMD")
    private TextBoxDate txtManryoYMD;
    @JsonProperty("txtMasshoYMD")
    private TextBoxDate txtMasshoYMD;
    @JsonProperty("ccdMasshoJiyu")
    private JiyuNameListDiv ccdMasshoJiyu;
    @JsonProperty("linLine")
    private HorizontalLine linLine;
    @JsonProperty("lblKisaisha")
    private Label lblKisaisha;
    @JsonProperty("btnSearchSimple")
    private ButtonDialog btnSearchSimple;
    @JsonProperty("btnDirectInput")
    private Button btnDirectInput;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("txtDairiKanjiShimei")
    private TextBoxAtenaMeisho txtDairiKanjiShimei;
    @JsonProperty("txtDairiSeinengappiYMD")
    private TextBoxFlexibleDate txtDairiSeinengappiYMD;
    @JsonProperty("txtDairiNenrei")
    private TextBox txtDairiNenrei;
    @JsonProperty("ddlDairiSeibetsu")
    private DropDownList ddlDairiSeibetsu;
    @JsonProperty("txtDairiJuminShubetsu")
    private TextBox txtDairiJuminShubetsu;
    @JsonProperty("txtDairiKanaShimei")
    private TextBoxKana txtDairiKanaShimei;
    @JsonProperty("txtDairiShikibetsuCode")
    private TextBoxShikibetsuCode txtDairiShikibetsuCode;
    @JsonProperty("txtDairiSetaiCode")
    private TextBoxSetaiCode txtDairiSetaiCode;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtDairiJusho")
    private TextBoxJusho txtDairiJusho;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("txtHdnSenkyoShurui")
    private RString txtHdnSenkyoShurui;
    @JsonProperty("txtHdnShikibetsuCode")
    private RString txtHdnShikibetsuCode;
    @JsonProperty("txtHdnAfT114Seq")
    private RString txtHdnAfT114Seq;
    @JsonProperty("txtHdnAfT115Seq")
    private RString txtHdnAfT115Seq;
    @JsonProperty("SearchSimpleJuminModel")
    private RString SearchSimpleJuminModel;
    @JsonProperty("hdnIsDailog")
    private RString hdnIsDailog;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradShikakuKubun
     * @return radShikakuKubun
     */
    @JsonProperty("radShikakuKubun")
    public RadioButton getRadShikakuKubun() {
        return radShikakuKubun;
    }

    /*
     * setradShikakuKubun
     * @param radShikakuKubun radShikakuKubun
     */
    @JsonProperty("radShikakuKubun")
    public void setRadShikakuKubun(RadioButton radShikakuKubun) {
        this.radShikakuKubun = radShikakuKubun;
    }

    /*
     * getchkShikakuJoken
     * @return chkShikakuJoken
     */
    @JsonProperty("chkShikakuJoken")
    public CheckBoxList getChkShikakuJoken() {
        return chkShikakuJoken;
    }

    /*
     * setchkShikakuJoken
     * @param chkShikakuJoken chkShikakuJoken
     */
    @JsonProperty("chkShikakuJoken")
    public void setChkShikakuJoken(CheckBoxList chkShikakuJoken) {
        this.chkShikakuJoken = chkShikakuJoken;
    }

    /*
     * gettxtShikakuTorokuYMD
     * @return txtShikakuTorokuYMD
     */
    @JsonProperty("txtShikakuTorokuYMD")
    public TextBoxDate getTxtShikakuTorokuYMD() {
        return txtShikakuTorokuYMD;
    }

    /*
     * settxtShikakuTorokuYMD
     * @param txtShikakuTorokuYMD txtShikakuTorokuYMD
     */
    @JsonProperty("txtShikakuTorokuYMD")
    public void setTxtShikakuTorokuYMD(TextBoxDate txtShikakuTorokuYMD) {
        this.txtShikakuTorokuYMD = txtShikakuTorokuYMD;
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
     * getbtnSaiban
     * @return btnSaiban
     */
    @JsonProperty("btnSaiban")
    public Button getBtnSaiban() {
        return btnSaiban;
    }

    /*
     * setbtnSaiban
     * @param btnSaiban btnSaiban
     */
    @JsonProperty("btnSaiban")
    public void setBtnSaiban(Button btnSaiban) {
        this.btnSaiban = btnSaiban;
    }

    /*
     * gettxtManryoYMD
     * @return txtManryoYMD
     */
    @JsonProperty("txtManryoYMD")
    public TextBoxDate getTxtManryoYMD() {
        return txtManryoYMD;
    }

    /*
     * settxtManryoYMD
     * @param txtManryoYMD txtManryoYMD
     */
    @JsonProperty("txtManryoYMD")
    public void setTxtManryoYMD(TextBoxDate txtManryoYMD) {
        this.txtManryoYMD = txtManryoYMD;
    }

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
     * getccdMasshoJiyu
     * @return ccdMasshoJiyu
     */
    @JsonProperty("ccdMasshoJiyu")
    public IJiyuNameListDiv getCcdMasshoJiyu() {
        return ccdMasshoJiyu;
    }

    /*
     * getlinLine
     * @return linLine
     */
    @JsonProperty("linLine")
    public HorizontalLine getLinLine() {
        return linLine;
    }

    /*
     * setlinLine
     * @param linLine linLine
     */
    @JsonProperty("linLine")
    public void setLinLine(HorizontalLine linLine) {
        this.linLine = linLine;
    }

    /*
     * getlblKisaisha
     * @return lblKisaisha
     */
    @JsonProperty("lblKisaisha")
    public Label getLblKisaisha() {
        return lblKisaisha;
    }

    /*
     * setlblKisaisha
     * @param lblKisaisha lblKisaisha
     */
    @JsonProperty("lblKisaisha")
    public void setLblKisaisha(Label lblKisaisha) {
        this.lblKisaisha = lblKisaisha;
    }

    /*
     * getbtnSearchSimple
     * @return btnSearchSimple
     */
    @JsonProperty("btnSearchSimple")
    public ButtonDialog getBtnSearchSimple() {
        return btnSearchSimple;
    }

    /*
     * setbtnSearchSimple
     * @param btnSearchSimple btnSearchSimple
     */
    @JsonProperty("btnSearchSimple")
    public void setBtnSearchSimple(ButtonDialog btnSearchSimple) {
        this.btnSearchSimple = btnSearchSimple;
    }

    /*
     * getbtnDirectInput
     * @return btnDirectInput
     */
    @JsonProperty("btnDirectInput")
    public Button getBtnDirectInput() {
        return btnDirectInput;
    }

    /*
     * setbtnDirectInput
     * @param btnDirectInput btnDirectInput
     */
    @JsonProperty("btnDirectInput")
    public void setBtnDirectInput(Button btnDirectInput) {
        this.btnDirectInput = btnDirectInput;
    }

    /*
     * getbtnClear
     * @return btnClear
     */
    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    /*
     * setbtnClear
     * @param btnClear btnClear
     */
    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear = btnClear;
    }

    /*
     * gettxtDairiKanjiShimei
     * @return txtDairiKanjiShimei
     */
    @JsonProperty("txtDairiKanjiShimei")
    public TextBoxAtenaMeisho getTxtDairiKanjiShimei() {
        return txtDairiKanjiShimei;
    }

    /*
     * settxtDairiKanjiShimei
     * @param txtDairiKanjiShimei txtDairiKanjiShimei
     */
    @JsonProperty("txtDairiKanjiShimei")
    public void setTxtDairiKanjiShimei(TextBoxAtenaMeisho txtDairiKanjiShimei) {
        this.txtDairiKanjiShimei = txtDairiKanjiShimei;
    }

    /*
     * gettxtDairiSeinengappiYMD
     * @return txtDairiSeinengappiYMD
     */
    @JsonProperty("txtDairiSeinengappiYMD")
    public TextBoxFlexibleDate getTxtDairiSeinengappiYMD() {
        return txtDairiSeinengappiYMD;
    }

    /*
     * settxtDairiSeinengappiYMD
     * @param txtDairiSeinengappiYMD txtDairiSeinengappiYMD
     */
    @JsonProperty("txtDairiSeinengappiYMD")
    public void setTxtDairiSeinengappiYMD(TextBoxFlexibleDate txtDairiSeinengappiYMD) {
        this.txtDairiSeinengappiYMD = txtDairiSeinengappiYMD;
    }

    /*
     * gettxtDairiNenrei
     * @return txtDairiNenrei
     */
    @JsonProperty("txtDairiNenrei")
    public TextBox getTxtDairiNenrei() {
        return txtDairiNenrei;
    }

    /*
     * settxtDairiNenrei
     * @param txtDairiNenrei txtDairiNenrei
     */
    @JsonProperty("txtDairiNenrei")
    public void setTxtDairiNenrei(TextBox txtDairiNenrei) {
        this.txtDairiNenrei = txtDairiNenrei;
    }

    /*
     * getddlDairiSeibetsu
     * @return ddlDairiSeibetsu
     */
    @JsonProperty("ddlDairiSeibetsu")
    public DropDownList getDdlDairiSeibetsu() {
        return ddlDairiSeibetsu;
    }

    /*
     * setddlDairiSeibetsu
     * @param ddlDairiSeibetsu ddlDairiSeibetsu
     */
    @JsonProperty("ddlDairiSeibetsu")
    public void setDdlDairiSeibetsu(DropDownList ddlDairiSeibetsu) {
        this.ddlDairiSeibetsu = ddlDairiSeibetsu;
    }

    /*
     * gettxtDairiJuminShubetsu
     * @return txtDairiJuminShubetsu
     */
    @JsonProperty("txtDairiJuminShubetsu")
    public TextBox getTxtDairiJuminShubetsu() {
        return txtDairiJuminShubetsu;
    }

    /*
     * settxtDairiJuminShubetsu
     * @param txtDairiJuminShubetsu txtDairiJuminShubetsu
     */
    @JsonProperty("txtDairiJuminShubetsu")
    public void setTxtDairiJuminShubetsu(TextBox txtDairiJuminShubetsu) {
        this.txtDairiJuminShubetsu = txtDairiJuminShubetsu;
    }

    /*
     * gettxtDairiKanaShimei
     * @return txtDairiKanaShimei
     */
    @JsonProperty("txtDairiKanaShimei")
    public TextBoxKana getTxtDairiKanaShimei() {
        return txtDairiKanaShimei;
    }

    /*
     * settxtDairiKanaShimei
     * @param txtDairiKanaShimei txtDairiKanaShimei
     */
    @JsonProperty("txtDairiKanaShimei")
    public void setTxtDairiKanaShimei(TextBoxKana txtDairiKanaShimei) {
        this.txtDairiKanaShimei = txtDairiKanaShimei;
    }

    /*
     * gettxtDairiShikibetsuCode
     * @return txtDairiShikibetsuCode
     */
    @JsonProperty("txtDairiShikibetsuCode")
    public TextBoxShikibetsuCode getTxtDairiShikibetsuCode() {
        return txtDairiShikibetsuCode;
    }

    /*
     * settxtDairiShikibetsuCode
     * @param txtDairiShikibetsuCode txtDairiShikibetsuCode
     */
    @JsonProperty("txtDairiShikibetsuCode")
    public void setTxtDairiShikibetsuCode(TextBoxShikibetsuCode txtDairiShikibetsuCode) {
        this.txtDairiShikibetsuCode = txtDairiShikibetsuCode;
    }

    /*
     * gettxtDairiSetaiCode
     * @return txtDairiSetaiCode
     */
    @JsonProperty("txtDairiSetaiCode")
    public TextBoxSetaiCode getTxtDairiSetaiCode() {
        return txtDairiSetaiCode;
    }

    /*
     * settxtDairiSetaiCode
     * @param txtDairiSetaiCode txtDairiSetaiCode
     */
    @JsonProperty("txtDairiSetaiCode")
    public void setTxtDairiSetaiCode(TextBoxSetaiCode txtDairiSetaiCode) {
        this.txtDairiSetaiCode = txtDairiSetaiCode;
    }

    /*
     * gettxtYubinNo
     * @return txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    /*
     * settxtYubinNo
     * @param txtYubinNo txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo = txtYubinNo;
    }

    /*
     * gettxtDairiJusho
     * @return txtDairiJusho
     */
    @JsonProperty("txtDairiJusho")
    public TextBoxJusho getTxtDairiJusho() {
        return txtDairiJusho;
    }

    /*
     * settxtDairiJusho
     * @param txtDairiJusho txtDairiJusho
     */
    @JsonProperty("txtDairiJusho")
    public void setTxtDairiJusho(TextBoxJusho txtDairiJusho) {
        this.txtDairiJusho = txtDairiJusho;
    }

    /*
     * getbtnCancel
     * @return btnCancel
     */
    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    /*
     * setbtnCancel
     * @param btnCancel btnCancel
     */
    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel = btnCancel;
    }

    /*
     * gettxtHdnSenkyoShurui
     * @return txtHdnSenkyoShurui
     */
    @JsonProperty("txtHdnSenkyoShurui")
    public RString getTxtHdnSenkyoShurui() {
        return txtHdnSenkyoShurui;
    }

    /*
     * settxtHdnSenkyoShurui
     * @param txtHdnSenkyoShurui txtHdnSenkyoShurui
     */
    @JsonProperty("txtHdnSenkyoShurui")
    public void setTxtHdnSenkyoShurui(RString txtHdnSenkyoShurui) {
        this.txtHdnSenkyoShurui = txtHdnSenkyoShurui;
    }

    /*
     * gettxtHdnShikibetsuCode
     * @return txtHdnShikibetsuCode
     */
    @JsonProperty("txtHdnShikibetsuCode")
    public RString getTxtHdnShikibetsuCode() {
        return txtHdnShikibetsuCode;
    }

    /*
     * settxtHdnShikibetsuCode
     * @param txtHdnShikibetsuCode txtHdnShikibetsuCode
     */
    @JsonProperty("txtHdnShikibetsuCode")
    public void setTxtHdnShikibetsuCode(RString txtHdnShikibetsuCode) {
        this.txtHdnShikibetsuCode = txtHdnShikibetsuCode;
    }

    /*
     * gettxtHdnAfT114Seq
     * @return txtHdnAfT114Seq
     */
    @JsonProperty("txtHdnAfT114Seq")
    public RString getTxtHdnAfT114Seq() {
        return txtHdnAfT114Seq;
    }

    /*
     * settxtHdnAfT114Seq
     * @param txtHdnAfT114Seq txtHdnAfT114Seq
     */
    @JsonProperty("txtHdnAfT114Seq")
    public void setTxtHdnAfT114Seq(RString txtHdnAfT114Seq) {
        this.txtHdnAfT114Seq = txtHdnAfT114Seq;
    }

    /*
     * gettxtHdnAfT115Seq
     * @return txtHdnAfT115Seq
     */
    @JsonProperty("txtHdnAfT115Seq")
    public RString getTxtHdnAfT115Seq() {
        return txtHdnAfT115Seq;
    }

    /*
     * settxtHdnAfT115Seq
     * @param txtHdnAfT115Seq txtHdnAfT115Seq
     */
    @JsonProperty("txtHdnAfT115Seq")
    public void setTxtHdnAfT115Seq(RString txtHdnAfT115Seq) {
        this.txtHdnAfT115Seq = txtHdnAfT115Seq;
    }

    /*
     * getSearchSimpleJuminModel
     * @return SearchSimpleJuminModel
     */
    @JsonProperty("SearchSimpleJuminModel")
    public RString getSearchSimpleJuminModel() {
        return SearchSimpleJuminModel;
    }

    /*
     * setSearchSimpleJuminModel
     * @param SearchSimpleJuminModel SearchSimpleJuminModel
     */
    @JsonProperty("SearchSimpleJuminModel")
    public void setSearchSimpleJuminModel(RString SearchSimpleJuminModel) {
        this.SearchSimpleJuminModel = SearchSimpleJuminModel;
    }

    /*
     * gethdnIsDailog
     * @return hdnIsDailog
     */
    @JsonProperty("hdnIsDailog")
    public RString getHdnIsDailog() {
        return hdnIsDailog;
    }

    /*
     * sethdnIsDailog
     * @param hdnIsDailog hdnIsDailog
     */
    @JsonProperty("hdnIsDailog")
    public void setHdnIsDailog(RString hdnIsDailog) {
        this.hdnIsDailog = hdnIsDailog;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(ShikibetsuCode shikibetsuCode, RString senkyoShurui) {
        getHandler().initialize(shikibetsuCode, senkyoShurui);
    }

    @Override
    public void set画面項目制御_資格登録画面以外() {
        getHandler().set画面項目制御_資格登録画面以外();
    }

    @Override
    public void set画面項目制御_代理記載者情報非活性() {
        getHandler().set画面項目制御_代理記載者情報非活性();
    }

    @Override
    public void clear代理記載者情報() {
        getHandler().clear代理記載者情報();
    }

    @Override
    public YubinShikakuDiv get郵便等投票資格情報() {
        return this;
    }

    @JsonIgnore
    public YubinShikakuHandler getHandler() {
        return new YubinShikakuHandler(this);
    }
}
