package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2080;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * RyojikanSelect のクラスファイル 
 * 
 * @author 自動生成
 */
public class RyojikanSelectDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("dgRyojikanList")
    private DataGrid<dgRyojikanList_Row> dgRyojikanList;

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
     * getdgRyojikanList
     * @return dgRyojikanList
     */
    @JsonProperty("dgRyojikanList")
    public DataGrid<dgRyojikanList_Row> getDgRyojikanList() {
        return dgRyojikanList;
    }

    /*
     * setdgRyojikanList
     * @param dgRyojikanList dgRyojikanList
     */
    @JsonProperty("dgRyojikanList")
    public void setDgRyojikanList(DataGrid<dgRyojikanList_Row> dgRyojikanList) {
        this.dgRyojikanList = dgRyojikanList;
    }

    // </editor-fold>
}
