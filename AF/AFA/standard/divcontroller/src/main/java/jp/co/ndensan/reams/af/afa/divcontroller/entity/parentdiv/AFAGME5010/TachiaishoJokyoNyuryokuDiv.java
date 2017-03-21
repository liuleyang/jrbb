package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuDairiTohyosha.ITohyorokuDairiTohyoshaDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuDairiTohyosha.TohyorokuDairiTohyoshaDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuKyohiNyuryoku.ITohyorokuKyohiNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuKyohiNyuryoku.TohyorokuKyohiNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuShimeiNyuryoku.ITohyorokuShimeiNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuShimeiNyuryoku.TohyorokuShimeiNyuryokuDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TachiaishoJokyoNyuryoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class TachiaishoJokyoNyuryokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtToha")
    private TextBox txtToha;
    @JsonProperty("txtTachiaininShimei")
    private TextBoxAtenaMeisho txtTachiaininShimei;
    @JsonProperty("txtTachiaiTimeRange")
    private TextBoxTimeRange txtTachiaiTimeRange;
    @JsonProperty("radIjoAriFlag")
    private RadioButton radIjoAriFlag;
    @JsonProperty("txtIjoNaiyo")
    private TextBoxMultiLine txtIjoNaiyo;
    @JsonProperty("spcSpace")
    private Space spcSpace;
    @JsonProperty("lblTachiaishoSaikofusha")
    private Label lblTachiaishoSaikofusha;
    @JsonProperty("dgTachiaishoSaikofusha")
    private DataGrid<dgTachiaishoSaikofusha_Row> dgTachiaishoSaikofusha;
    @JsonProperty("lblTachiaishoKetteisho")
    private Label lblTachiaishoKetteisho;
    @JsonProperty("lblTachiaishoHenkan")
    private Label lblTachiaishoHenkan;
    @JsonProperty("lblTachiaishoTenji")
    private Label lblTachiaishoTenji;
    @JsonProperty("lblTachiaishoDairi")
    private Label lblTachiaishoDairi;
    @JsonProperty("lblTachiaishoKyohiKettei")
    private Label lblTachiaishoKyohiKettei;
    @JsonProperty("ccdTachiaishoKyohiKettei")
    private TohyorokuKyohiNyuryokuDiv ccdTachiaishoKyohiKettei;
    @JsonProperty("ccdTachiaishoTenji")
    private TohyorokuShimeiNyuryokuDiv ccdTachiaishoTenji;
    @JsonProperty("ccdTachiaishoKetteisho")
    private TohyorokuShimeiNyuryokuDiv ccdTachiaishoKetteisho;
    @JsonProperty("ccdTachiaishoDairi")
    private TohyorokuDairiTohyoshaDiv ccdTachiaishoDairi;
    @JsonProperty("ccdTachiaishoHenkan")
    private TohyorokuShimeiNyuryokuDiv ccdTachiaishoHenkan;
    @JsonProperty("hdnTachiaininRenban")
    private RString hdnTachiaininRenban;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtToha
     * @return txtToha
     */
    @JsonProperty("txtToha")
    public TextBox getTxtToha() {
        return txtToha;
    }

    /*
     * settxtToha
     * @param txtToha txtToha
     */
    @JsonProperty("txtToha")
    public void setTxtToha(TextBox txtToha) {
        this.txtToha = txtToha;
    }

    /*
     * gettxtTachiaininShimei
     * @return txtTachiaininShimei
     */
    @JsonProperty("txtTachiaininShimei")
    public TextBoxAtenaMeisho getTxtTachiaininShimei() {
        return txtTachiaininShimei;
    }

    /*
     * settxtTachiaininShimei
     * @param txtTachiaininShimei txtTachiaininShimei
     */
    @JsonProperty("txtTachiaininShimei")
    public void setTxtTachiaininShimei(TextBoxAtenaMeisho txtTachiaininShimei) {
        this.txtTachiaininShimei = txtTachiaininShimei;
    }

    /*
     * gettxtTachiaiTimeRange
     * @return txtTachiaiTimeRange
     */
    @JsonProperty("txtTachiaiTimeRange")
    public TextBoxTimeRange getTxtTachiaiTimeRange() {
        return txtTachiaiTimeRange;
    }

    /*
     * settxtTachiaiTimeRange
     * @param txtTachiaiTimeRange txtTachiaiTimeRange
     */
    @JsonProperty("txtTachiaiTimeRange")
    public void setTxtTachiaiTimeRange(TextBoxTimeRange txtTachiaiTimeRange) {
        this.txtTachiaiTimeRange = txtTachiaiTimeRange;
    }

    /*
     * getradIjoAriFlag
     * @return radIjoAriFlag
     */
    @JsonProperty("radIjoAriFlag")
    public RadioButton getRadIjoAriFlag() {
        return radIjoAriFlag;
    }

    /*
     * setradIjoAriFlag
     * @param radIjoAriFlag radIjoAriFlag
     */
    @JsonProperty("radIjoAriFlag")
    public void setRadIjoAriFlag(RadioButton radIjoAriFlag) {
        this.radIjoAriFlag = radIjoAriFlag;
    }

    /*
     * gettxtIjoNaiyo
     * @return txtIjoNaiyo
     */
    @JsonProperty("txtIjoNaiyo")
    public TextBoxMultiLine getTxtIjoNaiyo() {
        return txtIjoNaiyo;
    }

    /*
     * settxtIjoNaiyo
     * @param txtIjoNaiyo txtIjoNaiyo
     */
    @JsonProperty("txtIjoNaiyo")
    public void setTxtIjoNaiyo(TextBoxMultiLine txtIjoNaiyo) {
        this.txtIjoNaiyo = txtIjoNaiyo;
    }

    /*
     * getspcSpace
     * @return spcSpace
     */
    @JsonProperty("spcSpace")
    public Space getSpcSpace() {
        return spcSpace;
    }

    /*
     * setspcSpace
     * @param spcSpace spcSpace
     */
    @JsonProperty("spcSpace")
    public void setSpcSpace(Space spcSpace) {
        this.spcSpace = spcSpace;
    }

    /*
     * getlblTachiaishoSaikofusha
     * @return lblTachiaishoSaikofusha
     */
    @JsonProperty("lblTachiaishoSaikofusha")
    public Label getLblTachiaishoSaikofusha() {
        return lblTachiaishoSaikofusha;
    }

    /*
     * setlblTachiaishoSaikofusha
     * @param lblTachiaishoSaikofusha lblTachiaishoSaikofusha
     */
    @JsonProperty("lblTachiaishoSaikofusha")
    public void setLblTachiaishoSaikofusha(Label lblTachiaishoSaikofusha) {
        this.lblTachiaishoSaikofusha = lblTachiaishoSaikofusha;
    }

    /*
     * getdgTachiaishoSaikofusha
     * @return dgTachiaishoSaikofusha
     */
    @JsonProperty("dgTachiaishoSaikofusha")
    public DataGrid<dgTachiaishoSaikofusha_Row> getDgTachiaishoSaikofusha() {
        return dgTachiaishoSaikofusha;
    }

    /*
     * setdgTachiaishoSaikofusha
     * @param dgTachiaishoSaikofusha dgTachiaishoSaikofusha
     */
    @JsonProperty("dgTachiaishoSaikofusha")
    public void setDgTachiaishoSaikofusha(DataGrid<dgTachiaishoSaikofusha_Row> dgTachiaishoSaikofusha) {
        this.dgTachiaishoSaikofusha = dgTachiaishoSaikofusha;
    }

    /*
     * getlblTachiaishoKetteisho
     * @return lblTachiaishoKetteisho
     */
    @JsonProperty("lblTachiaishoKetteisho")
    public Label getLblTachiaishoKetteisho() {
        return lblTachiaishoKetteisho;
    }

    /*
     * setlblTachiaishoKetteisho
     * @param lblTachiaishoKetteisho lblTachiaishoKetteisho
     */
    @JsonProperty("lblTachiaishoKetteisho")
    public void setLblTachiaishoKetteisho(Label lblTachiaishoKetteisho) {
        this.lblTachiaishoKetteisho = lblTachiaishoKetteisho;
    }

    /*
     * getlblTachiaishoHenkan
     * @return lblTachiaishoHenkan
     */
    @JsonProperty("lblTachiaishoHenkan")
    public Label getLblTachiaishoHenkan() {
        return lblTachiaishoHenkan;
    }

    /*
     * setlblTachiaishoHenkan
     * @param lblTachiaishoHenkan lblTachiaishoHenkan
     */
    @JsonProperty("lblTachiaishoHenkan")
    public void setLblTachiaishoHenkan(Label lblTachiaishoHenkan) {
        this.lblTachiaishoHenkan = lblTachiaishoHenkan;
    }

    /*
     * getlblTachiaishoTenji
     * @return lblTachiaishoTenji
     */
    @JsonProperty("lblTachiaishoTenji")
    public Label getLblTachiaishoTenji() {
        return lblTachiaishoTenji;
    }

    /*
     * setlblTachiaishoTenji
     * @param lblTachiaishoTenji lblTachiaishoTenji
     */
    @JsonProperty("lblTachiaishoTenji")
    public void setLblTachiaishoTenji(Label lblTachiaishoTenji) {
        this.lblTachiaishoTenji = lblTachiaishoTenji;
    }

    /*
     * getlblTachiaishoDairi
     * @return lblTachiaishoDairi
     */
    @JsonProperty("lblTachiaishoDairi")
    public Label getLblTachiaishoDairi() {
        return lblTachiaishoDairi;
    }

    /*
     * setlblTachiaishoDairi
     * @param lblTachiaishoDairi lblTachiaishoDairi
     */
    @JsonProperty("lblTachiaishoDairi")
    public void setLblTachiaishoDairi(Label lblTachiaishoDairi) {
        this.lblTachiaishoDairi = lblTachiaishoDairi;
    }

    /*
     * getlblTachiaishoKyohiKettei
     * @return lblTachiaishoKyohiKettei
     */
    @JsonProperty("lblTachiaishoKyohiKettei")
    public Label getLblTachiaishoKyohiKettei() {
        return lblTachiaishoKyohiKettei;
    }

    /*
     * setlblTachiaishoKyohiKettei
     * @param lblTachiaishoKyohiKettei lblTachiaishoKyohiKettei
     */
    @JsonProperty("lblTachiaishoKyohiKettei")
    public void setLblTachiaishoKyohiKettei(Label lblTachiaishoKyohiKettei) {
        this.lblTachiaishoKyohiKettei = lblTachiaishoKyohiKettei;
    }

    /*
     * getccdTachiaishoKyohiKettei
     * @return ccdTachiaishoKyohiKettei
     */
    @JsonProperty("ccdTachiaishoKyohiKettei")
    public ITohyorokuKyohiNyuryokuDiv getCcdTachiaishoKyohiKettei() {
        return ccdTachiaishoKyohiKettei;
    }

    /*
     * getccdTachiaishoTenji
     * @return ccdTachiaishoTenji
     */
    @JsonProperty("ccdTachiaishoTenji")
    public ITohyorokuShimeiNyuryokuDiv getCcdTachiaishoTenji() {
        return ccdTachiaishoTenji;
    }

    /*
     * getccdTachiaishoKetteisho
     * @return ccdTachiaishoKetteisho
     */
    @JsonProperty("ccdTachiaishoKetteisho")
    public ITohyorokuShimeiNyuryokuDiv getCcdTachiaishoKetteisho() {
        return ccdTachiaishoKetteisho;
    }

    /*
     * getccdTachiaishoDairi
     * @return ccdTachiaishoDairi
     */
    @JsonProperty("ccdTachiaishoDairi")
    public ITohyorokuDairiTohyoshaDiv getCcdTachiaishoDairi() {
        return ccdTachiaishoDairi;
    }

    /*
     * getccdTachiaishoHenkan
     * @return ccdTachiaishoHenkan
     */
    @JsonProperty("ccdTachiaishoHenkan")
    public ITohyorokuShimeiNyuryokuDiv getCcdTachiaishoHenkan() {
        return ccdTachiaishoHenkan;
    }

    /*
     * gethdnTachiaininRenban
     * @return hdnTachiaininRenban
     */
    @JsonProperty("hdnTachiaininRenban")
    public RString getHdnTachiaininRenban() {
        return hdnTachiaininRenban;
    }

    /*
     * sethdnTachiaininRenban
     * @param hdnTachiaininRenban hdnTachiaininRenban
     */
    @JsonProperty("hdnTachiaininRenban")
    public void setHdnTachiaininRenban(RString hdnTachiaininRenban) {
        this.hdnTachiaininRenban = hdnTachiaininRenban;
    }

    // </editor-fold>
}
