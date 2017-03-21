package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2040;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * BarCodeJuri のクラスファイル 
 * 
 * @author 自動生成
 */
public class BarCodeJuriDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("BarCodeJuriNyuryoku")
    private BarCodeJuriNyuryokuDiv BarCodeJuriNyuryoku;
    @JsonProperty("HojoshaNyuryokuModel")
    private RString HojoshaNyuryokuModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getBarCodeJuriNyuryoku
     * @return BarCodeJuriNyuryoku
     */
    @JsonProperty("BarCodeJuriNyuryoku")
    public BarCodeJuriNyuryokuDiv getBarCodeJuriNyuryoku() {
        return BarCodeJuriNyuryoku;
    }

    /*
     * setBarCodeJuriNyuryoku
     * @param BarCodeJuriNyuryoku BarCodeJuriNyuryoku
     */
    @JsonProperty("BarCodeJuriNyuryoku")
    public void setBarCodeJuriNyuryoku(BarCodeJuriNyuryokuDiv BarCodeJuriNyuryoku) {
        this.BarCodeJuriNyuryoku = BarCodeJuriNyuryoku;
    }

    /*
     * getHojoshaNyuryokuModel
     * @return HojoshaNyuryokuModel
     */
    @JsonProperty("HojoshaNyuryokuModel")
    public RString getHojoshaNyuryokuModel() {
        return HojoshaNyuryokuModel;
    }

    /*
     * setHojoshaNyuryokuModel
     * @param HojoshaNyuryokuModel HojoshaNyuryokuModel
     */
    @JsonProperty("HojoshaNyuryokuModel")
    public void setHojoshaNyuryokuModel(RString HojoshaNyuryokuModel) {
        this.HojoshaNyuryokuModel = HojoshaNyuryokuModel;
    }

    // </editor-fold>
}
