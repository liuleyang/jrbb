package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FuzaishaTohyo のクラスファイル
 *
 * @author 自動生成
 */
public class FuzaishaTohyoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("FuzaishaJohoSearch")
    private FuzaishaJohoSearchDiv FuzaishaJohoSearch;
    @JsonProperty("FuzaishaSenkyoninSearch")
    private FuzaishaSenkyoninSearchDiv FuzaishaSenkyoninSearch;
    @JsonProperty("FuzaishaTohyoJokyo")
    private FuzaishaTohyoJokyoDiv FuzaishaTohyoJokyo;
    @JsonProperty("hiddenPrintButtonDialog")
    private ButtonDialog hiddenPrintButtonDialog;
    @JsonProperty("SearchSimpleJuminModel")
    private RString SearchSimpleJuminModel;
    @JsonProperty("seikyuFlg")
    private RString seikyuFlg;
    @JsonProperty("labelSealSelectDialogModel")
    private RString labelSealSelectDialogModel;
    @JsonProperty("hiddenPrintButtonDialogFlg")
    private Label hiddenPrintButtonDialogFlg;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getFuzaishaJohoSearch
     * @return FuzaishaJohoSearch
     */
    @JsonProperty("FuzaishaJohoSearch")
    public FuzaishaJohoSearchDiv getFuzaishaJohoSearch() {
        return FuzaishaJohoSearch;
    }

    /*
     * setFuzaishaJohoSearch
     * @param FuzaishaJohoSearch FuzaishaJohoSearch
     */
    @JsonProperty("FuzaishaJohoSearch")
    public void setFuzaishaJohoSearch(FuzaishaJohoSearchDiv FuzaishaJohoSearch) {
        this.FuzaishaJohoSearch = FuzaishaJohoSearch;
    }

    /*
     * getFuzaishaSenkyoninSearch
     * @return FuzaishaSenkyoninSearch
     */
    @JsonProperty("FuzaishaSenkyoninSearch")
    public FuzaishaSenkyoninSearchDiv getFuzaishaSenkyoninSearch() {
        return FuzaishaSenkyoninSearch;
    }

    /*
     * setFuzaishaSenkyoninSearch
     * @param FuzaishaSenkyoninSearch FuzaishaSenkyoninSearch
     */
    @JsonProperty("FuzaishaSenkyoninSearch")
    public void setFuzaishaSenkyoninSearch(FuzaishaSenkyoninSearchDiv FuzaishaSenkyoninSearch) {
        this.FuzaishaSenkyoninSearch = FuzaishaSenkyoninSearch;
    }

    /*
     * getFuzaishaTohyoJokyo
     * @return FuzaishaTohyoJokyo
     */
    @JsonProperty("FuzaishaTohyoJokyo")
    public FuzaishaTohyoJokyoDiv getFuzaishaTohyoJokyo() {
        return FuzaishaTohyoJokyo;
    }

    /*
     * setFuzaishaTohyoJokyo
     * @param FuzaishaTohyoJokyo FuzaishaTohyoJokyo
     */
    @JsonProperty("FuzaishaTohyoJokyo")
    public void setFuzaishaTohyoJokyo(FuzaishaTohyoJokyoDiv FuzaishaTohyoJokyo) {
        this.FuzaishaTohyoJokyo = FuzaishaTohyoJokyo;
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
     * getSearchSimpleJuminModel
     * @return SearchSimpleJuminModel
     */
    @JsonProperty("SearchSimpleJuminModel")
    public RString getSearchSimpleJuminModel() {
        return SearchSimpleJuminModel;
    }

    /*
     * setSearchSimpleJuminModel
     * @param SearchSimpleJuminModel SearchSimpleJuminModel
     */
    @JsonProperty("SearchSimpleJuminModel")
    public void setSearchSimpleJuminModel(RString SearchSimpleJuminModel) {
        this.SearchSimpleJuminModel = SearchSimpleJuminModel;
    }

    /*
     * getseikyuFlg
     * @return seikyuFlg
     */
    @JsonProperty("seikyuFlg")
    public RString getSeikyuFlg() {
        return seikyuFlg;
    }

    /*
     * setseikyuFlg
     * @param seikyuFlg seikyuFlg
     */
    @JsonProperty("seikyuFlg")
    public void setSeikyuFlg(RString seikyuFlg) {
        this.seikyuFlg = seikyuFlg;
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
    // </editor-fold>
}
