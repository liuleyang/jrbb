package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM1030;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PrintSortTaishoChohyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class PrintSortTaishoChohyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgPrintSortTaishoChohyo")
    private DataGrid<dgPrintSortTaishoChohyo_Row> dgPrintSortTaishoChohyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgPrintSortTaishoChohyo
     * @return dgPrintSortTaishoChohyo
     */
    @JsonProperty("dgPrintSortTaishoChohyo")
    public DataGrid<dgPrintSortTaishoChohyo_Row> getDgPrintSortTaishoChohyo() {
        return dgPrintSortTaishoChohyo;
    }

    /*
     * setdgPrintSortTaishoChohyo
     * @param dgPrintSortTaishoChohyo dgPrintSortTaishoChohyo
     */
    @JsonProperty("dgPrintSortTaishoChohyo")
    public void setDgPrintSortTaishoChohyo(DataGrid<dgPrintSortTaishoChohyo_Row> dgPrintSortTaishoChohyo) {
        this.dgPrintSortTaishoChohyo = dgPrintSortTaishoChohyo;
    }

    // </editor-fold>
}
