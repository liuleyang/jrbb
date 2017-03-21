package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchSimpleJuminDialog;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SearchSimpleJuminDialog のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchSimpleJuminDialogDiv extends Panel implements ISearchSimpleJuminDialogDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-24_20-09-47">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SearchSimpleJoken")
    private SearchSimpleJokenDiv SearchSimpleJoken;
    @JsonProperty("SearchSimpleKekkaList")
    private SearchSimpleKekkaListDiv SearchSimpleKekkaList;
    @JsonProperty("txtHdnSenkyoShurui")
    private RString txtHdnSenkyoShurui;
    @JsonProperty("txtHdnNumber")
    private RString txtHdnNumber;
    @JsonProperty("txtHdnMaxCount")
    private RString txtHdnMaxCount;
    @JsonProperty("txtHdnShohonNo")
    private RString txtHdnShohonNo;
    @JsonProperty("txtHdnMaxKijunYMD")
    private RString txtHdnMaxKijunYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSearchSimpleJoken
     * @return SearchSimpleJoken
     */
    @JsonProperty("SearchSimpleJoken")
    public SearchSimpleJokenDiv getSearchSimpleJoken() {
        return SearchSimpleJoken;
    }

    /*
     * setSearchSimpleJoken
     * @param SearchSimpleJoken SearchSimpleJoken
     */
    @JsonProperty("SearchSimpleJoken")
    public void setSearchSimpleJoken(SearchSimpleJokenDiv SearchSimpleJoken) {
        this.SearchSimpleJoken = SearchSimpleJoken;
    }

    /*
     * getSearchSimpleKekkaList
     * @return SearchSimpleKekkaList
     */
    @JsonProperty("SearchSimpleKekkaList")
    public SearchSimpleKekkaListDiv getSearchSimpleKekkaList() {
        return SearchSimpleKekkaList;
    }

    /*
     * setSearchSimpleKekkaList
     * @param SearchSimpleKekkaList SearchSimpleKekkaList
     */
    @JsonProperty("SearchSimpleKekkaList")
    public void setSearchSimpleKekkaList(SearchSimpleKekkaListDiv SearchSimpleKekkaList) {
        this.SearchSimpleKekkaList = SearchSimpleKekkaList;
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

    /*
     * gettxtHdnMaxCount
     * @return txtHdnMaxCount
     */
    @JsonProperty("txtHdnMaxCount")
    public RString getTxtHdnMaxCount() {
        return txtHdnMaxCount;
    }

    /*
     * settxtHdnMaxCount
     * @param txtHdnMaxCount txtHdnMaxCount
     */
    @JsonProperty("txtHdnMaxCount")
    public void setTxtHdnMaxCount(RString txtHdnMaxCount) {
        this.txtHdnMaxCount = txtHdnMaxCount;
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
     * gettxtHdnMaxKijunYMD
     * @return txtHdnMaxKijunYMD
     */
    @JsonProperty("txtHdnMaxKijunYMD")
    public RString getTxtHdnMaxKijunYMD() {
        return txtHdnMaxKijunYMD;
    }

    /*
     * settxtHdnMaxKijunYMD
     * @param txtHdnMaxKijunYMD txtHdnMaxKijunYMD
     */
    @JsonProperty("txtHdnMaxKijunYMD")
    public void setTxtHdnMaxKijunYMD(RString txtHdnMaxKijunYMD) {
        this.txtHdnMaxKijunYMD = txtHdnMaxKijunYMD;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
