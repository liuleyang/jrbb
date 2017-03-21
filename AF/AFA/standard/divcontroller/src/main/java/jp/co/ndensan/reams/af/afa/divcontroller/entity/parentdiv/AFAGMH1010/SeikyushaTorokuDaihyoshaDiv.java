package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SeikyushaTorokuDaihyosha のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeikyushaTorokuDaihyoshaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnSearchSimple")
    private ButtonDialog btnSearchSimple;
    @JsonProperty("dgSeikyushaTorokuDaihyoshaIchiran")
    private DataGrid<dgSeikyushaTorokuDaihyoshaIchiran_Row> dgSeikyushaTorokuDaihyoshaIchiran;
    @JsonProperty("txtHdnShikibetsuCode")
    private RString txtHdnShikibetsuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnSearchSimple
     * @return btnSearchSimple
     */
    @JsonProperty("btnSearchSimple")
    public ButtonDialog getBtnSearchSimple() {
        return btnSearchSimple;
    }

    /*
     * setbtnSearchSimple
     * @param btnSearchSimple btnSearchSimple
     */
    @JsonProperty("btnSearchSimple")
    public void setBtnSearchSimple(ButtonDialog btnSearchSimple) {
        this.btnSearchSimple = btnSearchSimple;
    }

    /*
     * getdgSeikyushaTorokuDaihyoshaIchiran
     * @return dgSeikyushaTorokuDaihyoshaIchiran
     */
    @JsonProperty("dgSeikyushaTorokuDaihyoshaIchiran")
    public DataGrid<dgSeikyushaTorokuDaihyoshaIchiran_Row> getDgSeikyushaTorokuDaihyoshaIchiran() {
        return dgSeikyushaTorokuDaihyoshaIchiran;
    }

    /*
     * setdgSeikyushaTorokuDaihyoshaIchiran
     * @param dgSeikyushaTorokuDaihyoshaIchiran dgSeikyushaTorokuDaihyoshaIchiran
     */
    @JsonProperty("dgSeikyushaTorokuDaihyoshaIchiran")
    public void setDgSeikyushaTorokuDaihyoshaIchiran(DataGrid<dgSeikyushaTorokuDaihyoshaIchiran_Row> dgSeikyushaTorokuDaihyoshaIchiran) {
        this.dgSeikyushaTorokuDaihyoshaIchiran = dgSeikyushaTorokuDaihyoshaIchiran;
    }

    /*
     * gettxtHdnShikibetsuCode
     * @return txtHdnShikibetsuCode
     */
    @JsonProperty("txtHdnShikibetsuCode")
    public RString getTxtHdnShikibetsuCode() {
        return txtHdnShikibetsuCode;
    }

    /*
     * settxtHdnShikibetsuCode
     * @param txtHdnShikibetsuCode txtHdnShikibetsuCode
     */
    @JsonProperty("txtHdnShikibetsuCode")
    public void setTxtHdnShikibetsuCode(RString txtHdnShikibetsuCode) {
        this.txtHdnShikibetsuCode = txtHdnShikibetsuCode;
    }

    // </editor-fold>
}
