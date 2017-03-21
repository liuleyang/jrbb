package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMF1020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SaibaninTorikomiFileSelect のクラスファイル 
 * 
 * @author 自動生成
 */
public class SaibaninTorikomiFileSelectDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radSaibaninShinsain")
    private RadioButton radSaibaninShinsain;
    @JsonProperty("lblFaile")
    private Label lblFaile;
    @JsonProperty("uplSaibaninTorikomiFileSelect")
    private UploadPanel uplSaibaninTorikomiFileSelect;
    @JsonProperty("fileUpload")
    private Button fileUpload;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradSaibaninShinsain
     * @return radSaibaninShinsain
     */
    @JsonProperty("radSaibaninShinsain")
    public RadioButton getRadSaibaninShinsain() {
        return radSaibaninShinsain;
    }

    /*
     * setradSaibaninShinsain
     * @param radSaibaninShinsain radSaibaninShinsain
     */
    @JsonProperty("radSaibaninShinsain")
    public void setRadSaibaninShinsain(RadioButton radSaibaninShinsain) {
        this.radSaibaninShinsain = radSaibaninShinsain;
    }

    /*
     * getlblFaile
     * @return lblFaile
     */
    @JsonProperty("lblFaile")
    public Label getLblFaile() {
        return lblFaile;
    }

    /*
     * setlblFaile
     * @param lblFaile lblFaile
     */
    @JsonProperty("lblFaile")
    public void setLblFaile(Label lblFaile) {
        this.lblFaile = lblFaile;
    }

    /*
     * getuplSaibaninTorikomiFileSelect
     * @return uplSaibaninTorikomiFileSelect
     */
    @JsonProperty("uplSaibaninTorikomiFileSelect")
    public UploadPanel getUplSaibaninTorikomiFileSelect() {
        return uplSaibaninTorikomiFileSelect;
    }

    /*
     * setuplSaibaninTorikomiFileSelect
     * @param uplSaibaninTorikomiFileSelect uplSaibaninTorikomiFileSelect
     */
    @JsonProperty("uplSaibaninTorikomiFileSelect")
    public void setUplSaibaninTorikomiFileSelect(UploadPanel uplSaibaninTorikomiFileSelect) {
        this.uplSaibaninTorikomiFileSelect = uplSaibaninTorikomiFileSelect;
    }

    /*
     * getfileUpload
     * @return fileUpload
     */
    @JsonProperty("fileUpload")
    public Button getFileUpload() {
        return fileUpload;
    }

    /*
     * setfileUpload
     * @param fileUpload fileUpload
     */
    @JsonProperty("fileUpload")
    public void setFileUpload(Button fileUpload) {
        this.fileUpload = fileUpload;
    }

    // </editor-fold>
}
