package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1000;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchShikaku.ISearchShikakuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchShikaku.SearchShikakuDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaFinder.AtenaFinderDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaFinder.IAtenaFinderDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.SaikinShorishaRireki.ISaikinShorishaRirekiDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.SaikinShorishaRireki.SaikinShorishaRirekiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SearchJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SearchTohyoJokyo")
    private SearchTohyoJokyoDiv SearchTohyoJokyo;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("txtMaxKensu")
    private TextBoxNum txtMaxKensu;
    @JsonProperty("ccdSearchSaikinShoriTaisho")
    private SaikinShorishaRirekiDiv ccdSearchSaikinShoriTaisho;
    @JsonProperty("ccdSearchTohyoShikaku")
    private SearchShikakuDiv ccdSearchTohyoShikaku;
    @JsonProperty("ccdSearchJukiJoho")
    private AtenaFinderDiv ccdSearchJukiJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSearchTohyoJokyo
     * @return SearchTohyoJokyo
     */
    @JsonProperty("SearchTohyoJokyo")
    public SearchTohyoJokyoDiv getSearchTohyoJokyo() {
        return SearchTohyoJokyo;
    }

    /*
     * setSearchTohyoJokyo
     * @param SearchTohyoJokyo SearchTohyoJokyo
     */
    @JsonProperty("SearchTohyoJokyo")
    public void setSearchTohyoJokyo(SearchTohyoJokyoDiv SearchTohyoJokyo) {
        this.SearchTohyoJokyo = SearchTohyoJokyo;
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
     * gettxtMaxKensu
     * @return txtMaxKensu
     */
    @JsonProperty("txtMaxKensu")
    public TextBoxNum getTxtMaxKensu() {
        return txtMaxKensu;
    }

    /*
     * settxtMaxKensu
     * @param txtMaxKensu txtMaxKensu
     */
    @JsonProperty("txtMaxKensu")
    public void setTxtMaxKensu(TextBoxNum txtMaxKensu) {
        this.txtMaxKensu = txtMaxKensu;
    }

    /*
     * getccdSearchSaikinShoriTaisho
     * @return ccdSearchSaikinShoriTaisho
     */
    @JsonProperty("ccdSearchSaikinShoriTaisho")
    public ISaikinShorishaRirekiDiv getCcdSearchSaikinShoriTaisho() {
        return ccdSearchSaikinShoriTaisho;
    }

    /*
     * getccdSearchTohyoShikaku
     * @return ccdSearchTohyoShikaku
     */
    @JsonProperty("ccdSearchTohyoShikaku")
    public ISearchShikakuDiv getCcdSearchTohyoShikaku() {
        return ccdSearchTohyoShikaku;
    }

    /*
     * getccdSearchJukiJoho
     * @return ccdSearchJukiJoho
     */
    @JsonProperty("ccdSearchJukiJoho")
    public IAtenaFinderDiv getCcdSearchJukiJoho() {
        return ccdSearchJukiJoho;
    }

    // </editor-fold>
}
