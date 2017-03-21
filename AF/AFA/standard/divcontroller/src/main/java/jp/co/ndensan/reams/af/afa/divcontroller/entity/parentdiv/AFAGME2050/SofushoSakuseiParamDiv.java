package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2050;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonSenkyoList.IShohonSenkyoListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonSenkyoList.ShohonSenkyoListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * SofushoSakuseiParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class SofushoSakuseiParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SofushoSakuseiJoken")
    private SofushoSakuseiJokenDiv SofushoSakuseiJoken;
    @JsonProperty("ccdSofushoShohonSenkyoList")
    private ShohonSenkyoListDiv ccdSofushoShohonSenkyoList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSofushoSakuseiJoken
     * @return SofushoSakuseiJoken
     */
    @JsonProperty("SofushoSakuseiJoken")
    public SofushoSakuseiJokenDiv getSofushoSakuseiJoken() {
        return SofushoSakuseiJoken;
    }

    /*
     * setSofushoSakuseiJoken
     * @param SofushoSakuseiJoken SofushoSakuseiJoken
     */
    @JsonProperty("SofushoSakuseiJoken")
    public void setSofushoSakuseiJoken(SofushoSakuseiJokenDiv SofushoSakuseiJoken) {
        this.SofushoSakuseiJoken = SofushoSakuseiJoken;
    }

    /*
     * getccdSofushoShohonSenkyoList
     * @return ccdSofushoShohonSenkyoList
     */
    @JsonProperty("ccdSofushoShohonSenkyoList")
    public IShohonSenkyoListDiv getCcdSofushoShohonSenkyoList() {
        return ccdSofushoShohonSenkyoList;
    }

    // </editor-fold>
}
