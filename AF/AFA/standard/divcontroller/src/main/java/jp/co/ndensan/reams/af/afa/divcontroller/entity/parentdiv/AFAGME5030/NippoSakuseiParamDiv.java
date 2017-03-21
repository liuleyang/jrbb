package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5030;
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
 * NippoSakuseiParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class NippoSakuseiParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NippoSakuseiChohyo")
    private NippoSakuseiChohyoDiv NippoSakuseiChohyo;
    @JsonProperty("ccdNippoShohonSenkyoList")
    private ShohonSenkyoListDiv ccdNippoShohonSenkyoList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getNippoSakuseiChohyo
     * @return NippoSakuseiChohyo
     */
    @JsonProperty("NippoSakuseiChohyo")
    public NippoSakuseiChohyoDiv getNippoSakuseiChohyo() {
        return NippoSakuseiChohyo;
    }

    /*
     * setNippoSakuseiChohyo
     * @param NippoSakuseiChohyo NippoSakuseiChohyo
     */
    @JsonProperty("NippoSakuseiChohyo")
    public void setNippoSakuseiChohyo(NippoSakuseiChohyoDiv NippoSakuseiChohyo) {
        this.NippoSakuseiChohyo = NippoSakuseiChohyo;
    }

    /*
     * getccdNippoShohonSenkyoList
     * @return ccdNippoShohonSenkyoList
     */
    @JsonProperty("ccdNippoShohonSenkyoList")
    public IShohonSenkyoListDiv getCcdNippoShohonSenkyoList() {
        return ccdNippoShohonSenkyoList;
    }

    // </editor-fold>
}
