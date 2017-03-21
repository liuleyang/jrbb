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
 * ZenjitsuSakuseiChohyoDairiShukei のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZenjitsuSakuseiChohyoDairiShukeiDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-02-19_14-33-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkDairiTohyoTaisho")
    private CheckBoxList chkDairiTohyoTaisho;
    @JsonProperty("txtDairiShukeiJuriYMD")
    private TextBoxDateRange txtDairiShukeiJuriYMD;
    @JsonProperty("ccdDairiShukeiTohyokuCode")
    private TohyokuCodeSelectRangeDiv ccdDairiShukeiTohyokuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkDairiTohyoTaisho
     * @return chkDairiTohyoTaisho
     */
    @JsonProperty("chkDairiTohyoTaisho")
    public CheckBoxList getChkDairiTohyoTaisho() {
        return chkDairiTohyoTaisho;
    }

    /*
     * setchkDairiTohyoTaisho
     * @param chkDairiTohyoTaisho chkDairiTohyoTaisho
     */
    @JsonProperty("chkDairiTohyoTaisho")
    public void setChkDairiTohyoTaisho(CheckBoxList chkDairiTohyoTaisho) {
        this.chkDairiTohyoTaisho = chkDairiTohyoTaisho;
    }

    /*
     * gettxtDairiShukeiJuriYMD
     * @return txtDairiShukeiJuriYMD
     */
    @JsonProperty("txtDairiShukeiJuriYMD")
    public TextBoxDateRange getTxtDairiShukeiJuriYMD() {
        return txtDairiShukeiJuriYMD;
    }

    /*
     * settxtDairiShukeiJuriYMD
     * @param txtDairiShukeiJuriYMD txtDairiShukeiJuriYMD
     */
    @JsonProperty("txtDairiShukeiJuriYMD")
    public void setTxtDairiShukeiJuriYMD(TextBoxDateRange txtDairiShukeiJuriYMD) {
        this.txtDairiShukeiJuriYMD = txtDairiShukeiJuriYMD;
    }

    /*
     * getccdDairiShukeiTohyokuCode
     * @return ccdDairiShukeiTohyokuCode
     */
    @JsonProperty("ccdDairiShukeiTohyokuCode")
    public ITohyokuCodeSelectRangeDiv getCcdDairiShukeiTohyokuCode() {
        return ccdDairiShukeiTohyokuCode;
    }

    // </editor-fold>
}
