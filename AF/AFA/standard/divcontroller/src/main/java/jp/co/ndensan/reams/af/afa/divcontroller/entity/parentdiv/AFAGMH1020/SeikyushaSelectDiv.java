package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1020;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SeikyushaSelect のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeikyushaSelectDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SeikyushaSelectSeikyuIchiran")
    private SeikyushaSelectSeikyuIchiranDiv SeikyushaSelectSeikyuIchiran;
    @JsonProperty("SeikyushaSelectShohon")
    private SeikyushaSelectShohonDiv SeikyushaSelectShohon;
    @JsonProperty("btnSakusei")
    private Button btnSakusei;
    @JsonProperty("hdnTeishutsuKigenYMD")
    private RString hdnTeishutsuKigenYMD;
    @JsonProperty("hdnSeikyuNo")
    private RString hdnSeikyuNo;
    @JsonProperty("hdnSeikyuMei")
    private RString hdnSeikyuMei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSeikyushaSelectSeikyuIchiran
     * @return SeikyushaSelectSeikyuIchiran
     */
    @JsonProperty("SeikyushaSelectSeikyuIchiran")
    public SeikyushaSelectSeikyuIchiranDiv getSeikyushaSelectSeikyuIchiran() {
        return SeikyushaSelectSeikyuIchiran;
    }

    /*
     * setSeikyushaSelectSeikyuIchiran
     * @param SeikyushaSelectSeikyuIchiran SeikyushaSelectSeikyuIchiran
     */
    @JsonProperty("SeikyushaSelectSeikyuIchiran")
    public void setSeikyushaSelectSeikyuIchiran(SeikyushaSelectSeikyuIchiranDiv SeikyushaSelectSeikyuIchiran) {
        this.SeikyushaSelectSeikyuIchiran = SeikyushaSelectSeikyuIchiran;
    }

    /*
     * getSeikyushaSelectShohon
     * @return SeikyushaSelectShohon
     */
    @JsonProperty("SeikyushaSelectShohon")
    public SeikyushaSelectShohonDiv getSeikyushaSelectShohon() {
        return SeikyushaSelectShohon;
    }

    /*
     * setSeikyushaSelectShohon
     * @param SeikyushaSelectShohon SeikyushaSelectShohon
     */
    @JsonProperty("SeikyushaSelectShohon")
    public void setSeikyushaSelectShohon(SeikyushaSelectShohonDiv SeikyushaSelectShohon) {
        this.SeikyushaSelectShohon = SeikyushaSelectShohon;
    }

    /*
     * getbtnSakusei
     * @return btnSakusei
     */
    @JsonProperty("btnSakusei")
    public Button getBtnSakusei() {
        return btnSakusei;
    }

    /*
     * setbtnSakusei
     * @param btnSakusei btnSakusei
     */
    @JsonProperty("btnSakusei")
    public void setBtnSakusei(Button btnSakusei) {
        this.btnSakusei = btnSakusei;
    }

    /*
     * gethdnTeishutsuKigenYMD
     * @return hdnTeishutsuKigenYMD
     */
    @JsonProperty("hdnTeishutsuKigenYMD")
    public RString getHdnTeishutsuKigenYMD() {
        return hdnTeishutsuKigenYMD;
    }

    /*
     * sethdnTeishutsuKigenYMD
     * @param hdnTeishutsuKigenYMD hdnTeishutsuKigenYMD
     */
    @JsonProperty("hdnTeishutsuKigenYMD")
    public void setHdnTeishutsuKigenYMD(RString hdnTeishutsuKigenYMD) {
        this.hdnTeishutsuKigenYMD = hdnTeishutsuKigenYMD;
    }

    /*
     * gethdnSeikyuNo
     * @return hdnSeikyuNo
     */
    @JsonProperty("hdnSeikyuNo")
    public RString getHdnSeikyuNo() {
        return hdnSeikyuNo;
    }

    /*
     * sethdnSeikyuNo
     * @param hdnSeikyuNo hdnSeikyuNo
     */
    @JsonProperty("hdnSeikyuNo")
    public void setHdnSeikyuNo(RString hdnSeikyuNo) {
        this.hdnSeikyuNo = hdnSeikyuNo;
    }

    /*
     * gethdnSeikyuMei
     * @return hdnSeikyuMei
     */
    @JsonProperty("hdnSeikyuMei")
    public RString getHdnSeikyuMei() {
        return hdnSeikyuMei;
    }

    /*
     * sethdnSeikyuMei
     * @param hdnSeikyuMei hdnSeikyuMei
     */
    @JsonProperty("hdnSeikyuMei")
    public void setHdnSeikyuMei(RString hdnSeikyuMei) {
        this.hdnSeikyuMei = hdnSeikyuMei;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblShohonSelect() {
        return this.getSeikyushaSelectShohon().getLblShohonSelect();
    }

    @JsonIgnore
    public void  setLblShohonSelect(Label lblShohonSelect) {
        this.getSeikyushaSelectShohon().setLblShohonSelect(lblShohonSelect);
    }

    @JsonIgnore
    public IShohonNameListDiv getCcdShohonNameList() {
        return this.getSeikyushaSelectShohon().getCcdShohonNameList();
    }

    // </editor-fold>
}
