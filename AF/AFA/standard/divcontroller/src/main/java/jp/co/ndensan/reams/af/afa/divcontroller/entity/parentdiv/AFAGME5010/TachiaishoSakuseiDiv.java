package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuDairiTohyosha.ITohyorokuDairiTohyoshaDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuDairiTohyosha.TohyorokuDairiTohyoshaDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuKyohiNyuryoku.ITohyorokuKyohiNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuKyohiNyuryoku.TohyorokuKyohiNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuShimeiNyuryoku.ITohyorokuShimeiNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuShimeiNyuryoku.TohyorokuShimeiNyuryokuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TachiaishoSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class TachiaishoSakuseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TachiaishoJoken")
    private TachiaishoJokenDiv TachiaishoJoken;
    @JsonProperty("TachiaishoTachiainin")
    private TachiaishoTachiaininDiv TachiaishoTachiainin;
    @JsonProperty("TachiaishoJokyoNyuryoku")
    private TachiaishoJokyoNyuryokuDiv TachiaishoJokyoNyuryoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTachiaishoJoken
     * @return TachiaishoJoken
     */
    @JsonProperty("TachiaishoJoken")
    public TachiaishoJokenDiv getTachiaishoJoken() {
        return TachiaishoJoken;
    }

    /*
     * setTachiaishoJoken
     * @param TachiaishoJoken TachiaishoJoken
     */
    @JsonProperty("TachiaishoJoken")
    public void setTachiaishoJoken(TachiaishoJokenDiv TachiaishoJoken) {
        this.TachiaishoJoken = TachiaishoJoken;
    }

    /*
     * getTachiaishoTachiainin
     * @return TachiaishoTachiainin
     */
    @JsonProperty("TachiaishoTachiainin")
    public TachiaishoTachiaininDiv getTachiaishoTachiainin() {
        return TachiaishoTachiainin;
    }

    /*
     * setTachiaishoTachiainin
     * @param TachiaishoTachiainin TachiaishoTachiainin
     */
    @JsonProperty("TachiaishoTachiainin")
    public void setTachiaishoTachiainin(TachiaishoTachiaininDiv TachiaishoTachiainin) {
        this.TachiaishoTachiainin = TachiaishoTachiainin;
    }

    /*
     * getTachiaishoJokyoNyuryoku
     * @return TachiaishoJokyoNyuryoku
     */
    @JsonProperty("TachiaishoJokyoNyuryoku")
    public TachiaishoJokyoNyuryokuDiv getTachiaishoJokyoNyuryoku() {
        return TachiaishoJokyoNyuryoku;
    }

    /*
     * setTachiaishoJokyoNyuryoku
     * @param TachiaishoJokyoNyuryoku TachiaishoJokyoNyuryoku
     */
    @JsonProperty("TachiaishoJokyoNyuryoku")
    public void setTachiaishoJokyoNyuryoku(TachiaishoJokyoNyuryokuDiv TachiaishoJokyoNyuryoku) {
        this.TachiaishoJokyoNyuryoku = TachiaishoJokyoNyuryoku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtTohyoYMDJoken() {
        return this.getTachiaishoJoken().getTxtTohyoYMDJoken();
    }

    @JsonIgnore
    public void  setTxtTohyoYMDJoken(TextBoxDate txtTohyoYMDJoken) {
        this.getTachiaishoJoken().setTxtTohyoYMDJoken(txtTohyoYMDJoken);
    }

    @JsonIgnore
    public DropDownList getDdlSenkyoName() {
        return this.getTachiaishoJoken().getDdlSenkyoName();
    }

    @JsonIgnore
    public void  setDdlSenkyoName(DropDownList ddlSenkyoName) {
        this.getTachiaishoJoken().setDdlSenkyoName(ddlSenkyoName);
    }

    @JsonIgnore
    public DropDownList getDdlShisetsu() {
        return this.getTachiaishoJoken().getDdlShisetsu();
    }

    @JsonIgnore
    public void  setDdlShisetsu(DropDownList ddlShisetsu) {
        this.getTachiaishoJoken().setDdlShisetsu(ddlShisetsu);
    }

    @JsonIgnore
    public Button getBtnSearch() {
        return this.getTachiaishoJoken().getBtnSearch();
    }

    @JsonIgnore
    public void  setBtnSearch(Button btnSearch) {
        this.getTachiaishoJoken().setBtnSearch(btnSearch);
    }

    @JsonIgnore
    public IShohonNameListDiv getCcdShohonNameList() {
        return this.getTachiaishoJoken().getCcdShohonNameList();
    }

    @JsonIgnore
    public DataGrid<dgTachiaishoTachiainin_Row> getDgTachiaishoTachiainin() {
        return this.getTachiaishoTachiainin().getDgTachiaishoTachiainin();
    }

    @JsonIgnore
    public void  setDgTachiaishoTachiainin(DataGrid<dgTachiaishoTachiainin_Row> dgTachiaishoTachiainin) {
        this.getTachiaishoTachiainin().setDgTachiaishoTachiainin(dgTachiaishoTachiainin);
    }

    @JsonIgnore
    public Button getBtnAddNew() {
        return this.getTachiaishoTachiainin().getBtnAddNew();
    }

    @JsonIgnore
    public void  setBtnAddNew(Button btnAddNew) {
        this.getTachiaishoTachiainin().setBtnAddNew(btnAddNew);
    }

    @JsonIgnore
    public TextBox getTxtToha() {
        return this.getTachiaishoJokyoNyuryoku().getTxtToha();
    }

    @JsonIgnore
    public void  setTxtToha(TextBox txtToha) {
        this.getTachiaishoJokyoNyuryoku().setTxtToha(txtToha);
    }

    @JsonIgnore
    public TextBoxAtenaMeisho getTxtTachiaininShimei() {
        return this.getTachiaishoJokyoNyuryoku().getTxtTachiaininShimei();
    }

    @JsonIgnore
    public void  setTxtTachiaininShimei(TextBoxAtenaMeisho txtTachiaininShimei) {
        this.getTachiaishoJokyoNyuryoku().setTxtTachiaininShimei(txtTachiaininShimei);
    }

    @JsonIgnore
    public TextBoxTimeRange getTxtTachiaiTimeRange() {
        return this.getTachiaishoJokyoNyuryoku().getTxtTachiaiTimeRange();
    }

    @JsonIgnore
    public void  setTxtTachiaiTimeRange(TextBoxTimeRange txtTachiaiTimeRange) {
        this.getTachiaishoJokyoNyuryoku().setTxtTachiaiTimeRange(txtTachiaiTimeRange);
    }

    @JsonIgnore
    public RadioButton getRadIjoAriFlag() {
        return this.getTachiaishoJokyoNyuryoku().getRadIjoAriFlag();
    }

    @JsonIgnore
    public void  setRadIjoAriFlag(RadioButton radIjoAriFlag) {
        this.getTachiaishoJokyoNyuryoku().setRadIjoAriFlag(radIjoAriFlag);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtIjoNaiyo() {
        return this.getTachiaishoJokyoNyuryoku().getTxtIjoNaiyo();
    }

    @JsonIgnore
    public void  setTxtIjoNaiyo(TextBoxMultiLine txtIjoNaiyo) {
        this.getTachiaishoJokyoNyuryoku().setTxtIjoNaiyo(txtIjoNaiyo);
    }

    @JsonIgnore
    public Space getSpcSpace() {
        return this.getTachiaishoJokyoNyuryoku().getSpcSpace();
    }

    @JsonIgnore
    public void  setSpcSpace(Space spcSpace) {
        this.getTachiaishoJokyoNyuryoku().setSpcSpace(spcSpace);
    }

    @JsonIgnore
    public Label getLblTachiaishoSaikofusha() {
        return this.getTachiaishoJokyoNyuryoku().getLblTachiaishoSaikofusha();
    }

    @JsonIgnore
    public void  setLblTachiaishoSaikofusha(Label lblTachiaishoSaikofusha) {
        this.getTachiaishoJokyoNyuryoku().setLblTachiaishoSaikofusha(lblTachiaishoSaikofusha);
    }

    @JsonIgnore
    public DataGrid<dgTachiaishoSaikofusha_Row> getDgTachiaishoSaikofusha() {
        return this.getTachiaishoJokyoNyuryoku().getDgTachiaishoSaikofusha();
    }

    @JsonIgnore
    public void  setDgTachiaishoSaikofusha(DataGrid<dgTachiaishoSaikofusha_Row> dgTachiaishoSaikofusha) {
        this.getTachiaishoJokyoNyuryoku().setDgTachiaishoSaikofusha(dgTachiaishoSaikofusha);
    }

    @JsonIgnore
    public Label getLblTachiaishoKetteisho() {
        return this.getTachiaishoJokyoNyuryoku().getLblTachiaishoKetteisho();
    }

    @JsonIgnore
    public void  setLblTachiaishoKetteisho(Label lblTachiaishoKetteisho) {
        this.getTachiaishoJokyoNyuryoku().setLblTachiaishoKetteisho(lblTachiaishoKetteisho);
    }

    @JsonIgnore
    public Label getLblTachiaishoHenkan() {
        return this.getTachiaishoJokyoNyuryoku().getLblTachiaishoHenkan();
    }

    @JsonIgnore
    public void  setLblTachiaishoHenkan(Label lblTachiaishoHenkan) {
        this.getTachiaishoJokyoNyuryoku().setLblTachiaishoHenkan(lblTachiaishoHenkan);
    }

    @JsonIgnore
    public Label getLblTachiaishoTenji() {
        return this.getTachiaishoJokyoNyuryoku().getLblTachiaishoTenji();
    }

    @JsonIgnore
    public void  setLblTachiaishoTenji(Label lblTachiaishoTenji) {
        this.getTachiaishoJokyoNyuryoku().setLblTachiaishoTenji(lblTachiaishoTenji);
    }

    @JsonIgnore
    public Label getLblTachiaishoDairi() {
        return this.getTachiaishoJokyoNyuryoku().getLblTachiaishoDairi();
    }

    @JsonIgnore
    public void  setLblTachiaishoDairi(Label lblTachiaishoDairi) {
        this.getTachiaishoJokyoNyuryoku().setLblTachiaishoDairi(lblTachiaishoDairi);
    }

    @JsonIgnore
    public Label getLblTachiaishoKyohiKettei() {
        return this.getTachiaishoJokyoNyuryoku().getLblTachiaishoKyohiKettei();
    }

    @JsonIgnore
    public void  setLblTachiaishoKyohiKettei(Label lblTachiaishoKyohiKettei) {
        this.getTachiaishoJokyoNyuryoku().setLblTachiaishoKyohiKettei(lblTachiaishoKyohiKettei);
    }

    @JsonIgnore
    public ITohyorokuKyohiNyuryokuDiv getCcdTachiaishoKyohiKettei() {
        return this.getTachiaishoJokyoNyuryoku().getCcdTachiaishoKyohiKettei();
    }

    @JsonIgnore
    public ITohyorokuShimeiNyuryokuDiv getCcdTachiaishoTenji() {
        return this.getTachiaishoJokyoNyuryoku().getCcdTachiaishoTenji();
    }

    @JsonIgnore
    public ITohyorokuShimeiNyuryokuDiv getCcdTachiaishoKetteisho() {
        return this.getTachiaishoJokyoNyuryoku().getCcdTachiaishoKetteisho();
    }

    @JsonIgnore
    public ITohyorokuDairiTohyoshaDiv getCcdTachiaishoDairi() {
        return this.getTachiaishoJokyoNyuryoku().getCcdTachiaishoDairi();
    }

    @JsonIgnore
    public ITohyorokuShimeiNyuryokuDiv getCcdTachiaishoHenkan() {
        return this.getTachiaishoJokyoNyuryoku().getCcdTachiaishoHenkan();
    }

    // </editor-fold>
}
