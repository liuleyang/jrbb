package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminTaishoShohonJoho.IKokuminTaishoShohonJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminTaishoShohonJoho.KokuminTaishoShohonJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KokuminTohyoJohoShusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class KokuminTohyoJohoShuseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KokuminShusei")
    private KokuminShuseiDiv KokuminShusei;
    @JsonProperty("ccdKokuminShuseiShohon")
    private KokuminTaishoShohonJohoDiv ccdKokuminShuseiShohon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKokuminShusei
     * @return KokuminShusei
     */
    @JsonProperty("KokuminShusei")
    public KokuminShuseiDiv getKokuminShusei() {
        return KokuminShusei;
    }

    /*
     * setKokuminShusei
     * @param KokuminShusei KokuminShusei
     */
    @JsonProperty("KokuminShusei")
    public void setKokuminShusei(KokuminShuseiDiv KokuminShusei) {
        this.KokuminShusei = KokuminShusei;
    }

    /*
     * getccdKokuminShuseiShohon
     * @return ccdKokuminShuseiShohon
     */
    @JsonProperty("ccdKokuminShuseiShohon")
    public IKokuminTaishoShohonJohoDiv getCcdKokuminShuseiShohon() {
        return ccdKokuminShuseiShohon;
    }

    // </editor-fold>
}
