package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJokyoNyuryoku.ITohyoJokyoNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJokyoNyuryoku.TohyoJokyoNyuryokuDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KijitsumaeTohyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class KijitsumaeTohyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KijitsumaeTohyoJokyo")
    private KijitsumaeTohyoJokyoDiv KijitsumaeTohyoJokyo;
    @JsonProperty("KijitsumaeKojinJoho")
    private KijitsumaeKojinJohoDiv KijitsumaeKojinJoho;
    @JsonProperty("checkButton")
    private Button checkButton;
    @JsonProperty("btnFinish")
    private Button btnFinish;
    @JsonProperty("hiddenPrintButtonDialog")
    private ButtonDialog hiddenPrintButtonDialog;
    @JsonProperty("hiddenPrintButtonDialogFlg")
    private Label hiddenPrintButtonDialogFlg;
    @JsonProperty("ccdKijitsumaeSenkyoninTohyoJokyo")
    private TohyoJokyoNyuryokuDiv ccdKijitsumaeSenkyoninTohyoJokyo;
    @JsonProperty("labelSealSelectDialogModel")
    private RString labelSealSelectDialogModel;
    @JsonProperty("searchSimpleJuminModel")
    private RString searchSimpleJuminModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKijitsumaeTohyoJokyo
     * @return KijitsumaeTohyoJokyo
     */
    @JsonProperty("KijitsumaeTohyoJokyo")
    public KijitsumaeTohyoJokyoDiv getKijitsumaeTohyoJokyo() {
        return KijitsumaeTohyoJokyo;
    }

    /*
     * setKijitsumaeTohyoJokyo
     * @param KijitsumaeTohyoJokyo KijitsumaeTohyoJokyo
     */
    @JsonProperty("KijitsumaeTohyoJokyo")
    public void setKijitsumaeTohyoJokyo(KijitsumaeTohyoJokyoDiv KijitsumaeTohyoJokyo) {
        this.KijitsumaeTohyoJokyo = KijitsumaeTohyoJokyo;
    }

    /*
     * getKijitsumaeKojinJoho
     * @return KijitsumaeKojinJoho
     */
    @JsonProperty("KijitsumaeKojinJoho")
    public KijitsumaeKojinJohoDiv getKijitsumaeKojinJoho() {
        return KijitsumaeKojinJoho;
    }

    /*
     * setKijitsumaeKojinJoho
     * @param KijitsumaeKojinJoho KijitsumaeKojinJoho
     */
    @JsonProperty("KijitsumaeKojinJoho")
    public void setKijitsumaeKojinJoho(KijitsumaeKojinJohoDiv KijitsumaeKojinJoho) {
        this.KijitsumaeKojinJoho = KijitsumaeKojinJoho;
    }

    /*
     * getcheckButton
     * @return checkButton
     */
    @JsonProperty("checkButton")
    public Button getCheckButton() {
        return checkButton;
    }

    /*
     * setcheckButton
     * @param checkButton checkButton
     */
    @JsonProperty("checkButton")
    public void setCheckButton(Button checkButton) {
        this.checkButton = checkButton;
    }

    /*
     * getbtnFinish
     * @return btnFinish
     */
    @JsonProperty("btnFinish")
    public Button getBtnFinish() {
        return btnFinish;
    }

    /*
     * setbtnFinish
     * @param btnFinish btnFinish
     */
    @JsonProperty("btnFinish")
    public void setBtnFinish(Button btnFinish) {
        this.btnFinish = btnFinish;
    }

    /*
     * gethiddenPrintButtonDialog
     * @return hiddenPrintButtonDialog
     */
    @JsonProperty("hiddenPrintButtonDialog")
    public ButtonDialog getHiddenPrintButtonDialog() {
        return hiddenPrintButtonDialog;
    }

    /*
     * sethiddenPrintButtonDialog
     * @param hiddenPrintButtonDialog hiddenPrintButtonDialog
     */
    @JsonProperty("hiddenPrintButtonDialog")
    public void setHiddenPrintButtonDialog(ButtonDialog hiddenPrintButtonDialog) {
        this.hiddenPrintButtonDialog = hiddenPrintButtonDialog;
    }

    /*
     * gethiddenPrintButtonDialogFlg
     * @return hiddenPrintButtonDialogFlg
     */
    @JsonProperty("hiddenPrintButtonDialogFlg")
    public Label getHiddenPrintButtonDialogFlg() {
        return hiddenPrintButtonDialogFlg;
    }

    /*
     * sethiddenPrintButtonDialogFlg
     * @param hiddenPrintButtonDialogFlg hiddenPrintButtonDialogFlg
     */
    @JsonProperty("hiddenPrintButtonDialogFlg")
    public void setHiddenPrintButtonDialogFlg(Label hiddenPrintButtonDialogFlg) {
        this.hiddenPrintButtonDialogFlg = hiddenPrintButtonDialogFlg;
    }

    /*
     * getccdKijitsumaeSenkyoninTohyoJokyo
     * @return ccdKijitsumaeSenkyoninTohyoJokyo
     */
    @JsonProperty("ccdKijitsumaeSenkyoninTohyoJokyo")
    public ITohyoJokyoNyuryokuDiv getCcdKijitsumaeSenkyoninTohyoJokyo() {
        return ccdKijitsumaeSenkyoninTohyoJokyo;
    }

    /*
     * getlabelSealSelectDialogModel
     * @return labelSealSelectDialogModel
     */
    @JsonProperty("labelSealSelectDialogModel")
    public RString getLabelSealSelectDialogModel() {
        return labelSealSelectDialogModel;
    }

    /*
     * setlabelSealSelectDialogModel
     * @param labelSealSelectDialogModel labelSealSelectDialogModel
     */
    @JsonProperty("labelSealSelectDialogModel")
    public void setLabelSealSelectDialogModel(RString labelSealSelectDialogModel) {
        this.labelSealSelectDialogModel = labelSealSelectDialogModel;
    }

    /*
     * getsearchSimpleJuminModel
     * @return searchSimpleJuminModel
     */
    @JsonProperty("searchSimpleJuminModel")
    public RString getSearchSimpleJuminModel() {
        return searchSimpleJuminModel;
    }

    /*
     * setsearchSimpleJuminModel
     * @param searchSimpleJuminModel searchSimpleJuminModel
     */
    @JsonProperty("searchSimpleJuminModel")
    public void setSearchSimpleJuminModel(RString searchSimpleJuminModel) {
        this.searchSimpleJuminModel = searchSimpleJuminModel;
    }

    // </editor-fold>
}
