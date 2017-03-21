package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2040;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * BarCodeJuriJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class BarCodeJuriJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtJuriYMD")
    private TextBoxDate txtJuriYMD;
    @JsonProperty("txtJuriTime")
    private TextBoxTime txtJuriTime;
    @JsonProperty("radJuriHoho")
    private RadioButton radJuriHoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtJuriYMD
     * @return txtJuriYMD
     */
    @JsonProperty("txtJuriYMD")
    public TextBoxDate getTxtJuriYMD() {
        return txtJuriYMD;
    }

    /*
     * settxtJuriYMD
     * @param txtJuriYMD txtJuriYMD
     */
    @JsonProperty("txtJuriYMD")
    public void setTxtJuriYMD(TextBoxDate txtJuriYMD) {
        this.txtJuriYMD = txtJuriYMD;
    }

    /*
     * gettxtJuriTime
     * @return txtJuriTime
     */
    @JsonProperty("txtJuriTime")
    public TextBoxTime getTxtJuriTime() {
        return txtJuriTime;
    }

    /*
     * settxtJuriTime
     * @param txtJuriTime txtJuriTime
     */
    @JsonProperty("txtJuriTime")
    public void setTxtJuriTime(TextBoxTime txtJuriTime) {
        this.txtJuriTime = txtJuriTime;
    }

    /*
     * getradJuriHoho
     * @return radJuriHoho
     */
    @JsonProperty("radJuriHoho")
    public RadioButton getRadJuriHoho() {
        return radJuriHoho;
    }

    /*
     * setradJuriHoho
     * @param radJuriHoho radJuriHoho
     */
    @JsonProperty("radJuriHoho")
    public void setRadJuriHoho(RadioButton radJuriHoho) {
        this.radJuriHoho = radJuriHoho;
    }

    // </editor-fold>
}
