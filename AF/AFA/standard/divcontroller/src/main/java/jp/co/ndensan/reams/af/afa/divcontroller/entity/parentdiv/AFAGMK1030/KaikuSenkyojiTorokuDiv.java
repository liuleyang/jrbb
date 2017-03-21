package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1030;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuSakuseiChohyo.IKaikuSakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuTaishoShohonJoho.IKaikuTaishoShohonJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KaikuSenkyojiToroku のクラスファイル
 *
 * @author 自動生成
 */
public class KaikuSenkyojiTorokuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KaikuSenkyojiTorokuParam")
    private KaikuSenkyojiTorokuParamDiv KaikuSenkyojiTorokuParam;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKaikuSenkyojiTorokuParam
     * @return KaikuSenkyojiTorokuParam
     */
    @JsonProperty("KaikuSenkyojiTorokuParam")
    public KaikuSenkyojiTorokuParamDiv getKaikuSenkyojiTorokuParam() {
        return KaikuSenkyojiTorokuParam;
    }

    /*
     * setKaikuSenkyojiTorokuParam
     * @param KaikuSenkyojiTorokuParam KaikuSenkyojiTorokuParam
     */
    @JsonProperty("KaikuSenkyojiTorokuParam")
    public void setKaikuSenkyojiTorokuParam(KaikuSenkyojiTorokuParamDiv KaikuSenkyojiTorokuParam) {
        this.KaikuSenkyojiTorokuParam = KaikuSenkyojiTorokuParam;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaikuSakuseiChohyoDiv getCcdKaikuSenkyojiSakuseiChohyo() {
        return this.getKaikuSenkyojiTorokuParam().getCcdKaikuSenkyojiSakuseiChohyo();
    }

    @JsonIgnore
    public IKaikuTaishoShohonJohoDiv getCcdKaikuSenkyojiSenkyoNyuryoku() {
        return this.getKaikuSenkyojiTorokuParam().getCcdKaikuSenkyojiSenkyoNyuryoku();
    }

    // </editor-fold>
}
