package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC1000;
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
 * IdoSearchJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class IdoSearchJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("txtMaxKensu")
    private TextBoxNum txtMaxKensu;
    @JsonProperty("ccdIdoSearchTohyoShikaku")
    private SearchShikakuDiv ccdIdoSearchTohyoShikaku;
    @JsonProperty("ccdIdoSearchSaikinShoriTaisho")
    private SaikinShorishaRirekiDiv ccdIdoSearchSaikinShoriTaisho;
    @JsonProperty("ccdIdoSearchJukiJoho")
    private AtenaFinderDiv ccdIdoSearchJukiJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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
     * getccdIdoSearchTohyoShikaku
     * @return ccdIdoSearchTohyoShikaku
     */
    @JsonProperty("ccdIdoSearchTohyoShikaku")
    public ISearchShikakuDiv getCcdIdoSearchTohyoShikaku() {
        return ccdIdoSearchTohyoShikaku;
    }

    /*
     * getccdIdoSearchSaikinShoriTaisho
     * @return ccdIdoSearchSaikinShoriTaisho
     */
    @JsonProperty("ccdIdoSearchSaikinShoriTaisho")
    public ISaikinShorishaRirekiDiv getCcdIdoSearchSaikinShoriTaisho() {
        return ccdIdoSearchSaikinShoriTaisho;
    }

    /*
     * getccdIdoSearchJukiJoho
     * @return ccdIdoSearchJukiJoho
     */
    @JsonProperty("ccdIdoSearchJukiJoho")
    public IAtenaFinderDiv getCcdIdoSearchJukiJoho() {
        return ccdIdoSearchJukiJoho;
    }

    // </editor-fold>
}
