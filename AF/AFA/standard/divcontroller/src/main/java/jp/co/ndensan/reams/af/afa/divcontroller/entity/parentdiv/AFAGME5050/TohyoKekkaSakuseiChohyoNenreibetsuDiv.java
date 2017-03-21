package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5050;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelectRange.ITohyokuCodeSelectRangeDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelectRange.TohyokuCodeSelectRangeDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * TohyoKekkaSakuseiChohyoNenreibetsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class TohyoKekkaSakuseiChohyoNenreibetsuDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-02-19_14-33-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkNenreibetsuEUC")
    private CheckBoxList chkNenreibetsuEUC;
    @JsonProperty("ccdNenreibetsuTohyokuCode")
    private TohyokuCodeSelectRangeDiv ccdNenreibetsuTohyokuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkNenreibetsuEUC
     * @return chkNenreibetsuEUC
     */
    @JsonProperty("chkNenreibetsuEUC")
    public CheckBoxList getChkNenreibetsuEUC() {
        return chkNenreibetsuEUC;
    }

    /*
     * setchkNenreibetsuEUC
     * @param chkNenreibetsuEUC chkNenreibetsuEUC
     */
    @JsonProperty("chkNenreibetsuEUC")
    public void setChkNenreibetsuEUC(CheckBoxList chkNenreibetsuEUC) {
        this.chkNenreibetsuEUC = chkNenreibetsuEUC;
    }

    /*
     * getccdNenreibetsuTohyokuCode
     * @return ccdNenreibetsuTohyokuCode
     */
    @JsonProperty("ccdNenreibetsuTohyokuCode")
    public ITohyokuCodeSelectRangeDiv getCcdNenreibetsuTohyokuCode() {
        return ccdNenreibetsuTohyokuCode;
    }

    // </editor-fold>
}
