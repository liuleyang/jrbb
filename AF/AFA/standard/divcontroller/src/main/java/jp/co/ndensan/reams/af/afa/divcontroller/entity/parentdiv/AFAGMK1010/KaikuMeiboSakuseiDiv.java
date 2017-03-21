package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuSakuseiChohyo.IKaikuSakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuSakuseiChohyo.KaikuSakuseiChohyoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KaikuMeiboSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaikuMeiboSakuseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KaikuMeiboSakuseiParam")
    private KaikuMeiboSakuseiParamDiv KaikuMeiboSakuseiParam;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKaikuMeiboSakuseiParam
     * @return KaikuMeiboSakuseiParam
     */
    @JsonProperty("KaikuMeiboSakuseiParam")
    public KaikuMeiboSakuseiParamDiv getKaikuMeiboSakuseiParam() {
        return KaikuMeiboSakuseiParam;
    }

    /*
     * setKaikuMeiboSakuseiParam
     * @param KaikuMeiboSakuseiParam KaikuMeiboSakuseiParam
     */
    @JsonProperty("KaikuMeiboSakuseiParam")
    public void setKaikuMeiboSakuseiParam(KaikuMeiboSakuseiParamDiv KaikuMeiboSakuseiParam) {
        this.KaikuMeiboSakuseiParam = KaikuMeiboSakuseiParam;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public KaikuMeiboKoshinKijunDiv getKaikuMeiboKoshinKijun() {
        return this.getKaikuMeiboSakuseiParam().getKaikuMeiboKoshinKijun();
    }

    @JsonIgnore
    public void  setKaikuMeiboKoshinKijun(KaikuMeiboKoshinKijunDiv KaikuMeiboKoshinKijun) {
        this.getKaikuMeiboSakuseiParam().setKaikuMeiboKoshinKijun(KaikuMeiboKoshinKijun);
    }

    @JsonIgnore
    public IKaikuSakuseiChohyoDiv getCcdKaikuMeiboKaikuSakuseiChohyo() {
        return this.getKaikuMeiboSakuseiParam().getCcdKaikuMeiboKaikuSakuseiChohyo();
    }

    // </editor-fold>
}
