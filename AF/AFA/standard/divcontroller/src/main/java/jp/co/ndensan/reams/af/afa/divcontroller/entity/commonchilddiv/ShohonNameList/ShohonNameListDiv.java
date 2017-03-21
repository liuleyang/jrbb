package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * ShohonNameList のクラスファイル
 *
 * @author 自動生成
 */
public class ShohonNameListDiv extends Panel implements IShohonNameListDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlShohon")
    private DropDownList ddlShohon;
    @JsonProperty("chkKakoShohon")
    private CheckBoxList chkKakoShohon;
    @JsonProperty("txtHdnShohonName")
    private RString txtHdnShohonName;
    @JsonProperty("txtHdnSenkyoShurui")
    private RString txtHdnSenkyoShurui;
    @JsonProperty("txtHdnTohyoYMD")
    private RString txtHdnTohyoYMD;
    @JsonProperty("txtHdnKiteiNenreiTotatsuYMD")
    private RString txtHdnKiteiNenreiTotatsuYMD;
    @JsonProperty("txtHdnShohonNo")
    private RString txtHdnShohonNo;
    @JsonProperty("txtHdn一番近い未来")
    private RString txtHdn一番近い未来;
    @JsonProperty("txtHdn一番近い過去")
    private RString txtHdn一番近い過去;
    @JsonProperty("txtHdnInitialSenkyoShurui")
    private RString txtHdnInitialSenkyoShurui;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlShohon
     * @return ddlShohon
     */
    @JsonProperty("ddlShohon")
    public DropDownList getDdlShohon() {
        return ddlShohon;
    }

    /*
     * setddlShohon
     * @param ddlShohon ddlShohon
     */
    @JsonProperty("ddlShohon")
    public void setDdlShohon(DropDownList ddlShohon) {
        this.ddlShohon = ddlShohon;
    }

    /*
     * getchkKakoShohon
     * @return chkKakoShohon
     */
    @JsonProperty("chkKakoShohon")
    public CheckBoxList getChkKakoShohon() {
        return chkKakoShohon;
    }

    /*
     * setchkKakoShohon
     * @param chkKakoShohon chkKakoShohon
     */
    @JsonProperty("chkKakoShohon")
    public void setChkKakoShohon(CheckBoxList chkKakoShohon) {
        this.chkKakoShohon = chkKakoShohon;
    }

    /*
     * gettxtHdnShohonName
     * @return txtHdnShohonName
     */
    @JsonProperty("txtHdnShohonName")
    public RString getTxtHdnShohonName() {
        return txtHdnShohonName;
    }

    /*
     * settxtHdnShohonName
     * @param txtHdnShohonName txtHdnShohonName
     */
    @JsonProperty("txtHdnShohonName")
    public void setTxtHdnShohonName(RString txtHdnShohonName) {
        this.txtHdnShohonName = txtHdnShohonName;
    }

    /*
     * gettxtHdnSenkyoShurui
     * @return txtHdnSenkyoShurui
     */
    @JsonProperty("txtHdnSenkyoShurui")
    public RString getTxtHdnSenkyoShurui() {
        return txtHdnSenkyoShurui;
    }

    /*
     * settxtHdnSenkyoShurui
     * @param txtHdnSenkyoShurui txtHdnSenkyoShurui
     */
    @JsonProperty("txtHdnSenkyoShurui")
    public void setTxtHdnSenkyoShurui(RString txtHdnSenkyoShurui) {
        this.txtHdnSenkyoShurui = txtHdnSenkyoShurui;
    }

    /*
     * gettxtHdnTohyoYMD
     * @return txtHdnTohyoYMD
     */
    @JsonProperty("txtHdnTohyoYMD")
    public RString getTxtHdnTohyoYMD() {
        return txtHdnTohyoYMD;
    }

    /*
     * settxtHdnTohyoYMD
     * @param txtHdnTohyoYMD txtHdnTohyoYMD
     */
    @JsonProperty("txtHdnTohyoYMD")
    public void setTxtHdnTohyoYMD(RString txtHdnTohyoYMD) {
        this.txtHdnTohyoYMD = txtHdnTohyoYMD;
    }

    /*
     * gettxtHdnKiteiNenreiTotatsuYMD
     * @return txtHdnKiteiNenreiTotatsuYMD
     */
    @JsonProperty("txtHdnKiteiNenreiTotatsuYMD")
    public RString getTxtHdnKiteiNenreiTotatsuYMD() {
        return txtHdnKiteiNenreiTotatsuYMD;
    }

    /*
     * settxtHdnKiteiNenreiTotatsuYMD
     * @param txtHdnKiteiNenreiTotatsuYMD txtHdnKiteiNenreiTotatsuYMD
     */
    @JsonProperty("txtHdnKiteiNenreiTotatsuYMD")
    public void setTxtHdnKiteiNenreiTotatsuYMD(RString txtHdnKiteiNenreiTotatsuYMD) {
        this.txtHdnKiteiNenreiTotatsuYMD = txtHdnKiteiNenreiTotatsuYMD;
    }

    /*
     * gettxtHdnShohonNo
     * @return txtHdnShohonNo
     */
    @JsonProperty("txtHdnShohonNo")
    public RString getTxtHdnShohonNo() {
        return txtHdnShohonNo;
    }

    /*
     * settxtHdnShohonNo
     * @param txtHdnShohonNo txtHdnShohonNo
     */
    @JsonProperty("txtHdnShohonNo")
    public void setTxtHdnShohonNo(RString txtHdnShohonNo) {
        this.txtHdnShohonNo = txtHdnShohonNo;
    }

    /*
     * gettxtHdn一番近い未来
     * @return txtHdn一番近い未来
     */
    @JsonProperty("txtHdn一番近い未来")
    public RString getTxtHdn一番近い未来() {
        return txtHdn一番近い未来;
    }

    /*
     * settxtHdn一番近い未来
     * @param txtHdn一番近い未来 txtHdn一番近い未来
     */
    @JsonProperty("txtHdn一番近い未来")
    public void setTxtHdn一番近い未来(RString txtHdn一番近い未来) {
        this.txtHdn一番近い未来 = txtHdn一番近い未来;
    }

    /*
     * gettxtHdn一番近い過去
     * @return txtHdn一番近い過去
     */
    @JsonProperty("txtHdn一番近い過去")
    public RString getTxtHdn一番近い過去() {
        return txtHdn一番近い過去;
    }

    /*
     * settxtHdn一番近い過去
     * @param txtHdn一番近い過去 txtHdn一番近い過去
     */
    @JsonProperty("txtHdn一番近い過去")
    public void setTxtHdn一番近い過去(RString txtHdn一番近い過去) {
        this.txtHdn一番近い過去 = txtHdn一番近い過去;
    }

    /*
     * gettxtHdnInitialSenkyoShurui
     * @return txtHdnInitialSenkyoShurui
     */
    @JsonProperty("txtHdnInitialSenkyoShurui")
    public RString getTxtHdnInitialSenkyoShurui() {
        return txtHdnInitialSenkyoShurui;
    }

    /*
     * settxtHdnInitialSenkyoShurui
     * @param txtHdnInitialSenkyoShurui txtHdnInitialSenkyoShurui
     */
    @JsonProperty("txtHdnInitialSenkyoShurui")
    public void setTxtHdnInitialSenkyoShurui(RString txtHdnInitialSenkyoShurui) {
        this.txtHdnInitialSenkyoShurui = txtHdnInitialSenkyoShurui;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum KakoHyojiCheckBoxSelected implements ICommonChildDivMode {

        選択する("選択する"),
        選択しない("選択しない");

        private final String name;

        private KakoHyojiCheckBoxSelected(final String name) {
            this.name = name;
        }

        public static KakoHyojiCheckBoxSelected getEnum(String str) {
            KakoHyojiCheckBoxSelected[] enumArray = KakoHyojiCheckBoxSelected.values();

            for (KakoHyojiCheckBoxSelected enumStr : enumArray) {
                if (str.equals(enumStr.name.toString())) {
                    return enumStr;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return this.name;
        }

    }

    public KakoHyojiCheckBoxSelected getMode_KakoHyojiCheckBoxSelected() {
        return (KakoHyojiCheckBoxSelected) _CommonChildDivModeUtil.getMode(this.modes, KakoHyojiCheckBoxSelected.class);
    }

    public void setMode_KakoHyojiCheckBoxSelected(KakoHyojiCheckBoxSelected value) {
        _CommonChildDivModeUtil.setMode(this.modes, KakoHyojiCheckBoxSelected.class, value);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public RString getSelectedShohonName() {
        return this.getTxtHdnShohonName();
    }

    @Override
    public SenkyoShurui getSelectedSenkyoShurui() {
        return SenkyoShurui.toValue(this.getTxtHdnSenkyoShurui());
    }

    @Override
    public RDate getSelectedTohyoYMD() {
        if (!this.getTxtHdnTohyoYMD().isEmpty()) {
            return new RDate(this.getTxtHdnTohyoYMD().toString());
        } else {
            return null;
        }
    }

    @Override
    public RDate getSelectedKiteiNenreiTotatsuYMD() {
        if (!this.getTxtHdnKiteiNenreiTotatsuYMD().isEmpty()) {
            return new RDate(this.getTxtHdnKiteiNenreiTotatsuYMD().toString());
        } else {
            return null;
        }
    }

    @Override
    public RString getSelectedShohonNo() {
        return this.getTxtHdnShohonNo();
    }

    @Override
    public void initialize() {
        getHandler().initialize();
    }

    @Override
    public void initialize(SenkyoShurui senkyoShurui) {
        getHandler().initialize(senkyoShurui);
    }

    @Override
    public void initialize(RString senkyoShurui, Boolean is過去分のみ対象区分) {
        getHandler().initialize(senkyoShurui, is過去分のみ対象区分);
    }

    @Override
    public void initialize(SenkyoShurui senkyoShurui, Boolean is過去分のみ対象区分) {
        getHandler().initialize(senkyoShurui, is過去分のみ対象区分);
    }

    @Override
    public void initialSetting() {
        getHandler().initialSetting();
    }

    @Override
    public void selectedShohon(RString shohonNo) {
        getHandler().selectedShohon(shohonNo);
    }

    @Override
    public void changeDdlShohon() {
        getHandler().changeDdlShohon();
    }

    @Override
    public void clear() {
        getHandler().clear();
    }

    @Override
    public void click_chkKakoShohon() {
        getHandler().click_chkKakoShohon();
    }

    @Override
    public void setDisplayNoneMode(Boolean displayNoneSetMode) {
        getHandler().setDisplayNoneMode(displayNoneSetMode);
    }

    @Override
    public void setReadOnlyMode(Boolean readOnlySetMode) {
        getHandler().setReadOnlyMode(readOnlySetMode);
    }

    @Override
    public void setChkKakoShohonDisplayNoneMode(Boolean displayNoneSetMode) {
        getHandler().setChkKakoShohonDisplayNoneMode(displayNoneSetMode);
    }

    @Override
    public void setChkKakoShohonCheckMode(Boolean checkSetMode) {
        getHandler().setChkKakoShohonCheckMode(checkSetMode);
    }

    @Override
    public boolean isDisplayNoneMode() {
        return getHandler().isDisplayNoneMode();
    }

    @Override
    public int getShohonListSize() {
        return getHandler().getShohonListSize();
    }

    @Override
    public RString get一番近い未来抄本番号() {
        return this.txtHdn一番近い未来;
    }

    @Override
    public RString get一番近い過去抄本番号() {
        return this.txtHdn一番近い過去;
    }

    @Override
    public RString get抄本DDL() {
        return this.ddlShohon.getSelectControlID();
    }

    @Override
    public DropDownList getDdlShohonItem() {
        return getHandler().getDdlShohonItem();
    }

    @JsonIgnore
    public ShohonNameListHandler getHandler() {
        return new ShohonNameListHandler(this);
    }

}
