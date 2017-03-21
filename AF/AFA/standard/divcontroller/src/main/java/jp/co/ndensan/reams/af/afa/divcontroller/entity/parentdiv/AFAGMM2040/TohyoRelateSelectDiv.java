package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2040;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyoShuruiSelect.ISenkyoShuruiSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyoShuruiSelect.SenkyoShuruiSelectDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TohyoRelateSelect のクラスファイル 
 * 
 * @author 自動生成
 */
public class TohyoRelateSelectDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblTohyokuList")
    private Label lblTohyokuList;
    @JsonProperty("dgTohyoRelateList")
    private DataGrid<dgTohyoRelateList_Row> dgTohyoRelateList;
    @JsonProperty("ccdSenkyoShurui")
    private SenkyoShuruiSelectDiv ccdSenkyoShurui;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblTohyokuList
     * @return lblTohyokuList
     */
    @JsonProperty("lblTohyokuList")
    public Label getLblTohyokuList() {
        return lblTohyokuList;
    }

    /*
     * setlblTohyokuList
     * @param lblTohyokuList lblTohyokuList
     */
    @JsonProperty("lblTohyokuList")
    public void setLblTohyokuList(Label lblTohyokuList) {
        this.lblTohyokuList = lblTohyokuList;
    }

    /*
     * getdgTohyoRelateList
     * @return dgTohyoRelateList
     */
    @JsonProperty("dgTohyoRelateList")
    public DataGrid<dgTohyoRelateList_Row> getDgTohyoRelateList() {
        return dgTohyoRelateList;
    }

    /*
     * setdgTohyoRelateList
     * @param dgTohyoRelateList dgTohyoRelateList
     */
    @JsonProperty("dgTohyoRelateList")
    public void setDgTohyoRelateList(DataGrid<dgTohyoRelateList_Row> dgTohyoRelateList) {
        this.dgTohyoRelateList = dgTohyoRelateList;
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
