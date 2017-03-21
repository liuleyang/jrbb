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
public class KokuminSakuseiChohyoMasshoTsuchiDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdPrintNaiyoMasshoTsuchi")
    private SakuseiChohyoPrintNaiyoDiv ccdPrintNaiyoMasshoTsuchi;
    @JsonProperty("chkSealMasshoTsuchi")
    private CheckBoxList chkSealMasshoTsuchi;
    @JsonProperty("chkMasshoTsuchiIchiran")
    private CheckBoxList chkMasshoTsuchiIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdPrintNaiyoMasshoTsuchi
     * @return ccdPrintNaiyoMasshoTsuchi
     */
    @JsonProperty("ccdPrintNaiyoMasshoTsuchi")
    public ISakuseiChohyoPrintNaiyoDiv getCcdPrintNaiyoMasshoTsuchi() {
        return ccdPrintNaiyoMasshoTsuchi;
    }

    /*
     * getchkSealMasshoTsuchi
     * @return chkSealMasshoTsuchi
     */
    @JsonProperty("chkSealMasshoTsuchi")
    public CheckBoxList getChkSealMasshoTsuchi() {
        return chkSealMasshoTsuchi;
    }

    /*
     * setchkSealMasshoTsuchi
     * @param chkSealMasshoTsuchi chkSealMasshoTsuchi
     */
    @JsonProperty("chkSealMasshoTsuchi")
    public void setChkSealMasshoTsuchi(CheckBoxList chkSealMasshoTsuchi) {
        this.chkSealMasshoTsuchi = chkSealMasshoTsuchi;
    }

    /*
     * getchkMasshoTsuchiIchiran
     * @return chkMasshoTsuchiIchiran
     */
    @JsonProperty("chkMasshoTsuchiIchiran")
    public CheckBoxList getChkMasshoTsuchiIchiran() {
        return chkMasshoTsuchiIchiran;
    }

    /*
     * setchkMasshoTsuchiIchiran
     * @param chkMasshoTsuchiIchiran chkMasshoTsuchiIchiran
     */
    @JsonProperty("chkMasshoTsuchiIchiran")
    public void setChkMasshoTsuchiIchiran(CheckBoxList chkMasshoTsuchiIchiran) {
        this.chkMasshoTsuchiIchiran = chkMasshoTsuchiIchiran;
    }

    // </editor-fold>
}
