package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5030;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JiyuNameList.IJiyuNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JiyuNameList.JiyuNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelectRange.IShisetsuCodeSelectRangeDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelectRange.ShisetsuCodeSelectRangeDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelectRange.ITohyokuCodeSelectRangeDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelectRange.TohyokuCodeSelectRangeDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * NippoSakuseiChohyoTohyoshaIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class NippoSakuseiChohyoTohyoshaIchiranDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkKonzaiPrint")
    private CheckBoxList chkKonzaiPrint;
    @JsonProperty("chkTohyoshaIchiranKijitsumae")
    private CheckBoxList chkTohyoshaIchiranKijitsumae;
    @JsonProperty("txtTohyoshaIchiranTohyoYMD")
    private TextBoxDateRange txtTohyoshaIchiranTohyoYMD;
    @JsonProperty("txtTohyoshaIchiranTohyoTime")
    private TextBoxTimeRange txtTohyoshaIchiranTohyoTime;
    @JsonProperty("chkTohyoshaIchiranKijitsumaeTaisho")
    private CheckBoxList chkTohyoshaIchiranKijitsumaeTaisho;
    @JsonProperty("chkTohyoshaIchiranFuzaisha")
    private CheckBoxList chkTohyoshaIchiranFuzaisha;
    @JsonProperty("txtTohyoshaIchiranKofuYMD")
    private TextBoxDateRange txtTohyoshaIchiranKofuYMD;
    @JsonProperty("txtTohyoshaIchiranJuriYMD")
    private TextBoxDateRange txtTohyoshaIchiranJuriYMD;
    @JsonProperty("txtTohyoshaIchiranJuriTime")
    private TextBoxTimeRange txtTohyoshaIchiranJuriTime;
    @JsonProperty("chkTohyoshaIchiranFuzaishaTaisho")
    private CheckBoxList chkTohyoshaIchiranFuzaishaTaisho;
    @JsonProperty("ccdTohyoJiyu")
    private JiyuNameListDiv ccdTohyoJiyu;
    @JsonProperty("ccdTohyoshaIchiranTohyokuCode")
    private TohyokuCodeSelectRangeDiv ccdTohyoshaIchiranTohyokuCode;
    @JsonProperty("ccdTohyoshaIchiranShisetsuCode")
    private ShisetsuCodeSelectRangeDiv ccdTohyoshaIchiranShisetsuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkKonzaiPrint
     * @return chkKonzaiPrint
     */
    @JsonProperty("chkKonzaiPrint")
    public CheckBoxList getChkKonzaiPrint() {
        return chkKonzaiPrint;
    }

    /*
     * setchkKonzaiPrint
     * @param chkKonzaiPrint chkKonzaiPrint
     */
    @JsonProperty("chkKonzaiPrint")
    public void setChkKonzaiPrint(CheckBoxList chkKonzaiPrint) {
        this.chkKonzaiPrint = chkKonzaiPrint;
    }

    /*
     * getchkTohyoshaIchiranKijitsumae
     * @return chkTohyoshaIchiranKijitsumae
     */
    @JsonProperty("chkTohyoshaIchiranKijitsumae")
    public CheckBoxList getChkTohyoshaIchiranKijitsumae() {
        return chkTohyoshaIchiranKijitsumae;
    }

    /*
     * setchkTohyoshaIchiranKijitsumae
     * @param chkTohyoshaIchiranKijitsumae chkTohyoshaIchiranKijitsumae
     */
    @JsonProperty("chkTohyoshaIchiranKijitsumae")
    public void setChkTohyoshaIchiranKijitsumae(CheckBoxList chkTohyoshaIchiranKijitsumae) {
        this.chkTohyoshaIchiranKijitsumae = chkTohyoshaIchiranKijitsumae;
    }

    /*
     * gettxtTohyoshaIchiranTohyoYMD
     * @return txtTohyoshaIchiranTohyoYMD
     */
    @JsonProperty("txtTohyoshaIchiranTohyoYMD")
    public TextBoxDateRange getTxtTohyoshaIchiranTohyoYMD() {
        return txtTohyoshaIchiranTohyoYMD;
    }

    /*
     * settxtTohyoshaIchiranTohyoYMD
     * @param txtTohyoshaIchiranTohyoYMD txtTohyoshaIchiranTohyoYMD
     */
    @JsonProperty("txtTohyoshaIchiranTohyoYMD")
    public void setTxtTohyoshaIchiranTohyoYMD(TextBoxDateRange txtTohyoshaIchiranTohyoYMD) {
        this.txtTohyoshaIchiranTohyoYMD = txtTohyoshaIchiranTohyoYMD;
    }

    /*
     * gettxtTohyoshaIchiranTohyoTime
     * @return txtTohyoshaIchiranTohyoTime
     */
    @JsonProperty("txtTohyoshaIchiranTohyoTime")
    public TextBoxTimeRange getTxtTohyoshaIchiranTohyoTime() {
        return txtTohyoshaIchiranTohyoTime;
    }

    /*
     * settxtTohyoshaIchiranTohyoTime
     * @param txtTohyoshaIchiranTohyoTime txtTohyoshaIchiranTohyoTime
     */
    @JsonProperty("txtTohyoshaIchiranTohyoTime")
    public void setTxtTohyoshaIchiranTohyoTime(TextBoxTimeRange txtTohyoshaIchiranTohyoTime) {
        this.txtTohyoshaIchiranTohyoTime = txtTohyoshaIchiranTohyoTime;
    }

    /*
     * getchkTohyoshaIchiranKijitsumaeTaisho
     * @return chkTohyoshaIchiranKijitsumaeTaisho
     */
    @JsonProperty("chkTohyoshaIchiranKijitsumaeTaisho")
    public CheckBoxList getChkTohyoshaIchiranKijitsumaeTaisho() {
        return chkTohyoshaIchiranKijitsumaeTaisho;
    }

    /*
     * setchkTohyoshaIchiranKijitsumaeTaisho
     * @param chkTohyoshaIchiranKijitsumaeTaisho chkTohyoshaIchiranKijitsumaeTaisho
     */
    @JsonProperty("chkTohyoshaIchiranKijitsumaeTaisho")
    public void setChkTohyoshaIchiranKijitsumaeTaisho(CheckBoxList chkTohyoshaIchiranKijitsumaeTaisho) {
        this.chkTohyoshaIchiranKijitsumaeTaisho = chkTohyoshaIchiranKijitsumaeTaisho;
    }

    /*
     * getchkTohyoshaIchiranFuzaisha
     * @return chkTohyoshaIchiranFuzaisha
     */
    @JsonProperty("chkTohyoshaIchiranFuzaisha")
    public CheckBoxList getChkTohyoshaIchiranFuzaisha() {
        return chkTohyoshaIchiranFuzaisha;
    }

    /*
     * setchkTohyoshaIchiranFuzaisha
     * @param chkTohyoshaIchiranFuzaisha chkTohyoshaIchiranFuzaisha
     */
    @JsonProperty("chkTohyoshaIchiranFuzaisha")
    public void setChkTohyoshaIchiranFuzaisha(CheckBoxList chkTohyoshaIchiranFuzaisha) {
        this.chkTohyoshaIchiranFuzaisha = chkTohyoshaIchiranFuzaisha;
    }

    /*
     * gettxtTohyoshaIchiranKofuYMD
     * @return txtTohyoshaIchiranKofuYMD
     */
    @JsonProperty("txtTohyoshaIchiranKofuYMD")
    public TextBoxDateRange getTxtTohyoshaIchiranKofuYMD() {
        return txtTohyoshaIchiranKofuYMD;
    }

    /*
     * settxtTohyoshaIchiranKofuYMD
     * @param txtTohyoshaIchiranKofuYMD txtTohyoshaIchiranKofuYMD
     */
    @JsonProperty("txtTohyoshaIchiranKofuYMD")
    public void setTxtTohyoshaIchiranKofuYMD(TextBoxDateRange txtTohyoshaIchiranKofuYMD) {
        this.txtTohyoshaIchiranKofuYMD = txtTohyoshaIchiranKofuYMD;
    }

    /*
     * gettxtTohyoshaIchiranJuriYMD
     * @return txtTohyoshaIchiranJuriYMD
     */
    @JsonProperty("txtTohyoshaIchiranJuriYMD")
    public TextBoxDateRange getTxtTohyoshaIchiranJuriYMD() {
        return txtTohyoshaIchiranJuriYMD;
    }

    /*
     * settxtTohyoshaIchiranJuriYMD
     * @param txtTohyoshaIchiranJuriYMD txtTohyoshaIchiranJuriYMD
     */
    @JsonProperty("txtTohyoshaIchiranJuriYMD")
    public void setTxtTohyoshaIchiranJuriYMD(TextBoxDateRange txtTohyoshaIchiranJuriYMD) {
        this.txtTohyoshaIchiranJuriYMD = txtTohyoshaIchiranJuriYMD;
    }

    /*
     * gettxtTohyoshaIchiranJuriTime
     * @return txtTohyoshaIchiranJuriTime
     */
    @JsonProperty("txtTohyoshaIchiranJuriTime")
    public TextBoxTimeRange getTxtTohyoshaIchiranJuriTime() {
        return txtTohyoshaIchiranJuriTime;
    }

    /*
     * settxtTohyoshaIchiranJuriTime
     * @param txtTohyoshaIchiranJuriTime txtTohyoshaIchiranJuriTime
     */
    @JsonProperty("txtTohyoshaIchiranJuriTime")
    public void setTxtTohyoshaIchiranJuriTime(TextBoxTimeRange txtTohyoshaIchiranJuriTime) {
        this.txtTohyoshaIchiranJuriTime = txtTohyoshaIchiranJuriTime;
    }

    /*
     * getchkTohyoshaIchiranFuzaishaTaisho
     * @return chkTohyoshaIchiranFuzaishaTaisho
     */
    @JsonProperty("chkTohyoshaIchiranFuzaishaTaisho")
    public CheckBoxList getChkTohyoshaIchiranFuzaishaTaisho() {
        return chkTohyoshaIchiranFuzaishaTaisho;
    }

    /*
     * setchkTohyoshaIchiranFuzaishaTaisho
     * @param chkTohyoshaIchiranFuzaishaTaisho chkTohyoshaIchiranFuzaishaTaisho
     */
    @JsonProperty("chkTohyoshaIchiranFuzaishaTaisho")
    public void setChkTohyoshaIchiranFuzaishaTaisho(CheckBoxList chkTohyoshaIchiranFuzaishaTaisho) {
        this.chkTohyoshaIchiranFuzaishaTaisho = chkTohyoshaIchiranFuzaishaTaisho;
    }

    /*
     * getccdTohyoJiyu
     * @return ccdTohyoJiyu
     */
    @JsonProperty("ccdTohyoJiyu")
    public IJiyuNameListDiv getCcdTohyoJiyu() {
        return ccdTohyoJiyu;
    }

    /*
     * getccdTohyoshaIchiranTohyokuCode
     * @return ccdTohyoshaIchiranTohyokuCode
     */
    @JsonProperty("ccdTohyoshaIchiranTohyokuCode")
    public ITohyokuCodeSelectRangeDiv getCcdTohyoshaIchiranTohyokuCode() {
        return ccdTohyoshaIchiranTohyokuCode;
    }

    /*
     * getccdTohyoshaIchiranShisetsuCode
     * @return ccdTohyoshaIchiranShisetsuCode
     */
    @JsonProperty("ccdTohyoshaIchiranShisetsuCode")
    public IShisetsuCodeSelectRangeDiv getCcdTohyoshaIchiranShisetsuCode() {
        return ccdTohyoshaIchiranShisetsuCode;
    }

    // </editor-fold>
}
