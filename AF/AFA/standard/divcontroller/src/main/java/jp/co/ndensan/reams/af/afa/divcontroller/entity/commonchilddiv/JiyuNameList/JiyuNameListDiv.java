package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JiyuNameList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JiyuNameList のクラスファイル
 *
 * @reamsid_L AF-0320-011 lis
 */
public class JiyuNameListDiv extends Panel implements IJiyuNameListDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlJiyuName")
    private DropDownList ddlJiyuName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlJiyuName
     * @return ddlJiyuName
     */
    @JsonProperty("ddlJiyuName")
    public DropDownList getDdlJiyuName() {
        return ddlJiyuName;
    }

    /*
     * setddlJiyuName
     * @param ddlJiyuName ddlJiyuName
     */
    @JsonProperty("ddlJiyuName")
    public void setDdlJiyuName(DropDownList ddlJiyuName) {
        this.ddlJiyuName = ddlJiyuName;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(CodeShubetsu codeShubetsu) {
        initialize(codeShubetsu, Boolean.FALSE);
    }

    @Override
    public void initialize(CodeShubetsu codeShubetsu, Boolean isAddEmptyRow) {
        getHandler().initialize(codeShubetsu, isAddEmptyRow);
    }

    @Override
    public void initialize(Code code) {
        getHandler().initialize(code);
    }

    @Override
    public void clear() {
        getHandler().clear();
    }

    @Override
    public void setDisplayNoneMode(Boolean displayNoneSetMode) {
        getHandler().setDisplayNoneMode(displayNoneSetMode);
    }

    @Override
    public void setReadOnlyMode(Boolean readOnlySetMode) {
        getHandler().setReadOnlyMode(readOnlySetMode);
    }

    @Override
    public boolean isDisplayNoneMode() {
        return getHandler().isDisplayNoneMode();
    }

    @JsonIgnore
    public JiyuNameListHandler getHandler() {
        return new JiyuNameListHandler(this);
    }

    @Override
    @JsonIgnore
    public RString getSelectJiyuCode() {
        return getHandler().getSelectJiyuCode();
    }

    @Override
    @JsonIgnore
    public DropDownList getDdlJiyuNameList() {
        return getHandler().getDdlJiyuNameList();
    }

    @Override
    @JsonIgnore
    public void setRequiredMode(Boolean requiredSetMode) {
        getHandler().setRequiredMode(requiredSetMode);
    }

    @Override
    @JsonIgnore
    public void setDisabledMode(Boolean diabledSetMode) {
        getHandler().setDisabledMode(diabledSetMode);
    }
}
