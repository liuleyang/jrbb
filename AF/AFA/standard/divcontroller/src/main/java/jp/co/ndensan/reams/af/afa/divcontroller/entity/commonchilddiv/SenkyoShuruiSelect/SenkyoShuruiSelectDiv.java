package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyoShuruiSelect;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuShurui;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;

/**
 * SenkyoShuruiSelect のクラスファイル
 *
 * @reamsid_L AF-0180-012 liuyj
 */
public class SenkyoShuruiSelectDiv extends Panel implements ISenkyoShuruiSelectDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlSenkyoShurui")
    private DropDownList ddlSenkyoShurui;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlSenkyoShurui
     * @return ddlSenkyoShurui
     */
    @JsonProperty("ddlSenkyoShurui")
    public DropDownList getDdlSenkyoShurui() {
        return ddlSenkyoShurui;
    }

    /*
     * setddlSenkyoShurui
     * @param ddlSenkyoShurui ddlSenkyoShurui
     */
    @JsonProperty("ddlSenkyoShurui")
    public void setDdlSenkyoShurui(DropDownList ddlSenkyoShurui) {
        this.ddlSenkyoShurui = ddlSenkyoShurui;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize() {
        getHandler().initialize();
    }

    @Override
    public void initialize(SenkyoShurui senkyoShurui) {
        getHandler().initialize(senkyoShurui);
    }

    @Override
    public void initialize(SennkyoSikakuShurui sennkyoSikakuShurui) {
        getHandler().initialize(sennkyoSikakuShurui);
    }

    @Override
    public void initialize(Code code) {
        getHandler().initialize(code);
    }

    @Override
    public SenkyoShurui getSelectedSenkyoShurui() {
        return getHandler().getSelectedSenkyoShurui();
    }

    @Override
    public SennkyoSikakuShurui getSelectedSennkyoSikakuShurui() {
        return getHandler().getSelectedSennkyoSikakuShurui();
    }

    @Override
    public void setDisplayNoneMode(Boolean displayNoneSetMode) {
        getHandler().setDisplayNoneMode(displayNoneSetMode);
    }

    @Override
    public void setReadOnlyMode(Boolean readOnlyMode) {
        getHandler().setReadOnlyMode(readOnlyMode);
    }

    @JsonIgnore
    public SenkyoShuruiSelectHandler getHandler() {
        return new SenkyoShuruiSelectHandler(this);
    }

}
