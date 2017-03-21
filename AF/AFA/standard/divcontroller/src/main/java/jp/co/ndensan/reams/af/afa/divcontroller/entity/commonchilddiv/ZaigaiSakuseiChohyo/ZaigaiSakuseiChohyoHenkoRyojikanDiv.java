package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ZaigaiSakuseiChohyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyoPrintNaiyo.ISakuseiChohyoPrintNaiyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyoPrintNaiyo.SakuseiChohyoPrintNaiyoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
public class ZaigaiSakuseiChohyoHenkoRyojikanDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdPrintNaiyoHenkoRyojikan")
    private SakuseiChohyoPrintNaiyoDiv ccdPrintNaiyoHenkoRyojikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdPrintNaiyoHenkoRyojikan
     * @return ccdPrintNaiyoHenkoRyojikan
     */
    @JsonProperty("ccdPrintNaiyoHenkoRyojikan")
    public ISakuseiChohyoPrintNaiyoDiv getCcdPrintNaiyoHenkoRyojikan() {
        return ccdPrintNaiyoHenkoRyojikan;
    }

    // </editor-fold>
}
