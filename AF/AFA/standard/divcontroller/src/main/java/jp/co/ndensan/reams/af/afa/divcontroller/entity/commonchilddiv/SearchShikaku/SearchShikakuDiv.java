package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchShikaku;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.ITohyokuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.TohyokuCodeSelectDiv;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * SearchShikaku のクラスファイル
 *
 * @author 自動生成
 * @reamsid_L AF-0180-011 liuyj
 */
public class SearchShikakuDiv extends Panel implements ISearchShikakuDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdTohyokuCode")
    private TohyokuCodeSelectDiv ccdTohyokuCode;
    @JsonProperty("chkSearchSenkyoShikaku")
    private CheckBoxList chkSearchSenkyoShikaku;
    @JsonProperty("chkSearchTohyoShikaku")
    private CheckBoxList chkSearchTohyoShikaku;
    @JsonProperty("SearchShikakuShosai")
    private SearchShikakuShosaiDiv SearchShikakuShosai;
    @JsonProperty("txtHdnSenkyoShurui")
    private RString txtHdnSenkyoShurui;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdTohyokuCode
     * @return ccdTohyokuCode
     */
    @JsonProperty("ccdTohyokuCode")
    @Override
    public ITohyokuCodeSelectDiv getCcdTohyokuCode() {
        return ccdTohyokuCode;
    }

    /*
     * getchkSearchSenkyoShikaku
     * @return chkSearchSenkyoShikaku
     */
    @JsonProperty("chkSearchSenkyoShikaku")
    @Override
    public CheckBoxList getChkSearchSenkyoShikaku() {
        return chkSearchSenkyoShikaku;
    }

    /*
     * setchkSearchSenkyoShikaku
     * @param chkSearchSenkyoShikaku chkSearchSenkyoShikaku
     */
    @JsonProperty("chkSearchSenkyoShikaku")
    public void setChkSearchSenkyoShikaku(CheckBoxList chkSearchSenkyoShikaku) {
        this.chkSearchSenkyoShikaku = chkSearchSenkyoShikaku;
    }

    /*
     * getchkSearchTohyoShikaku
     * @return chkSearchTohyoShikaku
     */
    @JsonProperty("chkSearchTohyoShikaku")
    @Override
    public CheckBoxList getChkSearchTohyoShikaku() {
        return chkSearchTohyoShikaku;
    }

    /*
     * setchkSearchTohyoShikaku
     * @param chkSearchTohyoShikaku chkSearchTohyoShikaku
     */
    @JsonProperty("chkSearchTohyoShikaku")
    public void setChkSearchTohyoShikaku(CheckBoxList chkSearchTohyoShikaku) {
        this.chkSearchTohyoShikaku = chkSearchTohyoShikaku;
    }

    /*
     * getSearchShikakuShosai
     * @return SearchShikakuShosai
     */
    @JsonProperty("SearchShikakuShosai")
    public SearchShikakuShosaiDiv getSearchShikakuShosai() {
        return SearchShikakuShosai;
    }

    /*
     * setSearchShikakuShosai
     * @param SearchShikakuShosai SearchShikakuShosai
     */
    @JsonProperty("SearchShikakuShosai")
    public void setSearchShikakuShosai(SearchShikakuShosaiDiv SearchShikakuShosai) {
        this.SearchShikakuShosai = SearchShikakuShosai;
    }

    /*
     * gettxtHdnSenkyoShurui
     * @return txtHdnSenkyoShurui
     */
    @JsonProperty("txtHdnSenkyoShurui")
    public RString getTxtHdnSenkyoShurui() {
        return txtHdnSenkyoShurui;
    }

    /*
     * settxtHdnSenkyoShurui
     * @param txtHdnSenkyoShurui txtHdnSenkyoShurui
     */
    @JsonProperty("txtHdnSenkyoShurui")
    public void setTxtHdnSenkyoShurui(RString txtHdnSenkyoShurui) {
        this.txtHdnSenkyoShurui = txtHdnSenkyoShurui;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(SenkyoShurui senkyoShurui) {
        getHandler().initialize(senkyoShurui);
    }

    @Override
    public void initialize() {
        getHandler().initialize();
    }

    @Override
    public void clearData() {
        getHandler().clearThisPanel();
    }

    @Override
    public ValidationMessageControlPairs 日期大小関係チェック() {
        return getHandler().日期大小関係チェック();
    }

    @Override
    public RString get投票区コード() {
        return getHandler().get投票区コード();
    }

    @Override
    public List<RString> get選挙資格リスト() {
        return getHandler().get選挙資格リスト();
    }

    @Override
    public List<RString> get投票資格リスト() {
        return getHandler().get投票資格リスト();
    }

    @Override
    public FlexibleDate get名簿登録日From() {
        return getHandler().get名簿登録日From();
    }

    @Override
    public FlexibleDate get名簿登録日To() {
        return getHandler().get名簿登録日To();
    }

    @Override
    public FlexibleDate get登録停止日From() {
        return getHandler().get登録停止日From();
    }

    @Override
    public FlexibleDate get登録停止日To() {
        return getHandler().get登録停止日To();
    }

    @Override
    public FlexibleDate get抹消日From() {
        return getHandler().get抹消日From();
    }

    @Override
    public FlexibleDate get抹消日To() {
        return getHandler().get抹消日To();
    }

    @Override
    public FlexibleDate get表示日From() {
        return getHandler().get表示日From();
    }

    @Override
    public FlexibleDate get表示日To() {
        return getHandler().get表示日To();
    }

    @Override
    public FlexibleDate get消除予定日From() {
        return getHandler().get消除予定日From();
    }

    @Override
    public FlexibleDate get消除予定日To() {
        return getHandler().get消除予定日To();
    }

    @Override
    public FlexibleDate get表示消除日From() {
        return getHandler().get表示消除日From();
    }

    @Override
    public FlexibleDate get表示消除日To() {
        return getHandler().get表示消除日To();
    }

    @Override
    public FlexibleDate get刑期終了日From() {
        return getHandler().get刑期終了日From();
    }

    @Override
    public FlexibleDate get刑期終了日To() {
        return getHandler().get刑期終了日To();
    }

    @Override
    public RString get登録事由() {
        return getHandler().get登録事由();
    }

    @Override
    public RString get登録停止事由() {
        return getHandler().get登録停止事由();
    }

    @Override
    public RString get抹消事由() {
        return getHandler().get抹消事由();
    }

    @Override
    public RString get表示事由() {
        return getHandler().get表示事由();
    }

    @Override
    public boolean is2刑持ち() {
        return getHandler().is2刑持ち();
    }

    @JsonIgnore
    public SearchShikakuHandler getHandler() {
        return new SearchShikakuHandler(this);
    }

}
