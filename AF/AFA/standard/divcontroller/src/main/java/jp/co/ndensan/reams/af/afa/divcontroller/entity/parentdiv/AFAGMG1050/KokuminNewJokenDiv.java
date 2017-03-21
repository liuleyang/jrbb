package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1050;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KokuminNewJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class KokuminNewJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSaishinkaYMD")
    private TextBoxDate txtSaishinkaYMD;
    @JsonProperty("radSort")
    private RadioButton radSort;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSaishinkaYMD
     * @return txtSaishinkaYMD
     */
    @JsonProperty("txtSaishinkaYMD")
    public TextBoxDate getTxtSaishinkaYMD() {
        return txtSaishinkaYMD;
    }

    /*
     * settxtSaishinkaYMD
     * @param txtSaishinkaYMD txtSaishinkaYMD
     */
    @JsonProperty("txtSaishinkaYMD")
    public void setTxtSaishinkaYMD(TextBoxDate txtSaishinkaYMD) {
        this.txtSaishinkaYMD = txtSaishinkaYMD;
    }

    /*
     * getradSort
     * @return radSort
     */
    @JsonProperty("radSort")
    public RadioButton getRadSort() {
        return radSort;
    }

    /*
     * setradSort
     * @param radSort radSort
     */
    @JsonProperty("radSort")
    public void setRadSort(RadioButton radSort) {
        this.radSort = radSort;
    }

    // </editor-fold>
}
