package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1050;
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
 * KokuminNewMeiboSaishinka のクラスファイル 
 * 
 * @author 自動生成
 */
public class KokuminNewMeiboSaishinkaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KokuminNewMeiboSaishinkaParam")
    private KokuminNewMeiboSaishinkaParamDiv KokuminNewMeiboSaishinkaParam;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKokuminNewMeiboSaishinkaParam
     * @return KokuminNewMeiboSaishinkaParam
     */
    @JsonProperty("KokuminNewMeiboSaishinkaParam")
    public KokuminNewMeiboSaishinkaParamDiv getKokuminNewMeiboSaishinkaParam() {
        return KokuminNewMeiboSaishinkaParam;
    }

    /*
     * setKokuminNewMeiboSaishinkaParam
     * @param KokuminNewMeiboSaishinkaParam KokuminNewMeiboSaishinkaParam
     */
    @JsonProperty("KokuminNewMeiboSaishinkaParam")
    public void setKokuminNewMeiboSaishinkaParam(KokuminNewMeiboSaishinkaParamDiv KokuminNewMeiboSaishinkaParam) {
        this.KokuminNewMeiboSaishinkaParam = KokuminNewMeiboSaishinkaParam;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public KokuminNewShohonSelectDiv getKokuminNewShohonSelect() {
        return this.getKokuminNewMeiboSaishinkaParam().getKokuminNewShohonSelect();
    }

    @JsonIgnore
    public void  setKokuminNewShohonSelect(KokuminNewShohonSelectDiv KokuminNewShohonSelect) {
        this.getKokuminNewMeiboSaishinkaParam().setKokuminNewShohonSelect(KokuminNewShohonSelect);
    }

    @JsonIgnore
    public KokuminNewJokenDiv getKokuminNewJoken() {
        return this.getKokuminNewMeiboSaishinkaParam().getKokuminNewJoken();
    }

    @JsonIgnore
    public void  setKokuminNewJoken(KokuminNewJokenDiv KokuminNewJoken) {
        this.getKokuminNewMeiboSaishinkaParam().setKokuminNewJoken(KokuminNewJoken);
    }

    @JsonIgnore
    public IKokuminSakuseiChohyoDiv getCcdKokuminNewSakuseiChohyo() {
        return this.getKokuminNewMeiboSaishinkaParam().getCcdKokuminNewSakuseiChohyo();
    }

    // </editor-fold>
}
