package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1040;
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
 * RePrintSenkyoji のクラスファイル 
 * 
 * @author 自動生成
 */
public class RePrintSenkyojiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-02-19_14-33-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("RePrintSenkyojiParam")
    private RePrintSenkyojiParamDiv RePrintSenkyojiParam;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getRePrintSenkyojiParam
     * @return RePrintSenkyojiParam
     */
    @JsonProperty("RePrintSenkyojiParam")
    public RePrintSenkyojiParamDiv getRePrintSenkyojiParam() {
        return RePrintSenkyojiParam;
    }

    /*
     * setRePrintSenkyojiParam
     * @param RePrintSenkyojiParam RePrintSenkyojiParam
     */
    @JsonProperty("RePrintSenkyojiParam")
    public void setRePrintSenkyojiParam(RePrintSenkyojiParamDiv RePrintSenkyojiParam) {
        this.RePrintSenkyojiParam = RePrintSenkyojiParam;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RePrintSenkyojiShohonSelectDiv getRePrintSenkyojiShohonSelect() {
        return this.getRePrintSenkyojiParam().getRePrintSenkyojiShohonSelect();
    }

    @JsonIgnore
    public void  setRePrintSenkyojiShohonSelect(RePrintSenkyojiShohonSelectDiv RePrintSenkyojiShohonSelect) {
        this.getRePrintSenkyojiParam().setRePrintSenkyojiShohonSelect(RePrintSenkyojiShohonSelect);
    }

    @JsonIgnore
    public ISakuseiChohyoDiv getCcdRePrintSenkyojiSakuseiChohyo() {
        return this.getRePrintSenkyojiParam().getCcdRePrintSenkyojiSakuseiChohyo();
    }

    // </editor-fold>
}
