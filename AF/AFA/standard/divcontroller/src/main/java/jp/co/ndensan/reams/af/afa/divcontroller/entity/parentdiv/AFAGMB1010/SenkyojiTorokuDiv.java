package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboSakuseiKijun.IMeiboSakuseiKijunDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboSakuseiKijun.MeiboSakuseiKijunDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyo.ISakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyo.SakuseiChohyoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SenkyojiToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class SenkyojiTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-02-19_14-33-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SenkyojiTorokuParam")
    private SenkyojiTorokuParamDiv SenkyojiTorokuParam;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSenkyojiTorokuParam
     * @return SenkyojiTorokuParam
     */
    @JsonProperty("SenkyojiTorokuParam")
    public SenkyojiTorokuParamDiv getSenkyojiTorokuParam() {
        return SenkyojiTorokuParam;
    }

    /*
     * setSenkyojiTorokuParam
     * @param SenkyojiTorokuParam SenkyojiTorokuParam
     */
    @JsonProperty("SenkyojiTorokuParam")
    public void setSenkyojiTorokuParam(SenkyojiTorokuParamDiv SenkyojiTorokuParam) {
        this.SenkyojiTorokuParam = SenkyojiTorokuParam;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IMeiboSakuseiKijunDiv getCcdSenkyojiMeiboSakuseiKijun() {
        return this.getSenkyojiTorokuParam().getCcdSenkyojiMeiboSakuseiKijun();
    }

    @JsonIgnore
    public ISakuseiChohyoDiv getCcdSenkyojiSakuseiChohyo() {
        return this.getSenkyojiTorokuParam().getCcdSenkyojiSakuseiChohyo();
    }

    // </editor-fold>
}
