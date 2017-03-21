package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchSimpleTojitsuDialog;
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
 * SearchTojitsuKekkaList のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchTojitsuKekkaListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgSearchTojitsuKekkaList")
    private DataGrid<dgSearchTojitsuKekkaList_Row> dgSearchTojitsuKekkaList;
    @JsonProperty("btnCancel2")
    private Button btnCancel2;
    @JsonProperty("btnReSearch")
    private Button btnReSearch;
    @JsonProperty("txtHdnShikibetsuCode")
    private RString txtHdnShikibetsuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgSearchTojitsuKekkaList
     * @return dgSearchTojitsuKekkaList
     */
    @JsonProperty("dgSearchTojitsuKekkaList")
    public DataGrid<dgSearchTojitsuKekkaList_Row> getDgSearchTojitsuKekkaList() {
        return dgSearchTojitsuKekkaList;
    }

    /*
     * setdgSearchTojitsuKekkaList
     * @param dgSearchTojitsuKekkaList dgSearchTojitsuKekkaList
     */
    @JsonProperty("dgSearchTojitsuKekkaList")
    public void setDgSearchTojitsuKekkaList(DataGrid<dgSearchTojitsuKekkaList_Row> dgSearchTojitsuKekkaList) {
        this.dgSearchTojitsuKekkaList = dgSearchTojitsuKekkaList;
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

    // </editor-fold>
}
