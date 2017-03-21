package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME3010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.BarCodeNyuryoku.BarCodeNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.BarCodeNyuryoku.IBarCodeNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KojinJoho.IKojinJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KojinJoho.KojinJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboBango.IMeiboBangoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboBango.MeiboBangoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.ITohyokuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.TohyokuCodeSelectDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TojitsuKojinJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class TojitsuKojinJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnSearchSimple")
    private ButtonDialog btnSearchSimple;
    @JsonProperty("ddlSenkyoName")
    private DropDownList ddlSenkyoName;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("txtTohyoJokyo")
    private TextBox txtTohyoJokyo;
    @JsonProperty("ccdTojitsuBarCode")
    private BarCodeNyuryokuDiv ccdTojitsuBarCode;
    @JsonProperty("ccdMeiboBango")
    private MeiboBangoDiv ccdMeiboBango;
    @JsonProperty("txtSenkyoShikaku")
    private TextBox txtSenkyoShikaku;
    @JsonProperty("ccdTohyokuCode")
    private TohyokuCodeSelectDiv ccdTohyokuCode;
    @JsonProperty("ccdShohonNameList")
    private ShohonNameListDiv ccdShohonNameList;
    @JsonProperty("ccdKojinJoho")
    private KojinJohoDiv ccdKojinJoho;
    @JsonProperty("txtHdnShikibetsuCode")
    private RString txtHdnShikibetsuCode;
    @JsonProperty("txtHdnSenkyoninFlag")
    private RString txtHdnSenkyoninFlag;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnSearchSimple
     * @return btnSearchSimple
     */
    @JsonProperty("btnSearchSimple")
    public ButtonDialog getBtnSearchSimple() {
        return btnSearchSimple;
    }

    /*
     * setbtnSearchSimple
     * @param btnSearchSimple btnSearchSimple
     */
    @JsonProperty("btnSearchSimple")
    public void setBtnSearchSimple(ButtonDialog btnSearchSimple) {
        this.btnSearchSimple = btnSearchSimple;
    }

    /*
     * getddlSenkyoName
     * @return ddlSenkyoName
     */
    @JsonProperty("ddlSenkyoName")
    public DropDownList getDdlSenkyoName() {
        return ddlSenkyoName;
    }

    /*
     * setddlSenkyoName
     * @param ddlSenkyoName ddlSenkyoName
     */
    @JsonProperty("ddlSenkyoName")
    public void setDdlSenkyoName(DropDownList ddlSenkyoName) {
        this.ddlSenkyoName = ddlSenkyoName;
    }

    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * gettxtTohyoJokyo
     * @return txtTohyoJokyo
     */
    @JsonProperty("txtTohyoJokyo")
    public TextBox getTxtTohyoJokyo() {
        return txtTohyoJokyo;
    }

    /*
     * settxtTohyoJokyo
     * @param txtTohyoJokyo txtTohyoJokyo
     */
    @JsonProperty("txtTohyoJokyo")
    public void setTxtTohyoJokyo(TextBox txtTohyoJokyo) {
        this.txtTohyoJokyo = txtTohyoJokyo;
    }

    /*
     * getccdTojitsuBarCode
     * @return ccdTojitsuBarCode
     */
    @JsonProperty("ccdTojitsuBarCode")
    public IBarCodeNyuryokuDiv getCcdTojitsuBarCode() {
        return ccdTojitsuBarCode;
    }

    /*
     * getccdMeiboBango
     * @return ccdMeiboBango
     */
    @JsonProperty("ccdMeiboBango")
    public IMeiboBangoDiv getCcdMeiboBango() {
        return ccdMeiboBango;
    }

    /*
     * gettxtSenkyoShikaku
     * @return txtSenkyoShikaku
     */
    @JsonProperty("txtSenkyoShikaku")
    public TextBox getTxtSenkyoShikaku() {
        return txtSenkyoShikaku;
    }

    /*
     * settxtSenkyoShikaku
     * @param txtSenkyoShikaku txtSenkyoShikaku
     */
    @JsonProperty("txtSenkyoShikaku")
    public void setTxtSenkyoShikaku(TextBox txtSenkyoShikaku) {
        this.txtSenkyoShikaku = txtSenkyoShikaku;
    }

    /*
     * getccdTohyokuCode
     * @return ccdTohyokuCode
     */
    @JsonProperty("ccdTohyokuCode")
    public ITohyokuCodeSelectDiv getCcdTohyokuCode() {
        return ccdTohyokuCode;
    }

    /*
     * getccdShohonNameList
     * @return ccdShohonNameList
     */
    @JsonProperty("ccdShohonNameList")
    public IShohonNameListDiv getCcdShohonNameList() {
        return ccdShohonNameList;
    }

    /*
     * getccdKojinJoho
     * @return ccdKojinJoho
     */
    @JsonProperty("ccdKojinJoho")
    public IKojinJohoDiv getCcdKojinJoho() {
        return ccdKojinJoho;
    }

    /*
     * gettxtHdnShikibetsuCode
     * @return txtHdnShikibetsuCode
     */
    @JsonProperty("txtHdnShikibetsuCode")
    public RString getTxtHdnShikibetsuCode() {
        return txtHdnShikibetsuCode;
    }

    /*
     * settxtHdnShikibetsuCode
     * @param txtHdnShikibetsuCode txtHdnShikibetsuCode
     */
    @JsonProperty("txtHdnShikibetsuCode")
    public void setTxtHdnShikibetsuCode(RString txtHdnShikibetsuCode) {
        this.txtHdnShikibetsuCode = txtHdnShikibetsuCode;
    }

    /*
     * gettxtHdnSenkyoninFlag
     * @return txtHdnSenkyoninFlag
     */
    @JsonProperty("txtHdnSenkyoninFlag")
    public RString getTxtHdnSenkyoninFlag() {
        return txtHdnSenkyoninFlag;
    }

    /*
     * settxtHdnSenkyoninFlag
     * @param txtHdnSenkyoninFlag txtHdnSenkyoninFlag
     */
    @JsonProperty("txtHdnSenkyoninFlag")
    public void setTxtHdnSenkyoninFlag(RString txtHdnSenkyoninFlag) {
        this.txtHdnSenkyoninFlag = txtHdnSenkyoninFlag;
    }

    // </editor-fold>
}
