package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME3010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJokyoNyuryoku.ITohyoJokyoNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJokyoNyuryoku.TohyoJokyoNyuryokuDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TojitsuTohyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class TojitsuTohyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TojitsuTohyoJokyo")
    private TojitsuTohyoJokyoDiv TojitsuTohyoJokyo;
    @JsonProperty("TojitsuKojinJoho")
    private TojitsuKojinJohoDiv TojitsuKojinJoho;
    @JsonProperty("btnFinish")
    private Button btnFinish;
    @JsonProperty("ccdTojitsuSenkyoninTohyoJokyo")
    private TohyoJokyoNyuryokuDiv ccdTojitsuSenkyoninTohyoJokyo;
    @JsonProperty("labelSealSelectDialogModel")
    private RString labelSealSelectDialogModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTojitsuTohyoJokyo
     * @return TojitsuTohyoJokyo
     */
    @JsonProperty("TojitsuTohyoJokyo")
    public TojitsuTohyoJokyoDiv getTojitsuTohyoJokyo() {
        return TojitsuTohyoJokyo;
    }

    /*
     * setTojitsuTohyoJokyo
     * @param TojitsuTohyoJokyo TojitsuTohyoJokyo
     */
    @JsonProperty("TojitsuTohyoJokyo")
    public void setTojitsuTohyoJokyo(TojitsuTohyoJokyoDiv TojitsuTohyoJokyo) {
        this.TojitsuTohyoJokyo = TojitsuTohyoJokyo;
    }

    /*
     * getTojitsuKojinJoho
     * @return TojitsuKojinJoho
     */
    @JsonProperty("TojitsuKojinJoho")
    public TojitsuKojinJohoDiv getTojitsuKojinJoho() {
        return TojitsuKojinJoho;
    }

    /*
     * setTojitsuKojinJoho
     * @param TojitsuKojinJoho TojitsuKojinJoho
     */
    @JsonProperty("TojitsuKojinJoho")
    public void setTojitsuKojinJoho(TojitsuKojinJohoDiv TojitsuKojinJoho) {
        this.TojitsuKojinJoho = TojitsuKojinJoho;
    }

    /*
     * getbtnFinish
     * @return btnFinish
     */
    @JsonProperty("btnFinish")
    public Button getBtnFinish() {
        return btnFinish;
    }

    /*
     * setbtnFinish
     * @param btnFinish btnFinish
     */
    @JsonProperty("btnFinish")
    public void setBtnFinish(Button btnFinish) {
        this.btnFinish = btnFinish;
    }

    /*
     * getccdTojitsuSenkyoninTohyoJokyo
     * @return ccdTojitsuSenkyoninTohyoJokyo
     */
    @JsonProperty("ccdTojitsuSenkyoninTohyoJokyo")
    public ITohyoJokyoNyuryokuDiv getCcdTojitsuSenkyoninTohyoJokyo() {
        return ccdTojitsuSenkyoninTohyoJokyo;
    }

    /*
     * getlabelSealSelectDialogModel
     * @return labelSealSelectDialogModel
     */
    @JsonProperty("labelSealSelectDialogModel")
    public RString getLabelSealSelectDialogModel() {
        return labelSealSelectDialogModel;
    }

    /*
     * setlabelSealSelectDialogModel
     * @param labelSealSelectDialogModel labelSealSelectDialogModel
     */
    @JsonProperty("labelSealSelectDialogModel")
    public void setLabelSealSelectDialogModel(RString labelSealSelectDialogModel) {
        this.labelSealSelectDialogModel = labelSealSelectDialogModel;
    }

    // </editor-fold>
}
