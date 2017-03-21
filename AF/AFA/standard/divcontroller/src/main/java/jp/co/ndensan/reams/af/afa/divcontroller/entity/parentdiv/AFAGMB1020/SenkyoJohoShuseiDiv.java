package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TaishoShohonJoho.ITaishoShohonJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TaishoShohonJoho.TaishoShohonJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SenkyoJohoShusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class SenkyoJohoShuseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-02-19_14-33-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SenkyoShusei")
    private SenkyoShuseiDiv SenkyoShusei;
    @JsonProperty("SenkyoInput")
    private SenkyoInputDiv SenkyoInput;
    @JsonProperty("ccdSenkyoShuseiShohon")
    private TaishoShohonJohoDiv ccdSenkyoShuseiShohon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSenkyoShusei
     * @return SenkyoShusei
     */
    @JsonProperty("SenkyoShusei")
    public SenkyoShuseiDiv getSenkyoShusei() {
        return SenkyoShusei;
    }

    /*
     * setSenkyoShusei
     * @param SenkyoShusei SenkyoShusei
     */
    @JsonProperty("SenkyoShusei")
    public void setSenkyoShusei(SenkyoShuseiDiv SenkyoShusei) {
        this.SenkyoShusei = SenkyoShusei;
    }

    /*
     * getSenkyoInput
     * @return SenkyoInput
     */
    @JsonProperty("SenkyoInput")
    public SenkyoInputDiv getSenkyoInput() {
        return SenkyoInput;
    }

    /*
     * setSenkyoInput
     * @param SenkyoInput SenkyoInput
     */
    @JsonProperty("SenkyoInput")
    public void setSenkyoInput(SenkyoInputDiv SenkyoInput) {
        this.SenkyoInput = SenkyoInput;
    }

    /*
     * getccdSenkyoShuseiShohon
     * @return ccdSenkyoShuseiShohon
     */
    @JsonProperty("ccdSenkyoShuseiShohon")
    public ITaishoShohonJohoDiv getCcdSenkyoShuseiShohon() {
        return ccdSenkyoShuseiShohon;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxNum getTxtSenkyoNo() {
        return this.getSenkyoInput().getTxtSenkyoNo();
    }

    @JsonIgnore
    public void  setTxtSenkyoNo(TextBoxNum txtSenkyoNo) {
        this.getSenkyoInput().setTxtSenkyoNo(txtSenkyoNo);
    }

    @JsonIgnore
    public DropDownList getDdlSenkyoLevel() {
        return this.getSenkyoInput().getDdlSenkyoLevel();
    }

    @JsonIgnore
    public void  setDdlSenkyoLevel(DropDownList ddlSenkyoLevel) {
        this.getSenkyoInput().setDdlSenkyoLevel(ddlSenkyoLevel);
    }

    @JsonIgnore
    public CheckBoxList getChkMutohyoFlag() {
        return this.getSenkyoInput().getChkMutohyoFlag();
    }

    @JsonIgnore
    public void  setChkMutohyoFlag(CheckBoxList chkMutohyoFlag) {
        this.getSenkyoInput().setChkMutohyoFlag(chkMutohyoFlag);
    }

    @JsonIgnore
    public TextBox getTxtSenkyoName() {
        return this.getSenkyoInput().getTxtSenkyoName();
    }

    @JsonIgnore
    public void  setTxtSenkyoName(TextBox txtSenkyoName) {
        this.getSenkyoInput().setTxtSenkyoName(txtSenkyoName);
    }

    @JsonIgnore
    public TextBox getTxtSenkyoRyakusho() {
        return this.getSenkyoInput().getTxtSenkyoRyakusho();
    }

    @JsonIgnore
    public void  setTxtSenkyoRyakusho(TextBox txtSenkyoRyakusho) {
        this.getSenkyoInput().setTxtSenkyoRyakusho(txtSenkyoRyakusho);
    }

    @JsonIgnore
    public TextBox getTxtSenkyoMark() {
        return this.getSenkyoInput().getTxtSenkyoMark();
    }

    @JsonIgnore
    public void  setTxtSenkyoMark(TextBox txtSenkyoMark) {
        this.getSenkyoInput().setTxtSenkyoMark(txtSenkyoMark);
    }

    @JsonIgnore
    public TextBoxDate getTxtKijunYMD() {
        return this.getSenkyoInput().getTxtKijunYMD();
    }

    @JsonIgnore
    public void  setTxtKijunYMD(TextBoxDate txtKijunYMD) {
        this.getSenkyoInput().setTxtKijunYMD(txtKijunYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtUketsukeYMD() {
        return this.getSenkyoInput().getTxtUketsukeYMD();
    }

    @JsonIgnore
    public void  setTxtUketsukeYMD(TextBoxDate txtUketsukeYMD) {
        this.getSenkyoInput().setTxtUketsukeYMD(txtUketsukeYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtKokujiYMD() {
        return this.getSenkyoInput().getTxtKokujiYMD();
    }

    @JsonIgnore
    public void  setTxtKokujiYMD(TextBoxDate txtKokujiYMD) {
        this.getSenkyoInput().setTxtKokujiYMD(txtKokujiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtTorokuYMD() {
        return this.getSenkyoInput().getTxtTorokuYMD();
    }

    @JsonIgnore
    public void  setTxtTorokuYMD(TextBoxDate txtTorokuYMD) {
        this.getSenkyoInput().setTxtTorokuYMD(txtTorokuYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtTenshutsuKigenYMD() {
        return this.getSenkyoInput().getTxtTenshutsuKigenYMD();
    }

    @JsonIgnore
    public void  setTxtTenshutsuKigenYMD(TextBoxDate txtTenshutsuKigenYMD) {
        this.getSenkyoInput().setTxtTenshutsuKigenYMD(txtTenshutsuKigenYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtTennyuKigenYMD() {
        return this.getSenkyoInput().getTxtTennyuKigenYMD();
    }

    @JsonIgnore
    public void  setTxtTennyuKigenYMD(TextBoxDate txtTennyuKigenYMD) {
        this.getSenkyoInput().setTxtTennyuKigenYMD(txtTennyuKigenYMD);
    }

    @JsonIgnore
    public Button getBtnInsert() {
        return this.getSenkyoInput().getBtnInsert();
    }

    @JsonIgnore
    public void  setBtnInsert(Button btnInsert) {
        this.getSenkyoInput().setBtnInsert(btnInsert);
    }

    @JsonIgnore
    public Button getBtnStop() {
        return this.getSenkyoInput().getBtnStop();
    }

    @JsonIgnore
    public void  setBtnStop(Button btnStop) {
        this.getSenkyoInput().setBtnStop(btnStop);
    }

    // </editor-fold>
}
