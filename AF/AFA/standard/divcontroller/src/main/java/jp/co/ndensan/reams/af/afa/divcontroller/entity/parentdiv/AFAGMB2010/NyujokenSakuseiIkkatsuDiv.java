package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonSelect.IShohonSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonSelect.ShohonSelectDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NyujokenSakuseiIkkatsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class NyujokenSakuseiIkkatsuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NyujokenSakuseiIkkatsuParam")
    private NyujokenSakuseiIkkatsuParamDiv NyujokenSakuseiIkkatsuParam;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getNyujokenSakuseiIkkatsuParam
     * @return NyujokenSakuseiIkkatsuParam
     */
    @JsonProperty("NyujokenSakuseiIkkatsuParam")
    public NyujokenSakuseiIkkatsuParamDiv getNyujokenSakuseiIkkatsuParam() {
        return NyujokenSakuseiIkkatsuParam;
    }

    /*
     * setNyujokenSakuseiIkkatsuParam
     * @param NyujokenSakuseiIkkatsuParam NyujokenSakuseiIkkatsuParam
     */
    @JsonProperty("NyujokenSakuseiIkkatsuParam")
    public void setNyujokenSakuseiIkkatsuParam(NyujokenSakuseiIkkatsuParamDiv NyujokenSakuseiIkkatsuParam) {
        this.NyujokenSakuseiIkkatsuParam = NyujokenSakuseiIkkatsuParam;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public NyujokenSakuseiTaishoDiv getNyujokenSakuseiTaisho() {
        return this.getNyujokenSakuseiIkkatsuParam().getNyujokenSakuseiTaisho();
    }

    @JsonIgnore
    public void  setNyujokenSakuseiTaisho(NyujokenSakuseiTaishoDiv NyujokenSakuseiTaisho) {
        this.getNyujokenSakuseiIkkatsuParam().setNyujokenSakuseiTaisho(NyujokenSakuseiTaisho);
    }

    @JsonIgnore
    public IShohonSelectDiv getCcdNyujokenShohonSelect() {
        return this.getNyujokenSakuseiIkkatsuParam().getCcdNyujokenShohonSelect();
    }

    // </editor-fold>
}
