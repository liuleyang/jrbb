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
 * tplSeikyuShomeiboShukeiKensuJusho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplSeikyuShomeiboShukeiKensuJushoDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgSeikyuShomeiboShukeiKensuJusho")
    private DataGrid<dgSeikyuShomeiboShukeiKensuJusho_Row> dgSeikyuShomeiboShukeiKensuJusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgSeikyuShomeiboShukeiKensuJusho
     * @return dgSeikyuShomeiboShukeiKensuJusho
     */
    @JsonProperty("dgSeikyuShomeiboShukeiKensuJusho")
    public DataGrid<dgSeikyuShomeiboShukeiKensuJusho_Row> getDgSeikyuShomeiboShukeiKensuJusho() {
        return dgSeikyuShomeiboShukeiKensuJusho;
    }

    /*
     * setdgSeikyuShomeiboShukeiKensuJusho
     * @param dgSeikyuShomeiboShukeiKensuJusho dgSeikyuShomeiboShukeiKensuJusho
     */
    @JsonProperty("dgSeikyuShomeiboShukeiKensuJusho")
    public void setDgSeikyuShomeiboShukeiKensuJusho(DataGrid<dgSeikyuShomeiboShukeiKensuJusho_Row> dgSeikyuShomeiboShukeiKensuJusho) {
        this.dgSeikyuShomeiboShukeiKensuJusho = dgSeikyuShomeiboShukeiKensuJusho;
    }

    // </editor-fold>
}
