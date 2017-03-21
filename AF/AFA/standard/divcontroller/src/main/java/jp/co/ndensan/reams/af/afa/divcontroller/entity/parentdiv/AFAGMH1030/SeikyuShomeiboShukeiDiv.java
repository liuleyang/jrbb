package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1030;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SeikyuShomeiboShukei のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeikyuShomeiboShukeiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabSeikyuShomeiboShukei")
    private tabSeikyuShomeiboShukeiDiv tabSeikyuShomeiboShukei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettabSeikyuShomeiboShukei
     * @return tabSeikyuShomeiboShukei
     */
    @JsonProperty("tabSeikyuShomeiboShukei")
    public tabSeikyuShomeiboShukeiDiv getTabSeikyuShomeiboShukei() {
        return tabSeikyuShomeiboShukei;
    }

    /*
     * settabSeikyuShomeiboShukei
     * @param tabSeikyuShomeiboShukei tabSeikyuShomeiboShukei
     */
    @JsonProperty("tabSeikyuShomeiboShukei")
    public void setTabSeikyuShomeiboShukei(tabSeikyuShomeiboShukeiDiv tabSeikyuShomeiboShukei) {
        this.tabSeikyuShomeiboShukei = tabSeikyuShomeiboShukei;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tplSeikyuShomeiboShukeiKensuTohyokuDiv getTplSeikyuShomeiboShukeiKensuTohyoku() {
        return this.getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiKensuTohyoku();
    }

    @JsonIgnore
    public void  setTplSeikyuShomeiboShukeiKensuTohyoku(tplSeikyuShomeiboShukeiKensuTohyokuDiv tplSeikyuShomeiboShukeiKensuTohyoku) {
        this.getTabSeikyuShomeiboShukei().setTplSeikyuShomeiboShukeiKensuTohyoku(tplSeikyuShomeiboShukeiKensuTohyoku);
    }

    @JsonIgnore
    public DataGrid<dgSeikyuShomeiboShukeiKensuTohyoku_Row> getDgSeikyuShomeiboShukeiKensuTohyoku() {
        return this.getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiKensuTohyoku().getDgSeikyuShomeiboShukeiKensuTohyoku();
    }

    @JsonIgnore
    public void  setDgSeikyuShomeiboShukeiKensuTohyoku(DataGrid<dgSeikyuShomeiboShukeiKensuTohyoku_Row> dgSeikyuShomeiboShukeiKensuTohyoku) {
        this.getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiKensuTohyoku().setDgSeikyuShomeiboShukeiKensuTohyoku(dgSeikyuShomeiboShukeiKensuTohyoku);
    }

    @JsonIgnore
    public tplSeikyuShomeiboShukeiKensuJushoDiv getTplSeikyuShomeiboShukeiKensuJusho() {
        return this.getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiKensuJusho();
    }

    @JsonIgnore
    public void  setTplSeikyuShomeiboShukeiKensuJusho(tplSeikyuShomeiboShukeiKensuJushoDiv tplSeikyuShomeiboShukeiKensuJusho) {
        this.getTabSeikyuShomeiboShukei().setTplSeikyuShomeiboShukeiKensuJusho(tplSeikyuShomeiboShukeiKensuJusho);
    }

    @JsonIgnore
    public DataGrid<dgSeikyuShomeiboShukeiKensuJusho_Row> getDgSeikyuShomeiboShukeiKensuJusho() {
        return this.getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiKensuJusho().getDgSeikyuShomeiboShukeiKensuJusho();
    }

    @JsonIgnore
    public void  setDgSeikyuShomeiboShukeiKensuJusho(DataGrid<dgSeikyuShomeiboShukeiKensuJusho_Row> dgSeikyuShomeiboShukeiKensuJusho) {
        this.getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiKensuJusho().setDgSeikyuShomeiboShukeiKensuJusho(dgSeikyuShomeiboShukeiKensuJusho);
    }

    @JsonIgnore
    public tplSeikyuShomeiboShukeiMukoTohyokuDiv getTplSeikyuShomeiboShukeiMukoTohyoku() {
        return this.getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiMukoTohyoku();
    }

    @JsonIgnore
    public void  setTplSeikyuShomeiboShukeiMukoTohyoku(tplSeikyuShomeiboShukeiMukoTohyokuDiv tplSeikyuShomeiboShukeiMukoTohyoku) {
        this.getTabSeikyuShomeiboShukei().setTplSeikyuShomeiboShukeiMukoTohyoku(tplSeikyuShomeiboShukeiMukoTohyoku);
    }

    @JsonIgnore
    public DataGrid<dgSeikyuShomeiboShukeiMukoTohyoku_Row> getDgSeikyuShomeiboShukeiMukoTohyoku() {
        return this.getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiMukoTohyoku().getDgSeikyuShomeiboShukeiMukoTohyoku();
    }

    @JsonIgnore
    public void  setDgSeikyuShomeiboShukeiMukoTohyoku(DataGrid<dgSeikyuShomeiboShukeiMukoTohyoku_Row> dgSeikyuShomeiboShukeiMukoTohyoku) {
        this.getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiMukoTohyoku().setDgSeikyuShomeiboShukeiMukoTohyoku(dgSeikyuShomeiboShukeiMukoTohyoku);
    }

    @JsonIgnore
    public tplSeikyuShomeiboShukeiMukoJushoDiv getTplSeikyuShomeiboShukeiMukoJusho() {
        return this.getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiMukoJusho();
    }

    @JsonIgnore
    public void  setTplSeikyuShomeiboShukeiMukoJusho(tplSeikyuShomeiboShukeiMukoJushoDiv tplSeikyuShomeiboShukeiMukoJusho) {
        this.getTabSeikyuShomeiboShukei().setTplSeikyuShomeiboShukeiMukoJusho(tplSeikyuShomeiboShukeiMukoJusho);
    }

    @JsonIgnore
    public DataGrid<dgSeikyuShomeiboShukeiMukoJusho_Row> getDgSeikyuShomeiboShukeiMukoJusho() {
        return this.getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiMukoJusho().getDgSeikyuShomeiboShukeiMukoJusho();
    }

    @JsonIgnore
    public void  setDgSeikyuShomeiboShukeiMukoJusho(DataGrid<dgSeikyuShomeiboShukeiMukoJusho_Row> dgSeikyuShomeiboShukeiMukoJusho) {
        this.getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiMukoJusho().setDgSeikyuShomeiboShukeiMukoJusho(dgSeikyuShomeiboShukeiMukoJusho);
    }

    @JsonIgnore
    public tplSeikyuShomeiboShukeiNenreiDiv getTplSeikyuShomeiboShukeiNenrei() {
        return this.getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiNenrei();
    }

    @JsonIgnore
    public void  setTplSeikyuShomeiboShukeiNenrei(tplSeikyuShomeiboShukeiNenreiDiv tplSeikyuShomeiboShukeiNenrei) {
        this.getTabSeikyuShomeiboShukei().setTplSeikyuShomeiboShukeiNenrei(tplSeikyuShomeiboShukeiNenrei);
    }

    @JsonIgnore
    public DataGrid<dgSeikyuShomeiboShukeiNenrei_Row> getDgSeikyuShomeiboShukeiNenrei() {
        return this.getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiNenrei().getDgSeikyuShomeiboShukeiNenrei();
    }

    @JsonIgnore
    public void  setDgSeikyuShomeiboShukeiNenrei(DataGrid<dgSeikyuShomeiboShukeiNenrei_Row> dgSeikyuShomeiboShukeiNenrei) {
        this.getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiNenrei().setDgSeikyuShomeiboShukeiNenrei(dgSeikyuShomeiboShukeiNenrei);
    }

    @JsonIgnore
    public tplSeikyuShomeiboShukeiNendaiDiv getTplSeikyuShomeiboShukeiNendai() {
        return this.getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiNendai();
    }

    @JsonIgnore
    public void  setTplSeikyuShomeiboShukeiNendai(tplSeikyuShomeiboShukeiNendaiDiv tplSeikyuShomeiboShukeiNendai) {
        this.getTabSeikyuShomeiboShukei().setTplSeikyuShomeiboShukeiNendai(tplSeikyuShomeiboShukeiNendai);
    }

    @JsonIgnore
    public DataGrid<dgSeikyuShomeiboShukeiNendai_Row> getDgSeikyuShomeiboShukeiNendai() {
        return this.getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiNendai().getDgSeikyuShomeiboShukeiNendai();
    }

    @JsonIgnore
    public void  setDgSeikyuShomeiboShukeiNendai(DataGrid<dgSeikyuShomeiboShukeiNendai_Row> dgSeikyuShomeiboShukeiNendai) {
        this.getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiNendai().setDgSeikyuShomeiboShukeiNendai(dgSeikyuShomeiboShukeiNendai);
    }

    // </editor-fold>
}
