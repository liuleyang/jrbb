package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040;
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
 * ZenjitsuSakuseiChohyoFuzaishaChosho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZenjitsuSakuseiChohyoFuzaishaChoshoDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-02-19_14-33-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkBikoInji")
    private CheckBoxList chkBikoInji;
    @JsonProperty("ccdFuzaishaChoshoTohyokuCode")
    private TohyokuCodeSelectRangeDiv ccdFuzaishaChoshoTohyokuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkBikoInji
     * @return chkBikoInji
     */
    @JsonProperty("chkBikoInji")
    public CheckBoxList getChkBikoInji() {
        return chkBikoInji;
    }

    /*
     * setchkBikoInji
     * @param chkBikoInji chkBikoInji
     */
    @JsonProperty("chkBikoInji")
    public void setChkBikoInji(CheckBoxList chkBikoInji) {
        this.chkBikoInji = chkBikoInji;
    }

    /*
     * getccdFuzaishaChoshoTohyokuCode
     * @return ccdFuzaishaChoshoTohyokuCode
     */
    @JsonProperty("ccdFuzaishaChoshoTohyokuCode")
    public ITohyokuCodeSelectRangeDiv getCcdFuzaishaChoshoTohyokuCode() {
        return ccdFuzaishaChoshoTohyokuCode;
    }

    // </editor-fold>
}
