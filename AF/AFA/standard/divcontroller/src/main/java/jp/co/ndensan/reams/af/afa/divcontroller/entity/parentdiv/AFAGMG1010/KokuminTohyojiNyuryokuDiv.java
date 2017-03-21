package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KokuminTohyojiNyuryoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class KokuminTohyojiNyuryokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("chkSimulationData")
    private CheckBoxList chkSimulationData;
    @JsonProperty("dgKokuminTohyojiNyuryoku")
    private DataGrid<dgKokuminTohyojiNyuryoku_Row> dgKokuminTohyojiNyuryoku;

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
     * getchkSimulationData
     * @return chkSimulationData
     */
    @JsonProperty("chkSimulationData")
    public CheckBoxList getChkSimulationData() {
        return chkSimulationData;
    }

    /*
     * setchkSimulationData
     * @param chkSimulationData chkSimulationData
     */
    @JsonProperty("chkSimulationData")
    public void setChkSimulationData(CheckBoxList chkSimulationData) {
        this.chkSimulationData = chkSimulationData;
    }

    /*
     * getdgKokuminTohyojiNyuryoku
     * @return dgKokuminTohyojiNyuryoku
     */
    @JsonProperty("dgKokuminTohyojiNyuryoku")
    public DataGrid<dgKokuminTohyojiNyuryoku_Row> getDgKokuminTohyojiNyuryoku() {
        return dgKokuminTohyojiNyuryoku;
    }

    /*
     * setdgKokuminTohyojiNyuryoku
     * @param dgKokuminTohyojiNyuryoku dgKokuminTohyojiNyuryoku
     */
    @JsonProperty("dgKokuminTohyojiNyuryoku")
    public void setDgKokuminTohyojiNyuryoku(DataGrid<dgKokuminTohyojiNyuryoku_Row> dgKokuminTohyojiNyuryoku) {
        this.dgKokuminTohyojiNyuryoku = dgKokuminTohyojiNyuryoku;
    }

    // </editor-fold>
}
