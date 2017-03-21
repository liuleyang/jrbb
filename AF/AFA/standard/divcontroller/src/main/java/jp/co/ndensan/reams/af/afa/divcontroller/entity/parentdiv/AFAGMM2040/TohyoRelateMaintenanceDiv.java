package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2040;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyoShuruiSelect.ISenkyoShuruiSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyoShuruiSelect.SenkyoShuruiSelectDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TohyoRelateMaintenance のクラスファイル 
 * 
 * @author 自動生成
 */
public class TohyoRelateMaintenanceDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TohyoRelateSelect")
    private TohyoRelateSelectDiv TohyoRelateSelect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTohyoRelateSelect
     * @return TohyoRelateSelect
     */
    @JsonProperty("TohyoRelateSelect")
    public TohyoRelateSelectDiv getTohyoRelateSelect() {
        return TohyoRelateSelect;
    }

    /*
     * setTohyoRelateSelect
     * @param TohyoRelateSelect TohyoRelateSelect
     */
    @JsonProperty("TohyoRelateSelect")
    public void setTohyoRelateSelect(TohyoRelateSelectDiv TohyoRelateSelect) {
        this.TohyoRelateSelect = TohyoRelateSelect;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblTohyokuList() {
        return this.getTohyoRelateSelect().getLblTohyokuList();
    }

    @JsonIgnore
    public void  setLblTohyokuList(Label lblTohyokuList) {
        this.getTohyoRelateSelect().setLblTohyokuList(lblTohyokuList);
    }

    @JsonIgnore
    public DataGrid<dgTohyoRelateList_Row> getDgTohyoRelateList() {
        return this.getTohyoRelateSelect().getDgTohyoRelateList();
    }

    @JsonIgnore
    public void  setDgTohyoRelateList(DataGrid<dgTohyoRelateList_Row> dgTohyoRelateList) {
        this.getTohyoRelateSelect().setDgTohyoRelateList(dgTohyoRelateList);
    }

    @JsonIgnore
    public ISenkyoShuruiSelectDiv getCcdSenkyoShurui() {
        return this.getTohyoRelateSelect().getCcdSenkyoShurui();
    }

    // </editor-fold>
}
