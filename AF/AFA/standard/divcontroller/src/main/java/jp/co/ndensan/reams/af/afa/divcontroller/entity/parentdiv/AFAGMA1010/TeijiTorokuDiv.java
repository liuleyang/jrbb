package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboSakuseiKijun.IMeiboSakuseiKijunDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboSakuseiKijun.MeiboSakuseiKijunDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyo.ISakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyo.SakuseiChohyoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TeijiToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class TeijiTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-04-25_11-07-54">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TeijiTorokuParam")
    private TeijiTorokuParamDiv TeijiTorokuParam;
    @JsonProperty("hdn質問フラグ")
    private RString hdn質問フラグ;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTeijiTorokuParam
     * @return TeijiTorokuParam
     */
    @JsonProperty("TeijiTorokuParam")
    public TeijiTorokuParamDiv getTeijiTorokuParam() {
        return TeijiTorokuParam;
    }

    /*
     * setTeijiTorokuParam
     * @param TeijiTorokuParam TeijiTorokuParam
     */
    @JsonProperty("TeijiTorokuParam")
    public void setTeijiTorokuParam(TeijiTorokuParamDiv TeijiTorokuParam) {
        this.TeijiTorokuParam = TeijiTorokuParam;
    }

    /*
     * gethdn質問フラグ
     * @return hdn質問フラグ
     */
    @JsonProperty("hdn質問フラグ")
    public RString getHdn質問フラグ() {
        return hdn質問フラグ;
    }

    /*
     * sethdn質問フラグ
     * @param hdn質問フラグ hdn質問フラグ
     */
    @JsonProperty("hdn質問フラグ")
    public void setHdn質問フラグ(RString hdn質問フラグ) {
        this.hdn質問フラグ = hdn質問フラグ;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IMeiboSakuseiKijunDiv getCcdTeijiMeiboSakuseiKijun() {
        return this.getTeijiTorokuParam().getCcdTeijiMeiboSakuseiKijun();
    }

    @JsonIgnore
    public ISakuseiChohyoDiv getCcdTeijiSakuseiChohyo() {
        return this.getTeijiTorokuParam().getCcdTeijiSakuseiChohyo();
    }

    // </editor-fold>
}
