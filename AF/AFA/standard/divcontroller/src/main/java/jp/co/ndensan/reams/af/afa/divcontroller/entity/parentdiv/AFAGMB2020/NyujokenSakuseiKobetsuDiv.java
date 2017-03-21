package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2020;
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
 * NyujokenSakuseiKobetsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class NyujokenSakuseiKobetsuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NyujokenSakuseiKobetsuParam")
    private NyujokenSakuseiKobetsuParamDiv NyujokenSakuseiKobetsuParam;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getNyujokenSakuseiKobetsuParam
     * @return NyujokenSakuseiKobetsuParam
     */
    @JsonProperty("NyujokenSakuseiKobetsuParam")
    public NyujokenSakuseiKobetsuParamDiv getNyujokenSakuseiKobetsuParam() {
        return NyujokenSakuseiKobetsuParam;
    }

    /*
     * setNyujokenSakuseiKobetsuParam
     * @param NyujokenSakuseiKobetsuParam NyujokenSakuseiKobetsuParam
     */
    @JsonProperty("NyujokenSakuseiKobetsuParam")
    public void setNyujokenSakuseiKobetsuParam(NyujokenSakuseiKobetsuParamDiv NyujokenSakuseiKobetsuParam) {
        this.NyujokenSakuseiKobetsuParam = NyujokenSakuseiKobetsuParam;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public NyujokenKobetsuSakuseiTaishoDiv getNyujokenKobetsuSakuseiTaisho() {
        return this.getNyujokenSakuseiKobetsuParam().getNyujokenKobetsuSakuseiTaisho();
    }

    @JsonIgnore
    public void  setNyujokenKobetsuSakuseiTaisho(NyujokenKobetsuSakuseiTaishoDiv NyujokenKobetsuSakuseiTaisho) {
        this.getNyujokenSakuseiKobetsuParam().setNyujokenKobetsuSakuseiTaisho(NyujokenKobetsuSakuseiTaisho);
    }

    @JsonIgnore
    public IShohonSelectDiv getCcdNyujokenKobetsuShohonSelect() {
        return this.getNyujokenSakuseiKobetsuParam().getCcdNyujokenKobetsuShohonSelect();
    }

    // </editor-fold>
}
