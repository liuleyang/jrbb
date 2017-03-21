package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SeikyushaToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeikyushaTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SeikyushaTorokuSeikyuList")
    private SeikyushaTorokuSeikyuListDiv SeikyushaTorokuSeikyuList;
    @JsonProperty("SeikyushaTorokuDaihyosha")
    private SeikyushaTorokuDaihyoshaDiv SeikyushaTorokuDaihyosha;
    @JsonProperty("SeikyushaTorokuNaiyoNyuryoku")
    private SeikyushaTorokuNaiyoNyuryokuDiv SeikyushaTorokuNaiyoNyuryoku;
    @JsonProperty("txtHdnShoHonNo")
    private RString txtHdnShoHonNo;
    @JsonProperty("txtHdnSeikyuNo")
    private RString txtHdnSeikyuNo;
    @JsonProperty("txtHdnKey_Dialog")
    private RString txtHdnKey_Dialog;
    @JsonProperty("txtHdnKey_GyomuCode")
    private RString txtHdnKey_GyomuCode;
    @JsonProperty("txtHdnKey_SearchYusenKubun")
    private RString txtHdnKey_SearchYusenKubun;
    @JsonProperty("txtHdnKey_AgeArrivalDay")
    private RString txtHdnKey_AgeArrivalDay;
    @JsonProperty("txtHdnKey_KojinNoHyoji")
    private RString txtHdnKey_KojinNoHyoji;
    @JsonProperty("txtHdnKey_HojinNoHyoji")
    private RString txtHdnKey_HojinNoHyoji;
    @JsonProperty("txtHdnKey_SeinengappiHyoji")
    private RString txtHdnKey_SeinengappiHyoji;
    @JsonProperty("txtHdnKey_SeibetsuHyoji")
    private RString txtHdnKey_SeibetsuHyoji;
    @JsonProperty("txtHdnKey_HojinkeitaiHyoji")
    private RString txtHdnKey_HojinkeitaiHyoji;
    @JsonProperty("txtHdnKey_ZairyuCardHyoji")
    private RString txtHdnKey_ZairyuCardHyoji;
    @JsonProperty("txtHdnKey_ButtonAddNewHyoji")
    private RString txtHdnKey_ButtonAddNewHyoji;
    @JsonProperty("txtHdnKey_JuminShubetsuMode")
    private RString txtHdnKey_JuminShubetsuMode;
    @JsonProperty("txtHdnKey_JuminJotaiDefault")
    private RString txtHdnKey_JuminJotaiDefault;
    @JsonProperty("txtHdnKey_RadNihonjinDefault")
    private RString txtHdnKey_RadNihonjinDefault;
    @JsonProperty("txtHdnKey_RadGaikokujinDefault")
    private RString txtHdnKey_RadGaikokujinDefault;
    @JsonProperty("txtHdnKey_OutShikibetsuCode")
    private RString txtHdnKey_OutShikibetsuCode;
    @JsonProperty("hidMotoData")
    private RString hidMotoData;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSeikyushaTorokuSeikyuList
     * @return SeikyushaTorokuSeikyuList
     */
    @JsonProperty("SeikyushaTorokuSeikyuList")
    public SeikyushaTorokuSeikyuListDiv getSeikyushaTorokuSeikyuList() {
        return SeikyushaTorokuSeikyuList;
    }

    /*
     * setSeikyushaTorokuSeikyuList
     * @param SeikyushaTorokuSeikyuList SeikyushaTorokuSeikyuList
     */
    @JsonProperty("SeikyushaTorokuSeikyuList")
    public void setSeikyushaTorokuSeikyuList(SeikyushaTorokuSeikyuListDiv SeikyushaTorokuSeikyuList) {
        this.SeikyushaTorokuSeikyuList = SeikyushaTorokuSeikyuList;
    }

    /*
     * getSeikyushaTorokuDaihyosha
     * @return SeikyushaTorokuDaihyosha
     */
    @JsonProperty("SeikyushaTorokuDaihyosha")
    public SeikyushaTorokuDaihyoshaDiv getSeikyushaTorokuDaihyosha() {
        return SeikyushaTorokuDaihyosha;
    }

    /*
     * setSeikyushaTorokuDaihyosha
     * @param SeikyushaTorokuDaihyosha SeikyushaTorokuDaihyosha
     */
    @JsonProperty("SeikyushaTorokuDaihyosha")
    public void setSeikyushaTorokuDaihyosha(SeikyushaTorokuDaihyoshaDiv SeikyushaTorokuDaihyosha) {
        this.SeikyushaTorokuDaihyosha = SeikyushaTorokuDaihyosha;
    }

    /*
     * getSeikyushaTorokuNaiyoNyuryoku
     * @return SeikyushaTorokuNaiyoNyuryoku
     */
    @JsonProperty("SeikyushaTorokuNaiyoNyuryoku")
    public SeikyushaTorokuNaiyoNyuryokuDiv getSeikyushaTorokuNaiyoNyuryoku() {
        return SeikyushaTorokuNaiyoNyuryoku;
    }

    /*
     * setSeikyushaTorokuNaiyoNyuryoku
     * @param SeikyushaTorokuNaiyoNyuryoku SeikyushaTorokuNaiyoNyuryoku
     */
    @JsonProperty("SeikyushaTorokuNaiyoNyuryoku")
    public void setSeikyushaTorokuNaiyoNyuryoku(SeikyushaTorokuNaiyoNyuryokuDiv SeikyushaTorokuNaiyoNyuryoku) {
        this.SeikyushaTorokuNaiyoNyuryoku = SeikyushaTorokuNaiyoNyuryoku;
    }

    /*
     * gettxtHdnShoHonNo
     * @return txtHdnShoHonNo
     */
    @JsonProperty("txtHdnShoHonNo")
    public RString getTxtHdnShoHonNo() {
        return txtHdnShoHonNo;
    }

    /*
     * settxtHdnShoHonNo
     * @param txtHdnShoHonNo txtHdnShoHonNo
     */
    @JsonProperty("txtHdnShoHonNo")
    public void setTxtHdnShoHonNo(RString txtHdnShoHonNo) {
        this.txtHdnShoHonNo = txtHdnShoHonNo;
    }

    /*
     * gettxtHdnSeikyuNo
     * @return txtHdnSeikyuNo
     */
    @JsonProperty("txtHdnSeikyuNo")
    public RString getTxtHdnSeikyuNo() {
        return txtHdnSeikyuNo;
    }

    /*
     * settxtHdnSeikyuNo
     * @param txtHdnSeikyuNo txtHdnSeikyuNo
     */
    @JsonProperty("txtHdnSeikyuNo")
    public void setTxtHdnSeikyuNo(RString txtHdnSeikyuNo) {
        this.txtHdnSeikyuNo = txtHdnSeikyuNo;
    }

    /*
     * gettxtHdnKey_Dialog
     * @return txtHdnKey_Dialog
     */
    @JsonProperty("txtHdnKey_Dialog")
    public RString getTxtHdnKey_Dialog() {
        return txtHdnKey_Dialog;
    }

    /*
     * settxtHdnKey_Dialog
     * @param txtHdnKey_Dialog txtHdnKey_Dialog
     */
    @JsonProperty("txtHdnKey_Dialog")
    public void setTxtHdnKey_Dialog(RString txtHdnKey_Dialog) {
        this.txtHdnKey_Dialog = txtHdnKey_Dialog;
    }

    /*
     * gettxtHdnKey_GyomuCode
     * @return txtHdnKey_GyomuCode
     */
    @JsonProperty("txtHdnKey_GyomuCode")
    public RString getTxtHdnKey_GyomuCode() {
        return txtHdnKey_GyomuCode;
    }

    /*
     * settxtHdnKey_GyomuCode
     * @param txtHdnKey_GyomuCode txtHdnKey_GyomuCode
     */
    @JsonProperty("txtHdnKey_GyomuCode")
    public void setTxtHdnKey_GyomuCode(RString txtHdnKey_GyomuCode) {
        this.txtHdnKey_GyomuCode = txtHdnKey_GyomuCode;
    }

    /*
     * gettxtHdnKey_SearchYusenKubun
     * @return txtHdnKey_SearchYusenKubun
     */
    @JsonProperty("txtHdnKey_SearchYusenKubun")
    public RString getTxtHdnKey_SearchYusenKubun() {
        return txtHdnKey_SearchYusenKubun;
    }

    /*
     * settxtHdnKey_SearchYusenKubun
     * @param txtHdnKey_SearchYusenKubun txtHdnKey_SearchYusenKubun
     */
    @JsonProperty("txtHdnKey_SearchYusenKubun")
    public void setTxtHdnKey_SearchYusenKubun(RString txtHdnKey_SearchYusenKubun) {
        this.txtHdnKey_SearchYusenKubun = txtHdnKey_SearchYusenKubun;
    }

    /*
     * gettxtHdnKey_AgeArrivalDay
     * @return txtHdnKey_AgeArrivalDay
     */
    @JsonProperty("txtHdnKey_AgeArrivalDay")
    public RString getTxtHdnKey_AgeArrivalDay() {
        return txtHdnKey_AgeArrivalDay;
    }

    /*
     * settxtHdnKey_AgeArrivalDay
     * @param txtHdnKey_AgeArrivalDay txtHdnKey_AgeArrivalDay
     */
    @JsonProperty("txtHdnKey_AgeArrivalDay")
    public void setTxtHdnKey_AgeArrivalDay(RString txtHdnKey_AgeArrivalDay) {
        this.txtHdnKey_AgeArrivalDay = txtHdnKey_AgeArrivalDay;
    }

    /*
     * gettxtHdnKey_KojinNoHyoji
     * @return txtHdnKey_KojinNoHyoji
     */
    @JsonProperty("txtHdnKey_KojinNoHyoji")
    public RString getTxtHdnKey_KojinNoHyoji() {
        return txtHdnKey_KojinNoHyoji;
    }

    /*
     * settxtHdnKey_KojinNoHyoji
     * @param txtHdnKey_KojinNoHyoji txtHdnKey_KojinNoHyoji
     */
    @JsonProperty("txtHdnKey_KojinNoHyoji")
    public void setTxtHdnKey_KojinNoHyoji(RString txtHdnKey_KojinNoHyoji) {
        this.txtHdnKey_KojinNoHyoji = txtHdnKey_KojinNoHyoji;
    }

    /*
     * gettxtHdnKey_HojinNoHyoji
     * @return txtHdnKey_HojinNoHyoji
     */
    @JsonProperty("txtHdnKey_HojinNoHyoji")
    public RString getTxtHdnKey_HojinNoHyoji() {
        return txtHdnKey_HojinNoHyoji;
    }

    /*
     * settxtHdnKey_HojinNoHyoji
     * @param txtHdnKey_HojinNoHyoji txtHdnKey_HojinNoHyoji
     */
    @JsonProperty("txtHdnKey_HojinNoHyoji")
    public void setTxtHdnKey_HojinNoHyoji(RString txtHdnKey_HojinNoHyoji) {
        this.txtHdnKey_HojinNoHyoji = txtHdnKey_HojinNoHyoji;
    }

    /*
     * gettxtHdnKey_SeinengappiHyoji
     * @return txtHdnKey_SeinengappiHyoji
     */
    @JsonProperty("txtHdnKey_SeinengappiHyoji")
    public RString getTxtHdnKey_SeinengappiHyoji() {
        return txtHdnKey_SeinengappiHyoji;
    }

    /*
     * settxtHdnKey_SeinengappiHyoji
     * @param txtHdnKey_SeinengappiHyoji txtHdnKey_SeinengappiHyoji
     */
    @JsonProperty("txtHdnKey_SeinengappiHyoji")
    public void setTxtHdnKey_SeinengappiHyoji(RString txtHdnKey_SeinengappiHyoji) {
        this.txtHdnKey_SeinengappiHyoji = txtHdnKey_SeinengappiHyoji;
    }

    /*
     * gettxtHdnKey_SeibetsuHyoji
     * @return txtHdnKey_SeibetsuHyoji
     */
    @JsonProperty("txtHdnKey_SeibetsuHyoji")
    public RString getTxtHdnKey_SeibetsuHyoji() {
        return txtHdnKey_SeibetsuHyoji;
    }

    /*
     * settxtHdnKey_SeibetsuHyoji
     * @param txtHdnKey_SeibetsuHyoji txtHdnKey_SeibetsuHyoji
     */
    @JsonProperty("txtHdnKey_SeibetsuHyoji")
    public void setTxtHdnKey_SeibetsuHyoji(RString txtHdnKey_SeibetsuHyoji) {
        this.txtHdnKey_SeibetsuHyoji = txtHdnKey_SeibetsuHyoji;
    }

    /*
     * gettxtHdnKey_HojinkeitaiHyoji
     * @return txtHdnKey_HojinkeitaiHyoji
     */
    @JsonProperty("txtHdnKey_HojinkeitaiHyoji")
    public RString getTxtHdnKey_HojinkeitaiHyoji() {
        return txtHdnKey_HojinkeitaiHyoji;
    }

    /*
     * settxtHdnKey_HojinkeitaiHyoji
     * @param txtHdnKey_HojinkeitaiHyoji txtHdnKey_HojinkeitaiHyoji
     */
    @JsonProperty("txtHdnKey_HojinkeitaiHyoji")
    public void setTxtHdnKey_HojinkeitaiHyoji(RString txtHdnKey_HojinkeitaiHyoji) {
        this.txtHdnKey_HojinkeitaiHyoji = txtHdnKey_HojinkeitaiHyoji;
    }

    /*
     * gettxtHdnKey_ZairyuCardHyoji
     * @return txtHdnKey_ZairyuCardHyoji
     */
    @JsonProperty("txtHdnKey_ZairyuCardHyoji")
    public RString getTxtHdnKey_ZairyuCardHyoji() {
        return txtHdnKey_ZairyuCardHyoji;
    }

    /*
     * settxtHdnKey_ZairyuCardHyoji
     * @param txtHdnKey_ZairyuCardHyoji txtHdnKey_ZairyuCardHyoji
     */
    @JsonProperty("txtHdnKey_ZairyuCardHyoji")
    public void setTxtHdnKey_ZairyuCardHyoji(RString txtHdnKey_ZairyuCardHyoji) {
        this.txtHdnKey_ZairyuCardHyoji = txtHdnKey_ZairyuCardHyoji;
    }

    /*
     * gettxtHdnKey_ButtonAddNewHyoji
     * @return txtHdnKey_ButtonAddNewHyoji
     */
    @JsonProperty("txtHdnKey_ButtonAddNewHyoji")
    public RString getTxtHdnKey_ButtonAddNewHyoji() {
        return txtHdnKey_ButtonAddNewHyoji;
    }

    /*
     * settxtHdnKey_ButtonAddNewHyoji
     * @param txtHdnKey_ButtonAddNewHyoji txtHdnKey_ButtonAddNewHyoji
     */
    @JsonProperty("txtHdnKey_ButtonAddNewHyoji")
    public void setTxtHdnKey_ButtonAddNewHyoji(RString txtHdnKey_ButtonAddNewHyoji) {
        this.txtHdnKey_ButtonAddNewHyoji = txtHdnKey_ButtonAddNewHyoji;
    }

    /*
     * gettxtHdnKey_JuminShubetsuMode
     * @return txtHdnKey_JuminShubetsuMode
     */
    @JsonProperty("txtHdnKey_JuminShubetsuMode")
    public RString getTxtHdnKey_JuminShubetsuMode() {
        return txtHdnKey_JuminShubetsuMode;
    }

    /*
     * settxtHdnKey_JuminShubetsuMode
     * @param txtHdnKey_JuminShubetsuMode txtHdnKey_JuminShubetsuMode
     */
    @JsonProperty("txtHdnKey_JuminShubetsuMode")
    public void setTxtHdnKey_JuminShubetsuMode(RString txtHdnKey_JuminShubetsuMode) {
        this.txtHdnKey_JuminShubetsuMode = txtHdnKey_JuminShubetsuMode;
    }

    /*
     * gettxtHdnKey_JuminJotaiDefault
     * @return txtHdnKey_JuminJotaiDefault
     */
    @JsonProperty("txtHdnKey_JuminJotaiDefault")
    public RString getTxtHdnKey_JuminJotaiDefault() {
        return txtHdnKey_JuminJotaiDefault;
    }

    /*
     * settxtHdnKey_JuminJotaiDefault
     * @param txtHdnKey_JuminJotaiDefault txtHdnKey_JuminJotaiDefault
     */
    @JsonProperty("txtHdnKey_JuminJotaiDefault")
    public void setTxtHdnKey_JuminJotaiDefault(RString txtHdnKey_JuminJotaiDefault) {
        this.txtHdnKey_JuminJotaiDefault = txtHdnKey_JuminJotaiDefault;
    }

    /*
     * gettxtHdnKey_RadNihonjinDefault
     * @return txtHdnKey_RadNihonjinDefault
     */
    @JsonProperty("txtHdnKey_RadNihonjinDefault")
    public RString getTxtHdnKey_RadNihonjinDefault() {
        return txtHdnKey_RadNihonjinDefault;
    }

    /*
     * settxtHdnKey_RadNihonjinDefault
     * @param txtHdnKey_RadNihonjinDefault txtHdnKey_RadNihonjinDefault
     */
    @JsonProperty("txtHdnKey_RadNihonjinDefault")
    public void setTxtHdnKey_RadNihonjinDefault(RString txtHdnKey_RadNihonjinDefault) {
        this.txtHdnKey_RadNihonjinDefault = txtHdnKey_RadNihonjinDefault;
    }

    /*
     * gettxtHdnKey_RadGaikokujinDefault
     * @return txtHdnKey_RadGaikokujinDefault
     */
    @JsonProperty("txtHdnKey_RadGaikokujinDefault")
    public RString getTxtHdnKey_RadGaikokujinDefault() {
        return txtHdnKey_RadGaikokujinDefault;
    }

    /*
     * settxtHdnKey_RadGaikokujinDefault
     * @param txtHdnKey_RadGaikokujinDefault txtHdnKey_RadGaikokujinDefault
     */
    @JsonProperty("txtHdnKey_RadGaikokujinDefault")
    public void setTxtHdnKey_RadGaikokujinDefault(RString txtHdnKey_RadGaikokujinDefault) {
        this.txtHdnKey_RadGaikokujinDefault = txtHdnKey_RadGaikokujinDefault;
    }

    /*
     * gettxtHdnKey_OutShikibetsuCode
     * @return txtHdnKey_OutShikibetsuCode
     */
    @JsonProperty("txtHdnKey_OutShikibetsuCode")
    public RString getTxtHdnKey_OutShikibetsuCode() {
        return txtHdnKey_OutShikibetsuCode;
    }

    /*
     * settxtHdnKey_OutShikibetsuCode
     * @param txtHdnKey_OutShikibetsuCode txtHdnKey_OutShikibetsuCode
     */
    @JsonProperty("txtHdnKey_OutShikibetsuCode")
    public void setTxtHdnKey_OutShikibetsuCode(RString txtHdnKey_OutShikibetsuCode) {
        this.txtHdnKey_OutShikibetsuCode = txtHdnKey_OutShikibetsuCode;
    }

    /*
     * gethidMotoData
     * @return hidMotoData
     */
    @JsonProperty("hidMotoData")
    public RString getHidMotoData() {
        return hidMotoData;
    }

    /*
     * sethidMotoData
     * @param hidMotoData hidMotoData
     */
    @JsonProperty("hidMotoData")
    public void setHidMotoData(RString hidMotoData) {
        this.hidMotoData = hidMotoData;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnAdd() {
        return this.getSeikyushaTorokuSeikyuList().getBtnAdd();
    }

    @JsonIgnore
    public void  setBtnAdd(Button btnAdd) {
        this.getSeikyushaTorokuSeikyuList().setBtnAdd(btnAdd);
    }

    @JsonIgnore
    public DataGrid<dgSeikyushaTorokuSeikyuIchiran_Row> getDgSeikyushaTorokuSeikyuIchiran() {
        return this.getSeikyushaTorokuSeikyuList().getDgSeikyushaTorokuSeikyuIchiran();
    }

    @JsonIgnore
    public void  setDgSeikyushaTorokuSeikyuIchiran(DataGrid<dgSeikyushaTorokuSeikyuIchiran_Row> dgSeikyushaTorokuSeikyuIchiran) {
        this.getSeikyushaTorokuSeikyuList().setDgSeikyushaTorokuSeikyuIchiran(dgSeikyushaTorokuSeikyuIchiran);
    }

    @JsonIgnore
    public ButtonDialog getBtnSearchSimple() {
        return this.getSeikyushaTorokuDaihyosha().getBtnSearchSimple();
    }

    @JsonIgnore
    public void  setBtnSearchSimple(ButtonDialog btnSearchSimple) {
        this.getSeikyushaTorokuDaihyosha().setBtnSearchSimple(btnSearchSimple);
    }

    @JsonIgnore
    public DataGrid<dgSeikyushaTorokuDaihyoshaIchiran_Row> getDgSeikyushaTorokuDaihyoshaIchiran() {
        return this.getSeikyushaTorokuDaihyosha().getDgSeikyushaTorokuDaihyoshaIchiran();
    }

    @JsonIgnore
    public void  setDgSeikyushaTorokuDaihyoshaIchiran(DataGrid<dgSeikyushaTorokuDaihyoshaIchiran_Row> dgSeikyushaTorokuDaihyoshaIchiran) {
        this.getSeikyushaTorokuDaihyosha().setDgSeikyushaTorokuDaihyoshaIchiran(dgSeikyushaTorokuDaihyoshaIchiran);
    }

    @JsonIgnore
    public TextBoxDate getTxtSeikyuYMD() {
        return this.getSeikyushaTorokuNaiyoNyuryoku().getTxtSeikyuYMD();
    }

    @JsonIgnore
    public void  setTxtSeikyuYMD(TextBoxDate txtSeikyuYMD) {
        this.getSeikyushaTorokuNaiyoNyuryoku().setTxtSeikyuYMD(txtSeikyuYMD);
    }

    @JsonIgnore
    public TextBox getTxtSeikyuName() {
        return this.getSeikyushaTorokuNaiyoNyuryoku().getTxtSeikyuName();
    }

    @JsonIgnore
    public void  setTxtSeikyuName(TextBox txtSeikyuName) {
        this.getSeikyushaTorokuNaiyoNyuryoku().setTxtSeikyuName(txtSeikyuName);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtSeikyuNaiyo() {
        return this.getSeikyushaTorokuNaiyoNyuryoku().getTxtSeikyuNaiyo();
    }

    @JsonIgnore
    public void  setTxtSeikyuNaiyo(TextBoxMultiLine txtSeikyuNaiyo) {
        this.getSeikyushaTorokuNaiyoNyuryoku().setTxtSeikyuNaiyo(txtSeikyuNaiyo);
    }

    @JsonIgnore
    public TextBoxDate getTxtKofuYMD() {
        return this.getSeikyushaTorokuNaiyoNyuryoku().getTxtKofuYMD();
    }

    @JsonIgnore
    public void  setTxtKofuYMD(TextBoxDate txtKofuYMD) {
        this.getSeikyushaTorokuNaiyoNyuryoku().setTxtKofuYMD(txtKofuYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtTeishutsuKigenYMD() {
        return this.getSeikyushaTorokuNaiyoNyuryoku().getTxtTeishutsuKigenYMD();
    }

    @JsonIgnore
    public void  setTxtTeishutsuKigenYMD(TextBoxDate txtTeishutsuKigenYMD) {
        this.getSeikyushaTorokuNaiyoNyuryoku().setTxtTeishutsuKigenYMD(txtTeishutsuKigenYMD);
    }

    @JsonIgnore
    public DropDownList getDdlKofuSoshiki() {
        return this.getSeikyushaTorokuNaiyoNyuryoku().getDdlKofuSoshiki();
    }

    @JsonIgnore
    public void  setDdlKofuSoshiki(DropDownList ddlKofuSoshiki) {
        this.getSeikyushaTorokuNaiyoNyuryoku().setDdlKofuSoshiki(ddlKofuSoshiki);
    }

    @JsonIgnore
    public TextBox getTxtKofushaName() {
        return this.getSeikyushaTorokuNaiyoNyuryoku().getTxtKofushaName();
    }

    @JsonIgnore
    public void  setTxtKofushaName(TextBox txtKofushaName) {
        this.getSeikyushaTorokuNaiyoNyuryoku().setTxtKofushaName(txtKofushaName);
    }

    @JsonIgnore
    public Button getBtnAddNew() {
        return this.getSeikyushaTorokuNaiyoNyuryoku().getBtnAddNew();
    }

    @JsonIgnore
    public void  setBtnAddNew(Button btnAddNew) {
        this.getSeikyushaTorokuNaiyoNyuryoku().setBtnAddNew(btnAddNew);
    }

    @JsonIgnore
    public Button getBtnStop() {
        return this.getSeikyushaTorokuNaiyoNyuryoku().getBtnStop();
    }

    @JsonIgnore
    public void  setBtnStop(Button btnStop) {
        this.getSeikyushaTorokuNaiyoNyuryoku().setBtnStop(btnStop);
    }

    // </editor-fold>
}
