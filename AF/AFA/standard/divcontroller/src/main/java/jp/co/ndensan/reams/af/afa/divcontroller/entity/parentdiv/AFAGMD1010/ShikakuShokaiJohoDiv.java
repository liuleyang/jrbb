package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMD1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikakuShokaiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShikakuShokaiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSenkyoShurui")
    private TextBox txtSenkyoShurui;
    @JsonProperty("dgShikakuShokai")
    private DataGrid<dgShikakuShokai_Row> dgShikakuShokai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSenkyoShurui
     * @return txtSenkyoShurui
     */
    @JsonProperty("txtSenkyoShurui")
    public TextBox getTxtSenkyoShurui() {
        return txtSenkyoShurui;
    }

    /*
     * settxtSenkyoShurui
     * @param txtSenkyoShurui txtSenkyoShurui
     */
    @JsonProperty("txtSenkyoShurui")
    public void setTxtSenkyoShurui(TextBox txtSenkyoShurui) {
        this.txtSenkyoShurui = txtSenkyoShurui;
    }

    /*
     * getdgShikakuShokai
     * @return dgShikakuShokai
     */
    @JsonProperty("dgShikakuShokai")
    public DataGrid<dgShikakuShokai_Row> getDgShikakuShokai() {
        return dgShikakuShokai;
    }

    /*
     * setdgShikakuShokai
     * @param dgShikakuShokai dgShikakuShokai
     */
    @JsonProperty("dgShikakuShokai")
    public void setDgShikakuShokai(DataGrid<dgShikakuShokai_Row> dgShikakuShokai) {
        this.dgShikakuShokai = dgShikakuShokai;
    }

    // </editor-fold>
}
