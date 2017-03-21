package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelectRange;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelect.IShisetsuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelect.ShisetsuCodeSelectDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShisetsuShubetsu;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * ShisetsuCodeSelectRange のクラスファイル
 *
 * @author 自動生成
 * @reamsid_L AF-0280-010 lit
 */
public class ShisetsuCodeSelectRangeDiv extends Panel implements IShisetsuCodeSelectRangeDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdShisetsuCodeFrom")
    private ShisetsuCodeSelectDiv ccdShisetsuCodeFrom;
    @JsonProperty("ccdShisetsuCodeTo")
    private ShisetsuCodeSelectDiv ccdShisetsuCodeTo;
    @JsonProperty("btnHiddenFrom")
    private Button btnHiddenFrom;
    @JsonProperty("btnHiddenTo")
    private Button btnHiddenTo;
    @JsonProperty("btnHiddenOKCloseFrom")
    private Button btnHiddenOKCloseFrom;
    @JsonProperty("btnHiddenOKCloseTo")
    private Button btnHiddenOKCloseTo;
    @JsonProperty("txthidShisetsuNameFrom")
    private RString txthidShisetsuNameFrom;
    @JsonProperty("txthidShisetsuNameTo")
    private RString txthidShisetsuNameTo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdShisetsuCodeFrom
     * @return ccdShisetsuCodeFrom
     */
    @JsonProperty("ccdShisetsuCodeFrom")
    public IShisetsuCodeSelectDiv getCcdShisetsuCodeFrom() {
        return ccdShisetsuCodeFrom;
    }

    /*
     * getccdShisetsuCodeTo
     * @return ccdShisetsuCodeTo
     */
    @JsonProperty("ccdShisetsuCodeTo")
    public IShisetsuCodeSelectDiv getCcdShisetsuCodeTo() {
        return ccdShisetsuCodeTo;
    }

    /*
     * getbtnHiddenFrom
     * @return btnHiddenFrom
     */
    @JsonProperty("btnHiddenFrom")
    public Button getBtnHiddenFrom() {
        return btnHiddenFrom;
    }

    /*
     * setbtnHiddenFrom
     * @param btnHiddenFrom btnHiddenFrom
     */
    @JsonProperty("btnHiddenFrom")
    public void setBtnHiddenFrom(Button btnHiddenFrom) {
        this.btnHiddenFrom = btnHiddenFrom;
    }

    /*
     * getbtnHiddenTo
     * @return btnHiddenTo
     */
    @JsonProperty("btnHiddenTo")
    public Button getBtnHiddenTo() {
        return btnHiddenTo;
    }

    /*
     * setbtnHiddenTo
     * @param btnHiddenTo btnHiddenTo
     */
    @JsonProperty("btnHiddenTo")
    public void setBtnHiddenTo(Button btnHiddenTo) {
        this.btnHiddenTo = btnHiddenTo;
    }

    /*
     * getbtnHiddenOKCloseFrom
     * @return btnHiddenOKCloseFrom
     */
    @JsonProperty("btnHiddenOKCloseFrom")
    public Button getBtnHiddenOKCloseFrom() {
        return btnHiddenOKCloseFrom;
    }

    /*
     * setbtnHiddenOKCloseFrom
     * @param btnHiddenOKCloseFrom btnHiddenOKCloseFrom
     */
    @JsonProperty("btnHiddenOKCloseFrom")
    public void setBtnHiddenOKCloseFrom(Button btnHiddenOKCloseFrom) {
        this.btnHiddenOKCloseFrom = btnHiddenOKCloseFrom;
    }

    /*
     * getbtnHiddenOKCloseTo
     * @return btnHiddenOKCloseTo
     */
    @JsonProperty("btnHiddenOKCloseTo")
    public Button getBtnHiddenOKCloseTo() {
        return btnHiddenOKCloseTo;
    }

    /*
     * setbtnHiddenOKCloseTo
     * @param btnHiddenOKCloseTo btnHiddenOKCloseTo
     */
    @JsonProperty("btnHiddenOKCloseTo")
    public void setBtnHiddenOKCloseTo(Button btnHiddenOKCloseTo) {
        this.btnHiddenOKCloseTo = btnHiddenOKCloseTo;
    }

    /*
     * gettxthidShisetsuNameFrom
     * @return txthidShisetsuNameFrom
     */
    @JsonProperty("txthidShisetsuNameFrom")
    public RString getTxthidShisetsuNameFrom() {
        return txthidShisetsuNameFrom;
    }

    /*
     * settxthidShisetsuNameFrom
     * @param txthidShisetsuNameFrom txthidShisetsuNameFrom
     */
    @JsonProperty("txthidShisetsuNameFrom")
    public void setTxthidShisetsuNameFrom(RString txthidShisetsuNameFrom) {
        this.txthidShisetsuNameFrom = txthidShisetsuNameFrom;
    }

    /*
     * gettxthidShisetsuNameTo
     * @return txthidShisetsuNameTo
     */
    @JsonProperty("txthidShisetsuNameTo")
    public RString getTxthidShisetsuNameTo() {
        return txthidShisetsuNameTo;
    }

    /*
     * settxthidShisetsuNameTo
     * @param txthidShisetsuNameTo txthidShisetsuNameTo
     */
    @JsonProperty("txthidShisetsuNameTo")
    public void setTxthidShisetsuNameTo(RString txthidShisetsuNameTo) {
        this.txthidShisetsuNameTo = txthidShisetsuNameTo;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize() {
        getHandler().initialize();
    }

    @Override
    public void initialize(RString fromCode, RString toCode, ShisetsuShubetsu 施設種別) {
        getHandler().initialize(fromCode, toCode, 施設種別);
    }

    @Override
    public void clearData() {
        getHandler().clearThisPanel();
    }

    @JsonIgnore
    public ShisetsuCodeSelectRangeHandler getHandler() {
        return new ShisetsuCodeSelectRangeHandler(this);
    }

    @Override
    public RString get施設コードFROM() {
        return null == ccdShisetsuCodeFrom ? RString.EMPTY : ccdShisetsuCodeFrom.get施設コード();
    }

    @Override
    public RString get施設コードTO() {
        return null == ccdShisetsuCodeTo ? RString.EMPTY : ccdShisetsuCodeTo.get施設コード();
    }

    @Override
    public RString get施設名称From() {
        return getHandler().get施設名称From();
    }

    @Override
    public RString get施設名称To() {
        return getHandler().get施設名称To();
    }

    @Override
    public ValidationMessageControlPairs 関係チェック() {
        return getHandler().関係チェック();
    }
}
