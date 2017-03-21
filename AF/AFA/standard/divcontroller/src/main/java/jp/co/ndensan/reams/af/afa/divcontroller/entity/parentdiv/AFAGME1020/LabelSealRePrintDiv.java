package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME1020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * LabelSealRePrint のクラスファイル 
 * 
 * @author 自動生成
 */
public class LabelSealRePrintDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("LabelSealRePrintParam")
    private LabelSealRePrintParamDiv LabelSealRePrintParam;
    @JsonProperty("searchSimpleJuminModel")
    private RString searchSimpleJuminModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getLabelSealRePrintParam
     * @return LabelSealRePrintParam
     */
    @JsonProperty("LabelSealRePrintParam")
    public LabelSealRePrintParamDiv getLabelSealRePrintParam() {
        return LabelSealRePrintParam;
    }

    /*
     * setLabelSealRePrintParam
     * @param LabelSealRePrintParam LabelSealRePrintParam
     */
    @JsonProperty("LabelSealRePrintParam")
    public void setLabelSealRePrintParam(LabelSealRePrintParamDiv LabelSealRePrintParam) {
        this.LabelSealRePrintParam = LabelSealRePrintParam;
    }

    /*
     * getsearchSimpleJuminModel
     * @return searchSimpleJuminModel
     */
    @JsonProperty("searchSimpleJuminModel")
    public RString getSearchSimpleJuminModel() {
        return searchSimpleJuminModel;
    }

    /*
     * setsearchSimpleJuminModel
     * @param searchSimpleJuminModel searchSimpleJuminModel
     */
    @JsonProperty("searchSimpleJuminModel")
    public void setSearchSimpleJuminModel(RString searchSimpleJuminModel) {
        this.searchSimpleJuminModel = searchSimpleJuminModel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public LabelSealSakuseiTaishoDiv getLabelSealSakuseiTaisho() {
        return this.getLabelSealRePrintParam().getLabelSealSakuseiTaisho();
    }

    @JsonIgnore
    public void  setLabelSealSakuseiTaisho(LabelSealSakuseiTaishoDiv LabelSealSakuseiTaisho) {
        this.getLabelSealRePrintParam().setLabelSealSakuseiTaisho(LabelSealSakuseiTaisho);
    }

    // </editor-fold>
}
