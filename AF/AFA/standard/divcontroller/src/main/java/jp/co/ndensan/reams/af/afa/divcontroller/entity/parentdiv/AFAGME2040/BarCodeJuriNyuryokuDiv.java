package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2040;
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
 * BarCodeJuriNyuryoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class BarCodeJuriNyuryokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgBarCodeJuriTaishosha")
    private DataGrid<dgBarCodeJuriTaishosha_Row> dgBarCodeJuriTaishosha;
    @JsonProperty("BarCodeJuriJoho")
    private BarCodeJuriJohoDiv BarCodeJuriJoho;
    @JsonProperty("ccdJuriBarCode")
    private BarCodeNyuryokuDiv ccdJuriBarCode;
    @JsonProperty("ccdShohonNameList")
    private ShohonNameListDiv ccdShohonNameList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgBarCodeJuriTaishosha
     * @return dgBarCodeJuriTaishosha
     */
    @JsonProperty("dgBarCodeJuriTaishosha")
    public DataGrid<dgBarCodeJuriTaishosha_Row> getDgBarCodeJuriTaishosha() {
        return dgBarCodeJuriTaishosha;
    }

    /*
     * setdgBarCodeJuriTaishosha
     * @param dgBarCodeJuriTaishosha dgBarCodeJuriTaishosha
     */
    @JsonProperty("dgBarCodeJuriTaishosha")
    public void setDgBarCodeJuriTaishosha(DataGrid<dgBarCodeJuriTaishosha_Row> dgBarCodeJuriTaishosha) {
        this.dgBarCodeJuriTaishosha = dgBarCodeJuriTaishosha;
    }

    /*
     * getBarCodeJuriJoho
     * @return BarCodeJuriJoho
     */
    @JsonProperty("BarCodeJuriJoho")
    public BarCodeJuriJohoDiv getBarCodeJuriJoho() {
        return BarCodeJuriJoho;
    }

    /*
     * setBarCodeJuriJoho
     * @param BarCodeJuriJoho BarCodeJuriJoho
     */
    @JsonProperty("BarCodeJuriJoho")
    public void setBarCodeJuriJoho(BarCodeJuriJohoDiv BarCodeJuriJoho) {
        this.BarCodeJuriJoho = BarCodeJuriJoho;
    }

    /*
     * getccdJuriBarCode
     * @return ccdJuriBarCode
     */
    @JsonProperty("ccdJuriBarCode")
    public IBarCodeNyuryokuDiv getCcdJuriBarCode() {
        return ccdJuriBarCode;
    }

    /*
     * getccdShohonNameList
     * @return ccdShohonNameList
     */
    @JsonProperty("ccdShohonNameList")
    public IShohonNameListDiv getCcdShohonNameList() {
        return ccdShohonNameList;
    }

    // </editor-fold>
}
