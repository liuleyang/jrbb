package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME6010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.AtenaSealLayout.AtenaSealLayoutDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.AtenaSealLayout.IAtenaSealLayoutDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JushoJokenSelect.IJushoJokenSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JushoJokenSelect.JushoJokenSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaSealPositionGuide.AtenaSealPositionGuideDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaSealPositionGuide.IAtenaSealPositionGuideDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * SealSenkyoninParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class SealSenkyoninParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SealSenkyoninNaiyo")
    private SealSenkyoninNaiyoDiv SealSenkyoninNaiyo;
    @JsonProperty("ccdShohonNameList")
    private ShohonNameListDiv ccdShohonNameList;
    @JsonProperty("ccdJushoJokenSelect")
    private JushoJokenSelectDiv ccdJushoJokenSelect;
    @JsonProperty("ccdSealPosition")
    private AtenaSealPositionGuideDiv ccdSealPosition;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSealSenkyoninNaiyo
     * @return SealSenkyoninNaiyo
     */
    @JsonProperty("SealSenkyoninNaiyo")
    public SealSenkyoninNaiyoDiv getSealSenkyoninNaiyo() {
        return SealSenkyoninNaiyo;
    }

    /*
     * setSealSenkyoninNaiyo
     * @param SealSenkyoninNaiyo SealSenkyoninNaiyo
     */
    @JsonProperty("SealSenkyoninNaiyo")
    public void setSealSenkyoninNaiyo(SealSenkyoninNaiyoDiv SealSenkyoninNaiyo) {
        this.SealSenkyoninNaiyo = SealSenkyoninNaiyo;
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
     * getccdJushoJokenSelect
     * @return ccdJushoJokenSelect
     */
    @JsonProperty("ccdJushoJokenSelect")
    public IJushoJokenSelectDiv getCcdJushoJokenSelect() {
        return ccdJushoJokenSelect;
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
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadJusho() {
        return this.getSealSenkyoninNaiyo().getRadJusho();
    }

    @JsonIgnore
    public void  setRadJusho(RadioButton radJusho) {
        this.getSealSenkyoninNaiyo().setRadJusho(radJusho);
    }

    @JsonIgnore
    public CheckBoxList getChkSetainushi() {
        return this.getSealSenkyoninNaiyo().getChkSetainushi();
    }

    @JsonIgnore
    public void  setChkSetainushi(CheckBoxList chkSetainushi) {
        this.getSealSenkyoninNaiyo().setChkSetainushi(chkSetainushi);
    }

    @JsonIgnore
    public IAtenaSealLayoutDiv getCcdSealLayout() {
        return this.getSealSenkyoninNaiyo().getCcdSealLayout();
    }

    // </editor-fold>
}
