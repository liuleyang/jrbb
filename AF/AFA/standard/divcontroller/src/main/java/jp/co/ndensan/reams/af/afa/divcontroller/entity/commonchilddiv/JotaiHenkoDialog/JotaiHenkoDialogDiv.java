package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JotaiHenkoDialog;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboBango.IMeiboBangoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboBango.MeiboBangoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JotaiHenkoDialog のクラスファイル
 *
 * @author 自動生成
 */
public class JotaiHenkoDialogDiv extends Panel implements IJotaiHenkoDialogDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShikibetsuCode")
    private TextBoxShikibetsuCode txtShikibetsuCode;
    @JsonProperty("txtShimei")
    private TextBoxAtenaMeisho txtShimei;
    @JsonProperty("txtSetaiCode")
    private TextBoxSetaiCode txtSetaiCode;
    @JsonProperty("txtGroupCode")
    private TextBox txtGroupCode;
    @JsonProperty("txtTohyokuCode")
    private TextBox txtTohyokuCode;
    @JsonProperty("ccdMeiboBango")
    private MeiboBangoDiv ccdMeiboBango;
    @JsonProperty("linLine")
    private HorizontalLine linLine;
    @JsonProperty("lblNo")
    private Label lblNo;
    @JsonProperty("lblSenkyoMei")
    private Label lblSenkyoMei;
    @JsonProperty("lblTohyoJokyo")
    private Label lblTohyoJokyo;
    @JsonProperty("txtNo1")
    private TextBox txtNo1;
    @JsonProperty("txtSenkyoMei1")
    private TextBox txtSenkyoMei1;
    @JsonProperty("txtTohyoJokyo1")
    private TextBox txtTohyoJokyo1;
    @JsonProperty("ddlTohyoJokyo1")
    private DropDownList ddlTohyoJokyo1;
    @JsonProperty("LabelTohyoJokyo1")
    private Label LabelTohyoJokyo1;
    @JsonProperty("txtNo2")
    private TextBox txtNo2;
    @JsonProperty("txtSenkyoMei2")
    private TextBox txtSenkyoMei2;
    @JsonProperty("txtTohyoJokyo2")
    private TextBox txtTohyoJokyo2;
    @JsonProperty("ddlTohyoJokyo2")
    private DropDownList ddlTohyoJokyo2;
    @JsonProperty("LabelTohyoJokyo2")
    private Label LabelTohyoJokyo2;
    @JsonProperty("txtNo3")
    private TextBox txtNo3;
    @JsonProperty("txtSenkyoMei3")
    private TextBox txtSenkyoMei3;
    @JsonProperty("txtTohyoJokyo3")
    private TextBox txtTohyoJokyo3;
    @JsonProperty("ddlTohyoJokyo3")
    private DropDownList ddlTohyoJokyo3;
    @JsonProperty("LabelTohyoJokyo3")
    private Label LabelTohyoJokyo3;
    @JsonProperty("txtNo4")
    private TextBox txtNo4;
    @JsonProperty("txtSenkyoMei4")
    private TextBox txtSenkyoMei4;
    @JsonProperty("txtTohyoJokyo4")
    private TextBox txtTohyoJokyo4;
    @JsonProperty("ddlTohyoJokyo4")
    private DropDownList ddlTohyoJokyo4;
    @JsonProperty("LabelTohyoJokyo4")
    private Label LabelTohyoJokyo4;
    @JsonProperty("txtNo5")
    private TextBox txtNo5;
    @JsonProperty("txtSenkyoMei5")
    private TextBox txtSenkyoMei5;
    @JsonProperty("txtTohyoJokyo5")
    private TextBox txtTohyoJokyo5;
    @JsonProperty("ddlTohyoJokyo5")
    private DropDownList ddlTohyoJokyo5;
    @JsonProperty("LabelTohyoJokyo5")
    private Label LabelTohyoJokyo5;
    @JsonProperty("txtNo6")
    private TextBox txtNo6;
    @JsonProperty("txtSenkyoMei6")
    private TextBox txtSenkyoMei6;
    @JsonProperty("txtTohyoJokyo6")
    private TextBox txtTohyoJokyo6;
    @JsonProperty("ddlTohyoJokyo6")
    private DropDownList ddlTohyoJokyo6;
    @JsonProperty("LabelTohyoJokyo6")
    private Label LabelTohyoJokyo6;
    @JsonProperty("txtNo7")
    private TextBox txtNo7;
    @JsonProperty("txtSenkyoMei7")
    private TextBox txtSenkyoMei7;
    @JsonProperty("txtTohyoJokyo7")
    private TextBox txtTohyoJokyo7;
    @JsonProperty("ddlTohyoJokyo7")
    private DropDownList ddlTohyoJokyo7;
    @JsonProperty("LabelTohyoJokyo7")
    private Label LabelTohyoJokyo7;
    @JsonProperty("txtNo8")
    private TextBox txtNo8;
    @JsonProperty("txtSenkyoMei8")
    private TextBox txtSenkyoMei8;
    @JsonProperty("txtTohyoJokyo8")
    private TextBox txtTohyoJokyo8;
    @JsonProperty("ddlTohyoJokyo8")
    private DropDownList ddlTohyoJokyo8;
    @JsonProperty("LabelTohyoJokyo8")
    private Label LabelTohyoJokyo8;
    @JsonProperty("txtNo9")
    private TextBox txtNo9;
    @JsonProperty("txtSenkyoMei9")
    private TextBox txtSenkyoMei9;
    @JsonProperty("txtTohyoJokyo9")
    private TextBox txtTohyoJokyo9;
    @JsonProperty("ddlTohyoJokyo9")
    private DropDownList ddlTohyoJokyo9;
    @JsonProperty("LabelTohyoJokyo9")
    private Label LabelTohyoJokyo9;
    @JsonProperty("btnOK")
    private Button btnOK;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("txtHdnShohonNo")
    private RString txtHdnShohonNo;
    @JsonProperty("JotaiHenkoModel")
    private RString JotaiHenkoModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShikibetsuCode
     * @return txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public TextBoxShikibetsuCode getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    /*
     * settxtShikibetsuCode
     * @param txtShikibetsuCode txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public void setTxtShikibetsuCode(TextBoxShikibetsuCode txtShikibetsuCode) {
        this.txtShikibetsuCode = txtShikibetsuCode;
    }

    /*
     * gettxtShimei
     * @return txtShimei
     */
    @JsonProperty("txtShimei")
    public TextBoxAtenaMeisho getTxtShimei() {
        return txtShimei;
    }

    /*
     * settxtShimei
     * @param txtShimei txtShimei
     */
    @JsonProperty("txtShimei")
    public void setTxtShimei(TextBoxAtenaMeisho txtShimei) {
        this.txtShimei = txtShimei;
    }

    /*
     * gettxtSetaiCode
     * @return txtSetaiCode
     */
    @JsonProperty("txtSetaiCode")
    public TextBoxSetaiCode getTxtSetaiCode() {
        return txtSetaiCode;
    }

    /*
     * settxtSetaiCode
     * @param txtSetaiCode txtSetaiCode
     */
    @JsonProperty("txtSetaiCode")
    public void setTxtSetaiCode(TextBoxSetaiCode txtSetaiCode) {
        this.txtSetaiCode = txtSetaiCode;
    }

    /*
     * gettxtGroupCode
     * @return txtGroupCode
     */
    @JsonProperty("txtGroupCode")
    public TextBox getTxtGroupCode() {
        return txtGroupCode;
    }

    /*
     * settxtGroupCode
     * @param txtGroupCode txtGroupCode
     */
    @JsonProperty("txtGroupCode")
    public void setTxtGroupCode(TextBox txtGroupCode) {
        this.txtGroupCode = txtGroupCode;
    }

    /*
     * gettxtTohyokuCode
     * @return txtTohyokuCode
     */
    @JsonProperty("txtTohyokuCode")
    public TextBox getTxtTohyokuCode() {
        return txtTohyokuCode;
    }

    /*
     * settxtTohyokuCode
     * @param txtTohyokuCode txtTohyokuCode
     */
    @JsonProperty("txtTohyokuCode")
    public void setTxtTohyokuCode(TextBox txtTohyokuCode) {
        this.txtTohyokuCode = txtTohyokuCode;
    }

    /*
     * getccdMeiboBango
     * @return ccdMeiboBango
     */
    @JsonProperty("ccdMeiboBango")
    public IMeiboBangoDiv getCcdMeiboBango() {
        return ccdMeiboBango;
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
     * getlblNo
     * @return lblNo
     */
    @JsonProperty("lblNo")
    public Label getLblNo() {
        return lblNo;
    }

    /*
     * setlblNo
     * @param lblNo lblNo
     */
    @JsonProperty("lblNo")
    public void setLblNo(Label lblNo) {
        this.lblNo = lblNo;
    }

    /*
     * getlblSenkyoMei
     * @return lblSenkyoMei
     */
    @JsonProperty("lblSenkyoMei")
    public Label getLblSenkyoMei() {
        return lblSenkyoMei;
    }

    /*
     * setlblSenkyoMei
     * @param lblSenkyoMei lblSenkyoMei
     */
    @JsonProperty("lblSenkyoMei")
    public void setLblSenkyoMei(Label lblSenkyoMei) {
        this.lblSenkyoMei = lblSenkyoMei;
    }

    /*
     * getlblTohyoJokyo
     * @return lblTohyoJokyo
     */
    @JsonProperty("lblTohyoJokyo")
    public Label getLblTohyoJokyo() {
        return lblTohyoJokyo;
    }

    /*
     * setlblTohyoJokyo
     * @param lblTohyoJokyo lblTohyoJokyo
     */
    @JsonProperty("lblTohyoJokyo")
    public void setLblTohyoJokyo(Label lblTohyoJokyo) {
        this.lblTohyoJokyo = lblTohyoJokyo;
    }

    /*
     * gettxtNo1
     * @return txtNo1
     */
    @JsonProperty("txtNo1")
    public TextBox getTxtNo1() {
        return txtNo1;
    }

    /*
     * settxtNo1
     * @param txtNo1 txtNo1
     */
    @JsonProperty("txtNo1")
    public void setTxtNo1(TextBox txtNo1) {
        this.txtNo1 = txtNo1;
    }

    /*
     * gettxtSenkyoMei1
     * @return txtSenkyoMei1
     */
    @JsonProperty("txtSenkyoMei1")
    public TextBox getTxtSenkyoMei1() {
        return txtSenkyoMei1;
    }

    /*
     * settxtSenkyoMei1
     * @param txtSenkyoMei1 txtSenkyoMei1
     */
    @JsonProperty("txtSenkyoMei1")
    public void setTxtSenkyoMei1(TextBox txtSenkyoMei1) {
        this.txtSenkyoMei1 = txtSenkyoMei1;
    }

    /*
     * gettxtTohyoJokyo1
     * @return txtTohyoJokyo1
     */
    @JsonProperty("txtTohyoJokyo1")
    public TextBox getTxtTohyoJokyo1() {
        return txtTohyoJokyo1;
    }

    /*
     * settxtTohyoJokyo1
     * @param txtTohyoJokyo1 txtTohyoJokyo1
     */
    @JsonProperty("txtTohyoJokyo1")
    public void setTxtTohyoJokyo1(TextBox txtTohyoJokyo1) {
        this.txtTohyoJokyo1 = txtTohyoJokyo1;
    }

    /*
     * getddlTohyoJokyo1
     * @return ddlTohyoJokyo1
     */
    @JsonProperty("ddlTohyoJokyo1")
    public DropDownList getDdlTohyoJokyo1() {
        return ddlTohyoJokyo1;
    }

    /*
     * setddlTohyoJokyo1
     * @param ddlTohyoJokyo1 ddlTohyoJokyo1
     */
    @JsonProperty("ddlTohyoJokyo1")
    public void setDdlTohyoJokyo1(DropDownList ddlTohyoJokyo1) {
        this.ddlTohyoJokyo1 = ddlTohyoJokyo1;
    }

    /*
     * getLabelTohyoJokyo1
     * @return LabelTohyoJokyo1
     */
    @JsonProperty("LabelTohyoJokyo1")
    public Label getLabelTohyoJokyo1() {
        return LabelTohyoJokyo1;
    }

    /*
     * setLabelTohyoJokyo1
     * @param LabelTohyoJokyo1 LabelTohyoJokyo1
     */
    @JsonProperty("LabelTohyoJokyo1")
    public void setLabelTohyoJokyo1(Label LabelTohyoJokyo1) {
        this.LabelTohyoJokyo1 = LabelTohyoJokyo1;
    }

    /*
     * gettxtNo2
     * @return txtNo2
     */
    @JsonProperty("txtNo2")
    public TextBox getTxtNo2() {
        return txtNo2;
    }

    /*
     * settxtNo2
     * @param txtNo2 txtNo2
     */
    @JsonProperty("txtNo2")
    public void setTxtNo2(TextBox txtNo2) {
        this.txtNo2 = txtNo2;
    }

    /*
     * gettxtSenkyoMei2
     * @return txtSenkyoMei2
     */
    @JsonProperty("txtSenkyoMei2")
    public TextBox getTxtSenkyoMei2() {
        return txtSenkyoMei2;
    }

    /*
     * settxtSenkyoMei2
     * @param txtSenkyoMei2 txtSenkyoMei2
     */
    @JsonProperty("txtSenkyoMei2")
    public void setTxtSenkyoMei2(TextBox txtSenkyoMei2) {
        this.txtSenkyoMei2 = txtSenkyoMei2;
    }

    /*
     * gettxtTohyoJokyo2
     * @return txtTohyoJokyo2
     */
    @JsonProperty("txtTohyoJokyo2")
    public TextBox getTxtTohyoJokyo2() {
        return txtTohyoJokyo2;
    }

    /*
     * settxtTohyoJokyo2
     * @param txtTohyoJokyo2 txtTohyoJokyo2
     */
    @JsonProperty("txtTohyoJokyo2")
    public void setTxtTohyoJokyo2(TextBox txtTohyoJokyo2) {
        this.txtTohyoJokyo2 = txtTohyoJokyo2;
    }

    /*
     * getddlTohyoJokyo2
     * @return ddlTohyoJokyo2
     */
    @JsonProperty("ddlTohyoJokyo2")
    public DropDownList getDdlTohyoJokyo2() {
        return ddlTohyoJokyo2;
    }

    /*
     * setddlTohyoJokyo2
     * @param ddlTohyoJokyo2 ddlTohyoJokyo2
     */
    @JsonProperty("ddlTohyoJokyo2")
    public void setDdlTohyoJokyo2(DropDownList ddlTohyoJokyo2) {
        this.ddlTohyoJokyo2 = ddlTohyoJokyo2;
    }

    /*
     * getLabelTohyoJokyo2
     * @return LabelTohyoJokyo2
     */
    @JsonProperty("LabelTohyoJokyo2")
    public Label getLabelTohyoJokyo2() {
        return LabelTohyoJokyo2;
    }

    /*
     * setLabelTohyoJokyo2
     * @param LabelTohyoJokyo2 LabelTohyoJokyo2
     */
    @JsonProperty("LabelTohyoJokyo2")
    public void setLabelTohyoJokyo2(Label LabelTohyoJokyo2) {
        this.LabelTohyoJokyo2 = LabelTohyoJokyo2;
    }

    /*
     * gettxtNo3
     * @return txtNo3
     */
    @JsonProperty("txtNo3")
    public TextBox getTxtNo3() {
        return txtNo3;
    }

    /*
     * settxtNo3
     * @param txtNo3 txtNo3
     */
    @JsonProperty("txtNo3")
    public void setTxtNo3(TextBox txtNo3) {
        this.txtNo3 = txtNo3;
    }

    /*
     * gettxtSenkyoMei3
     * @return txtSenkyoMei3
     */
    @JsonProperty("txtSenkyoMei3")
    public TextBox getTxtSenkyoMei3() {
        return txtSenkyoMei3;
    }

    /*
     * settxtSenkyoMei3
     * @param txtSenkyoMei3 txtSenkyoMei3
     */
    @JsonProperty("txtSenkyoMei3")
    public void setTxtSenkyoMei3(TextBox txtSenkyoMei3) {
        this.txtSenkyoMei3 = txtSenkyoMei3;
    }

    /*
     * gettxtTohyoJokyo3
     * @return txtTohyoJokyo3
     */
    @JsonProperty("txtTohyoJokyo3")
    public TextBox getTxtTohyoJokyo3() {
        return txtTohyoJokyo3;
    }

    /*
     * settxtTohyoJokyo3
     * @param txtTohyoJokyo3 txtTohyoJokyo3
     */
    @JsonProperty("txtTohyoJokyo3")
    public void setTxtTohyoJokyo3(TextBox txtTohyoJokyo3) {
        this.txtTohyoJokyo3 = txtTohyoJokyo3;
    }

    /*
     * getddlTohyoJokyo3
     * @return ddlTohyoJokyo3
     */
    @JsonProperty("ddlTohyoJokyo3")
    public DropDownList getDdlTohyoJokyo3() {
        return ddlTohyoJokyo3;
    }

    /*
     * setddlTohyoJokyo3
     * @param ddlTohyoJokyo3 ddlTohyoJokyo3
     */
    @JsonProperty("ddlTohyoJokyo3")
    public void setDdlTohyoJokyo3(DropDownList ddlTohyoJokyo3) {
        this.ddlTohyoJokyo3 = ddlTohyoJokyo3;
    }

    /*
     * getLabelTohyoJokyo3
     * @return LabelTohyoJokyo3
     */
    @JsonProperty("LabelTohyoJokyo3")
    public Label getLabelTohyoJokyo3() {
        return LabelTohyoJokyo3;
    }

    /*
     * setLabelTohyoJokyo3
     * @param LabelTohyoJokyo3 LabelTohyoJokyo3
     */
    @JsonProperty("LabelTohyoJokyo3")
    public void setLabelTohyoJokyo3(Label LabelTohyoJokyo3) {
        this.LabelTohyoJokyo3 = LabelTohyoJokyo3;
    }

    /*
     * gettxtNo4
     * @return txtNo4
     */
    @JsonProperty("txtNo4")
    public TextBox getTxtNo4() {
        return txtNo4;
    }

    /*
     * settxtNo4
     * @param txtNo4 txtNo4
     */
    @JsonProperty("txtNo4")
    public void setTxtNo4(TextBox txtNo4) {
        this.txtNo4 = txtNo4;
    }

    /*
     * gettxtSenkyoMei4
     * @return txtSenkyoMei4
     */
    @JsonProperty("txtSenkyoMei4")
    public TextBox getTxtSenkyoMei4() {
        return txtSenkyoMei4;
    }

    /*
     * settxtSenkyoMei4
     * @param txtSenkyoMei4 txtSenkyoMei4
     */
    @JsonProperty("txtSenkyoMei4")
    public void setTxtSenkyoMei4(TextBox txtSenkyoMei4) {
        this.txtSenkyoMei4 = txtSenkyoMei4;
    }

    /*
     * gettxtTohyoJokyo4
     * @return txtTohyoJokyo4
     */
    @JsonProperty("txtTohyoJokyo4")
    public TextBox getTxtTohyoJokyo4() {
        return txtTohyoJokyo4;
    }

    /*
     * settxtTohyoJokyo4
     * @param txtTohyoJokyo4 txtTohyoJokyo4
     */
    @JsonProperty("txtTohyoJokyo4")
    public void setTxtTohyoJokyo4(TextBox txtTohyoJokyo4) {
        this.txtTohyoJokyo4 = txtTohyoJokyo4;
    }

    /*
     * getddlTohyoJokyo4
     * @return ddlTohyoJokyo4
     */
    @JsonProperty("ddlTohyoJokyo4")
    public DropDownList getDdlTohyoJokyo4() {
        return ddlTohyoJokyo4;
    }

    /*
     * setddlTohyoJokyo4
     * @param ddlTohyoJokyo4 ddlTohyoJokyo4
     */
    @JsonProperty("ddlTohyoJokyo4")
    public void setDdlTohyoJokyo4(DropDownList ddlTohyoJokyo4) {
        this.ddlTohyoJokyo4 = ddlTohyoJokyo4;
    }

    /*
     * getLabelTohyoJokyo4
     * @return LabelTohyoJokyo4
     */
    @JsonProperty("LabelTohyoJokyo4")
    public Label getLabelTohyoJokyo4() {
        return LabelTohyoJokyo4;
    }

    /*
     * setLabelTohyoJokyo4
     * @param LabelTohyoJokyo4 LabelTohyoJokyo4
     */
    @JsonProperty("LabelTohyoJokyo4")
    public void setLabelTohyoJokyo4(Label LabelTohyoJokyo4) {
        this.LabelTohyoJokyo4 = LabelTohyoJokyo4;
    }

    /*
     * gettxtNo5
     * @return txtNo5
     */
    @JsonProperty("txtNo5")
    public TextBox getTxtNo5() {
        return txtNo5;
    }

    /*
     * settxtNo5
     * @param txtNo5 txtNo5
     */
    @JsonProperty("txtNo5")
    public void setTxtNo5(TextBox txtNo5) {
        this.txtNo5 = txtNo5;
    }

    /*
     * gettxtSenkyoMei5
     * @return txtSenkyoMei5
     */
    @JsonProperty("txtSenkyoMei5")
    public TextBox getTxtSenkyoMei5() {
        return txtSenkyoMei5;
    }

    /*
     * settxtSenkyoMei5
     * @param txtSenkyoMei5 txtSenkyoMei5
     */
    @JsonProperty("txtSenkyoMei5")
    public void setTxtSenkyoMei5(TextBox txtSenkyoMei5) {
        this.txtSenkyoMei5 = txtSenkyoMei5;
    }

    /*
     * gettxtTohyoJokyo5
     * @return txtTohyoJokyo5
     */
    @JsonProperty("txtTohyoJokyo5")
    public TextBox getTxtTohyoJokyo5() {
        return txtTohyoJokyo5;
    }

    /*
     * settxtTohyoJokyo5
     * @param txtTohyoJokyo5 txtTohyoJokyo5
     */
    @JsonProperty("txtTohyoJokyo5")
    public void setTxtTohyoJokyo5(TextBox txtTohyoJokyo5) {
        this.txtTohyoJokyo5 = txtTohyoJokyo5;
    }

    /*
     * getddlTohyoJokyo5
     * @return ddlTohyoJokyo5
     */
    @JsonProperty("ddlTohyoJokyo5")
    public DropDownList getDdlTohyoJokyo5() {
        return ddlTohyoJokyo5;
    }

    /*
     * setddlTohyoJokyo5
     * @param ddlTohyoJokyo5 ddlTohyoJokyo5
     */
    @JsonProperty("ddlTohyoJokyo5")
    public void setDdlTohyoJokyo5(DropDownList ddlTohyoJokyo5) {
        this.ddlTohyoJokyo5 = ddlTohyoJokyo5;
    }

    /*
     * getLabelTohyoJokyo5
     * @return LabelTohyoJokyo5
     */
    @JsonProperty("LabelTohyoJokyo5")
    public Label getLabelTohyoJokyo5() {
        return LabelTohyoJokyo5;
    }

    /*
     * setLabelTohyoJokyo5
     * @param LabelTohyoJokyo5 LabelTohyoJokyo5
     */
    @JsonProperty("LabelTohyoJokyo5")
    public void setLabelTohyoJokyo5(Label LabelTohyoJokyo5) {
        this.LabelTohyoJokyo5 = LabelTohyoJokyo5;
    }

    /*
     * gettxtNo6
     * @return txtNo6
     */
    @JsonProperty("txtNo6")
    public TextBox getTxtNo6() {
        return txtNo6;
    }

    /*
     * settxtNo6
     * @param txtNo6 txtNo6
     */
    @JsonProperty("txtNo6")
    public void setTxtNo6(TextBox txtNo6) {
        this.txtNo6 = txtNo6;
    }

    /*
     * gettxtSenkyoMei6
     * @return txtSenkyoMei6
     */
    @JsonProperty("txtSenkyoMei6")
    public TextBox getTxtSenkyoMei6() {
        return txtSenkyoMei6;
    }

    /*
     * settxtSenkyoMei6
     * @param txtSenkyoMei6 txtSenkyoMei6
     */
    @JsonProperty("txtSenkyoMei6")
    public void setTxtSenkyoMei6(TextBox txtSenkyoMei6) {
        this.txtSenkyoMei6 = txtSenkyoMei6;
    }

    /*
     * gettxtTohyoJokyo6
     * @return txtTohyoJokyo6
     */
    @JsonProperty("txtTohyoJokyo6")
    public TextBox getTxtTohyoJokyo6() {
        return txtTohyoJokyo6;
    }

    /*
     * settxtTohyoJokyo6
     * @param txtTohyoJokyo6 txtTohyoJokyo6
     */
    @JsonProperty("txtTohyoJokyo6")
    public void setTxtTohyoJokyo6(TextBox txtTohyoJokyo6) {
        this.txtTohyoJokyo6 = txtTohyoJokyo6;
    }

    /*
     * getddlTohyoJokyo6
     * @return ddlTohyoJokyo6
     */
    @JsonProperty("ddlTohyoJokyo6")
    public DropDownList getDdlTohyoJokyo6() {
        return ddlTohyoJokyo6;
    }

    /*
     * setddlTohyoJokyo6
     * @param ddlTohyoJokyo6 ddlTohyoJokyo6
     */
    @JsonProperty("ddlTohyoJokyo6")
    public void setDdlTohyoJokyo6(DropDownList ddlTohyoJokyo6) {
        this.ddlTohyoJokyo6 = ddlTohyoJokyo6;
    }

    /*
     * getLabelTohyoJokyo6
     * @return LabelTohyoJokyo6
     */
    @JsonProperty("LabelTohyoJokyo6")
    public Label getLabelTohyoJokyo6() {
        return LabelTohyoJokyo6;
    }

    /*
     * setLabelTohyoJokyo6
     * @param LabelTohyoJokyo6 LabelTohyoJokyo6
     */
    @JsonProperty("LabelTohyoJokyo6")
    public void setLabelTohyoJokyo6(Label LabelTohyoJokyo6) {
        this.LabelTohyoJokyo6 = LabelTohyoJokyo6;
    }

    /*
     * gettxtNo7
     * @return txtNo7
     */
    @JsonProperty("txtNo7")
    public TextBox getTxtNo7() {
        return txtNo7;
    }

    /*
     * settxtNo7
     * @param txtNo7 txtNo7
     */
    @JsonProperty("txtNo7")
    public void setTxtNo7(TextBox txtNo7) {
        this.txtNo7 = txtNo7;
    }

    /*
     * gettxtSenkyoMei7
     * @return txtSenkyoMei7
     */
    @JsonProperty("txtSenkyoMei7")
    public TextBox getTxtSenkyoMei7() {
        return txtSenkyoMei7;
    }

    /*
     * settxtSenkyoMei7
     * @param txtSenkyoMei7 txtSenkyoMei7
     */
    @JsonProperty("txtSenkyoMei7")
    public void setTxtSenkyoMei7(TextBox txtSenkyoMei7) {
        this.txtSenkyoMei7 = txtSenkyoMei7;
    }

    /*
     * gettxtTohyoJokyo7
     * @return txtTohyoJokyo7
     */
    @JsonProperty("txtTohyoJokyo7")
    public TextBox getTxtTohyoJokyo7() {
        return txtTohyoJokyo7;
    }

    /*
     * settxtTohyoJokyo7
     * @param txtTohyoJokyo7 txtTohyoJokyo7
     */
    @JsonProperty("txtTohyoJokyo7")
    public void setTxtTohyoJokyo7(TextBox txtTohyoJokyo7) {
        this.txtTohyoJokyo7 = txtTohyoJokyo7;
    }

    /*
     * getddlTohyoJokyo7
     * @return ddlTohyoJokyo7
     */
    @JsonProperty("ddlTohyoJokyo7")
    public DropDownList getDdlTohyoJokyo7() {
        return ddlTohyoJokyo7;
    }

    /*
     * setddlTohyoJokyo7
     * @param ddlTohyoJokyo7 ddlTohyoJokyo7
     */
    @JsonProperty("ddlTohyoJokyo7")
    public void setDdlTohyoJokyo7(DropDownList ddlTohyoJokyo7) {
        this.ddlTohyoJokyo7 = ddlTohyoJokyo7;
    }

    /*
     * getLabelTohyoJokyo7
     * @return LabelTohyoJokyo7
     */
    @JsonProperty("LabelTohyoJokyo7")
    public Label getLabelTohyoJokyo7() {
        return LabelTohyoJokyo7;
    }

    /*
     * setLabelTohyoJokyo7
     * @param LabelTohyoJokyo7 LabelTohyoJokyo7
     */
    @JsonProperty("LabelTohyoJokyo7")
    public void setLabelTohyoJokyo7(Label LabelTohyoJokyo7) {
        this.LabelTohyoJokyo7 = LabelTohyoJokyo7;
    }

    /*
     * gettxtNo8
     * @return txtNo8
     */
    @JsonProperty("txtNo8")
    public TextBox getTxtNo8() {
        return txtNo8;
    }

    /*
     * settxtNo8
     * @param txtNo8 txtNo8
     */
    @JsonProperty("txtNo8")
    public void setTxtNo8(TextBox txtNo8) {
        this.txtNo8 = txtNo8;
    }

    /*
     * gettxtSenkyoMei8
     * @return txtSenkyoMei8
     */
    @JsonProperty("txtSenkyoMei8")
    public TextBox getTxtSenkyoMei8() {
        return txtSenkyoMei8;
    }

    /*
     * settxtSenkyoMei8
     * @param txtSenkyoMei8 txtSenkyoMei8
     */
    @JsonProperty("txtSenkyoMei8")
    public void setTxtSenkyoMei8(TextBox txtSenkyoMei8) {
        this.txtSenkyoMei8 = txtSenkyoMei8;
    }

    /*
     * gettxtTohyoJokyo8
     * @return txtTohyoJokyo8
     */
    @JsonProperty("txtTohyoJokyo8")
    public TextBox getTxtTohyoJokyo8() {
        return txtTohyoJokyo8;
    }

    /*
     * settxtTohyoJokyo8
     * @param txtTohyoJokyo8 txtTohyoJokyo8
     */
    @JsonProperty("txtTohyoJokyo8")
    public void setTxtTohyoJokyo8(TextBox txtTohyoJokyo8) {
        this.txtTohyoJokyo8 = txtTohyoJokyo8;
    }

    /*
     * getddlTohyoJokyo8
     * @return ddlTohyoJokyo8
     */
    @JsonProperty("ddlTohyoJokyo8")
    public DropDownList getDdlTohyoJokyo8() {
        return ddlTohyoJokyo8;
    }

    /*
     * setddlTohyoJokyo8
     * @param ddlTohyoJokyo8 ddlTohyoJokyo8
     */
    @JsonProperty("ddlTohyoJokyo8")
    public void setDdlTohyoJokyo8(DropDownList ddlTohyoJokyo8) {
        this.ddlTohyoJokyo8 = ddlTohyoJokyo8;
    }

    /*
     * getLabelTohyoJokyo8
     * @return LabelTohyoJokyo8
     */
    @JsonProperty("LabelTohyoJokyo8")
    public Label getLabelTohyoJokyo8() {
        return LabelTohyoJokyo8;
    }

    /*
     * setLabelTohyoJokyo8
     * @param LabelTohyoJokyo8 LabelTohyoJokyo8
     */
    @JsonProperty("LabelTohyoJokyo8")
    public void setLabelTohyoJokyo8(Label LabelTohyoJokyo8) {
        this.LabelTohyoJokyo8 = LabelTohyoJokyo8;
    }

    /*
     * gettxtNo9
     * @return txtNo9
     */
    @JsonProperty("txtNo9")
    public TextBox getTxtNo9() {
        return txtNo9;
    }

    /*
     * settxtNo9
     * @param txtNo9 txtNo9
     */
    @JsonProperty("txtNo9")
    public void setTxtNo9(TextBox txtNo9) {
        this.txtNo9 = txtNo9;
    }

    /*
     * gettxtSenkyoMei9
     * @return txtSenkyoMei9
     */
    @JsonProperty("txtSenkyoMei9")
    public TextBox getTxtSenkyoMei9() {
        return txtSenkyoMei9;
    }

    /*
     * settxtSenkyoMei9
     * @param txtSenkyoMei9 txtSenkyoMei9
     */
    @JsonProperty("txtSenkyoMei9")
    public void setTxtSenkyoMei9(TextBox txtSenkyoMei9) {
        this.txtSenkyoMei9 = txtSenkyoMei9;
    }

    /*
     * gettxtTohyoJokyo9
     * @return txtTohyoJokyo9
     */
    @JsonProperty("txtTohyoJokyo9")
    public TextBox getTxtTohyoJokyo9() {
        return txtTohyoJokyo9;
    }

    /*
     * settxtTohyoJokyo9
     * @param txtTohyoJokyo9 txtTohyoJokyo9
     */
    @JsonProperty("txtTohyoJokyo9")
    public void setTxtTohyoJokyo9(TextBox txtTohyoJokyo9) {
        this.txtTohyoJokyo9 = txtTohyoJokyo9;
    }

    /*
     * getddlTohyoJokyo9
     * @return ddlTohyoJokyo9
     */
    @JsonProperty("ddlTohyoJokyo9")
    public DropDownList getDdlTohyoJokyo9() {
        return ddlTohyoJokyo9;
    }

    /*
     * setddlTohyoJokyo9
     * @param ddlTohyoJokyo9 ddlTohyoJokyo9
     */
    @JsonProperty("ddlTohyoJokyo9")
    public void setDdlTohyoJokyo9(DropDownList ddlTohyoJokyo9) {
        this.ddlTohyoJokyo9 = ddlTohyoJokyo9;
    }

    /*
     * getLabelTohyoJokyo9
     * @return LabelTohyoJokyo9
     */
    @JsonProperty("LabelTohyoJokyo9")
    public Label getLabelTohyoJokyo9() {
        return LabelTohyoJokyo9;
    }

    /*
     * setLabelTohyoJokyo9
     * @param LabelTohyoJokyo9 LabelTohyoJokyo9
     */
    @JsonProperty("LabelTohyoJokyo9")
    public void setLabelTohyoJokyo9(Label LabelTohyoJokyo9) {
        this.LabelTohyoJokyo9 = LabelTohyoJokyo9;
    }

    /*
     * getbtnOK
     * @return btnOK
     */
    @JsonProperty("btnOK")
    public Button getBtnOK() {
        return btnOK;
    }

    /*
     * setbtnOK
     * @param btnOK btnOK
     */
    @JsonProperty("btnOK")
    public void setBtnOK(Button btnOK) {
        this.btnOK = btnOK;
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
     * gettxtHdnShohonNo
     * @return txtHdnShohonNo
     */
    @JsonProperty("txtHdnShohonNo")
    public RString getTxtHdnShohonNo() {
        return txtHdnShohonNo;
    }

    /*
     * settxtHdnShohonNo
     * @param txtHdnShohonNo txtHdnShohonNo
     */
    @JsonProperty("txtHdnShohonNo")
    public void setTxtHdnShohonNo(RString txtHdnShohonNo) {
        this.txtHdnShohonNo = txtHdnShohonNo;
    }

    /*
     * getJotaiHenkoModel
     * @return JotaiHenkoModel
     */
    @JsonProperty("JotaiHenkoModel")
    public RString getJotaiHenkoModel() {
        return JotaiHenkoModel;
    }

    /*
     * setJotaiHenkoModel
     * @param JotaiHenkoModel JotaiHenkoModel
     */
    @JsonProperty("JotaiHenkoModel")
    public void setJotaiHenkoModel(RString JotaiHenkoModel) {
        this.JotaiHenkoModel = JotaiHenkoModel;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
