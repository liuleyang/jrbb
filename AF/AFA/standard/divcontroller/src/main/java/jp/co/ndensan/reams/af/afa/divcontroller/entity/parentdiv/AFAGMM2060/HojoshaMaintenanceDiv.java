package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2060;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyojoCodeSelect.ITohyojoCodeSelectDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxAtenaMeisho;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxShikibetsuCode;

/**
 * HojoshaMaintenance のクラスファイル
 *
 * @author 自動生成
 */
public class HojoshaMaintenanceDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HojoshaSelect")
    private HojoshaSelectDiv HojoshaSelect;
    @JsonProperty("HojoshaInput")
    private HojoshaInputDiv HojoshaInput;
    @JsonProperty("searchSimpleJuminModel")
    private RString searchSimpleJuminModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHojoshaSelect
     * @return HojoshaSelect
     */
    @JsonProperty("HojoshaSelect")
    public HojoshaSelectDiv getHojoshaSelect() {
        return HojoshaSelect;
    }

    /*
     * setHojoshaSelect
     * @param HojoshaSelect HojoshaSelect
     */
    @JsonProperty("HojoshaSelect")
    public void setHojoshaSelect(HojoshaSelectDiv HojoshaSelect) {
        this.HojoshaSelect = HojoshaSelect;
    }

    /*
     * getHojoshaInput
     * @return HojoshaInput
     */
    @JsonProperty("HojoshaInput")
    public HojoshaInputDiv getHojoshaInput() {
        return HojoshaInput;
    }

    /*
     * setHojoshaInput
     * @param HojoshaInput HojoshaInput
     */
    @JsonProperty("HojoshaInput")
    public void setHojoshaInput(HojoshaInputDiv HojoshaInput) {
        this.HojoshaInput = HojoshaInput;
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
    public Button getBtnAdd() {
        return this.getHojoshaSelect().getBtnAdd();
    }

    @JsonIgnore
    public void setBtnAdd(Button btnAdd) {
        this.getHojoshaSelect().setBtnAdd(btnAdd);
    }

    @JsonIgnore
    public DataGrid<dgHojoshaList_Row> getDgHojoshaList() {
        return this.getHojoshaSelect().getDgHojoshaList();
    }

    @JsonIgnore
    public void setDgHojoshaList(DataGrid<dgHojoshaList_Row> dgHojoshaList) {
        this.getHojoshaSelect().setDgHojoshaList(dgHojoshaList);
    }

    @JsonIgnore
    public IShohonNameListDiv getCcdShohonNameList() {
        return this.getHojoshaSelect().getCcdShohonNameList();
    }

    @JsonIgnore
    public TextBoxShikibetsuCode getTxtShikibetsuCode() {
        return this.getHojoshaInput().getTxtShikibetsuCode();
    }

    @JsonIgnore
    public void setTxtShikibetsuCode(TextBoxShikibetsuCode txtShikibetsuCode) {
        this.getHojoshaInput().setTxtShikibetsuCode(txtShikibetsuCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnSearchJumin() {
        return this.getHojoshaInput().getBtnSearchJumin();
    }

    @JsonIgnore
    public void setBtnSearchJumin(ButtonDialog btnSearchJumin) {
        this.getHojoshaInput().setBtnSearchJumin(btnSearchJumin);
    }

    @JsonIgnore
    public TextBoxAtenaMeisho getTxtName() {
        return this.getHojoshaInput().getTxtName();
    }

    @JsonIgnore
    public void setTxtName(TextBoxAtenaMeisho txtName) {
        this.getHojoshaInput().setTxtName(txtName);
    }

    @JsonIgnore
    public Button getBtnAddNew() {
        return this.getHojoshaInput().getBtnAddNew();
    }

    @JsonIgnore
    public void setBtnAddNew(Button btnAddNew) {
        this.getHojoshaInput().setBtnAddNew(btnAddNew);
    }

    @JsonIgnore
    public Button getBtnStop() {
        return this.getHojoshaInput().getBtnStop();
    }

    @JsonIgnore
    public void setBtnStop(Button btnStop) {
        this.getHojoshaInput().setBtnStop(btnStop);
    }

    @JsonIgnore
    public ITohyojoCodeSelectDiv getCcdTohyojoCode() {
        return this.getHojoshaInput().getCcdTohyojoCode();
    }

    // </editor-fold>
}
