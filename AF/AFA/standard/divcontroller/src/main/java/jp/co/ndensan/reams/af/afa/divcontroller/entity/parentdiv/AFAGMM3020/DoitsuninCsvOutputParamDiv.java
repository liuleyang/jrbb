package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM3020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * DoitsuninCsvOutputParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class DoitsuninCsvOutputParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblHanteiJoken")
    private Label lblHanteiJoken;
    @JsonProperty("chkShimei")
    private CheckBoxList chkShimei;
    @JsonProperty("radSeiMei")
    private RadioButton radSeiMei;
    @JsonProperty("radKanaKanji")
    private RadioButton radKanaKanji;
    @JsonProperty("chkSeinengappi")
    private CheckBoxList chkSeinengappi;
    @JsonProperty("chkSeibetsu")
    private CheckBoxList chkSeibetsu;
    @JsonProperty("chkJushoCode")
    private CheckBoxList chkJushoCode;
    @JsonProperty("chkJusho")
    private CheckBoxList chkJusho;
    @JsonProperty("chkBanchiCode")
    private CheckBoxList chkBanchiCode;
    @JsonProperty("ccdShohonNameList")
    private ShohonNameListDiv ccdShohonNameList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblHanteiJoken
     * @return lblHanteiJoken
     */
    @JsonProperty("lblHanteiJoken")
    public Label getLblHanteiJoken() {
        return lblHanteiJoken;
    }

    /*
     * setlblHanteiJoken
     * @param lblHanteiJoken lblHanteiJoken
     */
    @JsonProperty("lblHanteiJoken")
    public void setLblHanteiJoken(Label lblHanteiJoken) {
        this.lblHanteiJoken = lblHanteiJoken;
    }

    /*
     * getchkShimei
     * @return chkShimei
     */
    @JsonProperty("chkShimei")
    public CheckBoxList getChkShimei() {
        return chkShimei;
    }

    /*
     * setchkShimei
     * @param chkShimei chkShimei
     */
    @JsonProperty("chkShimei")
    public void setChkShimei(CheckBoxList chkShimei) {
        this.chkShimei = chkShimei;
    }

    /*
     * getradSeiMei
     * @return radSeiMei
     */
    @JsonProperty("radSeiMei")
    public RadioButton getRadSeiMei() {
        return radSeiMei;
    }

    /*
     * setradSeiMei
     * @param radSeiMei radSeiMei
     */
    @JsonProperty("radSeiMei")
    public void setRadSeiMei(RadioButton radSeiMei) {
        this.radSeiMei = radSeiMei;
    }

    /*
     * getradKanaKanji
     * @return radKanaKanji
     */
    @JsonProperty("radKanaKanji")
    public RadioButton getRadKanaKanji() {
        return radKanaKanji;
    }

    /*
     * setradKanaKanji
     * @param radKanaKanji radKanaKanji
     */
    @JsonProperty("radKanaKanji")
    public void setRadKanaKanji(RadioButton radKanaKanji) {
        this.radKanaKanji = radKanaKanji;
    }

    /*
     * getchkSeinengappi
     * @return chkSeinengappi
     */
    @JsonProperty("chkSeinengappi")
    public CheckBoxList getChkSeinengappi() {
        return chkSeinengappi;
    }

    /*
     * setchkSeinengappi
     * @param chkSeinengappi chkSeinengappi
     */
    @JsonProperty("chkSeinengappi")
    public void setChkSeinengappi(CheckBoxList chkSeinengappi) {
        this.chkSeinengappi = chkSeinengappi;
    }

    /*
     * getchkSeibetsu
     * @return chkSeibetsu
     */
    @JsonProperty("chkSeibetsu")
    public CheckBoxList getChkSeibetsu() {
        return chkSeibetsu;
    }

    /*
     * setchkSeibetsu
     * @param chkSeibetsu chkSeibetsu
     */
    @JsonProperty("chkSeibetsu")
    public void setChkSeibetsu(CheckBoxList chkSeibetsu) {
        this.chkSeibetsu = chkSeibetsu;
    }

    /*
     * getchkJushoCode
     * @return chkJushoCode
     */
    @JsonProperty("chkJushoCode")
    public CheckBoxList getChkJushoCode() {
        return chkJushoCode;
    }

    /*
     * setchkJushoCode
     * @param chkJushoCode chkJushoCode
     */
    @JsonProperty("chkJushoCode")
    public void setChkJushoCode(CheckBoxList chkJushoCode) {
        this.chkJushoCode = chkJushoCode;
    }

    /*
     * getchkJusho
     * @return chkJusho
     */
    @JsonProperty("chkJusho")
    public CheckBoxList getChkJusho() {
        return chkJusho;
    }

    /*
     * setchkJusho
     * @param chkJusho chkJusho
     */
    @JsonProperty("chkJusho")
    public void setChkJusho(CheckBoxList chkJusho) {
        this.chkJusho = chkJusho;
    }

    /*
     * getchkBanchiCode
     * @return chkBanchiCode
     */
    @JsonProperty("chkBanchiCode")
    public CheckBoxList getChkBanchiCode() {
        return chkBanchiCode;
    }

    /*
     * setchkBanchiCode
     * @param chkBanchiCode chkBanchiCode
     */
    @JsonProperty("chkBanchiCode")
    public void setChkBanchiCode(CheckBoxList chkBanchiCode) {
        this.chkBanchiCode = chkBanchiCode;
    }

    /*
     * getccdShohonNameList
     * @return ccdShohonNameList
     */
    @JsonProperty("ccdShohonNameList")
    public IShohonNameListDiv getCcdShohonNameList() {
        return ccdShohonNameList;
    }

    // </editor-fold>
}
