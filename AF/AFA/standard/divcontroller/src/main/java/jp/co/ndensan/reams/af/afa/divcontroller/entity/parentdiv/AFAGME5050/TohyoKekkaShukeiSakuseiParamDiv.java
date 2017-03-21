package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5050;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonSenkyoList.IShohonSenkyoListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonSenkyoList.ShohonSenkyoListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * TohyoKekkaShukeiSakuseiParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class TohyoKekkaShukeiSakuseiParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-02-19_14-33-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TohyoKekkaSakuseiChohyo")
    private TohyoKekkaSakuseiChohyoDiv TohyoKekkaSakuseiChohyo;
    @JsonProperty("ccdTohyoKekkaShohonSenkyoList")
    private ShohonSenkyoListDiv ccdTohyoKekkaShohonSenkyoList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTohyoKekkaSakuseiChohyo
     * @return TohyoKekkaSakuseiChohyo
     */
    @JsonProperty("TohyoKekkaSakuseiChohyo")
    public TohyoKekkaSakuseiChohyoDiv getTohyoKekkaSakuseiChohyo() {
        return TohyoKekkaSakuseiChohyo;
    }

    /*
     * setTohyoKekkaSakuseiChohyo
     * @param TohyoKekkaSakuseiChohyo TohyoKekkaSakuseiChohyo
     */
    @JsonProperty("TohyoKekkaSakuseiChohyo")
    public void setTohyoKekkaSakuseiChohyo(TohyoKekkaSakuseiChohyoDiv TohyoKekkaSakuseiChohyo) {
        this.TohyoKekkaSakuseiChohyo = TohyoKekkaSakuseiChohyo;
    }

    /*
     * getccdTohyoKekkaShohonSenkyoList
     * @return ccdTohyoKekkaShohonSenkyoList
     */
    @JsonProperty("ccdTohyoKekkaShohonSenkyoList")
    public IShohonSenkyoListDiv getCcdTohyoKekkaShohonSenkyoList() {
        return ccdTohyoKekkaShohonSenkyoList;
    }

    // </editor-fold>
}
