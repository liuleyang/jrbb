package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ZaigaiMeiboJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JiyuNameList.IJiyuNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JiyuNameList.JiyuNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.ITohyokuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.TohyokuCodeSelectDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.BanchiInput.BanchiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.BanchiInput.IBanchiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.KatagakiInput.IKatagakiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.KatagakiInput.KatagakiInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.ZenkokuJushoInput.IZenkokuJushoInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.ZenkokuJushoInput.ZenkokuJushoInputDiv;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
public class ZaigaiMeiboJohoDiv extends Panel implements IZaigaiMeiboJohoDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdShohonNameList")
    private ShohonNameListDiv ccdShohonNameList;
    @JsonProperty("radZaigaiShikaku")
    private RadioButton radZaigaiShikaku;
    @JsonProperty("ccdTohyokuCode")
    private TohyokuCodeSelectDiv ccdTohyokuCode;
    @JsonProperty("txtTorokuYMD")
    private TextBoxDate txtTorokuYMD;
    @JsonProperty("txtHyojiYMD")
    private TextBoxDate txtHyojiYMD;
    @JsonProperty("ccdHyojiJiyu")
    private JiyuNameListDiv ccdHyojiJiyu;
    @JsonProperty("lblJusho")
    private Label lblJusho;
    @JsonProperty("ccdKokunaiTennyuJusho")
    private ZenkokuJushoInputDiv ccdKokunaiTennyuJusho;
    @JsonProperty("ccdKokunaiTennyuBanchi")
    private BanchiInputDiv ccdKokunaiTennyuBanchi;
    @JsonProperty("ccdKokunaiTennyuKatagaki")
    private KatagakiInputDiv ccdKokunaiTennyuKatagaki;
    @JsonProperty("txtKokunaiTennyuYMD")
    private TextBoxDate txtKokunaiTennyuYMD;
    @JsonProperty("txtMasshoYMD")
    private TextBoxDate txtMasshoYMD;
    @JsonProperty("ccdMasshoJiyu")
    private JiyuNameListDiv ccdMasshoJiyu;
    @JsonProperty("txtShuseiYMD")
    private TextBoxDate txtShuseiYMD;
    @JsonProperty("txtBiko")
    private TextBoxMultiLine txtBiko;
    @JsonProperty("hdnKokuminTohyoKubun")
    private RString hdnKokuminTohyoKubun;

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
     * getradZaigaiShikaku
     * @return radZaigaiShikaku
     */
    @JsonProperty("radZaigaiShikaku")
    public RadioButton getRadZaigaiShikaku() {
        return radZaigaiShikaku;
    }

    /*
     * setradZaigaiShikaku
     * @param radZaigaiShikaku radZaigaiShikaku
     */
    @JsonProperty("radZaigaiShikaku")
    public void setRadZaigaiShikaku(RadioButton radZaigaiShikaku) {
        this.radZaigaiShikaku = radZaigaiShikaku;
    }

    /*
     * getccdTohyokuCode
     * @return ccdTohyokuCode
     */
    @JsonProperty("ccdTohyokuCode")
    public ITohyokuCodeSelectDiv getCcdTohyokuCode() {
        return ccdTohyokuCode;
    }

    /*
     * gettxtTorokuYMD
     * @return txtTorokuYMD
     */
    @JsonProperty("txtTorokuYMD")
    public TextBoxDate getTxtTorokuYMD() {
        return txtTorokuYMD;
    }

    /*
     * settxtTorokuYMD
     * @param txtTorokuYMD txtTorokuYMD
     */
    @JsonProperty("txtTorokuYMD")
    public void setTxtTorokuYMD(TextBoxDate txtTorokuYMD) {
        this.txtTorokuYMD = txtTorokuYMD;
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
     * getlblJusho
     * @return lblJusho
     */
    @JsonProperty("lblJusho")
    public Label getLblJusho() {
        return lblJusho;
    }

    /*
     * setlblJusho
     * @param lblJusho lblJusho
     */
    @JsonProperty("lblJusho")
    public void setLblJusho(Label lblJusho) {
        this.lblJusho = lblJusho;
    }

    /*
     * getccdKokunaiTennyuJusho
     * @return ccdKokunaiTennyuJusho
     */
    @JsonProperty("ccdKokunaiTennyuJusho")
    public IZenkokuJushoInputDiv getCcdKokunaiTennyuJusho() {
        return ccdKokunaiTennyuJusho;
    }

    /*
     * getccdKokunaiTennyuBanchi
     * @return ccdKokunaiTennyuBanchi
     */
    @JsonProperty("ccdKokunaiTennyuBanchi")
    public IBanchiInputDiv getCcdKokunaiTennyuBanchi() {
        return ccdKokunaiTennyuBanchi;
    }

    /*
     * getccdKokunaiTennyuKatagaki
     * @return ccdKokunaiTennyuKatagaki
     */
    @JsonProperty("ccdKokunaiTennyuKatagaki")
    public IKatagakiInputDiv getCcdKokunaiTennyuKatagaki() {
        return ccdKokunaiTennyuKatagaki;
    }

    /*
     * gettxtKokunaiTennyuYMD
     * @return txtKokunaiTennyuYMD
     */
    @JsonProperty("txtKokunaiTennyuYMD")
    public TextBoxDate getTxtKokunaiTennyuYMD() {
        return txtKokunaiTennyuYMD;
    }

    /*
     * settxtKokunaiTennyuYMD
     * @param txtKokunaiTennyuYMD txtKokunaiTennyuYMD
     */
    @JsonProperty("txtKokunaiTennyuYMD")
    public void setTxtKokunaiTennyuYMD(TextBoxDate txtKokunaiTennyuYMD) {
        this.txtKokunaiTennyuYMD = txtKokunaiTennyuYMD;
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
     * gettxtShuseiYMD
     * @return txtShuseiYMD
     */
    @JsonProperty("txtShuseiYMD")
    public TextBoxDate getTxtShuseiYMD() {
        return txtShuseiYMD;
    }

    /*
     * settxtShuseiYMD
     * @param txtShuseiYMD txtShuseiYMD
     */
    @JsonProperty("txtShuseiYMD")
    public void setTxtShuseiYMD(TextBoxDate txtShuseiYMD) {
        this.txtShuseiYMD = txtShuseiYMD;
    }

    /*
     * gettxtBiko
     * @return txtBiko
     */
    @JsonProperty("txtBiko")
    public TextBoxMultiLine getTxtBiko() {
        return txtBiko;
    }

    /*
     * settxtBiko
     * @param txtBiko txtBiko
     */
    @JsonProperty("txtBiko")
    public void setTxtBiko(TextBoxMultiLine txtBiko) {
        this.txtBiko = txtBiko;
    }

    /*
     * gethdnKokuminTohyoKubun
     * @return hdnKokuminTohyoKubun
     */
    @JsonProperty("hdnKokuminTohyoKubun")
    public RString getHdnKokuminTohyoKubun() {
        return hdnKokuminTohyoKubun;
    }

    /*
     * sethdnKokuminTohyoKubun
     * @param hdnKokuminTohyoKubun hdnKokuminTohyoKubun
     */
    @JsonProperty("hdnKokuminTohyoKubun")
    public void setHdnKokuminTohyoKubun(RString hdnKokuminTohyoKubun) {
        this.hdnKokuminTohyoKubun = hdnKokuminTohyoKubun;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(RString 申請番号, ShikibetsuCode 識別コード) {
        getHandler().initialize(申請番号, 識別コード);
    }

    @Override
    public void setDisplayNoneMode(Boolean displayNoneSetMode) {
        getHandler().setDisplayNoneMode(displayNoneSetMode);
    }

    @Override
    public void setReadOnlyMode(Boolean readOnlySetMode) {
        getHandler().setReadOnlyMode(readOnlySetMode);
    }

    @Override
    public void setIsOpenMode(Boolean isOpenSetMode) {
        getHandler().setIsOpenMode(isOpenSetMode);
    }

    @JsonIgnore
    public ZaigaiMeiboJohoHandler getHandler() {
        return new ZaigaiMeiboJohoHandler(this);
    }

    @Override
    public ZaigaiMeiboJohoDiv get在外名簿情報() {
        return this;
    }
}
