package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2050;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.HakkoBango.HakkoBangoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.HakkoBango.IHakkoBangoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelectRange.IShisetsuCodeSelectRangeDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelectRange.ShisetsuCodeSelectRangeDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SofushoSakuseiJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class SofushoSakuseiJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHakkoYMD")
    private TextBoxDate txtHakkoYMD;
    @JsonProperty("linLine")
    private HorizontalLine linLine;
    @JsonProperty("txtKofuYMD")
    private TextBoxDateRange txtKofuYMD;
    @JsonProperty("ccdHakkoBango")
    private HakkoBangoDiv ccdHakkoBango;
    @JsonProperty("ccdShisetsuCode")
    private ShisetsuCodeSelectRangeDiv ccdShisetsuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHakkoYMD
     * @return txtHakkoYMD
     */
    @JsonProperty("txtHakkoYMD")
    public TextBoxDate getTxtHakkoYMD() {
        return txtHakkoYMD;
    }

    /*
     * settxtHakkoYMD
     * @param txtHakkoYMD txtHakkoYMD
     */
    @JsonProperty("txtHakkoYMD")
    public void setTxtHakkoYMD(TextBoxDate txtHakkoYMD) {
        this.txtHakkoYMD = txtHakkoYMD;
    }

    /*
     * getlinLine
     * @return linLine
     */
    @JsonProperty("linLine")
    public HorizontalLine getLinLine() {
        return linLine;
    }

    /*
     * setlinLine
     * @param linLine linLine
     */
    @JsonProperty("linLine")
    public void setLinLine(HorizontalLine linLine) {
        this.linLine = linLine;
    }

    /*
     * gettxtKofuYMD
     * @return txtKofuYMD
     */
    @JsonProperty("txtKofuYMD")
    public TextBoxDateRange getTxtKofuYMD() {
        return txtKofuYMD;
    }

    /*
     * settxtKofuYMD
     * @param txtKofuYMD txtKofuYMD
     */
    @JsonProperty("txtKofuYMD")
    public void setTxtKofuYMD(TextBoxDateRange txtKofuYMD) {
        this.txtKofuYMD = txtKofuYMD;
    }

    /*
     * getccdHakkoBango
     * @return ccdHakkoBango
     */
    @JsonProperty("ccdHakkoBango")
    public IHakkoBangoDiv getCcdHakkoBango() {
        return ccdHakkoBango;
    }

    /*
     * getccdShisetsuCode
     * @return ccdShisetsuCode
     */
    @JsonProperty("ccdShisetsuCode")
    public IShisetsuCodeSelectRangeDiv getCcdShisetsuCode() {
        return ccdShisetsuCode;
    }

    // </editor-fold>
}
