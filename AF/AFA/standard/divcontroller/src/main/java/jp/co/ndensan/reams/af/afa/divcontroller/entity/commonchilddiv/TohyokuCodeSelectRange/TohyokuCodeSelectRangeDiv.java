package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelectRange;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.ITohyokuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.TohyokuCodeSelectDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * TohyokuCodeSelectRange のクラスファイル
 *
 * @author 自動生成
 * @reamsid_L AF-0280-010 lit
 */
public class TohyokuCodeSelectRangeDiv extends Panel implements ITohyokuCodeSelectRangeDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdTohyokuCodeFrom")
    private TohyokuCodeSelectDiv ccdTohyokuCodeFrom;
    @JsonProperty("ccdTohyokuCodeTo")
    private TohyokuCodeSelectDiv ccdTohyokuCodeTo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdTohyokuCodeFrom
     * @return ccdTohyokuCodeFrom
     */
    @JsonProperty("ccdTohyokuCodeFrom")
    public ITohyokuCodeSelectDiv getCcdTohyokuCodeFrom() {
        return ccdTohyokuCodeFrom;
    }

    /*
     * getccdTohyokuCodeTo
     * @return ccdTohyokuCodeTo
     */
    @JsonProperty("ccdTohyokuCodeTo")
    public ITohyokuCodeSelectDiv getCcdTohyokuCodeTo() {
        return ccdTohyokuCodeTo;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(SenkyoShurui senkyoShurui) {
        getHandler().initialize(senkyoShurui);
    }

    @Override
    public void initialize(RString fromCode, RString toCode) {
        getHandler().initialize(fromCode, toCode);
    }

    @Override
    public void clearData() {
        getHandler().clearThisPanel();
    }

    @JsonIgnore
    public TohyokuCodeSelectRangeHandler getHandler() {
        return new TohyokuCodeSelectRangeHandler(this);
    }

    @Override
    public RString get投票区コードFROM() {
        return null != ccdTohyokuCodeFrom ? ccdTohyokuCodeFrom.get投票区コード() : RString.EMPTY;
    }

    /**
     * 投票区コードTOを返す。
     *
     * @return 投票区コードTO
     */
    @Override
    public RString get投票区コードTO() {
        return null != ccdTohyokuCodeTo ? ccdTohyokuCodeTo.get投票区コード() : RString.EMPTY;
    }

    @Override
    public ValidationMessageControlPairs 関係チェック() {
        return getHandler().関係チェック();
    }
}
