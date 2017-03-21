package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM1030;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujunList.ChohyoShutsuryokujunListDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujunList.IChohyoShutsuryokujunListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PrintSort のクラスファイル 
 * 
 * @author 自動生成
 */
public class PrintSortDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("PrintSortTaishoChohyo")
    private PrintSortTaishoChohyoDiv PrintSortTaishoChohyo;
    @JsonProperty("ccdPrintSort")
    private ChohyoShutsuryokujunListDiv ccdPrintSort;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getPrintSortTaishoChohyo
     * @return PrintSortTaishoChohyo
     */
    @JsonProperty("PrintSortTaishoChohyo")
    public PrintSortTaishoChohyoDiv getPrintSortTaishoChohyo() {
        return PrintSortTaishoChohyo;
    }

    /*
     * setPrintSortTaishoChohyo
     * @param PrintSortTaishoChohyo PrintSortTaishoChohyo
     */
    @JsonProperty("PrintSortTaishoChohyo")
    public void setPrintSortTaishoChohyo(PrintSortTaishoChohyoDiv PrintSortTaishoChohyo) {
        this.PrintSortTaishoChohyo = PrintSortTaishoChohyo;
    }

    /*
     * getccdPrintSort
     * @return ccdPrintSort
     */
    @JsonProperty("ccdPrintSort")
    public IChohyoShutsuryokujunListDiv getCcdPrintSort() {
        return ccdPrintSort;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgPrintSortTaishoChohyo_Row> getDgPrintSortTaishoChohyo() {
        return this.getPrintSortTaishoChohyo().getDgPrintSortTaishoChohyo();
    }

    @JsonIgnore
    public void  setDgPrintSortTaishoChohyo(DataGrid<dgPrintSortTaishoChohyo_Row> dgPrintSortTaishoChohyo) {
        this.getPrintSortTaishoChohyo().setDgPrintSortTaishoChohyo(dgPrintSortTaishoChohyo);
    }

    // </editor-fold>
}
