package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.HojoshaNyuryoku;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.business.core.contexts.HojoshaNyuryokuContext;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxShikibetsuCode;

/**
 * HojoshaNyuryoku のクラスファイル
 *
 * @reamsid_L AF-0080-030 wangm
 */
public class HojoshaNyuryokuDiv extends Panel implements IHojoshaNyuryokuDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-04-25_11-07-54">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkDairiTohyo")
    private CheckBoxList chkDairiTohyo;
    @JsonProperty("txtHojoshaShimei1")
    private TextBox txtHojoshaShimei1;
    @JsonProperty("btnHojosha1Search")
    private ButtonDialog btnHojosha1Search;
    @JsonProperty("txtHojosha1ShikibetsuCode")
    private TextBoxShikibetsuCode txtHojosha1ShikibetsuCode;
    @JsonProperty("txtHojoshaShimei2")
    private TextBox txtHojoshaShimei2;
    @JsonProperty("btnHojosha2Search")
    private ButtonDialog btnHojosha2Search;
    @JsonProperty("txtHojosha2ShikibetsuCode")
    private TextBoxShikibetsuCode txtHojosha2ShikibetsuCode;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("btnOK")
    private Button btnOK;
    @JsonProperty("txtHdnShohonNo")
    private RString txtHdnShohonNo;
    @JsonProperty("txtHdnTohyokuCode")
    private RString txtHdnTohyokuCode;
    @JsonProperty("HojoshaSelectDialogModel")
    private RString HojoshaSelectDialogModel;
    @JsonProperty("HojoshaNyuryokuModel")
    private RString HojoshaNyuryokuModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkDairiTohyo
     * @return chkDairiTohyo
     */
    @JsonProperty("chkDairiTohyo")
    public CheckBoxList getChkDairiTohyo() {
        return chkDairiTohyo;
    }

    /*
     * setchkDairiTohyo
     * @param chkDairiTohyo chkDairiTohyo
     */
    @JsonProperty("chkDairiTohyo")
    public void setChkDairiTohyo(CheckBoxList chkDairiTohyo) {
        this.chkDairiTohyo = chkDairiTohyo;
    }

    /*
     * gettxtHojoshaShimei1
     * @return txtHojoshaShimei1
     */
    @JsonProperty("txtHojoshaShimei1")
    public TextBox getTxtHojoshaShimei1() {
        return txtHojoshaShimei1;
    }

    /*
     * settxtHojoshaShimei1
     * @param txtHojoshaShimei1 txtHojoshaShimei1
     */
    @JsonProperty("txtHojoshaShimei1")
    public void setTxtHojoshaShimei1(TextBox txtHojoshaShimei1) {
        this.txtHojoshaShimei1 = txtHojoshaShimei1;
    }

    /*
     * getbtnHojosha1Search
     * @return btnHojosha1Search
     */
    @JsonProperty("btnHojosha1Search")
    public ButtonDialog getBtnHojosha1Search() {
        return btnHojosha1Search;
    }

    /*
     * setbtnHojosha1Search
     * @param btnHojosha1Search btnHojosha1Search
     */
    @JsonProperty("btnHojosha1Search")
    public void setBtnHojosha1Search(ButtonDialog btnHojosha1Search) {
        this.btnHojosha1Search = btnHojosha1Search;
    }

    /*
     * gettxtHojosha1ShikibetsuCode
     * @return txtHojosha1ShikibetsuCode
     */
    @JsonProperty("txtHojosha1ShikibetsuCode")
    public TextBoxShikibetsuCode getTxtHojosha1ShikibetsuCode() {
        return txtHojosha1ShikibetsuCode;
    }

    /*
     * settxtHojosha1ShikibetsuCode
     * @param txtHojosha1ShikibetsuCode txtHojosha1ShikibetsuCode
     */
    @JsonProperty("txtHojosha1ShikibetsuCode")
    public void setTxtHojosha1ShikibetsuCode(TextBoxShikibetsuCode txtHojosha1ShikibetsuCode) {
        this.txtHojosha1ShikibetsuCode = txtHojosha1ShikibetsuCode;
    }

    /*
     * gettxtHojoshaShimei2
     * @return txtHojoshaShimei2
     */
    @JsonProperty("txtHojoshaShimei2")
    public TextBox getTxtHojoshaShimei2() {
        return txtHojoshaShimei2;
    }

    /*
     * settxtHojoshaShimei2
     * @param txtHojoshaShimei2 txtHojoshaShimei2
     */
    @JsonProperty("txtHojoshaShimei2")
    public void setTxtHojoshaShimei2(TextBox txtHojoshaShimei2) {
        this.txtHojoshaShimei2 = txtHojoshaShimei2;
    }

    /*
     * getbtnHojosha2Search
     * @return btnHojosha2Search
     */
    @JsonProperty("btnHojosha2Search")
    public ButtonDialog getBtnHojosha2Search() {
        return btnHojosha2Search;
    }

    /*
     * setbtnHojosha2Search
     * @param btnHojosha2Search btnHojosha2Search
     */
    @JsonProperty("btnHojosha2Search")
    public void setBtnHojosha2Search(ButtonDialog btnHojosha2Search) {
        this.btnHojosha2Search = btnHojosha2Search;
    }

    /*
     * gettxtHojosha2ShikibetsuCode
     * @return txtHojosha2ShikibetsuCode
     */
    @JsonProperty("txtHojosha2ShikibetsuCode")
    public TextBoxShikibetsuCode getTxtHojosha2ShikibetsuCode() {
        return txtHojosha2ShikibetsuCode;
    }

    /*
     * settxtHojosha2ShikibetsuCode
     * @param txtHojosha2ShikibetsuCode txtHojosha2ShikibetsuCode
     */
    @JsonProperty("txtHojosha2ShikibetsuCode")
    public void setTxtHojosha2ShikibetsuCode(TextBoxShikibetsuCode txtHojosha2ShikibetsuCode) {
        this.txtHojosha2ShikibetsuCode = txtHojosha2ShikibetsuCode;
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
     * gettxtHdnTohyokuCode
     * @return txtHdnTohyokuCode
     */
    @JsonProperty("txtHdnTohyokuCode")
    public RString getTxtHdnTohyokuCode() {
        return txtHdnTohyokuCode;
    }

    /*
     * settxtHdnTohyokuCode
     * @param txtHdnTohyokuCode txtHdnTohyokuCode
     */
    @JsonProperty("txtHdnTohyokuCode")
    public void setTxtHdnTohyokuCode(RString txtHdnTohyokuCode) {
        this.txtHdnTohyokuCode = txtHdnTohyokuCode;
    }

    /*
     * getHojoshaSelectDialogModel
     * @return HojoshaSelectDialogModel
     */
    @JsonProperty("HojoshaSelectDialogModel")
    public RString getHojoshaSelectDialogModel() {
        return HojoshaSelectDialogModel;
    }

    /*
     * setHojoshaSelectDialogModel
     * @param HojoshaSelectDialogModel HojoshaSelectDialogModel
     */
    @JsonProperty("HojoshaSelectDialogModel")
    public void setHojoshaSelectDialogModel(RString HojoshaSelectDialogModel) {
        this.HojoshaSelectDialogModel = HojoshaSelectDialogModel;
    }

    /*
     * getHojoshaNyuryokuModel
     * @return HojoshaNyuryokuModel
     */
    @JsonProperty("HojoshaNyuryokuModel")
    public RString getHojoshaNyuryokuModel() {
        return HojoshaNyuryokuModel;
    }

    /*
     * setHojoshaNyuryokuModel
     * @param HojoshaNyuryokuModel HojoshaNyuryokuModel
     */
    @JsonProperty("HojoshaNyuryokuModel")
    public void setHojoshaNyuryokuModel(RString HojoshaNyuryokuModel) {
        this.HojoshaNyuryokuModel = HojoshaNyuryokuModel;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public HojoshaNyuryokuContext getHojoshaNyuryokuContext() {
        return getHandler().getHojoshaNyuryokuContext();
    }

    @Override
    public void initialize(RString shohonNo) {
        this.setTxtHdnShohonNo(shohonNo);
        getHandler().initialize();
    }

    @Override
    public void initialize(RString shohonNo, RString tohyokuCode) {
        this.setTxtHdnShohonNo(shohonNo);
        this.setTxtHdnTohyokuCode(tohyokuCode);
        getHandler().initialize();
        getHandler().set補助者を不可にする(false);
    }

    @JsonIgnore
    private HojoshaNyuryokuHandler getHandler() {
        return new HojoshaNyuryokuHandler(this);
    }

    @Override
    public void setReadOnlyMode(Boolean blnShiyoFuka) {
        getHandler().set補助者を不可にする(blnShiyoFuka);
    }

    @Override
    public void clearData() {
        getHandler().clearThisPanelForCheckBox();
        this.getChkDairiTohyo().getSelectedItems().clear();
        getHandler().set補助者を不可にする(true);
    }

    @Override
    public void setButtonDisplayNone(boolean DisplayNone) {
        btnHojosha1Search.setDisplayNone(DisplayNone);
        btnHojosha2Search.setDisplayNone(DisplayNone);
    }
}
