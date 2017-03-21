package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC2030;
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
 * NankyokuShikakuToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class NankyokuShikakuTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdNankyokuShikakuJoho")
    private FuzaishaShikakuDiv ccdNankyokuShikakuJoho;
    @JsonProperty("ccdNankyokuTohyoShikakuJoho")
    private ShikakuJohoDiv ccdNankyokuTohyoShikakuJoho;
    @JsonProperty("ccdNankyokuKojinJoho")
    private KojinJohoDiv ccdNankyokuKojinJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdNankyokuShikakuJoho
     * @return ccdNankyokuShikakuJoho
     */
    @JsonProperty("ccdNankyokuShikakuJoho")
    public IFuzaishaShikakuDiv getCcdNankyokuShikakuJoho() {
        return ccdNankyokuShikakuJoho;
    }

    /*
     * getccdNankyokuTohyoShikakuJoho
     * @return ccdNankyokuTohyoShikakuJoho
     */
    @JsonProperty("ccdNankyokuTohyoShikakuJoho")
    public IShikakuJohoDiv getCcdNankyokuTohyoShikakuJoho() {
        return ccdNankyokuTohyoShikakuJoho;
    }

    /*
     * getccdNankyokuKojinJoho
     * @return ccdNankyokuKojinJoho
     */
    @JsonProperty("ccdNankyokuKojinJoho")
    public IKojinJohoDiv getCcdNankyokuKojinJoho() {
        return ccdNankyokuKojinJoho;
    }

    // </editor-fold>
}
