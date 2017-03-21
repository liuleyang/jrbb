package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShikakuJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JiyuNameList.IJiyuNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JiyuNameList.JiyuNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.ITohyokuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.TohyokuCodeSelectDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 資格情報 のクラスファイル
 *
 * @reamsid_L AF-0180-015 lis2
 */
public class ShikakuJohoDiv extends Panel implements IShikakuJohoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdTohyokuCode")
    private TohyokuCodeSelectDiv ccdTohyokuCode;
    @JsonProperty("radSenkyoShikaku")
    private RadioButton radSenkyoShikaku;
    @JsonProperty("lblTohyoShikakuShurui")
    private Label lblTohyoShikakuShurui;
    @JsonProperty("btnYubin")
    private ButtonDialog btnYubin;
    @JsonProperty("btnSenin")
    private ButtonDialog btnSenin;
    @JsonProperty("btnNankyoku")
    private ButtonDialog btnNankyoku;
    @JsonProperty("txtMeiboTorokuYMD")
    private TextBoxDate txtMeiboTorokuYMD;
    @JsonProperty("ccdMeiboTorokuJiyu")
    private JiyuNameListDiv ccdMeiboTorokuJiyu;
    @JsonProperty("txtTorokuTeishiYMD")
    private TextBoxDate txtTorokuTeishiYMD;
    @JsonProperty("ccdTorokuTeishiJiyu")
    private JiyuNameListDiv ccdTorokuTeishiJiyu;
    @JsonProperty("txtMasshoYMD")
    private TextBoxDate txtMasshoYMD;
    @JsonProperty("ccdMasshoJiyu")
    private JiyuNameListDiv ccdMasshoJiyu;
    @JsonProperty("txtHyojiYMD")
    private TextBoxDate txtHyojiYMD;
    @JsonProperty("ccdHyojiJiyu")
    private JiyuNameListDiv ccdHyojiJiyu;
    @JsonProperty("txtHyojiShojoYoteiYMD")
    private TextBoxDate txtHyojiShojoYoteiYMD;
    @JsonProperty("txtHyojiShojoYMD")
    private TextBoxDate txtHyojiShojoYMD;
    @JsonProperty("txtKeikiShuryoYMD")
    private TextBoxDate txtKeikiShuryoYMD;
    @JsonProperty("chk2keiMochi")
    private CheckBoxList chk2keiMochi;
    @JsonProperty("txtHdnSenkyoShurui")
    private RString txtHdnSenkyoShurui;
    @JsonProperty("txtHdnShikibetsuCode")
    private RString txtHdnShikibetsuCode;
    @JsonProperty("txtHdnTorokuYMD")
    private RString txtHdnTorokuYMD;
    @JsonProperty("txtHdnjuminShubetsuCode")
    private RString txtHdnjuminShubetsuCode;
    @JsonProperty("txtHdnjuminJotaiCode")
    private RString txtHdnjuminJotaiCode;
    @JsonProperty("txtHdnShojoIdoYMD")
    private RString txtHdnShojoIdoYMD;
    @JsonProperty("txtHdnShojoTodokedeYMD")
    private RString txtHdnShojoTodokedeYMD;
    @JsonProperty("txtHdnSeinengappiYMD")
    private RString txtHdnSeinengappiYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdTohyokuCode
     * @return ccdTohyokuCode
     */
    @JsonProperty("ccdTohyokuCode")
    public ITohyokuCodeSelectDiv getCcdTohyokuCode() {
        return ccdTohyokuCode;
    }

    /*
     * getradSenkyoShikaku
     * @return radSenkyoShikaku
     */
    @JsonProperty("radSenkyoShikaku")
    public RadioButton getRadSenkyoShikaku() {
        return radSenkyoShikaku;
    }

    /*
     * setradSenkyoShikaku
     * @param radSenkyoShikaku radSenkyoShikaku
     */
    @JsonProperty("radSenkyoShikaku")
    public void setRadSenkyoShikaku(RadioButton radSenkyoShikaku) {
        this.radSenkyoShikaku = radSenkyoShikaku;
    }

    /*
     * getlblTohyoShikakuShurui
     * @return lblTohyoShikakuShurui
     */
    @JsonProperty("lblTohyoShikakuShurui")
    public Label getLblTohyoShikakuShurui() {
        return lblTohyoShikakuShurui;
    }

    /*
     * setlblTohyoShikakuShurui
     * @param lblTohyoShikakuShurui lblTohyoShikakuShurui
     */
    @JsonProperty("lblTohyoShikakuShurui")
    public void setLblTohyoShikakuShurui(Label lblTohyoShikakuShurui) {
        this.lblTohyoShikakuShurui = lblTohyoShikakuShurui;
    }

    /*
     * getbtnYubin
     * @return btnYubin
     */
    @JsonProperty("btnYubin")
    public ButtonDialog getBtnYubin() {
        return btnYubin;
    }

    /*
     * setbtnYubin
     * @param btnYubin btnYubin
     */
    @JsonProperty("btnYubin")
    public void setBtnYubin(ButtonDialog btnYubin) {
        this.btnYubin = btnYubin;
    }

    /*
     * getbtnSenin
     * @return btnSenin
     */
    @JsonProperty("btnSenin")
    public ButtonDialog getBtnSenin() {
        return btnSenin;
    }

    /*
     * setbtnSenin
     * @param btnSenin btnSenin
     */
    @JsonProperty("btnSenin")
    public void setBtnSenin(ButtonDialog btnSenin) {
        this.btnSenin = btnSenin;
    }

    /*
     * getbtnNankyoku
     * @return btnNankyoku
     */
    @JsonProperty("btnNankyoku")
    public ButtonDialog getBtnNankyoku() {
        return btnNankyoku;
    }

    /*
     * setbtnNankyoku
     * @param btnNankyoku btnNankyoku
     */
    @JsonProperty("btnNankyoku")
    public void setBtnNankyoku(ButtonDialog btnNankyoku) {
        this.btnNankyoku = btnNankyoku;
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
     * getccdMeiboTorokuJiyu
     * @return ccdMeiboTorokuJiyu
     */
    @JsonProperty("ccdMeiboTorokuJiyu")
    public IJiyuNameListDiv getCcdMeiboTorokuJiyu() {
        return ccdMeiboTorokuJiyu;
    }

    /*
     * gettxtTorokuTeishiYMD
     * @return txtTorokuTeishiYMD
     */
    @JsonProperty("txtTorokuTeishiYMD")
    public TextBoxDate getTxtTorokuTeishiYMD() {
        return txtTorokuTeishiYMD;
    }

    /*
     * settxtTorokuTeishiYMD
     * @param txtTorokuTeishiYMD txtTorokuTeishiYMD
     */
    @JsonProperty("txtTorokuTeishiYMD")
    public void setTxtTorokuTeishiYMD(TextBoxDate txtTorokuTeishiYMD) {
        this.txtTorokuTeishiYMD = txtTorokuTeishiYMD;
    }

    /*
     * getccdTorokuTeishiJiyu
     * @return ccdTorokuTeishiJiyu
     */
    @JsonProperty("ccdTorokuTeishiJiyu")
    public IJiyuNameListDiv getCcdTorokuTeishiJiyu() {
        return ccdTorokuTeishiJiyu;
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
     * gettxtHyojiYMD
     * @return txtHyojiYMD
     */
    @JsonProperty("txtHyojiYMD")
    public TextBoxDate getTxtHyojiYMD() {
        return txtHyojiYMD;
    }

    /*
     * settxtHyojiYMD
     * @param txtHyojiYMD txtHyojiYMD
     */
    @JsonProperty("txtHyojiYMD")
    public void setTxtHyojiYMD(TextBoxDate txtHyojiYMD) {
        this.txtHyojiYMD = txtHyojiYMD;
    }

    /*
     * getccdHyojiJiyu
     * @return ccdHyojiJiyu
     */
    @JsonProperty("ccdHyojiJiyu")
    public IJiyuNameListDiv getCcdHyojiJiyu() {
        return ccdHyojiJiyu;
    }

    /*
     * gettxtHyojiShojoYoteiYMD
     * @return txtHyojiShojoYoteiYMD
     */
    @JsonProperty("txtHyojiShojoYoteiYMD")
    public TextBoxDate getTxtHyojiShojoYoteiYMD() {
        return txtHyojiShojoYoteiYMD;
    }

    /*
     * settxtHyojiShojoYoteiYMD
     * @param txtHyojiShojoYoteiYMD txtHyojiShojoYoteiYMD
     */
    @JsonProperty("txtHyojiShojoYoteiYMD")
    public void setTxtHyojiShojoYoteiYMD(TextBoxDate txtHyojiShojoYoteiYMD) {
        this.txtHyojiShojoYoteiYMD = txtHyojiShojoYoteiYMD;
    }

    /*
     * gettxtHyojiShojoYMD
     * @return txtHyojiShojoYMD
     */
    @JsonProperty("txtHyojiShojoYMD")
    public TextBoxDate getTxtHyojiShojoYMD() {
        return txtHyojiShojoYMD;
    }

    /*
     * settxtHyojiShojoYMD
     * @param txtHyojiShojoYMD txtHyojiShojoYMD
     */
    @JsonProperty("txtHyojiShojoYMD")
    public void setTxtHyojiShojoYMD(TextBoxDate txtHyojiShojoYMD) {
        this.txtHyojiShojoYMD = txtHyojiShojoYMD;
    }

    /*
     * gettxtKeikiShuryoYMD
     * @return txtKeikiShuryoYMD
     */
    @JsonProperty("txtKeikiShuryoYMD")
    public TextBoxDate getTxtKeikiShuryoYMD() {
        return txtKeikiShuryoYMD;
    }

    /*
     * settxtKeikiShuryoYMD
     * @param txtKeikiShuryoYMD txtKeikiShuryoYMD
     */
    @JsonProperty("txtKeikiShuryoYMD")
    public void setTxtKeikiShuryoYMD(TextBoxDate txtKeikiShuryoYMD) {
        this.txtKeikiShuryoYMD = txtKeikiShuryoYMD;
    }

    /*
     * getchk2keiMochi
     * @return chk2keiMochi
     */
    @JsonProperty("chk2keiMochi")
    public CheckBoxList getChk2keiMochi() {
        return chk2keiMochi;
    }

    /*
     * setchk2keiMochi
     * @param chk2keiMochi chk2keiMochi
     */
    @JsonProperty("chk2keiMochi")
    public void setChk2keiMochi(CheckBoxList chk2keiMochi) {
        this.chk2keiMochi = chk2keiMochi;
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
     * gettxtHdnTorokuYMD
     * @return txtHdnTorokuYMD
     */
    @JsonProperty("txtHdnTorokuYMD")
    public RString getTxtHdnTorokuYMD() {
        return txtHdnTorokuYMD;
    }

    /*
     * settxtHdnTorokuYMD
     * @param txtHdnTorokuYMD txtHdnTorokuYMD
     */
    @JsonProperty("txtHdnTorokuYMD")
    public void setTxtHdnTorokuYMD(RString txtHdnTorokuYMD) {
        this.txtHdnTorokuYMD = txtHdnTorokuYMD;
    }

    /*
     * gettxtHdnjuminShubetsuCode
     * @return txtHdnjuminShubetsuCode
     */
    @JsonProperty("txtHdnjuminShubetsuCode")
    public RString getTxtHdnjuminShubetsuCode() {
        return txtHdnjuminShubetsuCode;
    }

    /*
     * settxtHdnjuminShubetsuCode
     * @param txtHdnjuminShubetsuCode txtHdnjuminShubetsuCode
     */
    @JsonProperty("txtHdnjuminShubetsuCode")
    public void setTxtHdnjuminShubetsuCode(RString txtHdnjuminShubetsuCode) {
        this.txtHdnjuminShubetsuCode = txtHdnjuminShubetsuCode;
    }

    /*
     * gettxtHdnjuminJotaiCode
     * @return txtHdnjuminJotaiCode
     */
    @JsonProperty("txtHdnjuminJotaiCode")
    public RString getTxtHdnjuminJotaiCode() {
        return txtHdnjuminJotaiCode;
    }

    /*
     * settxtHdnjuminJotaiCode
     * @param txtHdnjuminJotaiCode txtHdnjuminJotaiCode
     */
    @JsonProperty("txtHdnjuminJotaiCode")
    public void setTxtHdnjuminJotaiCode(RString txtHdnjuminJotaiCode) {
        this.txtHdnjuminJotaiCode = txtHdnjuminJotaiCode;
    }

    /*
     * gettxtHdnShojoIdoYMD
     * @return txtHdnShojoIdoYMD
     */
    @JsonProperty("txtHdnShojoIdoYMD")
    public RString getTxtHdnShojoIdoYMD() {
        return txtHdnShojoIdoYMD;
    }

    /*
     * settxtHdnShojoIdoYMD
     * @param txtHdnShojoIdoYMD txtHdnShojoIdoYMD
     */
    @JsonProperty("txtHdnShojoIdoYMD")
    public void setTxtHdnShojoIdoYMD(RString txtHdnShojoIdoYMD) {
        this.txtHdnShojoIdoYMD = txtHdnShojoIdoYMD;
    }

    /*
     * gettxtHdnShojoTodokedeYMD
     * @return txtHdnShojoTodokedeYMD
     */
    @JsonProperty("txtHdnShojoTodokedeYMD")
    public RString getTxtHdnShojoTodokedeYMD() {
        return txtHdnShojoTodokedeYMD;
    }

    /*
     * settxtHdnShojoTodokedeYMD
     * @param txtHdnShojoTodokedeYMD txtHdnShojoTodokedeYMD
     */
    @JsonProperty("txtHdnShojoTodokedeYMD")
    public void setTxtHdnShojoTodokedeYMD(RString txtHdnShojoTodokedeYMD) {
        this.txtHdnShojoTodokedeYMD = txtHdnShojoTodokedeYMD;
    }

    /*
     * gettxtHdnSeinengappiYMD
     * @return txtHdnSeinengappiYMD
     */
    @JsonProperty("txtHdnSeinengappiYMD")
    public RString getTxtHdnSeinengappiYMD() {
        return txtHdnSeinengappiYMD;
    }

    /*
     * settxtHdnSeinengappiYMD
     * @param txtHdnSeinengappiYMD txtHdnSeinengappiYMD
     */
    @JsonProperty("txtHdnSeinengappiYMD")
    public void setTxtHdnSeinengappiYMD(RString txtHdnSeinengappiYMD) {
        this.txtHdnSeinengappiYMD = txtHdnSeinengappiYMD;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(SenkyoShurui senkyoShurui, ShikibetsuCode shikibetsuCode) {
        getHandler().initialize(senkyoShurui, shikibetsuCode);
    }

    @Override
    public void clearData() {
        getHandler().clearThisPanel();
    }

    @JsonIgnore
    public ShikakuJohoHandler getHandler() {
        return new ShikakuJohoHandler(this);
    }

    @Override
    public void get選挙資格状態制御(SenkyoShurui senkyoShurui) {
        getHandler().set選挙資格状態制御(senkyoShurui);
    }

    @Override
    public ValidationMessageControlPairs 入力日付のチェック() {
        return getValidationHandler().validate入力日付のチェック();
    }

    @Override
    public ValidationMessageControlPairs 入力日付ウォーニングチェック() {
        return getValidationHandler().validate入力日付ウォーニングチェックです();
    }

    @Override
    public ValidationMessageControlPairs 同一日チェック() {
        return getValidationHandler().validate同一日チェック();
    }

    @Override
    public ValidationMessageControlPairs 抹消理由と住民種別のチェック() {
        return getValidationHandler().validate抹消理由と住民種別のチェック();
    }

    @Override
    public ValidationMessageControlPairs 抹消理由と抹消年月日入力チェック() {
        return getValidationHandler().validate抹消理由と抹消年月日入力チェック();
    }

    @Override
    public ValidationMessageControlPairs 抹消異動日関連チェック() {
        return getValidationHandler().validate抹消異動日関連チェック();
    }

    @Override
    public ValidationMessageControlPairs 登録停止者変更時のチェック() {
        return getValidationHandler().validate登録停止者変更時のチェック();
    }

    @Override
    public ValidationMessageControlPairs 登録年月日と抹消年月日の関連チェック() {
        return getValidationHandler().validate登録年月日と抹消年月日の関連チェック();
    }

    @Override
    public ValidationMessageControlPairs 登録年月日と表示年月日の関連チェック() {
        return getValidationHandler().validate登録年月日と表示年月日の関連チェック();
    }

    @Override
    public ValidationMessageControlPairs 経過日3ヶ月チェック() {
        return getValidationHandler().validate経過日3ヶ月チェック();
    }

    @Override
    public ValidationMessageControlPairs 表示日と表示事由チェック() {
        return getValidationHandler().validate表示日と表示事由チェック();
    }

    @Override
    public ValidationMessageControlPairs 表示消除予定年月日チェック() {
        return getValidationHandler().validate表示消除予定年月日チェック();
    }

    @Override
    public ValidationMessageControlPairs 表示消除年月日チェック() {
        return getValidationHandler().validate表示消除年月日チェック();
    }

    @Override
    public ValidationMessageControlPairs 転出時の住民種別ウォーニングチェック() {
        return getValidationHandler().validate転出時の住民種別ウォーニングチェックです();
    }

    @Override
    public ValidationMessageControlPairs 転出時の住民種別チェック() {
        return getValidationHandler().validate転出時の住民種別チェック();
    }
    
    @Override
    public ValidationMessageControlPairs 選挙資格の有無チェック() {
        return getValidationHandler().validate選挙資格の有無チェック();
    }

    @Override
    public ValidationMessageControlPairs 住登外チェック() {
        return getValidationHandler().validate住登外チェック();
    }

    @Override
    public ValidationMessageControlPairs 登録対象外Warnチェック() {
        return getValidationHandler().validate登録対象外Warnチェック();
    }   

    @JsonIgnore
    public ShikakuJohoValidationHandler getValidationHandler() {
        return new ShikakuJohoValidationHandler(this);
    }

    @Override
    public ShikakuJohoDiv get選挙資格情報() {
        return this;
    }
}
