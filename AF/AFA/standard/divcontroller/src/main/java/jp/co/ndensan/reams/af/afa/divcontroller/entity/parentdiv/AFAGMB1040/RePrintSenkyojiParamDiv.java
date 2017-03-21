package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1040;
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
 * RePrintSenkyojiParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class RePrintSenkyojiParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-02-19_14-33-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("RePrintSenkyojiShohonSelect")
    private RePrintSenkyojiShohonSelectDiv RePrintSenkyojiShohonSelect;
    @JsonProperty("ccdRePrintSenkyojiSakuseiChohyo")
    private SakuseiChohyoDiv ccdRePrintSenkyojiSakuseiChohyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getRePrintSenkyojiShohonSelect
     * @return RePrintSenkyojiShohonSelect
     */
    @JsonProperty("RePrintSenkyojiShohonSelect")
    public RePrintSenkyojiShohonSelectDiv getRePrintSenkyojiShohonSelect() {
        return RePrintSenkyojiShohonSelect;
    }

    /*
     * setRePrintSenkyojiShohonSelect
     * @param RePrintSenkyojiShohonSelect RePrintSenkyojiShohonSelect
     */
    @JsonProperty("RePrintSenkyojiShohonSelect")
    public void setRePrintSenkyojiShohonSelect(RePrintSenkyojiShohonSelectDiv RePrintSenkyojiShohonSelect) {
        this.RePrintSenkyojiShohonSelect = RePrintSenkyojiShohonSelect;
    }

    /*
     * getccdRePrintSenkyojiSakuseiChohyo
     * @return ccdRePrintSenkyojiSakuseiChohyo
     */
    @JsonProperty("ccdRePrintSenkyojiSakuseiChohyo")
    public ISakuseiChohyoDiv getCcdRePrintSenkyojiSakuseiChohyo() {
        return ccdRePrintSenkyojiSakuseiChohyo;
    }

    // </editor-fold>
}
