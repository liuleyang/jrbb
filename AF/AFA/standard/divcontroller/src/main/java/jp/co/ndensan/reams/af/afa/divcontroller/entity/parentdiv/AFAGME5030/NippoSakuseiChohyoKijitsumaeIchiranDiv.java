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
 * NippoSakuseiChohyoKijitsumaeIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class NippoSakuseiChohyoKijitsumaeIchiranDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKijitsumaeIchiranTohyoYMD")
    private TextBoxDateRange txtKijitsumaeIchiranTohyoYMD;
    @JsonProperty("txtKijitsumaeIchiranTohyoTime")
    private TextBoxTimeRange txtKijitsumaeIchiranTohyoTime;
    @JsonProperty("chkKjitsuzenIchiranTaisho")
    private CheckBoxList chkKjitsuzenIchiranTaisho;
    @JsonProperty("ccdKijitsumaeIchiranShisetsuCode")
    private ShisetsuCodeSelectRangeDiv ccdKijitsumaeIchiranShisetsuCode;
    @JsonProperty("ccdKijitsumaeIchiranTohyokuCode")
    private TohyokuCodeSelectRangeDiv ccdKijitsumaeIchiranTohyokuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKijitsumaeIchiranTohyoYMD
     * @return txtKijitsumaeIchiranTohyoYMD
     */
    @JsonProperty("txtKijitsumaeIchiranTohyoYMD")
    public TextBoxDateRange getTxtKijitsumaeIchiranTohyoYMD() {
        return txtKijitsumaeIchiranTohyoYMD;
    }

    /*
     * settxtKijitsumaeIchiranTohyoYMD
     * @param txtKijitsumaeIchiranTohyoYMD txtKijitsumaeIchiranTohyoYMD
     */
    @JsonProperty("txtKijitsumaeIchiranTohyoYMD")
    public void setTxtKijitsumaeIchiranTohyoYMD(TextBoxDateRange txtKijitsumaeIchiranTohyoYMD) {
        this.txtKijitsumaeIchiranTohyoYMD = txtKijitsumaeIchiranTohyoYMD;
    }

    /*
     * gettxtKijitsumaeIchiranTohyoTime
     * @return txtKijitsumaeIchiranTohyoTime
     */
    @JsonProperty("txtKijitsumaeIchiranTohyoTime")
    public TextBoxTimeRange getTxtKijitsumaeIchiranTohyoTime() {
        return txtKijitsumaeIchiranTohyoTime;
    }

    /*
     * settxtKijitsumaeIchiranTohyoTime
     * @param txtKijitsumaeIchiranTohyoTime txtKijitsumaeIchiranTohyoTime
     */
    @JsonProperty("txtKijitsumaeIchiranTohyoTime")
    public void setTxtKijitsumaeIchiranTohyoTime(TextBoxTimeRange txtKijitsumaeIchiranTohyoTime) {
        this.txtKijitsumaeIchiranTohyoTime = txtKijitsumaeIchiranTohyoTime;
    }

    /*
     * getchkKjitsuzenIchiranTaisho
     * @return chkKjitsuzenIchiranTaisho
     */
    @JsonProperty("chkKjitsuzenIchiranTaisho")
    public CheckBoxList getChkKjitsuzenIchiranTaisho() {
        return chkKjitsuzenIchiranTaisho;
    }

    /*
     * setchkKjitsuzenIchiranTaisho
     * @param chkKjitsuzenIchiranTaisho chkKjitsuzenIchiranTaisho
     */
    @JsonProperty("chkKjitsuzenIchiranTaisho")
    public void setChkKjitsuzenIchiranTaisho(CheckBoxList chkKjitsuzenIchiranTaisho) {
        this.chkKjitsuzenIchiranTaisho = chkKjitsuzenIchiranTaisho;
    }

    /*
     * getccdKijitsumaeIchiranShisetsuCode
     * @return ccdKijitsumaeIchiranShisetsuCode
     */
    @JsonProperty("ccdKijitsumaeIchiranShisetsuCode")
    public IShisetsuCodeSelectRangeDiv getCcdKijitsumaeIchiranShisetsuCode() {
        return ccdKijitsumaeIchiranShisetsuCode;
    }

    /*
     * getccdKijitsumaeIchiranTohyokuCode
     * @return ccdKijitsumaeIchiranTohyokuCode
     */
    @JsonProperty("ccdKijitsumaeIchiranTohyokuCode")
    public ITohyokuCodeSelectRangeDiv getCcdKijitsumaeIchiranTohyokuCode() {
        return ccdKijitsumaeIchiranTohyokuCode;
    }

    // </editor-fold>
}
