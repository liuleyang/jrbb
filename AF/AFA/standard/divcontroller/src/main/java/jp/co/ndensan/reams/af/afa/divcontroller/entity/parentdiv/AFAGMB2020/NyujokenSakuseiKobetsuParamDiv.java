package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2020;
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
 * NyujokenSakuseiKobetsuParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class NyujokenSakuseiKobetsuParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NyujokenKobetsuSakuseiTaisho")
    private NyujokenKobetsuSakuseiTaishoDiv NyujokenKobetsuSakuseiTaisho;
    @JsonProperty("ccdNyujokenKobetsuShohonSelect")
    private ShohonSelectDiv ccdNyujokenKobetsuShohonSelect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getNyujokenKobetsuSakuseiTaisho
     * @return NyujokenKobetsuSakuseiTaisho
     */
    @JsonProperty("NyujokenKobetsuSakuseiTaisho")
    public NyujokenKobetsuSakuseiTaishoDiv getNyujokenKobetsuSakuseiTaisho() {
        return NyujokenKobetsuSakuseiTaisho;
    }

    /*
     * setNyujokenKobetsuSakuseiTaisho
     * @param NyujokenKobetsuSakuseiTaisho NyujokenKobetsuSakuseiTaisho
     */
    @JsonProperty("NyujokenKobetsuSakuseiTaisho")
    public void setNyujokenKobetsuSakuseiTaisho(NyujokenKobetsuSakuseiTaishoDiv NyujokenKobetsuSakuseiTaisho) {
        this.NyujokenKobetsuSakuseiTaisho = NyujokenKobetsuSakuseiTaisho;
    }

    /*
     * getccdNyujokenKobetsuShohonSelect
     * @return ccdNyujokenKobetsuShohonSelect
     */
    @JsonProperty("ccdNyujokenKobetsuShohonSelect")
    public IShohonSelectDiv getCcdNyujokenKobetsuShohonSelect() {
        return ccdNyujokenKobetsuShohonSelect;
    }

    // </editor-fold>
}
