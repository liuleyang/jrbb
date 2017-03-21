package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NyujokenKobetsuSakuseiTaisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class NyujokenKobetsuSakuseiTaishoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NyujokenKobetsuSentaku")
    private NyujokenKobetsuSentakuDiv NyujokenKobetsuSentaku;
    @JsonProperty("txtHdnSenkyoShurui")
    private RString txtHdnSenkyoShurui;
    @JsonProperty("txtHdnShohonNo")
    private RString txtHdnShohonNo;
    @JsonProperty("txtHdnShikibetsuCode")
    private RString txtHdnShikibetsuCode;
    @JsonProperty("SearchSimpleJuminModel")
    private RString SearchSimpleJuminModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getNyujokenKobetsuSentaku
     * @return NyujokenKobetsuSentaku
     */
    @JsonProperty("NyujokenKobetsuSentaku")
    public NyujokenKobetsuSentakuDiv getNyujokenKobetsuSentaku() {
        return NyujokenKobetsuSentaku;
    }

    /*
     * setNyujokenKobetsuSentaku
     * @param NyujokenKobetsuSentaku NyujokenKobetsuSentaku
     */
    @JsonProperty("NyujokenKobetsuSentaku")
    public void setNyujokenKobetsuSentaku(NyujokenKobetsuSentakuDiv NyujokenKobetsuSentaku) {
        this.NyujokenKobetsuSentaku = NyujokenKobetsuSentaku;
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

    /*
     * getSearchSimpleJuminModel
     * @return SearchSimpleJuminModel
     */
    @JsonProperty("SearchSimpleJuminModel")
    public RString getSearchSimpleJuminModel() {
        return SearchSimpleJuminModel;
    }

    /*
     * setSearchSimpleJuminModel
     * @param SearchSimpleJuminModel SearchSimpleJuminModel
     */
    @JsonProperty("SearchSimpleJuminModel")
    public void setSearchSimpleJuminModel(RString SearchSimpleJuminModel) {
        this.SearchSimpleJuminModel = SearchSimpleJuminModel;
    }

    // </editor-fold>
}
