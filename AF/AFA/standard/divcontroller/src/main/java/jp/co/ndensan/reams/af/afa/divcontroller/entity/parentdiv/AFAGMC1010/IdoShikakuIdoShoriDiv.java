package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC1010;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IdoShikakuIdoShori のクラスファイル 
 * 
 * @author 自動生成
 */
public class IdoShikakuIdoShoriDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdIdoShikakuJoho")
    private ShikakuJohoDiv ccdIdoShikakuJoho;
    @JsonProperty("ccdIdoKojinJoho")
    private KojinJohoDiv ccdIdoKojinJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdIdoShikakuJoho
     * @return ccdIdoShikakuJoho
     */
    @JsonProperty("ccdIdoShikakuJoho")
    public IShikakuJohoDiv getCcdIdoShikakuJoho() {
        return ccdIdoShikakuJoho;
    }

    /*
     * getccdIdoKojinJoho
     * @return ccdIdoKojinJoho
     */
    @JsonProperty("ccdIdoKojinJoho")
    public IKojinJohoDiv getCcdIdoKojinJoho() {
        return ccdIdoKojinJoho;
    }

    // </editor-fold>
}
