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
public class KokuminSakuseiChohyo2goShikakuChosahyoDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdPrintNaiyo2goChosahyo")
    private SakuseiChohyoPrintNaiyoDiv ccdPrintNaiyo2goChosahyo;
    @JsonProperty("chkSeal2goChosahyo")
    private CheckBoxList chkSeal2goChosahyo;
    @JsonProperty("chk2goChosaIchiran")
    private CheckBoxList chk2goChosaIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdPrintNaiyo2goChosahyo
     * @return ccdPrintNaiyo2goChosahyo
     */
    @JsonProperty("ccdPrintNaiyo2goChosahyo")
    public ISakuseiChohyoPrintNaiyoDiv getCcdPrintNaiyo2goChosahyo() {
        return ccdPrintNaiyo2goChosahyo;
    }

    /*
     * getchkSeal2goChosahyo
     * @return chkSeal2goChosahyo
     */
    @JsonProperty("chkSeal2goChosahyo")
    public CheckBoxList getChkSeal2goChosahyo() {
        return chkSeal2goChosahyo;
    }

    /*
     * setchkSeal2goChosahyo
     * @param chkSeal2goChosahyo chkSeal2goChosahyo
     */
    @JsonProperty("chkSeal2goChosahyo")
    public void setChkSeal2goChosahyo(CheckBoxList chkSeal2goChosahyo) {
        this.chkSeal2goChosahyo = chkSeal2goChosahyo;
    }

    /*
     * getchk2goChosaIchiran
     * @return chk2goChosaIchiran
     */
    @JsonProperty("chk2goChosaIchiran")
    public CheckBoxList getChk2goChosaIchiran() {
        return chk2goChosaIchiran;
    }

    /*
     * setchk2goChosaIchiran
     * @param chk2goChosaIchiran chk2goChosaIchiran
     */
    @JsonProperty("chk2goChosaIchiran")
    public void setChk2goChosaIchiran(CheckBoxList chk2goChosaIchiran) {
        this.chk2goChosaIchiran = chk2goChosaIchiran;
    }

    // </editor-fold>
}
