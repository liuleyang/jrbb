package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME4010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChangePage のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChangePageDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnBefore")
    private Button btnBefore;
    @JsonProperty("btnAfter")
    private Button btnAfter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnBefore
     * @return btnBefore
     */
    @JsonProperty("btnBefore")
    public Button getBtnBefore() {
        return btnBefore;
    }

    /*
     * setbtnBefore
     * @param btnBefore btnBefore
     */
    @JsonProperty("btnBefore")
    public void setBtnBefore(Button btnBefore) {
        this.btnBefore = btnBefore;
    }

    /*
     * getbtnAfter
     * @return btnAfter
     */
    @JsonProperty("btnAfter")
    public Button getBtnAfter() {
        return btnAfter;
    }

    /*
     * setbtnAfter
     * @param btnAfter btnAfter
     */
    @JsonProperty("btnAfter")
    public void setBtnAfter(Button btnAfter) {
        this.btnAfter = btnAfter;
    }

    // </editor-fold>
}
