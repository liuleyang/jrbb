package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1030;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyo.ISakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyo.SakuseiChohyoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * RePrintTeijiParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class RePrintTeijiParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-04-25_11-07-54">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("RePrintTeijiShohonSelect")
    private RePrintTeijiShohonSelectDiv RePrintTeijiShohonSelect;
    @JsonProperty("ccdRePrintTeijiSakuseiChohyo")
    private SakuseiChohyoDiv ccdRePrintTeijiSakuseiChohyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getRePrintTeijiShohonSelect
     * @return RePrintTeijiShohonSelect
     */
    @JsonProperty("RePrintTeijiShohonSelect")
    public RePrintTeijiShohonSelectDiv getRePrintTeijiShohonSelect() {
        return RePrintTeijiShohonSelect;
    }

    /*
     * setRePrintTeijiShohonSelect
     * @param RePrintTeijiShohonSelect RePrintTeijiShohonSelect
     */
    @JsonProperty("RePrintTeijiShohonSelect")
    public void setRePrintTeijiShohonSelect(RePrintTeijiShohonSelectDiv RePrintTeijiShohonSelect) {
        this.RePrintTeijiShohonSelect = RePrintTeijiShohonSelect;
    }

    /*
     * getccdRePrintTeijiSakuseiChohyo
     * @return ccdRePrintTeijiSakuseiChohyo
     */
    @JsonProperty("ccdRePrintTeijiSakuseiChohyo")
    public ISakuseiChohyoDiv getCcdRePrintTeijiSakuseiChohyo() {
        return ccdRePrintTeijiSakuseiChohyo;
    }

    // </editor-fold>
}
