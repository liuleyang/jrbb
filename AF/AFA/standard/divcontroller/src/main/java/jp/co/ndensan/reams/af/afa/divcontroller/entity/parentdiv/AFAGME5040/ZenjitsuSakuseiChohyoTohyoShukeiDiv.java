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
 * ZenjitsuSakuseiChohyoTohyoShukei のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZenjitsuSakuseiChohyoTohyoShukeiDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-02-19_14-33-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTohyoShukeiJuriYMD")
    private TextBoxDateRange txtTohyoShukeiJuriYMD;
    @JsonProperty("ccdTohyoShukeiTohyokuCode")
    private TohyokuCodeSelectRangeDiv ccdTohyoShukeiTohyokuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTohyoShukeiJuriYMD
     * @return txtTohyoShukeiJuriYMD
     */
    @JsonProperty("txtTohyoShukeiJuriYMD")
    public TextBoxDateRange getTxtTohyoShukeiJuriYMD() {
        return txtTohyoShukeiJuriYMD;
    }

    /*
     * settxtTohyoShukeiJuriYMD
     * @param txtTohyoShukeiJuriYMD txtTohyoShukeiJuriYMD
     */
    @JsonProperty("txtTohyoShukeiJuriYMD")
    public void setTxtTohyoShukeiJuriYMD(TextBoxDateRange txtTohyoShukeiJuriYMD) {
        this.txtTohyoShukeiJuriYMD = txtTohyoShukeiJuriYMD;
    }

    /*
     * getccdTohyoShukeiTohyokuCode
     * @return ccdTohyoShukeiTohyokuCode
     */
    @JsonProperty("ccdTohyoShukeiTohyokuCode")
    public ITohyokuCodeSelectRangeDiv getCcdTohyoShukeiTohyokuCode() {
        return ccdTohyoShukeiTohyokuCode;
    }

    // </editor-fold>
}
