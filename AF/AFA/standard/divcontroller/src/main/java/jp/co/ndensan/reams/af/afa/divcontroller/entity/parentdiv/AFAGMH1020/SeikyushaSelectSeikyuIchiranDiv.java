package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SeikyushaSelectSeikyuIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeikyushaSelectSeikyuIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgSeikyushaSelectSeikyuIchiran")
    private DataGrid<dgSeikyushaSelectSeikyuIchiran_Row> dgSeikyushaSelectSeikyuIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgSeikyushaSelectSeikyuIchiran
     * @return dgSeikyushaSelectSeikyuIchiran
     */
    @JsonProperty("dgSeikyushaSelectSeikyuIchiran")
    public DataGrid<dgSeikyushaSelectSeikyuIchiran_Row> getDgSeikyushaSelectSeikyuIchiran() {
        return dgSeikyushaSelectSeikyuIchiran;
    }

    /*
     * setdgSeikyushaSelectSeikyuIchiran
     * @param dgSeikyushaSelectSeikyuIchiran dgSeikyushaSelectSeikyuIchiran
     */
    @JsonProperty("dgSeikyushaSelectSeikyuIchiran")
    public void setDgSeikyushaSelectSeikyuIchiran(DataGrid<dgSeikyushaSelectSeikyuIchiran_Row> dgSeikyushaSelectSeikyuIchiran) {
        this.dgSeikyushaSelectSeikyuIchiran = dgSeikyushaSelectSeikyuIchiran;
    }

    // </editor-fold>
}
