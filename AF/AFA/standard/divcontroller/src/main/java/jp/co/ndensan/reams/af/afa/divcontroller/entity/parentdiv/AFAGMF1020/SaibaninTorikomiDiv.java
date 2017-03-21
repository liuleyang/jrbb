package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMF1020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SaibaninTorikomi のクラスファイル 
 * 
 * @author 自動生成
 */
public class SaibaninTorikomiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SaibaninTorikomiFileSelect")
    private SaibaninTorikomiFileSelectDiv SaibaninTorikomiFileSelect;
    @JsonProperty("saibaninMeiboSakuseiFlg")
    private RString saibaninMeiboSakuseiFlg;
    @JsonProperty("meiboTorikomiZumiFlg")
    private RString meiboTorikomiZumiFlg;
    @JsonProperty("fileEmptyFlg")
    private RString fileEmptyFlg;
    @JsonProperty("countFlg")
    private RString countFlg;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSaibaninTorikomiFileSelect
     * @return SaibaninTorikomiFileSelect
     */
    @JsonProperty("SaibaninTorikomiFileSelect")
    public SaibaninTorikomiFileSelectDiv getSaibaninTorikomiFileSelect() {
        return SaibaninTorikomiFileSelect;
    }

    /*
     * setSaibaninTorikomiFileSelect
     * @param SaibaninTorikomiFileSelect SaibaninTorikomiFileSelect
     */
    @JsonProperty("SaibaninTorikomiFileSelect")
    public void setSaibaninTorikomiFileSelect(SaibaninTorikomiFileSelectDiv SaibaninTorikomiFileSelect) {
        this.SaibaninTorikomiFileSelect = SaibaninTorikomiFileSelect;
    }

    /*
     * getsaibaninMeiboSakuseiFlg
     * @return saibaninMeiboSakuseiFlg
     */
    @JsonProperty("saibaninMeiboSakuseiFlg")
    public RString getSaibaninMeiboSakuseiFlg() {
        return saibaninMeiboSakuseiFlg;
    }

    /*
     * setsaibaninMeiboSakuseiFlg
     * @param saibaninMeiboSakuseiFlg saibaninMeiboSakuseiFlg
     */
    @JsonProperty("saibaninMeiboSakuseiFlg")
    public void setSaibaninMeiboSakuseiFlg(RString saibaninMeiboSakuseiFlg) {
        this.saibaninMeiboSakuseiFlg = saibaninMeiboSakuseiFlg;
    }

    /*
     * getmeiboTorikomiZumiFlg
     * @return meiboTorikomiZumiFlg
     */
    @JsonProperty("meiboTorikomiZumiFlg")
    public RString getMeiboTorikomiZumiFlg() {
        return meiboTorikomiZumiFlg;
    }

    /*
     * setmeiboTorikomiZumiFlg
     * @param meiboTorikomiZumiFlg meiboTorikomiZumiFlg
     */
    @JsonProperty("meiboTorikomiZumiFlg")
    public void setMeiboTorikomiZumiFlg(RString meiboTorikomiZumiFlg) {
        this.meiboTorikomiZumiFlg = meiboTorikomiZumiFlg;
    }

    /*
     * getfileEmptyFlg
     * @return fileEmptyFlg
     */
    @JsonProperty("fileEmptyFlg")
    public RString getFileEmptyFlg() {
        return fileEmptyFlg;
    }

    /*
     * setfileEmptyFlg
     * @param fileEmptyFlg fileEmptyFlg
     */
    @JsonProperty("fileEmptyFlg")
    public void setFileEmptyFlg(RString fileEmptyFlg) {
        this.fileEmptyFlg = fileEmptyFlg;
    }

    /*
     * getcountFlg
     * @return countFlg
     */
    @JsonProperty("countFlg")
    public RString getCountFlg() {
        return countFlg;
    }

    /*
     * setcountFlg
     * @param countFlg countFlg
     */
    @JsonProperty("countFlg")
    public void setCountFlg(RString countFlg) {
        this.countFlg = countFlg;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadSaibaninShinsain() {
        return this.getSaibaninTorikomiFileSelect().getRadSaibaninShinsain();
    }

    @JsonIgnore
    public void  setRadSaibaninShinsain(RadioButton radSaibaninShinsain) {
        this.getSaibaninTorikomiFileSelect().setRadSaibaninShinsain(radSaibaninShinsain);
    }

    @JsonIgnore
    public Label getLblFaile() {
        return this.getSaibaninTorikomiFileSelect().getLblFaile();
    }

    @JsonIgnore
    public void  setLblFaile(Label lblFaile) {
        this.getSaibaninTorikomiFileSelect().setLblFaile(lblFaile);
    }

    @JsonIgnore
    public UploadPanel getUplSaibaninTorikomiFileSelect() {
        return this.getSaibaninTorikomiFileSelect().getUplSaibaninTorikomiFileSelect();
    }

    @JsonIgnore
    public void  setUplSaibaninTorikomiFileSelect(UploadPanel uplSaibaninTorikomiFileSelect) {
        this.getSaibaninTorikomiFileSelect().setUplSaibaninTorikomiFileSelect(uplSaibaninTorikomiFileSelect);
    }

    @JsonIgnore
    public Button getFileUpload() {
        return this.getSaibaninTorikomiFileSelect().getFileUpload();
    }

    @JsonIgnore
    public void  setFileUpload(Button fileUpload) {
        this.getSaibaninTorikomiFileSelect().setFileUpload(fileUpload);
    }

    // </editor-fold>
}
