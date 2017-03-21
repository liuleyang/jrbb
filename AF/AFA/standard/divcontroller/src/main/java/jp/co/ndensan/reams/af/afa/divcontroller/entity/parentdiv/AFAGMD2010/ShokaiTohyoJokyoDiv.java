package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMD2010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShokaiTohyoJokyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokaiTohyoJokyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-04-25_11-07-54">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShokaiTohyoJokyo")
    private DataGrid<dgShokaiTohyoJokyo_Row> dgShokaiTohyoJokyo;
    @JsonProperty("btnFinish")
    private Button btnFinish;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgShokaiTohyoJokyo
     * @return dgShokaiTohyoJokyo
     */
    @JsonProperty("dgShokaiTohyoJokyo")
    public DataGrid<dgShokaiTohyoJokyo_Row> getDgShokaiTohyoJokyo() {
        return dgShokaiTohyoJokyo;
    }

    /*
     * setdgShokaiTohyoJokyo
     * @param dgShokaiTohyoJokyo dgShokaiTohyoJokyo
     */
    @JsonProperty("dgShokaiTohyoJokyo")
    public void setDgShokaiTohyoJokyo(DataGrid<dgShokaiTohyoJokyo_Row> dgShokaiTohyoJokyo) {
        this.dgShokaiTohyoJokyo = dgShokaiTohyoJokyo;
    }

    /*
     * getbtnFinish
     * @return btnFinish
     */
    @JsonProperty("btnFinish")
    public Button getBtnFinish() {
        return btnFinish;
    }

    /*
     * setbtnFinish
     * @param btnFinish btnFinish
     */
    @JsonProperty("btnFinish")
    public void setBtnFinish(Button btnFinish) {
        this.btnFinish = btnFinish;
    }

    // </editor-fold>
}
