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
public class SakuseiChohyoNijuTorokuTsuchiDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdPrintNaiyoNijuTsuchi")
    private SakuseiChohyoPrintNaiyoDiv ccdPrintNaiyoNijuTsuchi;
    @JsonProperty("txtTennyuKikan")
    private TextBoxDateRange txtTennyuKikan;
    @JsonProperty("chkSealNijuTsuchi")
    private CheckBoxList chkSealNijuTsuchi;
    @JsonProperty("chkNijuTsuchiIchiran")
    private CheckBoxList chkNijuTsuchiIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdPrintNaiyoNijuTsuchi
     * @return ccdPrintNaiyoNijuTsuchi
     */
    @JsonProperty("ccdPrintNaiyoNijuTsuchi")
    public ISakuseiChohyoPrintNaiyoDiv getCcdPrintNaiyoNijuTsuchi() {
        return ccdPrintNaiyoNijuTsuchi;
    }

    /*
     * gettxtTennyuKikan
     * @return txtTennyuKikan
     */
    @JsonProperty("txtTennyuKikan")
    public TextBoxDateRange getTxtTennyuKikan() {
        return txtTennyuKikan;
    }

    /*
     * settxtTennyuKikan
     * @param txtTennyuKikan txtTennyuKikan
     */
    @JsonProperty("txtTennyuKikan")
    public void setTxtTennyuKikan(TextBoxDateRange txtTennyuKikan) {
        this.txtTennyuKikan = txtTennyuKikan;
    }

    /*
     * getchkSealNijuTsuchi
     * @return chkSealNijuTsuchi
     */
    @JsonProperty("chkSealNijuTsuchi")
    public CheckBoxList getChkSealNijuTsuchi() {
        return chkSealNijuTsuchi;
    }

    /*
     * setchkSealNijuTsuchi
     * @param chkSealNijuTsuchi chkSealNijuTsuchi
     */
    @JsonProperty("chkSealNijuTsuchi")
    public void setChkSealNijuTsuchi(CheckBoxList chkSealNijuTsuchi) {
        this.chkSealNijuTsuchi = chkSealNijuTsuchi;
    }

    /*
     * getchkNijuTsuchiIchiran
     * @return chkNijuTsuchiIchiran
     */
    @JsonProperty("chkNijuTsuchiIchiran")
    public CheckBoxList getChkNijuTsuchiIchiran() {
        return chkNijuTsuchiIchiran;
    }

    /*
     * setchkNijuTsuchiIchiran
     * @param chkNijuTsuchiIchiran chkNijuTsuchiIchiran
     */
    @JsonProperty("chkNijuTsuchiIchiran")
    public void setChkNijuTsuchiIchiran(CheckBoxList chkNijuTsuchiIchiran) {
        this.chkNijuTsuchiIchiran = chkNijuTsuchiIchiran;
    }

    // </editor-fold>
}
