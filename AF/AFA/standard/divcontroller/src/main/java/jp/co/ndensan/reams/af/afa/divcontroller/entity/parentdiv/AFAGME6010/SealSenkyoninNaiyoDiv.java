package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME6010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.AtenaSealLayout.AtenaSealLayoutDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.AtenaSealLayout.IAtenaSealLayoutDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SealSenkyoninNaiyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class SealSenkyoninNaiyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radJusho")
    private RadioButton radJusho;
    @JsonProperty("chkSetainushi")
    private CheckBoxList chkSetainushi;
    @JsonProperty("ccdSealLayout")
    private AtenaSealLayoutDiv ccdSealLayout;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradJusho
     * @return radJusho
     */
    @JsonProperty("radJusho")
    public RadioButton getRadJusho() {
        return radJusho;
    }

    /*
     * setradJusho
     * @param radJusho radJusho
     */
    @JsonProperty("radJusho")
    public void setRadJusho(RadioButton radJusho) {
        this.radJusho = radJusho;
    }

    /*
     * getchkSetainushi
     * @return chkSetainushi
     */
    @JsonProperty("chkSetainushi")
    public CheckBoxList getChkSetainushi() {
        return chkSetainushi;
    }

    /*
     * setchkSetainushi
     * @param chkSetainushi chkSetainushi
     */
    @JsonProperty("chkSetainushi")
    public void setChkSetainushi(CheckBoxList chkSetainushi) {
        this.chkSetainushi = chkSetainushi;
    }

    /*
     * getccdSealLayout
     * @return ccdSealLayout
     */
    @JsonProperty("ccdSealLayout")
    public IAtenaSealLayoutDiv getCcdSealLayout() {
        return ccdSealLayout;
    }

    // </editor-fold>
}
