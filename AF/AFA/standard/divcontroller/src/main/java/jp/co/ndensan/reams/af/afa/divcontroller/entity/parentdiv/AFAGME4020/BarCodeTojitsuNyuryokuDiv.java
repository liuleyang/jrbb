package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME4020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.BarCodeNyuryoku.BarCodeNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.BarCodeNyuryoku.IBarCodeNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * BarCodeTojitsuNyuryoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class BarCodeTojitsuNyuryokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblSenkyoRyakuName")
    private Label lblSenkyoRyakuName;
    @JsonProperty("dgBarCodeTojitsuTaishosha")
    private DataGrid<dgBarCodeTojitsuTaishosha_Row> dgBarCodeTojitsuTaishosha;
    @JsonProperty("ccdShohonNameList")
    private ShohonNameListDiv ccdShohonNameList;
    @JsonProperty("ccdNyujokenBarCode")
    private BarCodeNyuryokuDiv ccdNyujokenBarCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblSenkyoRyakuName
     * @return lblSenkyoRyakuName
     */
    @JsonProperty("lblSenkyoRyakuName")
    public Label getLblSenkyoRyakuName() {
        return lblSenkyoRyakuName;
    }

    /*
     * setlblSenkyoRyakuName
     * @param lblSenkyoRyakuName lblSenkyoRyakuName
     */
    @JsonProperty("lblSenkyoRyakuName")
    public void setLblSenkyoRyakuName(Label lblSenkyoRyakuName) {
        this.lblSenkyoRyakuName = lblSenkyoRyakuName;
    }

    /*
     * getdgBarCodeTojitsuTaishosha
     * @return dgBarCodeTojitsuTaishosha
     */
    @JsonProperty("dgBarCodeTojitsuTaishosha")
    public DataGrid<dgBarCodeTojitsuTaishosha_Row> getDgBarCodeTojitsuTaishosha() {
        return dgBarCodeTojitsuTaishosha;
    }

    /*
     * setdgBarCodeTojitsuTaishosha
     * @param dgBarCodeTojitsuTaishosha dgBarCodeTojitsuTaishosha
     */
    @JsonProperty("dgBarCodeTojitsuTaishosha")
    public void setDgBarCodeTojitsuTaishosha(DataGrid<dgBarCodeTojitsuTaishosha_Row> dgBarCodeTojitsuTaishosha) {
        this.dgBarCodeTojitsuTaishosha = dgBarCodeTojitsuTaishosha;
    }

    /*
     * getccdShohonNameList
     * @return ccdShohonNameList
     */
    @JsonProperty("ccdShohonNameList")
    public IShohonNameListDiv getCcdShohonNameList() {
        return ccdShohonNameList;
    }

    /*
     * getccdNyujokenBarCode
     * @return ccdNyujokenBarCode
     */
    @JsonProperty("ccdNyujokenBarCode")
    public IBarCodeNyuryokuDiv getCcdNyujokenBarCode() {
        return ccdNyujokenBarCode;
    }

    // </editor-fold>
}
