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
public class KokuminSakuseiChohyo1goShikakuTsuchiDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdPrintNaiyo1goTsuchi")
    private SakuseiChohyoPrintNaiyoDiv ccdPrintNaiyo1goTsuchi;
    @JsonProperty("chkSeal1goTsuchi")
    private CheckBoxList chkSeal1goTsuchi;
    @JsonProperty("chk1goTsuchiIchiran")
    private CheckBoxList chk1goTsuchiIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdPrintNaiyo1goTsuchi
     * @return ccdPrintNaiyo1goTsuchi
     */
    @JsonProperty("ccdPrintNaiyo1goTsuchi")
    public ISakuseiChohyoPrintNaiyoDiv getCcdPrintNaiyo1goTsuchi() {
        return ccdPrintNaiyo1goTsuchi;
    }

    /*
     * getchkSeal1goTsuchi
     * @return chkSeal1goTsuchi
     */
    @JsonProperty("chkSeal1goTsuchi")
    public CheckBoxList getChkSeal1goTsuchi() {
        return chkSeal1goTsuchi;
    }

    /*
     * setchkSeal1goTsuchi
     * @param chkSeal1goTsuchi chkSeal1goTsuchi
     */
    @JsonProperty("chkSeal1goTsuchi")
    public void setChkSeal1goTsuchi(CheckBoxList chkSeal1goTsuchi) {
        this.chkSeal1goTsuchi = chkSeal1goTsuchi;
    }

    /*
     * getchk1goTsuchiIchiran
     * @return chk1goTsuchiIchiran
     */
    @JsonProperty("chk1goTsuchiIchiran")
    public CheckBoxList getChk1goTsuchiIchiran() {
        return chk1goTsuchiIchiran;
    }

    /*
     * setchk1goTsuchiIchiran
     * @param chk1goTsuchiIchiran chk1goTsuchiIchiran
     */
    @JsonProperty("chk1goTsuchiIchiran")
    public void setChk1goTsuchiIchiran(CheckBoxList chk1goTsuchiIchiran) {
        this.chk1goTsuchiIchiran = chk1goTsuchiIchiran;
    }

    // </editor-fold>
}
