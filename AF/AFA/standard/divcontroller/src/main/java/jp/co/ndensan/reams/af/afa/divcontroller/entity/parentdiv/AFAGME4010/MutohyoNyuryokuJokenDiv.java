package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME4010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboBango.IMeiboBangoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboBango.MeiboBangoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.ITohyokuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.TohyokuCodeSelectDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.CodeInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.ICodeInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * MutohyoNyuryokuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class MutohyoNyuryokuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnSelect")
    private Button btnSelect;
    @JsonProperty("ccdMeiboBango")
    private MeiboBangoDiv ccdMeiboBango;
    @JsonProperty("ccdTohyoku")
    private TohyokuCodeSelectDiv ccdTohyoku;
    @JsonProperty("ccdShohonNameList")
    private ShohonNameListDiv ccdShohonNameList;
    @JsonProperty("ccdKubunCode")
    private CodeInputDiv ccdKubunCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnSelect
     * @return btnSelect
     */
    @JsonProperty("btnSelect")
    public Button getBtnSelect() {
        return btnSelect;
    }

    /*
     * setbtnSelect
     * @param btnSelect btnSelect
     */
    @JsonProperty("btnSelect")
    public void setBtnSelect(Button btnSelect) {
        this.btnSelect = btnSelect;
    }

    /*
     * getccdMeiboBango
     * @return ccdMeiboBango
     */
    @JsonProperty("ccdMeiboBango")
    public IMeiboBangoDiv getCcdMeiboBango() {
        return ccdMeiboBango;
    }

    /*
     * getccdTohyoku
     * @return ccdTohyoku
     */
    @JsonProperty("ccdTohyoku")
    public ITohyokuCodeSelectDiv getCcdTohyoku() {
        return ccdTohyoku;
    }

    /*
     * getccdShohonNameList
     * @return ccdShohonNameList
     */
    @JsonProperty("ccdShohonNameList")
    public IShohonNameListDiv getCcdShohonNameList() {
        return ccdShohonNameList;
    }

    /*
     * getccdKubunCode
     * @return ccdKubunCode
     */
    @JsonProperty("ccdKubunCode")
    public ICodeInputDiv getCcdKubunCode() {
        return ccdKubunCode;
    }

    // </editor-fold>
}
