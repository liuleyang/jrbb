package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME1020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * LabelSealRePrintParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class LabelSealRePrintParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("LabelSealSakuseiTaisho")
    private LabelSealSakuseiTaishoDiv LabelSealSakuseiTaisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getLabelSealSakuseiTaisho
     * @return LabelSealSakuseiTaisho
     */
    @JsonProperty("LabelSealSakuseiTaisho")
    public LabelSealSakuseiTaishoDiv getLabelSealSakuseiTaisho() {
        return LabelSealSakuseiTaisho;
    }

    /*
     * setLabelSealSakuseiTaisho
     * @param LabelSealSakuseiTaisho LabelSealSakuseiTaisho
     */
    @JsonProperty("LabelSealSakuseiTaisho")
    public void setLabelSealSakuseiTaisho(LabelSealSakuseiTaishoDiv LabelSealSakuseiTaisho) {
        this.LabelSealSakuseiTaisho = LabelSealSakuseiTaisho;
    }

    // </editor-fold>
}
