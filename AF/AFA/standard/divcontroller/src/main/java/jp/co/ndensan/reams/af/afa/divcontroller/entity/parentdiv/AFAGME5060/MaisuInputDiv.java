package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5060;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * MaisuInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class MaisuInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgMaisuInput")
    private DataGrid<dgMaisuInput_Row> dgMaisuInput;
    @JsonProperty("btnUpdate")
    private Button btnUpdate;
    @JsonProperty("btnStop")
    private Button btnStop;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgMaisuInput
     * @return dgMaisuInput
     */
    @JsonProperty("dgMaisuInput")
    public DataGrid<dgMaisuInput_Row> getDgMaisuInput() {
        return dgMaisuInput;
    }

    /*
     * setdgMaisuInput
     * @param dgMaisuInput dgMaisuInput
     */
    @JsonProperty("dgMaisuInput")
    public void setDgMaisuInput(DataGrid<dgMaisuInput_Row> dgMaisuInput) {
        this.dgMaisuInput = dgMaisuInput;
    }

    /*
     * getbtnUpdate
     * @return btnUpdate
     */
    @JsonProperty("btnUpdate")
    public Button getBtnUpdate() {
        return btnUpdate;
    }

    /*
     * setbtnUpdate
     * @param btnUpdate btnUpdate
     */
    @JsonProperty("btnUpdate")
    public void setBtnUpdate(Button btnUpdate) {
        this.btnUpdate = btnUpdate;
    }

    /*
     * getbtnStop
     * @return btnStop
     */
    @JsonProperty("btnStop")
    public Button getBtnStop() {
        return btnStop;
    }

    /*
     * setbtnStop
     * @param btnStop btnStop
     */
    @JsonProperty("btnStop")
    public void setBtnStop(Button btnStop) {
        this.btnStop = btnStop;
    }

    // </editor-fold>
}
