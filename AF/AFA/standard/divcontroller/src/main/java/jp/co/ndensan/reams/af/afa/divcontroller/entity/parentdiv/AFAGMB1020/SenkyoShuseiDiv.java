package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SenkyoShusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class SenkyoShuseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-02-19_14-33-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnSenkyoAdd")
    private Button btnSenkyoAdd;
    @JsonProperty("dgSenkyoShusei")
    private DataGrid<dgSenkyoShusei_Row> dgSenkyoShusei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnSenkyoAdd
     * @return btnSenkyoAdd
     */
    @JsonProperty("btnSenkyoAdd")
    public Button getBtnSenkyoAdd() {
        return btnSenkyoAdd;
    }

    /*
     * setbtnSenkyoAdd
     * @param btnSenkyoAdd btnSenkyoAdd
     */
    @JsonProperty("btnSenkyoAdd")
    public void setBtnSenkyoAdd(Button btnSenkyoAdd) {
        this.btnSenkyoAdd = btnSenkyoAdd;
    }

    /*
     * getdgSenkyoShusei
     * @return dgSenkyoShusei
     */
    @JsonProperty("dgSenkyoShusei")
    public DataGrid<dgSenkyoShusei_Row> getDgSenkyoShusei() {
        return dgSenkyoShusei;
    }

    /*
     * setdgSenkyoShusei
     * @param dgSenkyoShusei dgSenkyoShusei
     */
    @JsonProperty("dgSenkyoShusei")
    public void setDgSenkyoShusei(DataGrid<dgSenkyoShusei_Row> dgSenkyoShusei) {
        this.dgSenkyoShusei = dgSenkyoShusei;
    }

    // </editor-fold>
}
