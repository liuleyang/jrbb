package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboSakuseiKijun;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
public class MeiboSakuseiKijunDiv extends Panel implements IMeiboSakuseiKijunDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
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
    @JsonProperty("txtKijunYMD")
    private TextBoxDate txtKijunYMD;
    @JsonProperty("btnSetYmd")
    private Button btnSetYmd;
    @JsonProperty("txtMeiboTorokuYMD")
    private TextBoxDate txtMeiboTorokuYMD;
    @JsonProperty("txtTenshutsuYMD")
    private TextBoxDate txtTenshutsuYMD;
    @JsonProperty("lblTenshutsuYMD")
    private Label lblTenshutsuYMD;
    @JsonProperty("txtTennyuYMD")
    private TextBoxDate txtTennyuYMD;
    @JsonProperty("lblTennyuYMD")
    private Label lblTennyuYMD;
    @JsonProperty("txtNenreiTotatsuYMD")
    private TextBoxDate txtNenreiTotatsuYMD;
    @JsonProperty("lblNenreiTotatsuYMD")
    private Label lblNenreiTotatsuYMD;
    @JsonProperty("SenkyoNyuryoku")
    private SenkyoNyuryokuDiv SenkyoNyuryoku;
    @JsonProperty("btnSetChohyoYmd")
    private Button btnSetChohyoYmd;
    @JsonProperty("btnHdnChangeShohon")
    private Button btnHdnChangeShohon;
    @JsonProperty("txtHdnSenkyoShurui")
    private RString txtHdnSenkyoShurui;

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
     * gettxtTenshutsuYMD
     * @return txtTenshutsuYMD
     */
    @JsonProperty("txtTenshutsuYMD")
    public TextBoxDate getTxtTenshutsuYMD() {
        return txtTenshutsuYMD;
    }

    /*
     * settxtTenshutsuYMD
     * @param txtTenshutsuYMD txtTenshutsuYMD
     */
    @JsonProperty("txtTenshutsuYMD")
    public void setTxtTenshutsuYMD(TextBoxDate txtTenshutsuYMD) {
        this.txtTenshutsuYMD = txtTenshutsuYMD;
    }

    /*
     * getlblTenshutsuYMD
     * @return lblTenshutsuYMD
     */
    @JsonProperty("lblTenshutsuYMD")
    public Label getLblTenshutsuYMD() {
        return lblTenshutsuYMD;
    }

    /*
     * setlblTenshutsuYMD
     * @param lblTenshutsuYMD lblTenshutsuYMD
     */
    @JsonProperty("lblTenshutsuYMD")
    public void setLblTenshutsuYMD(Label lblTenshutsuYMD) {
        this.lblTenshutsuYMD = lblTenshutsuYMD;
    }

    /*
     * gettxtTennyuYMD
     * @return txtTennyuYMD
     */
    @JsonProperty("txtTennyuYMD")
    public TextBoxDate getTxtTennyuYMD() {
        return txtTennyuYMD;
    }

    /*
     * settxtTennyuYMD
     * @param txtTennyuYMD txtTennyuYMD
     */
    @JsonProperty("txtTennyuYMD")
    public void setTxtTennyuYMD(TextBoxDate txtTennyuYMD) {
        this.txtTennyuYMD = txtTennyuYMD;
    }

    /*
     * getlblTennyuYMD
     * @return lblTennyuYMD
     */
    @JsonProperty("lblTennyuYMD")
    public Label getLblTennyuYMD() {
        return lblTennyuYMD;
    }

    /*
     * setlblTennyuYMD
     * @param lblTennyuYMD lblTennyuYMD
     */
    @JsonProperty("lblTennyuYMD")
    public void setLblTennyuYMD(Label lblTennyuYMD) {
        this.lblTennyuYMD = lblTennyuYMD;
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
     * getlblNenreiTotatsuYMD
     * @return lblNenreiTotatsuYMD
     */
    @JsonProperty("lblNenreiTotatsuYMD")
    public Label getLblNenreiTotatsuYMD() {
        return lblNenreiTotatsuYMD;
    }

    /*
     * setlblNenreiTotatsuYMD
     * @param lblNenreiTotatsuYMD lblNenreiTotatsuYMD
     */
    @JsonProperty("lblNenreiTotatsuYMD")
    public void setLblNenreiTotatsuYMD(Label lblNenreiTotatsuYMD) {
        this.lblNenreiTotatsuYMD = lblNenreiTotatsuYMD;
    }

    /*
     * getSenkyoNyuryoku
     * @return SenkyoNyuryoku
     */
    @JsonProperty("SenkyoNyuryoku")
    public SenkyoNyuryokuDiv getSenkyoNyuryoku() {
        return SenkyoNyuryoku;
    }

    /*
     * setSenkyoNyuryoku
     * @param SenkyoNyuryoku SenkyoNyuryoku
     */
    @JsonProperty("SenkyoNyuryoku")
    public void setSenkyoNyuryoku(SenkyoNyuryokuDiv SenkyoNyuryoku) {
        this.SenkyoNyuryoku = SenkyoNyuryoku;
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

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(SenkyoShurui senkyoShurui) {
        getHandler().initialize(senkyoShurui);
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
    public List<dgSenkyojiSenkyoNyuryoku_Row> get選挙情報() {
        return getHandler().get選挙情報();
    }

    @Override
    public void setSelected抄本項目By定時登録() {
        this.getHandler().setSelected抄本項目By定時登録();
    }

    @Override
    public void setSelected抄本項目By選挙時登録() {
        this.getHandler().setSelected抄本項目By選挙時登録();
    }

    @Override
    public void set処理種類(RString key) {
        this.getRadShori().setSelectedKey(key);
    }

    @JsonIgnore
    public MeiboSakuseiKijunHandler getHandler() {
        return new MeiboSakuseiKijunHandler(this);
    }

}
