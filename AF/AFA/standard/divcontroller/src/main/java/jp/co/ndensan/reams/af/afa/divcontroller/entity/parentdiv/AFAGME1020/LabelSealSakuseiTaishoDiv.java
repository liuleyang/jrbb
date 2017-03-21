package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME1020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.LabelSealPrintTaisho.ILabelSealPrintTaishoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.LabelSealPrintTaisho.LabelSealPrintTaishoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelect.IShisetsuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelect.ShisetsuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaSealPositionGuide.AtenaSealPositionGuideDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaSealPositionGuide.IAtenaSealPositionGuideDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * LabelSealSakuseiTaisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class LabelSealSakuseiTaishoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnShisetsuSearch")
    private Button btnShisetsuSearch;
    @JsonProperty("btnSearchSimple")
    private ButtonDialog btnSearchSimple;
    @JsonProperty("dgLabelSealRePrintTaishosha")
    private DataGrid<dgLabelSealRePrintTaishosha_Row> dgLabelSealRePrintTaishosha;
    @JsonProperty("ccdLabelSealPrintTaisho")
    private LabelSealPrintTaishoDiv ccdLabelSealPrintTaisho;
    @JsonProperty("ccdShohonNameList")
    private ShohonNameListDiv ccdShohonNameList;
    @JsonProperty("ccdShisetsuCode")
    private ShisetsuCodeSelectDiv ccdShisetsuCode;
    @JsonProperty("ccdSealPosition")
    private AtenaSealPositionGuideDiv ccdSealPosition;
    @JsonProperty("txtHdnSenkyoShurui")
    private RString txtHdnSenkyoShurui;
    @JsonProperty("txtHdnShohonNo")
    private RString txtHdnShohonNo;
    @JsonProperty("txtHdnShikibetsuCode")
    private RString txtHdnShikibetsuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnShisetsuSearch
     * @return btnShisetsuSearch
     */
    @JsonProperty("btnShisetsuSearch")
    public Button getBtnShisetsuSearch() {
        return btnShisetsuSearch;
    }

    /*
     * setbtnShisetsuSearch
     * @param btnShisetsuSearch btnShisetsuSearch
     */
    @JsonProperty("btnShisetsuSearch")
    public void setBtnShisetsuSearch(Button btnShisetsuSearch) {
        this.btnShisetsuSearch = btnShisetsuSearch;
    }

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
     * getdgLabelSealRePrintTaishosha
     * @return dgLabelSealRePrintTaishosha
     */
    @JsonProperty("dgLabelSealRePrintTaishosha")
    public DataGrid<dgLabelSealRePrintTaishosha_Row> getDgLabelSealRePrintTaishosha() {
        return dgLabelSealRePrintTaishosha;
    }

    /*
     * setdgLabelSealRePrintTaishosha
     * @param dgLabelSealRePrintTaishosha dgLabelSealRePrintTaishosha
     */
    @JsonProperty("dgLabelSealRePrintTaishosha")
    public void setDgLabelSealRePrintTaishosha(DataGrid<dgLabelSealRePrintTaishosha_Row> dgLabelSealRePrintTaishosha) {
        this.dgLabelSealRePrintTaishosha = dgLabelSealRePrintTaishosha;
    }

    /*
     * getccdLabelSealPrintTaisho
     * @return ccdLabelSealPrintTaisho
     */
    @JsonProperty("ccdLabelSealPrintTaisho")
    public ILabelSealPrintTaishoDiv getCcdLabelSealPrintTaisho() {
        return ccdLabelSealPrintTaisho;
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
     * getccdShisetsuCode
     * @return ccdShisetsuCode
     */
    @JsonProperty("ccdShisetsuCode")
    public IShisetsuCodeSelectDiv getCcdShisetsuCode() {
        return ccdShisetsuCode;
    }

    /*
     * getccdSealPosition
     * @return ccdSealPosition
     */
    @JsonProperty("ccdSealPosition")
    public IAtenaSealPositionGuideDiv getCcdSealPosition() {
        return ccdSealPosition;
    }

    /*
     * gettxtHdnSenkyoShurui
     * @return txtHdnSenkyoShurui
     */
    @JsonProperty("txtHdnSenkyoShurui")
    public RString getTxtHdnSenkyoShurui() {
        return txtHdnSenkyoShurui;
    }

    /*
     * settxtHdnSenkyoShurui
     * @param txtHdnSenkyoShurui txtHdnSenkyoShurui
     */
    @JsonProperty("txtHdnSenkyoShurui")
    public void setTxtHdnSenkyoShurui(RString txtHdnSenkyoShurui) {
        this.txtHdnSenkyoShurui = txtHdnSenkyoShurui;
    }

    /*
     * gettxtHdnShohonNo
     * @return txtHdnShohonNo
     */
    @JsonProperty("txtHdnShohonNo")
    public RString getTxtHdnShohonNo() {
        return txtHdnShohonNo;
    }

    /*
     * settxtHdnShohonNo
     * @param txtHdnShohonNo txtHdnShohonNo
     */
    @JsonProperty("txtHdnShohonNo")
    public void setTxtHdnShohonNo(RString txtHdnShohonNo) {
        this.txtHdnShohonNo = txtHdnShohonNo;
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
