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
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KaikuNewMeiboSaishinka のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaikuNewMeiboSaishinkaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KaikuNewMeiboSaishinkaParam")
    private KaikuNewMeiboSaishinkaParamDiv KaikuNewMeiboSaishinkaParam;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKaikuNewMeiboSaishinkaParam
     * @return KaikuNewMeiboSaishinkaParam
     */
    @JsonProperty("KaikuNewMeiboSaishinkaParam")
    public KaikuNewMeiboSaishinkaParamDiv getKaikuNewMeiboSaishinkaParam() {
        return KaikuNewMeiboSaishinkaParam;
    }

    /*
     * setKaikuNewMeiboSaishinkaParam
     * @param KaikuNewMeiboSaishinkaParam KaikuNewMeiboSaishinkaParam
     */
    @JsonProperty("KaikuNewMeiboSaishinkaParam")
    public void setKaikuNewMeiboSaishinkaParam(KaikuNewMeiboSaishinkaParamDiv KaikuNewMeiboSaishinkaParam) {
        this.KaikuNewMeiboSaishinkaParam = KaikuNewMeiboSaishinkaParam;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public KaikuNewShohonSelectDiv getKaikuNewShohonSelect() {
        return this.getKaikuNewMeiboSaishinkaParam().getKaikuNewShohonSelect();
    }

    @JsonIgnore
    public void  setKaikuNewShohonSelect(KaikuNewShohonSelectDiv KaikuNewShohonSelect) {
        this.getKaikuNewMeiboSaishinkaParam().setKaikuNewShohonSelect(KaikuNewShohonSelect);
    }

    @JsonIgnore
    public DataGrid<dgKaikuShohonSelect_Row> getDgKaikuShohonSelect() {
        return this.getKaikuNewMeiboSaishinkaParam().getKaikuNewShohonSelect().getDgKaikuShohonSelect();
    }

    @JsonIgnore
    public void  setDgKaikuShohonSelect(DataGrid<dgKaikuShohonSelect_Row> dgKaikuShohonSelect) {
        this.getKaikuNewMeiboSaishinkaParam().getKaikuNewShohonSelect().setDgKaikuShohonSelect(dgKaikuShohonSelect);
    }

    @JsonIgnore
    public KaikuNewJokenDiv getKaikuNewJoken() {
        return this.getKaikuNewMeiboSaishinkaParam().getKaikuNewJoken();
    }

    @JsonIgnore
    public void  setKaikuNewJoken(KaikuNewJokenDiv KaikuNewJoken) {
        this.getKaikuNewMeiboSaishinkaParam().setKaikuNewJoken(KaikuNewJoken);
    }

    @JsonIgnore
    public TextBoxDate getTxtSaishinkaYMD() {
        return this.getKaikuNewMeiboSaishinkaParam().getKaikuNewJoken().getTxtSaishinkaYMD();
    }

    @JsonIgnore
    public void  setTxtSaishinkaYMD(TextBoxDate txtSaishinkaYMD) {
        this.getKaikuNewMeiboSaishinkaParam().getKaikuNewJoken().setTxtSaishinkaYMD(txtSaishinkaYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkOnlyPrint() {
        return this.getKaikuNewMeiboSaishinkaParam().getKaikuNewJoken().getChkOnlyPrint();
    }

    @JsonIgnore
    public void  setChkOnlyPrint(CheckBoxList chkOnlyPrint) {
        this.getKaikuNewMeiboSaishinkaParam().getKaikuNewJoken().setChkOnlyPrint(chkOnlyPrint);
    }

    @JsonIgnore
    public RadioButton getRadSort() {
        return this.getKaikuNewMeiboSaishinkaParam().getKaikuNewJoken().getRadSort();
    }

    @JsonIgnore
    public void  setRadSort(RadioButton radSort) {
        this.getKaikuNewMeiboSaishinkaParam().getKaikuNewJoken().setRadSort(radSort);
    }

    @JsonIgnore
    public IKaikuSakuseiChohyoDiv getCcdKaikuNewSakuseiChohyo() {
        return this.getKaikuNewMeiboSaishinkaParam().getCcdKaikuNewSakuseiChohyo();
    }

    // </editor-fold>
}
