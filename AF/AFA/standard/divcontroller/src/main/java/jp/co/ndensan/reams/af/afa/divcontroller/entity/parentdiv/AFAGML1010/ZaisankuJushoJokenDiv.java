package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGML1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ZaisankuJushoJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZaisankuJushoJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgZaisankuTohyoku")
    private DataGrid<dgZaisankuTohyoku_Row> dgZaisankuTohyoku;
    @JsonProperty("ZaisankuJushoJokenShosai")
    private ZaisankuJushoJokenShosaiDiv ZaisankuJushoJokenShosai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgZaisankuTohyoku
     * @return dgZaisankuTohyoku
     */
    @JsonProperty("dgZaisankuTohyoku")
    public DataGrid<dgZaisankuTohyoku_Row> getDgZaisankuTohyoku() {
        return dgZaisankuTohyoku;
    }

    /*
     * setdgZaisankuTohyoku
     * @param dgZaisankuTohyoku dgZaisankuTohyoku
     */
    @JsonProperty("dgZaisankuTohyoku")
    public void setDgZaisankuTohyoku(DataGrid<dgZaisankuTohyoku_Row> dgZaisankuTohyoku) {
        this.dgZaisankuTohyoku = dgZaisankuTohyoku;
    }

    /*
     * getZaisankuJushoJokenShosai
     * @return ZaisankuJushoJokenShosai
     */
    @JsonProperty("ZaisankuJushoJokenShosai")
    public ZaisankuJushoJokenShosaiDiv getZaisankuJushoJokenShosai() {
        return ZaisankuJushoJokenShosai;
    }

    /*
     * setZaisankuJushoJokenShosai
     * @param ZaisankuJushoJokenShosai ZaisankuJushoJokenShosai
     */
    @JsonProperty("ZaisankuJushoJokenShosai")
    public void setZaisankuJushoJokenShosai(ZaisankuJushoJokenShosaiDiv ZaisankuJushoJokenShosai) {
        this.ZaisankuJushoJokenShosai = ZaisankuJushoJokenShosai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgZaisankuJusho_Row> getDgZaisankuJusho() {
        return this.getZaisankuJushoJokenShosai().getDgZaisankuJusho();
    }

    @JsonIgnore
    public void  setDgZaisankuJusho(DataGrid<dgZaisankuJusho_Row> dgZaisankuJusho) {
        this.getZaisankuJushoJokenShosai().setDgZaisankuJusho(dgZaisankuJusho);
    }

    // </editor-fold>
}
