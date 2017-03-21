package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboBango.IMeiboBangoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboBango.MeiboBangoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.ITohyokuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.TohyokuCodeSelectDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TohyokuHenkoMeiboBangoJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class TohyokuHenkoMeiboBangoJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblWarningMessage")
    private Label lblWarningMessage;
    @JsonProperty("spc1")
    private Space spc1;
    @JsonProperty("lblBefore")
    private Label lblBefore;
    @JsonProperty("lblMeiboBangoBefore")
    private Label lblMeiboBangoBefore;
    @JsonProperty("lblAfter")
    private Label lblAfter;
    @JsonProperty("lblMeiboBnagoAfter")
    private Label lblMeiboBnagoAfter;
    @JsonProperty("btnBangoSanshutsu")
    private Button btnBangoSanshutsu;
    @JsonProperty("spc2")
    private Space spc2;
    @JsonProperty("radTekiyoNaiyo")
    private RadioButton radTekiyoNaiyo;
    @JsonProperty("ccdMeiboBangoAfter")
    private MeiboBangoDiv ccdMeiboBangoAfter;
    @JsonProperty("ccdMeiboBangoBefore")
    private MeiboBangoDiv ccdMeiboBangoBefore;
    @JsonProperty("ccdTohyokuAfter")
    private TohyokuCodeSelectDiv ccdTohyokuAfter;
    @JsonProperty("ccdTohyokuBefore")
    private TohyokuCodeSelectDiv ccdTohyokuBefore;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblWarningMessage
     * @return lblWarningMessage
     */
    @JsonProperty("lblWarningMessage")
    public Label getLblWarningMessage() {
        return lblWarningMessage;
    }

    /*
     * setlblWarningMessage
     * @param lblWarningMessage lblWarningMessage
     */
    @JsonProperty("lblWarningMessage")
    public void setLblWarningMessage(Label lblWarningMessage) {
        this.lblWarningMessage = lblWarningMessage;
    }

    /*
     * getspc1
     * @return spc1
     */
    @JsonProperty("spc1")
    public Space getSpc1() {
        return spc1;
    }

    /*
     * setspc1
     * @param spc1 spc1
     */
    @JsonProperty("spc1")
    public void setSpc1(Space spc1) {
        this.spc1 = spc1;
    }

    /*
     * getlblBefore
     * @return lblBefore
     */
    @JsonProperty("lblBefore")
    public Label getLblBefore() {
        return lblBefore;
    }

    /*
     * setlblBefore
     * @param lblBefore lblBefore
     */
    @JsonProperty("lblBefore")
    public void setLblBefore(Label lblBefore) {
        this.lblBefore = lblBefore;
    }

    /*
     * getlblMeiboBangoBefore
     * @return lblMeiboBangoBefore
     */
    @JsonProperty("lblMeiboBangoBefore")
    public Label getLblMeiboBangoBefore() {
        return lblMeiboBangoBefore;
    }

    /*
     * setlblMeiboBangoBefore
     * @param lblMeiboBangoBefore lblMeiboBangoBefore
     */
    @JsonProperty("lblMeiboBangoBefore")
    public void setLblMeiboBangoBefore(Label lblMeiboBangoBefore) {
        this.lblMeiboBangoBefore = lblMeiboBangoBefore;
    }

    /*
     * getlblAfter
     * @return lblAfter
     */
    @JsonProperty("lblAfter")
    public Label getLblAfter() {
        return lblAfter;
    }

    /*
     * setlblAfter
     * @param lblAfter lblAfter
     */
    @JsonProperty("lblAfter")
    public void setLblAfter(Label lblAfter) {
        this.lblAfter = lblAfter;
    }

    /*
     * getlblMeiboBnagoAfter
     * @return lblMeiboBnagoAfter
     */
    @JsonProperty("lblMeiboBnagoAfter")
    public Label getLblMeiboBnagoAfter() {
        return lblMeiboBnagoAfter;
    }

    /*
     * setlblMeiboBnagoAfter
     * @param lblMeiboBnagoAfter lblMeiboBnagoAfter
     */
    @JsonProperty("lblMeiboBnagoAfter")
    public void setLblMeiboBnagoAfter(Label lblMeiboBnagoAfter) {
        this.lblMeiboBnagoAfter = lblMeiboBnagoAfter;
    }

    /*
     * getbtnBangoSanshutsu
     * @return btnBangoSanshutsu
     */
    @JsonProperty("btnBangoSanshutsu")
    public Button getBtnBangoSanshutsu() {
        return btnBangoSanshutsu;
    }

    /*
     * setbtnBangoSanshutsu
     * @param btnBangoSanshutsu btnBangoSanshutsu
     */
    @JsonProperty("btnBangoSanshutsu")
    public void setBtnBangoSanshutsu(Button btnBangoSanshutsu) {
        this.btnBangoSanshutsu = btnBangoSanshutsu;
    }

    /*
     * getspc2
     * @return spc2
     */
    @JsonProperty("spc2")
    public Space getSpc2() {
        return spc2;
    }

    /*
     * setspc2
     * @param spc2 spc2
     */
    @JsonProperty("spc2")
    public void setSpc2(Space spc2) {
        this.spc2 = spc2;
    }

    /*
     * getradTekiyoNaiyo
     * @return radTekiyoNaiyo
     */
    @JsonProperty("radTekiyoNaiyo")
    public RadioButton getRadTekiyoNaiyo() {
        return radTekiyoNaiyo;
    }

    /*
     * setradTekiyoNaiyo
     * @param radTekiyoNaiyo radTekiyoNaiyo
     */
    @JsonProperty("radTekiyoNaiyo")
    public void setRadTekiyoNaiyo(RadioButton radTekiyoNaiyo) {
        this.radTekiyoNaiyo = radTekiyoNaiyo;
    }

    /*
     * getccdMeiboBangoAfter
     * @return ccdMeiboBangoAfter
     */
    @JsonProperty("ccdMeiboBangoAfter")
    public IMeiboBangoDiv getCcdMeiboBangoAfter() {
        return ccdMeiboBangoAfter;
    }

    /*
     * getccdMeiboBangoBefore
     * @return ccdMeiboBangoBefore
     */
    @JsonProperty("ccdMeiboBangoBefore")
    public IMeiboBangoDiv getCcdMeiboBangoBefore() {
        return ccdMeiboBangoBefore;
    }

    /*
     * getccdTohyokuAfter
     * @return ccdTohyokuAfter
     */
    @JsonProperty("ccdTohyokuAfter")
    public ITohyokuCodeSelectDiv getCcdTohyokuAfter() {
        return ccdTohyokuAfter;
    }

    /*
     * getccdTohyokuBefore
     * @return ccdTohyokuBefore
     */
    @JsonProperty("ccdTohyokuBefore")
    public ITohyokuCodeSelectDiv getCcdTohyokuBefore() {
        return ccdTohyokuBefore;
    }

    // </editor-fold>
}
