package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuSakuseiChohyo.IKaikuSakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuSakuseiChohyo.KaikuSakuseiChohyoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * KaikuMeiboSakuseiParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaikuMeiboSakuseiParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KaikuMeiboKoshinKijun")
    private KaikuMeiboKoshinKijunDiv KaikuMeiboKoshinKijun;
    @JsonProperty("ccdKaikuMeiboKaikuSakuseiChohyo")
    private KaikuSakuseiChohyoDiv ccdKaikuMeiboKaikuSakuseiChohyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKaikuMeiboKoshinKijun
     * @return KaikuMeiboKoshinKijun
     */
    @JsonProperty("KaikuMeiboKoshinKijun")
    public KaikuMeiboKoshinKijunDiv getKaikuMeiboKoshinKijun() {
        return KaikuMeiboKoshinKijun;
    }

    /*
     * setKaikuMeiboKoshinKijun
     * @param KaikuMeiboKoshinKijun KaikuMeiboKoshinKijun
     */
    @JsonProperty("KaikuMeiboKoshinKijun")
    public void setKaikuMeiboKoshinKijun(KaikuMeiboKoshinKijunDiv KaikuMeiboKoshinKijun) {
        this.KaikuMeiboKoshinKijun = KaikuMeiboKoshinKijun;
    }

    /*
     * getccdKaikuMeiboKaikuSakuseiChohyo
     * @return ccdKaikuMeiboKaikuSakuseiChohyo
     */
    @JsonProperty("ccdKaikuMeiboKaikuSakuseiChohyo")
    public IKaikuSakuseiChohyoDiv getCcdKaikuMeiboKaikuSakuseiChohyo() {
        return ccdKaikuMeiboKaikuSakuseiChohyo;
    }

    // </editor-fold>
}
