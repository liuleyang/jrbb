package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchSimpleTojitsuDialog;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboBango.IMeiboBangoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboBango.MeiboBangoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.ITohyokuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.TohyokuCodeSelectDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.SaikinShorishaRireki.ISaikinShorishaRirekiDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.SaikinShorishaRireki.SaikinShorishaRirekiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SearchTojitsuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchTojitsuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdShohon")
    private ShohonNameListDiv ccdShohon;
    @JsonProperty("lin3")
    private HorizontalLine lin3;
    @JsonProperty("txtMeisho")
    private TextBox txtMeisho;
    @JsonProperty("ddlMeishoKensaku")
    private DropDownList ddlMeishoKensaku;
    @JsonProperty("txtSeinengappi")
    private TextBoxFlexibleDate txtSeinengappi;
    @JsonProperty("txtSeibetsu")
    private DropDownList txtSeibetsu;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("ccdTohyokuCode")
    private TohyokuCodeSelectDiv ccdTohyokuCode;
    @JsonProperty("ccdMeiboBango")
    private MeiboBangoDiv ccdMeiboBango;
    @JsonProperty("lin2")
    private HorizontalLine lin2;
    @JsonProperty("txtMaxDisplayCount")
    private TextBoxNum txtMaxDisplayCount;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("btnSearch")
    private Button btnSearch;
    @JsonProperty("ccdSearchTojitsuSaikinShoriTaisho")
    private SaikinShorishaRirekiDiv ccdSearchTojitsuSaikinShoriTaisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdShohon
     * @return ccdShohon
     */
    @JsonProperty("ccdShohon")
    public IShohonNameListDiv getCcdShohon() {
        return ccdShohon;
    }

    /*
     * getlin3
     * @return lin3
     */
    @JsonProperty("lin3")
    public HorizontalLine getLin3() {
        return lin3;
    }

    /*
     * setlin3
     * @param lin3 lin3
     */
    @JsonProperty("lin3")
    public void setLin3(HorizontalLine lin3) {
        this.lin3 = lin3;
    }

    /*
     * gettxtMeisho
     * @return txtMeisho
     */
    @JsonProperty("txtMeisho")
    public TextBox getTxtMeisho() {
        return txtMeisho;
    }

    /*
     * settxtMeisho
     * @param txtMeisho txtMeisho
     */
    @JsonProperty("txtMeisho")
    public void setTxtMeisho(TextBox txtMeisho) {
        this.txtMeisho = txtMeisho;
    }

    /*
     * getddlMeishoKensaku
     * @return ddlMeishoKensaku
     */
    @JsonProperty("ddlMeishoKensaku")
    public DropDownList getDdlMeishoKensaku() {
        return ddlMeishoKensaku;
    }

    /*
     * setddlMeishoKensaku
     * @param ddlMeishoKensaku ddlMeishoKensaku
     */
    @JsonProperty("ddlMeishoKensaku")
    public void setDdlMeishoKensaku(DropDownList ddlMeishoKensaku) {
        this.ddlMeishoKensaku = ddlMeishoKensaku;
    }

    /*
     * gettxtSeinengappi
     * @return txtSeinengappi
     */
    @JsonProperty("txtSeinengappi")
    public TextBoxFlexibleDate getTxtSeinengappi() {
        return txtSeinengappi;
    }

    /*
     * settxtSeinengappi
     * @param txtSeinengappi txtSeinengappi
     */
    @JsonProperty("txtSeinengappi")
    public void setTxtSeinengappi(TextBoxFlexibleDate txtSeinengappi) {
        this.txtSeinengappi = txtSeinengappi;
    }

    /*
     * gettxtSeibetsu
     * @return txtSeibetsu
     */
    @JsonProperty("txtSeibetsu")
    public DropDownList getTxtSeibetsu() {
        return txtSeibetsu;
    }

    /*
     * settxtSeibetsu
     * @param txtSeibetsu txtSeibetsu
     */
    @JsonProperty("txtSeibetsu")
    public void setTxtSeibetsu(DropDownList txtSeibetsu) {
        this.txtSeibetsu = txtSeibetsu;
    }

    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * getccdTohyokuCode
     * @return ccdTohyokuCode
     */
    @JsonProperty("ccdTohyokuCode")
    public ITohyokuCodeSelectDiv getCcdTohyokuCode() {
        return ccdTohyokuCode;
    }

    /*
     * getccdMeiboBango
     * @return ccdMeiboBango
     */
    @JsonProperty("ccdMeiboBango")
    public IMeiboBangoDiv getCcdMeiboBango() {
        return ccdMeiboBango;
    }

    /*
     * getlin2
     * @return lin2
     */
    @JsonProperty("lin2")
    public HorizontalLine getLin2() {
        return lin2;
    }

    /*
     * setlin2
     * @param lin2 lin2
     */
    @JsonProperty("lin2")
    public void setLin2(HorizontalLine lin2) {
        this.lin2 = lin2;
    }

    /*
     * gettxtMaxDisplayCount
     * @return txtMaxDisplayCount
     */
    @JsonProperty("txtMaxDisplayCount")
    public TextBoxNum getTxtMaxDisplayCount() {
        return txtMaxDisplayCount;
    }

    /*
     * settxtMaxDisplayCount
     * @param txtMaxDisplayCount txtMaxDisplayCount
     */
    @JsonProperty("txtMaxDisplayCount")
    public void setTxtMaxDisplayCount(TextBoxNum txtMaxDisplayCount) {
        this.txtMaxDisplayCount = txtMaxDisplayCount;
    }

    /*
     * getbtnCancel
     * @return btnCancel
     */
    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    /*
     * setbtnCancel
     * @param btnCancel btnCancel
     */
    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel = btnCancel;
    }

    /*
     * getbtnClear
     * @return btnClear
     */
    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    /*
     * setbtnClear
     * @param btnClear btnClear
     */
    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear = btnClear;
    }

    /*
     * getbtnSearch
     * @return btnSearch
     */
    @JsonProperty("btnSearch")
    public Button getBtnSearch() {
        return btnSearch;
    }

    /*
     * setbtnSearch
     * @param btnSearch btnSearch
     */
    @JsonProperty("btnSearch")
    public void setBtnSearch(Button btnSearch) {
        this.btnSearch = btnSearch;
    }

    /*
     * getccdSearchTojitsuSaikinShoriTaisho
     * @return ccdSearchTojitsuSaikinShoriTaisho
     */
    @JsonProperty("ccdSearchTojitsuSaikinShoriTaisho")
    public ISaikinShorishaRirekiDiv getCcdSearchTojitsuSaikinShoriTaisho() {
        return ccdSearchTojitsuSaikinShoriTaisho;
    }

    // </editor-fold>
}
