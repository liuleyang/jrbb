package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME4010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * MutohyoNyuryoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class MutohyoNyuryokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("MutohyoNyuryokuJoken")
    private MutohyoNyuryokuJokenDiv MutohyoNyuryokuJoken;
    @JsonProperty("MutohyoDataNyuryoku")
    private MutohyoDataNyuryokuDiv MutohyoDataNyuryoku;
    @JsonProperty("JotaiHenkoModel")
    private RString JotaiHenkoModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getMutohyoNyuryokuJoken
     * @return MutohyoNyuryokuJoken
     */
    @JsonProperty("MutohyoNyuryokuJoken")
    public MutohyoNyuryokuJokenDiv getMutohyoNyuryokuJoken() {
        return MutohyoNyuryokuJoken;
    }

    /*
     * setMutohyoNyuryokuJoken
     * @param MutohyoNyuryokuJoken MutohyoNyuryokuJoken
     */
    @JsonProperty("MutohyoNyuryokuJoken")
    public void setMutohyoNyuryokuJoken(MutohyoNyuryokuJokenDiv MutohyoNyuryokuJoken) {
        this.MutohyoNyuryokuJoken = MutohyoNyuryokuJoken;
    }

    /*
     * getMutohyoDataNyuryoku
     * @return MutohyoDataNyuryoku
     */
    @JsonProperty("MutohyoDataNyuryoku")
    public MutohyoDataNyuryokuDiv getMutohyoDataNyuryoku() {
        return MutohyoDataNyuryoku;
    }

    /*
     * setMutohyoDataNyuryoku
     * @param MutohyoDataNyuryoku MutohyoDataNyuryoku
     */
    @JsonProperty("MutohyoDataNyuryoku")
    public void setMutohyoDataNyuryoku(MutohyoDataNyuryokuDiv MutohyoDataNyuryoku) {
        this.MutohyoDataNyuryoku = MutohyoDataNyuryoku;
    }

    /*
     * getJotaiHenkoModel
     * @return JotaiHenkoModel
     */
    @JsonProperty("JotaiHenkoModel")
    public RString getJotaiHenkoModel() {
        return JotaiHenkoModel;
    }

    /*
     * setJotaiHenkoModel
     * @param JotaiHenkoModel JotaiHenkoModel
     */
    @JsonProperty("JotaiHenkoModel")
    public void setJotaiHenkoModel(RString JotaiHenkoModel) {
        this.JotaiHenkoModel = JotaiHenkoModel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblSenkyoRyakuName() {
        return this.getMutohyoDataNyuryoku().getLblSenkyoRyakuName();
    }

    @JsonIgnore
    public void  setLblSenkyoRyakuName(Label lblSenkyoRyakuName) {
        this.getMutohyoDataNyuryoku().setLblSenkyoRyakuName(lblSenkyoRyakuName);
    }

    @JsonIgnore
    public Button getBtnAllOff() {
        return this.getMutohyoDataNyuryoku().getBtnAllOff();
    }

    @JsonIgnore
    public void  setBtnAllOff(Button btnAllOff) {
        this.getMutohyoDataNyuryoku().setBtnAllOff(btnAllOff);
    }

    @JsonIgnore
    public Button getBtnAllOn() {
        return this.getMutohyoDataNyuryoku().getBtnAllOn();
    }

    @JsonIgnore
    public void  setBtnAllOn(Button btnAllOn) {
        this.getMutohyoDataNyuryoku().setBtnAllOn(btnAllOn);
    }

    @JsonIgnore
    public Label getLblCheckNaiyo() {
        return this.getMutohyoDataNyuryoku().getLblCheckNaiyo();
    }

    @JsonIgnore
    public void  setLblCheckNaiyo(Label lblCheckNaiyo) {
        this.getMutohyoDataNyuryoku().setLblCheckNaiyo(lblCheckNaiyo);
    }

    @JsonIgnore
    public DataGrid<dgMutohyoData_Row> getDgMutohyoData() {
        return this.getMutohyoDataNyuryoku().getDgMutohyoData();
    }

    @JsonIgnore
    public void  setDgMutohyoData(DataGrid<dgMutohyoData_Row> dgMutohyoData) {
        this.getMutohyoDataNyuryoku().setDgMutohyoData(dgMutohyoData);
    }

    @JsonIgnore
    public ChangePageDiv getChangePage() {
        return this.getMutohyoDataNyuryoku().getChangePage();
    }

    @JsonIgnore
    public void  setChangePage(ChangePageDiv ChangePage) {
        this.getMutohyoDataNyuryoku().setChangePage(ChangePage);
    }

    @JsonIgnore
    public Button getBtnBefore() {
        return this.getMutohyoDataNyuryoku().getChangePage().getBtnBefore();
    }

    @JsonIgnore
    public void  setBtnBefore(Button btnBefore) {
        this.getMutohyoDataNyuryoku().getChangePage().setBtnBefore(btnBefore);
    }

    @JsonIgnore
    public Button getBtnAfter() {
        return this.getMutohyoDataNyuryoku().getChangePage().getBtnAfter();
    }

    @JsonIgnore
    public void  setBtnAfter(Button btnAfter) {
        this.getMutohyoDataNyuryoku().getChangePage().setBtnAfter(btnAfter);
    }

    // </editor-fold>
}
