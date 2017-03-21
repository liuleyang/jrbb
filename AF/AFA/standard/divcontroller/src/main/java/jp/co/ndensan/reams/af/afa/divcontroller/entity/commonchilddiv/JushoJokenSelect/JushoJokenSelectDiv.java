package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JushoJokenSelect;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * JushoJokenSelect のクラスファイル
 *
 * @author 自動生成
 */
public class JushoJokenSelectDiv extends Panel implements IJushoJokenSelectDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radJushoJoken")
    private RadioButton radJushoJoken;
    @JsonProperty("dgJushoJokenList")
    private DataGrid<dgJushoJokenList_Row> dgJushoJokenList;
    @JsonProperty("shohonNoValue")
    private RString shohonNoValue;
    @JsonProperty("senkyoShuruiKey")
    private RString senkyoShuruiKey;
    @JsonProperty("senkyoShuruiValue")
    private RString senkyoShuruiValue;
    @JsonProperty("radioButtonName")
    private RString radioButtonName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradJushoJoken
     * @return radJushoJoken
     */
    @JsonProperty("radJushoJoken")
    public RadioButton getRadJushoJoken() {
        return radJushoJoken;
    }

    /*
     * setradJushoJoken
     * @param radJushoJoken radJushoJoken
     */
    @JsonProperty("radJushoJoken")
    public void setRadJushoJoken(RadioButton radJushoJoken) {
        this.radJushoJoken = radJushoJoken;
    }

    /*
     * getdgJushoJokenList
     * @return dgJushoJokenList
     */
    @JsonProperty("dgJushoJokenList")
    public DataGrid<dgJushoJokenList_Row> getDgJushoJokenList() {
        return dgJushoJokenList;
    }

    /*
     * setdgJushoJokenList
     * @param dgJushoJokenList dgJushoJokenList
     */
    @JsonProperty("dgJushoJokenList")
    public void setDgJushoJokenList(DataGrid<dgJushoJokenList_Row> dgJushoJokenList) {
        this.dgJushoJokenList = dgJushoJokenList;
    }

    /*
     * getshohonNoValue
     * @return shohonNoValue
     */
    @JsonProperty("shohonNoValue")
    public RString getShohonNoValue() {
        return shohonNoValue;
    }

    /*
     * setshohonNoValue
     * @param shohonNoValue shohonNoValue
     */
    @JsonProperty("shohonNoValue")
    public void setShohonNoValue(RString shohonNoValue) {
        this.shohonNoValue = shohonNoValue;
    }

    /*
     * getsenkyoShuruiKey
     * @return senkyoShuruiKey
     */
    @JsonProperty("senkyoShuruiKey")
    public RString getSenkyoShuruiKey() {
        return senkyoShuruiKey;
    }

    /*
     * setsenkyoShuruiKey
     * @param senkyoShuruiKey senkyoShuruiKey
     */
    @JsonProperty("senkyoShuruiKey")
    public void setSenkyoShuruiKey(RString senkyoShuruiKey) {
        this.senkyoShuruiKey = senkyoShuruiKey;
    }

    /*
     * getsenkyoShuruiValue
     * @return senkyoShuruiValue
     */
    @JsonProperty("senkyoShuruiValue")
    public RString getSenkyoShuruiValue() {
        return senkyoShuruiValue;
    }

    /*
     * setsenkyoShuruiValue
     * @param senkyoShuruiValue senkyoShuruiValue
     */
    @JsonProperty("senkyoShuruiValue")
    public void setSenkyoShuruiValue(RString senkyoShuruiValue) {
        this.senkyoShuruiValue = senkyoShuruiValue;
    }

    /*
     * getradioButtonName
     * @return radioButtonName
     */
    @JsonProperty("radioButtonName")
    public RString getRadioButtonName() {
        return radioButtonName;
    }

    /*
     * setradioButtonName
     * @param radioButtonName radioButtonName
     */
    @JsonProperty("radioButtonName")
    public void setRadioButtonName(RString radioButtonName) {
        this.radioButtonName = radioButtonName;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(ShohonNo 抄本番号, Code 選挙種類) {
        getHandler().initialize(抄本番号, 選挙種類);
    }

    @Override
    public void onChange_radJushoJoken() {
        getHandler().onChange_radJushoJoken();
    }

    @Override
    public void initialize(Code 選挙種類) {
        getHandler().initialize(null, 選挙種類);
    }

    @Override
    public ValidationMessageControlPairs gridContextCheck() {
        return getValidatorHandler().validateチェック();
    }

    @JsonIgnore
    public JushoJokenSelectHandler getHandler() {
        return new JushoJokenSelectHandler(this);
    }

    @JsonIgnore
    public JushoJokenSelectValidationHandler getValidatorHandler() {
        return new JushoJokenSelectValidationHandler(this);
    }
}
