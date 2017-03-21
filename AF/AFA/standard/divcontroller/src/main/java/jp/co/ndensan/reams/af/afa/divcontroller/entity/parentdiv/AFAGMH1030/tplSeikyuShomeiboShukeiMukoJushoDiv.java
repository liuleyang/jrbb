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
 * tplSeikyuShomeiboShukeiMukoJusho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplSeikyuShomeiboShukeiMukoJushoDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgSeikyuShomeiboShukeiMukoJusho")
    private DataGrid<dgSeikyuShomeiboShukeiMukoJusho_Row> dgSeikyuShomeiboShukeiMukoJusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgSeikyuShomeiboShukeiMukoJusho
     * @return dgSeikyuShomeiboShukeiMukoJusho
     */
    @JsonProperty("dgSeikyuShomeiboShukeiMukoJusho")
    public DataGrid<dgSeikyuShomeiboShukeiMukoJusho_Row> getDgSeikyuShomeiboShukeiMukoJusho() {
        return dgSeikyuShomeiboShukeiMukoJusho;
    }

    /*
     * setdgSeikyuShomeiboShukeiMukoJusho
     * @param dgSeikyuShomeiboShukeiMukoJusho dgSeikyuShomeiboShukeiMukoJusho
     */
    @JsonProperty("dgSeikyuShomeiboShukeiMukoJusho")
    public void setDgSeikyuShomeiboShukeiMukoJusho(DataGrid<dgSeikyuShomeiboShukeiMukoJusho_Row> dgSeikyuShomeiboShukeiMukoJusho) {
        this.dgSeikyuShomeiboShukeiMukoJusho = dgSeikyuShomeiboShukeiMukoJusho;
    }

    // </editor-fold>
}
