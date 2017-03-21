package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo;
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
public class KokuminSakuseiChohyoKokugaiChosahyoDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdPrintNaiyoKokugaiChosa")
    private SakuseiChohyoPrintNaiyoDiv ccdPrintNaiyoKokugaiChosa;
    @JsonProperty("chkSealKokugaiChosa")
    private CheckBoxList chkSealKokugaiChosa;
    @JsonProperty("chkKokugaiChosaIchiran")
    private CheckBoxList chkKokugaiChosaIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdPrintNaiyoKokugaiChosa
     * @return ccdPrintNaiyoKokugaiChosa
     */
    @JsonProperty("ccdPrintNaiyoKokugaiChosa")
    public ISakuseiChohyoPrintNaiyoDiv getCcdPrintNaiyoKokugaiChosa() {
        return ccdPrintNaiyoKokugaiChosa;
    }

    /*
     * getchkSealKokugaiChosa
     * @return chkSealKokugaiChosa
     */
    @JsonProperty("chkSealKokugaiChosa")
    public CheckBoxList getChkSealKokugaiChosa() {
        return chkSealKokugaiChosa;
    }

    /*
     * setchkSealKokugaiChosa
     * @param chkSealKokugaiChosa chkSealKokugaiChosa
     */
    @JsonProperty("chkSealKokugaiChosa")
    public void setChkSealKokugaiChosa(CheckBoxList chkSealKokugaiChosa) {
        this.chkSealKokugaiChosa = chkSealKokugaiChosa;
    }

    /*
     * getchkKokugaiChosaIchiran
     * @return chkKokugaiChosaIchiran
     */
    @JsonProperty("chkKokugaiChosaIchiran")
    public CheckBoxList getChkKokugaiChosaIchiran() {
        return chkKokugaiChosaIchiran;
    }

    /*
     * setchkKokugaiChosaIchiran
     * @param chkKokugaiChosaIchiran chkKokugaiChosaIchiran
     */
    @JsonProperty("chkKokugaiChosaIchiran")
    public void setChkKokugaiChosaIchiran(CheckBoxList chkKokugaiChosaIchiran) {
        this.chkKokugaiChosaIchiran = chkKokugaiChosaIchiran;
    }

    // </editor-fold>
}
