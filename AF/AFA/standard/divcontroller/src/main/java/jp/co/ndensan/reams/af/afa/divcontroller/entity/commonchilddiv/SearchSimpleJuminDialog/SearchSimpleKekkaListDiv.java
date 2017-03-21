package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchSimpleJuminDialog;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SearchSimpleKekkaList のクラスファイル
 *
 * @author 自動生成
 */
public class SearchSimpleKekkaListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-24_20-09-47">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgSearchSimpleKekkaList")
    private DataGrid<dgSearchSimpleKekkaList_Row> dgSearchSimpleKekkaList;
    @JsonProperty("btnSelect")
    private Button btnSelect;
    @JsonProperty("btnReSearch")
    private Button btnReSearch;
    @JsonProperty("btnCancel2")
    private Button btnCancel2;
    @JsonProperty("txtHdnShikibetsuCode")
    private RString txtHdnShikibetsuCode;
    @JsonProperty("SearchSimpleJuminModel")
    private RString SearchSimpleJuminModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgSearchSimpleKekkaList
     * @return dgSearchSimpleKekkaList
     */
    @JsonProperty("dgSearchSimpleKekkaList")
    public DataGrid<dgSearchSimpleKekkaList_Row> getDgSearchSimpleKekkaList() {
        return dgSearchSimpleKekkaList;
    }

    /*
     * setdgSearchSimpleKekkaList
     * @param dgSearchSimpleKekkaList dgSearchSimpleKekkaList
     */
    @JsonProperty("dgSearchSimpleKekkaList")
    public void setDgSearchSimpleKekkaList(DataGrid<dgSearchSimpleKekkaList_Row> dgSearchSimpleKekkaList) {
        this.dgSearchSimpleKekkaList = dgSearchSimpleKekkaList;
    }

    /*
     * getbtnSelect
     * @return btnSelect
     */
    @JsonProperty("btnSelect")
    public Button getBtnSelect() {
        return btnSelect;
    }

    /*
     * setbtnSelect
     * @param btnSelect btnSelect
     */
    @JsonProperty("btnSelect")
    public void setBtnSelect(Button btnSelect) {
        this.btnSelect = btnSelect;
    }

    /*
     * getbtnReSearch
     * @return btnReSearch
     */
    @JsonProperty("btnReSearch")
    public Button getBtnReSearch() {
        return btnReSearch;
    }

    /*
     * setbtnReSearch
     * @param btnReSearch btnReSearch
     */
    @JsonProperty("btnReSearch")
    public void setBtnReSearch(Button btnReSearch) {
        this.btnReSearch = btnReSearch;
    }

    /*
     * getbtnCancel2
     * @return btnCancel2
     */
    @JsonProperty("btnCancel2")
    public Button getBtnCancel2() {
        return btnCancel2;
    }

    /*
     * setbtnCancel2
     * @param btnCancel2 btnCancel2
     */
    @JsonProperty("btnCancel2")
    public void setBtnCancel2(Button btnCancel2) {
        this.btnCancel2 = btnCancel2;
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

    // </editor-fold>
}
