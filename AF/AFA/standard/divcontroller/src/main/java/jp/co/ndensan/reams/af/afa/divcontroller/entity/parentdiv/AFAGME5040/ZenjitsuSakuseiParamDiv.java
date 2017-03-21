package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040;
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
 * ZenjitsuSakuseiParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZenjitsuSakuseiParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-02-19_14-33-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ZenjitsuSakuseiChohyo")
    private ZenjitsuSakuseiChohyoDiv ZenjitsuSakuseiChohyo;
    @JsonProperty("ccdZenjitsuShohonSenkyoList")
    private ShohonSenkyoListDiv ccdZenjitsuShohonSenkyoList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getZenjitsuSakuseiChohyo
     * @return ZenjitsuSakuseiChohyo
     */
    @JsonProperty("ZenjitsuSakuseiChohyo")
    public ZenjitsuSakuseiChohyoDiv getZenjitsuSakuseiChohyo() {
        return ZenjitsuSakuseiChohyo;
    }

    /*
     * setZenjitsuSakuseiChohyo
     * @param ZenjitsuSakuseiChohyo ZenjitsuSakuseiChohyo
     */
    @JsonProperty("ZenjitsuSakuseiChohyo")
    public void setZenjitsuSakuseiChohyo(ZenjitsuSakuseiChohyoDiv ZenjitsuSakuseiChohyo) {
        this.ZenjitsuSakuseiChohyo = ZenjitsuSakuseiChohyo;
    }

    /*
     * getccdZenjitsuShohonSenkyoList
     * @return ccdZenjitsuShohonSenkyoList
     */
    @JsonProperty("ccdZenjitsuShohonSenkyoList")
    public IShohonSenkyoListDiv getCcdZenjitsuShohonSenkyoList() {
        return ccdZenjitsuShohonSenkyoList;
    }

    // </editor-fold>
}
