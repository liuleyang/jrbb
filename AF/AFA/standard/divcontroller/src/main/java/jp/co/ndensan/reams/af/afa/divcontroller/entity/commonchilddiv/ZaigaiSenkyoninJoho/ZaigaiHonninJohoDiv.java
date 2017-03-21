package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ZaigaiSenkyoninJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.BanchiInput.BanchiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.BanchiInput.IBanchiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.KatagakiInput.IKatagakiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.KatagakiInput.KatagakiInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.ZenkokuJushoInput.IZenkokuJushoInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.ZenkokuJushoInput.ZenkokuJushoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
public class ZaigaiHonninJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShimei")
    private TextBoxAtenaMeisho txtShimei;
    @JsonProperty("txtSeinengappiYMD")
    private TextBoxFlexibleDate txtSeinengappiYMD;
    @JsonProperty("txtShimeiKana")
    private TextBoxAtenaKanaMeisho txtShimeiKana;
    @JsonProperty("ddlSeibetsu")
    private DropDownList ddlSeibetsu;
    @JsonProperty("lblHonseki")
    private Label lblHonseki;
    @JsonProperty("ccdHonsekiJusho")
    private ZenkokuJushoInputDiv ccdHonsekiJusho;
    @JsonProperty("ccdHonsekiBanchi")
    private BanchiInputDiv ccdHonsekiBanchi;
    @JsonProperty("lblLastJusho")
    private Label lblLastJusho;
    @JsonProperty("ccdLastJusho")
    private ZenkokuJushoInputDiv ccdLastJusho;
    @JsonProperty("ccdLastBanchi")
    private BanchiInputDiv ccdLastBanchi;
    @JsonProperty("ccdLastKatagaki")
    private KatagakiInputDiv ccdLastKatagaki;
    @JsonProperty("txtTenshutsuYMD")
    private TextBoxDate txtTenshutsuYMD;
    @JsonProperty("radHonsekichiToroku")
    private RadioButton radHonsekichiToroku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShimei
     * @return txtShimei
     */
    @JsonProperty("txtShimei")
    public TextBoxAtenaMeisho getTxtShimei() {
        return txtShimei;
    }

    /*
     * settxtShimei
     * @param txtShimei txtShimei
     */
    @JsonProperty("txtShimei")
    public void setTxtShimei(TextBoxAtenaMeisho txtShimei) {
        this.txtShimei = txtShimei;
    }

    /*
     * gettxtSeinengappiYMD
     * @return txtSeinengappiYMD
     */
    @JsonProperty("txtSeinengappiYMD")
    public TextBoxFlexibleDate getTxtSeinengappiYMD() {
        return txtSeinengappiYMD;
    }

    /*
     * settxtSeinengappiYMD
     * @param txtSeinengappiYMD txtSeinengappiYMD
     */
    @JsonProperty("txtSeinengappiYMD")
    public void setTxtSeinengappiYMD(TextBoxFlexibleDate txtSeinengappiYMD) {
        this.txtSeinengappiYMD = txtSeinengappiYMD;
    }

    /*
     * gettxtShimeiKana
     * @return txtShimeiKana
     */
    @JsonProperty("txtShimeiKana")
    public TextBoxAtenaKanaMeisho getTxtShimeiKana() {
        return txtShimeiKana;
    }

    /*
     * settxtShimeiKana
     * @param txtShimeiKana txtShimeiKana
     */
    @JsonProperty("txtShimeiKana")
    public void setTxtShimeiKana(TextBoxAtenaKanaMeisho txtShimeiKana) {
        this.txtShimeiKana = txtShimeiKana;
    }

    /*
     * getddlSeibetsu
     * @return ddlSeibetsu
     */
    @JsonProperty("ddlSeibetsu")
    public DropDownList getDdlSeibetsu() {
        return ddlSeibetsu;
    }

    /*
     * setddlSeibetsu
     * @param ddlSeibetsu ddlSeibetsu
     */
    @JsonProperty("ddlSeibetsu")
    public void setDdlSeibetsu(DropDownList ddlSeibetsu) {
        this.ddlSeibetsu = ddlSeibetsu;
    }

    /*
     * getlblHonseki
     * @return lblHonseki
     */
    @JsonProperty("lblHonseki")
    public Label getLblHonseki() {
        return lblHonseki;
    }

    /*
     * setlblHonseki
     * @param lblHonseki lblHonseki
     */
    @JsonProperty("lblHonseki")
    public void setLblHonseki(Label lblHonseki) {
        this.lblHonseki = lblHonseki;
    }

    /*
     * getccdHonsekiJusho
     * @return ccdHonsekiJusho
     */
    @JsonProperty("ccdHonsekiJusho")
    public IZenkokuJushoInputDiv getCcdHonsekiJusho() {
        return ccdHonsekiJusho;
    }

    /*
     * getccdHonsekiBanchi
     * @return ccdHonsekiBanchi
     */
    @JsonProperty("ccdHonsekiBanchi")
    public IBanchiInputDiv getCcdHonsekiBanchi() {
        return ccdHonsekiBanchi;
    }

    /*
     * getlblLastJusho
     * @return lblLastJusho
     */
    @JsonProperty("lblLastJusho")
    public Label getLblLastJusho() {
        return lblLastJusho;
    }

    /*
     * setlblLastJusho
     * @param lblLastJusho lblLastJusho
     */
    @JsonProperty("lblLastJusho")
    public void setLblLastJusho(Label lblLastJusho) {
        this.lblLastJusho = lblLastJusho;
    }

    /*
     * getccdLastJusho
     * @return ccdLastJusho
     */
    @JsonProperty("ccdLastJusho")
    public IZenkokuJushoInputDiv getCcdLastJusho() {
        return ccdLastJusho;
    }

    /*
     * getccdLastBanchi
     * @return ccdLastBanchi
     */
    @JsonProperty("ccdLastBanchi")
    public IBanchiInputDiv getCcdLastBanchi() {
        return ccdLastBanchi;
    }

    /*
     * getccdLastKatagaki
     * @return ccdLastKatagaki
     */
    @JsonProperty("ccdLastKatagaki")
    public IKatagakiInputDiv getCcdLastKatagaki() {
        return ccdLastKatagaki;
    }

    /*
     * gettxtTenshutsuYMD
     * @return txtTenshutsuYMD
     */
    @JsonProperty("txtTenshutsuYMD")
    public TextBoxDate getTxtTenshutsuYMD() {
        return txtTenshutsuYMD;
    }

    /*
     * settxtTenshutsuYMD
     * @param txtTenshutsuYMD txtTenshutsuYMD
     */
    @JsonProperty("txtTenshutsuYMD")
    public void setTxtTenshutsuYMD(TextBoxDate txtTenshutsuYMD) {
        this.txtTenshutsuYMD = txtTenshutsuYMD;
    }

    /*
     * getradHonsekichiToroku
     * @return radHonsekichiToroku
     */
    @JsonProperty("radHonsekichiToroku")
    public RadioButton getRadHonsekichiToroku() {
        return radHonsekichiToroku;
    }

    /*
     * setradHonsekichiToroku
     * @param radHonsekichiToroku radHonsekichiToroku
     */
    @JsonProperty("radHonsekichiToroku")
    public void setRadHonsekichiToroku(RadioButton radHonsekichiToroku) {
        this.radHonsekichiToroku = radHonsekichiToroku;
    }

    // </editor-fold>
}
