package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelectRange.ITohyokuCodeSelectRangeDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelectRange.TohyokuCodeSelectRangeDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * ZenjitsuSakuseiChohyoKanrishaChosho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZenjitsuSakuseiChohyoKanrishaChoshoDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-02-19_14-33-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdKanrishaChoshoTohyokuCode")
    private TohyokuCodeSelectRangeDiv ccdKanrishaChoshoTohyokuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdKanrishaChoshoTohyokuCode
     * @return ccdKanrishaChoshoTohyokuCode
     */
    @JsonProperty("ccdKanrishaChoshoTohyokuCode")
    public ITohyokuCodeSelectRangeDiv getCcdKanrishaChoshoTohyokuCode() {
        return ccdKanrishaChoshoTohyokuCode;
    }

    // </editor-fold>
}
