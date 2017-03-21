package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME6020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.AtenaSealLayout.AtenaSealLayoutDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.AtenaSealLayout.IAtenaSealLayoutDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaSealPositionGuide.AtenaSealPositionGuideDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaSealPositionGuide.IAtenaSealPositionGuideDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * SealTenshutsushaParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class SealTenshutsushaParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radSenkyo")
    private RadioButton radSenkyo;
    @JsonProperty("txtTaishoKikan")
    private TextBoxDateRange txtTaishoKikan;
    @JsonProperty("SealTenshutsushaNaiyo")
    private SealTenshutsushaNaiyoDiv SealTenshutsushaNaiyo;
    @JsonProperty("ccdSealPosition")
    private AtenaSealPositionGuideDiv ccdSealPosition;
    @JsonProperty("ccdShohonNameList")
    private ShohonNameListDiv ccdShohonNameList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradSenkyo
     * @return radSenkyo
     */
    @JsonProperty("radSenkyo")
    public RadioButton getRadSenkyo() {
        return radSenkyo;
    }

    /*
     * setradSenkyo
     * @param radSenkyo radSenkyo
     */
    @JsonProperty("radSenkyo")
    public void setRadSenkyo(RadioButton radSenkyo) {
        this.radSenkyo = radSenkyo;
    }

    /*
     * gettxtTaishoKikan
     * @return txtTaishoKikan
     */
    @JsonProperty("txtTaishoKikan")
    public TextBoxDateRange getTxtTaishoKikan() {
        return txtTaishoKikan;
    }

    /*
     * settxtTaishoKikan
     * @param txtTaishoKikan txtTaishoKikan
     */
    @JsonProperty("txtTaishoKikan")
    public void setTxtTaishoKikan(TextBoxDateRange txtTaishoKikan) {
        this.txtTaishoKikan = txtTaishoKikan;
    }

    /*
     * getSealTenshutsushaNaiyo
     * @return SealTenshutsushaNaiyo
     */
    @JsonProperty("SealTenshutsushaNaiyo")
    public SealTenshutsushaNaiyoDiv getSealTenshutsushaNaiyo() {
        return SealTenshutsushaNaiyo;
    }

    /*
     * setSealTenshutsushaNaiyo
     * @param SealTenshutsushaNaiyo SealTenshutsushaNaiyo
     */
    @JsonProperty("SealTenshutsushaNaiyo")
    public void setSealTenshutsushaNaiyo(SealTenshutsushaNaiyoDiv SealTenshutsushaNaiyo) {
        this.SealTenshutsushaNaiyo = SealTenshutsushaNaiyo;
    }

    /*
     * getccdSealPosition
     * @return ccdSealPosition
     */
    @JsonProperty("ccdSealPosition")
    public IAtenaSealPositionGuideDiv getCcdSealPosition() {
        return ccdSealPosition;
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
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IAtenaSealLayoutDiv getCcdSealLayout() {
        return this.getSealTenshutsushaNaiyo().getCcdSealLayout();
    }

    // </editor-fold>
}
