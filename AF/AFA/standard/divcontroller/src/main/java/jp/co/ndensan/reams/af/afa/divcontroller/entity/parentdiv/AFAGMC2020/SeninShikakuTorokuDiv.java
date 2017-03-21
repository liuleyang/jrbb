package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC2020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.FuzaishaShikaku.FuzaishaShikakuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.FuzaishaShikaku.IFuzaishaShikakuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KojinJoho.IKojinJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KojinJoho.KojinJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShikakuJoho.IShikakuJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShikakuJoho.ShikakuJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SeninShikakuToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeninShikakuTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdSeninShikakuJoho")
    private FuzaishaShikakuDiv ccdSeninShikakuJoho;
    @JsonProperty("ccdSeninTohyoShikakuJoho")
    private ShikakuJohoDiv ccdSeninTohyoShikakuJoho;
    @JsonProperty("ccdSeninKojinJoho")
    private KojinJohoDiv ccdSeninKojinJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdSeninShikakuJoho
     * @return ccdSeninShikakuJoho
     */
    @JsonProperty("ccdSeninShikakuJoho")
    public IFuzaishaShikakuDiv getCcdSeninShikakuJoho() {
        return ccdSeninShikakuJoho;
    }

    /*
     * getccdSeninTohyoShikakuJoho
     * @return ccdSeninTohyoShikakuJoho
     */
    @JsonProperty("ccdSeninTohyoShikakuJoho")
    public IShikakuJohoDiv getCcdSeninTohyoShikakuJoho() {
        return ccdSeninTohyoShikakuJoho;
    }

    /*
     * getccdSeninKojinJoho
     * @return ccdSeninKojinJoho
     */
    @JsonProperty("ccdSeninKojinJoho")
    public IKojinJohoDiv getCcdSeninKojinJoho() {
        return ccdSeninKojinJoho;
    }

    // </editor-fold>
}
