package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB3010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KojinJoho.IKojinJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KojinJoho.KojinJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ZaigaiMeiboJoho.IZaigaiMeiboJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ZaigaiMeiboJoho.ZaigaiMeiboJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ZaigaiSakuseiChohyo.IZaigaiSakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ZaigaiSakuseiChohyo.ZaigaiSakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ZaigaiSenkyoninJoho.IZaigaiSenkyoninJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ZaigaiSenkyoninJoho.ZaigaiSenkyoninJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ZaigaiMeiboToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZaigaiMeiboTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnApproval")
    private Button btnApproval;
    @JsonProperty("ccdZaigaiMeiboKojinJoho")
    private KojinJohoDiv ccdZaigaiMeiboKojinJoho;
    @JsonProperty("ccdZaigaiMeiboJoho")
    private ZaigaiMeiboJohoDiv ccdZaigaiMeiboJoho;
    @JsonProperty("ccdZaigaiMeiboSakuseiChohyo")
    private ZaigaiSakuseiChohyoDiv ccdZaigaiMeiboSakuseiChohyo;
    @JsonProperty("ccdZaigaiMeiboSenkyoninJoho")
    private ZaigaiSenkyoninJohoDiv ccdZaigaiMeiboSenkyoninJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnApproval
     * @return btnApproval
     */
    @JsonProperty("btnApproval")
    public Button getBtnApproval() {
        return btnApproval;
    }

    /*
     * setbtnApproval
     * @param btnApproval btnApproval
     */
    @JsonProperty("btnApproval")
    public void setBtnApproval(Button btnApproval) {
        this.btnApproval = btnApproval;
    }

    /*
     * getccdZaigaiMeiboKojinJoho
     * @return ccdZaigaiMeiboKojinJoho
     */
    @JsonProperty("ccdZaigaiMeiboKojinJoho")
    public IKojinJohoDiv getCcdZaigaiMeiboKojinJoho() {
        return ccdZaigaiMeiboKojinJoho;
    }

    /*
     * getccdZaigaiMeiboJoho
     * @return ccdZaigaiMeiboJoho
     */
    @JsonProperty("ccdZaigaiMeiboJoho")
    public IZaigaiMeiboJohoDiv getCcdZaigaiMeiboJoho() {
        return ccdZaigaiMeiboJoho;
    }

    /*
     * getccdZaigaiMeiboSakuseiChohyo
     * @return ccdZaigaiMeiboSakuseiChohyo
     */
    @JsonProperty("ccdZaigaiMeiboSakuseiChohyo")
    public IZaigaiSakuseiChohyoDiv getCcdZaigaiMeiboSakuseiChohyo() {
        return ccdZaigaiMeiboSakuseiChohyo;
    }

    /*
     * getccdZaigaiMeiboSenkyoninJoho
     * @return ccdZaigaiMeiboSenkyoninJoho
     */
    @JsonProperty("ccdZaigaiMeiboSenkyoninJoho")
    public IZaigaiSenkyoninJohoDiv getCcdZaigaiMeiboSenkyoninJoho() {
        return ccdZaigaiMeiboSenkyoninJoho;
    }

    // </editor-fold>
}
