package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1040;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KaikuNewShohonSelect のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaikuNewShohonSelectDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKaikuShohonSelect")
    private DataGrid<dgKaikuShohonSelect_Row> dgKaikuShohonSelect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgKaikuShohonSelect
     * @return dgKaikuShohonSelect
     */
    @JsonProperty("dgKaikuShohonSelect")
    public DataGrid<dgKaikuShohonSelect_Row> getDgKaikuShohonSelect() {
        return dgKaikuShohonSelect;
    }

    /*
     * setdgKaikuShohonSelect
     * @param dgKaikuShohonSelect dgKaikuShohonSelect
     */
    @JsonProperty("dgKaikuShohonSelect")
    public void setDgKaikuShohonSelect(DataGrid<dgKaikuShohonSelect_Row> dgKaikuShohonSelect) {
        this.dgKaikuShohonSelect = dgKaikuShohonSelect;
    }

    // </editor-fold>
}
