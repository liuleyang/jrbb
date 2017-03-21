package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB3020;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ZaigaiHenko のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZaigaiHenkoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdZaigaiHenkoKojinJoho")
    private KojinJohoDiv ccdZaigaiHenkoKojinJoho;
    @JsonProperty("ccdZaigaiHenkoJoho")
    private ZaigaiMeiboJohoDiv ccdZaigaiHenkoJoho;
    @JsonProperty("ccdZaigaiHenkoSakuseiChohyo")
    private ZaigaiSakuseiChohyoDiv ccdZaigaiHenkoSakuseiChohyo;
    @JsonProperty("ccdZaigaiHenkoSenkyoninJoho")
    private ZaigaiSenkyoninJohoDiv ccdZaigaiHenkoSenkyoninJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdZaigaiHenkoKojinJoho
     * @return ccdZaigaiHenkoKojinJoho
     */
    @JsonProperty("ccdZaigaiHenkoKojinJoho")
    public IKojinJohoDiv getCcdZaigaiHenkoKojinJoho() {
        return ccdZaigaiHenkoKojinJoho;
    }

    /*
     * getccdZaigaiHenkoJoho
     * @return ccdZaigaiHenkoJoho
     */
    @JsonProperty("ccdZaigaiHenkoJoho")
    public IZaigaiMeiboJohoDiv getCcdZaigaiHenkoJoho() {
        return ccdZaigaiHenkoJoho;
    }

    /*
     * getccdZaigaiHenkoSakuseiChohyo
     * @return ccdZaigaiHenkoSakuseiChohyo
     */
    @JsonProperty("ccdZaigaiHenkoSakuseiChohyo")
    public IZaigaiSakuseiChohyoDiv getCcdZaigaiHenkoSakuseiChohyo() {
        return ccdZaigaiHenkoSakuseiChohyo;
    }

    /*
     * getccdZaigaiHenkoSenkyoninJoho
     * @return ccdZaigaiHenkoSenkyoninJoho
     */
    @JsonProperty("ccdZaigaiHenkoSenkyoninJoho")
    public IZaigaiSenkyoninJohoDiv getCcdZaigaiHenkoSenkyoninJoho() {
        return ccdZaigaiHenkoSenkyoninJoho;
    }

    // </editor-fold>
}
