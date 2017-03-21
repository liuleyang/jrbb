package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.FuzaishaShikaku;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JiyuNameList.IJiyuNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JiyuNameList.JiyuNameListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * FuzaishaShikaku のクラスファイル
 *
 * @author 自動生成
 */
public class FuzaishaShikakuDiv extends Panel implements IFuzaishaShikakuDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radShikakuKubun")
    private RadioButton radShikakuKubun;
    @JsonProperty("txtShikakuTorokuYMD")
    private TextBoxDate txtShikakuTorokuYMD;
    @JsonProperty("txtKofuYMD")
    private TextBoxDate txtKofuYMD;
    @JsonProperty("txtManryoYMD")
    private TextBoxDate txtManryoYMD;
    @JsonProperty("txtMasshoYMD")
    private TextBoxDate txtMasshoYMD;
    @JsonProperty("ccdMasshoJiyu")
    private JiyuNameListDiv ccdMasshoJiyu;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("txtHdnTohyoShikakuShurui")
    private RString txtHdnTohyoShikakuShurui;
    @JsonProperty("txtHdnShikibetsuCode")
    private RString txtHdnShikibetsuCode;
    @JsonProperty("txtHdnSeq")
    private RString txtHdnSeq;
    @JsonProperty("txtHdnNumber")
    private RString txtHdnNumber;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradShikakuKubun
     * @return radShikakuKubun
     */
    @JsonProperty("radShikakuKubun")
    public RadioButton getRadShikakuKubun() {
        return radShikakuKubun;
    }

    /*
     * setradShikakuKubun
     * @param radShikakuKubun radShikakuKubun
     */
    @JsonProperty("radShikakuKubun")
    public void setRadShikakuKubun(RadioButton radShikakuKubun) {
        this.radShikakuKubun = radShikakuKubun;
    }

    /*
     * gettxtShikakuTorokuYMD
     * @return txtShikakuTorokuYMD
     */
    @JsonProperty("txtShikakuTorokuYMD")
    public TextBoxDate getTxtShikakuTorokuYMD() {
        return txtShikakuTorokuYMD;
    }

    /*
     * settxtShikakuTorokuYMD
     * @param txtShikakuTorokuYMD txtShikakuTorokuYMD
     */
    @JsonProperty("txtShikakuTorokuYMD")
    public void setTxtShikakuTorokuYMD(TextBoxDate txtShikakuTorokuYMD) {
        this.txtShikakuTorokuYMD = txtShikakuTorokuYMD;
    }

    /*
     * gettxtKofuYMD
     * @return txtKofuYMD
     */
    @JsonProperty("txtKofuYMD")
    public TextBoxDate getTxtKofuYMD() {
        return txtKofuYMD;
    }

    /*
     * settxtKofuYMD
     * @param txtKofuYMD txtKofuYMD
     */
    @JsonProperty("txtKofuYMD")
    public void setTxtKofuYMD(TextBoxDate txtKofuYMD) {
        this.txtKofuYMD = txtKofuYMD;
    }

    /*
     * gettxtManryoYMD
     * @return txtManryoYMD
     */
    @JsonProperty("txtManryoYMD")
    public TextBoxDate getTxtManryoYMD() {
        return txtManryoYMD;
    }

    /*
     * settxtManryoYMD
     * @param txtManryoYMD txtManryoYMD
     */
    @JsonProperty("txtManryoYMD")
    public void setTxtManryoYMD(TextBoxDate txtManryoYMD) {
        this.txtManryoYMD = txtManryoYMD;
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
     * gettxtHdnTohyoShikakuShurui
     * @return txtHdnTohyoShikakuShurui
     */
    @JsonProperty("txtHdnTohyoShikakuShurui")
    public RString getTxtHdnTohyoShikakuShurui() {
        return txtHdnTohyoShikakuShurui;
    }

    /*
     * settxtHdnTohyoShikakuShurui
     * @param txtHdnTohyoShikakuShurui txtHdnTohyoShikakuShurui
     */
    @JsonProperty("txtHdnTohyoShikakuShurui")
    public void setTxtHdnTohyoShikakuShurui(RString txtHdnTohyoShikakuShurui) {
        this.txtHdnTohyoShikakuShurui = txtHdnTohyoShikakuShurui;
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
     * gettxtHdnSeq
     * @return txtHdnSeq
     */
    @JsonProperty("txtHdnSeq")
    public RString getTxtHdnSeq() {
        return txtHdnSeq;
    }

    /*
     * settxtHdnSeq
     * @param txtHdnSeq txtHdnSeq
     */
    @JsonProperty("txtHdnSeq")
    public void setTxtHdnSeq(RString txtHdnSeq) {
        this.txtHdnSeq = txtHdnSeq;
    }

    /*
     * gettxtHdnNumber
     * @return txtHdnNumber
     */
    @JsonProperty("txtHdnNumber")
    public RString getTxtHdnNumber() {
        return txtHdnNumber;
    }

    /*
     * settxtHdnNumber
     * @param txtHdnNumber txtHdnNumber
     */
    @JsonProperty("txtHdnNumber")
    public void setTxtHdnNumber(RString txtHdnNumber) {
        this.txtHdnNumber = txtHdnNumber;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(Code 投票資格種類, ShikibetsuCode 識別コード) {
        FuzaishaShikakuHandler.of(this).initialize(投票資格種類, 識別コード);
    }

    @Override
    public void clear() {
        FuzaishaShikakuHandler.of(this).clear();
    }

    @Override
    public void set有りの場合() {
        FuzaishaShikakuHandler.of(this).set有りの場合();
    }

    @Override
    public void set無しの場合() {
        FuzaishaShikakuHandler.of(this).set無しの場合();
    }

    @Override
    public FuzaishaShikakuDiv get不在者資格情報() {
        return this;
    }
}
