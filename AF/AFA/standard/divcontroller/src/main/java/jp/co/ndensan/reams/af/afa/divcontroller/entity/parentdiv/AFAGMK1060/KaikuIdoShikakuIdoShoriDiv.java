package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1060;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KojinJoho.IKojinJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KojinJoho.KojinJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KaikuIdoShikakuIdoShori のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaikuIdoShikakuIdoShoriDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KaikuIdoShikakuJoho")
    private KaikuIdoShikakuJohoDiv KaikuIdoShikakuJoho;
    @JsonProperty("ccdKaikuIdoKojinJoho")
    private KojinJohoDiv ccdKaikuIdoKojinJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKaikuIdoShikakuJoho
     * @return KaikuIdoShikakuJoho
     */
    @JsonProperty("KaikuIdoShikakuJoho")
    public KaikuIdoShikakuJohoDiv getKaikuIdoShikakuJoho() {
        return KaikuIdoShikakuJoho;
    }

    /*
     * setKaikuIdoShikakuJoho
     * @param KaikuIdoShikakuJoho KaikuIdoShikakuJoho
     */
    @JsonProperty("KaikuIdoShikakuJoho")
    public void setKaikuIdoShikakuJoho(KaikuIdoShikakuJohoDiv KaikuIdoShikakuJoho) {
        this.KaikuIdoShikakuJoho = KaikuIdoShikakuJoho;
    }

    /*
     * getccdKaikuIdoKojinJoho
     * @return ccdKaikuIdoKojinJoho
     */
    @JsonProperty("ccdKaikuIdoKojinJoho")
    public IKojinJohoDiv getCcdKaikuIdoKojinJoho() {
        return ccdKaikuIdoKojinJoho;
    }

    // </editor-fold>
}
