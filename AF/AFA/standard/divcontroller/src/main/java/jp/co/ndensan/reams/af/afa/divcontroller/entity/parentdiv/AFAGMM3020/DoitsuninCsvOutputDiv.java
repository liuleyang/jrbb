package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM3020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DoitsuninCsvOutput のクラスファイル 
 * 
 * @author 自動生成
 */
public class DoitsuninCsvOutputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("DoitsuninCsvOutputParam")
    private DoitsuninCsvOutputParamDiv DoitsuninCsvOutputParam;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getDoitsuninCsvOutputParam
     * @return DoitsuninCsvOutputParam
     */
    @JsonProperty("DoitsuninCsvOutputParam")
    public DoitsuninCsvOutputParamDiv getDoitsuninCsvOutputParam() {
        return DoitsuninCsvOutputParam;
    }

    /*
     * setDoitsuninCsvOutputParam
     * @param DoitsuninCsvOutputParam DoitsuninCsvOutputParam
     */
    @JsonProperty("DoitsuninCsvOutputParam")
    public void setDoitsuninCsvOutputParam(DoitsuninCsvOutputParamDiv DoitsuninCsvOutputParam) {
        this.DoitsuninCsvOutputParam = DoitsuninCsvOutputParam;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblHanteiJoken() {
        return this.getDoitsuninCsvOutputParam().getLblHanteiJoken();
    }

    @JsonIgnore
    public void  setLblHanteiJoken(Label lblHanteiJoken) {
        this.getDoitsuninCsvOutputParam().setLblHanteiJoken(lblHanteiJoken);
    }

    @JsonIgnore
    public CheckBoxList getChkShimei() {
        return this.getDoitsuninCsvOutputParam().getChkShimei();
    }

    @JsonIgnore
    public void  setChkShimei(CheckBoxList chkShimei) {
        this.getDoitsuninCsvOutputParam().setChkShimei(chkShimei);
    }

    @JsonIgnore
    public RadioButton getRadSeiMei() {
        return this.getDoitsuninCsvOutputParam().getRadSeiMei();
    }

    @JsonIgnore
    public void  setRadSeiMei(RadioButton radSeiMei) {
        this.getDoitsuninCsvOutputParam().setRadSeiMei(radSeiMei);
    }

    @JsonIgnore
    public RadioButton getRadKanaKanji() {
        return this.getDoitsuninCsvOutputParam().getRadKanaKanji();
    }

    @JsonIgnore
    public void  setRadKanaKanji(RadioButton radKanaKanji) {
        this.getDoitsuninCsvOutputParam().setRadKanaKanji(radKanaKanji);
    }

    @JsonIgnore
    public CheckBoxList getChkSeinengappi() {
        return this.getDoitsuninCsvOutputParam().getChkSeinengappi();
    }

    @JsonIgnore
    public void  setChkSeinengappi(CheckBoxList chkSeinengappi) {
        this.getDoitsuninCsvOutputParam().setChkSeinengappi(chkSeinengappi);
    }

    @JsonIgnore
    public CheckBoxList getChkSeibetsu() {
        return this.getDoitsuninCsvOutputParam().getChkSeibetsu();
    }

    @JsonIgnore
    public void  setChkSeibetsu(CheckBoxList chkSeibetsu) {
        this.getDoitsuninCsvOutputParam().setChkSeibetsu(chkSeibetsu);
    }

    @JsonIgnore
    public CheckBoxList getChkJushoCode() {
        return this.getDoitsuninCsvOutputParam().getChkJushoCode();
    }

    @JsonIgnore
    public void  setChkJushoCode(CheckBoxList chkJushoCode) {
        this.getDoitsuninCsvOutputParam().setChkJushoCode(chkJushoCode);
    }

    @JsonIgnore
    public CheckBoxList getChkJusho() {
        return this.getDoitsuninCsvOutputParam().getChkJusho();
    }

    @JsonIgnore
    public void  setChkJusho(CheckBoxList chkJusho) {
        this.getDoitsuninCsvOutputParam().setChkJusho(chkJusho);
    }

    @JsonIgnore
    public CheckBoxList getChkBanchiCode() {
        return this.getDoitsuninCsvOutputParam().getChkBanchiCode();
    }

    @JsonIgnore
    public void  setChkBanchiCode(CheckBoxList chkBanchiCode) {
        this.getDoitsuninCsvOutputParam().setChkBanchiCode(chkBanchiCode);
    }

    @JsonIgnore
    public IShohonNameListDiv getCcdShohonNameList() {
        return this.getDoitsuninCsvOutputParam().getCcdShohonNameList();
    }

    // </editor-fold>
}
