package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.BarCodeNyuryoku;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * BarCodeNyuryoku のクラスファイル
 *
 * @author 自動生成
 */
public class BarCodeNyuryokuDiv extends Panel implements IBarCodeNyuryokuDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtBarCode")
    private TextBox txtBarCode;
    @JsonProperty("btnBarCode")
    private Button btnBarCode;
    @JsonProperty("length")
    private Label length;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtBarCode
     * @return txtBarCode
     */
    @JsonProperty("txtBarCode")
    public TextBox getTxtBarCode() {
        return txtBarCode;
    }

    /*
     * settxtBarCode
     * @param txtBarCode txtBarCode
     */
    @JsonProperty("txtBarCode")
    public void setTxtBarCode(TextBox txtBarCode) {
        this.txtBarCode = txtBarCode;
    }

    /*
     * getbtnBarCode
     * @return btnBarCode
     */
    @JsonProperty("btnBarCode")
    public Button getBtnBarCode() {
        return btnBarCode;
    }

    /*
     * setbtnBarCode
     * @param btnBarCode btnBarCode
     */
    @JsonProperty("btnBarCode")
    public void setBtnBarCode(Button btnBarCode) {
        this.btnBarCode = btnBarCode;
    }

    /*
     * getlength
     * @return length
     */
    @JsonProperty("length")
    public Label getLength() {
        return length;
    }

    /*
     * setlength
     * @param length length
     */
    @JsonProperty("length")
    public void setLength(Label length) {
        this.length = length;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(TohyoJokyo tohyoJokyo, boolean isシミュレーション) {
        getHandler().initialize(tohyoJokyo, isシミュレーション);
    }

    @Override
    public void clearData() {
        getHandler().clearThisPanel();
    }

    @Override
    public RString getBarCode() {
        return getHandler().getBarCode();
    }

    @Override
    public RString getShohonNo() {
        return getHandler().getShohonNo();
    }

    @Override
    public RString getSenkyoNo() {
        return getHandler().getSenkyoNo();
    }

    @Override
    public ShikibetsuCode getShikibetsuCodeNyujoken() {
        return getHandler().getShikibetsuCodeNyujoken();
    }

    @Override
    public ShikibetsuCode getShikibetsuCodeJuri() {
        return getHandler().getShikibetsuCodeJuri();
    }

    @Override
    public RString getSelectControlIdForBarCode() {
        return this.getTxtBarCode().getSelectControlID();
    }

    @Override
    public Boolean isMatchShohonNo(RString shohonNo) {
        return getHandler().isMatchShohonNo(shohonNo);
    }

    @Override
    public void setBarCodeForNyujoken(RString shohonNo, ShikibetsuCode shikibetsuCode) {
        getHandler().setBarCodeForNyujoken(shohonNo, shikibetsuCode);
    }

//    @Override
//    public HashMap get宛名個人情報(ShikibetsuCode shikibetsuCode) {
//        return getHandler().get宛名個人情報(shikibetsuCode);
//    }
//
    @JsonIgnore
    public BarCodeNyuryokuHandler getHandler() {
        return new BarCodeNyuryokuHandler(this);
    }

    @Override
    public ValidationMessageControlPairs validateバーコード() {
        return new BarCodeNyuryokuValidationHandler(this).validate();
    }

}
