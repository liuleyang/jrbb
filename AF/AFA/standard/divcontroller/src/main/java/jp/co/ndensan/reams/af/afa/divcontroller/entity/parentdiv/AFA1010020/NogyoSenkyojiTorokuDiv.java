package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFA1010020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.NogyoSakuseiChohyo.INogyoSakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.NogyoSakuseiChohyo.NogyoSakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TasenTaishoShohonJoho.ITasenTaishoShohonJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TasenTaishoShohonJoho.TasenTaishoShohonJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NogyoSenkyojiToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class NogyoSenkyojiTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdNogyoSenkyojiSakuseiChohyo")
    private NogyoSakuseiChohyoDiv ccdNogyoSenkyojiSakuseiChohyo;
    @JsonProperty("ccdNogyoSenkyojiSenkyoNyuryoku")
    private TasenTaishoShohonJohoDiv ccdNogyoSenkyojiSenkyoNyuryoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdNogyoSenkyojiSakuseiChohyo
     * @return ccdNogyoSenkyojiSakuseiChohyo
     */
    @JsonProperty("ccdNogyoSenkyojiSakuseiChohyo")
    public INogyoSakuseiChohyoDiv getCcdNogyoSenkyojiSakuseiChohyo() {
        return ccdNogyoSenkyojiSakuseiChohyo;
    }

    /*
     * getccdNogyoSenkyojiSenkyoNyuryoku
     * @return ccdNogyoSenkyojiSenkyoNyuryoku
     */
    @JsonProperty("ccdNogyoSenkyojiSenkyoNyuryoku")
    public ITasenTaishoShohonJohoDiv getCcdNogyoSenkyojiSenkyoNyuryoku() {
        return ccdNogyoSenkyojiSenkyoNyuryoku;
    }

    // </editor-fold>
}
