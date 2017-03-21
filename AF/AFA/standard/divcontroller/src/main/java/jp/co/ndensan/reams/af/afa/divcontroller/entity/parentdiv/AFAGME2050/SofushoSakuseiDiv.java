package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2050;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonSenkyoList.IShohonSenkyoListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SofushoSakusei のクラスファイル
 *
 * @author 自動生成
 */
public class SofushoSakuseiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SofushoSakuseiParam")
    private SofushoSakuseiParamDiv SofushoSakuseiParam;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSofushoSakuseiParam
     * @return SofushoSakuseiParam
     */
    @JsonProperty("SofushoSakuseiParam")
    public SofushoSakuseiParamDiv getSofushoSakuseiParam() {
        return SofushoSakuseiParam;
    }

    /*
     * setSofushoSakuseiParam
     * @param SofushoSakuseiParam SofushoSakuseiParam
     */
    @JsonProperty("SofushoSakuseiParam")
    public void setSofushoSakuseiParam(SofushoSakuseiParamDiv SofushoSakuseiParam) {
        this.SofushoSakuseiParam = SofushoSakuseiParam;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IShohonSenkyoListDiv getCcdSofushoShohonSenkyoList() {
        return this.getSofushoSakuseiParam().getCcdSofushoShohonSenkyoList();
    }

    @JsonIgnore
    public SofushoSakuseiJokenDiv getSofushoSakuseiJoken() {
        return this.getSofushoSakuseiParam().getSofushoSakuseiJoken();
    }

    @JsonIgnore
    public void setSofushoSakuseiJoken(SofushoSakuseiJokenDiv SofushoSakuseiJoken) {
        this.getSofushoSakuseiParam().setSofushoSakuseiJoken(SofushoSakuseiJoken);
    }

    // </editor-fold>
}
