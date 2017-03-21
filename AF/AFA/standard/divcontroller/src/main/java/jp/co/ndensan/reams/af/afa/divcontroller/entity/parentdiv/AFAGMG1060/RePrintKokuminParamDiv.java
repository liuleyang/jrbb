package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1060;
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
 * RePrintKokuminParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class RePrintKokuminParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("RePrintKokuminShohonSelect")
    private RePrintKokuminShohonSelectDiv RePrintKokuminShohonSelect;
    @JsonProperty("ccdRePrintKokuminSakuseiChohy")
    private KokuminSakuseiChohyoDiv ccdRePrintKokuminSakuseiChohy;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getRePrintKokuminShohonSelect
     * @return RePrintKokuminShohonSelect
     */
    @JsonProperty("RePrintKokuminShohonSelect")
    public RePrintKokuminShohonSelectDiv getRePrintKokuminShohonSelect() {
        return RePrintKokuminShohonSelect;
    }

    /*
     * setRePrintKokuminShohonSelect
     * @param RePrintKokuminShohonSelect RePrintKokuminShohonSelect
     */
    @JsonProperty("RePrintKokuminShohonSelect")
    public void setRePrintKokuminShohonSelect(RePrintKokuminShohonSelectDiv RePrintKokuminShohonSelect) {
        this.RePrintKokuminShohonSelect = RePrintKokuminShohonSelect;
    }

    /*
     * getccdRePrintKokuminSakuseiChohy
     * @return ccdRePrintKokuminSakuseiChohy
     */
    @JsonProperty("ccdRePrintKokuminSakuseiChohy")
    public IKokuminSakuseiChohyoDiv getCcdRePrintKokuminSakuseiChohy() {
        return ccdRePrintKokuminSakuseiChohy;
    }

    // </editor-fold>
}
