package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC1000;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyoShuruiSelect.ISenkyoShuruiSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyoShuruiSelect.SenkyoShuruiSelectDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IdoSearchJuminShikaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class IdoSearchJuminShikakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("IdoSearchJoken")
    private IdoSearchJokenDiv IdoSearchJoken;
    @JsonProperty("IdoSearchKekkaList")
    private IdoSearchKekkaListDiv IdoSearchKekkaList;
    @JsonProperty("ccdSenkyoShurui")
    private SenkyoShuruiSelectDiv ccdSenkyoShurui;
    @JsonProperty("hdnSenkyoShuruiCode")
    private RString hdnSenkyoShuruiCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getIdoSearchJoken
     * @return IdoSearchJoken
     */
    @JsonProperty("IdoSearchJoken")
    public IdoSearchJokenDiv getIdoSearchJoken() {
        return IdoSearchJoken;
    }

    /*
     * setIdoSearchJoken
     * @param IdoSearchJoken IdoSearchJoken
     */
    @JsonProperty("IdoSearchJoken")
    public void setIdoSearchJoken(IdoSearchJokenDiv IdoSearchJoken) {
        this.IdoSearchJoken = IdoSearchJoken;
    }

    /*
     * getIdoSearchKekkaList
     * @return IdoSearchKekkaList
     */
    @JsonProperty("IdoSearchKekkaList")
    public IdoSearchKekkaListDiv getIdoSearchKekkaList() {
        return IdoSearchKekkaList;
    }

    /*
     * setIdoSearchKekkaList
     * @param IdoSearchKekkaList IdoSearchKekkaList
     */
    @JsonProperty("IdoSearchKekkaList")
    public void setIdoSearchKekkaList(IdoSearchKekkaListDiv IdoSearchKekkaList) {
        this.IdoSearchKekkaList = IdoSearchKekkaList;
    }

    /*
     * getccdSenkyoShurui
     * @return ccdSenkyoShurui
     */
    @JsonProperty("ccdSenkyoShurui")
    public ISenkyoShuruiSelectDiv getCcdSenkyoShurui() {
        return ccdSenkyoShurui;
    }

    /*
     * gethdnSenkyoShuruiCode
     * @return hdnSenkyoShuruiCode
     */
    @JsonProperty("hdnSenkyoShuruiCode")
    public RString getHdnSenkyoShuruiCode() {
        return hdnSenkyoShuruiCode;
    }

    /*
     * sethdnSenkyoShuruiCode
     * @param hdnSenkyoShuruiCode hdnSenkyoShuruiCode
     */
    @JsonProperty("hdnSenkyoShuruiCode")
    public void setHdnSenkyoShuruiCode(RString hdnSenkyoShuruiCode) {
        this.hdnSenkyoShuruiCode = hdnSenkyoShuruiCode;
    }

    // </editor-fold>
}
