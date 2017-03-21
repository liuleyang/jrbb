package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1060;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo.IKokuminSakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo.KokuminSakuseiChohyoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * RePrintKokumin のクラスファイル 
 * 
 * @author 自動生成
 */
public class RePrintKokuminDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("RePrintKokuminParam")
    private RePrintKokuminParamDiv RePrintKokuminParam;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getRePrintKokuminParam
     * @return RePrintKokuminParam
     */
    @JsonProperty("RePrintKokuminParam")
    public RePrintKokuminParamDiv getRePrintKokuminParam() {
        return RePrintKokuminParam;
    }

    /*
     * setRePrintKokuminParam
     * @param RePrintKokuminParam RePrintKokuminParam
     */
    @JsonProperty("RePrintKokuminParam")
    public void setRePrintKokuminParam(RePrintKokuminParamDiv RePrintKokuminParam) {
        this.RePrintKokuminParam = RePrintKokuminParam;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RePrintKokuminShohonSelectDiv getRePrintKokuminShohonSelect() {
        return this.getRePrintKokuminParam().getRePrintKokuminShohonSelect();
    }

    @JsonIgnore
    public void  setRePrintKokuminShohonSelect(RePrintKokuminShohonSelectDiv RePrintKokuminShohonSelect) {
        this.getRePrintKokuminParam().setRePrintKokuminShohonSelect(RePrintKokuminShohonSelect);
    }

    @JsonIgnore
    public IKokuminSakuseiChohyoDiv getCcdRePrintKokuminSakuseiChohy() {
        return this.getRePrintKokuminParam().getCcdRePrintKokuminSakuseiChohy();
    }

    // </editor-fold>
}
