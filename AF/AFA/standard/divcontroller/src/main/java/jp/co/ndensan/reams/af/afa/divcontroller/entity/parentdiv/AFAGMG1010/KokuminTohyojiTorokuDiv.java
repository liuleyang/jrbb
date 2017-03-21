package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo.IKokuminSakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo.KokuminSakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminTaishoShohonJoho.IKokuminTaishoShohonJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminTaishoShohonJoho.KokuminTaishoShohonJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KokuminTohyojiToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class KokuminTohyojiTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KokuminTohyojiTorokuParam")
    private KokuminTohyojiTorokuParamDiv KokuminTohyojiTorokuParam;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKokuminTohyojiTorokuParam
     * @return KokuminTohyojiTorokuParam
     */
    @JsonProperty("KokuminTohyojiTorokuParam")
    public KokuminTohyojiTorokuParamDiv getKokuminTohyojiTorokuParam() {
        return KokuminTohyojiTorokuParam;
    }

    /*
     * setKokuminTohyojiTorokuParam
     * @param KokuminTohyojiTorokuParam KokuminTohyojiTorokuParam
     */
    @JsonProperty("KokuminTohyojiTorokuParam")
    public void setKokuminTohyojiTorokuParam(KokuminTohyojiTorokuParamDiv KokuminTohyojiTorokuParam) {
        this.KokuminTohyojiTorokuParam = KokuminTohyojiTorokuParam;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public KokuminTohyojiNyuryokuDiv getKokuminTohyojiNyuryoku() {
        return this.getKokuminTohyojiTorokuParam().getKokuminTohyojiNyuryoku();
    }

    @JsonIgnore
    public void  setKokuminTohyojiNyuryoku(KokuminTohyojiNyuryokuDiv KokuminTohyojiNyuryoku) {
        this.getKokuminTohyojiTorokuParam().setKokuminTohyojiNyuryoku(KokuminTohyojiNyuryoku);
    }

    @JsonIgnore
    public IKokuminTaishoShohonJohoDiv getCcdKokuminTohyojiMeiboKijun() {
        return this.getKokuminTohyojiTorokuParam().getCcdKokuminTohyojiMeiboKijun();
    }

    @JsonIgnore
    public IKokuminSakuseiChohyoDiv getCcdKokuminTohyojiSakuseiChohyo() {
        return this.getKokuminTohyojiTorokuParam().getCcdKokuminTohyojiSakuseiChohyo();
    }

    // </editor-fold>
}
