package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5030;
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
 * NippoSakuseiChohyoSeirihyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class NippoSakuseiChohyoSeirihyoDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSeirihyoJuriYMD")
    private TextBoxDate txtSeirihyoJuriYMD;
    @JsonProperty("ccdSeirihyoTohyokuCode")
    private TohyokuCodeSelectRangeDiv ccdSeirihyoTohyokuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSeirihyoJuriYMD
     * @return txtSeirihyoJuriYMD
     */
    @JsonProperty("txtSeirihyoJuriYMD")
    public TextBoxDate getTxtSeirihyoJuriYMD() {
        return txtSeirihyoJuriYMD;
    }

    /*
     * settxtSeirihyoJuriYMD
     * @param txtSeirihyoJuriYMD txtSeirihyoJuriYMD
     */
    @JsonProperty("txtSeirihyoJuriYMD")
    public void setTxtSeirihyoJuriYMD(TextBoxDate txtSeirihyoJuriYMD) {
        this.txtSeirihyoJuriYMD = txtSeirihyoJuriYMD;
    }

    /*
     * getccdSeirihyoTohyokuCode
     * @return ccdSeirihyoTohyokuCode
     */
    @JsonProperty("ccdSeirihyoTohyokuCode")
    public ITohyokuCodeSelectRangeDiv getCcdSeirihyoTohyokuCode() {
        return ccdSeirihyoTohyokuCode;
    }

    // </editor-fold>
}
