package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFA1010010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.NogyoSakuseiChohyo.INogyoSakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.NogyoSakuseiChohyo.NogyoSakuseiChohyoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NogyoMeiboSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class NogyoMeiboSakuseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NogyoMeiboKoshinKijun")
    private NogyoMeiboKoshinKijunDiv NogyoMeiboKoshinKijun;
    @JsonProperty("ccdNogyoMeiboNogyoSakuseiChohyo")
    private NogyoSakuseiChohyoDiv ccdNogyoMeiboNogyoSakuseiChohyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getNogyoMeiboKoshinKijun
     * @return NogyoMeiboKoshinKijun
     */
    @JsonProperty("NogyoMeiboKoshinKijun")
    public NogyoMeiboKoshinKijunDiv getNogyoMeiboKoshinKijun() {
        return NogyoMeiboKoshinKijun;
    }

    /*
     * setNogyoMeiboKoshinKijun
     * @param NogyoMeiboKoshinKijun NogyoMeiboKoshinKijun
     */
    @JsonProperty("NogyoMeiboKoshinKijun")
    public void setNogyoMeiboKoshinKijun(NogyoMeiboKoshinKijunDiv NogyoMeiboKoshinKijun) {
        this.NogyoMeiboKoshinKijun = NogyoMeiboKoshinKijun;
    }

    /*
     * getccdNogyoMeiboNogyoSakuseiChohyo
     * @return ccdNogyoMeiboNogyoSakuseiChohyo
     */
    @JsonProperty("ccdNogyoMeiboNogyoSakuseiChohyo")
    public INogyoSakuseiChohyoDiv getCcdNogyoMeiboNogyoSakuseiChohyo() {
        return ccdNogyoMeiboNogyoSakuseiChohyo;
    }

    // </editor-fold>
}
