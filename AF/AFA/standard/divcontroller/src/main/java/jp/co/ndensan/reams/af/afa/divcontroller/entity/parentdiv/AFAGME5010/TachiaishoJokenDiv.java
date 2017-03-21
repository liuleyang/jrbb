package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TachiaishoJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class TachiaishoJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTohyoYMDJoken")
    private TextBoxDate txtTohyoYMDJoken;
    @JsonProperty("ddlSenkyoName")
    private DropDownList ddlSenkyoName;
    @JsonProperty("ddlShisetsu")
    private DropDownList ddlShisetsu;
    @JsonProperty("btnSearch")
    private Button btnSearch;
    @JsonProperty("ccdShohonNameList")
    private ShohonNameListDiv ccdShohonNameList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTohyoYMDJoken
     * @return txtTohyoYMDJoken
     */
    @JsonProperty("txtTohyoYMDJoken")
    public TextBoxDate getTxtTohyoYMDJoken() {
        return txtTohyoYMDJoken;
    }

    /*
     * settxtTohyoYMDJoken
     * @param txtTohyoYMDJoken txtTohyoYMDJoken
     */
    @JsonProperty("txtTohyoYMDJoken")
    public void setTxtTohyoYMDJoken(TextBoxDate txtTohyoYMDJoken) {
        this.txtTohyoYMDJoken = txtTohyoYMDJoken;
    }

    /*
     * getddlSenkyoName
     * @return ddlSenkyoName
     */
    @JsonProperty("ddlSenkyoName")
    public DropDownList getDdlSenkyoName() {
        return ddlSenkyoName;
    }

    /*
     * setddlSenkyoName
     * @param ddlSenkyoName ddlSenkyoName
     */
    @JsonProperty("ddlSenkyoName")
    public void setDdlSenkyoName(DropDownList ddlSenkyoName) {
        this.ddlSenkyoName = ddlSenkyoName;
    }

    /*
     * getddlShisetsu
     * @return ddlShisetsu
     */
    @JsonProperty("ddlShisetsu")
    public DropDownList getDdlShisetsu() {
        return ddlShisetsu;
    }

    /*
     * setddlShisetsu
     * @param ddlShisetsu ddlShisetsu
     */
    @JsonProperty("ddlShisetsu")
    public void setDdlShisetsu(DropDownList ddlShisetsu) {
        this.ddlShisetsu = ddlShisetsu;
    }

    /*
     * getbtnSearch
     * @return btnSearch
     */
    @JsonProperty("btnSearch")
    public Button getBtnSearch() {
        return btnSearch;
    }

    /*
     * setbtnSearch
     * @param btnSearch btnSearch
     */
    @JsonProperty("btnSearch")
    public void setBtnSearch(Button btnSearch) {
        this.btnSearch = btnSearch;
    }

    /*
     * getccdShohonNameList
     * @return ccdShohonNameList
     */
    @JsonProperty("ccdShohonNameList")
    public IShohonNameListDiv getCcdShohonNameList() {
        return ccdShohonNameList;
    }

    // </editor-fold>
}
