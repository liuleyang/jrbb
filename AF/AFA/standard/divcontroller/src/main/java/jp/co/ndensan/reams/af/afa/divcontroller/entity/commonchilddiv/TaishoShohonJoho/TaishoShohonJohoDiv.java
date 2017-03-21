package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TaishoShohonJoho;
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
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 *
 * @reamsid_L AF-0050-010 qiuxy
 */
public class TaishoShohonJohoDiv extends Panel implements ITaishoShohonJohoDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdShohonNameList")
    private ShohonNameListDiv ccdShohonNameList;
    @JsonProperty("txtShohonName")
    private TextBox txtShohonName;
    @JsonProperty("txtKijunYMD")
    private TextBoxDate txtKijunYMD;
    @JsonProperty("txtTohyoYMD")
    private TextBoxDate txtTohyoYMD;
    @JsonProperty("txtMeiboTorokuYMD")
    private TextBoxDate txtMeiboTorokuYMD;
    @JsonProperty("txtNenreiTotatsuYMD")
    private TextBoxDate txtNenreiTotatsuYMD;
    @JsonProperty("txtTenshutsuKigenYMD")
    private TextBoxDate txtTenshutsuKigenYMD;
    @JsonProperty("txtTennyuKigenYMD")
    private TextBoxDate txtTennyuKigenYMD;
    @JsonProperty("btnHdnChangeShohon")
    private Button btnHdnChangeShohon;
    @JsonProperty("txtHdnSenkyoShurui")
    private RString txtHdnSenkyoShurui;
    @JsonProperty("txtHdnShohonNo")
    private RString txtHdnShohonNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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
     * gettxtTenshutsuKigenYMD
     * @return txtTenshutsuKigenYMD
     */
    @JsonProperty("txtTenshutsuKigenYMD")
    public TextBoxDate getTxtTenshutsuKigenYMD() {
        return txtTenshutsuKigenYMD;
    }

    /*
     * settxtTenshutsuKigenYMD
     * @param txtTenshutsuKigenYMD txtTenshutsuKigenYMD
     */
    @JsonProperty("txtTenshutsuKigenYMD")
    public void setTxtTenshutsuKigenYMD(TextBoxDate txtTenshutsuKigenYMD) {
        this.txtTenshutsuKigenYMD = txtTenshutsuKigenYMD;
    }

    /*
     * gettxtTennyuKigenYMD
     * @return txtTennyuKigenYMD
     */
    @JsonProperty("txtTennyuKigenYMD")
    public TextBoxDate getTxtTennyuKigenYMD() {
        return txtTennyuKigenYMD;
    }

    /*
     * settxtTennyuKigenYMD
     * @param txtTennyuKigenYMD txtTennyuKigenYMD
     */
    @JsonProperty("txtTennyuKigenYMD")
    public void setTxtTennyuKigenYMD(TextBoxDate txtTennyuKigenYMD) {
        this.txtTennyuKigenYMD = txtTennyuKigenYMD;
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

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @JsonIgnore
    @Override
    public void initialize(SenkyoShurui senkyoShurui) {
        getHandler().initialize(senkyoShurui);
    }

    @JsonIgnore
    @Override
    public void initialSetting() {
        getHandler().initialSetting();
    }

    @JsonIgnore
    @Override
    public void initialize(RString shohonNo) {
        getHandler().initialize(shohonNo);
    }

    @JsonIgnore
    @Override
    public void clearData() {
        getHandler().clearThisPanel();
    }

    @Override
    public RString get抄本名() {
        return txtShohonName.getText();
    }

    @Override
    public RDate get基準日() {
        return txtKijunYMD.getValue();
    }

    @Override
    public RDate get投票日() {
        return txtTohyoYMD.getValue();
    }

    @Override
    public RDate get名簿登録日() {
        return txtMeiboTorokuYMD.getValue();
    }

    @Override
    public RDate get年齢到達日() {
        return txtNenreiTotatsuYMD.getValue();
    }

    @Override
    public RDate get転出期限日() {
        return txtTenshutsuKigenYMD.getValue();
    }

    @Override
    public RDate get転入期限日() {
        return txtTennyuKigenYMD.getValue();
    }

    @JsonIgnore
    @Override
    public TaishoShohonJohoHandler getHandler() {
        return new TaishoShohonJohoHandler(this);
    }
}
