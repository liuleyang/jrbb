package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo.IKokuminSakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo.KokuminSakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminTaishoShohonJoho.IKokuminTaishoShohonJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminTaishoShohonJoho.KokuminTaishoShohonJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * KokuminTohyojiTorokuParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class KokuminTohyojiTorokuParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KokuminTohyojiNyuryoku")
    private KokuminTohyojiNyuryokuDiv KokuminTohyojiNyuryoku;
    @JsonProperty("ccdKokuminTohyojiMeiboKijun")
    private KokuminTaishoShohonJohoDiv ccdKokuminTohyojiMeiboKijun;
    @JsonProperty("ccdKokuminTohyojiSakuseiChohyo")
    private KokuminSakuseiChohyoDiv ccdKokuminTohyojiSakuseiChohyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKokuminTohyojiNyuryoku
     * @return KokuminTohyojiNyuryoku
     */
    @JsonProperty("KokuminTohyojiNyuryoku")
    public KokuminTohyojiNyuryokuDiv getKokuminTohyojiNyuryoku() {
        return KokuminTohyojiNyuryoku;
    }

    /*
     * setKokuminTohyojiNyuryoku
     * @param KokuminTohyojiNyuryoku KokuminTohyojiNyuryoku
     */
    @JsonProperty("KokuminTohyojiNyuryoku")
    public void setKokuminTohyojiNyuryoku(KokuminTohyojiNyuryokuDiv KokuminTohyojiNyuryoku) {
        this.KokuminTohyojiNyuryoku = KokuminTohyojiNyuryoku;
    }

    /*
     * getccdKokuminTohyojiMeiboKijun
     * @return ccdKokuminTohyojiMeiboKijun
     */
    @JsonProperty("ccdKokuminTohyojiMeiboKijun")
    public IKokuminTaishoShohonJohoDiv getCcdKokuminTohyojiMeiboKijun() {
        return ccdKokuminTohyojiMeiboKijun;
    }

    /*
     * getccdKokuminTohyojiSakuseiChohyo
     * @return ccdKokuminTohyojiSakuseiChohyo
     */
    @JsonProperty("ccdKokuminTohyojiSakuseiChohyo")
    public IKokuminSakuseiChohyoDiv getCcdKokuminTohyojiSakuseiChohyo() {
        return ccdKokuminTohyojiSakuseiChohyo;
    }

    // </editor-fold>
}
