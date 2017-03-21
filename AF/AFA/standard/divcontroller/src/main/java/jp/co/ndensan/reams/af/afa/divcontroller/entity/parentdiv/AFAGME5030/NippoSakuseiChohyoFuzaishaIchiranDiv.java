package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5030;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelectRange.IShisetsuCodeSelectRangeDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelectRange.ShisetsuCodeSelectRangeDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelectRange.ITohyokuCodeSelectRangeDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelectRange.TohyokuCodeSelectRangeDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * NippoSakuseiChohyoFuzaishaIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class NippoSakuseiChohyoFuzaishaIchiranDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtFuzaishaIchiranKofuYMD")
    private TextBoxDateRange txtFuzaishaIchiranKofuYMD;
    @JsonProperty("txtFuzaishaIchiranJuriYMD")
    private TextBoxDateRange txtFuzaishaIchiranJuriYMD;
    @JsonProperty("txtFuzaishaIchiranJuriTime")
    private TextBoxTimeRange txtFuzaishaIchiranJuriTime;
    @JsonProperty("chkFuzaishaIchiranTaisho")
    private CheckBoxList chkFuzaishaIchiranTaisho;
    @JsonProperty("ccdFuzaishaIchiranShisetsuCode")
    private ShisetsuCodeSelectRangeDiv ccdFuzaishaIchiranShisetsuCode;
    @JsonProperty("ccdFuzaishaIchiranTohyokuCode")
    private TohyokuCodeSelectRangeDiv ccdFuzaishaIchiranTohyokuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtFuzaishaIchiranKofuYMD
     * @return txtFuzaishaIchiranKofuYMD
     */
    @JsonProperty("txtFuzaishaIchiranKofuYMD")
    public TextBoxDateRange getTxtFuzaishaIchiranKofuYMD() {
        return txtFuzaishaIchiranKofuYMD;
    }

    /*
     * settxtFuzaishaIchiranKofuYMD
     * @param txtFuzaishaIchiranKofuYMD txtFuzaishaIchiranKofuYMD
     */
    @JsonProperty("txtFuzaishaIchiranKofuYMD")
    public void setTxtFuzaishaIchiranKofuYMD(TextBoxDateRange txtFuzaishaIchiranKofuYMD) {
        this.txtFuzaishaIchiranKofuYMD = txtFuzaishaIchiranKofuYMD;
    }

    /*
     * gettxtFuzaishaIchiranJuriYMD
     * @return txtFuzaishaIchiranJuriYMD
     */
    @JsonProperty("txtFuzaishaIchiranJuriYMD")
    public TextBoxDateRange getTxtFuzaishaIchiranJuriYMD() {
        return txtFuzaishaIchiranJuriYMD;
    }

    /*
     * settxtFuzaishaIchiranJuriYMD
     * @param txtFuzaishaIchiranJuriYMD txtFuzaishaIchiranJuriYMD
     */
    @JsonProperty("txtFuzaishaIchiranJuriYMD")
    public void setTxtFuzaishaIchiranJuriYMD(TextBoxDateRange txtFuzaishaIchiranJuriYMD) {
        this.txtFuzaishaIchiranJuriYMD = txtFuzaishaIchiranJuriYMD;
    }

    /*
     * gettxtFuzaishaIchiranJuriTime
     * @return txtFuzaishaIchiranJuriTime
     */
    @JsonProperty("txtFuzaishaIchiranJuriTime")
    public TextBoxTimeRange getTxtFuzaishaIchiranJuriTime() {
        return txtFuzaishaIchiranJuriTime;
    }

    /*
     * settxtFuzaishaIchiranJuriTime
     * @param txtFuzaishaIchiranJuriTime txtFuzaishaIchiranJuriTime
     */
    @JsonProperty("txtFuzaishaIchiranJuriTime")
    public void setTxtFuzaishaIchiranJuriTime(TextBoxTimeRange txtFuzaishaIchiranJuriTime) {
        this.txtFuzaishaIchiranJuriTime = txtFuzaishaIchiranJuriTime;
    }

    /*
     * getchkFuzaishaIchiranTaisho
     * @return chkFuzaishaIchiranTaisho
     */
    @JsonProperty("chkFuzaishaIchiranTaisho")
    public CheckBoxList getChkFuzaishaIchiranTaisho() {
        return chkFuzaishaIchiranTaisho;
    }

    /*
     * setchkFuzaishaIchiranTaisho
     * @param chkFuzaishaIchiranTaisho chkFuzaishaIchiranTaisho
     */
    @JsonProperty("chkFuzaishaIchiranTaisho")
    public void setChkFuzaishaIchiranTaisho(CheckBoxList chkFuzaishaIchiranTaisho) {
        this.chkFuzaishaIchiranTaisho = chkFuzaishaIchiranTaisho;
    }

    /*
     * getccdFuzaishaIchiranShisetsuCode
     * @return ccdFuzaishaIchiranShisetsuCode
     */
    @JsonProperty("ccdFuzaishaIchiranShisetsuCode")
    public IShisetsuCodeSelectRangeDiv getCcdFuzaishaIchiranShisetsuCode() {
        return ccdFuzaishaIchiranShisetsuCode;
    }

    /*
     * getccdFuzaishaIchiranTohyokuCode
     * @return ccdFuzaishaIchiranTohyokuCode
     */
    @JsonProperty("ccdFuzaishaIchiranTohyokuCode")
    public ITohyokuCodeSelectRangeDiv getCcdFuzaishaIchiranTohyokuCode() {
        return ccdFuzaishaIchiranTohyokuCode;
    }

    // </editor-fold>
}
