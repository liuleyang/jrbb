package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2050;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShisetsuSelect のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShisetsuSelectDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("dgShisetsuList")
    private DataGrid<dgShisetsuList_Row> dgShisetsuList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnAdd
     * @return btnAdd
     */
    @JsonProperty("btnAdd")
    public Button getBtnAdd() {
        return btnAdd;
    }

    /*
     * setbtnAdd
     * @param btnAdd btnAdd
     */
    @JsonProperty("btnAdd")
    public void setBtnAdd(Button btnAdd) {
        this.btnAdd = btnAdd;
    }

    /*
     * getdgShisetsuList
     * @return dgShisetsuList
     */
    @JsonProperty("dgShisetsuList")
    public DataGrid<dgShisetsuList_Row> getDgShisetsuList() {
        return dgShisetsuList;
    }

    /*
     * setdgShisetsuList
     * @param dgShisetsuList dgShisetsuList
     */
    @JsonProperty("dgShisetsuList")
    public void setDgShisetsuList(DataGrid<dgShisetsuList_Row> dgShisetsuList) {
        this.dgShisetsuList = dgShisetsuList;
    }

    // </editor-fold>
}
