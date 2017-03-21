package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1060;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuFuzuiJoho.IKaikuFuzuiJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuFuzuiJoho.KaikuFuzuiJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShikakuJoho.IShikakuJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShikakuJoho.ShikakuJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KaikuIdoShikakuJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaikuIdoShikakuJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdKaikuIdoTohyoShikakuJoho")
    private ShikakuJohoDiv ccdKaikuIdoTohyoShikakuJoho;
    @JsonProperty("ccdKaikuIdoKaikuFuzuiJoho")
    private KaikuFuzuiJohoDiv ccdKaikuIdoKaikuFuzuiJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdKaikuIdoTohyoShikakuJoho
     * @return ccdKaikuIdoTohyoShikakuJoho
     */
    @JsonProperty("ccdKaikuIdoTohyoShikakuJoho")
    public IShikakuJohoDiv getCcdKaikuIdoTohyoShikakuJoho() {
        return ccdKaikuIdoTohyoShikakuJoho;
    }

    /*
     * getccdKaikuIdoKaikuFuzuiJoho
     * @return ccdKaikuIdoKaikuFuzuiJoho
     */
    @JsonProperty("ccdKaikuIdoKaikuFuzuiJoho")
    public IKaikuFuzuiJohoDiv getCcdKaikuIdoKaikuFuzuiJoho() {
        return ccdKaikuIdoKaikuFuzuiJoho;
    }

    // </editor-fold>
}
