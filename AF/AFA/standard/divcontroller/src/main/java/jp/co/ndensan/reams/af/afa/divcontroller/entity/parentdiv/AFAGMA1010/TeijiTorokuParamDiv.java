package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboSakuseiKijun.IMeiboSakuseiKijunDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboSakuseiKijun.MeiboSakuseiKijunDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyo.ISakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyo.SakuseiChohyoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * TeijiTorokuParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class TeijiTorokuParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-04-25_11-07-54">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdTeijiMeiboSakuseiKijun")
    private MeiboSakuseiKijunDiv ccdTeijiMeiboSakuseiKijun;
    @JsonProperty("ccdTeijiSakuseiChohyo")
    private SakuseiChohyoDiv ccdTeijiSakuseiChohyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdTeijiMeiboSakuseiKijun
     * @return ccdTeijiMeiboSakuseiKijun
     */
    @JsonProperty("ccdTeijiMeiboSakuseiKijun")
    public IMeiboSakuseiKijunDiv getCcdTeijiMeiboSakuseiKijun() {
        return ccdTeijiMeiboSakuseiKijun;
    }

    /*
     * getccdTeijiSakuseiChohyo
     * @return ccdTeijiSakuseiChohyo
     */
    @JsonProperty("ccdTeijiSakuseiChohyo")
    public ISakuseiChohyoDiv getCcdTeijiSakuseiChohyo() {
        return ccdTeijiSakuseiChohyo;
    }

    // </editor-fold>
}
