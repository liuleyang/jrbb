package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.HojoshaSelectDialog;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.IDialogDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HojoshaSelectDialog のクラスファイル
 *
 * @reamsid_L AF-0080-030 wangm
 */
public class HojoshaSelectDialogDiv extends Panel implements IHojoshaSelectDialogDiv, IDialogDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-04-25_11-07-54">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdShohonName")
    private ShohonNameListDiv ccdShohonName;
    @JsonProperty("dgHojoshaSelect")
    private DataGrid<dgHojoshaSelect_Row> dgHojoshaSelect;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("HojoshaSelectDialogModel")
    private RString HojoshaSelectDialogModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdShohonName
     * @return ccdShohonName
     */
    @JsonProperty("ccdShohonName")
    public IShohonNameListDiv getCcdShohonName() {
        return ccdShohonName;
    }

    /*
     * getdgHojoshaSelect
     * @return dgHojoshaSelect
     */
    @JsonProperty("dgHojoshaSelect")
    public DataGrid<dgHojoshaSelect_Row> getDgHojoshaSelect() {
        return dgHojoshaSelect;
    }

    /*
     * setdgHojoshaSelect
     * @param dgHojoshaSelect dgHojoshaSelect
     */
    @JsonProperty("dgHojoshaSelect")
    public void setDgHojoshaSelect(DataGrid<dgHojoshaSelect_Row> dgHojoshaSelect) {
        this.dgHojoshaSelect = dgHojoshaSelect;
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
     * getHojoshaSelectDialogModel
     * @return HojoshaSelectDialogModel
     */
    @JsonProperty("HojoshaSelectDialogModel")
    public RString getHojoshaSelectDialogModel() {
        return HojoshaSelectDialogModel;
    }

    /*
     * setHojoshaSelectDialogModel
     * @param HojoshaSelectDialogModel HojoshaSelectDialogModel
     */
    @JsonProperty("HojoshaSelectDialogModel")
    public void setHojoshaSelectDialogModel(RString HojoshaSelectDialogModel) {
        this.HojoshaSelectDialogModel = HojoshaSelectDialogModel;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
}
