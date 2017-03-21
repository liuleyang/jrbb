package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5050;
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
 * TohyoKekkaShukeiSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class TohyoKekkaShukeiSakuseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-02-19_14-33-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TohyoKekkaShukeiSakuseiParam")
    private TohyoKekkaShukeiSakuseiParamDiv TohyoKekkaShukeiSakuseiParam;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTohyoKekkaShukeiSakuseiParam
     * @return TohyoKekkaShukeiSakuseiParam
     */
    @JsonProperty("TohyoKekkaShukeiSakuseiParam")
    public TohyoKekkaShukeiSakuseiParamDiv getTohyoKekkaShukeiSakuseiParam() {
        return TohyoKekkaShukeiSakuseiParam;
    }

    /*
     * setTohyoKekkaShukeiSakuseiParam
     * @param TohyoKekkaShukeiSakuseiParam TohyoKekkaShukeiSakuseiParam
     */
    @JsonProperty("TohyoKekkaShukeiSakuseiParam")
    public void setTohyoKekkaShukeiSakuseiParam(TohyoKekkaShukeiSakuseiParamDiv TohyoKekkaShukeiSakuseiParam) {
        this.TohyoKekkaShukeiSakuseiParam = TohyoKekkaShukeiSakuseiParam;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TohyoKekkaSakuseiChohyoDiv getTohyoKekkaSakuseiChohyo() {
        return this.getTohyoKekkaShukeiSakuseiParam().getTohyoKekkaSakuseiChohyo();
    }

    @JsonIgnore
    public void  setTohyoKekkaSakuseiChohyo(TohyoKekkaSakuseiChohyoDiv TohyoKekkaSakuseiChohyo) {
        this.getTohyoKekkaShukeiSakuseiParam().setTohyoKekkaSakuseiChohyo(TohyoKekkaSakuseiChohyo);
    }

    @JsonIgnore
    public IShohonSenkyoListDiv getCcdTohyoKekkaShohonSenkyoList() {
        return this.getTohyoKekkaShukeiSakuseiParam().getCcdTohyoKekkaShohonSenkyoList();
    }

    // </editor-fold>
}
