package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelect;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.af.afa.business.core.contexts.ShisetsuCodeSelectContext;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShisetsuShubetsu;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;

/**
 * ShisetsuCodeSelect のクラスファイル
 *
 * @author 自動生成
 * @reamsid_L AF-0080-035 qiuxy
 */
public class ShisetsuCodeSelectDiv extends Panel implements IShisetsuCodeSelectDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShisetsuCode")
    private TextBoxCode txtShisetsuCode;
    @JsonProperty("btnShisetsuCode")
    private ButtonDialog btnShisetsuCode;
    @JsonProperty("txtShisetsuName")
    private TextBox txtShisetsuName;
    @JsonProperty("ShisetsuCodeSelectModel")
    private RString ShisetsuCodeSelectModel;
    @JsonProperty("txtHdnShisetsuShubetsu")
    private RString txtHdnShisetsuShubetsu;
    @JsonProperty("isUsingShisetsuShubetsu")
    private RString isUsingShisetsuShubetsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShisetsuCode
     * @return txtShisetsuCode
     */
    @JsonProperty("txtShisetsuCode")
    public TextBoxCode getTxtShisetsuCode() {
        return txtShisetsuCode;
    }

    /*
     * settxtShisetsuCode
     * @param txtShisetsuCode txtShisetsuCode
     */
    @JsonProperty("txtShisetsuCode")
    public void setTxtShisetsuCode(TextBoxCode txtShisetsuCode) {
        this.txtShisetsuCode = txtShisetsuCode;
    }

    /*
     * getbtnShisetsuCode
     * @return btnShisetsuCode
     */
    @JsonProperty("btnShisetsuCode")
    public ButtonDialog getBtnShisetsuCode() {
        return btnShisetsuCode;
    }

    /*
     * setbtnShisetsuCode
     * @param btnShisetsuCode btnShisetsuCode
     */
    @JsonProperty("btnShisetsuCode")
    public void setBtnShisetsuCode(ButtonDialog btnShisetsuCode) {
        this.btnShisetsuCode = btnShisetsuCode;
    }

    /*
     * gettxtShisetsuName
     * @return txtShisetsuName
     */
    @JsonProperty("txtShisetsuName")
    public TextBox getTxtShisetsuName() {
        return txtShisetsuName;
    }

    /*
     * settxtShisetsuName
     * @param txtShisetsuName txtShisetsuName
     */
    @JsonProperty("txtShisetsuName")
    public void setTxtShisetsuName(TextBox txtShisetsuName) {
        this.txtShisetsuName = txtShisetsuName;
    }

    /*
     * getShisetsuCodeSelectModel
     * @return ShisetsuCodeSelectModel
     */
    @JsonProperty("ShisetsuCodeSelectModel")
    public RString getShisetsuCodeSelectModel() {
        return ShisetsuCodeSelectModel;
    }

    /*
     * setShisetsuCodeSelectModel
     * @param ShisetsuCodeSelectModel ShisetsuCodeSelectModel
     */
    @JsonProperty("ShisetsuCodeSelectModel")
    public void setShisetsuCodeSelectModel(RString ShisetsuCodeSelectModel) {
        this.ShisetsuCodeSelectModel = ShisetsuCodeSelectModel;
    }

    /*
     * gettxtHdnShisetsuShubetsu
     * @return txtHdnShisetsuShubetsu
     */
    @JsonProperty("txtHdnShisetsuShubetsu")
    public RString getTxtHdnShisetsuShubetsu() {
        return txtHdnShisetsuShubetsu;
    }

    /*
     * settxtHdnShisetsuShubetsu
     * @param txtHdnShisetsuShubetsu txtHdnShisetsuShubetsu
     */
    @JsonProperty("txtHdnShisetsuShubetsu")
    public void setTxtHdnShisetsuShubetsu(RString txtHdnShisetsuShubetsu) {
        this.txtHdnShisetsuShubetsu = txtHdnShisetsuShubetsu;
    }

    /*
     * getisUsingShisetsuShubetsu
     * @return isUsingShisetsuShubetsu
     */
    @JsonProperty("isUsingShisetsuShubetsu")
    public RString getIsUsingShisetsuShubetsu() {
        return isUsingShisetsuShubetsu;
    }

    /*
     * setisUsingShisetsuShubetsu
     * @param isUsingShisetsuShubetsu isUsingShisetsuShubetsu
     */
    @JsonProperty("isUsingShisetsuShubetsu")
    public void setIsUsingShisetsuShubetsu(RString isUsingShisetsuShubetsu) {
        this.isUsingShisetsuShubetsu = isUsingShisetsuShubetsu;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    // 共有子Div自身のsetDisabledのセットができるように
    @Override
    public void initialize() {
        getHandler().initialize();
    }

    @Override
    public void initialize(RString code, boolean kubun) {
        getHandler().initialize(code, kubun);
    }

    @Override
    public void initialize(ShisetsuShubetsu 施設種別, boolean 本庁支所区分, RString 施設コード) {
        getHandler().initialize(施設種別, 本庁支所区分, 施設コード);
    }

    @Override
    public void initialize(RString code) {
        getHandler().initialize(code);
    }

    @Override
    public void clear() {
        getHandler().clear();
    }

    @Override
    public RString get施設コード() {
        return getHandler().get施設コード();
    }

    @Override
    public RString get施設名称() {
        return getHandler().get施設名称();
    }

    @Override
    public void setReadOnlyMode(Boolean readOnlySetMode) {
        getHandler().setReadOnlyMode(readOnlySetMode);
    }

    @JsonIgnore
    public ShisetsuCodeSelectHandler getHandler() {
        return new ShisetsuCodeSelectHandler(this);
    }

    @JsonIgnore
    public ShisetsuCodeSelectValidationHandler getValidationHandler() {
        return new ShisetsuCodeSelectValidationHandler(this);
    }

    @Override
    public ShisetsuCodeSelectContext getShisetsuCodeSelectContext() {
        return getHandler().getShisetsuCodeSelectContext();
    }

}
