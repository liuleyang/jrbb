package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1000;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyoShuruiSelect.ISenkyoShuruiSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyoShuruiSelect.SenkyoShuruiSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SearchJumin のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchJuminDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SearchJoken")
    private SearchJokenDiv SearchJoken;
    @JsonProperty("SearchKekkaList")
    private SearchKekkaListDiv SearchKekkaList;
    @JsonProperty("ccdShohonNameList")
    private ShohonNameListDiv ccdShohonNameList;
    @JsonProperty("ccdSenkyoShurui")
    private SenkyoShuruiSelectDiv ccdSenkyoShurui;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSearchJoken
     * @return SearchJoken
     */
    @JsonProperty("SearchJoken")
    public SearchJokenDiv getSearchJoken() {
        return SearchJoken;
    }

    /*
     * setSearchJoken
     * @param SearchJoken SearchJoken
     */
    @JsonProperty("SearchJoken")
    public void setSearchJoken(SearchJokenDiv SearchJoken) {
        this.SearchJoken = SearchJoken;
    }

    /*
     * getSearchKekkaList
     * @return SearchKekkaList
     */
    @JsonProperty("SearchKekkaList")
    public SearchKekkaListDiv getSearchKekkaList() {
        return SearchKekkaList;
    }

    /*
     * setSearchKekkaList
     * @param SearchKekkaList SearchKekkaList
     */
    @JsonProperty("SearchKekkaList")
    public void setSearchKekkaList(SearchKekkaListDiv SearchKekkaList) {
        this.SearchKekkaList = SearchKekkaList;
    }

    /*
     * getccdShohonNameList
     * @return ccdShohonNameList
     */
    @JsonProperty("ccdShohonNameList")
    public IShohonNameListDiv getCcdShohonNameList() {
        return ccdShohonNameList;
    }

    /*
     * getccdSenkyoShurui
     * @return ccdSenkyoShurui
     */
    @JsonProperty("ccdSenkyoShurui")
    public ISenkyoShuruiSelectDiv getCcdSenkyoShurui() {
        return ccdSenkyoShurui;
    }

    // </editor-fold>
}
