package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040;
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
 * ZenjitsuSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZenjitsuSakuseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-02-19_14-33-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ZenjitsuSakuseiParam")
    private ZenjitsuSakuseiParamDiv ZenjitsuSakuseiParam;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getZenjitsuSakuseiParam
     * @return ZenjitsuSakuseiParam
     */
    @JsonProperty("ZenjitsuSakuseiParam")
    public ZenjitsuSakuseiParamDiv getZenjitsuSakuseiParam() {
        return ZenjitsuSakuseiParam;
    }

    /*
     * setZenjitsuSakuseiParam
     * @param ZenjitsuSakuseiParam ZenjitsuSakuseiParam
     */
    @JsonProperty("ZenjitsuSakuseiParam")
    public void setZenjitsuSakuseiParam(ZenjitsuSakuseiParamDiv ZenjitsuSakuseiParam) {
        this.ZenjitsuSakuseiParam = ZenjitsuSakuseiParam;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ZenjitsuSakuseiChohyoDiv getZenjitsuSakuseiChohyo() {
        return this.getZenjitsuSakuseiParam().getZenjitsuSakuseiChohyo();
    }

    @JsonIgnore
    public void  setZenjitsuSakuseiChohyo(ZenjitsuSakuseiChohyoDiv ZenjitsuSakuseiChohyo) {
        this.getZenjitsuSakuseiParam().setZenjitsuSakuseiChohyo(ZenjitsuSakuseiChohyo);
    }

    @JsonIgnore
    public IShohonSenkyoListDiv getCcdZenjitsuShohonSenkyoList() {
        return this.getZenjitsuSakuseiParam().getCcdZenjitsuShohonSenkyoList();
    }

    // </editor-fold>
}
