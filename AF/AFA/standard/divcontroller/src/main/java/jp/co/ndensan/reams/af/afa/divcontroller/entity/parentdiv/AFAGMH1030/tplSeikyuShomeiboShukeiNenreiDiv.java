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
 * tplSeikyuShomeiboShukeiNenrei のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplSeikyuShomeiboShukeiNenreiDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgSeikyuShomeiboShukeiNenrei")
    private DataGrid<dgSeikyuShomeiboShukeiNenrei_Row> dgSeikyuShomeiboShukeiNenrei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgSeikyuShomeiboShukeiNenrei
     * @return dgSeikyuShomeiboShukeiNenrei
     */
    @JsonProperty("dgSeikyuShomeiboShukeiNenrei")
    public DataGrid<dgSeikyuShomeiboShukeiNenrei_Row> getDgSeikyuShomeiboShukeiNenrei() {
        return dgSeikyuShomeiboShukeiNenrei;
    }

    /*
     * setdgSeikyuShomeiboShukeiNenrei
     * @param dgSeikyuShomeiboShukeiNenrei dgSeikyuShomeiboShukeiNenrei
     */
    @JsonProperty("dgSeikyuShomeiboShukeiNenrei")
    public void setDgSeikyuShomeiboShukeiNenrei(DataGrid<dgSeikyuShomeiboShukeiNenrei_Row> dgSeikyuShomeiboShukeiNenrei) {
        this.dgSeikyuShomeiboShukeiNenrei = dgSeikyuShomeiboShukeiNenrei;
    }

    // </editor-fold>
}
