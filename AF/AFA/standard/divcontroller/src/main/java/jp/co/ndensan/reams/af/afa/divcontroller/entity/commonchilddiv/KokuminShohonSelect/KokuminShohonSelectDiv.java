package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminShohonSelect;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
public class KokuminShohonSelectDiv extends Panel implements IKokuminShohonSelectDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKokuminShohon")
    private DataGrid<dgKokuminShohon_Row> dgKokuminShohon;
    @JsonProperty("hdnMasshoYMD")
    private RString hdnMasshoYMD;
    @JsonProperty("hdnShohonNo")
    private RString hdnShohonNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgKokuminShohon
     * @return dgKokuminShohon
     */
    @JsonProperty("dgKokuminShohon")
    public DataGrid<dgKokuminShohon_Row> getDgKokuminShohon() {
        return dgKokuminShohon;
    }

    /*
     * setdgKokuminShohon
     * @param dgKokuminShohon dgKokuminShohon
     */
    @JsonProperty("dgKokuminShohon")
    public void setDgKokuminShohon(DataGrid<dgKokuminShohon_Row> dgKokuminShohon) {
        this.dgKokuminShohon = dgKokuminShohon;
    }

    /*
     * gethdnMasshoYMD
     * @return hdnMasshoYMD
     */
    @JsonProperty("hdnMasshoYMD")
    public RString getHdnMasshoYMD() {
        return hdnMasshoYMD;
    }

    /*
     * sethdnMasshoYMD
     * @param hdnMasshoYMD hdnMasshoYMD
     */
    @JsonProperty("hdnMasshoYMD")
    public void setHdnMasshoYMD(RString hdnMasshoYMD) {
        this.hdnMasshoYMD = hdnMasshoYMD;
    }

    /*
     * gethdnShohonNo
     * @return hdnShohonNo
     */
    @JsonProperty("hdnShohonNo")
    public RString getHdnShohonNo() {
        return hdnShohonNo;
    }

    /*
     * sethdnShohonNo
     * @param hdnShohonNo hdnShohonNo
     */
    @JsonProperty("hdnShohonNo")
    public void setHdnShohonNo(RString hdnShohonNo) {
        this.hdnShohonNo = hdnShohonNo;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public boolean initialize() {
        return getHandler().initialize();
    }

    @JsonIgnore
    public KokuminShohonSelectHandler getHandler() {
        return new KokuminShohonSelectHandler(this);
    }
}
