package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJiyuCode;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.business.core.contexts.TohyoJiyuCodeContext;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;

/**
 * TohyoJiyuCode のクラスファイル
 *
 * @author 自動生成
 */
public class TohyoJiyuCodeDiv extends Panel implements ITohyoJiyuCodeDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTohyoJiyuCode")
    private TextBoxCode txtTohyoJiyuCode;
    @JsonProperty("ddlTohyoJiyu")
    private DropDownList ddlTohyoJiyu;
    @JsonProperty("initialValue")
    private RString initialValue;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTohyoJiyuCode
     * @return txtTohyoJiyuCode
     */
    @JsonProperty("txtTohyoJiyuCode")
    public TextBoxCode getTxtTohyoJiyuCode() {
        return txtTohyoJiyuCode;
    }

    /*
     * settxtTohyoJiyuCode
     * @param txtTohyoJiyuCode txtTohyoJiyuCode
     */
    @JsonProperty("txtTohyoJiyuCode")
    public void setTxtTohyoJiyuCode(TextBoxCode txtTohyoJiyuCode) {
        this.txtTohyoJiyuCode = txtTohyoJiyuCode;
    }

    /*
     * getddlTohyoJiyu
     * @return ddlTohyoJiyu
     */
    @JsonProperty("ddlTohyoJiyu")
    public DropDownList getDdlTohyoJiyu() {
        return ddlTohyoJiyu;
    }

    /*
     * setddlTohyoJiyu
     * @param ddlTohyoJiyu ddlTohyoJiyu
     */
    @JsonProperty("ddlTohyoJiyu")
    public void setDdlTohyoJiyu(DropDownList ddlTohyoJiyu) {
        this.ddlTohyoJiyu = ddlTohyoJiyu;
    }

    /*
     * getinitialValue
     * @return initialValue
     */
    @JsonProperty("initialValue")
    public RString getInitialValue() {
        return initialValue;
    }

    /*
     * setinitialValue
     * @param initialValue initialValue
     */
    @JsonProperty("initialValue")
    public void setInitialValue(RString initialValue) {
        this.initialValue = initialValue;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public TohyoJiyuCodeContext getTohyoJiyuCodeContext() {
        return getHandler().getTohyoJiyuCodeContext();
    }

    @Override
    public void initialize(SenkyoShurui senkyoShurui, TohyoJokyo tohyoJokyo) {
        getHandler().initialize(senkyoShurui, tohyoJokyo);
    }

    @Override
    public void initialSetting() {
        getHandler().initialSetting();
    }

    @Override
    public void clearData() {
        getHandler().clearThisPanel();
    }

    @Override
    public void setReadOnlyMode(Boolean readOnlySetMode) {
        getHandler().setReadOnlyMode(readOnlySetMode);
    }

    @JsonIgnore
    public TohyoJiyuCodeHandler getHandler() {
        return new TohyoJiyuCodeHandler(this);
    }

    @Override
    public boolean checkTohyoJiyuCode() {
        return new TohyoJiyuCodeHandler(this).is投票事由コード存在();
    }

}
