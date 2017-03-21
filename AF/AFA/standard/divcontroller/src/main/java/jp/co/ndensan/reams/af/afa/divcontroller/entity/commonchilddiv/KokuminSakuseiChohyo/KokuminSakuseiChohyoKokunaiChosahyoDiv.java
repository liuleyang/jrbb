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
public class KokuminSakuseiChohyoKokunaiChosahyoDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdPrintNaiyoKokunaiChosa")
    private SakuseiChohyoPrintNaiyoDiv ccdPrintNaiyoKokunaiChosa;
    @JsonProperty("chkSealKokunaiChosa")
    private CheckBoxList chkSealKokunaiChosa;
    @JsonProperty("chkKokunaiChosaIchiran")
    private CheckBoxList chkKokunaiChosaIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdPrintNaiyoKokunaiChosa
     * @return ccdPrintNaiyoKokunaiChosa
     */
    @JsonProperty("ccdPrintNaiyoKokunaiChosa")
    public ISakuseiChohyoPrintNaiyoDiv getCcdPrintNaiyoKokunaiChosa() {
        return ccdPrintNaiyoKokunaiChosa;
    }

    /*
     * getchkSealKokunaiChosa
     * @return chkSealKokunaiChosa
     */
    @JsonProperty("chkSealKokunaiChosa")
    public CheckBoxList getChkSealKokunaiChosa() {
        return chkSealKokunaiChosa;
    }

    /*
     * setchkSealKokunaiChosa
     * @param chkSealKokunaiChosa chkSealKokunaiChosa
     */
    @JsonProperty("chkSealKokunaiChosa")
    public void setChkSealKokunaiChosa(CheckBoxList chkSealKokunaiChosa) {
        this.chkSealKokunaiChosa = chkSealKokunaiChosa;
    }

    /*
     * getchkKokunaiChosaIchiran
     * @return chkKokunaiChosaIchiran
     */
    @JsonProperty("chkKokunaiChosaIchiran")
    public CheckBoxList getChkKokunaiChosaIchiran() {
        return chkKokunaiChosaIchiran;
    }

    /*
     * setchkKokunaiChosaIchiran
     * @param chkKokunaiChosaIchiran chkKokunaiChosaIchiran
     */
    @JsonProperty("chkKokunaiChosaIchiran")
    public void setChkKokunaiChosaIchiran(CheckBoxList chkKokunaiChosaIchiran) {
        this.chkKokunaiChosaIchiran = chkKokunaiChosaIchiran;
    }

    // </editor-fold>
}
