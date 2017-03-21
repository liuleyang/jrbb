package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchSimpleJuminDialog;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.ITohyokuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.TohyokuCodeSelectDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaFinder.AtenaFinderDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaFinder.IAtenaFinderDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.SaikinShorishaRireki.ISaikinShorishaRirekiDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.SaikinShorishaRireki.SaikinShorishaRirekiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SearchSimpleJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchSimpleJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-24_20-09-47">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdShohonNameList")
    private ShohonNameListDiv ccdShohonNameList;
    @JsonProperty("ccdSearchSimpleJukiJoho")
    private AtenaFinderDiv ccdSearchSimpleJukiJoho;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("ccdTohyokuCode")
    private TohyokuCodeSelectDiv ccdTohyokuCode;
    @JsonProperty("chkSearchSenkyoShikaku")
    private CheckBoxList chkSearchSenkyoShikaku;
    @JsonProperty("chkSearchTohyoShikaku")
    private CheckBoxList chkSearchTohyoShikaku;
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
    @JsonProperty("ccdSearchSimpleSaikinShoriTaisho")
    private SaikinShorishaRirekiDiv ccdSearchSimpleSaikinShoriTaisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdShohonNameList
     * @return ccdShohonNameList
     */
    @JsonProperty("ccdShohonNameList")
    public IShohonNameListDiv getCcdShohonNameList() {
        return ccdShohonNameList;
    }

    /*
     * getccdSearchSimpleJukiJoho
     * @return ccdSearchSimpleJukiJoho
     */
    @JsonProperty("ccdSearchSimpleJukiJoho")
    public IAtenaFinderDiv getCcdSearchSimpleJukiJoho() {
        return ccdSearchSimpleJukiJoho;
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
     * getchkSearchSenkyoShikaku
     * @return chkSearchSenkyoShikaku
     */
    @JsonProperty("chkSearchSenkyoShikaku")
    public CheckBoxList getChkSearchSenkyoShikaku() {
        return chkSearchSenkyoShikaku;
    }

    /*
     * setchkSearchSenkyoShikaku
     * @param chkSearchSenkyoShikaku chkSearchSenkyoShikaku
     */
    @JsonProperty("chkSearchSenkyoShikaku")
    public void setChkSearchSenkyoShikaku(CheckBoxList chkSearchSenkyoShikaku) {
        this.chkSearchSenkyoShikaku = chkSearchSenkyoShikaku;
    }

    /*
     * getchkSearchTohyoShikaku
     * @return chkSearchTohyoShikaku
     */
    @JsonProperty("chkSearchTohyoShikaku")
    public CheckBoxList getChkSearchTohyoShikaku() {
        return chkSearchTohyoShikaku;
    }

    /*
     * setchkSearchTohyoShikaku
     * @param chkSearchTohyoShikaku chkSearchTohyoShikaku
     */
    @JsonProperty("chkSearchTohyoShikaku")
    public void setChkSearchTohyoShikaku(CheckBoxList chkSearchTohyoShikaku) {
        this.chkSearchTohyoShikaku = chkSearchTohyoShikaku;
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
     * getccdSearchSimpleSaikinShoriTaisho
     * @return ccdSearchSimpleSaikinShoriTaisho
     */
    @JsonProperty("ccdSearchSimpleSaikinShoriTaisho")
    public ISaikinShorishaRirekiDiv getCcdSearchSimpleSaikinShoriTaisho() {
        return ccdSearchSimpleSaikinShoriTaisho;
    }

    // </editor-fold>
}
