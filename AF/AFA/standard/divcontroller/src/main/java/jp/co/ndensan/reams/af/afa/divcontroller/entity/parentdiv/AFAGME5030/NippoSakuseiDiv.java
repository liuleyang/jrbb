package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5030;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonSenkyoList.IShohonSenkyoListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonSenkyoList.ShohonSenkyoListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NippoSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class NippoSakuseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NippoSakuseiParam")
    private NippoSakuseiParamDiv NippoSakuseiParam;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getNippoSakuseiParam
     * @return NippoSakuseiParam
     */
    @JsonProperty("NippoSakuseiParam")
    public NippoSakuseiParamDiv getNippoSakuseiParam() {
        return NippoSakuseiParam;
    }

    /*
     * setNippoSakuseiParam
     * @param NippoSakuseiParam NippoSakuseiParam
     */
    @JsonProperty("NippoSakuseiParam")
    public void setNippoSakuseiParam(NippoSakuseiParamDiv NippoSakuseiParam) {
        this.NippoSakuseiParam = NippoSakuseiParam;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public NippoSakuseiChohyoDiv getNippoSakuseiChohyo() {
        return this.getNippoSakuseiParam().getNippoSakuseiChohyo();
    }

    @JsonIgnore
    public void  setNippoSakuseiChohyo(NippoSakuseiChohyoDiv NippoSakuseiChohyo) {
        this.getNippoSakuseiParam().setNippoSakuseiChohyo(NippoSakuseiChohyo);
    }

    @JsonIgnore
    public IShohonSenkyoListDiv getCcdNippoShohonSenkyoList() {
        return this.getNippoSakuseiParam().getCcdNippoShohonSenkyoList();
    }

    // </editor-fold>
}
