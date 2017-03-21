package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC2010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KojinJoho.IKojinJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KojinJoho.KojinJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShikakuJoho.IShikakuJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShikakuJoho.ShikakuJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.YubinShikaku.IYubinShikakuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.YubinShikaku.YubinShikakuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * YubinShikakuToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class YubinShikakuTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdYubinTohyoShikakuJoho")
    private ShikakuJohoDiv ccdYubinTohyoShikakuJoho;
    @JsonProperty("ccdYubinKojinJoho")
    private KojinJohoDiv ccdYubinKojinJoho;
    @JsonProperty("ccdYubinShikakuJoho")
    private YubinShikakuDiv ccdYubinShikakuJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdYubinTohyoShikakuJoho
     * @return ccdYubinTohyoShikakuJoho
     */
    @JsonProperty("ccdYubinTohyoShikakuJoho")
    public IShikakuJohoDiv getCcdYubinTohyoShikakuJoho() {
        return ccdYubinTohyoShikakuJoho;
    }

    /*
     * getccdYubinKojinJoho
     * @return ccdYubinKojinJoho
     */
    @JsonProperty("ccdYubinKojinJoho")
    public IKojinJohoDiv getCcdYubinKojinJoho() {
        return ccdYubinKojinJoho;
    }

    /*
     * getccdYubinShikakuJoho
     * @return ccdYubinShikakuJoho
     */
    @JsonProperty("ccdYubinShikakuJoho")
    public IYubinShikakuDiv getCcdYubinShikakuJoho() {
        return ccdYubinShikakuJoho;
    }

    // </editor-fold>
}
