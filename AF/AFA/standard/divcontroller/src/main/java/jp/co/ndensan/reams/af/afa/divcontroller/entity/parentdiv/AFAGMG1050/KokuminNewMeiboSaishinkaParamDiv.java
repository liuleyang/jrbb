package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1050;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo.IKokuminSakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo.KokuminSakuseiChohyoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * KokuminNewMeiboSaishinkaParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class KokuminNewMeiboSaishinkaParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KokuminNewShohonSelect")
    private KokuminNewShohonSelectDiv KokuminNewShohonSelect;
    @JsonProperty("KokuminNewJoken")
    private KokuminNewJokenDiv KokuminNewJoken;
    @JsonProperty("ccdKokuminNewSakuseiChohyo")
    private KokuminSakuseiChohyoDiv ccdKokuminNewSakuseiChohyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKokuminNewShohonSelect
     * @return KokuminNewShohonSelect
     */
    @JsonProperty("KokuminNewShohonSelect")
    public KokuminNewShohonSelectDiv getKokuminNewShohonSelect() {
        return KokuminNewShohonSelect;
    }

    /*
     * setKokuminNewShohonSelect
     * @param KokuminNewShohonSelect KokuminNewShohonSelect
     */
    @JsonProperty("KokuminNewShohonSelect")
    public void setKokuminNewShohonSelect(KokuminNewShohonSelectDiv KokuminNewShohonSelect) {
        this.KokuminNewShohonSelect = KokuminNewShohonSelect;
    }

    /*
     * getKokuminNewJoken
     * @return KokuminNewJoken
     */
    @JsonProperty("KokuminNewJoken")
    public KokuminNewJokenDiv getKokuminNewJoken() {
        return KokuminNewJoken;
    }

    /*
     * setKokuminNewJoken
     * @param KokuminNewJoken KokuminNewJoken
     */
    @JsonProperty("KokuminNewJoken")
    public void setKokuminNewJoken(KokuminNewJokenDiv KokuminNewJoken) {
        this.KokuminNewJoken = KokuminNewJoken;
    }

    /*
     * getccdKokuminNewSakuseiChohyo
     * @return ccdKokuminNewSakuseiChohyo
     */
    @JsonProperty("ccdKokuminNewSakuseiChohyo")
    public IKokuminSakuseiChohyoDiv getCcdKokuminNewSakuseiChohyo() {
        return ccdKokuminNewSakuseiChohyo;
    }

    // </editor-fold>
}
