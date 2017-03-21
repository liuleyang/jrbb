package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJokyoNyuryoku;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SeikyuHoho;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.HojoshaNyuryoku.HojoshaNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.HojoshaNyuryoku.IHojoshaNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KyohiJiyuNyuryoku.IKyohiJiyuNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KyohiJiyuNyuryoku.KyohiJiyuNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelect.IShisetsuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelect.ShisetsuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJiyuCode.ITohyoJiyuCodeDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJiyuCode.TohyoJiyuCodeDiv;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;

/**
 * TohyoJokyoNyuryoku のクラスファイル
 *
 * @author 自動生成
 */
public class TohyoJokyoNyuryokuDiv extends Panel implements ITohyoJokyoNyuryokuDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TohyoJokyoSelect")
    private TohyoJokyoSelectDiv TohyoJokyoSelect;
    @JsonProperty("dgTohyoJokyo")
    private DataGrid<dgTohyoJokyo_Row> dgTohyoJokyo;
    @JsonProperty("radSeikyusha")
    private RadioButton radSeikyusha;
    @JsonProperty("txtTohyoYMD")
    private TextBoxDate txtTohyoYMD;
    @JsonProperty("txtTohyoTime")
    private TextBoxTime txtTohyoTime;
    @JsonProperty("ccdTohyoJiyu")
    private TohyoJiyuCodeDiv ccdTohyoJiyu;
    @JsonProperty("chkTenjiYoshi")
    private CheckBoxList chkTenjiYoshi;
    @JsonProperty("ccdKofuShisetsu")
    private ShisetsuCodeSelectDiv ccdKofuShisetsu;
    @JsonProperty("ccdDairiTohyo")
    private HojoshaNyuryokuDiv ccdDairiTohyo;
    @JsonProperty("ccdKyohiJiyuNyuryoku")
    private KyohiJiyuNyuryokuDiv ccdKyohiJiyuNyuryoku;
    @JsonProperty("chkKariTohyo")
    private CheckBoxList chkKariTohyo;
    @JsonProperty("txtHdnShikibetsuCode")
    private RString txtHdnShikibetsuCode;
    @JsonProperty("txtHdnShohonNo")
    private RString txtHdnShohonNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTohyoJokyoSelect
     * @return TohyoJokyoSelect
     */
    @JsonProperty("TohyoJokyoSelect")
    public TohyoJokyoSelectDiv getTohyoJokyoSelect() {
        return TohyoJokyoSelect;
    }

    /*
     * setTohyoJokyoSelect
     * @param TohyoJokyoSelect TohyoJokyoSelect
     */
    @JsonProperty("TohyoJokyoSelect")
    public void setTohyoJokyoSelect(TohyoJokyoSelectDiv TohyoJokyoSelect) {
        this.TohyoJokyoSelect = TohyoJokyoSelect;
    }

    /*
     * getdgTohyoJokyo
     * @return dgTohyoJokyo
     */
    @JsonProperty("dgTohyoJokyo")
    public DataGrid<dgTohyoJokyo_Row> getDgTohyoJokyo() {
        return dgTohyoJokyo;
    }

    /*
     * setdgTohyoJokyo
     * @param dgTohyoJokyo dgTohyoJokyo
     */
    @JsonProperty("dgTohyoJokyo")
    public void setDgTohyoJokyo(DataGrid<dgTohyoJokyo_Row> dgTohyoJokyo) {
        this.dgTohyoJokyo = dgTohyoJokyo;
    }

    /*
     * getradSeikyusha
     * @return radSeikyusha
     */
    @JsonProperty("radSeikyusha")
    public RadioButton getRadSeikyusha() {
        return radSeikyusha;
    }

    /*
     * setradSeikyusha
     * @param radSeikyusha radSeikyusha
     */
    @JsonProperty("radSeikyusha")
    public void setRadSeikyusha(RadioButton radSeikyusha) {
        this.radSeikyusha = radSeikyusha;
    }

    /*
     * gettxtTohyoYMD
     * @return txtTohyoYMD
     */
    @JsonProperty("txtTohyoYMD")
    public TextBoxDate getTxtTohyoYMD() {
        return txtTohyoYMD;
    }

    /*
     * settxtTohyoYMD
     * @param txtTohyoYMD txtTohyoYMD
     */
    @JsonProperty("txtTohyoYMD")
    public void setTxtTohyoYMD(TextBoxDate txtTohyoYMD) {
        this.txtTohyoYMD = txtTohyoYMD;
    }

    /*
     * gettxtTohyoTime
     * @return txtTohyoTime
     */
    @JsonProperty("txtTohyoTime")
    public TextBoxTime getTxtTohyoTime() {
        return txtTohyoTime;
    }

    /*
     * settxtTohyoTime
     * @param txtTohyoTime txtTohyoTime
     */
    @JsonProperty("txtTohyoTime")
    public void setTxtTohyoTime(TextBoxTime txtTohyoTime) {
        this.txtTohyoTime = txtTohyoTime;
    }

    /*
     * getccdTohyoJiyu
     * @return ccdTohyoJiyu
     */
    @JsonProperty("ccdTohyoJiyu")
    public ITohyoJiyuCodeDiv getCcdTohyoJiyu() {
        return ccdTohyoJiyu;
    }

    /*
     * getchkTenjiYoshi
     * @return chkTenjiYoshi
     */
    @JsonProperty("chkTenjiYoshi")
    public CheckBoxList getChkTenjiYoshi() {
        return chkTenjiYoshi;
    }

    /*
     * setchkTenjiYoshi
     * @param chkTenjiYoshi chkTenjiYoshi
     */
    @JsonProperty("chkTenjiYoshi")
    public void setChkTenjiYoshi(CheckBoxList chkTenjiYoshi) {
        this.chkTenjiYoshi = chkTenjiYoshi;
    }

    /*
     * getccdKofuShisetsu
     * @return ccdKofuShisetsu
     */
    @JsonProperty("ccdKofuShisetsu")
    public IShisetsuCodeSelectDiv getCcdKofuShisetsu() {
        return ccdKofuShisetsu;
    }

    /*
     * getccdDairiTohyo
     * @return ccdDairiTohyo
     */
    @JsonProperty("ccdDairiTohyo")
    public IHojoshaNyuryokuDiv getCcdDairiTohyo() {
        return ccdDairiTohyo;
    }

    /*
     * getccdKyohiJiyuNyuryoku
     * @return ccdKyohiJiyuNyuryoku
     */
    @JsonProperty("ccdKyohiJiyuNyuryoku")
    public IKyohiJiyuNyuryokuDiv getCcdKyohiJiyuNyuryoku() {
        return ccdKyohiJiyuNyuryoku;
    }

    /*
     * getchkKariTohyo
     * @return chkKariTohyo
     */
    @JsonProperty("chkKariTohyo")
    public CheckBoxList getChkKariTohyo() {
        return chkKariTohyo;
    }

    /*
     * setchkKariTohyo
     * @param chkKariTohyo chkKariTohyo
     */
    @JsonProperty("chkKariTohyo")
    public void setChkKariTohyo(CheckBoxList chkKariTohyo) {
        this.chkKariTohyo = chkKariTohyo;
    }

    /*
     * gettxtHdnShikibetsuCode
     * @return txtHdnShikibetsuCode
     */
    @JsonProperty("txtHdnShikibetsuCode")
    public RString getTxtHdnShikibetsuCode() {
        return txtHdnShikibetsuCode;
    }

    /*
     * settxtHdnShikibetsuCode
     * @param txtHdnShikibetsuCode txtHdnShikibetsuCode
     */
    @JsonProperty("txtHdnShikibetsuCode")
    public void setTxtHdnShikibetsuCode(RString txtHdnShikibetsuCode) {
        this.txtHdnShikibetsuCode = txtHdnShikibetsuCode;
    }

    /*
     * gettxtHdnShohonNo
     * @return txtHdnShohonNo
     */
    @JsonProperty("txtHdnShohonNo")
    public RString getTxtHdnShohonNo() {
        return txtHdnShohonNo;
    }

    /*
     * settxtHdnShohonNo
     * @param txtHdnShohonNo txtHdnShohonNo
     */
    @JsonProperty("txtHdnShohonNo")
    public void setTxtHdnShohonNo(RString txtHdnShohonNo) {
        this.txtHdnShohonNo = txtHdnShohonNo;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public TohyoJokyo getTohyoKubun() {
        return TohyoJokyo.toValue(this.getTohyoJokyoSelect().getRadTohyoJokyo().getSelectedKey());
    }

    @Override
    public SeikyuHoho getSeikyusha() {
        return SeikyuHoho.toValue(this.getRadSeikyusha().getSelectedKey());
    }

    @Override
    public RDate getTohyoYMD() {
        return this.getTxtTohyoYMD().getValue();
    }

    @Override
    public RTime getTohyoTime() {
        return this.getTxtTohyoTime().getValue();
    }

    @Override
    public Boolean isTenjiTohyo() {
        return (this.getChkTenjiYoshi().getSelectedKeys().isEmpty()) ? Boolean.FALSE : Boolean.TRUE;
    }

    @Override
    public Boolean isKariTohyo() {
        return (this.getChkKariTohyo().getSelectedKeys().isEmpty()) ? Boolean.FALSE : Boolean.TRUE;
    }

    @Override
    public void initialize(SenkyoShurui senkyoShurui, TohyoJokyo tohyoJokyo, RString shohonNo) {
        getHandler().initialize(senkyoShurui, tohyoJokyo, shohonNo);
    }

    @Override
    public void initialize(RString shohonNo, ShikibetsuCode shikibetsuCode, RString tohyokuCode) {
        getHandler().initialize(shohonNo, shikibetsuCode, tohyokuCode);
    }

    @Override
    public void initialize(RString shohonNo, ShikibetsuCode shikibetsuCode, RString tohyokuCode, SenkyoNo 選挙番号) {
        getHandler().initializeBy選挙番号(shohonNo, shikibetsuCode, tohyokuCode, 選挙番号);
    }

    @Override
    public void clearData() {
        getHandler().clearThisPanel();
    }

    @JsonIgnore
    public TohyoJokyoNyuryokuHandler getHandler() {
        return new TohyoJokyoNyuryokuHandler(this);
    }

    @Override
    public void setReadOnlyMode(Boolean readOnlySetMode) {
        getHandler().setReadOnlyMode(readOnlySetMode);
    }

    @Override
    public boolean isSearchAlready() {
        return (this.getDgTohyoJokyo().getDataSource().isEmpty()) ? Boolean.FALSE : Boolean.TRUE;
    }

    @Override
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        getHandler().setShikibetsuCode(shikibetsuCode);
    }

}
