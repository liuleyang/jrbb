package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonSelect.IShohonSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonSelect.ShohonSelectDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * NyujokenSakuseiIkkatsuParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class NyujokenSakuseiIkkatsuParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NyujokenSakuseiTaisho")
    private NyujokenSakuseiTaishoDiv NyujokenSakuseiTaisho;
    @JsonProperty("ccdNyujokenShohonSelect")
    private ShohonSelectDiv ccdNyujokenShohonSelect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getNyujokenSakuseiTaisho
     * @return NyujokenSakuseiTaisho
     */
    @JsonProperty("NyujokenSakuseiTaisho")
    public NyujokenSakuseiTaishoDiv getNyujokenSakuseiTaisho() {
        return NyujokenSakuseiTaisho;
    }

    /*
     * setNyujokenSakuseiTaisho
     * @param NyujokenSakuseiTaisho NyujokenSakuseiTaisho
     */
    @JsonProperty("NyujokenSakuseiTaisho")
    public void setNyujokenSakuseiTaisho(NyujokenSakuseiTaishoDiv NyujokenSakuseiTaisho) {
        this.NyujokenSakuseiTaisho = NyujokenSakuseiTaisho;
    }

    /*
     * getccdNyujokenShohonSelect
     * @return ccdNyujokenShohonSelect
     */
    @JsonProperty("ccdNyujokenShohonSelect")
    public IShohonSelectDiv getCcdNyujokenShohonSelect() {
        return ccdNyujokenShohonSelect;
    }

    // </editor-fold>
}
