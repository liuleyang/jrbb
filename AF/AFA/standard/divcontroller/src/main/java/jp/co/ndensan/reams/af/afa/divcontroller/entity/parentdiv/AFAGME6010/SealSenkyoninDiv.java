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
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SealSenkyonin のクラスファイル 
 * 
 * @author 自動生成
 */
public class SealSenkyoninDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SealSenkyoninParam")
    private SealSenkyoninParamDiv SealSenkyoninParam;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSealSenkyoninParam
     * @return SealSenkyoninParam
     */
    @JsonProperty("SealSenkyoninParam")
    public SealSenkyoninParamDiv getSealSenkyoninParam() {
        return SealSenkyoninParam;
    }

    /*
     * setSealSenkyoninParam
     * @param SealSenkyoninParam SealSenkyoninParam
     */
    @JsonProperty("SealSenkyoninParam")
    public void setSealSenkyoninParam(SealSenkyoninParamDiv SealSenkyoninParam) {
        this.SealSenkyoninParam = SealSenkyoninParam;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public SealSenkyoninNaiyoDiv getSealSenkyoninNaiyo() {
        return this.getSealSenkyoninParam().getSealSenkyoninNaiyo();
    }

    @JsonIgnore
    public void  setSealSenkyoninNaiyo(SealSenkyoninNaiyoDiv SealSenkyoninNaiyo) {
        this.getSealSenkyoninParam().setSealSenkyoninNaiyo(SealSenkyoninNaiyo);
    }

    @JsonIgnore
    public RadioButton getRadJusho() {
        return this.getSealSenkyoninParam().getSealSenkyoninNaiyo().getRadJusho();
    }

    @JsonIgnore
    public void  setRadJusho(RadioButton radJusho) {
        this.getSealSenkyoninParam().getSealSenkyoninNaiyo().setRadJusho(radJusho);
    }

    @JsonIgnore
    public CheckBoxList getChkSetainushi() {
        return this.getSealSenkyoninParam().getSealSenkyoninNaiyo().getChkSetainushi();
    }

    @JsonIgnore
    public void  setChkSetainushi(CheckBoxList chkSetainushi) {
        this.getSealSenkyoninParam().getSealSenkyoninNaiyo().setChkSetainushi(chkSetainushi);
    }

    @JsonIgnore
    public IAtenaSealLayoutDiv getCcdSealLayout() {
        return this.getSealSenkyoninParam().getSealSenkyoninNaiyo().getCcdSealLayout();
    }

    @JsonIgnore
    public IShohonNameListDiv getCcdShohonNameList() {
        return this.getSealSenkyoninParam().getCcdShohonNameList();
    }

    @JsonIgnore
    public IJushoJokenSelectDiv getCcdJushoJokenSelect() {
        return this.getSealSenkyoninParam().getCcdJushoJokenSelect();
    }

    @JsonIgnore
    public IAtenaSealPositionGuideDiv getCcdSealPosition() {
        return this.getSealSenkyoninParam().getCcdSealPosition();
    }

    // </editor-fold>
}
