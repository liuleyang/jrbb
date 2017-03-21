package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1030;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyo.ISakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyo.SakuseiChohyoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * RePrintTeiji のクラスファイル 
 * 
 * @author 自動生成
 */
public class RePrintTeijiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-04-25_11-07-54">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("RePrintTeijiParam")
    private RePrintTeijiParamDiv RePrintTeijiParam;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getRePrintTeijiParam
     * @return RePrintTeijiParam
     */
    @JsonProperty("RePrintTeijiParam")
    public RePrintTeijiParamDiv getRePrintTeijiParam() {
        return RePrintTeijiParam;
    }

    /*
     * setRePrintTeijiParam
     * @param RePrintTeijiParam RePrintTeijiParam
     */
    @JsonProperty("RePrintTeijiParam")
    public void setRePrintTeijiParam(RePrintTeijiParamDiv RePrintTeijiParam) {
        this.RePrintTeijiParam = RePrintTeijiParam;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RePrintTeijiShohonSelectDiv getRePrintTeijiShohonSelect() {
        return this.getRePrintTeijiParam().getRePrintTeijiShohonSelect();
    }

    @JsonIgnore
    public void  setRePrintTeijiShohonSelect(RePrintTeijiShohonSelectDiv RePrintTeijiShohonSelect) {
        this.getRePrintTeijiParam().setRePrintTeijiShohonSelect(RePrintTeijiShohonSelect);
    }

    @JsonIgnore
    public ISakuseiChohyoDiv getCcdRePrintTeijiSakuseiChohyo() {
        return this.getRePrintTeijiParam().getCcdRePrintTeijiSakuseiChohyo();
    }

    // </editor-fold>
}
