package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyoPrintNaiyo.ISakuseiChohyoPrintNaiyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyoPrintNaiyo.SakuseiChohyoPrintNaiyoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
public class SakuseiChohyoNijuChosahyoDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdPrintNaiyoNijuChosa")
    private SakuseiChohyoPrintNaiyoDiv ccdPrintNaiyoNijuChosa;
    @JsonProperty("txtTenshutsuKikan")
    private TextBoxDateRange txtTenshutsuKikan;
    @JsonProperty("chkSealNijuChosahyo")
    private CheckBoxList chkSealNijuChosahyo;
    @JsonProperty("chkNijuChosahyoIchiran")
    private CheckBoxList chkNijuChosahyoIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdPrintNaiyoNijuChosa
     * @return ccdPrintNaiyoNijuChosa
     */
    @JsonProperty("ccdPrintNaiyoNijuChosa")
    public ISakuseiChohyoPrintNaiyoDiv getCcdPrintNaiyoNijuChosa() {
        return ccdPrintNaiyoNijuChosa;
    }

    /*
     * gettxtTenshutsuKikan
     * @return txtTenshutsuKikan
     */
    @JsonProperty("txtTenshutsuKikan")
    public TextBoxDateRange getTxtTenshutsuKikan() {
        return txtTenshutsuKikan;
    }

    /*
     * settxtTenshutsuKikan
     * @param txtTenshutsuKikan txtTenshutsuKikan
     */
    @JsonProperty("txtTenshutsuKikan")
    public void setTxtTenshutsuKikan(TextBoxDateRange txtTenshutsuKikan) {
        this.txtTenshutsuKikan = txtTenshutsuKikan;
    }

    /*
     * getchkSealNijuChosahyo
     * @return chkSealNijuChosahyo
     */
    @JsonProperty("chkSealNijuChosahyo")
    public CheckBoxList getChkSealNijuChosahyo() {
        return chkSealNijuChosahyo;
    }

    /*
     * setchkSealNijuChosahyo
     * @param chkSealNijuChosahyo chkSealNijuChosahyo
     */
    @JsonProperty("chkSealNijuChosahyo")
    public void setChkSealNijuChosahyo(CheckBoxList chkSealNijuChosahyo) {
        this.chkSealNijuChosahyo = chkSealNijuChosahyo;
    }

    /*
     * getchkNijuChosahyoIchiran
     * @return chkNijuChosahyoIchiran
     */
    @JsonProperty("chkNijuChosahyoIchiran")
    public CheckBoxList getChkNijuChosahyoIchiran() {
        return chkNijuChosahyoIchiran;
    }

    /*
     * setchkNijuChosahyoIchiran
     * @param chkNijuChosahyoIchiran chkNijuChosahyoIchiran
     */
    @JsonProperty("chkNijuChosahyoIchiran")
    public void setChkNijuChosahyoIchiran(CheckBoxList chkNijuChosahyoIchiran) {
        this.chkNijuChosahyoIchiran = chkNijuChosahyoIchiran;
    }

    // </editor-fold>
}
