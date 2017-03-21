package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ZaigaiKofuRirekiDialog;
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
 * ZaigaiKofuRirekiDialog のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZaigaiKofuRirekiDialogDiv extends Panel implements IZaigaiKofuRirekiDialogDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKofuRireki")
    private DataGrid<dgKofuRireki_Row> dgKofuRireki;
    @JsonProperty("btnClose")
    private Button btnClose;
    @JsonProperty("ShikibetsuCode")
    private RString ShikibetsuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgKofuRireki
     * @return dgKofuRireki
     */
    @JsonProperty("dgKofuRireki")
    public DataGrid<dgKofuRireki_Row> getDgKofuRireki() {
        return dgKofuRireki;
    }

    /*
     * setdgKofuRireki
     * @param dgKofuRireki dgKofuRireki
     */
    @JsonProperty("dgKofuRireki")
    public void setDgKofuRireki(DataGrid<dgKofuRireki_Row> dgKofuRireki) {
        this.dgKofuRireki = dgKofuRireki;
    }

    /*
     * getbtnClose
     * @return btnClose
     */
    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    /*
     * setbtnClose
     * @param btnClose btnClose
     */
    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    /*
     * getShikibetsuCode
     * @return ShikibetsuCode
     */
    @JsonProperty("ShikibetsuCode")
    public RString getShikibetsuCode() {
        return ShikibetsuCode;
    }

    /*
     * setShikibetsuCode
     * @param ShikibetsuCode ShikibetsuCode
     */
    @JsonProperty("ShikibetsuCode")
    public void setShikibetsuCode(RString ShikibetsuCode) {
        this.ShikibetsuCode = ShikibetsuCode;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
