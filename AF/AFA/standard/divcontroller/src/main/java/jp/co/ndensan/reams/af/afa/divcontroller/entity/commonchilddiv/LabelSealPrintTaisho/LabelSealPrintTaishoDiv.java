package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.LabelSealPrintTaisho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KijitsumaeFuzaishaKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * LabelSealPrintTaisho のクラスファイルです。
 *
 * @reamsid_L AF-0620-016 zhangl
 */
public class LabelSealPrintTaishoDiv extends Panel implements ILabelSealPrintTaishoDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkFuzaishaTohyoShomeisho")
    private CheckBoxList chkFuzaishaTohyoShomeisho;
    @JsonProperty("chkSenseisho")
    private CheckBoxList chkSenseisho;
    @JsonProperty("lblLabelSeal")
    private Label lblLabelSeal;
    @JsonProperty("chkLabelSenseisho")
    private CheckBoxList chkLabelSenseisho;
    @JsonProperty("txtMaisuSenseisho")
    private TextBoxNum txtMaisuSenseisho;
    @JsonProperty("chkLabelFuto")
    private CheckBoxList chkLabelFuto;
    @JsonProperty("txtMaisuFuto")
    private TextBoxNum txtMaisuFuto;
    @JsonProperty("chkSenkyo")
    private CheckBoxList chkSenkyo;
    @JsonProperty("chkLabelShohon")
    private CheckBoxList chkLabelShohon;
    @JsonProperty("txtMaisuShohon")
    private TextBoxNum txtMaisuShohon;
    @JsonProperty("chkLabelNyujoken")
    private CheckBoxList chkLabelNyujoken;
    @JsonProperty("txtMaisuNyujoken")
    private TextBoxNum txtMaisuNyujoken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkFuzaishaTohyoShomeisho
     * @return chkFuzaishaTohyoShomeisho
     */
    @JsonProperty("chkFuzaishaTohyoShomeisho")
    public CheckBoxList getChkFuzaishaTohyoShomeisho() {
        return chkFuzaishaTohyoShomeisho;
    }

    /*
     * setchkFuzaishaTohyoShomeisho
     * @param chkFuzaishaTohyoShomeisho chkFuzaishaTohyoShomeisho
     */
    @JsonProperty("chkFuzaishaTohyoShomeisho")
    public void setChkFuzaishaTohyoShomeisho(CheckBoxList chkFuzaishaTohyoShomeisho) {
        this.chkFuzaishaTohyoShomeisho = chkFuzaishaTohyoShomeisho;
    }

    /*
     * getchkSenseisho
     * @return chkSenseisho
     */
    @JsonProperty("chkSenseisho")
    public CheckBoxList getChkSenseisho() {
        return chkSenseisho;
    }

    /*
     * setchkSenseisho
     * @param chkSenseisho chkSenseisho
     */
    @JsonProperty("chkSenseisho")
    public void setChkSenseisho(CheckBoxList chkSenseisho) {
        this.chkSenseisho = chkSenseisho;
    }

    /*
     * getlblLabelSeal
     * @return lblLabelSeal
     */
    @JsonProperty("lblLabelSeal")
    public Label getLblLabelSeal() {
        return lblLabelSeal;
    }

    /*
     * setlblLabelSeal
     * @param lblLabelSeal lblLabelSeal
     */
    @JsonProperty("lblLabelSeal")
    public void setLblLabelSeal(Label lblLabelSeal) {
        this.lblLabelSeal = lblLabelSeal;
    }

    /*
     * getchkLabelSenseisho
     * @return chkLabelSenseisho
     */
    @JsonProperty("chkLabelSenseisho")
    public CheckBoxList getChkLabelSenseisho() {
        return chkLabelSenseisho;
    }

    /*
     * setchkLabelSenseisho
     * @param chkLabelSenseisho chkLabelSenseisho
     */
    @JsonProperty("chkLabelSenseisho")
    public void setChkLabelSenseisho(CheckBoxList chkLabelSenseisho) {
        this.chkLabelSenseisho = chkLabelSenseisho;
    }

    /*
     * gettxtMaisuSenseisho
     * @return txtMaisuSenseisho
     */
    @JsonProperty("txtMaisuSenseisho")
    public TextBoxNum getTxtMaisuSenseisho() {
        return txtMaisuSenseisho;
    }

    /*
     * settxtMaisuSenseisho
     * @param txtMaisuSenseisho txtMaisuSenseisho
     */
    @JsonProperty("txtMaisuSenseisho")
    public void setTxtMaisuSenseisho(TextBoxNum txtMaisuSenseisho) {
        this.txtMaisuSenseisho = txtMaisuSenseisho;
    }

    /*
     * getchkLabelFuto
     * @return chkLabelFuto
     */
    @JsonProperty("chkLabelFuto")
    public CheckBoxList getChkLabelFuto() {
        return chkLabelFuto;
    }

    /*
     * setchkLabelFuto
     * @param chkLabelFuto chkLabelFuto
     */
    @JsonProperty("chkLabelFuto")
    public void setChkLabelFuto(CheckBoxList chkLabelFuto) {
        this.chkLabelFuto = chkLabelFuto;
    }

    /*
     * gettxtMaisuFuto
     * @return txtMaisuFuto
     */
    @JsonProperty("txtMaisuFuto")
    public TextBoxNum getTxtMaisuFuto() {
        return txtMaisuFuto;
    }

    /*
     * settxtMaisuFuto
     * @param txtMaisuFuto txtMaisuFuto
     */
    @JsonProperty("txtMaisuFuto")
    public void setTxtMaisuFuto(TextBoxNum txtMaisuFuto) {
        this.txtMaisuFuto = txtMaisuFuto;
    }

    /*
     * getchkSenkyo
     * @return chkSenkyo
     */
    @JsonProperty("chkSenkyo")
    public CheckBoxList getChkSenkyo() {
        return chkSenkyo;
    }

    /*
     * setchkSenkyo
     * @param chkSenkyo chkSenkyo
     */
    @JsonProperty("chkSenkyo")
    public void setChkSenkyo(CheckBoxList chkSenkyo) {
        this.chkSenkyo = chkSenkyo;
    }

    /*
     * getchkLabelShohon
     * @return chkLabelShohon
     */
    @JsonProperty("chkLabelShohon")
    public CheckBoxList getChkLabelShohon() {
        return chkLabelShohon;
    }

    /*
     * setchkLabelShohon
     * @param chkLabelShohon chkLabelShohon
     */
    @JsonProperty("chkLabelShohon")
    public void setChkLabelShohon(CheckBoxList chkLabelShohon) {
        this.chkLabelShohon = chkLabelShohon;
    }

    /*
     * gettxtMaisuShohon
     * @return txtMaisuShohon
     */
    @JsonProperty("txtMaisuShohon")
    public TextBoxNum getTxtMaisuShohon() {
        return txtMaisuShohon;
    }

    /*
     * settxtMaisuShohon
     * @param txtMaisuShohon txtMaisuShohon
     */
    @JsonProperty("txtMaisuShohon")
    public void setTxtMaisuShohon(TextBoxNum txtMaisuShohon) {
        this.txtMaisuShohon = txtMaisuShohon;
    }

    /*
     * getchkLabelNyujoken
     * @return chkLabelNyujoken
     */
    @JsonProperty("chkLabelNyujoken")
    public CheckBoxList getChkLabelNyujoken() {
        return chkLabelNyujoken;
    }

    /*
     * setchkLabelNyujoken
     * @param chkLabelNyujoken chkLabelNyujoken
     */
    @JsonProperty("chkLabelNyujoken")
    public void setChkLabelNyujoken(CheckBoxList chkLabelNyujoken) {
        this.chkLabelNyujoken = chkLabelNyujoken;
    }

    /*
     * gettxtMaisuNyujoken
     * @return txtMaisuNyujoken
     */
    @JsonProperty("txtMaisuNyujoken")
    public TextBoxNum getTxtMaisuNyujoken() {
        return txtMaisuNyujoken;
    }

    /*
     * settxtMaisuNyujoken
     * @param txtMaisuNyujoken txtMaisuNyujoken
     */
    @JsonProperty("txtMaisuNyujoken")
    public void setTxtMaisuNyujoken(TextBoxNum txtMaisuNyujoken) {
        this.txtMaisuNyujoken = txtMaisuNyujoken;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @JsonIgnore
    public LabelSealPrintTaishoHandler getHandler() {
        return new LabelSealPrintTaishoHandler(this);
    }

    @Override
    public void initialize(KijitsumaeFuzaishaKubun 期日前不在者区分, ShohonNo 抄本番号) {
        getHandler().initialize(期日前不在者区分, 抄本番号);
    }

    @Override
    public ValidationMessageControlPairs validate() {
        return getValidationHandler().validate();
    }

    @Override
    public boolean isCheckedFuzaishaTohyoShomeisho() {
        return chkFuzaishaTohyoShomeisho.isAllSelected();
    }

    @Override
    public boolean isCheckedSenseisho() {
        return chkSenseisho.isAllSelected();
    }

    @Override
    public boolean isCheckedLabelSenseisho() {
        return chkLabelSenseisho.isAllSelected();
    }

    @Override
    public boolean isCheckedLabelFuto() {
        return chkLabelFuto.isAllSelected();
    }

    @Override
    public boolean isCheckedLabelShohon() {
        return chkLabelShohon.isAllSelected();
    }

    @Override
    public boolean isCheckedLabelNyujoken() {
        return chkLabelNyujoken.isAllSelected();
    }

    @Override
    public boolean isChkFuzaishaTohyoShomeishoDisplay() {
        return !chkFuzaishaTohyoShomeisho.isDisplayNone();
    }

    @Override
    public boolean isChkSenseishoDisplay() {
        return !chkSenseisho.isDisplayNone();
    }

    @Override
    public boolean isChkLabelSenseishoDisplay() {
        return !chkLabelSenseisho.isDisplayNone();
    }

    @Override
    public boolean isChkLabelFutoDisplay() {
        return !chkLabelFuto.isDisplayNone();
    }

    @Override
    public boolean isChkSenkyoDisplay() {
        return !chkSenkyo.isDisplayNone();
    }

    @Override
    public boolean isChkLabelShohonDisplay() {
        return !chkLabelShohon.isDisplayNone();
    }

    @Override
    public boolean isChkLabelNyujokenDisplay() {
        return !chkLabelNyujoken.isDisplayNone();
    }

    @Override
    public boolean is全てのチェックボックス非表示() {
        return chkFuzaishaTohyoShomeisho.isDisplayNone()
                && chkSenseisho.isDisplayNone()
                && chkLabelSenseisho.isDisplayNone()
                && chkLabelFuto.isDisplayNone()
                && chkSenkyo.isDisplayNone()
                && chkLabelShohon.isDisplayNone()
                && chkLabelNyujoken.isDisplayNone();
    }

    @Override
    public List<RString> get選挙リスト() {
        return chkSenkyo.getSelectedValues();
    }

    @Override
    public List<RString> get選挙Indexリスト() {
        return chkSenkyo.getSelectedKeys();
    }

    @Override
    public int get宣誓書貼付用の印刷枚数() {
        if (txtMaisuSenseisho.getValue() == null) {
            return 0;
        } else {
            return txtMaisuSenseisho.getValue().intValue();
        }
    }

    @Override
    public int get抄本貼付用の印刷枚数() {
        if (txtMaisuShohon.getValue() == null) {
            return 0;
        } else {
            return txtMaisuShohon.getValue().intValue();
        }
    }

    @Override
    public int get入場券貼付用の印刷枚数() {
        if (txtMaisuNyujoken.getValue() == null) {
            return 0;
        } else {
            return txtMaisuNyujoken.getValue().intValue();
        }
    }

    @Override
    public List<RString> getシール種別リスト() {
        List<RString> list = new ArrayList<>();
        if (isChkLabelSenseishoDisplay() && isCheckedLabelSenseisho()) {
            list.add(new RString("宣誓書貼付用"));
        }
        if (isChkLabelFutoDisplay() && isCheckedLabelFuto()) {
            list.add(new RString("封筒貼付用"));
        }
        if (isChkLabelShohonDisplay() && isCheckedLabelShohon()) {
            list.add(new RString("抄本貼付用"));
        }
        if (isChkLabelNyujokenDisplay() && isCheckedLabelNyujoken()) {
            list.add(new RString("入場券貼付用"));
        }
        return list;
    }

    private LabelSealPrintTaishoValidationHandler getValidationHandler() {
        return new LabelSealPrintTaishoValidationHandler(this);
    }
}
