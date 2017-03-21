package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KojinJoho.IKojinJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KojinJoho.KojinJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TaishoShohonJoho.ITaishoShohonJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TaishoShohonJoho.TaishoShohonJohoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TohyokuHenko のクラスファイル 
 * 
 * @author 自動生成
 */
public class TohyokuHenkoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TohyokuHenkoMeiboBangoJoho")
    private TohyokuHenkoMeiboBangoJohoDiv TohyokuHenkoMeiboBangoJoho;
    @JsonProperty("ccdTohyokuHenkoTaishoShohonJoho")
    private TaishoShohonJohoDiv ccdTohyokuHenkoTaishoShohonJoho;
    @JsonProperty("ccdTohyokuHenkoKojinJoho")
    private KojinJohoDiv ccdTohyokuHenkoKojinJoho;
    @JsonProperty("txtHdnSenkyoShurui")
    private RString txtHdnSenkyoShurui;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTohyokuHenkoMeiboBangoJoho
     * @return TohyokuHenkoMeiboBangoJoho
     */
    @JsonProperty("TohyokuHenkoMeiboBangoJoho")
    public TohyokuHenkoMeiboBangoJohoDiv getTohyokuHenkoMeiboBangoJoho() {
        return TohyokuHenkoMeiboBangoJoho;
    }

    /*
     * setTohyokuHenkoMeiboBangoJoho
     * @param TohyokuHenkoMeiboBangoJoho TohyokuHenkoMeiboBangoJoho
     */
    @JsonProperty("TohyokuHenkoMeiboBangoJoho")
    public void setTohyokuHenkoMeiboBangoJoho(TohyokuHenkoMeiboBangoJohoDiv TohyokuHenkoMeiboBangoJoho) {
        this.TohyokuHenkoMeiboBangoJoho = TohyokuHenkoMeiboBangoJoho;
    }

    /*
     * getccdTohyokuHenkoTaishoShohonJoho
     * @return ccdTohyokuHenkoTaishoShohonJoho
     */
    @JsonProperty("ccdTohyokuHenkoTaishoShohonJoho")
    public ITaishoShohonJohoDiv getCcdTohyokuHenkoTaishoShohonJoho() {
        return ccdTohyokuHenkoTaishoShohonJoho;
    }

    /*
     * getccdTohyokuHenkoKojinJoho
     * @return ccdTohyokuHenkoKojinJoho
     */
    @JsonProperty("ccdTohyokuHenkoKojinJoho")
    public IKojinJohoDiv getCcdTohyokuHenkoKojinJoho() {
        return ccdTohyokuHenkoKojinJoho;
    }

    /*
     * gettxtHdnSenkyoShurui
     * @return txtHdnSenkyoShurui
     */
    @JsonProperty("txtHdnSenkyoShurui")
    public RString getTxtHdnSenkyoShurui() {
        return txtHdnSenkyoShurui;
    }

    /*
     * settxtHdnSenkyoShurui
     * @param txtHdnSenkyoShurui txtHdnSenkyoShurui
     */
    @JsonProperty("txtHdnSenkyoShurui")
    public void setTxtHdnSenkyoShurui(RString txtHdnSenkyoShurui) {
        this.txtHdnSenkyoShurui = txtHdnSenkyoShurui;
    }

    // </editor-fold>
}
