package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1030;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplSeikyuShomeiboShukeiKensuTohyoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplSeikyuShomeiboShukeiKensuTohyokuDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgSeikyuShomeiboShukeiKensuTohyoku")
    private DataGrid<dgSeikyuShomeiboShukeiKensuTohyoku_Row> dgSeikyuShomeiboShukeiKensuTohyoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgSeikyuShomeiboShukeiKensuTohyoku
     * @return dgSeikyuShomeiboShukeiKensuTohyoku
     */
    @JsonProperty("dgSeikyuShomeiboShukeiKensuTohyoku")
    public DataGrid<dgSeikyuShomeiboShukeiKensuTohyoku_Row> getDgSeikyuShomeiboShukeiKensuTohyoku() {
        return dgSeikyuShomeiboShukeiKensuTohyoku;
    }

    /*
     * setdgSeikyuShomeiboShukeiKensuTohyoku
     * @param dgSeikyuShomeiboShukeiKensuTohyoku dgSeikyuShomeiboShukeiKensuTohyoku
     */
    @JsonProperty("dgSeikyuShomeiboShukeiKensuTohyoku")
    public void setDgSeikyuShomeiboShukeiKensuTohyoku(DataGrid<dgSeikyuShomeiboShukeiKensuTohyoku_Row> dgSeikyuShomeiboShukeiKensuTohyoku) {
        this.dgSeikyuShomeiboShukeiKensuTohyoku = dgSeikyuShomeiboShukeiKensuTohyoku;
    }

    // </editor-fold>
}
