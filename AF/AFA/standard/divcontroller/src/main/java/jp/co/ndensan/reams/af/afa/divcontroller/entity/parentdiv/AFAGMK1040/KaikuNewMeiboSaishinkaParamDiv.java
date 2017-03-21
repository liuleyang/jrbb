package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1040;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuSakuseiChohyo.IKaikuSakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuSakuseiChohyo.KaikuSakuseiChohyoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * KaikuNewMeiboSaishinkaParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaikuNewMeiboSaishinkaParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KaikuNewShohonSelect")
    private KaikuNewShohonSelectDiv KaikuNewShohonSelect;
    @JsonProperty("KaikuNewJoken")
    private KaikuNewJokenDiv KaikuNewJoken;
    @JsonProperty("ccdKaikuNewSakuseiChohyo")
    private KaikuSakuseiChohyoDiv ccdKaikuNewSakuseiChohyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKaikuNewShohonSelect
     * @return KaikuNewShohonSelect
     */
    @JsonProperty("KaikuNewShohonSelect")
    public KaikuNewShohonSelectDiv getKaikuNewShohonSelect() {
        return KaikuNewShohonSelect;
    }

    /*
     * setKaikuNewShohonSelect
     * @param KaikuNewShohonSelect KaikuNewShohonSelect
     */
    @JsonProperty("KaikuNewShohonSelect")
    public void setKaikuNewShohonSelect(KaikuNewShohonSelectDiv KaikuNewShohonSelect) {
        this.KaikuNewShohonSelect = KaikuNewShohonSelect;
    }

    /*
     * getKaikuNewJoken
     * @return KaikuNewJoken
     */
    @JsonProperty("KaikuNewJoken")
    public KaikuNewJokenDiv getKaikuNewJoken() {
        return KaikuNewJoken;
    }

    /*
     * setKaikuNewJoken
     * @param KaikuNewJoken KaikuNewJoken
     */
    @JsonProperty("KaikuNewJoken")
    public void setKaikuNewJoken(KaikuNewJokenDiv KaikuNewJoken) {
        this.KaikuNewJoken = KaikuNewJoken;
    }

    /*
     * getccdKaikuNewSakuseiChohyo
     * @return ccdKaikuNewSakuseiChohyo
     */
    @JsonProperty("ccdKaikuNewSakuseiChohyo")
    public IKaikuSakuseiChohyoDiv getCcdKaikuNewSakuseiChohyo() {
        return ccdKaikuNewSakuseiChohyo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgKaikuShohonSelect_Row> getDgKaikuShohonSelect() {
        return this.getKaikuNewShohonSelect().getDgKaikuShohonSelect();
    }

    @JsonIgnore
    public void  setDgKaikuShohonSelect(DataGrid<dgKaikuShohonSelect_Row> dgKaikuShohonSelect) {
        this.getKaikuNewShohonSelect().setDgKaikuShohonSelect(dgKaikuShohonSelect);
    }

    @JsonIgnore
    public TextBoxDate getTxtSaishinkaYMD() {
        return this.getKaikuNewJoken().getTxtSaishinkaYMD();
    }

    @JsonIgnore
    public void  setTxtSaishinkaYMD(TextBoxDate txtSaishinkaYMD) {
        this.getKaikuNewJoken().setTxtSaishinkaYMD(txtSaishinkaYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkOnlyPrint() {
        return this.getKaikuNewJoken().getChkOnlyPrint();
    }

    @JsonIgnore
    public void  setChkOnlyPrint(CheckBoxList chkOnlyPrint) {
        this.getKaikuNewJoken().setChkOnlyPrint(chkOnlyPrint);
    }

    @JsonIgnore
    public RadioButton getRadSort() {
        return this.getKaikuNewJoken().getRadSort();
    }

    @JsonIgnore
    public void  setRadSort(RadioButton radSort) {
        this.getKaikuNewJoken().setRadSort(radSort);
    }

    // </editor-fold>
}
