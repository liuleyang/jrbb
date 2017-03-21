package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuDairiTohyosha.ITohyorokuDairiTohyoshaDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuDairiTohyosha.TohyorokuDairiTohyoshaDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuKyohiNyuryoku.ITohyorokuKyohiNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuKyohiNyuryoku.TohyorokuKyohiNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuShimeiNyuryoku.ITohyorokuShimeiNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuShimeiNyuryoku.TohyorokuShimeiNyuryokuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TohyorokuShosai のクラスファイル 
 * 
 * @author 自動生成
 */
public class TohyorokuShosaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShikkoYMD")
    private TextBoxDate txtShikkoYMD;
    @JsonProperty("txtChoseiYMD")
    private TextBoxDate txtChoseiYMD;
    @JsonProperty("txtTohyoYMD")
    private TextBoxDate txtTohyoYMD;
    @JsonProperty("txtSecchiJokyo")
    private TextBox txtSecchiJokyo;
    @JsonProperty("txtKaisetsuBasho")
    private TextBox txtKaisetsuBasho;
    @JsonProperty("txtSecchiKikan")
    private TextBoxDateRange txtSecchiKikan;
    @JsonProperty("lblTachiainin")
    private Label lblTachiainin;
    @JsonProperty("lblTachiaininSenkan")
    private Label lblTachiaininSenkan;
    @JsonProperty("dgTohyorokuTachiaininSenkan")
    private DataGrid<dgTohyorokuTachiaininSenkan_Row> dgTohyorokuTachiaininSenkan;
    @JsonProperty("lblTachiaininKanrisha")
    private Label lblTachiaininKanrisha;
    @JsonProperty("dgTohyorokuTachiaininKanrisha")
    private DataGrid<dgTohyorokuTachiaininKanrisha_Row> dgTohyorokuTachiaininKanrisha;
    @JsonProperty("lblKaiheiTime")
    private Label lblKaiheiTime;
    @JsonProperty("txtKaiheiStartTime")
    private TextBoxTime txtKaiheiStartTime;
    @JsonProperty("txtKaiheiStopTime")
    private TextBoxTime txtKaiheiStopTime;
    @JsonProperty("lblTohyosha")
    private Label lblTohyosha;
    @JsonProperty("txtTohyoshaOtoko")
    private TextBoxNum txtTohyoshaOtoko;
    @JsonProperty("txtTohyoshaOnna")
    private TextBoxNum txtTohyoshaOnna;
    @JsonProperty("txtTohyoshaKei")
    private TextBoxNum txtTohyoshaKei;
    @JsonProperty("lblTohyoshaKari")
    private Label lblTohyoshaKari;
    @JsonProperty("txtKariTohyoshaOtoko")
    private TextBoxNum txtKariTohyoshaOtoko;
    @JsonProperty("txtKariTohyoshaOnna")
    private TextBoxNum txtKariTohyoshaOnna;
    @JsonProperty("txtKariTohyoshaKei")
    private TextBoxNum txtKariTohyoshaKei;
    @JsonProperty("lblSaikofusha")
    private Label lblSaikofusha;
    @JsonProperty("dgTohyorokuSaikofusha")
    private DataGrid<dgTohyorokuSaikofusha_Row> dgTohyorokuSaikofusha;
    @JsonProperty("lblKetteishoSaiketsusho")
    private Label lblKetteishoSaiketsusho;
    @JsonProperty("lblHenkanTohyosha")
    private Label lblHenkanTohyosha;
    @JsonProperty("txtTenjiNinzu")
    private TextBoxNum txtTenjiNinzu;
    @JsonProperty("txtDairiNinzu")
    private TextBoxNum txtDairiNinzu;
    @JsonProperty("lblKyohi")
    private Label lblKyohi;
    @JsonProperty("lblTohyoKyohi")
    private Label lblTohyoKyohi;
    @JsonProperty("lblDairiTohyoKyohi")
    private Label lblDairiTohyoKyohi;
    @JsonProperty("lblJujisha")
    private Label lblJujisha;
    @JsonProperty("txtJimuNinzu")
    private TextBoxNum txtJimuNinzu;
    @JsonProperty("txtShokiNinzu")
    private TextBoxNum txtShokiNinzu;
    @JsonProperty("txtShokuinNinzu")
    private TextBoxNum txtShokuinNinzu;
    @JsonProperty("txtSonotaNinzu")
    private TextBoxNum txtSonotaNinzu;
    @JsonProperty("ccdTohyorokuDairiTohyoKyohi")
    private TohyorokuKyohiNyuryokuDiv ccdTohyorokuDairiTohyoKyohi;
    @JsonProperty("ccdTohyorokuTohyoKyohi")
    private TohyorokuKyohiNyuryokuDiv ccdTohyorokuTohyoKyohi;
    @JsonProperty("ccdTohyorokuDairiTohyosha")
    private TohyorokuDairiTohyoshaDiv ccdTohyorokuDairiTohyosha;
    @JsonProperty("ccdTohyorokuKetteishoSaiketsusho")
    private TohyorokuShimeiNyuryokuDiv ccdTohyorokuKetteishoSaiketsusho;
    @JsonProperty("ccdTohyorokuHenkanTohyosha")
    private TohyorokuShimeiNyuryokuDiv ccdTohyorokuHenkanTohyosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShikkoYMD
     * @return txtShikkoYMD
     */
    @JsonProperty("txtShikkoYMD")
    public TextBoxDate getTxtShikkoYMD() {
        return txtShikkoYMD;
    }

    /*
     * settxtShikkoYMD
     * @param txtShikkoYMD txtShikkoYMD
     */
    @JsonProperty("txtShikkoYMD")
    public void setTxtShikkoYMD(TextBoxDate txtShikkoYMD) {
        this.txtShikkoYMD = txtShikkoYMD;
    }

    /*
     * gettxtChoseiYMD
     * @return txtChoseiYMD
     */
    @JsonProperty("txtChoseiYMD")
    public TextBoxDate getTxtChoseiYMD() {
        return txtChoseiYMD;
    }

    /*
     * settxtChoseiYMD
     * @param txtChoseiYMD txtChoseiYMD
     */
    @JsonProperty("txtChoseiYMD")
    public void setTxtChoseiYMD(TextBoxDate txtChoseiYMD) {
        this.txtChoseiYMD = txtChoseiYMD;
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
     * gettxtSecchiJokyo
     * @return txtSecchiJokyo
     */
    @JsonProperty("txtSecchiJokyo")
    public TextBox getTxtSecchiJokyo() {
        return txtSecchiJokyo;
    }

    /*
     * settxtSecchiJokyo
     * @param txtSecchiJokyo txtSecchiJokyo
     */
    @JsonProperty("txtSecchiJokyo")
    public void setTxtSecchiJokyo(TextBox txtSecchiJokyo) {
        this.txtSecchiJokyo = txtSecchiJokyo;
    }

    /*
     * gettxtKaisetsuBasho
     * @return txtKaisetsuBasho
     */
    @JsonProperty("txtKaisetsuBasho")
    public TextBox getTxtKaisetsuBasho() {
        return txtKaisetsuBasho;
    }

    /*
     * settxtKaisetsuBasho
     * @param txtKaisetsuBasho txtKaisetsuBasho
     */
    @JsonProperty("txtKaisetsuBasho")
    public void setTxtKaisetsuBasho(TextBox txtKaisetsuBasho) {
        this.txtKaisetsuBasho = txtKaisetsuBasho;
    }

    /*
     * gettxtSecchiKikan
     * @return txtSecchiKikan
     */
    @JsonProperty("txtSecchiKikan")
    public TextBoxDateRange getTxtSecchiKikan() {
        return txtSecchiKikan;
    }

    /*
     * settxtSecchiKikan
     * @param txtSecchiKikan txtSecchiKikan
     */
    @JsonProperty("txtSecchiKikan")
    public void setTxtSecchiKikan(TextBoxDateRange txtSecchiKikan) {
        this.txtSecchiKikan = txtSecchiKikan;
    }

    /*
     * getlblTachiainin
     * @return lblTachiainin
     */
    @JsonProperty("lblTachiainin")
    public Label getLblTachiainin() {
        return lblTachiainin;
    }

    /*
     * setlblTachiainin
     * @param lblTachiainin lblTachiainin
     */
    @JsonProperty("lblTachiainin")
    public void setLblTachiainin(Label lblTachiainin) {
        this.lblTachiainin = lblTachiainin;
    }

    /*
     * getlblTachiaininSenkan
     * @return lblTachiaininSenkan
     */
    @JsonProperty("lblTachiaininSenkan")
    public Label getLblTachiaininSenkan() {
        return lblTachiaininSenkan;
    }

    /*
     * setlblTachiaininSenkan
     * @param lblTachiaininSenkan lblTachiaininSenkan
     */
    @JsonProperty("lblTachiaininSenkan")
    public void setLblTachiaininSenkan(Label lblTachiaininSenkan) {
        this.lblTachiaininSenkan = lblTachiaininSenkan;
    }

    /*
     * getdgTohyorokuTachiaininSenkan
     * @return dgTohyorokuTachiaininSenkan
     */
    @JsonProperty("dgTohyorokuTachiaininSenkan")
    public DataGrid<dgTohyorokuTachiaininSenkan_Row> getDgTohyorokuTachiaininSenkan() {
        return dgTohyorokuTachiaininSenkan;
    }

    /*
     * setdgTohyorokuTachiaininSenkan
     * @param dgTohyorokuTachiaininSenkan dgTohyorokuTachiaininSenkan
     */
    @JsonProperty("dgTohyorokuTachiaininSenkan")
    public void setDgTohyorokuTachiaininSenkan(DataGrid<dgTohyorokuTachiaininSenkan_Row> dgTohyorokuTachiaininSenkan) {
        this.dgTohyorokuTachiaininSenkan = dgTohyorokuTachiaininSenkan;
    }

    /*
     * getlblTachiaininKanrisha
     * @return lblTachiaininKanrisha
     */
    @JsonProperty("lblTachiaininKanrisha")
    public Label getLblTachiaininKanrisha() {
        return lblTachiaininKanrisha;
    }

    /*
     * setlblTachiaininKanrisha
     * @param lblTachiaininKanrisha lblTachiaininKanrisha
     */
    @JsonProperty("lblTachiaininKanrisha")
    public void setLblTachiaininKanrisha(Label lblTachiaininKanrisha) {
        this.lblTachiaininKanrisha = lblTachiaininKanrisha;
    }

    /*
     * getdgTohyorokuTachiaininKanrisha
     * @return dgTohyorokuTachiaininKanrisha
     */
    @JsonProperty("dgTohyorokuTachiaininKanrisha")
    public DataGrid<dgTohyorokuTachiaininKanrisha_Row> getDgTohyorokuTachiaininKanrisha() {
        return dgTohyorokuTachiaininKanrisha;
    }

    /*
     * setdgTohyorokuTachiaininKanrisha
     * @param dgTohyorokuTachiaininKanrisha dgTohyorokuTachiaininKanrisha
     */
    @JsonProperty("dgTohyorokuTachiaininKanrisha")
    public void setDgTohyorokuTachiaininKanrisha(DataGrid<dgTohyorokuTachiaininKanrisha_Row> dgTohyorokuTachiaininKanrisha) {
        this.dgTohyorokuTachiaininKanrisha = dgTohyorokuTachiaininKanrisha;
    }

    /*
     * getlblKaiheiTime
     * @return lblKaiheiTime
     */
    @JsonProperty("lblKaiheiTime")
    public Label getLblKaiheiTime() {
        return lblKaiheiTime;
    }

    /*
     * setlblKaiheiTime
     * @param lblKaiheiTime lblKaiheiTime
     */
    @JsonProperty("lblKaiheiTime")
    public void setLblKaiheiTime(Label lblKaiheiTime) {
        this.lblKaiheiTime = lblKaiheiTime;
    }

    /*
     * gettxtKaiheiStartTime
     * @return txtKaiheiStartTime
     */
    @JsonProperty("txtKaiheiStartTime")
    public TextBoxTime getTxtKaiheiStartTime() {
        return txtKaiheiStartTime;
    }

    /*
     * settxtKaiheiStartTime
     * @param txtKaiheiStartTime txtKaiheiStartTime
     */
    @JsonProperty("txtKaiheiStartTime")
    public void setTxtKaiheiStartTime(TextBoxTime txtKaiheiStartTime) {
        this.txtKaiheiStartTime = txtKaiheiStartTime;
    }

    /*
     * gettxtKaiheiStopTime
     * @return txtKaiheiStopTime
     */
    @JsonProperty("txtKaiheiStopTime")
    public TextBoxTime getTxtKaiheiStopTime() {
        return txtKaiheiStopTime;
    }

    /*
     * settxtKaiheiStopTime
     * @param txtKaiheiStopTime txtKaiheiStopTime
     */
    @JsonProperty("txtKaiheiStopTime")
    public void setTxtKaiheiStopTime(TextBoxTime txtKaiheiStopTime) {
        this.txtKaiheiStopTime = txtKaiheiStopTime;
    }

    /*
     * getlblTohyosha
     * @return lblTohyosha
     */
    @JsonProperty("lblTohyosha")
    public Label getLblTohyosha() {
        return lblTohyosha;
    }

    /*
     * setlblTohyosha
     * @param lblTohyosha lblTohyosha
     */
    @JsonProperty("lblTohyosha")
    public void setLblTohyosha(Label lblTohyosha) {
        this.lblTohyosha = lblTohyosha;
    }

    /*
     * gettxtTohyoshaOtoko
     * @return txtTohyoshaOtoko
     */
    @JsonProperty("txtTohyoshaOtoko")
    public TextBoxNum getTxtTohyoshaOtoko() {
        return txtTohyoshaOtoko;
    }

    /*
     * settxtTohyoshaOtoko
     * @param txtTohyoshaOtoko txtTohyoshaOtoko
     */
    @JsonProperty("txtTohyoshaOtoko")
    public void setTxtTohyoshaOtoko(TextBoxNum txtTohyoshaOtoko) {
        this.txtTohyoshaOtoko = txtTohyoshaOtoko;
    }

    /*
     * gettxtTohyoshaOnna
     * @return txtTohyoshaOnna
     */
    @JsonProperty("txtTohyoshaOnna")
    public TextBoxNum getTxtTohyoshaOnna() {
        return txtTohyoshaOnna;
    }

    /*
     * settxtTohyoshaOnna
     * @param txtTohyoshaOnna txtTohyoshaOnna
     */
    @JsonProperty("txtTohyoshaOnna")
    public void setTxtTohyoshaOnna(TextBoxNum txtTohyoshaOnna) {
        this.txtTohyoshaOnna = txtTohyoshaOnna;
    }

    /*
     * gettxtTohyoshaKei
     * @return txtTohyoshaKei
     */
    @JsonProperty("txtTohyoshaKei")
    public TextBoxNum getTxtTohyoshaKei() {
        return txtTohyoshaKei;
    }

    /*
     * settxtTohyoshaKei
     * @param txtTohyoshaKei txtTohyoshaKei
     */
    @JsonProperty("txtTohyoshaKei")
    public void setTxtTohyoshaKei(TextBoxNum txtTohyoshaKei) {
        this.txtTohyoshaKei = txtTohyoshaKei;
    }

    /*
     * getlblTohyoshaKari
     * @return lblTohyoshaKari
     */
    @JsonProperty("lblTohyoshaKari")
    public Label getLblTohyoshaKari() {
        return lblTohyoshaKari;
    }

    /*
     * setlblTohyoshaKari
     * @param lblTohyoshaKari lblTohyoshaKari
     */
    @JsonProperty("lblTohyoshaKari")
    public void setLblTohyoshaKari(Label lblTohyoshaKari) {
        this.lblTohyoshaKari = lblTohyoshaKari;
    }

    /*
     * gettxtKariTohyoshaOtoko
     * @return txtKariTohyoshaOtoko
     */
    @JsonProperty("txtKariTohyoshaOtoko")
    public TextBoxNum getTxtKariTohyoshaOtoko() {
        return txtKariTohyoshaOtoko;
    }

    /*
     * settxtKariTohyoshaOtoko
     * @param txtKariTohyoshaOtoko txtKariTohyoshaOtoko
     */
    @JsonProperty("txtKariTohyoshaOtoko")
    public void setTxtKariTohyoshaOtoko(TextBoxNum txtKariTohyoshaOtoko) {
        this.txtKariTohyoshaOtoko = txtKariTohyoshaOtoko;
    }

    /*
     * gettxtKariTohyoshaOnna
     * @return txtKariTohyoshaOnna
     */
    @JsonProperty("txtKariTohyoshaOnna")
    public TextBoxNum getTxtKariTohyoshaOnna() {
        return txtKariTohyoshaOnna;
    }

    /*
     * settxtKariTohyoshaOnna
     * @param txtKariTohyoshaOnna txtKariTohyoshaOnna
     */
    @JsonProperty("txtKariTohyoshaOnna")
    public void setTxtKariTohyoshaOnna(TextBoxNum txtKariTohyoshaOnna) {
        this.txtKariTohyoshaOnna = txtKariTohyoshaOnna;
    }

    /*
     * gettxtKariTohyoshaKei
     * @return txtKariTohyoshaKei
     */
    @JsonProperty("txtKariTohyoshaKei")
    public TextBoxNum getTxtKariTohyoshaKei() {
        return txtKariTohyoshaKei;
    }

    /*
     * settxtKariTohyoshaKei
     * @param txtKariTohyoshaKei txtKariTohyoshaKei
     */
    @JsonProperty("txtKariTohyoshaKei")
    public void setTxtKariTohyoshaKei(TextBoxNum txtKariTohyoshaKei) {
        this.txtKariTohyoshaKei = txtKariTohyoshaKei;
    }

    /*
     * getlblSaikofusha
     * @return lblSaikofusha
     */
    @JsonProperty("lblSaikofusha")
    public Label getLblSaikofusha() {
        return lblSaikofusha;
    }

    /*
     * setlblSaikofusha
     * @param lblSaikofusha lblSaikofusha
     */
    @JsonProperty("lblSaikofusha")
    public void setLblSaikofusha(Label lblSaikofusha) {
        this.lblSaikofusha = lblSaikofusha;
    }

    /*
     * getdgTohyorokuSaikofusha
     * @return dgTohyorokuSaikofusha
     */
    @JsonProperty("dgTohyorokuSaikofusha")
    public DataGrid<dgTohyorokuSaikofusha_Row> getDgTohyorokuSaikofusha() {
        return dgTohyorokuSaikofusha;
    }

    /*
     * setdgTohyorokuSaikofusha
     * @param dgTohyorokuSaikofusha dgTohyorokuSaikofusha
     */
    @JsonProperty("dgTohyorokuSaikofusha")
    public void setDgTohyorokuSaikofusha(DataGrid<dgTohyorokuSaikofusha_Row> dgTohyorokuSaikofusha) {
        this.dgTohyorokuSaikofusha = dgTohyorokuSaikofusha;
    }

    /*
     * getlblKetteishoSaiketsusho
     * @return lblKetteishoSaiketsusho
     */
    @JsonProperty("lblKetteishoSaiketsusho")
    public Label getLblKetteishoSaiketsusho() {
        return lblKetteishoSaiketsusho;
    }

    /*
     * setlblKetteishoSaiketsusho
     * @param lblKetteishoSaiketsusho lblKetteishoSaiketsusho
     */
    @JsonProperty("lblKetteishoSaiketsusho")
    public void setLblKetteishoSaiketsusho(Label lblKetteishoSaiketsusho) {
        this.lblKetteishoSaiketsusho = lblKetteishoSaiketsusho;
    }

    /*
     * getlblHenkanTohyosha
     * @return lblHenkanTohyosha
     */
    @JsonProperty("lblHenkanTohyosha")
    public Label getLblHenkanTohyosha() {
        return lblHenkanTohyosha;
    }

    /*
     * setlblHenkanTohyosha
     * @param lblHenkanTohyosha lblHenkanTohyosha
     */
    @JsonProperty("lblHenkanTohyosha")
    public void setLblHenkanTohyosha(Label lblHenkanTohyosha) {
        this.lblHenkanTohyosha = lblHenkanTohyosha;
    }

    /*
     * gettxtTenjiNinzu
     * @return txtTenjiNinzu
     */
    @JsonProperty("txtTenjiNinzu")
    public TextBoxNum getTxtTenjiNinzu() {
        return txtTenjiNinzu;
    }

    /*
     * settxtTenjiNinzu
     * @param txtTenjiNinzu txtTenjiNinzu
     */
    @JsonProperty("txtTenjiNinzu")
    public void setTxtTenjiNinzu(TextBoxNum txtTenjiNinzu) {
        this.txtTenjiNinzu = txtTenjiNinzu;
    }

    /*
     * gettxtDairiNinzu
     * @return txtDairiNinzu
     */
    @JsonProperty("txtDairiNinzu")
    public TextBoxNum getTxtDairiNinzu() {
        return txtDairiNinzu;
    }

    /*
     * settxtDairiNinzu
     * @param txtDairiNinzu txtDairiNinzu
     */
    @JsonProperty("txtDairiNinzu")
    public void setTxtDairiNinzu(TextBoxNum txtDairiNinzu) {
        this.txtDairiNinzu = txtDairiNinzu;
    }

    /*
     * getlblKyohi
     * @return lblKyohi
     */
    @JsonProperty("lblKyohi")
    public Label getLblKyohi() {
        return lblKyohi;
    }

    /*
     * setlblKyohi
     * @param lblKyohi lblKyohi
     */
    @JsonProperty("lblKyohi")
    public void setLblKyohi(Label lblKyohi) {
        this.lblKyohi = lblKyohi;
    }

    /*
     * getlblTohyoKyohi
     * @return lblTohyoKyohi
     */
    @JsonProperty("lblTohyoKyohi")
    public Label getLblTohyoKyohi() {
        return lblTohyoKyohi;
    }

    /*
     * setlblTohyoKyohi
     * @param lblTohyoKyohi lblTohyoKyohi
     */
    @JsonProperty("lblTohyoKyohi")
    public void setLblTohyoKyohi(Label lblTohyoKyohi) {
        this.lblTohyoKyohi = lblTohyoKyohi;
    }

    /*
     * getlblDairiTohyoKyohi
     * @return lblDairiTohyoKyohi
     */
    @JsonProperty("lblDairiTohyoKyohi")
    public Label getLblDairiTohyoKyohi() {
        return lblDairiTohyoKyohi;
    }

    /*
     * setlblDairiTohyoKyohi
     * @param lblDairiTohyoKyohi lblDairiTohyoKyohi
     */
    @JsonProperty("lblDairiTohyoKyohi")
    public void setLblDairiTohyoKyohi(Label lblDairiTohyoKyohi) {
        this.lblDairiTohyoKyohi = lblDairiTohyoKyohi;
    }

    /*
     * getlblJujisha
     * @return lblJujisha
     */
    @JsonProperty("lblJujisha")
    public Label getLblJujisha() {
        return lblJujisha;
    }

    /*
     * setlblJujisha
     * @param lblJujisha lblJujisha
     */
    @JsonProperty("lblJujisha")
    public void setLblJujisha(Label lblJujisha) {
        this.lblJujisha = lblJujisha;
    }

    /*
     * gettxtJimuNinzu
     * @return txtJimuNinzu
     */
    @JsonProperty("txtJimuNinzu")
    public TextBoxNum getTxtJimuNinzu() {
        return txtJimuNinzu;
    }

    /*
     * settxtJimuNinzu
     * @param txtJimuNinzu txtJimuNinzu
     */
    @JsonProperty("txtJimuNinzu")
    public void setTxtJimuNinzu(TextBoxNum txtJimuNinzu) {
        this.txtJimuNinzu = txtJimuNinzu;
    }

    /*
     * gettxtShokiNinzu
     * @return txtShokiNinzu
     */
    @JsonProperty("txtShokiNinzu")
    public TextBoxNum getTxtShokiNinzu() {
        return txtShokiNinzu;
    }

    /*
     * settxtShokiNinzu
     * @param txtShokiNinzu txtShokiNinzu
     */
    @JsonProperty("txtShokiNinzu")
    public void setTxtShokiNinzu(TextBoxNum txtShokiNinzu) {
        this.txtShokiNinzu = txtShokiNinzu;
    }

    /*
     * gettxtShokuinNinzu
     * @return txtShokuinNinzu
     */
    @JsonProperty("txtShokuinNinzu")
    public TextBoxNum getTxtShokuinNinzu() {
        return txtShokuinNinzu;
    }

    /*
     * settxtShokuinNinzu
     * @param txtShokuinNinzu txtShokuinNinzu
     */
    @JsonProperty("txtShokuinNinzu")
    public void setTxtShokuinNinzu(TextBoxNum txtShokuinNinzu) {
        this.txtShokuinNinzu = txtShokuinNinzu;
    }

    /*
     * gettxtSonotaNinzu
     * @return txtSonotaNinzu
     */
    @JsonProperty("txtSonotaNinzu")
    public TextBoxNum getTxtSonotaNinzu() {
        return txtSonotaNinzu;
    }

    /*
     * settxtSonotaNinzu
     * @param txtSonotaNinzu txtSonotaNinzu
     */
    @JsonProperty("txtSonotaNinzu")
    public void setTxtSonotaNinzu(TextBoxNum txtSonotaNinzu) {
        this.txtSonotaNinzu = txtSonotaNinzu;
    }

    /*
     * getccdTohyorokuDairiTohyoKyohi
     * @return ccdTohyorokuDairiTohyoKyohi
     */
    @JsonProperty("ccdTohyorokuDairiTohyoKyohi")
    public ITohyorokuKyohiNyuryokuDiv getCcdTohyorokuDairiTohyoKyohi() {
        return ccdTohyorokuDairiTohyoKyohi;
    }

    /*
     * getccdTohyorokuTohyoKyohi
     * @return ccdTohyorokuTohyoKyohi
     */
    @JsonProperty("ccdTohyorokuTohyoKyohi")
    public ITohyorokuKyohiNyuryokuDiv getCcdTohyorokuTohyoKyohi() {
        return ccdTohyorokuTohyoKyohi;
    }

    /*
     * getccdTohyorokuDairiTohyosha
     * @return ccdTohyorokuDairiTohyosha
     */
    @JsonProperty("ccdTohyorokuDairiTohyosha")
    public ITohyorokuDairiTohyoshaDiv getCcdTohyorokuDairiTohyosha() {
        return ccdTohyorokuDairiTohyosha;
    }

    /*
     * getccdTohyorokuKetteishoSaiketsusho
     * @return ccdTohyorokuKetteishoSaiketsusho
     */
    @JsonProperty("ccdTohyorokuKetteishoSaiketsusho")
    public ITohyorokuShimeiNyuryokuDiv getCcdTohyorokuKetteishoSaiketsusho() {
        return ccdTohyorokuKetteishoSaiketsusho;
    }

    /*
     * getccdTohyorokuHenkanTohyosha
     * @return ccdTohyorokuHenkanTohyosha
     */
    @JsonProperty("ccdTohyorokuHenkanTohyosha")
    public ITohyorokuShimeiNyuryokuDiv getCcdTohyorokuHenkanTohyosha() {
        return ccdTohyorokuHenkanTohyosha;
    }

    // </editor-fold>
}
