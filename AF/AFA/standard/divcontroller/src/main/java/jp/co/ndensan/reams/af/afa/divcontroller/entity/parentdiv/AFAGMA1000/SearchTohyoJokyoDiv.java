package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1000;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboBango.IMeiboBangoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboBango.MeiboBangoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelect.IShisetsuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelect.ShisetsuCodeSelectDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SearchTohyoJokyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchTohyoJokyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblMeiboBango")
    private Label lblMeiboBango;
    @JsonProperty("chkTohyoJokyo")
    private CheckBoxList chkTohyoJokyo;
    @JsonProperty("txtUketsukeYMDRange")
    private TextBoxDateRange txtUketsukeYMDRange;
    @JsonProperty("txtUketsukeTime")
    private TextBoxTimeRange txtUketsukeTime;
    @JsonProperty("ddlUketsukeBnago")
    private DropDownList ddlUketsukeBnago;
    @JsonProperty("txtUketsukeBnago")
    private TextBox txtUketsukeBnago;
    @JsonProperty("SearchSaibanin")
    private SearchSaibaninDiv SearchSaibanin;
    @JsonProperty("ccdShisetsuCode")
    private ShisetsuCodeSelectDiv ccdShisetsuCode;
    @JsonProperty("ccdMeiboBango")
    private MeiboBangoDiv ccdMeiboBango;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblMeiboBango
     * @return lblMeiboBango
     */
    @JsonProperty("lblMeiboBango")
    public Label getLblMeiboBango() {
        return lblMeiboBango;
    }

    /*
     * setlblMeiboBango
     * @param lblMeiboBango lblMeiboBango
     */
    @JsonProperty("lblMeiboBango")
    public void setLblMeiboBango(Label lblMeiboBango) {
        this.lblMeiboBango = lblMeiboBango;
    }

    /*
     * getchkTohyoJokyo
     * @return chkTohyoJokyo
     */
    @JsonProperty("chkTohyoJokyo")
    public CheckBoxList getChkTohyoJokyo() {
        return chkTohyoJokyo;
    }

    /*
     * setchkTohyoJokyo
     * @param chkTohyoJokyo chkTohyoJokyo
     */
    @JsonProperty("chkTohyoJokyo")
    public void setChkTohyoJokyo(CheckBoxList chkTohyoJokyo) {
        this.chkTohyoJokyo = chkTohyoJokyo;
    }

    /*
     * gettxtUketsukeYMDRange
     * @return txtUketsukeYMDRange
     */
    @JsonProperty("txtUketsukeYMDRange")
    public TextBoxDateRange getTxtUketsukeYMDRange() {
        return txtUketsukeYMDRange;
    }

    /*
     * settxtUketsukeYMDRange
     * @param txtUketsukeYMDRange txtUketsukeYMDRange
     */
    @JsonProperty("txtUketsukeYMDRange")
    public void setTxtUketsukeYMDRange(TextBoxDateRange txtUketsukeYMDRange) {
        this.txtUketsukeYMDRange = txtUketsukeYMDRange;
    }

    /*
     * gettxtUketsukeTime
     * @return txtUketsukeTime
     */
    @JsonProperty("txtUketsukeTime")
    public TextBoxTimeRange getTxtUketsukeTime() {
        return txtUketsukeTime;
    }

    /*
     * settxtUketsukeTime
     * @param txtUketsukeTime txtUketsukeTime
     */
    @JsonProperty("txtUketsukeTime")
    public void setTxtUketsukeTime(TextBoxTimeRange txtUketsukeTime) {
        this.txtUketsukeTime = txtUketsukeTime;
    }

    /*
     * getddlUketsukeBnago
     * @return ddlUketsukeBnago
     */
    @JsonProperty("ddlUketsukeBnago")
    public DropDownList getDdlUketsukeBnago() {
        return ddlUketsukeBnago;
    }

    /*
     * setddlUketsukeBnago
     * @param ddlUketsukeBnago ddlUketsukeBnago
     */
    @JsonProperty("ddlUketsukeBnago")
    public void setDdlUketsukeBnago(DropDownList ddlUketsukeBnago) {
        this.ddlUketsukeBnago = ddlUketsukeBnago;
    }

    /*
     * gettxtUketsukeBnago
     * @return txtUketsukeBnago
     */
    @JsonProperty("txtUketsukeBnago")
    public TextBox getTxtUketsukeBnago() {
        return txtUketsukeBnago;
    }

    /*
     * settxtUketsukeBnago
     * @param txtUketsukeBnago txtUketsukeBnago
     */
    @JsonProperty("txtUketsukeBnago")
    public void setTxtUketsukeBnago(TextBox txtUketsukeBnago) {
        this.txtUketsukeBnago = txtUketsukeBnago;
    }

    /*
     * getSearchSaibanin
     * @return SearchSaibanin
     */
    @JsonProperty("SearchSaibanin")
    public SearchSaibaninDiv getSearchSaibanin() {
        return SearchSaibanin;
    }

    /*
     * setSearchSaibanin
     * @param SearchSaibanin SearchSaibanin
     */
    @JsonProperty("SearchSaibanin")
    public void setSearchSaibanin(SearchSaibaninDiv SearchSaibanin) {
        this.SearchSaibanin = SearchSaibanin;
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
     * getccdMeiboBango
     * @return ccdMeiboBango
     */
    @JsonProperty("ccdMeiboBango")
    public IMeiboBangoDiv getCcdMeiboBango() {
        return ccdMeiboBango;
    }

    // </editor-fold>
}
