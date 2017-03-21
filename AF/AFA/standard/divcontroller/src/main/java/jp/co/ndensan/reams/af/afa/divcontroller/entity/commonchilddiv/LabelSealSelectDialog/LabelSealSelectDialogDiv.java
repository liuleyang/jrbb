package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.LabelSealSelectDialog;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.LabelSealPrintTaisho.ILabelSealPrintTaishoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.LabelSealPrintTaisho.LabelSealPrintTaishoDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaSealPositionGuide.AtenaSealPositionGuideDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaSealPositionGuide.IAtenaSealPositionGuideDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * LabelSealSelectDialog のクラスファイルです。
 *
 * @reamsid_L AF-0620-015 liuyj
 */
public class LabelSealSelectDialogDiv extends Panel implements ILabelSealSelectDialogDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-04-25_11-07-54">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdLabelSealPrintTaisho")
    private LabelSealPrintTaishoDiv ccdLabelSealPrintTaisho;
    @JsonProperty("ccdSealPosition")
    private AtenaSealPositionGuideDiv ccdSealPosition;
    @JsonProperty("btnPrint")
    private Button btnPrint;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("LabelSealSelectDialogModel")
    private RString LabelSealSelectDialogModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdLabelSealPrintTaisho
     * @return ccdLabelSealPrintTaisho
     */
    @JsonProperty("ccdLabelSealPrintTaisho")
    public ILabelSealPrintTaishoDiv getCcdLabelSealPrintTaisho() {
        return ccdLabelSealPrintTaisho;
    }

    /*
     * getccdSealPosition
     * @return ccdSealPosition
     */
    @JsonProperty("ccdSealPosition")
    public IAtenaSealPositionGuideDiv getCcdSealPosition() {
        return ccdSealPosition;
    }

    /*
     * getbtnPrint
     * @return btnPrint
     */
    @JsonProperty("btnPrint")
    public Button getBtnPrint() {
        return btnPrint;
    }

    /*
     * setbtnPrint
     * @param btnPrint btnPrint
     */
    @JsonProperty("btnPrint")
    public void setBtnPrint(Button btnPrint) {
        this.btnPrint = btnPrint;
    }

    /*
     * getbtnCancel
     * @return btnCancel
     */
    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    /*
     * setbtnCancel
     * @param btnCancel btnCancel
     */
    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel = btnCancel;
    }

    /*
     * getLabelSealSelectDialogModel
     * @return LabelSealSelectDialogModel
     */
    @JsonProperty("LabelSealSelectDialogModel")
    public RString getLabelSealSelectDialogModel() {
        return LabelSealSelectDialogModel;
    }

    /*
     * setLabelSealSelectDialogModel
     * @param LabelSealSelectDialogModel LabelSealSelectDialogModel
     */
    @JsonProperty("LabelSealSelectDialogModel")
    public void setLabelSealSelectDialogModel(RString LabelSealSelectDialogModel) {
        this.LabelSealSelectDialogModel = LabelSealSelectDialogModel;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @JsonIgnore
    public LabelSealSelectDialogHandler getHandler() {
        return new LabelSealSelectDialogHandler(this);
    }

    @JsonIgnore
    public LabelSealSelectDialogValidationHandler getValidationHandler() {
        return new LabelSealSelectDialogValidationHandler(this);
    }

}
