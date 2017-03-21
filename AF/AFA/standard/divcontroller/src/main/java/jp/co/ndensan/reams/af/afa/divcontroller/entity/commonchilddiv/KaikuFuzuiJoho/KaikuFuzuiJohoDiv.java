package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuFuzuiJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KumiaiCodeSelect.IKumiaiCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KumiaiCodeSelect.KumiaiCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.CodeInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.ICodeInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * KaikuFuzuiJoho のクラスファイル
 *
 * @author 自動生成
 */
public class KaikuFuzuiJohoDiv extends Panel implements IKaikuFuzuiJohoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdShohonNameList")
    private ShohonNameListDiv ccdShohonNameList;
    @JsonProperty("txtGyogyoshaBango")
    private TextBoxNum txtGyogyoshaBango;
    @JsonProperty("ccdGyogyoKumiaiCode")
    private KumiaiCodeSelectDiv ccdGyogyoKumiaiCode;
    @JsonProperty("lblGyogyoNissu")
    private Label lblGyogyoNissu;
    @JsonProperty("txtGyogyoshaNissu")
    private TextBoxNum txtGyogyoshaNissu;
    @JsonProperty("txtGyogyoJujishaNissu")
    private TextBoxNum txtGyogyoJujishaNissu;
    @JsonProperty("ccdGyogyoShurui")
    private CodeInputDiv ccdGyogyoShurui;
    @JsonProperty("ccdGyosenShubetsu")
    private CodeInputDiv ccdGyosenShubetsu;
    @JsonProperty("txtSenmei")
    private TextBox txtSenmei;
    @JsonProperty("txtTorokuBango")
    private TextBox txtTorokuBango;
    @JsonProperty("txtHiddenShikibetsuCode")
    private RString txtHiddenShikibetsuCode;
    @JsonProperty("txtHiddenShohon")
    private RString txtHiddenShohon;
    @JsonProperty("hdnKaikuSenkyoFuzuiJoho")
    private RString hdnKaikuSenkyoFuzuiJoho;

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
     * gettxtGyogyoshaBango
     * @return txtGyogyoshaBango
     */
    @JsonProperty("txtGyogyoshaBango")
    public TextBoxNum getTxtGyogyoshaBango() {
        return txtGyogyoshaBango;
    }

    /*
     * settxtGyogyoshaBango
     * @param txtGyogyoshaBango txtGyogyoshaBango
     */
    @JsonProperty("txtGyogyoshaBango")
    public void setTxtGyogyoshaBango(TextBoxNum txtGyogyoshaBango) {
        this.txtGyogyoshaBango = txtGyogyoshaBango;
    }

    /*
     * getccdGyogyoKumiaiCode
     * @return ccdGyogyoKumiaiCode
     */
    @JsonProperty("ccdGyogyoKumiaiCode")
    public IKumiaiCodeSelectDiv getCcdGyogyoKumiaiCode() {
        return ccdGyogyoKumiaiCode;
    }

    /*
     * getlblGyogyoNissu
     * @return lblGyogyoNissu
     */
    @JsonProperty("lblGyogyoNissu")
    public Label getLblGyogyoNissu() {
        return lblGyogyoNissu;
    }

    /*
     * setlblGyogyoNissu
     * @param lblGyogyoNissu lblGyogyoNissu
     */
    @JsonProperty("lblGyogyoNissu")
    public void setLblGyogyoNissu(Label lblGyogyoNissu) {
        this.lblGyogyoNissu = lblGyogyoNissu;
    }

    /*
     * gettxtGyogyoshaNissu
     * @return txtGyogyoshaNissu
     */
    @JsonProperty("txtGyogyoshaNissu")
    public TextBoxNum getTxtGyogyoshaNissu() {
        return txtGyogyoshaNissu;
    }

    /*
     * settxtGyogyoshaNissu
     * @param txtGyogyoshaNissu txtGyogyoshaNissu
     */
    @JsonProperty("txtGyogyoshaNissu")
    public void setTxtGyogyoshaNissu(TextBoxNum txtGyogyoshaNissu) {
        this.txtGyogyoshaNissu = txtGyogyoshaNissu;
    }

    /*
     * gettxtGyogyoJujishaNissu
     * @return txtGyogyoJujishaNissu
     */
    @JsonProperty("txtGyogyoJujishaNissu")
    public TextBoxNum getTxtGyogyoJujishaNissu() {
        return txtGyogyoJujishaNissu;
    }

    /*
     * settxtGyogyoJujishaNissu
     * @param txtGyogyoJujishaNissu txtGyogyoJujishaNissu
     */
    @JsonProperty("txtGyogyoJujishaNissu")
    public void setTxtGyogyoJujishaNissu(TextBoxNum txtGyogyoJujishaNissu) {
        this.txtGyogyoJujishaNissu = txtGyogyoJujishaNissu;
    }

    /*
     * getccdGyogyoShurui
     * @return ccdGyogyoShurui
     */
    @JsonProperty("ccdGyogyoShurui")
    public ICodeInputDiv getCcdGyogyoShurui() {
        return ccdGyogyoShurui;
    }

    /*
     * getccdGyosenShubetsu
     * @return ccdGyosenShubetsu
     */
    @JsonProperty("ccdGyosenShubetsu")
    public ICodeInputDiv getCcdGyosenShubetsu() {
        return ccdGyosenShubetsu;
    }

    /*
     * gettxtSenmei
     * @return txtSenmei
     */
    @JsonProperty("txtSenmei")
    public TextBox getTxtSenmei() {
        return txtSenmei;
    }

    /*
     * settxtSenmei
     * @param txtSenmei txtSenmei
     */
    @JsonProperty("txtSenmei")
    public void setTxtSenmei(TextBox txtSenmei) {
        this.txtSenmei = txtSenmei;
    }

    /*
     * gettxtTorokuBango
     * @return txtTorokuBango
     */
    @JsonProperty("txtTorokuBango")
    public TextBox getTxtTorokuBango() {
        return txtTorokuBango;
    }

    /*
     * settxtTorokuBango
     * @param txtTorokuBango txtTorokuBango
     */
    @JsonProperty("txtTorokuBango")
    public void setTxtTorokuBango(TextBox txtTorokuBango) {
        this.txtTorokuBango = txtTorokuBango;
    }

    /*
     * gettxtHiddenShikibetsuCode
     * @return txtHiddenShikibetsuCode
     */
    @JsonProperty("txtHiddenShikibetsuCode")
    public RString getTxtHiddenShikibetsuCode() {
        return txtHiddenShikibetsuCode;
    }

    /*
     * settxtHiddenShikibetsuCode
     * @param txtHiddenShikibetsuCode txtHiddenShikibetsuCode
     */
    @JsonProperty("txtHiddenShikibetsuCode")
    public void setTxtHiddenShikibetsuCode(RString txtHiddenShikibetsuCode) {
        this.txtHiddenShikibetsuCode = txtHiddenShikibetsuCode;
    }

    /*
     * gettxtHiddenShohon
     * @return txtHiddenShohon
     */
    @JsonProperty("txtHiddenShohon")
    public RString getTxtHiddenShohon() {
        return txtHiddenShohon;
    }

    /*
     * settxtHiddenShohon
     * @param txtHiddenShohon txtHiddenShohon
     */
    @JsonProperty("txtHiddenShohon")
    public void setTxtHiddenShohon(RString txtHiddenShohon) {
        this.txtHiddenShohon = txtHiddenShohon;
    }

    /*
     * gethdnKaikuSenkyoFuzuiJoho
     * @return hdnKaikuSenkyoFuzuiJoho
     */
    @JsonProperty("hdnKaikuSenkyoFuzuiJoho")
    public RString getHdnKaikuSenkyoFuzuiJoho() {
        return hdnKaikuSenkyoFuzuiJoho;
    }

    /*
     * sethdnKaikuSenkyoFuzuiJoho
     * @param hdnKaikuSenkyoFuzuiJoho hdnKaikuSenkyoFuzuiJoho
     */
    @JsonProperty("hdnKaikuSenkyoFuzuiJoho")
    public void setHdnKaikuSenkyoFuzuiJoho(RString hdnKaikuSenkyoFuzuiJoho) {
        this.hdnKaikuSenkyoFuzuiJoho = hdnKaikuSenkyoFuzuiJoho;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(RString shohonNo, ShikibetsuCode shikibetsuCode) {
        getHandler().initialize(shohonNo, shikibetsuCode);
    }

    @Override
    public void initialize(ShikibetsuCode shikibetsuCode) {
        getHandler().initialize(shikibetsuCode);
    }

    @Override
    public void clearData() {
        getHandler().clearThisPanel();
    }

    @Override
    public void setDisplayNoneMode(Boolean displayNoneSetMode) {
        getHandler().setDisplayNoneMode(displayNoneSetMode);
    }

    @Override
    public boolean isDisplayNoneMode() {
        return getHandler().isDisplayNoneMode();
    }

    @JsonIgnore
    public KaikuFuzuiJohoHandler getHandler() {
        return new KaikuFuzuiJohoHandler(this);
    }

    @Override
    public void changeDdlShohon(RString shohonNo, ShikibetsuCode shikibetsuCode) {
        getHandler().changeDdlShohon(shohonNo, shikibetsuCode);
    }

    @Override
    public KaikuFuzuiJohoDiv get海区付随資格情報() {
        return this;
    }

}
