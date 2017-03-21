package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboSakuseiKijun;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
public class SenkyoNyuryokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAddRowSenkyo")
    private Button btnAddRowSenkyo;
    @JsonProperty("btnCopySenkyo")
    private Button btnCopySenkyo;
    @JsonProperty("chkKenshuDataCreate")
    private CheckBoxList chkKenshuDataCreate;
    @JsonProperty("dgSenkyojiSenkyoNyuryoku")
    private DataGrid<dgSenkyojiSenkyoNyuryoku_Row> dgSenkyojiSenkyoNyuryoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnAddRowSenkyo
     * @return btnAddRowSenkyo
     */
    @JsonProperty("btnAddRowSenkyo")
    public Button getBtnAddRowSenkyo() {
        return btnAddRowSenkyo;
    }

    /*
     * setbtnAddRowSenkyo
     * @param btnAddRowSenkyo btnAddRowSenkyo
     */
    @JsonProperty("btnAddRowSenkyo")
    public void setBtnAddRowSenkyo(Button btnAddRowSenkyo) {
        this.btnAddRowSenkyo = btnAddRowSenkyo;
    }

    /*
     * getbtnCopySenkyo
     * @return btnCopySenkyo
     */
    @JsonProperty("btnCopySenkyo")
    public Button getBtnCopySenkyo() {
        return btnCopySenkyo;
    }

    /*
     * setbtnCopySenkyo
     * @param btnCopySenkyo btnCopySenkyo
     */
    @JsonProperty("btnCopySenkyo")
    public void setBtnCopySenkyo(Button btnCopySenkyo) {
        this.btnCopySenkyo = btnCopySenkyo;
    }

    /*
     * getchkKenshuDataCreate
     * @return chkKenshuDataCreate
     */
    @JsonProperty("chkKenshuDataCreate")
    public CheckBoxList getChkKenshuDataCreate() {
        return chkKenshuDataCreate;
    }

    /*
     * setchkKenshuDataCreate
     * @param chkKenshuDataCreate chkKenshuDataCreate
     */
    @JsonProperty("chkKenshuDataCreate")
    public void setChkKenshuDataCreate(CheckBoxList chkKenshuDataCreate) {
        this.chkKenshuDataCreate = chkKenshuDataCreate;
    }

    /*
     * getdgSenkyojiSenkyoNyuryoku
     * @return dgSenkyojiSenkyoNyuryoku
     */
    @JsonProperty("dgSenkyojiSenkyoNyuryoku")
    public DataGrid<dgSenkyojiSenkyoNyuryoku_Row> getDgSenkyojiSenkyoNyuryoku() {
        return dgSenkyojiSenkyoNyuryoku;
    }

    /*
     * setdgSenkyojiSenkyoNyuryoku
     * @param dgSenkyojiSenkyoNyuryoku dgSenkyojiSenkyoNyuryoku
     */
    @JsonProperty("dgSenkyojiSenkyoNyuryoku")
    public void setDgSenkyojiSenkyoNyuryoku(DataGrid<dgSenkyojiSenkyoNyuryoku_Row> dgSenkyojiSenkyoNyuryoku) {
        this.dgSenkyojiSenkyoNyuryoku = dgSenkyojiSenkyoNyuryoku;
    }

    // </editor-fold>
}
